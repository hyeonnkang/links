package alone.links.controller;

import alone.links.domain.Board;
import alone.links.form.BoardForm;
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
        return "boards/createBoardForm";
    }

    @PostMapping("boards/create")
    public String create_process(BoardForm boardForm) {
        boardService.create(boardForm);

        return "redirect:/boards";
    }

    @GetMapping("boards/delete")
    public String delete_process(String id, Model model) {
        boardService.deleteById(id);
        return "redirect:/boards";
    }

    @GetMapping("/boards/update")
    public String update(String id, Model model){
        if(boardService.findById(id).isPresent()){
            Board board = boardService.findById(id).get();
            model.addAttribute("board", board);
            return "boards/updateBoardForm";
        }else{
            System.out.println("수정하려는 id가 없습니다.");
            return "redirect:/boards";
        }
    }

    @PostMapping("boards/update")
    public String update_process(BoardForm boardForm) {
        boardService.update(boardForm);
        return "redirect:/boards";
    }

    @GetMapping("boards/details")
    public String detail(String id, Model model){
        if(boardService.findById(id).isPresent()){
            Board board = boardService.findById(id).get();
            model.addAttribute("board", board);
            return "boards/boardDetails";
        }else{
            System.out.println("글 상세보기 불가: 해당 id의 글이 없음");
            return "redirect:/boards";
        }
    }
}
