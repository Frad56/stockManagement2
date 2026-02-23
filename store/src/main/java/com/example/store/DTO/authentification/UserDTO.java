package com.example.store.DTO.authentification;

import com.example.store.Model.Authentification.Role;
import lombok.Data;



@Data
public class UserDTO {
    private Long id;

    private String username;
    private String password;
    private String email;
    private Role role;
}
