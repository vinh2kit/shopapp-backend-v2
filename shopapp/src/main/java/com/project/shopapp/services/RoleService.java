package com.project.shopapp.services;

import com.project.shopapp.model.Role;
import com.project.shopapp.repositories.RoleRepository;
import com.project.shopapp.services.interfaces.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
