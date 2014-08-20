package com.mycompany.service;

import com.mycompany.UserNotFoundException;
import com.mycompany.repositories.UserSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service implementation
 */
@Service
public class UserSecurityServiceImpl implements UserSecurityService{

    @Autowired
    private UserSecurityRepository userSecurityRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails userDetails = userSecurityRepository.getUserByUsername(s);
        if(userDetails == null) {
            throw new UsernameNotFoundException("User not found using supplied username");
        }

        return userDetails;
    }


    @Override
    public UserDetails getUserByApiKey(String apiKey) {
        UserDetails userDetails = userSecurityRepository.getUserByApiKey(apiKey);
        if(userDetails == null){
            throw new UserNotFoundException("User could not be found with the supplied api key.");
        }

        return userDetails;
    }
}
