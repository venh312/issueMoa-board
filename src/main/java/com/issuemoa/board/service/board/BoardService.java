package com.issuemoa.board.service.board;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.issuemoa.board.common.UsersRestApi;
import com.issuemoa.board.domain.board.Board;
import com.issuemoa.board.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

    public Board addFavoriteBoards(HttpServletRequest httpServletRequest, BoardFavoriteSave boardFavoriteSave) throws JsonProcessingException {
        HashMap<String, Object> userInfo = usersRestApi.getUserInfo(httpServletRequest);

        if (userInfo == null) return null;

        String userId = ((String) userInfo.get("id"));

        Optional<Board> boardOptional = boardRepository.findById(boardFavoriteSave.boardId());

        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            List<String> userIds = board.getFavoriteUserIds();
            userIds.add(userId);
            board.setFavoriteUserIds(userIds);
            return boardRepository.save(board);
        }

        return null;
    }

    public List<BoardListResponse> findByFavoriteUserIdsContaining(HttpServletRequest httpServletRequest) throws JsonProcessingException {
        HashMap<String, Object> userInfo = usersRestApi.getUserInfo(httpServletRequest);

        if (userInfo == null) return null;

        String userId = ((String) userInfo.get("id"));

        return boardRepository.findByFavoriteUserIdsContaining(userId);
    }
}
