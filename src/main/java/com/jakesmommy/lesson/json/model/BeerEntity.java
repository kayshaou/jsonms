package com.jakesmommy.lesson.json.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
public class BeerEntity {
    @Id
    @NotNull
    private UUID id;
    @NotBlank
    @Size(min = 3, max=100)
    private String beerName;
    @NotBlank
    @Size(min = 3, max=100)
    private String beerStyle;
    @Positive
    @NotNull
    private Long upc;
    @Positive
    @NotNull
    private Integer quantity;
}
