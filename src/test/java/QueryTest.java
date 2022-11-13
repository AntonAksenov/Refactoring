import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryTest implements BaseTest {

    @RepeatedTest(10)
    void testSum() throws IOException, SQLException {
        int sum = 0;
        for (int i = 0; i < rnd.nextInt(5); i++) {
            int price = rnd.nextInt(5) + 1;
            sum += price;
            Database.add("" + i, "" + price);
        }
        String response = Utils.sendQueryRequest("sum").trim();
        assertEquals("<html><body>\r\nSummary price: \r\n" + sum + "\r\n</body></html>", response);
    }

    @RepeatedTest(10)
    void testMax() throws IOException, SQLException {
        int maxProduct = -1;
        int maxPrice = 0;
        for (int i = 0; i < rnd.nextInt(5); i++) {
            int price = rnd.nextInt(5) + 1;
            if (maxPrice < price) {
                maxProduct = i;
                maxPrice = price;
            }
            Database.add("" + i, "" + price);
        }
        String response = Utils.sendQueryRequest("max").trim();
        if (maxProduct == -1) {
            assertEquals("<html><body>\r\n<h1>Product with max price: </h1>\r\n</body></html>", response);
        } else {
            assertEquals("<html><body>\r\n<h1>Product with max price: </h1>\r\n" + maxProduct + "\t" + maxPrice + "</br>\r\n</body></html>", response);
        }
    }

    @RepeatedTest(10)
    void testMin() throws IOException, SQLException {
        int minProduct = -1;
        int minPrice = 7;
        for (int i = 0; i < rnd.nextInt(5); i++) {
            int price = rnd.nextInt(5) + 1;
            if (minPrice > price) {
                minProduct = i;
                minPrice = price;
            }
            Database.add("" + i, "" + price);
        }
        String response = Utils.sendQueryRequest("min").trim();
        if (minProduct == -1) {
            assertEquals("<html><body>\r\n<h1>Product with min price: </h1>\r\n</body></html>", response);
        } else {
            assertEquals("<html><body>\r\n<h1>Product with min price: </h1>\r\n" + minProduct + "\t" + minPrice + "</br>\r\n</body></html>", response);
        }
    }

    @RepeatedTest(10)
    void testCount() throws IOException, SQLException {
        int count = 0;
        for (int i = 0; i < rnd.nextInt(5); i++) {
            int price = rnd.nextInt(5) + 1;
            count++;
            Database.add("" + i, "" + price);
        }
        String response = Utils.sendQueryRequest("count").trim();
        assertEquals("<html><body>\r\nNumber of products: \r\n" +count + "\r\n</body></html>", response);
    }
}
