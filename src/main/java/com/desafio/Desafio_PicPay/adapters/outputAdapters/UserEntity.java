package com.desafio.Desafio_PicPay.adapters.outputAdapters;

import com.desafio.Desafio_PicPay.domain.TypeAccount;
import com.desafio.Desafio_PicPay.domain.dtos.UserRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Table(name = "\"users\"")
@Entity(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class UserEntity {


    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(length = 150)
    private String name;
    @Column(unique = true)
    private String cpf;
    @Enumerated(EnumType.STRING)
    private TypeAccount status;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account")
    private AccountEntity account;

    public UserEntity(UserRequestDTO userRequestDTO) {
        this.name = userRequestDTO.name();
        this.email = userRequestDTO.email();
        this.status = userRequestDTO.status();
        this.cpf = userRequestDTO.cpf();
        this.password = userRequestDTO.password();
        this.account = new AccountEntity();
    }

}
