package main.exceptions;

import lombok.Value;

import java.util.List;
@Value  // face campurile finale, private,
public class ErrorResponse {

     String message;
     List<String> detailes;
}
