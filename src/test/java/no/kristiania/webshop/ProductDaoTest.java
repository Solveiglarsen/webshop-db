package no.kristiania.webshop;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductDaoTest {
    private DataSource dataSource;

    @Test
    void shouldListInsertedProducts() throws SQLException {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:mem:myTestDatabase");

        dataSource.getConnection().createStatement().executeUpdate("create table products (name varchar(1000))");

        ProductDao dao = new ProductDao(this.dataSource);
        String product = sampleProduct();
        dao.insert(product, "insert into products (name) values (?)");
        assertThat(dao.listAll())
                .contains(product);
    }

}
