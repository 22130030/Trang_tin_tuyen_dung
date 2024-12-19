package com.vn.tim_viec_lam.controller.cart;

import com.vn.tim_viec_lam.dao.model.savingcart.SavingCart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "updateJob",value = "/updateJob")
public class UpdateJobCart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();
        SavingCart sc = (SavingCart) session.getAttribute("cart");

        if(sc != null){
            int size = sc.getSize();
            String jsonResponse = "{\"items\": " + size + "}";
            response.getWriter().write(jsonResponse);
        }


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
