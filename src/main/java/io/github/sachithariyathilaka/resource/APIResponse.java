package io.github.sachithariyathilaka.resource;

import io.github.sachithariyathilaka.model.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Response resource for the application.
 *
 * @author 	Sachith Ariyathilaka
 * @version 1.0.0
 * @since 	2024/04/27
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {
    private int pageNumber;
    private int code;
    private String message;
    private List<Data> data;
}
