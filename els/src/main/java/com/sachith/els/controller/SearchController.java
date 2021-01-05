package com.sachith.els.controller;

import com.sachith.els.builder.SearchQueryBuilder;
import com.sachith.els.dto.RequestDto;
import com.sachith.els.dto.ResponseDto;
import com.sachith.els.model.Data;
import com.sachith.els.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SearchController {

    @Autowired
    private SearchQueryBuilder searchQueryBuilder;

    @Autowired
    private DataRepository dataRepository;

    @RequestMapping(value = "/api/search", method = RequestMethod.GET)
    public ResponseDto getAll(@RequestBody RequestDto requestDto){
        List<Data> list =searchQueryBuilder.getAll(requestDto);
        if(list.size()<25){
            return new ResponseDto(1,1,list, "Successfully Data Fetched");
        } else if(list.size()>0){
            List<Data> newList = new ArrayList<>();
            for(int i = (requestDto.getPageNumber() - 1)*25; i< requestDto.getPageNumber()*25; i++){
                newList.add(list.get(i));
            }
            return new ResponseDto(requestDto.getPageNumber(),1,newList, "Successfully Data Fetched");
        } else{
            return new ResponseDto(0,1,null, "No Data Available");
        }
    }

    @RequestMapping(value = "/api/search/findById/{id}", method = RequestMethod.GET)
    public ResponseDto getDataById(@PathVariable final Long id){
        Optional<Data> data = dataRepository.findById(id);
        List<Data> newList = new ArrayList<>();
        newList.add(data.get());
        return new ResponseDto(1,1,newList, "Successfully Data Fetched");
    }

}
