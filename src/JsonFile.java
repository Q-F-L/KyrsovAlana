import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonFile implements InterfaceJsonFile {
    public ArrayList<Buyer> readBuyer() throws JsonMappingException, JsonProcessingException {
        String json = "";
        try (FileReader fileReader = new FileReader("src/BD/Buyer.json");
        BufferedReader br = new BufferedReader(fileReader)) {
            while (br.ready()) { // пока есть непрочитанные данные
                json += br.readLine();//считываем строку
            }
        } catch (IOException e) {
            System.out.println("Error - "+e);
        }
        
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Buyer> personList = objectMapper.readValue(json, new TypeReference<ArrayList<Buyer>>(){});
        return personList;
    }

    public ArrayList<Product> readProduct() throws JsonMappingException, JsonProcessingException {
        String json = "";
        try (FileReader fileReader = new FileReader("src/BD/Product.json");
        BufferedReader br = new BufferedReader(fileReader)) {
            while (br.ready()) { // пока есть непрочитанные данные
                json += br.readLine();//считываем строку
            }
        } catch (IOException e) {
            System.out.println("Error - "+e);
        }
        
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Product> personList = objectMapper.readValue(json, new TypeReference<ArrayList<Product>>(){});
        return personList;
    }

    public ArrayList<ProductInStock> readProductInStock() throws JsonMappingException, JsonProcessingException {
        String json = "";
        try (FileReader fileReader = new FileReader("src/BD/ProductInStock.json");
        BufferedReader br = new BufferedReader(fileReader)) {
            while (br.ready()) { // пока есть непрочитанные данные
                json += br.readLine();//считываем строку
            }
        } catch (IOException e) {
            System.out.println("Error - "+e);
        }
        
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<ProductInStock> personList = objectMapper.readValue(json, new TypeReference<ArrayList<ProductInStock>>(){});
        return personList;
    }

    public ArrayList<Sales> readSales() throws JsonMappingException, JsonProcessingException {
        String json = "";
        try (FileReader fileReader = new FileReader("src/BD/Sales.json");
        BufferedReader br = new BufferedReader(fileReader)) {
            while (br.ready()) { // пока есть непрочитанные данные
                json += br.readLine();//считываем строку
            }
        } catch (IOException e) {
            System.out.println("Error - "+e);
        }
        
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Sales> personList = objectMapper.readValue(json, new TypeReference<ArrayList<Sales>>(){});
        return personList;
    }

    public ArrayList<Supply> readSupply() throws JsonMappingException, JsonProcessingException {
        String json = "";
        try (FileReader fileReader = new FileReader("src/BD/Supply.json");
        BufferedReader br = new BufferedReader(fileReader)) {
            while (br.ready()) { // пока есть непрочитанные данные
                json += br.readLine();//считываем строку
            }
        } catch (IOException e) {
            System.out.println("Error - "+e);
        }
        
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Supply> personList = objectMapper.readValue(json, new TypeReference<ArrayList<Supply>>(){});
        return personList;
    }



    public void writeBuyer(ArrayList<Buyer> object) throws JsonProcessingException{
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String result = ow.writeValueAsString(object);

        try (PrintWriter out = new PrintWriter(new FileWriter("src/BD/Buyer.json"))) {
            out.write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeProduct(ArrayList<Product> object) throws JsonProcessingException{
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String result = ow.writeValueAsString(object);

        try (PrintWriter out = new PrintWriter(new FileWriter("src/BD/Product.json"))) {
            out.write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeProductInStock(ArrayList<ProductInStock> object) throws JsonProcessingException{
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String result = ow.writeValueAsString(object);

        try (PrintWriter out = new PrintWriter(new FileWriter("src/BD/ProductInStock.json"))) {
            out.write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeSales(ArrayList<Sales> object) throws JsonProcessingException{
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String result = ow.writeValueAsString(object);

        try (PrintWriter out = new PrintWriter(new FileWriter("src/BD/Sales.json"))) {
            out.write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeSupply(ArrayList<Supply> object) throws JsonProcessingException{
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String result = ow.writeValueAsString(object);

        try (PrintWriter out = new PrintWriter(new FileWriter("src/BD/Supply.json"))) {
            out.write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
