    package com.vn.tim_viec_lam.controller.google;

    import com.google.api.client.auth.oauth2.TokenResponse;
    import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
    import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
    import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
    import com.google.api.client.http.javanet.NetHttpTransport;
    import com.google.api.client.json.JsonFactory;
    import com.google.api.client.json.jackson2.JacksonFactory;
    import com.vn.tim_viec_lam.dao.model.User;
    import com.vn.tim_viec_lam.service.UserService;
    import io.github.cdimascio.dotenv.Dotenv;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;

    import java.io.IOException;
    import java.security.GeneralSecurityException;
    import java.util.Collections;

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
                    String name = (String) payload.get("name");
                    String password = (String) payload.get("password");
                    String phone = (String) payload.get("phone");


                    // Tạo đối tượng User (tùy vào hệ thống bạn có thể cần mapping vào DB)
                    UserService userService = new UserService();
                    User user = userService.getUser(email);

                    if (user == null) {
                        // Nếu chưa có trong DB, có thể tự động đăng ký tài khoản mới
                        user = new User();
                        user.setEmail(email);
                        user.setPassword(password);
                        user.setName(name);
                        user.setPhone_number(phone);


                        user.setRoleNum(1); // Mặc định là user thường

                        userService.addUser(user.getEmail(),user.getPassword(),user.getName(),user.getPhoneNumber()); // Thêm vào DB
                    }

                    // Lưu vào session giống như đăng nhập bình thường
                    req.getSession().setAttribute("user", user);
                    req.getSession().setAttribute("email", email);
                    req.getSession().setAttribute("name", name);
                    req.getSession().setAttribute("role", 1);

                    resp.sendRedirect("home");
                } else {
                    resp.sendRedirect("login?error=google");
                }
            } catch (GeneralSecurityException e) {
                throw new ServletException("Failed to verify token", e);
            }

        }
    }