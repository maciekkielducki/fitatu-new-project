package com.fitatu.pl.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "product")
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description", unique = true)
    private String description;

    @OneToOne
    @JoinColumn(name = "product_info_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProductInfo productInfo;

}
