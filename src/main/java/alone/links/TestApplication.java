package alone.links;

import alone.links.model.Board;
import alone.links.repository.MongoBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    @Autowired
    private MongoBoardRepository mongoBoardRepository;

    public static void main(String[] args){

        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       Board board1 = new Board("111111", "desc111111", "author 1111");
        Board board2 = new Board("222222", "desc2222222", "author 22222");

        //insert
        mongoBoardRepository.insert(Arrays.asList(board1, board2));

        //get
        List<Board> result = mongoBoardRepository.findAll();
        System.out.println(result);
    }
}

