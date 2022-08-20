package alone.links.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinksController {

    @GetMapping("list")
    public String list(Model model){
        model.addAttribute("data", "아무개");
        return "list";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("data", "아무개");
        return "create";
    }

    @GetMapping("create_process")
    public String create_process(Model model){
        return "create_process";
    }
}
