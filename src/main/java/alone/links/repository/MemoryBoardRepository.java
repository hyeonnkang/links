package alone.links.repository;

import alone.links.domain.Board;

import java.util.*;

public class MemoryBoardRepository implements BoardRepository{

    private static Map<Long, Board> store = new HashMap<>();
    private static long sequence = 0L;  // 글 번호

    @Override
    public Board insert(Board board) {
        board.setId(++sequence);
        store.put(board.getId(), board);
        return board;
    }

    @Override
    public Optional<Board> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Board> findByTitle(String title) {
        return store.values().stream()
                .filter(board -> board.getTitle().equals(title))
                .findAny();
    }

    @Override
    public Optional<Board> findByDesc(String desc) {
        return store.values().stream()
                .filter(board -> board.getDesc().equals(desc))
                .findAny();
    }

    @Override
    public List<Board> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
