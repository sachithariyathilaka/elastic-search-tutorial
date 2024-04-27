package io.github.sachithariyathilaka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Event data model.
 *
 * @author 	Sachith Ariyathilaka
 * @version 1.0.0
 * @since 	2024/04/27
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Event {

    @JsonProperty("Topic")
    private String topic;

    @JsonProperty("Params")
    private Params params;
}
