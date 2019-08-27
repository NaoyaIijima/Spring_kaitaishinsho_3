import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; 
// ポイント １：@ Controller 
@Controller 
public class HelloController {
    // ポイント ２：@ GetMapping
    @GetMapping("/ hello") 
    public String getHello() { // hello. html に 画面 遷移 
        return "hello"; 
    }
}
