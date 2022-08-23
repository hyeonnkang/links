package alone.links.controller;

import alone.links.domain.Board;
import alone.links.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/boards")
    public String list(Model model) {
        model.addAttribute("data", "아무개");

        List<Board> boards = boardService.findAll(); // 게시글 모두 조회
        model.addAttribute("boards", boards);
        return "boards/boardList";
    }

    @GetMapping("/boards/create")
    public String create(Model model) {
        model.addAttribute("data", "아무개");
        return "boards/createBoardForm";
    }

    @PostMapping("boards/create")
    public String create_process(BoardForm boardForm) {
        boardService.create(boardForm);

        return "redirect:/";
    }
}
