package com.rest.api.enums;

/**
 * Created by chou3ibi on 19/08/17.
 */
public enum ErrorCode {
    NoContent(204), Unauthorized(401);

    private int numVal;

    ErrorCode(int numVal) {
        this.numVal = numVal;
    }

    public int getCodeVal() {
        return numVal;
    }
}
