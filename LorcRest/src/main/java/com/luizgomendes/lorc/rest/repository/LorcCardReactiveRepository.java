package com.luizgomendes.lorc.rest.repository;

import com.luizgomendes.lorc.rest.model.AggregationTuple;
import com.luizgomendes.lorc.rest.model.Card;
import com.luizgomendes.lorc.rest.model.CardProjection;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.util.List;

public interface LorcCardReactiveRepository extends ReactiveMongoRepository<Card, String> {

    Flux<Card> findByColorIn(List<String> colors);
    @Aggregation(pipeline = {
                                "{$group:{ _id: '$color', count: { $sum: 1 }}}",
                                "{ $project : { _id : 0, label : $_id, value : $count}}"
                            })
    Flux<AggregationTuple> countByColor();
    @Aggregation(pipeline = {
            "{$lookup: { from: 'sets',localField: 'setCode', foreignField: 'id', as: 'setInfo' }}",
            "{ $project : { id: \"$id\",fullName: \"$fullName\", color: \"$color\", type: \"$type\", rarity: \"$rarity\",thumbnail: \"$images.thumbnail\", set: {\"$arrayElemAt\":[\"$setInfo.name\", 0]} }}}}"
    })
    Flux<CardProjection> getAllCardsProjection();


}
