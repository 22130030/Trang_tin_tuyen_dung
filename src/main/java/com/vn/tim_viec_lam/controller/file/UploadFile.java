package com.vn.tim_viec_lam.controller.file;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.cart.FileCart;
import com.vn.tim_viec_lam.dao.model.cart.JobApplicationCart;
import com.vn.tim_viec_lam.dao.model.cart.JobAppliedCart;
import com.vn.tim_viec_lam.service.FileService;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.util.Date;

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

        Part filePart = request.getPart("file");
        String path = filePart.getSubmittedFileName();
        String fileName = filePart.getSubmittedFileName();
        String type = filePart.getContentType();
        long size = filePart.getSize();

        HttpSession session = request.getSession();

        JobApplicationCart jac = (JobApplicationCart)session.getAttribute("jac");
        int id = 0;
        if(jac != null){
            id = jac.getSize();

        }
        if(jac == null){
            jac = new JobApplicationCart();
        }
        FileCart fc = new FileCart(++id,fileName,path,type,size,new Date());
        jac.addFileCart(fc);
        session.setAttribute("jac",jac);
    }


}



