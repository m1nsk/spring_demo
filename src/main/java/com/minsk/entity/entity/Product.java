package com.minsk.entity.entity;

import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product")
public class Product {

    public Product() {
    }

    public Product(String name, String description, BigDecimal price, BigDecimal sale, Boolean hot, Category category, Image image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.sale = sale;
        this.hot = hot;
        this.category = category;
        this.image = image;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "sale")
    private BigDecimal sale;

    @Column(name = "hot")
    private Boolean hot;


    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(mappedBy = "product")
    private Set<ProductShop> productShops;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
            }
    )
    @JoinTable(
            name = "product_image",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private Set<Image> images;

    public void addProductImage(Image image){
        if(image == null)
            return;
        if(images == null)
            images = new HashSet<>();
        images.add(image);
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }

    public Boolean getHot() {
        return hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", sale=" + sale +
                ", hot=" + hot +
                ", category=" + category +
                ", image=" + image +
                '}';
    }
}
