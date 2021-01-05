package com.sachith.els.repository;

import com.sachith.els.model.Data;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface DataRepository extends ElasticsearchRepository<Data, Long>  {
    Optional<Data> findById(Long id);
}
