package com.lockerfoot.app.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "shoes")
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String size; // Mungkin lebih baik jika ini adalah tipe data yang lebih spesifik jika ada variasi ukuran (misal, UK, US, EU)
    private BigDecimal price;
    private Integer stock;
    private String description;
    private String imageUrl; // URL gambar sepatu

    // Konstruktor default (dibutuhkan oleh JPA)
    public Shoe() {
    }

    // Konstruktor dengan parameter
    public Shoe(String name, String brand, String size, BigDecimal price, Integer stock, String description, String imageUrl) {
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // Getter dan Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Shoe{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", brand='" + brand + '\'' +
               ", size='" + size + '\'' +
               ", price=" + price +
               ", stock=" + stock +
               ", description='" + description + '\'' +
               ", imageUrl='" + imageUrl + '\'' +
               '}';
    }
}