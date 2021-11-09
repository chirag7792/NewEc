package com.example.ec.newec.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
@Data
@Builder
public class ErrorResponse {
    private String errCode;
    private String errDesc;
    private Instant dateTime;
}
