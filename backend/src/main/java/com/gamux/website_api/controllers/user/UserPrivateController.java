package com.gamux.website_api.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamux.website_api.domain.user.dto.UpdateUserRequestDTO;
import com.gamux.website_api.domain.user.dto.UserResponseDTO;
import com.gamux.website_api.services.UserService;

@RestController
@RequestMapping("/private/users")
public class UserPrivateController {
    
    @Autowired
    private UserService userService;

    @PatchMapping
    public ResponseEntity<UserResponseDTO> updateUser(@ModelAttribute UpdateUserRequestDTO data, @RequestHeader String username) {
        try {
            UserResponseDTO res = userService.updateUser(data, username);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestHeader String username) {
        try {
            userService.deleteUser(username);
            return ResponseEntity.ok("Usuário deletado com sucesso.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }
}
