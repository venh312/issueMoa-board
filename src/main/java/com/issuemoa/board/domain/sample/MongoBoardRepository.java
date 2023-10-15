package com.issuemoa.board.domain.sample;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoBoardRepository extends MongoRepository<MongoBoard, String> {
}
