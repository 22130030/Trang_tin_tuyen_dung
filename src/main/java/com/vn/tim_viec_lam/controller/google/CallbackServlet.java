    package com.vn.tim_viec_lam.controller.google;

    import com.google.api.client.auth.oauth2.TokenResponse;
    import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
    import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
    import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
    import com.google.api.client.http.javanet.NetHttpTransport;
    import com.google.api.client.json.JsonFactory;
    import com.google.api.client.json.jackson2.JacksonFactory;
    import com.vn.tim_viec_lam.dao.model.JobApplication;
    import com.vn.tim_viec_lam.dao.model.Resumes;
    import com.vn.tim_viec_lam.dao.model.User;
    import com.vn.tim_viec_lam.service.*;
    import io.github.cdimascio.dotenv.Dotenv;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import jakarta.servlet.http.HttpSession;

    import java.io.IOException;
    import java.security.GeneralSecurityException;
    import java.util.Collections;
    import java.util.List;

    @WebServlet(name="callback",value = "/callback")
    public class CallbackServlet extends HttpServlet {

        private Dotenv dotenv = Dotenv.load();
        private String clientId = dotenv.get("GOOGLE_CLIENT_ID");
        private String clientSecret = dotenv.get("GOOGLE_CLIENT_SECRET");
        private  final String REDIRECT_URI = dotenv.get("REDIRECT_URI");

        private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
        private static final NetHttpTransport HTTP_TRANSPORT = new NetHttpTransport();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String code = req.getParameter("code");

            if (code == null) {
                resp.sendRedirect("login?error=google");
                return;
            }

            GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                    HTTP_TRANSPORT, JSON_FACTORY,clientId, clientSecret,
                    Collections.singletonList("https://www.googleapis.com/auth/userinfo.profile"))
                    .build();

            TokenResponse tokenResponse = flow.newTokenRequest(code).setRedirectUri(REDIRECT_URI).execute();
            String idTokenString = (String) tokenResponse.get("id_token");


            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(HTTP_TRANSPORT, JSON_FACTORY)
                    .setAudience(Collections.singletonList(clientId))
                    .build();


//            GoogleIdToken idToken = verifier.verify(tokenResponse.getIdToken());
            try {
                GoogleIdToken idToken = verifier.verify(idTokenString);
                if (idToken != null) {
                    GoogleIdToken.Payload payload = idToken.getPayload();
                    String email = payload.getEmail();

                    UserService userService = new UserService();
                    LogService logService = new LogService();
                    String ip = req.getRemoteAddr();
                    User user = userService.getUser(email);

                    HttpSession session = req.getSession(true);
                    if(user == null) {
                        String name = (String) payload.get("name");
                        String picture = (String) payload.get("picture");

                        logService.addLog(null, "candidate", "login", "google", "ERROR", ip, "Login Google Failed:");

                        session.setAttribute("email", email);
                        session.setAttribute("fName", name);
                        session.setAttribute("auth_provider", "google");
                        req.setAttribute("picture", picture);
                        session.setAttribute("auth_provider", "google");
                        req.getRequestDispatcher("CandidateLoginGG.jsp").forward(req, resp);
                    }else{
                        boolean locked = userService.getLockStatus(user.getUserID());
                        if(locked){
                            logService.addLog(user, "candidate", "login", "google", "ERROR", ip, "Login Google Failed");
                            resp.sendRedirect("login.jsp?error=locked");
                            return;
                        }
                        logService.addLog(user, "candidate", "login", "google", "INFO", ip, "Login Google Success");
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
                        session.setAttribute("loginType", "google");
                        resp.sendRedirect("home");
                    }






                } else {
                    resp.sendRedirect("login?error=google");
                }
            } catch (GeneralSecurityException e) {
                throw new ServletException("Failed to verify token", e);
            }

        }
    }