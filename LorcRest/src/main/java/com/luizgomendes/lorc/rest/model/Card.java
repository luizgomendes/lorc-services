package com.luizgomendes.lorc.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cards")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    private String id;
    private boolean inkwell;
    private String rarity;
    private String type;
    private String fullIdentifier;
    private int number;
    private String setCode;
    private int setNumber;
    private String artist;
    private String baseName;
    private String fullName;
    private String simpleName;
    private String subtitle;
    private int cost;
    private int lore;
    private int strength;
    private int willpower;
    private String color;
    private LorcImage images;
    private String flavorText;
    private List<String> abilities;
    private List<String> keywordAbilities;
    private List<CardEffect> effects;
    private List<String> subtypes;
    private String fullText;
    private String story;

}
