package com.issuemoa.board.application;

import com.issuemoa.board.infrastructure.api.UsersRestApi;
import com.issuemoa.board.domain.board.Board;
import com.issuemoa.board.domain.board.BoardRepository;
import com.issuemoa.board.presentation.dto.BoardFavoriteSave;
import com.issuemoa.board.presentation.dto.BoardListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final UsersRestApi usersRestApi;

    @Cacheable(value = "board", key = "#type", cacheManager = "contentCacheManager")
    public List<BoardListResponse> findByType(String type, int skip, int limit) {
        PageRequest pageable = PageRequest.of(skip, limit);
        return boardRepository.findByType(type, pageable);
    }

    public Board addFavoriteBoards(HttpServletRequest httpServletRequest, BoardFavoriteSave boardFavoriteSave) {
        Board board = boardRepository.findById(boardFavoriteSave.boardId()).orElseThrow(() ->  new NullPointerException("게시글이 존재하지 않습니다."));
        String userId = usersRestApi.getUserId(httpServletRequest);

        List<String> userIds = board.getFavoriteUserIds();
        userIds.add(userId);
        board.setFavoriteUserIds(userIds);

        return boardRepository.save(board);
    }

    public List<BoardListResponse> findByFavoriteUserIdsContaining(HttpServletRequest httpServletRequest) {
        String userId = usersRestApi.getUserId(httpServletRequest);
        return boardRepository.findByFavoriteUserIdsContaining(userId);
    }
}
