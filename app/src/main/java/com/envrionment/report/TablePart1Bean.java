package com.envrionment.report;

import java.util.List;

/**
 * Created by mac on 12/11/16.
 */

public class TablePart1Bean {

//    "name":"工业总产值\n(当年价格)",
//            "units":"万元",
//            "code":"1",
//            "id":"output",
//            "type":1,
//            "items":[]

    public static final int SHOW_TYPE_GAP = 0;//空白
    public static final int SHOW_TYPE_NOMRAL = 1;//标准显示
    public static final int SHOW_TYPE_MUL = 2;//二级显示

    private String color;
    private String name;
    private String units;
    private String code;
    private String id;
    private int type;
    private List<TablePart1Bean> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<TablePart1Bean> getItems() {
        return items;
    }

    public void setItems(List<TablePart1Bean> items) {
        this.items = items;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
