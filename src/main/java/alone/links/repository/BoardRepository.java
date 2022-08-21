package alone.links.repository;

import alone.links.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    Board insert(Board board);
    Optional<Board> findById(String id);
    Optional<Board> findByTitle(String title);
    Optional<Board> findByDesc(String desc);
    List<Board> findAll();
}
