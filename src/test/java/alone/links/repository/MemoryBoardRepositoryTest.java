package alone.links.repository;

import alone.links.domain.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryBoardRepositoryTest {

    MemoryBoardRepository repository = new MemoryBoardRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        //given
        Board board = new Board();
        board.setTitle("제목1");
        board.setDesc("내용1");
        board.setAuthor("아무개");

        //when
        repository.save(board);

        //then
        Board result = repository.findById(board.getId()).get();
        assertThat(result).isEqualTo(board);
    }

    @Test
    public void findById() {
        //given
        Board board1 = new Board();
        board1.setTitle("제목1");
        board1.setDesc("내용1");
        board1.setAuthor("아무개");

        Board board2 = new Board();
        board2.setTitle("제목2");
        board2.setDesc("내용2");
        board2.setAuthor("아무개");

        //when
        repository.save(board1);
        repository.save(board2);

        //then
        Board result = repository.findById(board1.getId()).get();
        assertThat(result).isNotEqualTo(board2);
    }

    @Test
    public void findByTitle() {
        //given
        Board board = new Board();
        board.setTitle("제목1");
        board.setDesc("내용1");
        board.setAuthor("아무개");

        //when
        repository.save(board);

        //then
        Board result = repository.findByTitle(board.getTitle()).get();
        assertThat(result).isEqualTo(board);
    }

    @Test
    public void findByDesc() {
        //given
        Board board = new Board();
        board.setTitle("제목1");
        board.setDesc("내용1");
        board.setAuthor("아무개");

        //when
        repository.save(board);

        //then
        Board result = repository.findByDesc(board.getDesc()).get();
        assertThat(result).isEqualTo(board);
    }

    @Test
    public void findAll() {
        //given
        Board board1 = new Board();
        board1.setTitle("제목1");
        board1.setDesc("내용1");
        board1.setAuthor("아무개");

        Board board2 = new Board();
        board2.setTitle("제목2");
        board2.setDesc("내용2");
        board2.setAuthor("아무개");

        //when
        repository.save(board1);
        repository.save(board2);
        List<Board> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}
