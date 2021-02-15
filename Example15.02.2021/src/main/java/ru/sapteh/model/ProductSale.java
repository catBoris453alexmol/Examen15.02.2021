package ru.sapteh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ProductSale")
public class ProductSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String saleDate;

    @Column
    private int quantity;

    @ManyToOne
    private Product product;

    @Override
    public String toString() {
        return "ProductSale{" +
                "id=" + id +
                ", saleDate='" + saleDate + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
