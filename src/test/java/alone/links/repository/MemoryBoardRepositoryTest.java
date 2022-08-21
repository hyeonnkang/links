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
    public void insert() {
        //given
        Board board = new Board("제목1", "내용1", "아무개");

        //when
        repository.insert(board);

        //then
        Board result = repository.findById(board.getId()).get();
        assertThat(result).isEqualTo(board);
    }

    @Test
    public void findById() {
        //given
        Board board1 = new Board("제목1", "내용1", "아무개");

        Board board2 = new Board("제목2", "내용2", "아무개");

        //when
        repository.insert(board1);
        repository.insert(board2);

        //then
        Board result = repository.findById(board1.getId()).get();
        assertThat(result).isNotEqualTo(board2);
    }

    @Test
    public void findByTitle() {
        //given
        Board board = new Board("제목1", "내용1", "아무개");

        //when
        repository.insert(board);

        //then
        Board result = repository.findByTitle(board.getTitle()).get();
        assertThat(result).isEqualTo(board);
    }

    @Test
    public void findByDesc() {
        //given
        Board board = new Board("제목1", "내용1", "아무개");

        //when
        repository.insert(board);

        //then
        Board result = repository.findByDesc(board.getDesc()).get();
        assertThat(result).isEqualTo(board);
    }

    @Test
    public void findAll() {
        //given
        Board board1 = new Board("제목1", "내용1", "아무개");

        Board board2 = new Board("제목2", "내용2", "아무개");

        //when
        repository.insert(board1);
        repository.insert(board2);
        List<Board> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}
