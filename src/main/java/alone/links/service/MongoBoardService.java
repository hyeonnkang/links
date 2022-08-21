package alone.links.service;

import alone.links.domain.Board;
import alone.links.repository.MongoBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MongoBoardService {
    @Autowired
    private MongoBoardRepository mongoBoardRepository;

    // 글 생성
    public String create(Board board){
        mongoBoardRepository.insert(board);
        return board.getId();
    }

    // 전체 글 목록 조회
    public List<Board> findBoards(){
        return mongoBoardRepository.findAll();
    }
}
