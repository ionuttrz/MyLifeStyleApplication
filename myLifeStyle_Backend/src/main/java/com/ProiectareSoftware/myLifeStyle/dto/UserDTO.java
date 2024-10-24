package com.ProiectareSoftware.myLifeStyle.dto;

import com.ProiectareSoftware.myLifeStyle.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer id;
    private String name;
    private String email;

    private String gender;
    private Set<RoleDTO> roles;

    public UserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.gender = user.getGender();
        this.roles = user.getRoles().stream().map((r) -> new RoleDTO(r)).collect(Collectors.toSet());
    }
}
