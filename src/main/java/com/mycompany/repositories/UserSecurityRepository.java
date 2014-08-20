package com.mycompany.repositories;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Interface for providers
 */
public interface UserSecurityRepository {

    UserDetails getUserByUsername(String username);
    UserDetails getUserByApiKey(String apiKey);
}
