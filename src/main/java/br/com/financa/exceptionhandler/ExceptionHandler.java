package br.com.financa.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

// adicionar anotação para informar que será tratada as exceções nessa classe
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request){
        ExceptionsObj exceptionsObj = new ExceptionsObj();

        exceptionsObj.setStatus(HttpStatus.BAD_REQUEST.value());
        exceptionsObj.setDateTime(LocalDateTime.now());
        exceptionsObj.setMessage(ex.getMessage());

        return handleExceptionInternal(ex, exceptionsObj, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {

        ExceptionsObj exceptionsObj = new ExceptionsObj();
        ArrayList<ExceptionsObj.FieldException> fieldsException = new ArrayList<ExceptionsObj.FieldException>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()){
            String fieldName = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            fieldsException.add(new ExceptionsObj.FieldException(fieldName, message ));
        }

        exceptionsObj.setStatus(status.value());
        exceptionsObj.setDateTime(LocalDateTime.now());
        exceptionsObj.setMessage("Um ou mais campos estão inválidos");
        exceptionsObj.setFieldsException(fieldsException);

        return super.handleExceptionInternal(ex, exceptionsObj, headers, status, request);
    }
}
