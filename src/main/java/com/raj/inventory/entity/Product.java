package com.raj.inventory.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product cannot be empty")
    private String name;
    
    @NotBlank(message = "Description cannot be empty")
    private String description;
    
    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be greater than zero")
    private Double price;
    
    @NotNull(message = "Quantity cannot be null")
    @Min(value = 0, message ="Quantity cannot be negative")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}