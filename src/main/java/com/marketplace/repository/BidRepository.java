package com.marketplace.repository;

import com.marketplace.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findByServiceRequestId(Long serviceRequestId);
}
