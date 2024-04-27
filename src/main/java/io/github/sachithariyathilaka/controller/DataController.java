package io.github.sachithariyathilaka.controller;

import io.github.sachithariyathilaka.repository.DataRepository;
import io.github.sachithariyathilaka.resource.APIResponse;
import io.github.sachithariyathilaka.resource.Request;
import io.github.sachithariyathilaka.service.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller layer of the application.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/04/27
 */
@RequestMapping("/api/data")
@RestController
public class DataController {

    private final DataService dataService;

    private final DataRepository dataRepository;

    public DataController(DataService dataService, DataRepository dataRepository) {
        this.dataService = dataService;
        this.dataRepository = dataRepository;
    }

    /**
     * Search data from request and page size.
     *
     * @param   size the page size
     * @param   request the request
     *
     * @return  the api response
     */
    @GetMapping(value = "/search")
    public ResponseEntity<APIResponse> search(@RequestParam("size") int size, @RequestBody Request request) {
        APIResponse apiResponse = dataService.search(size, request);

        if(apiResponse.getData().isEmpty())
            return new ResponseEntity<>(apiResponse, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    /**
     * Search data from id.
     *
     * @param   id the id
     *
     * @return  the api response
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<APIResponse> findById(@PathVariable Long id){
        APIResponse apiResponse = dataService.findById(id);

        if(apiResponse.getData() == null)
            return new ResponseEntity<>(apiResponse, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
