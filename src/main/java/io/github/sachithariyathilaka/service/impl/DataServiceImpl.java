package io.github.sachithariyathilaka.service.impl;

import io.github.sachithariyathilaka.repository.DataRepository;
import io.github.sachithariyathilaka.resource.APIResponse;
import io.github.sachithariyathilaka.resource.Request;
import io.github.sachithariyathilaka.model.Data;
import io.github.sachithariyathilaka.service.DataService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Config class for the elastic search.
 *
 * @author 	Sachith Ariyathilaka
 * @version 1.0.0
 * @since 	2024/04/27
 */
@Service
public class DataServiceImpl implements DataService {

    private final ElasticsearchRestTemplate elasticsearchTemplate;
    private final DataRepository dataRepository;

    public DataServiceImpl(ElasticsearchRestTemplate elasticsearchTemplate, DataRepository dataRepository) {
        this.elasticsearchTemplate = elasticsearchTemplate;
        this.dataRepository = dataRepository;
    }


    /**
     * Abstract method for search data.
     *
     * @param   request the request
     *
     * @return  the api response
     */
    @Override
    public APIResponse search(int size, Request request) {
        BoolQueryBuilder query = QueryBuilders.boolQuery().should(QueryBuilders.queryStringQuery(request.getFreeText())).should(QueryBuilders.queryStringQuery("*" + request.getFreeText() + "*"));

        if(request.getNameNode() != null){
            BoolQueryBuilder nodeFilter =  QueryBuilders.boolQuery();
            nodeFilter.must(QueryBuilders.queryStringQuery(request.getNameNode()).field("nameNode"));
            query = query.filter(nodeFilter);
        }

        if(request.getAggName() != null){
            BoolQueryBuilder aggFilter =  QueryBuilders.boolQuery();
            aggFilter.must(QueryBuilders.queryStringQuery(request.getAggName()).field("aggName"));
            query = query.filter(aggFilter);
        }

        if(request.getTopic() != null){
            BoolQueryBuilder topicFilter =  QueryBuilders.boolQuery();
            topicFilter.must(QueryBuilders.queryStringQuery(request.getTopic()).field("topic"));
            query = query.filter(topicFilter);
        }

        if(request.getDevice() != null){
            BoolQueryBuilder deviceFilter =  QueryBuilders.boolQuery();
            deviceFilter.must(QueryBuilders.queryStringQuery(request.getDevice()).field("device"));
            query = query.filter(deviceFilter);
        }

        if(request.getCategory() != null){
            BoolQueryBuilder categoryFilter =  QueryBuilders.boolQuery();
            categoryFilter.must(QueryBuilders.queryStringQuery(request.getCategory()).field("category"));
            query = query.filter(categoryFilter);
        }

        if(request.getFromDate() != null && request.getToDate() != null){
            BoolQueryBuilder dateFilter =  QueryBuilders.boolQuery();
            dateFilter.must(QueryBuilders.rangeQuery("timestamp").gte(request.getFromDate()).lte(request.getToDate()));
            query = query.filter(dateFilter);
        }

        NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(query).build();
        List<Data> dataList = elasticsearchTemplate.queryForList(build, Data.class, elasticsearchTemplate.getIndexCoordinatesFor(Data.class));

        if(dataList.size() < size)
            return new APIResponse(1,200, "Successfully Data Fetched", dataList);
        else if(!dataList.isEmpty()){
            List<Data> newList = new ArrayList<>();
            for(int i = (request.getPageNumber() - 1) * size; i< request.getPageNumber() * size; i++)
                newList.add(dataList.get(i));

            return new APIResponse(request.getPageNumber(),200, "Successfully Data Fetched", newList);
        } else
            return new APIResponse(0,204, "No Data Available", dataList);
    }

    /**
     * Find data by id.
     *
     * @param   id the id
     *
     * @return  the api response
     */
    @Override
    public APIResponse findById(Long id) {
        Optional<Data> data = dataRepository.findById(id);
        return data.map(value -> new APIResponse(1, 200, "Successfully Data Fetched", Collections.singletonList(value))).orElseGet(() -> new APIResponse(1, 204, "No Data Available", null));
    }
}
