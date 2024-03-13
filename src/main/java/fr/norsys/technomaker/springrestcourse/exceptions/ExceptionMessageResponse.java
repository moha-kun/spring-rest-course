package fr.norsys.technomaker.springrestcourse.exceptions;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@Builder
@Getter
public class ExceptionMessageResponse {

    private Timestamp timestamp;
    private HttpStatus status;
    private String message;

}
