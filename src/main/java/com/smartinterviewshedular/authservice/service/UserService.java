package com.smartinterviewshedular.authservice.service;

import com.smartinterviewshedular.authservice.repository.UserRepository;
import com.smartinterviewshedular.commonlib.auth.model.Permission;
import com.smartinterviewshedular.commonlib.auth.model.Role;
import com.smartinterviewshedular.commonlib.auth.model.User;
import com.smartinterviewshedular.commonlib.auth.model.UserRoleType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(rollbackFor = Exception.class)
    public void createUser(String email, String password, Model model) {
        Optional<User> optionalUser = userRepository.findByUsername(email);
        if (optionalUser.isPresent()) {
            model.addAttribute("errorMessage", "User already exists. Please reset password if cannot remember");
        } else {
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(password));
            newUser.setEmail(email);
            newUser.setUsername(email);
            newUser.setEnabled(Boolean.TRUE);
            newUser.setAccountNonExpired(Boolean.TRUE);
            newUser.setAccountNonLocked(Boolean.TRUE);
            newUser.setCredentialsNonExpired(Boolean.TRUE);
            Role newUserRole = new Role();
            newUserRole.setId(UserRoleType.APP_ROLE_OPERATOR.getRoleId());
            newUserRole.setName(UserRoleType.APP_ROLE_OPERATOR.getRoleName());
            newUser.setRoles(Collections.singletonList(newUserRole));
            User savedUser = userRepository.save(newUser);
            if (savedUser.getUsername().equals(newUser.getUsername())) {
                model.addAttribute("successMessage", "User created, Please re-login to the system");
            } else {
                model.addAttribute("errorMessage", "An error occurred while creating a user");
            }
        }
    }
}
