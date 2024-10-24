package com.ProiectareSoftware.myLifeStyle.service;

import com.ProiectareSoftware.myLifeStyle.dto.request.RegisterRequest;
import com.ProiectareSoftware.myLifeStyle.dto.response.AuthenticationResponse;
import com.ProiectareSoftware.myLifeStyle.dto.request.LoginRequest;
import com.ProiectareSoftware.myLifeStyle.model.ERole;
import com.ProiectareSoftware.myLifeStyle.model.Role;
import com.ProiectareSoftware.myLifeStyle.model.User;
import com.ProiectareSoftware.myLifeStyle.repository.RoleRepository;
import com.ProiectareSoftware.myLifeStyle.repository.UserRepository;
import com.ProiectareSoftware.myLifeStyle.security.JwtUtils;
import com.ProiectareSoftware.myLifeStyle.security.UserDetailsImpl;
import com.ProiectareSoftware.myLifeStyle.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


    @Override
    public ResponseEntity<AuthenticationResponse> login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        User user = userRepository.findByEmail(userDetails.getEmail()).orElse(null);
        UserDTO userDTO = new UserDTO(user);

        return ResponseEntity.ok(new AuthenticationResponse(userDTO, jwt));
    }

    @Override
    public ResponseEntity<?> register(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        // Create new user's account
        User user = new User();
        Role userRole = roleRepository.findByRole(ERole.USER).orElse(null);

        if(userRole == null){
            Role tempRole = new Role();
            tempRole.setRole(ERole.USER);
            userRole = roleRepository.save(tempRole);
        }

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setGender(registerRequest.getGender());
        user.setPassword(encoder.encode(registerRequest.getPassword()));

        user = userRepository.save(user);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), registerRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity.ok(new AuthenticationResponse(new UserDTO(user), jwt));
    }
}
