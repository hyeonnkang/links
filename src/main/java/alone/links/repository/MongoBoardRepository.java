package alone.links.repository;

import alone.links.model.Board;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoBoardRepository extends MongoRepository<Board, String> {
    public Board findByTitle(String title);
    public Board findByDesc(String desc);
    public Board findByAuthor(String author);
}
