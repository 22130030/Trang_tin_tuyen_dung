package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.cart.JobAppliedCart;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "jobApplied",value = "/job-applied")
public class JobApplied extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("jid") != null){
            int id = Integer.parseInt(request.getParameter("jid"));
            JobService js = new JobService();

            Job job = js.getJobById(id);

            HttpSession session = request.getSession();

            JobAppliedCart cart = (JobAppliedCart) session.getAttribute("jobAppliedCart");
            if(cart == null){
                cart = new JobAppliedCart();
            }
            cart.addJobCart(job);
            session.setAttribute("jobAppliedCart",cart);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
