import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;

public class App {
    public static void main(String[] args) throws Exception {
        JsonFile jsonFile = new JsonFile();
        ArrayList<Buyer> buyerList = jsonFile.readBuyer();
        ArrayList<Product> productList = jsonFile.readProduct();
        // ArrayList<ProductInStock> productInStockList = jsonFile.readProductInStock();
        // ArrayList<Sales> SalesList = jsonFile.readSales();
        // ArrayList<Supply> SupplyList = jsonFile.readSupply();
        Scanner scanner = new Scanner(System.in);
        

        do {
            int key = scanner.nextInt();
            switch (key) {
                //get all, add, edit, delete
                case 1: //output all buyer and action
                    allBuyers(buyerList);
                    break;
                case 2: //output all product and action
                    allProducts(productList);
                    break;
                case 3: //output all product in stok and action
                    break;
                case 4: //output all sales and action
                    break;
                case 5: //output all supply and action
                    break;
                case 6: //имеется ли в наличии указанный товар и в каком количестве
                    break;
                case 7: //кому, на какую сумму и какой товар был отпущен в заданный день
                    break;
                case 8: //какова суммарная стоимость товаров на складе в отчетный день;
                    break;
                case 9: //наиболее и наименее востребованные товары по суммарной стоимости продаж
                    break;
                default: 
                    break;
            }
        } while (true);
    }

    static void allBuyers(ArrayList<Buyer> buyers){
        Scanner scanner = new Scanner(System.in, System.getProperty("console.encoding", "cp866"));
        int indexArray;
        int key;
        do {
            for (Buyer buyer : buyers) {
                System.out.println("Код: "+buyer.getId());
                System.out.println("ФИО: "+buyer.getFio());
                System.out.println("Название компании: "+buyer.getCompanyName());
            }
            System.out.println("Нажмите Enter для выхода\n1.Добавить нового покупателя\n2.Изменить ФИО\n3.Изменить название компании\n4.Удалить элемент");
            System.out.println("Выберите действие: ");
            key = scanner.nextInt();
            switch (key) {
                case 1: // add new element
                    buyers.add(new Buyer(buyers.size()));
                    break;
                case 2: // edit fio
                    System.out.println("Выберите покупателя: ");
                    indexArray = scanner.nextInt();
                    System.out.println("Введите новое ФИО: ");
                    String st = scanner.nextLine();
                    buyers.get(indexArray).setFio(st);
                    break;
                case 3: // edit companyName
                    System.out.println("Выберите покупателя: ");
                    indexArray = scanner.nextInt();
                    System.out.println("Введите новое название компании: ");
                    buyers.get(indexArray).setCompanyName(scanner.nextLine());
                    break;
                case 4: // delete element
                    System.out.println("Выберите покупателя: ");
                    indexArray = scanner.nextInt();
                    buyers.remove(indexArray);
                    break;
                default: // save and exit
                    JsonFile jsonFile = new JsonFile();
                    try {
                        jsonFile.writeBuyer(buyers);
                    } catch (JsonProcessingException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    return;
            }
        } while (true);
    }

    static void allProducts(ArrayList<Product> product){
        Scanner scanner = new Scanner(System.in, System.getProperty("console.encoding", "cp866"));
        int indexArray;
        do {
            System.out.println("Выберите действие: ");
            int key = scanner.nextInt();
            switch (key) {
                case 1: // add new element
                    product.add(new Product(product.size()));
                    break;
                case 2: // edit fio
                    System.out.println("Выберите продукт: ");
                    indexArray = scanner.nextInt();
                    System.out.println("Введите новое название: ");
                    product.get(indexArray).setName(scanner.nextLine());
                    break;
                case 3: // edit companyName
                    System.out.println("Выберите продукт: ");
                    indexArray = scanner.nextInt();
                    System.out.println("Введите новую цену: ");
                    product.get(indexArray).setPrice(scanner.nextInt());
                    break;
                case 4: // edit companyName
                    System.out.println("Выберите продукт: ");
                    indexArray = scanner.nextInt();
                    System.out.println("Введите новую категорию: ");
                    product.get(indexArray).setCategory(scanner.nextLine());
                    break;
                case 5: // delete element
                    System.out.println("Выберите продукт: ");
                    indexArray = scanner.nextInt();
                    product.remove(indexArray);
                    break;
                default: // save and exit
                    JsonFile jsonFile = new JsonFile();
                    try {
                        jsonFile.writeProduct(product);
                    } catch (JsonProcessingException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    return;
            }
        } while (true);
    }
}
