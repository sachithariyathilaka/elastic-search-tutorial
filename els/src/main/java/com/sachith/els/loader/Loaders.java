package com.sachith.els.loader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sachith.els.model.Data;
import com.sachith.els.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    DataRepository dataRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){
        operations.putMapping(Data.class);
        List<Data> dataList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        try {
            Iterator<Data> dataIterator = mapper.reader(Data.class).readValues(new File("/Users/sachithariyathilaka/Documents/Fidenz/Java/els/src/main/resources/json/sample.json"));
            while (dataIterator.hasNext()) {
                dataList.add(dataIterator.next());
                dataList.get(dataList.size()-1).setNameNode(dataList.get(dataList.size()-1).getNode().getName());
                dataList.get(dataList.size()-1).setAggName(dataList.get(dataList.size()-1).getAgg().getName());
                dataList.get(dataList.size()-1).setTopic(dataList.get(dataList.size()-1).getEvent().getTopic());
                dataList.get(dataList.size()-1).setDevice(dataList.get(dataList.size()-1).getEvent().getParams().getDeviceId());
                dataList.get(dataList.size()-1).setCategory(dataList.get(dataList.size()-1).getEvent().getParams().getCategory());
                dataList.get(dataList.size()-1).setId(dataList.size());
            }
            dataRepository.saveAll(dataList);
            System.out.println("Data Saved!");
        } catch (IOException e){
            System.out.println("Unable to save Data: " + e.getMessage());
        }
    }
}
