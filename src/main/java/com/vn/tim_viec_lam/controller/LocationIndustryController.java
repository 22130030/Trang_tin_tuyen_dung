package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Category;
import com.vn.tim_viec_lam.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name="locationIndustry",value = "/location-industry")
public class LocationIndustryController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        CategoryService cs = new CategoryService();
        Map<String, List<Category>> categories = cs.getCategories();

        request.setAttribute("categories", categories);
        request.getRequestDispatcher("location_industry.jsp").forward(request, response);

    }
}
