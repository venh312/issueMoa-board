package com.issuemoa.board.service.inquiry;

import com.issuemoa.board.domain.inquiry.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InquiryService {
    private final InquiryRepository inquiryRepository;

    public Long save(InquirySaveRequest inquirySaveRequest) {
        return inquiryRepository.save(inquirySaveRequest.toEntity()).getId();
    }
}
