package ru.akirakozov.sd.refactoring.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author akirakozov
 */
public class GetProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Utils.genericQuery("SELECT * FROM PRODUCT", "", true, false, response);
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
