package com.example.demo.trySpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

// ポイント １：@ Controller 
@Controller 
public class HelloController {
    // ポイント ２：@ GetMapping
    @GetMapping("/hello") 
    public String getHello() { // hello. html に 画面 遷移 
        return "hello"; 
    }
    
    @PostMapping("/hello")
    public String postRequest(@RequestParam("text1") String str, Model model){
        model.appAttributre("sample", str);
        return "helloResponse";
    }
    
}
