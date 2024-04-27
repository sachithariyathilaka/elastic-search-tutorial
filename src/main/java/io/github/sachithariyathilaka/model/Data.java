package io.github.sachithariyathilaka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * Data data model.
 *
 * @author 	Sachith Ariyathilaka
 * @version 1.0.0
 * @since 	2024/04/27
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(indexName = "data")
public class Data {

    private int id;

    @Field
    @JsonProperty("Timestamp")
    private String timestamp;

    @Field
    @JsonProperty("MessageType")
    private String messageType;

    @Field
    @JsonProperty("Node")
    private Node node;

    @Field
    private String nameNode;

    @Field
    private String aggName;

    @Field
    private String topic;

    @Field
    private String device;

    @Field
    private String category;

    @Field
    @JsonProperty("Agg")
    private Agg agg;

    @Field
    @JsonProperty("Event")
    private Event event;
}
