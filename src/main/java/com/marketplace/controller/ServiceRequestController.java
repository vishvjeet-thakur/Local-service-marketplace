package com.marketplace.controller;

import com.marketplace.model.ServiceRequest;
import com.marketplace.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-requests")
public class ServiceRequestController {

    @Autowired
    private ServiceRequestService serviceRequestService;

    @PostMapping
    public ServiceRequest createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        return serviceRequestService.createServiceRequest(serviceRequest);
    }

    @GetMapping("/customer/{customerId}")
    public List<ServiceRequest> getServiceRequestsByCustomer(@PathVariable Long customerId) {
        return serviceRequestService.getServiceRequestsByCustomer(customerId);
    }
}
