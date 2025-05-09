package com.vn.tim_viec_lam.controller.facebook;

import com.google.gson.JsonObject;
import com.vn.tim_viec_lam.dao.model.JobApplication;
import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.service.CandidateService;
import com.vn.tim_viec_lam.service.JobApplicationService;
import com.vn.tim_viec_lam.service.ResumesService;
import com.vn.tim_viec_lam.service.UserService;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.StringTokenizer;

@WebServlet(name = "callback-facebook",value = "/callback-facebook")
public class CallbackFacebook extends HttpServlet {
    private Dotenv dotenv = Dotenv.load();
    private final String FB_APP_ID = dotenv.get("FB_APP_ID");
    private final String FB_CLIENT_SECRET = dotenv.get("FB_CLIENT_SECRET");
    private final String FB_REDIRECT_URI = dotenv.get("FB_REDIRECT_URI");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        if(code == null || code.isEmpty()) {
            resp.sendRedirect("home");
        }

        String tokenUrl = "https://graph.facebook.com/v18.0/oauth/access_token" +
                "?client_id=" + FB_APP_ID
                + "&redirect_uri=" + FB_REDIRECT_URI
                + "&client_secret=" + FB_CLIENT_SECRET
                + "&code=" + code;



        String accessToken = getJsonValue(tokenUrl, "access_token");
        if (accessToken != null && !accessToken.isEmpty()) {
            String userInfoUrl = "https://graph.facebook.com/me?fields=id,name,email,picture&access_token=" + accessToken;

            String userId = getJsonValue(userInfoUrl, "id");
            String userName = getJsonValue(userInfoUrl, "name");
            String picture = (getJsonValue(userInfoUrl, "picture"));
            String url = getPictureUrl(picture);
            String userEmail = getJsonValue(userInfoUrl, "email");
            if (userEmail == null) {
                System.out.println("Không thể lấy email từ Facebook!");
                resp.sendRedirect("login?error=email_not_found");
                return;
            }

            UserService userService = new UserService();
            User user = userService.getUser(userEmail);
            HttpSession session = req.getSession(true);
            if(user != null) {
                boolean locked = userService.getLockStatus(user.getUserID());
                if(locked){
                    resp.sendRedirect("login.jsp?error=locked");
                    return;
                }
                int role = user.getRoleNum();
                CandidateService cs = new CandidateService();
                int candidateId = cs.getCandidateIdByUserId(user.getUserID());
                List<JobApplication> jobApplicationList = new JobApplicationService().getAll(candidateId);
                List<Resumes> resumesList = new ResumesService().getResumes(candidateId);

                session.setAttribute("user", user);
                session.setAttribute("email",user.getEmail());
                session.setAttribute("jobAppliedCart", jobApplicationList);
                session.setAttribute("jac", resumesList);
                session.setAttribute("role", role);
                session.setAttribute("status",user.getStatus());
                session.setAttribute("userID",user.getUserID());
                session.setAttribute("candidateId", candidateId);
                resp.sendRedirect("home");
                return;
            }
            if(user == null) {
                session.setAttribute("email", userEmail);
                session.setAttribute("fName", userName);
                session.setAttribute("auth_provider", "facebook");
                session.setAttribute("providerId", userId);
                req.setAttribute("picture", url);
                req.getRequestDispatcher("CandidateLoginGG.jsp").forward(req, resp);
            }
        }else{
//            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private String getJsonValue(String url, String key) throws IOException {
        URL requestUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jsonObject = new JSONObject(response.toString());
        return jsonObject.optString(key, null);
    }
    private String getPictureUrl(String userInfoJson) {
        StringTokenizer stringTokenizer = new StringTokenizer(userInfoJson,"\",");
        String url = "";
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken().trim();

            if (token.startsWith("https://")) {
                url  = token;
            }
        }
        return url;
    }
}
