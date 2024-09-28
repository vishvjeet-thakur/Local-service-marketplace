package com.marketplace.service;

import com.marketplace.model.User;
import com.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private UserRepository userRepository;

    public void notifyProviders(Long serviceRequestId) {
        List<User> providers = userRepository.findByRole("PROVIDER");

        // In a real-world scenario, send an email, SMS, or push notification to each provider.
        for (User provider : providers) {
            System.out.println("Notification sent to provider: " + provider.getEmail());
        }
    }
}
