package com.luizgomendes.lorc.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LorcImage {
    private String full;
    private String thumbnail;
    private String foilMask;
}
