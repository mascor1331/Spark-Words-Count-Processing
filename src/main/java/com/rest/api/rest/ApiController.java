package com.rest.api.rest;

import com.rest.api.enums.ErrorCode;
import com.rest.api.ApiConsts;
import com.rest.api.model.response.ErrorResponse;
import com.rest.api.model.response.WordCountResponse;
import com.rest.api.service.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {ApiConsts.API} )
public class ApiController {

    @Autowired
    DataProcessingService dataProcessingService;


        @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
        public ErrorResponse render() {
            return new ErrorResponse(ErrorCode.Unauthorized);
        }

    //-------------------Retrieve words count --------------------------------------------------------

    @RequestMapping(value = {"/wordsCount/{words}"}, method = RequestMethod.GET)
    public WordCountResponse wordsCount(@PathVariable("words") String words) {
        return dataProcessingService.getWordsCount(words);
    }

}
