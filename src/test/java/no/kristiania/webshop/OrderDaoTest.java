package no.kristiania.webshop;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OrderDaoTest {

    private DataSource dataSource;

    @Test
    void shouldFindSavedOrders() throws SQLException {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:mem:myTestDatabase");

        dataSource.getConnection().createStatement().executeUpdate("create table orders (order varchar(100))");

        Order order = new Order();
        order.setName("Test");
        OrderDao dao = new OrderDao(dataSource);
        dao.insert(order);
        assertThat(dao.listAll()).contains(order);
    }


}
