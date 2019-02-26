package prices;

import java.sql.*;

public class Prices {

    private final Double price;

    public Prices(String name) {

        Double p=0.0;

        try {
            // query template
            String query = "SELECT PRICE from PRODUCTS WHERE NAME=?";
            
            // connect and execute
            Connection conn = DriverManager.getConnection("jdbc:postgresql://db:5432/mydb", "moby", "12345678");
            PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            // extract price
            if (rs.isBeforeFirst()) {    
                rs.first();
                p=Double.parseDouble(rs.getString(1));
            } 

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.price = p;
    }

    public Double getPrice() {
        return price;
    }
}