package com.issuemoa.board.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    public int countByTypeAndRegisterId(String type, Long registerId);
}
