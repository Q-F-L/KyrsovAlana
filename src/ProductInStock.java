import java.util.Scanner;

import com.fasterxml.jackson.annotation.*;

public class ProductInStock{
    long id; // уникальный код
    String product; // название продукта
    int amount; // количество продукта
    String shelfLive; // срок годности продукта

    @JsonCreator
    ProductInStock(@JsonProperty("id") long id,
    @JsonProperty("product") String product,
    @JsonProperty("amount") int amount,
    @JsonProperty("shelfLive") String shelfLive) {
        this.id = id;
        this.product = product;
        this.amount = amount;
        this.shelfLive = shelfLive;
    }

    ProductInStock(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите продукт");
        setProduct(scanner.nextLine());
        System.out.println("Введите количество");
        setAmount(scanner.nextInt());
        System.out.println("Введите продукт");
        setShelfLive(scanner.nextLine());

        scanner.close();
    }

    public long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public String getShelfLive() {
        return shelfLive;
    }


    public void setId(long id) {
        if (id < 0) {
            System.out.println("id Error");
        } else {
            this.id = id;
        }
    }

    public void setProduct(String product) {
        if (product.isEmpty()) {
            System.out.println("product");
        } else {
            this.product = product;
        }
    }

    public void setAmount(int amount) {
        if (amount < 0) {
            System.out.println("amount");
        } else {
            this.amount = amount;
        }
    }

    public void setShelfLive(String shelfLive) {
        if (shelfLive.isEmpty()) {
            System.out.println("shelfLive");
        } else {
            this.shelfLive = shelfLive;
        }
    }
}