package com.vn.tim_viec_lam.controller.facebook;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "login-facebook",value = "/login-facebook")
public class LoginFBController extends HttpServlet {
    Dotenv dotenv = Dotenv.load();
    private final String FB_APP_ID = dotenv.get("FB_APP_ID");
    private final String REDIRECT_URI = dotenv.get("FB_REDIRECT_URI");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Tạo URL đăng nhập Facebook
        String fbLoginUrl = "https://www.facebook.com/v18.0/dialog/oauth?"
                + "client_id=" + FB_APP_ID
                + "&redirect_uri=" + REDIRECT_URI
                + "&scope=email,public_profile";

        response.sendRedirect(fbLoginUrl);
    }
}
