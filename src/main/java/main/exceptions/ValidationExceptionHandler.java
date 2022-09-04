package main.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j     // pt Logger - adauga un camp
@RestControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {


//    @ExceptionHandler(MyCustomException.class)
//    public ResponseEntity<Object> handleCustomBusinessException(MyCustomException e) {
//        return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
//    }

    //eroare specifica (nu Bad_Request) pt cazurile de fail  - si arata la client (in postman)
    // loghez eroarea la linia 38
    @Override     // pt a suprascrie mecanismul standard Java de scriere/afisare a exceptiilor
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        log.error("validation error", ex);  // cu aceasta linie loghez eroare in consola
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.toString());
        }
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}



