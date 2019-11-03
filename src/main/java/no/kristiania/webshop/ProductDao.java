package no.kristiania.webshop;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDao extends AbstractDao<String> {

    public ProductDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected void insertObject(String product, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, product);
    }

    @Override
    protected String readObject(ResultSet rs) throws SQLException {
        return rs.getString("name");
    }

}
