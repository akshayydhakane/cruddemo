package com.example.cruddemo.Controller;

import com.example.cruddemo.DTO.UserMasterDTO;
import com.example.cruddemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserMasterDTO> addUser(@RequestBody UserMasterDTO userDTO) {
        UserMasterDTO savedUser = userService.addUser(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserMasterDTO> updateUser(@PathVariable Long id, @RequestBody UserMasterDTO userDTO) {
        userDTO.setUsermasterid(id);
        UserMasterDTO updatedUser = userService.updateUser(userDTO);
        return ResponseEntity.ok(updatedUser);
    }
}
