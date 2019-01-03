package sj.app.model.entry;

import org.litepal.crud.DataSupport;

public class Province extends DataSupport {

    /**
     * id : 1
     * name : 北京
     */

    private int id;
    private String provinceName;
    private int provinceCode;


    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
