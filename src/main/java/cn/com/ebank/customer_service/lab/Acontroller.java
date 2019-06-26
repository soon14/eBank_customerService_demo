package cn.com.ebank.customer_service.lab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Acontroller {

    @GetMapping("/myException")
    public String getMessage() {
        throw new MyException("this is a 异常啊");
    }

    @GetMapping("NoHandlerException")
    public String getNoHandlerMsg() {
        throw new NoHandlerException("这个异常没有处理器");
    }


}
