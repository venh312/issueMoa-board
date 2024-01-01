package com.issuemoa.board.service;

import com.issuemoa.board.domain.board.Board;
import com.issuemoa.board.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> findByType(String type, int skip, int limit) {
        PageRequest pageable = PageRequest.of(skip, limit);
        return boardRepository.findByType(type, pageable);
    }
}
