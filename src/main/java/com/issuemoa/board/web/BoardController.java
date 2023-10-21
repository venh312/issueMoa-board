package com.issuemoa.board.web;

import com.issuemoa.board.domain.Board;
import com.issuemoa.board.message.RestMessage;
import com.issuemoa.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;
    private final MessageSource messages;

    @GetMapping("/board/{type}/list")
    public ResponseEntity<RestMessage> findAll(Board.Request request, Locale locale,
                                  @RequestParam(required = false, defaultValue = "0") Integer page,
                                  @RequestParam(required = false, defaultValue = "24") Integer pageSize) {

        log.info("local message : {}", messages.getMessage("board.select.empty", null, locale));
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
