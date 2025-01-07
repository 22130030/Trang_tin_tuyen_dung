package com.vn.tim_viec_lam.controller.file;

import com.mysql.cj.Session;
import com.vn.tim_viec_lam.dao.model.cart.JobApplicationCart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name="removeFile",value = "/remove-file")
public class RemoveFile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("fileId") != null) {
            int fileId = Integer.parseInt(request.getParameter("fileId"));
            HttpSession session = request.getSession();

            JobApplicationCart jac = (JobApplicationCart)session.getAttribute("jac");
            if(jac != null) {
                jac.removeFileCart(fileId);
            }
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
