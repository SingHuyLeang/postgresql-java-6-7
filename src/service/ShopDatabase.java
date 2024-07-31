package service;

import data.Product;
import dto.ProductDto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDatabase extends DataBaseService{
    
    public boolean addProduct(Product product) {
        
        System.out.println("o id = " + product.getIdOwner());
        
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
    
    public List<ProductDto> getProducts(int idOwner){
        List<ProductDto> products = new ArrayList<>();
        String query = "SELECT "
                + "p.id,"
                + "p.name,"
                + "p.qty,"
                + "p.price,"
                + "p.discount,"
                + "p.total," 
                + "p.image,"
                + "u.email "
                + "FROM tbl_product p "
                + "JOIN tbl_user u ON u.id = p.owner "
                + "WHERE u.id = ?";
        
        try {
            ps = connection().prepareStatement(query);
            ps.setInt(1, idOwner);
            rs = ps.executeQuery();
            while (rs.next()) {                
                products.add(new ProductDto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (SQLException e) {
            System.out.println("SQLException on get products by " + e.getMessage());
        }
        return products;
    }
    
}
