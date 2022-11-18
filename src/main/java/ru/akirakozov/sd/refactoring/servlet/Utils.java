package ru.akirakozov.sd.refactoring.servlet;

import ru.akirakozov.sd.refactoring.formater.HtmlFormater;
import ru.akirakozov.sd.refactoring.Product;

import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Utils {
    static void genericQuery(String query, String header, boolean isReturning, boolean isFunction, HttpServletResponse response) {
        try {
            try (Connection c = DriverManager.getConnection("jdbc:sqlite:test.db")) {
                Statement stmt = c.createStatement();
                if (isReturning) {
                    ResultSet rs = stmt.executeQuery(query);
                    HtmlFormater htmlFormater = new HtmlFormater();

                    htmlFormater.addHeader(header);

                    if (isFunction) {
                        htmlFormater.addFunctionResult(rs.getInt(1));
                    } else {

                        List<Product> products = new LinkedList<>();
                        while (rs.next()) {
                            products.add(new Product(rs.getString("name"), rs.getInt("price")));
                        }
                        htmlFormater.addProductsResult(products);
                    }
                    response.getWriter().print(htmlFormater.getPage());
                    rs.close();
                }
                stmt.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
