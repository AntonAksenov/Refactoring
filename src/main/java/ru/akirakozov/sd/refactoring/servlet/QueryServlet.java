package ru.akirakozov.sd.refactoring.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author akirakozov
 */
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String command = request.getParameter("command");

        if ("max".equals(command)) {
            Utils.genericQuery("SELECT * FROM PRODUCT ORDER BY PRICE DESC LIMIT 1",
                    "<h1>Product with max price: </h1>",
                    true, false, response);
        } else if ("min".equals(command)) {
            Utils.genericQuery("SELECT * FROM PRODUCT ORDER BY PRICE LIMIT 1",
                    "<h1>Product with min price: </h1>",
                    true, false, response);
        } else if ("sum".equals(command)) {
            Utils.genericQuery("SELECT SUM(price) FROM PRODUCT",
                    "Summary price: ",
                    true, true, response);
        } else if ("count".equals(command)) {
            Utils.genericQuery("SELECT COUNT(*) FROM PRODUCT",
                    "Number of products: ",
                    true, true, response);
        } else {
            response.getWriter().println("Unknown command: " + command);
        }

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
