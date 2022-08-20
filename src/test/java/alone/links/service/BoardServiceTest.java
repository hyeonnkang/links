package alone.links.service;

import alone.links.domain.Board;
import alone.links.repository.MemoryBoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardServiceTest {

    MemoryBoardRepository boardRepository;
    BoardService boardService;

    @BeforeEach
    public void beforeEach(){
        boardRepository = new MemoryBoardRepository();
        boardService = new BoardService(boardRepository);
    }

    @AfterEach
    public void afterEach(){
        boardRepository.clearStore();
    }

    @Test
    public void create() throws Exception{

        //given
        Board board = new Board();
        board.setTitle("제목1");
        board.setDesc("내용1");
        board.setAuthor("아무개");

        //when
        Long saveId = boardService.create(board);

        //then
        Board findBoard = boardRepository.findById(saveId).get();
        Assertions.assertThat(findBoard).isEqualTo(board);
    }
}
