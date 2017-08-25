package com.rest.api.model.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by chou3ibi on 19/08/17.
 */

public abstract class AbstractResponse implements Serializable {

    @Getter
    @Setter
    private boolean success;

    @Getter
    @Setter
    private ErrorResponse errors;

}
