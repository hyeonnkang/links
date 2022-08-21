package alone.links.service;

import alone.links.domain.Board;
import alone.links.repository.BoardRepository;
import alone.links.repository.MemoryBoardRepository;

import java.util.List;
import java.util.Optional;

public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 글 생성
    public Long create(Board board){
        boardRepository.insert(board);
        return board.getId();
    }

    // 전체 글 목록 조회
    public List<Board> findBoards(){
        return boardRepository.findAll();
    }

    // 글 id에 해당하는 글 조회
    public Optional<Board> findOne(Long boardId){
        return boardRepository.findById(boardId);
    }
}
