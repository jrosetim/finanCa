package br.com.financa.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionsObj {

    private Integer status;
    private LocalDateTime dateTime;
    private String message;
    private List<FieldException> fieldsException;

    public static class FieldException{
        private String fieldName;
        private String fieldMessage;

        public FieldException(String fieldName, String fieldMessage){
            super();
            this.fieldName = fieldName;
            this.fieldMessage = fieldMessage;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getFieldMessage() {
            return fieldMessage;
        }

        public void setFieldMessage(String fieldMessage) {
            this.fieldMessage = fieldMessage;
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FieldException> getFieldsException() {
        return fieldsException;
    }

    public void setFieldsException(List<FieldException> fieldsException) {
        this.fieldsException = fieldsException;
    }
}
