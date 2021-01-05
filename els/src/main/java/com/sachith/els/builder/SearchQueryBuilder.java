package com.sachith.els.builder;

import com.sachith.els.dto.RequestDto;
import com.sachith.els.model.Data;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchQueryBuilder {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;

    public List<Data> getAll(RequestDto requestDto) {
        BoolQueryBuilder query = QueryBuilders.boolQuery().should(QueryBuilders.queryStringQuery(requestDto.getFreeText())).should(QueryBuilders.queryStringQuery("*" + requestDto.getFreeText() + "*"));

        if(requestDto.getNodeName() != null){
            BoolQueryBuilder nodeFilter =  QueryBuilders.boolQuery();
            nodeFilter.must(QueryBuilders.queryStringQuery(requestDto.getNodeName()).field("nameNode"));
            query = query.filter(nodeFilter);
        }

        if(requestDto.getAggName() != null){
            BoolQueryBuilder aggFilter =  QueryBuilders.boolQuery();
            aggFilter.must(QueryBuilders.queryStringQuery(requestDto.getAggName()).field("aggName"));
            query = query.filter(aggFilter);
        }

        if(requestDto.getTopic() != null){
            BoolQueryBuilder topicFilter =  QueryBuilders.boolQuery();
            topicFilter.must(QueryBuilders.queryStringQuery(requestDto.getTopic()).field("topic"));
            query = query.filter(topicFilter);
        }

        if(requestDto.getDevice() != null){
            BoolQueryBuilder deviceFilter =  QueryBuilders.boolQuery();
            deviceFilter.must(QueryBuilders.queryStringQuery(requestDto.getDevice()).field("device"));
            query = query.filter(deviceFilter);
        }

        if(requestDto.getCategory() != null){
            BoolQueryBuilder categoryFilter =  QueryBuilders.boolQuery();
            categoryFilter.must(QueryBuilders.queryStringQuery(requestDto.getCategory()).field("category"));
            query = query.filter(categoryFilter);
        }

        if(requestDto.getFromDate() != null && requestDto.getToDate() != null){
            BoolQueryBuilder dateFilter =  QueryBuilders.boolQuery();
            dateFilter.must(QueryBuilders.rangeQuery("timestamp").gte(requestDto.getFromDate()).lte(requestDto.getToDate()));
            query = query.filter(dateFilter);
        }

        NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(query).build();
        return elasticsearchTemplate.queryForList(build,Data.class, elasticsearchTemplate.getIndexCoordinatesFor(Data.class));
    }
}
