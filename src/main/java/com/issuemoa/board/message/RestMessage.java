package com.issuemoa.board.message;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestMessage {
    private HttpStatus status;
    private Object data;

    public RestMessage(HttpStatus status, Object data) {
        this.status = status;
        this.data = data;
    }
}
