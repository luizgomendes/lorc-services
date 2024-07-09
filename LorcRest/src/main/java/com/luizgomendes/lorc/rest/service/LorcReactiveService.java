package com.luizgomendes.lorc.rest.service;

import com.luizgomendes.lorc.rest.model.AggregationTuple;
import com.luizgomendes.lorc.rest.model.Card;
import com.luizgomendes.lorc.rest.model.CardProjection;
import com.luizgomendes.lorc.rest.repository.LorcCardReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.List;

@Service
public class LorcReactiveService {

    private final LorcCardReactiveRepository lorcCardReactiveRepository;

    @Autowired
    public LorcReactiveService(LorcCardReactiveRepository lorcCardReactiveRepository) {
        this.lorcCardReactiveRepository = lorcCardReactiveRepository;
    }

    public Flux<Card> getAllCards() {
        return lorcCardReactiveRepository.findAll();
    }

    public Flux<CardProjection> getAllCardsProjection() { return lorcCardReactiveRepository.getAllCardsProjection(); }

    public Flux<Card> getByColors(List<String> colors) {
        return lorcCardReactiveRepository.findByColorIn(colors);
    }

    public Flux<Tuple2<String, Long>> countByColors() {
        return lorcCardReactiveRepository.findAll()
                .groupBy(Card::getColor)
                .flatMap(group -> Mono.just(group.key()).zipWith(group.count()));

    }

    public Flux<AggregationTuple> countByColorsQuery() {
        return lorcCardReactiveRepository.countByColor();
    }
}
