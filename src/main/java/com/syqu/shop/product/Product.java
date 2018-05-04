package com.syqu.shop.product;

import com.syqu.shop.cart.ShoppingCart;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    @NotNull @NotEmpty
    private String name;

    @Column(name = "description",length = 500)
    @NotNull
    @NotEmpty
    private String description;

    @Column(name = "image")
    @URL private String image_url;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private Set<ShoppingCart> carts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<ShoppingCart> getCarts() {
        return carts;
    }

    public void setCarts(Set<ShoppingCart> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + " Name: " + getName() + " Description: " + getDescription() + " Price: " + getPrice();
    }
}
