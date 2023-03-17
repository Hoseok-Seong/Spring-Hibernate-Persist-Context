package shop.mtcoding.hiberpc.config.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MyException extends RuntimeException {
    private HttpStatus httpStatus;

    public MyException(String msg) {
        this(msg, HttpStatus.BAD_REQUEST);
    }

    public MyException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }
}