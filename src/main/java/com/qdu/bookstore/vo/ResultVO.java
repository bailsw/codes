package com.qdu.bookstore.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}
