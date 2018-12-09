package com.matmazur.springjpa.model;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Item.getAll", query ="SELECT i FROM Item i "),
        @NamedQuery(name = "Item.deleteAll", query ="DELETE FROM Item i"),
        @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name=:name")

})
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

    public Item() {
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public Double getPrice() {
        return price;
    }


    public static class Builder {

        private String name;
        private String producer;
        private Double price;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withProducer(String producer) {
            this.producer = producer;
            return this;
        }

        public Builder withPrice(Double price) {
            this.price = price;
            return this;
        }

        public Item build() {
            return new Item(name, producer, price);
        }
    }
}
