package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Company;
import com.vn.tim_viec_lam.service.CompanyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="filterCompany",value = "/filter-company")
public class FilterCompany extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        request.setCharacterEncoding("utf-8");
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        // Chuyển chuỗi JSON thành đối tượng Java
        String json = sb.toString();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray locationsArray = jsonObject.getJSONArray("locations");

        // Lấy danh sách các location đã chọn
        List<String> selectedLocations = new ArrayList<>();
        for (int i = 0; i < locationsArray.length(); i++) {
            selectedLocations.add(locationsArray.getString(i));
        }
        CompanyService cs = new CompanyService();
        List<Company> companies = new ArrayList<>();
        if (selectedLocations != null && selectedLocations.size() > 0) {
            // Lọc công ty theo các địa điểm đã chọn
            companies = cs.filterByCity(selectedLocations);
        } else {
            // Trả lại tất cả công ty nếu không có địa điểm nào được chọn
            companies = cs.getAllCompany();
        }
        // Tạo JSON response chứa kết quả công ty
        JSONArray result = new JSONArray();
        for (Company company : companies) {
            JSONObject companyObj = new JSONObject();
            companyObj.put("companyName", company.getCompanyName());
            companyObj.put("city", company.getCity());
            companyObj.put("img", company.getImg());
            result.put(companyObj);
        }
        System.out.println(result.toString());

        // Gửi JSON về phía client
        PrintWriter out = response.getWriter();
        out.print(result.toString());
        out.flush();
    }
}
