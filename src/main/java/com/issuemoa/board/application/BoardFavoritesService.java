package com.issuemoa.board.application;

import com.issuemoa.board.domain.board.favorite.BoardFavorites;
import com.issuemoa.board.domain.board.favorite.BoardFavoritesRepository;
import com.issuemoa.board.presentation.dto.BoardFavoritesResponse;
import com.issuemoa.board.presentation.dto.BoardFavoritesSave;
import com.issuemoa.board.presentation.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardFavoritesService {
    private final BoardFavoritesRepository boardFavoritesRepository;
    private final TokenProvider tokenProvider;

    public BoardFavoritesResponse save(String token, BoardFavoritesSave boardFavoritesSave){
        Long userId = tokenProvider.getUserId(token);
        BoardFavorites favorites = boardFavoritesRepository.save(boardFavoritesSave.toEntity(userId));
        return BoardFavoritesResponse.toDto(favorites);
    }

    public List<BoardFavoritesResponse> findByUserId(String token){
        Long userId = tokenProvider.getUserId(token);
        return boardFavoritesRepository.findByUserId(userId, Sort.by(Sort.Direction.DESC, "registerDateTime"));
    }
}
