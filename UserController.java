package com.example.amazon;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/AmazonClone")
public class UserController {
    private final UserService authService;

    public UserController(UserService authService) {
        this.authService = authService;
    }

    @GetMapping("/users")
    public ResponseEntity getUsers(){
        ArrayList<User> users=authService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/register")
    public ResponseEntity addUser(@RequestBody @Valid User myUser, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        authService.addUser(myUser);
        return ResponseEntity.status(201).body( new ApiResponse("New user added !",201));
    }
    //
    @PutMapping("/users/{index}")
    public ResponseEntity updateUser(@RequestBody @Valid User myUser
            ,@PathVariable int index,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        authService.updateUser(index,myUser);
        return ResponseEntity.status(201).body( new ApiResponse("User updated !",201));
    }

    @DeleteMapping("/users/{index}")
    public ResponseEntity deleteUser(@PathVariable int index){
        authService.deleteUser(index);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted !",200));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid User loginForm,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        boolean isValid=authService.login(loginForm);
        if(isValid){
            return ResponseEntity.status(200).body(new ApiResponse("Welcome back",200));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong username or password",400));
    }

}
