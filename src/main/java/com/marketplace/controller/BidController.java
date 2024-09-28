package com.marketplace.controller;

import com.marketplace.model.Bid;
import com.marketplace.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @PostMapping
    public Bid placeBid(@RequestBody Bid bid) {
        return bidService.placeBid(bid);
    }

    @GetMapping("/service-request/{serviceRequestId}")
    public List<Bid> getBidsForServiceRequest(@PathVariable Long serviceRequestId) {
        return bidService.getBidsForServiceRequest(serviceRequestId);
    }

    @PostMapping("/{bidId}/accept")
    public Bid acceptBid(@PathVariable Long bidId) {
        return bidService.acceptBid(bidId);
    }

    @PostMapping("/{bidId}/reject")
    public Bid rejectBid(@PathVariable Long bidId) {
        return bidService.rejectBid(bidId);
    }
}
