package com.desafio.Desafio_PicPay.adapters.outputAdapters;

import com.desafio.Desafio_PicPay.domain.dtos.UserRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;


@Table(name = "users")
@Entity(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(unique = true, length = 150)
    private String name;
    @Column(unique = true) //Diz que o CPF não pode se repetir
    private String cpf;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName =  "id")
    private AccountEntity account;

    public UserEntity(UserRequestDTO userRequestDTO) {
        this.name = userRequestDTO.name();
        this.email = userRequestDTO.email();
        this.cpf = userRequestDTO.cpf();
        this.password = userRequestDTO.password();
        this.account = new AccountEntity();
    }
}
