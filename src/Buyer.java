import java.util.Scanner;

import com.fasterxml.jackson.annotation.*;

public class Buyer {
    private long id;
    private String fio;
    private String companyName;

    @JsonCreator
    Buyer(@JsonProperty("id") long id,
    @JsonProperty("fio") String fio,
    @JsonProperty("companyName") String companyName) {
        this.id = id;
        this.fio = fio;
        this.companyName = companyName;
    }

    Buyer(int id){
        System.out.println("Частное лицо (да или нет)");
        Scanner scanner = new Scanner(System.in, System.getProperty("console.encoding", "cp866"));

        setId(id);
        String st = scanner.nextLine();
        if (st.equals("да")) {
            System.out.println("Введите ФИО");
            setFio(scanner.nextLine());
        } else {
            System.out.println("Введите наименование компании");
            setCompanyName(scanner.nextLine());
        }
    }

    public long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getFio() {
        return fio;
    }

    public void setId(long id) {
        if (id < 0) {
            System.out.println("id Error");
        } else {
            this.id = id;
        }
    }

    public void setCompanyName(String companyName) {
        if (companyName.isEmpty()) {
            System.out.println("companyName");
        } else {
            this.companyName = companyName;
        }
    }
    
    public void setFio(String fio) {
        if (fio.isEmpty()) {
            System.out.println("fio");
        } else {
            this.fio = fio;
        }
    }
}
