package com.issuemoa.board.pojo;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    static List<Board> list = new ArrayList<>();
    private Long sequence = 0L;

    public Long save(Board board) {
        list.add(new Board.Builder(board).id(++sequence).build());
        return sequence;
    }

    public List<Board> findByAll() {
        return list;
    }

    public List<Board> findByType(String type) {
        List<Board> result = new ArrayList<>();
        for (Board board : list) {
            if (board.getType().equals(type))
                result.add(board);
        }
        return result;
    }

}
