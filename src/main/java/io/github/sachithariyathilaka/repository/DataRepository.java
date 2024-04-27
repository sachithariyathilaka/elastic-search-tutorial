package io.github.sachithariyathilaka.repository;

import io.github.sachithariyathilaka.model.Data;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository layer for the elastic search application.
 *
 * @author 	Sachith Ariyathilaka
 * @version 1.0.0
 * @since 	2024/04/27
 */
@Repository
public interface DataRepository extends ElasticsearchRepository<Data, Long> {
}
