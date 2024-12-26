package com.vn.tim_viec_lam.service;

import jakarta.servlet.http.Part;

public class FileService {
    public FileService fileService;
    public FileService() {
        fileService = new FileService();
    }
    public String extractFile(Part Part){
        String contentDisposition = Part.getHeader("content-disposition");
        for(String content : contentDisposition.split(";")){
            if(content.trim().startsWith("filename")){
                return content.substring(content.indexOf("=")+2,content.length()-1);
            }
        }
        return null;
    }
}
