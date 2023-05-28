import java.util.Scanner;

import com.fasterxml.jackson.annotation.*;

public class Product {
    long id;
    String name;
    double price;
    String category;

    @JsonCreator
    Product(@JsonProperty("id") long id,
    @JsonProperty("name") String name,
    @JsonProperty("price") double price,
    @JsonProperty("category") String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    Product(int id){
        Scanner scanner = new Scanner(System.in);

        setId(id);
        System.out.println("Введите название продукта: ");
        setName(scanner.nextLine());
        System.out.println("Введите цену продукта: ");
        setPrice(scanner.nextInt());
        System.out.println("Введите категорию продукта: ");
        setCategory(scanner.nextLine());

        scanner.close();
    }

    public long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(long id) {
        if (id < 0) {
            System.out.println("id");
        } else {
            this.id = id;
        }
    }

    public void setCategory(String category) {
        if (category.isEmpty()) {
            System.out.println("category");
            Scanner scanner = new Scanner(System.in);
            setCategory(category);
            scanner.close();
        } else {
            this.category = category;
        }
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("name");
            Scanner scanner = new Scanner(System.in);
            setName(name);
            scanner.close();
        } else {
            this.name = name;
        }
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("price");
            Scanner scanner = new Scanner(System.in);
            setPrice(scanner.nextInt());
            scanner.close();
        } else {
            this.price = price;
        }
    }
}
