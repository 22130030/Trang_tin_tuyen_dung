package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.AccountLevel;
import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.JobApplication;
import com.vn.tim_viec_lam.dao.model.cart.JobAppliedCart;
import com.vn.tim_viec_lam.service.AccountLevelService;
import com.vn.tim_viec_lam.service.FileService;
import com.vn.tim_viec_lam.service.JobApplicationService;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "jobApplied",value = "/account/job-applied")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 3, // 3MB
        maxFileSize = 1024 * 1024 * 30,
        maxRequestSize = 1024 * 1024 * 40
)
public class JobApplied extends HttpServlet {
    private static final String UPLOAD_DIR = "job_application";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("jid") != null){
            int id = Integer.parseInt(request.getParameter("jid"));
            JobService js = new JobService();
            Job job = js.getJobById(id);
            int companyId = job.getCompanyId();
            HttpSession session = request.getSession();
            JobApplicationService jas = new JobApplicationService();

            String phone = request.getParameter("phone");
            int candidateId = session.getAttribute("candidateId")==null?0:Integer.parseInt(session.getAttribute("candidateId").toString());
            int status = session.getAttribute("status")==null?-2:Integer.parseInt(session.getAttribute("status").toString());

            AccountLevelService accountLevelService = new AccountLevelService();
            AccountLevel accountLevel = accountLevelService.getAccountLevelById(status);

            int applicationLimit = accountLevel.getApplicationLimit();
            int applicationInDay = jas.getJobApplicationInDay(candidateId);
            if (applicationInDay >= applicationLimit) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                String json = String.format(
                        "{\"error\":\"Bạn đã đạt giới hạn nộp đơn trong ngày.\", \"limit\":%d, \"current\":%d}",
                        applicationLimit,
                        applicationInDay
                );
                response.getWriter().write(json);
                return;
            }


                if(request.getPart("fileId") == null){

                    String uploadDirPath = getServletContext().getRealPath("") + UPLOAD_DIR;
                    File uploadDir = new File(uploadDirPath);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdirs();
                    }

                    FileService fs = new FileService();
                    String filePath = "";
                    try{
                        for(Part part : request.getParts()){
                            String fileName = fs.extractFile(part);
                            if(fileName != null && !fileName.isEmpty()){
                                filePath = uploadDirPath + File.separator + fileName;
                                String type = "";
                                long size = part.getSize();
                                int i = fileName.lastIndexOf('.');
                                if (i > 0) {
                                    type = fileName.substring(i + 1).toLowerCase();
                                }
                                part.write(filePath);
                                jas.addJobAppFromComputer(filePath,fileName,type,id,companyId,candidateId,phone);
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(request.getPart("fileId") != null){
                    int fId = Integer.parseInt(request.getParameter("fileId"));
                    jas.addJobApplicationFromAccount(companyId,id,fId,candidateId,phone);
                    }
                List<JobApplication> jobApplicationList = jas.getAll(candidateId);
                session.setAttribute("jobAppliedCart",jobApplicationList);

        }

    }
}
