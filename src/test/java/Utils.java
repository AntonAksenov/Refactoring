import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Utils {
    public static String sendRequest(final String method, final Map<String, Object> paramsMap) throws IOException {
        String params = paramsMap.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("&"));
        URL url = new URL("http://localhost:8081/" + method + "?" + params);
        return new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
    }

    public static String sendAddRequest(String name, String price) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("price", price);
        return sendRequest("add-product", map);
    }

    public static String sendGetRequest() throws IOException {
        Map<String, Object> map = new HashMap<>();
        return sendRequest("get-products", map);
    }

    public static String sendQueryRequest(String command) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("command", command);
        return sendRequest("query", map);
    }
}
