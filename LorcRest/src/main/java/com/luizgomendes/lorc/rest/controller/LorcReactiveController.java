package com.luizgomendes.lorc.rest.controller;

import com.luizgomendes.lorc.rest.model.AggregationTuple;
import com.luizgomendes.lorc.rest.model.Card;
import com.luizgomendes.lorc.rest.model.CardProjection;
import com.luizgomendes.lorc.rest.service.LorcReactiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RequestMapping("/lorc/r")
@RestController
public class LorcReactiveController {

    private final LorcReactiveService lorcReactiveService;

    @Autowired
    public LorcReactiveController(LorcReactiveService lorcReactiveService) {
        this.lorcReactiveService = lorcReactiveService;
    }

    @GetMapping("/list")
    public Flux<Card> getAllCards(@RequestBody(required = false) List<String> colors) {

        if(colors == null || colors.isEmpty()) {
            return lorcReactiveService.getAllCards();
        }

        return lorcReactiveService.getByColors(colors);
    }

    @GetMapping("/proj")
    public Flux<CardProjection> getAllCards() {

        return lorcReactiveService.getAllCardsProjection();
    }

    @GetMapping("/colorPie")
    public Flux<AggregationTuple> getColorCount() {
        return lorcReactiveService.countByColorsQuery();
    }
}
