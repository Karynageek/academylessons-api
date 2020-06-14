package org.academy.api.pojo.karyna.chelpan;

public class Shop {
    private long id;
    private String shopName;
    private String address;

    public Shop(long id, String shopName, String address) {
        this.id = id;
        this.shopName = shopName;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
