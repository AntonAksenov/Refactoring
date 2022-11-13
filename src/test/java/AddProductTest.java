import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProductTest implements BaseTest {

    @Test
    void testAdd() throws IOException {
        String response = Utils.sendAddRequest("1", "1").trim();
        assertEquals("OK", response);
    }
}
