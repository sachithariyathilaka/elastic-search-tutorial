package io.github.sachithariyathilaka.service;

import io.github.sachithariyathilaka.resource.APIResponse;
import io.github.sachithariyathilaka.resource.Request;

/**
 * Service layer for the elastic search application.
 *
 * @author 	Sachith Ariyathilaka
 * @version 1.0.0
 * @since 	2024/04/27
 */
public interface DataService {
    APIResponse search(int size, Request request);
    APIResponse findById(Long id);
}
