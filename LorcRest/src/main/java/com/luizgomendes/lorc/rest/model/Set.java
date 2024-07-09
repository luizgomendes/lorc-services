package com.luizgomendes.lorc.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "sets")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Set {
    private String id;
    private LocalDate prereleaseDate;
    private LocalDate releaseDate;
    private boolean hasAllCards;
    private String type;
    private int number;
    private String name;

}
