package com.vn.tim_viec_lam.controller.file;

import com.vn.tim_viec_lam.service.FileService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
@WebServlet(name = "uploadFile",value = "/upload-file")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 3, // 3MB
        maxFileSize = 1024 * 1024 * 30,
        maxRequestSize = 1024 * 1024 * 40
)
public class UploadFile extends HttpServlet {
    private static final String UPLOAD_DIR = "upload_file";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String uploadPart = getServletContext().getRealPath("");

//        FileService fs = new FileService();
//        try{
//            for(Part part : request.getParts()){
//                String fileName = fs.extractFile(part);
//                if(!fileName.isEmpty() && fileName != null){
//                    String filePath = uploadDir.getAbsolutePath() + File.separator + fileName;
//
//                    part.write(filePath);
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        long size = filePart.getSize();

        response.getWriter().write(String.format(
                "{\"fileName\": \"%s\", \"fileSize\": %.2f}",
                fileName,size/1024.0
                ));


    }
public class UploadFile {
}
