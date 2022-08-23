package alone.links.service;

import alone.links.controller.BoardForm;
import alone.links.domain.Board;
import alone.links.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public String create(BoardForm boardForm){  // 생성한 board id를 반환
        Board board = new Board(boardForm.getTitle(), boardForm.getDesc(), boardForm.getAuthor());
        boardRepository.insert(board);
        return board.getId();
    }

    public List<Board> findAll(){  // 모든 board 리스트를 반환
        return boardRepository.findAll();
    }

    public Optional<Board> findById(String id){
        return boardRepository.findById(id);
    }
}
