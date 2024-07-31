package data;

import lombok.*;

// Entity
@Getter
@Setter
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private int qty;
    private double price;
    private int discount;
    private double total;
    private String image;
    private int idOwner;

    public Product(String name, int qty, double price, int discount, double total, String image,int idOwner) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.discount = discount;
        this.total = total;
        this.image = image;
        this.idOwner = idOwner;
    }
}
