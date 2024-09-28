package com.marketplace.service;

import com.marketplace.model.ServiceRequest;
import com.marketplace.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestService {

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @Autowired
    private NotificationService notificationService;

    public ServiceRequest createServiceRequest(ServiceRequest serviceRequest) {
        ServiceRequest savedRequest = serviceRequestRepository.save(serviceRequest);
        notificationService.notifyProviders(savedRequest.getId());
        return savedRequest;
    }

    public List<ServiceRequest> getServiceRequestsByCustomer(Long customerId) {
        return serviceRequestRepository.findByCustomerId(customerId);
    }
}
