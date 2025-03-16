package com.vn.tim_viec_lam.controller.file;

import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.service.FileService;
import com.vn.tim_viec_lam.service.ResumesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "uploadFile",value = "/account/upload-file")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 3, // 3MB
        maxFileSize = 1024 * 1024 * 30,
        maxRequestSize = 1024 * 1024 * 40
)
public class UploadFile extends HttpServlet {
    private static final String UPLOAD_DIR = "upload_file";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ResumesService rs = new ResumesService();

        List<Resumes> resumesList = rs.getResumes();
        session.setAttribute("jac", resumesList);
        request.getRequestDispatcher("job_application.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        String uploadDirPath = getServletContext().getRealPath("")  + UPLOAD_DIR;

        File uploadDir = new File(uploadDirPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        FileService fs = new FileService();
        HttpSession session = request.getSession();
        ResumesService rs = new ResumesService();
        String filePath = "";
        int resumeId =0;
        try{
            for(Part part : request.getParts()){
                String fileName = fs.extractFile(part);
                if(!fileName.isEmpty() && fileName != null){
                    String fName = part.getSubmittedFileName();
                    filePath = uploadDirPath + File.separator + fileName;
                    String type = "";
                    long size = part.getSize();
                    int i = fileName.lastIndexOf('.');
                    if (i > 0) {
                        type = fileName.substring(i + 1).toLowerCase();
                    }
                    part.write(filePath);
                    resumeId = rs.addResume(fName, filePath, type);
                    System.out.println("resumeId = " + resumeId);

                }
                    List<Resumes> updatedList = rs.getResumes();
                    session.setAttribute("jac", updatedList);
            }
                    response.setContentType("application/json");
                    response.getWriter().write("{\"resumesId\": " + resumeId + "}");
                    response.getWriter().flush();
                    response.getWriter().close();
        }catch (Exception e){
            System.out.println(1);
            e.printStackTrace();
        }



    }


}



