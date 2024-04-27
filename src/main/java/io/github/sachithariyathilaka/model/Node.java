package io.github.sachithariyathilaka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * Node data model.
 *
 * @author 	Sachith Ariyathilaka
 * @version 1.0.0
 * @since 	2024/04/27
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Node {

    @Field
    @JsonProperty("Name")
    private String nodeName;

    @Field
    @JsonProperty("IPAddress")
    private String ipAddress;

    @Field
    @JsonProperty("Plugin")
    private String plugIn;

    @Override
    public String toString(){
        return "Name: "+ nodeName;
    }
}
