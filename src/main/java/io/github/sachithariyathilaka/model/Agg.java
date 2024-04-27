package io.github.sachithariyathilaka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Agg data model.
 *
 * @author 	Sachith Ariyathilaka
 * @version 1.0.0
 * @since 	2024/04/27
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Agg {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("IPAddress")
    private String ipAddress;

    @JsonProperty("Id")
    private String id;
}
