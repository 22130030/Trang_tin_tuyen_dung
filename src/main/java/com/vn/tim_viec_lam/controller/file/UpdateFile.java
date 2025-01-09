package com.vn.tim_viec_lam.controller.file;

import com.vn.tim_viec_lam.dao.model.cart.JobApplicationCart;
import com.vn.tim_viec_lam.dao.model.cart.SavingCart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name="updateFile",value = "/account/update-file")
public class UpdateFile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();
        JobApplicationCart jac = (JobApplicationCart) session.getAttribute("jac");
        if(jac != null){
            int size = jac.getSize();
            String jsonResponse = "{\"items\": " + size + "}";
            response.getWriter().write(jsonResponse);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
