package com.luizgomendes.lorc.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardProjection {
    private String id;
    private String fullName;
    private String color;
    private String rarity;
    private String type;
    private String set;
    private String thumbnail;
}
