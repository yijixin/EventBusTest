package vp.com.eventbustest.bean;

/**
 * Created by Administrator on 2017/3/30.
 */

public class ItemList {
    private int id;
    private String name;

    public ItemList(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ItemList() {

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
}
