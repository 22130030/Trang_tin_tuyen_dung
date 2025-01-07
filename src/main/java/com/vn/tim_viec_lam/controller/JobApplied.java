package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.cart.JobAppliedCart;
import com.vn.tim_viec_lam.service.FileService;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "jobApplied",value = "/job-applied")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 3, // 3MB
        maxFileSize = 1024 * 1024 * 30,
        maxRequestSize = 1024 * 1024 * 40
)
public class JobApplied extends HttpServlet {
    private static final String UPLOAD_DIR = "upload_file";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String uploadPart = getServletContext().getRealPath("");

        FileService fs = new FileService();
        try{
            for(Part part : request.getParts()){
                String fileName = fs.extractFile(part);
                if(!fileName.isEmpty() && fileName != null){
                    String filePath = uploadDir.getAbsolutePath() + File.separator + fileName;

                    part.write(filePath);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
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
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        long size = filePart.getSize();

        response.getWriter().write(String.format(
                "{\"fileName\": \"%s\", \"fileSize\": %.2f}",
                fileName, size / 1024.0
        ));


    }
}
