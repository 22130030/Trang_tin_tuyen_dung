package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.ResumesDao;
import com.vn.tim_viec_lam.dao.model.Resumes;
import jakarta.servlet.http.Part;

import java.util.List;

public class FileService {
    private ResumesDao resumesDao;
    public FileService() {
        resumesDao = new ResumesDao();
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
    public void addFile(Part Part, String fileName) {

    }
    public List<Resumes> getFiles(int jobID){
        return resumesDao.getResumesByJobID(jobID);
    }
}
