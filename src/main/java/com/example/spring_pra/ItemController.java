package com.example.spring_pra;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
    @GetMapping("/list")
    // HTML에 서버데이터 넣으려면 파라미터에 Model model 넣고
    String list(Model model){
        // model.addAttribute(데이터 이름, 데이터);
        model.addAttribute("name","SeungHo");
        model.addAttribute("test","SeungHo1");
        return "list.html";
    }
}
