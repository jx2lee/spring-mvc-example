package com.jx2lee.springmvcexample.basic.response;

import com.jx2lee.springmvcexample.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
// @ResponseBody // class 레벨에 annotation 적용 시 모든 메서드에 ResponseBody annotation 적용
// @RestController // @Controller + @ResponseBody
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("jx2lee");
        helloData.setAge(31);

        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    // API 만들때 주로 쓰는 방식
    @ResponseStatus(HttpStatus.OK) // 상태코드를 반환할 수 있는 annotation
    @ResponseBody // return 값을 바로 HTTP 메세지 body 로 전달
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("jx2lee");
        helloData.setAge(31);

        return helloData;
    }
}
