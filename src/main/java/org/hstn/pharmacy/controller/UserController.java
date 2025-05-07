package org.hstn.pharmacy.controller;

import org.hstn.pharmacy.controller.api.UserApi;
import org.hstn.pharmacy.dto.dtoUser.UpdateUserRequest;
import org.hstn.pharmacy.dto.dtoUser.UserResponse;
import org.hstn.pharmacy.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(UpdateUserRequest request) {
        return ResponseEntity.ok(userService.updateUser(request));
    }

    @PutMapping("/updatePhotoLink")
    public ResponseEntity<Void> updatePhotoLink(@RequestParam Integer userId, @RequestParam String photoLink) {
        userService.updatePhotoLink(userId, photoLink);
        return ResponseEntity.ok().build();
    }
}
