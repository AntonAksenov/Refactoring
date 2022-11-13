import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetProductsTest implements BaseTest {
    @Test
    void testGet() throws IOException {
        String response = Utils.sendGetRequest().trim();
        assertEquals("<html><body>\r\n</body></html>", response);
    }

    @Test
    void testAddAndGet() throws SQLException, IOException {
        Database.add("1", "2");
        String response = Utils.sendGetRequest().trim();
        assertEquals("<html><body>\r\n1\t2</br>\r\n</body></html>", response);
    }
}
