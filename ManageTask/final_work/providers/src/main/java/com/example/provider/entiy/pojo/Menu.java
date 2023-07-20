package com.example.provider.entiy.pojo;

public class Menu {
    private String menuName;
    private String url;

    public Menu(String menuName,String url) {
        this.menuName = menuName;
        this.url=url;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
