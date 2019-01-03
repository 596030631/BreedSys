package sj.app.model.entry;
public class Page1_0_add_demo1 {
    int id;
    String name;
    double num;
    double price;
    double amount;
    String date;

    public Page1_0_add_demo1(int id,String name,double num, double price, double amount, String date){
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.date = date;
        this.num = num;
    }
    public double getNum() {
        return num;
    }
    public void setNum(double num) {
        this.num = num;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
