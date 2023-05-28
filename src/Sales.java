import java.util.List;
/*
 * Продажи
 */
public class Sales {
    String date;
    String buyer;
    List<Product> productList;
    double totalCost;

    public String getDate() {
        return date;
    }

    public String getBuyer() {
        return buyer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setDate(String date) {
        if (date.isEmpty()) {
            System.out.println("date");

        } else {
            this.date = date;
        }
    }

    public void setBuyer(String buyer) {
        if (buyer.isEmpty()) {
            System.out.println("buyer");

        } else {
            this.buyer = buyer;
        }
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void setTotalCost(double totalCost) {
        if (totalCost < 0) {
            System.out.println("totalCost");

        } else {
            this.totalCost = totalCost;
        }
    }
}
