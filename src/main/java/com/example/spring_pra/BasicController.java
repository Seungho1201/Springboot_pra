package com.example.spring_pra;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // class에 붙이면 Spring이 알아서 챙겨줌
public class BasicController {
    // 여기서 서버 제작 가능
    @GetMapping("/")    // 이건 URL
    String hello(){             // html파일을 보내려면 @ResponseBody 쓰면 안됨 얘는 그냥 문자 전송
        return "index.html";    // 기본 경로가 static 폴더기 떄문에 파일 이름만 쓰면 알아서 잡힘
    }



    @GetMapping("/mypage")
    @ResponseBody
    String about(){
        return "Mypage";
    }

}
