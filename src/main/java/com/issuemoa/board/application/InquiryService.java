package com.issuemoa.board.application;

import com.issuemoa.board.infrastructure.kafka.InquiryProducer;
import com.issuemoa.board.domain.inquiry.InquiryRepository;
import com.issuemoa.board.presentation.dto.InquirySaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InquiryService {
    private final InquiryRepository inquiryRepository;
    private final InquiryProducer inquiryProducer;

    public Long save(InquirySaveRequest inquirySaveRequest) {
        Long result = inquiryRepository.save(inquirySaveRequest.toEntity()).getId();

        if (result > 0) {
            inquiryProducer.sendMessage(inquirySaveRequest);
        }

        return result;
    }
}
