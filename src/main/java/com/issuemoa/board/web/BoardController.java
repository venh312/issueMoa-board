package com.issuemoa.board.web;

import com.issuemoa.board.domain.Board;
import com.issuemoa.board.message.RestMessage;
import com.issuemoa.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/{type}/list")
    public ResponseEntity<RestMessage> findAll(Board.Request request,
                                  @RequestParam(required = false, defaultValue = "0") Integer page,
                                  @RequestParam(required = false, defaultValue = "24") Integer pageSize) {
        return ResponseEntity.ok()
                .headers(new HttpHeaders())
                .body(new RestMessage(HttpStatus.OK, boardService.findAll(request, page, pageSize)));
    }

    @GetMapping("/board/{type}/detail")
    public ResponseEntity<RestMessage> findById(@RequestParam Long id) {
        return ResponseEntity.ok()
                .headers(new HttpHeaders())
                .body(new RestMessage(HttpStatus.OK, boardService.findById(id)));
    }

    @PostMapping("/board/{type}/countByTypeAndRegisterId")
    public ResponseEntity<RestMessage> countByTypeAndRegisterId(Board.Request request) {
        return ResponseEntity.ok()
                .headers(new HttpHeaders())
                .body(new RestMessage(HttpStatus.OK, boardService.countByTypeAndRegisterId(request)));
    }
}
