package ru.akirakozov.sd.refactoring.formater;

import ru.akirakozov.sd.refactoring.Product;

import java.util.List;

public class HtmlFormater {
    String header;
    private List<Product> productResult;
    private Integer functionResult;


    public String getPage() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>\r\n");
        if (!header.isEmpty()) {
//            sb.append("<h1>");
            sb.append(header);
//            sb.append("</h1>");
            sb.append("\r\n");
        }
        if(functionResult != null) {
            sb.append(functionResult);
            sb.append("\r\n");
        }
        if(productResult != null) {
            productResult.forEach(product -> {
                sb.append(product.getName());
                sb.append("\t");
                sb.append(product.getPrice());
                sb.append("</br>\r\n");
            });
        }
        sb.append("</body></html>\r\n");
        return sb.toString();
    }

    public void addHeader(String header) {
        this.header = header;
    }

    public void addProductsResult(List<Product> result) {
        productResult = result;
    }

    public void addFunctionResult(int result) {
        functionResult = result;
    }
}
