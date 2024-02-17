package com.issuemoa.board.domain.board;

import com.issuemoa.board.service.board.BoardListResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BoardRepository extends MongoRepository<Board, String> {
    List<BoardListResponse> findByType(String type, Pageable pageable);
    List<BoardListResponse> findByFavoriteUserIdsContaining(String userId);
}
