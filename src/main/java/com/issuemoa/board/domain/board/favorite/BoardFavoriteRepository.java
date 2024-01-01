package com.issuemoa.board.domain.board.favorite;

import com.issuemoa.board.domain.board.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BoardFavoriteRepository extends MongoRepository<BoardFavorite, String> {
}
