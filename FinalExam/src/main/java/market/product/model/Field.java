package market.product.model;

import javax.naming.Name;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "field")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(targetEntity = Product.class)
    private List<Product> products;

    public Field() {
    }

    public Field(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getEmployees() {
        return products;
    }

    public void setEmployees(List<Product> employees) {
        this.products = employees;
    }
}
