package com.example.spring_pra;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    // DB 입출력 함수 잔뜩 들어잇음
    private final ItemRepository itemrepository;
    // 서비스 항목을 실행할때 마다 객체를 생성하면 리소스 낭비겠지? 그래서
    // 미리 서비스 기능의 객체를 생성하여 오브젝트 생성을 최소화
    private final ItemService itemservice;


    @GetMapping("/list")
    // HTML에 서버데이터 넣으려면 파라미터에 Model model 넣고
    String list(Model model){
        // arraylist 자료형으로 가져온다
        // 출력중인 테이블 이름을 넣어야 함
        List<Item> testdata = itemrepository.findAll();

        // model.addAttribute(데이터 이름, 데이터);
        // 템플렛 엔진 Tymeleaf
        model.addAttribute("items", testdata);
        System.out.println(testdata.toString());

        return "list.html";
    }

    @GetMapping("/write")
    String write(){
        return "write.html";
    }

    @PostMapping("/add")
    // 여러가지 변수르를 한 번에 넣고 싶을 때 Map 자료형 사용
    String addPost(@RequestParam String title, Integer price){
        itemservice.saveItem(title, price);

        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model){

            // 왜 Optional 써야함? => JPA findById 만든 사람이 쓰라는데요
            Optional<Item> result = itemservice.getItem(id);

            if(result.isPresent()){
                model.addAttribute("detaildata", result.get());
            } else{
                return "redirect:/list";
            }
            return "detail.html";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model)
    {
        Optional<Item> result = itemrepository.findById(id);

        if(result.isPresent()){
            model.addAttribute("data", result.get());
            return "edit.html";
        } else {
            return "redirect:/list";
        }
    }

    @PostMapping("/postedit/{id}")
    String postedit(@PathVariable Long id, String title, Integer price){

        // title 항목이 null 이거나 price 항목이 음수일 때 아무동작 안함
        if(title.isEmpty() || price < 0){

        }else{
            // title, price 항목 둘 다 정상일 때 실행
            itemservice.editpost(id, title, price);
        }
        return "redirect:/list";
    }


}
