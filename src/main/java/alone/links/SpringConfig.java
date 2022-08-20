package alone.links;

import alone.links.repository.BoardRepository;
import alone.links.repository.MemoryBoardRepository;
import alone.links.service.BoardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public BoardService boardService(){
        return new BoardService(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository(){
        return new MemoryBoardRepository();
    }
}
