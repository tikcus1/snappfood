package Admin;

import javafx.util.Pair;

import java.io.Serializable;
import java.util.ArrayList;

public class Restaurant implements Serializable {
    //fields
    private String name;
    private String address;
    private String work_time;
    private String pic;
    private Pair<String, Integer> type;
    boolean vis;
    ArrayList<Pair<FoodClass, Integer>> foods = new ArrayList<>();

    //constructors
    public Restaurant(String name, String address, String work_time, String pic, Pair<String, Integer> type, ArrayList<Pair<FoodClass, Integer>> foods) {
        this.name = name;
        this.address = address;
        this.work_time = work_time;
        this.pic = pic;
        this.type = type;
        this.foods = foods;
        vis = true;
    }

    //methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Pair<String, Integer> getType() {
        return type;
    }

    public void setType(Pair<String, Integer> type) {
        this.type = type;
    }

    public boolean isVis() {
        return vis;
    }

    public void setVis(boolean vis) {
        this.vis = vis;
    }

    public ArrayList<Pair<FoodClass, Integer>> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Pair<FoodClass, Integer>> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", work_time='" + work_time + '\'' +
                ", pic='" + pic + '\'' +
                ", type=" + type +
                ", vis=" + vis +
                ", foods=" + foods +
                '}';
    }
}
