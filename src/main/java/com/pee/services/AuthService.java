package com.pee.services;

import com.pee.dto.SignupRequest;
import com.pee.entities.User;

public interface AuthService {

    User createUser(SignupRequest signupRequest);
}
