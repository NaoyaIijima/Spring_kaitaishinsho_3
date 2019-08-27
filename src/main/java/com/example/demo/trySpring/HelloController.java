package com.example.demo.trySpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

// ポイント １：@ Controller 
@Controller 
public class HelloController {
    
    @Autowired
    private HelloService helloService;
    
    
    
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
    
    @PostMapping("/hello/db")
    public String postDbRequest(@RequestParam("text2")String str, Model model){
        
        // Stringからintに変換
        int id = Integer.parseInt(str);
        
        // 1件検索
        Employee employee = helloService.findOne(id);
        
        // 検索結果をModelに登録
        model.addAttribute("id", employee.getEmployeeId());
        model.addAttribute("name", employee.getEmployeeName());
        model.addAttribute("age", employee.getAge());
        
        // helloResponseDB.htmlに画面遷移
        return "helloResponseDB";
    }
    
}
