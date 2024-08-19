package com.project.shopapp.services.interfaces;

import com.project.shopapp.dto.UserDTO;
import com.project.shopapp.model.User;

public interface IUserService {
    User createUser(UserDTO userDTO) throws Exception;
    String login(String phoneNumber, String password, Long roleId) throws Exception;
}
