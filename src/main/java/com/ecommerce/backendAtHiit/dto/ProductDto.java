package com.ecommerce.backendAtHiit.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@ToString
public class ProductDto {
    @NotBlank
    private String name;
    @Size(min =5, max=50)
    private String description;
    private BigDecimal price;
    private String imageUrk;
    @PastOrPresent
    @NotNull
    private Date createdAt;
    @FutureOrPresent
    @NotNull
    private Date updatedAt;
    @NotNull
    private boolean active;
    @Max(value=10)
    @Min(value=5)
    private int uniqueId;

}
