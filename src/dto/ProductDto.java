package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// dao -> data access object
// dto -> data tranfer object

@AllArgsConstructor
@Getter
public class ProductDto {
    private int id;
    private String name;
    private int qty;
    private double price;
    private int discount;
    private double total;
    private String image;
    private String owner;
}
