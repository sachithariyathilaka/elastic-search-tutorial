package io.github.sachithariyathilaka.loader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.sachithariyathilaka.model.Data;
import io.github.sachithariyathilaka.repository.DataRepository;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Data load component.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/04/27
 */
@Component
public class Loaders {

    private final ElasticsearchOperations operations;

    private final DataRepository dataRepository;

    public Loaders(ElasticsearchOperations operations, DataRepository dataRepository) {
        this.operations = operations;
        this.dataRepository = dataRepository;
    }

    @PostConstruct
    @Transactional
    public void loadAll() {
        operations.putMapping(Data.class);
        List<Data> dataList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        try {
            Iterator<Data> dataIterator;
            if (new File("src/main/resources/json/sample.json").exists())
                dataIterator = mapper.reader(Data.class).readValues(new File("src/main/resources/json/sample.json"));
            else
                dataIterator = mapper.reader(Data.class).readValues(getClass().getResourceAsStream("json/sample.json"));

            while (dataIterator.hasNext()) {
                dataList.add(dataIterator.next());
                dataList.get(dataList.size() - 1).setNameNode(dataList.get(dataList.size() - 1).getNode().getNodeName());
                dataList.get(dataList.size() - 1).setAggName(dataList.get(dataList.size() - 1).getAgg().getName());
                dataList.get(dataList.size() - 1).setTopic(dataList.get(dataList.size() - 1).getEvent().getTopic());
                dataList.get(dataList.size() - 1).setDevice(dataList.get(dataList.size() - 1).getEvent().getParams().getDeviceId());
                dataList.get(dataList.size() - 1).setCategory(dataList.get(dataList.size() - 1).getEvent().getParams().getCategory());
                dataList.get(dataList.size() - 1).setId(dataList.size());
            }

            dataRepository.saveAll(dataList);
            System.out.println("Data Saved!");
        } catch (IOException e) {
            System.out.println("Unable to save Data: " + e.getMessage());
        }
    }
}
