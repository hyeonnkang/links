package alone.links.repository;

import alone.links.domain.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("레포지토리 데이터 저장")
    public void insertTest(){
        //given
        Board board = new Board("제목1", "내용1", "작성자1");

        //when
        boardRepository.insert(board);

        //then
        Optional<Board> result = boardRepository.findById(board.getId());
        Assertions.assertThat(result.get().getId()).isEqualTo(board.getId());
    }
}
