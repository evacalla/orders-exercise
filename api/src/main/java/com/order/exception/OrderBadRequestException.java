package com.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by evacalla on 8/12/2019
 **/

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OrderBadRequestException extends RuntimeException {

    private String fieldParam;
    private Object fieldValue;

    public OrderBadRequestException(String fieldParam, Object fieldValue) {
        super(String.format("Bad request by %s : '%s'",  fieldParam, fieldValue));
        this.fieldParam = fieldParam;
        this.fieldValue = fieldValue;
    }

    public String getFieldParam() {
        return fieldParam;
    }

    public void setFieldParam(String fieldParam) {
        this.fieldParam = fieldParam;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }
}
