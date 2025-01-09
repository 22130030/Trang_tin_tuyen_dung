package com.vn.tim_viec_lam.controller.savingcart;

import com.vn.tim_viec_lam.dao.model.cart.SavingCart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "removeJob",value = "/account/removeJob")
public class RemoveJobCart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        if(request.getParameter("jid") != null){
            int id = Integer.parseInt(request.getParameter("jid"));

            HttpSession session = request.getSession();
            response.getWriter().write("success");
            SavingCart cart = (SavingCart) session.getAttribute("cart");
            if(cart != null){
                cart.removeJobCart(id);
            }
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
