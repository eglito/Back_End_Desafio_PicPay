package com.desafio.Desafio_PicPay.adapters.inputAdapters;

import com.desafio.Desafio_PicPay.domain.dtos.UserRequestDTO;
import com.desafio.Desafio_PicPay.domain.dtos.UserResponseDTO;
import com.desafio.Desafio_PicPay.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserServices services;

    @PostMapping(value = "/create_user")
    public ResponseEntity<Void> createUser(@RequestBody UserRequestDTO userRequestDTO){
        services.creatUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDTO> getUser(Long id){
        UserResponseDTO user = services.getUser(id).getBody();
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody UserRequestDTO userRequestDTO, Long id){
        services.updateUser(userRequestDTO, id);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(Long id){
        ResponseEntity response = services.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
