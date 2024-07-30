package service;

import data.Product;
import java.sql.SQLException;

public class ShopDatabase extends DataBaseService{
    
    public boolean addProduct(Product product) {
        int i = -1;
        String query = "INSERT INTO tbl_product (name,qty,price,discount,total,image,owner) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = connection().prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getQty());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getDiscount());
            ps.setDouble(5, product.getTotal());
            ps.setString(6, product.getImage());
            ps.setInt(7, product.getIdOwner());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException on add product by " + e.getMessage());
        }
        return i > 0;
    }
    
}
