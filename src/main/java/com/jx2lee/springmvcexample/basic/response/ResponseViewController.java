package com.jx2lee.springmvcexample.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView ResponseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String ResponseViewV2(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello";
    }

    /**
    * void 로 생략하는 아래 V3버젼은 추천하진 않음
    * 해당 메서드를 보고 명확히 구분이 어려움
    **/
    @RequestMapping("/response/hello")
    public void ResponseViewV3(Model model) {
        model.addAttribute("data", "hello!");
    }
}
