package com.mycompany.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Provides security services
 */
public interface UserSecurityService extends UserDetailsService {

    UserDetails getUserByApiKey(String apiKey);
}
