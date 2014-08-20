package com.mycompany.repositories;

import com.mycompany.domain.RESTUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Fake provider
 */
@Repository
public class FakeUserSecurityRepositoryImpl implements UserSecurityRepository {

    private RESTUser simulateFetchOfuser() {
        return new RESTUser("username", "password", "api-1234", new ArrayList<GrantedAuthority>());
    }

    @Override
    public UserDetails getUserByUsername(String username) {
        RESTUser exampleUser = simulateFetchOfuser();

        if(username.equalsIgnoreCase(exampleUser.getUsername())){
            return exampleUser;
        }
        return null;
    }

    @Override
    public UserDetails getUserByApiKey(String apiKey) {
        RESTUser exampleUser = simulateFetchOfuser();
        if(apiKey.equals(exampleUser.getApiKey())){
            return exampleUser;
        }
        return null;
    }
}
