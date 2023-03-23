package com.Amazon.Amazon.Entity;


import com.Amazon.Amazon.Enum.Catagory;
import com.Amazon.Amazon.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private int productPrice;
    private int productQuantity;

    @Enumerated(value=EnumType.STRING)
    private Catagory catagory;


    @Enumerated(value=EnumType.STRING)
    private ProductStatus productStatus;

    @ManyToOne
    @JoinColumn
    Seller seller;
    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    Item item;

}
