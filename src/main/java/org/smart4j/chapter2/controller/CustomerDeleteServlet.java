package org.smart4j.chapter2.controller;

import org.smart4j.chapter2.service.CustomerService;
import org.smart4j.chapter2.util.CastUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer_delete")
public class CustomerDeleteServlet extends HttpServlet {

    private CustomerService customerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean result = customerService.deleteCustomer(CastUtil.castLong(req.getParameter("id")));
        req.setAttribute("result",result);
        req.getRequestDispatcher("/WEB-INF/view/customer_delete.jsp").forward(req,resp);
    }

}
