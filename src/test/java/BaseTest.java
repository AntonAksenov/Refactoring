import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.akirakozov.sd.refactoring.servlet.AddProductServlet;
import ru.akirakozov.sd.refactoring.servlet.GetProductsServlet;
import ru.akirakozov.sd.refactoring.servlet.QueryServlet;

import java.sql.SQLException;
import java.util.Random;


public interface BaseTest {
    Random rnd = new Random();

    @BeforeAll
    static void init() {
        try {
            Database.create();

            Server server = new Server(8081);

            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            server.setHandler(context);

            context.addServlet(new ServletHolder(new AddProductServlet()), "/add-product");
            context.addServlet(new ServletHolder(new GetProductsServlet()),"/get-products");
            context.addServlet(new ServletHolder(new QueryServlet()),"/query");

            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    default void clear() {
        try {
            Database.clear();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
