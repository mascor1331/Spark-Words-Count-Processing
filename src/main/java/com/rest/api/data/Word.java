package com.rest.api.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by chou3ibi on 19/08/17.
 */


@NoArgsConstructor
public class Word {


    @Getter
    @Setter
    private  String word ;


    public Word(String word) {
        this.word = word;
    }
}
