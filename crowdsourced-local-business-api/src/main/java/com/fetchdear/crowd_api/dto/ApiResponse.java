package com.fetchdear.crowd_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ApiResponse<T> {
    private String message;
    private T data;
    @JsonIgnore
    private HttpStatus httpStatus;

    public ApiResponse(HttpStatus httpStatus, String message, T data) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }
}
