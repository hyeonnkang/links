package alone.links.service;

import alone.links.controller.BoardForm;
import alone.links.domain.Board;
import alone.links.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Test
    @DisplayName("모든 board 조회")
    public void findAllBoard(){
        List<Board> boardList = boardService.findAll();
        for(Board board : boardList){
            System.out.println(board);
        }
        Assertions.assertThat(boardList.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("새로운 board 생성")
    public void createBoard(){
        BoardForm boardForm = new BoardForm();
        boardForm.setTitle("hello");
        boardForm.setDesc("i'm happy");
        boardForm.setAuthor("whoami");
        
        String id = boardService.create(boardForm);
        System.out.println("id = " + id);
    }
}
