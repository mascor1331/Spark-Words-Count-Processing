package com.rest.api.model.response;

import com.rest.api.enums.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by chou3ibi on 19/08/17.
 */

@NoArgsConstructor
public class ErrorResponse {

    @Getter
    @Setter
    private int code ;

    @Getter
    @Setter
    private String message ;

    public ErrorResponse(ErrorCode errorCode){
        this.code = errorCode.getCodeVal();
        this.message = errorCode.name();
    }
}
