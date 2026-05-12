package com.gamux.website_api.controllers.user;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamux.website_api.services.UserService;

@RestController
@RequestMapping("/private/users")
public class UserPrivateController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam UUID id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("Usuário deletado com sucesso.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }
}
