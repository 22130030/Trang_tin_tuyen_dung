package com.vn.tim_viec_lam.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
@WebServlet(name="searchResume",value="/search-resume")
public class SearchResume extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {

        String title = request.getParameter("titleInput");
        String address = request.getParameter("addressInput");


    }
}
