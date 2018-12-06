package com.matmazur.springjpa.model;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @Column(name = "id_item")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String producer;
    private Double price;

    public Item(String name, String producer, Double price) {
        this.name = name;
        this.producer = producer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
