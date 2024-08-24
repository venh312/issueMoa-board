package com.issuemoa.board.application;

import com.issuemoa.board.domain.board.BoardRepository;
import com.issuemoa.board.presentation.dto.BoardResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Cacheable(value = "board", key = "#type + '_' + #skip + '_' + #limit", cacheManager = "contentCacheManager")
    public List<BoardResponse> findByType(String type, int skip, int limit) {
        PageRequest pageable = PageRequest.of(skip, limit);
        return boardRepository.findByType(type, pageable);
    }
}
