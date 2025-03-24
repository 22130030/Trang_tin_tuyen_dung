package com.vn.tim_viec_lam.controller.historycart;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.cart.HistoryCart;
import com.vn.tim_viec_lam.dao.model.cart.SavingCart;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "removeSaveCart",value = "/account/remove-saveCart")
public class RemoveSaveCart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        HistoryCart sc = (HistoryCart) session.getAttribute("hsCart");
        if(sc != null){
            session.removeAttribute("hsCart");
        }
        response.sendRedirect(request.getContextPath() + "/account/home_account.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    }
}
