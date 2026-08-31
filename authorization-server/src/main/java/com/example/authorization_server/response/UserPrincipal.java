package com.example.authorization_server.response;

import com.example.authorization_server.entity.RoleEntity;
import com.example.authorization_server.entity.UserEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserPrincipal implements UserDetails {

    private String id;
    private String username;
    private String fullName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> roles;

    public UserPrincipal(String username, String fullName, String email, String password,
                         Collection<? extends GrantedAuthority> roles){

        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public static UserPrincipal build(UserEntity user, Collection<RoleEntity> roles){

        List<GrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());

        return new UserPrincipal(
                user.getUsername(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
