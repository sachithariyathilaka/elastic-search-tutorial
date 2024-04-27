package io.github.sachithariyathilaka.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Params data model.
 *
 * @author 	Sachith Ariyathilaka
 * @version 1.0.0
 * @since 	2024/04/27
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Params {

    @JsonProperty("NvrUuid")
    private String nvrUuid;

    @JsonProperty("DeviceId")
    private String deviceId;

    @JsonProperty("DeviceName")
    private String deviceName;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Category")
    private String category;

    @JsonProperty("LinkMode")
    private String linkMode;

    @JsonProperty("LinkedEventType")
    private String linkedEventType;

    @JsonProperty("Message")
    private String message;
}
