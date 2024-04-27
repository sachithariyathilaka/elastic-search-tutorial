package io.github.sachithariyathilaka.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Request resource for the application.
 *
 * @author 	Sachith Ariyathilaka
 * @version 1.0.0
 * @since 	2024/04/27
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    private String freeText;
    private int pageNumber;
    private String nameNode;
    private String aggName;
    private String topic;
    private String device;
    private String category;
    private String fromDate;
    private String toDate;
}
