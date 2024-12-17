package com.vn.tim_viec_lam.controller.cart;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.savingcart.SavingCart;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addJob",value = "/addJob")
public class AddJobCart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        if(request.getParameter("jid")!=null){
            int id = Integer.parseInt(request.getParameter("jid"));
            JobService js = new JobService();

            Job job = js.getJobById(id);
            HttpSession session = request.getSession();

            SavingCart cart = (SavingCart) session.getAttribute("addJobCart");

            if(cart == null){
                cart = new SavingCart();
            }
            cart.addJobCart(job);
            session.setAttribute("addJobCart",cart);
        }
        response.sendRedirect(request.getContextPath()+"/home");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    }
}
