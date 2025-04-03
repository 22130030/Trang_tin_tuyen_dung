package com.vn.tim_viec_lam.controller.file;

import com.vn.tim_viec_lam.service.JobApplicationService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

@WebServlet(name="downloadFile",value="/employer/download-file")
public class DownloadFile extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {
        String encodedPath = request.getParameter("path");
        String filePath = "hello";
        if(encodedPath != null && !encodedPath.isEmpty()){
            filePath = URLDecoder.decode(encodedPath, "UTF-8");
        }


        if(filePath == null || filePath.isEmpty()){
            response.getWriter().write("File not found");

        }

        if(request.getParameter("job_application") != null){
            int id = Integer.parseInt(request.getParameter("job_application"));
            JobApplicationService jobApplicationService = new JobApplicationService();
            jobApplicationService.updateStatus("Đã xem",id);

        }

        String fullPath = getServletContext().getRealPath("")  + "upload_file" + File.separator +"Dich_DBMS_Concurrency.docx";
        File file = new File(filePath);
        if (file.exists()) {
            response.setContentType(getServletContext().getMimeType(file.getName()));
            response.setContentLengthLong(file.length());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
            try (FileInputStream inputStream = new FileInputStream(file);
                 OutputStream outputStream = response.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        } else {
            response.getWriter().println("File không tồn tại!");
        }
    }
}
