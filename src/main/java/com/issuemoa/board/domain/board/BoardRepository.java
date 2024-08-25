package com.issuemoa.board.domain.board;

import com.issuemoa.board.presentation.dto.BoardResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BoardRepository extends MongoRepository<Board, String> {
    List<BoardResponse> findByType(String type, Pageable pageable, Sort sort);
}
