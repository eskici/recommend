package com.moss.project.eneasy.core.user.service;


import com.moss.project.eneasy.dto.UserDto;
import com.moss.project.eneasy.entity.User;
import com.moss.project.eneasy.exception.InvalidTokenException;
import com.moss.project.eneasy.exception.UnkownIdentifierException;
import com.moss.project.eneasy.exception.UserAlreadyExistException;

public interface UserService {

    void register(final UserDto user) throws UserAlreadyExistException;
    boolean checkIfUserExist(final String email);
    void sendRegistrationConfirmationEmail(final User user);
    boolean verifyUser(final String token) throws InvalidTokenException;
    User getUserById(final String id) throws UnkownIdentifierException;
}
