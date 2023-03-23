package com.Amazon.Amazon.Entity;


import com.Amazon.Amazon.Enum.CardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    @Column(unique = true)
    private String cardNo;
    private int cvv;

    @Enumerated(value=EnumType.STRING)
     private CardType cardType;

    @ManyToOne
    @JoinColumn
    Customer customer;


}
