package com.rest.api.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by chou3ibi on 19/08/17.
 */

@NoArgsConstructor
public class Count {


    @Getter
    @Setter
    private String word;

    @Getter
    @Setter
    private long count;


    public Count(String word, long count) {
        this.word = word;
        this.count = count;
    }
}
