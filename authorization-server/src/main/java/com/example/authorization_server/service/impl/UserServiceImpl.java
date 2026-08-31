package com.example.authorization_server.service.impl;

import com.example.authorization_server.entity.RoleEntity;
import com.example.authorization_server.entity.UserEntity;
import com.example.authorization_server.entity.UserRoleEntity;
import com.example.authorization_server.repository.RoleRepository;
import com.example.authorization_server.repository.UserRepository;
import com.example.authorization_server.repository.UserRoleRepository;
import com.example.authorization_server.response.UserPrincipal;
import com.example.authorization_server.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userDetail = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found " + username));

        List<UserRoleEntity> listUserRole = userRoleRepository.findByUserId(userDetail.getId());

        List<String> listIdRole = listUserRole.stream().map(UserRoleEntity::getRoleId).toList();
        Collection<RoleEntity> role =roleRepository.findByIdIn(listIdRole);

        return UserPrincipal.build(userDetail, role);
    }
}
