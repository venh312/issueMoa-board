package com.issuemoa.board.service;

import com.issuemoa.board.domain.board.favorite.BoardFavorite;
import com.issuemoa.board.domain.board.favorite.BoardFavoriteRepository;
import com.issuemoa.board.dto.boardfavorite.BoardFavoriteSave;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardFavoriteService {
    private final BoardFavoriteRepository boardFavoriteRepository;

    public String save(BoardFavoriteSave request) {
        return boardFavoriteRepository.save(request.toEntity()).getId();
    }

    public List<BoardFavorite> findAll(BoardFavorite request, int skip, int limit) {
        PageRequest pageable = PageRequest.of(skip, limit);
        return boardFavoriteRepository.findAll();
    }
}
