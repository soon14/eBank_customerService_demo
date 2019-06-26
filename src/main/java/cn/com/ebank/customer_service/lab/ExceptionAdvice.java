package cn.com.ebank.customer_service.lab;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler()
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handle(MyException e) {

        return e.getMessage();
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public String handleRuntime(RuntimeException e) {
        return e.getMessage();
    }


    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public String handleRuntime(NoHandlerException e) {
        return "重新定义：" + e.getMessage();
    }

}

