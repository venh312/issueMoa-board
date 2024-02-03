package com.issuemoa.board.pojo;

import org.junit.jupiter.api.*;
import java.util.List;
import java.util.logging.Logger;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardControllerTest {
    private static final Logger logger = Logger.getLogger(BoardControllerTest.class.getName());
    private BoardService boardService;

    @BeforeEach
    void setUp() {
        BoardRepository boardRepository = new BoardRepository();
        boardService = new BoardService(boardRepository);
    }

    @Test
    @Order(1)
    void 게시글_등록() {
        logger.info("게시글 등록");
        BoardSaveRequest boardSaveRequest = new BoardSaveRequest(
                "NEWS",
                "Apple",
                "MacOS",
                "https://apple.com",
                "apple.jpg",
                null,
                null
        );
        Assertions.assertTrue(boardService.save(boardSaveRequest) > 0L);

        BoardSaveRequest boardSaveRequest2 = new BoardSaveRequest(
                "Youtube",
                "Appl2e",
                "MacOS2",
                "https://apple2.com",
                "apple2.jpg",
                null,
                null
        );
        Assertions.assertTrue(boardService.save(boardSaveRequest2) > 0L);
    }

    @Test
    @Order(2)
    void 게시글_다건조회() {
        List<Board> list = boardService.findByAll();
        for (Board board : list) {
            logger.info(board.toString());
        }
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    @Order(3)
    void 게시글_타입조회() {
        List<Board> list = boardService.findByType("NEWS");
        for (Board board : list) {
            logger.info(board.toString());
        }
        Assertions.assertFalse(list.isEmpty());
    }
}
