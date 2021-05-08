package br.com.lbr.beerApi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private int quantity;

    @OneToOne(targetEntity = BeerType.class)
    private BeerType type;

    @ManyToOne
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;
}
