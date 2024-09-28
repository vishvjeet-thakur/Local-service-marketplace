package com.marketplace.service;

import com.marketplace.model.Bid;
import com.marketplace.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    public Bid placeBid(Bid bid) {
        return bidRepository.save(bid);
    }

    public List<Bid> getBidsForServiceRequest(Long serviceRequestId) {
        return bidRepository.findByServiceRequestId(serviceRequestId);
    }

    public Bid acceptBid(Long bidId) {
        Bid bid = bidRepository.findById(bidId).orElseThrow();
        bid.setStatus("ACCEPTED");
        return bidRepository.save(bid);
    }

    public Bid rejectBid(Long bidId) {
        Bid bid = bidRepository.findById(bidId).orElseThrow();
        bid.setStatus("REJECTED");
        return bidRepository.save(bid);
    }
}
