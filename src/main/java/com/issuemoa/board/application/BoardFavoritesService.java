package com.issuemoa.board.application;

import com.issuemoa.board.domain.board.favorite.BoardFavorites;
import com.issuemoa.board.domain.board.favorite.BoardFavoritesRepository;
import com.issuemoa.board.infrastructure.api.UsersRestApi;
import com.issuemoa.board.presentation.dto.BoardFavoritesResponse;
import com.issuemoa.board.presentation.dto.BoardFavoritesSave;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardFavoritesService {
    private final BoardFavoritesRepository boardFavoritesRepository;
    private final UsersRestApi usersRestApi;

    public BoardFavoritesResponse save(HttpServletRequest httpServletRequest, BoardFavoritesSave boardFavoritesSave){
        String userId = usersRestApi.getUserId(httpServletRequest);
        BoardFavorites favorites = boardFavoritesRepository.save(boardFavoritesSave.toEntity(userId));
        return BoardFavoritesResponse.toDto(favorites);
    }

    public List<BoardFavoritesResponse> findByUserId(HttpServletRequest httpServletRequest){
        String userId = usersRestApi.getUserId(httpServletRequest);
        return boardFavoritesRepository.findByUserId(userId);
    }
}
