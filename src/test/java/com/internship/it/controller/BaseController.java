package com.internship.it.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internship.bookstore.api.exchange.Response;


public class BaseController {
    public static <V> String createExpectedBody(V v) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(Response.build(v));
    }
}
