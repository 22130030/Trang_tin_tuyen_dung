package com.vn.tim_viec_lam.controller.file;

import com.vn.tim_viec_lam.service.FileService;
import jakarta.servlet.ServletException;
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
public class UploadFile extends HttpServlet {
    private static final String UPLOAD_DIR = "upload_file";
    private static final int THRESHOLD_SIZE = 1024*1024*3;
    private static final int MAX_FILE_SIZE = 1024*1024*30;
    private static final int MAX_REQUEST_SIZE = 1024*1024*40;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(THRESHOLD_SIZE);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);

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
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
public class UploadFile {
}
