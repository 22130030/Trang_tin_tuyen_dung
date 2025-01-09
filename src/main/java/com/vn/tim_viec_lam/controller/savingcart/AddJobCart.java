package com.vn.tim_viec_lam.controller.savingcart;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.cart.SavingCart;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "addJob",value = "/account/addJob")
public class AddJobCart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        if(request.getParameter("jid")!=null){
            int id = Integer.parseInt(request.getParameter("jid"));
            JobService js = new JobService();

            Job job = js.getJobById(id);
            HttpSession session = request.getSession();

            SavingCart cart = (SavingCart) session.getAttribute("cart");

            if(cart == null){
                cart = new SavingCart();
            }
            cart.addJobCart(job);
            session.setAttribute("cart",cart);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    }
}
