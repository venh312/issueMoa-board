package com.issuemoa.board.pojo;

import java.util.List;

public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Long save(BoardSaveRequest boardSaveRequest) {
        return boardRepository.save(boardSaveRequest.toEntity());
    }

    public List<Board> findByAll() {
        return boardRepository.findByAll();
    }

    public List<Board> findByType(String type) {
        return boardRepository.findByType(type);
    }
}
