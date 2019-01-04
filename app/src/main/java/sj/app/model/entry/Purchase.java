package sj.app.model.entry;

import org.litepal.crud.DataSupport;

public class Purchase extends DataSupport {
    String pur_num;
    String date;
    String user;
    String name;
    int quity;
    int price;
    int amount;

    public String getPur_num() {
        return pur_num;
    }

    public void setPur_num(String pur_num) {
        this.pur_num = pur_num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuity() {
        return quity;
    }

    public void setQuity(int quity) {
        this.quity = quity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
