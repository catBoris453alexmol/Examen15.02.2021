package ru.sapteh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private int cost;

    @Column
    private String description;

    @Column
    private  String mainImagePath;

    @Column
    private int active;

    @OneToMany(mappedBy = "product")
    private Set<ProductSale> productSales;

    @ManyToOne
    private Manufacture manufacture;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", mainImagePath='" + mainImagePath + '\'' +
                ", active=" + active +
                '}';
    }
}
