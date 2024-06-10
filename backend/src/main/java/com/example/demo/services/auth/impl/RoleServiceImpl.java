package com.example.demo.services.auth.impl;

import com.example.demo.infra.exceptions.EntityNotFoundException;
import com.example.demo.persistence.entities.Role;
import com.example.demo.persistence.repository.RoleRepository;
import com.example.demo.services.auth.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getByName(String name) {
        return this.roleRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Role not found"));
    }
}
