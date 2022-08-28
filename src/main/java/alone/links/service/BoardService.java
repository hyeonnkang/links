package alone.links.service;

import alone.links.form.BoardForm;
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
        String author = boardForm.getAuthor();
        System.out.println("author = " + author);
        if(author.isBlank())
            author = "아무개";
        Board board = new Board(boardForm.getTitle(), boardForm.getDesc(),author);
        boardRepository.insert(board);
        return board.getId();
    }

    public List<Board> findAll(){  // 모든 board 리스트를 반환
        return boardRepository.findAll();
    }

    public Optional<Board> findById(String id){
        return boardRepository.findById(id);
    }

    public String update(BoardForm boardForm){
        if(this.findById(boardForm.getId()).isEmpty())
            return "수정실패";

        Board board = this.findById(boardForm.getId()).get();
        board.setTitle(boardForm.getTitle());
        board.setDesc(boardForm.getDesc());

        boardRepository.save(board);    // id값이 이전과 동일하므로 수정된다.

        return "수정성공";
    }

    public String deleteById(String id){
        if(this.findById(id).isEmpty())
            return "삭제실패";

        boardRepository.deleteById(id);
        return "삭제성공";
    }
}
