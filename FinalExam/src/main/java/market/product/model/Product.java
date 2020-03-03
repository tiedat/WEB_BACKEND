package market.product.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;

    private Double price;
    private Double amount;
    private LocalDate initDate;
    private String description;
    private String gender;

    public Product() {
    }

    public Product(String name, Field field, Double price, Double amount, LocalDate initDate, String description, String gender) {
        this.name = name;
        this.field = field;
        this.price = price;
        this.amount = amount;
        this.initDate = initDate;
        this.description = description;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Product[ id =%d, name=%s ]", id , name);
    }
}
