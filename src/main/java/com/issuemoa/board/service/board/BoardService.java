package com.issuemoa.board.service.board;

import com.issuemoa.board.domain.board.Board;
import com.issuemoa.board.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Cacheable(value = "board", key = "#type", cacheManager = "contentCacheManager")
    public List<Board> findByType(String type, int skip, int limit) {
        PageRequest pageable = PageRequest.of(skip, limit);
        return boardRepository.findByType(type, pageable);
    }

    public Board addFavoriteBoards(BoardFavoriteSave boardFavoriteSave) {
        Optional<Board> boardOptional = boardRepository.findById(boardFavoriteSave.boardId());

        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            List<String> userIds = board.getFavoriteUserIds();
            userIds.add(boardFavoriteSave.userId());
            board.setFavoriteUserIds(userIds);
            return boardRepository.save(board);
        }

        return null;
    }

    public List<Board> findByFavoriteUserIdsContaining(BoardFavoriteSearch boardFavoriteSearch) {
          return boardRepository.findByFavoriteUserIdsContaining(boardFavoriteSearch.userId());
    }
}
