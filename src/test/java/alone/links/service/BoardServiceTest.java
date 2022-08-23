package alone.links.service;

import alone.links.form.BoardForm;
import alone.links.domain.Board;
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

    @Test
    @DisplayName("id로 board 조회")
    public void findById(){
        BoardForm boardForm = new BoardForm();
        boardForm.setTitle("bye");
        boardForm.setDesc("i'm studying");
        boardForm.setAuthor("whoareyou");

        String id = boardService.create(boardForm);

        Board result = boardService.findById(id).get();

        Assertions.assertThat(result.getTitle()).isEqualTo(boardForm.getTitle());
        Assertions.assertThat(result.getDesc()).isEqualTo(boardForm.getDesc());
        Assertions.assertThat(result.getAuthor()).isEqualTo(boardForm.getAuthor());
    }

    @Test
    @DisplayName("id로 board 삭제")
    public void deleteById(){
        BoardForm boardForm = new BoardForm();
        boardForm.setTitle("bye2");
        boardForm.setDesc("i'm studying2");
        boardForm.setAuthor("whoareyou2");

        String id = boardService.create(boardForm);

        String message = boardService.deleteById(id);

        Assertions.assertThat(message).isEqualTo("삭제성공");
    }

    @Test
    @DisplayName("board 수정하기")
    public void update(){
        BoardForm boardForm = new BoardForm();
        boardForm.setTitle("수정전 bye");
        boardForm.setDesc("i'm studying2");
        boardForm.setAuthor("whoareyou2");

        String id = boardService.create(boardForm);

        boardForm.setId(id);
        boardForm.setTitle("수정후 bye");
        boardForm.setDesc("수정후 i'm studying2");
        boardForm.setAuthor("수정후 whoareyou2");

        String result = boardService.update(boardForm);

        Assertions.assertThat(result).isEqualTo("수정성공");
    }
}
