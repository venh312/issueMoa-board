package com.issuemoa.board.domain.board;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BoardRepository extends MongoRepository<Board, String> {
    List<Board> findByType(String type, Pageable pageable);
    List<Board> findByFavoriteUserIdsContaining(String userId);
}
