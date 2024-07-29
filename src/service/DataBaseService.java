package service;

import java.sql.*;

public class DataBaseService {
    
    public PreparedStatement ps;
    public ResultSet rs;
    
    public Connection connection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop-6-7", "postgres", "1004");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException : " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return con;
    }
}
