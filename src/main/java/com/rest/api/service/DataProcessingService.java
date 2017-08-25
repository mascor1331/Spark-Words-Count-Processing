package com.rest.api.service;

import com.rest.api.model.response.WordCountResponse;

/**
 * Created by chou3ibi on 19/08/17.
 */
public interface DataProcessingService {

    WordCountResponse getWordsCount(String input);
    WordCountResponse textClassificationP(String input);
}
