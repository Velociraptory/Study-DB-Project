package tacobell.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tacobell.web.UserController;

@ControllerAdvice //дает «совет» группе констроллеров по определенным событиям
public class TacoBellExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserController.ThereIsNoSuchUserException.class) //handling exception
    protected ResponseEntity<TacoBellException> handleThereIsNoSuchUserException() {
        return new ResponseEntity<>(new TacoBellException("There is no such user"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class TacoBellException {
        private String message;
    }
}
