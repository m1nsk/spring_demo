package com.minsk.entity.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shop")
public class Shop {
    public Shop() {
    }

    public Shop(String name, String address, String workTime, String phone, String status) {
        this.name = name;
        this.address = address;
        this.workTime = workTime;
        this.phone = phone;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "work_time")
    private String workTime;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "shop")
    private Set<ProductShop> productShops;

    public Set<ProductShop> getProductShops() {
        return productShops;
    }

    public void setProductShops(Set<ProductShop> productShops) {
        this.productShops = productShops;
    }

    public void addProductShop(ProductShop productShop){
        if(productShop == null)
            return;
        if(productShops == null)
            productShops = new HashSet<>();
        productShops.add(productShop);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", workTime='" + workTime + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", productShops=" + productShops +
                '}';
    }
}
