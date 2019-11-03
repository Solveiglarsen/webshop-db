package no.kristiania.webshop;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends AbstractDao<Order> {
    private List<Order> orders = new ArrayList<>();

    public OrderDao(DataSource dataSource) {
        super (dataSource);
    }

    public void insert(Order order) {
        orders.add(order);
    }

    @Override
    protected void insertObject(String product, PreparedStatement stmt) throws SQLException {

    }

    public List<Order> listAll() {
        return orders;
    }

    @Override
    protected String readObject(ResultSet rs) throws SQLException {
        return null;
    }

}
