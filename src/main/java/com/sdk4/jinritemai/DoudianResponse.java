package com.sdk4.jinritemai;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianResponse<T> {
    private Integer errNo;
    private String message;
    private T data;

    public boolean isSuccess() {
        return errNo != null && errNo == 0;
    }
}
