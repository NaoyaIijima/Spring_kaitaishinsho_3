package com.example.demo.trySpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        // 画面から指定したキー"sample"の値を受け取ることが出来る
        model.addAttribute("sample", str);
        return "helloResponse";
    }
    
}
