package ru.akirakozov.sd.refactoring.servlet;

import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Utils {
    static void genericQuery(String query, String header, boolean isReturning, boolean isFunction, HttpServletResponse response) {
        try {
            try (Connection c = DriverManager.getConnection("jdbc:sqlite:test.db")) {
                Statement stmt = c.createStatement();
                if (isReturning) {
                    ResultSet rs = stmt.executeQuery(query);
                    response.getWriter().println("<html><body>");
                    if (!header.isEmpty()) {
                        response.getWriter().println(header);
                    }

                    if (isFunction) {
                        response.getWriter().println(rs.getInt(1));
                    } else {
                        while (rs.next()) {
                            String name = rs.getString("name");
                            int price = rs.getInt("price");
                            response.getWriter().println(name + "\t" + price + "</br>");
                        }
                    }
                    response.getWriter().println("</body></html>");
                    rs.close();
                }
                stmt.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
