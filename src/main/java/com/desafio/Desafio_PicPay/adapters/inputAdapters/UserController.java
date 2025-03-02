package com.desafio.Desafio_PicPay.adapters.inputAdapters;

import com.desafio.Desafio_PicPay.domain.dtos.EmailResponseDTO;
import com.desafio.Desafio_PicPay.domain.dtos.UserRequestDTO;
import com.desafio.Desafio_PicPay.domain.dtos.UserResponseDTO;
import com.desafio.Desafio_PicPay.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices services;

    @PostMapping(value = "/new_user")
    public ResponseEntity<Void> createUser(@RequestBody UserRequestDTO userRequestDTO){
        services.createUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDTO> getUserForId(@PathVariable UUID id){
        return ResponseEntity.ok(services.getUser(id).getBody());
    }

    @GetMapping("/emails")
    public ResponseEntity<List<EmailResponseDTO>> getAllEmails(){
        return ResponseEntity.ok(services.getAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody UserRequestDTO userRequestDTO,@PathVariable UUID id){
        services.updateUser(userRequestDTO, id);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id){
        ResponseEntity response = services.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
