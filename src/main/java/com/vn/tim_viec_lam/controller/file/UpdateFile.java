package com.vn.tim_viec_lam.controller.file;

import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.service.ResumesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name="updateFile",value = "/account/update-file")
public class UpdateFile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();
        ResumesService rs = new ResumesService();
        List<Resumes> jac = rs.getResumes();
        if(jac != null){
            int size = jac.size();
            String jsonResponse = "{\"items\": " + size + "}";
            response.getWriter().write(jsonResponse);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
