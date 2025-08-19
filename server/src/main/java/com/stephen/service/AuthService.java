package com.stephen.service;

import com.stephen.dto.UserDTO;
import com.stephen.dto.auth.AuthResponse;
import com.stephen.factory.UserFactory;
import com.stephen.mapper.UserMapper;
import com.stephen.model.Admin;
import com.stephen.model.Client;
import com.stephen.model.Freelance;
import com.stephen.model.User;
import com.stephen.model.enums.Role;
import com.stephen.repository.AdminRepository;
import com.stephen.repository.ClientRepository;
import com.stephen.repository.FreelanceRepository;
import com.stephen.repository.UserRepository;
import com.stephen.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserFactory userFactory;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private FreelanceRepository freelanceRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserMapper userMapper;

    public AuthResponse login(String email, String password) {
        User user = authenticateAndGetUser(email, password);
        String token = generateTokenForUser(user);
        UserDTO dto = userMapper.toDto(user);
        return new AuthResponse(token, dto);
    }

    public AuthResponse register(String email, String password, Role role) {
        User user = performRegistration(email, password, role);
        String token = generateTokenForUser(user);
        UserDTO dto = userMapper.toDto(user);
        return new AuthResponse(token, dto);
    }

    private String generateTokenForUser(User user) {
        return jwtUtil.generateToken(new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPasswordHash(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        ));
    }

    public User authenticateAndGetUser(String email, String password) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        return userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private User performRegistration(String email, String password, Role role) {
        User user = userFactory.create(email, passwordEncoder.encode(password), role);

        switch (role) {
            case CLIENT -> clientRepository.save((Client) user);
            case FREELANCE -> freelanceRepository.save((Freelance) user);
            case ADMIN -> adminRepository.save((Admin) user);
            default -> throw new IllegalArgumentException("Unknown role: " + role);
        }

        return user;
    }

}

