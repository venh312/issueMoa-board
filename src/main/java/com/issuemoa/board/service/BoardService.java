package com.issuemoa.board.service;

import com.issuemoa.board.domain.Board;
import com.issuemoa.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> findByType(String type, int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return boardRepository.findByType(type, pageable);
    }
}
