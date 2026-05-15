package com.gamux.website_api.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamux.website_api.services.UserService;

@RestController
@RequestMapping("/private/users")
public class UserPrivateController {
    
    @Autowired
    private UserService userService;

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
