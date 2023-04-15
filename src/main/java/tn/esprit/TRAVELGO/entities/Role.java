package tn.esprit.TRAVELGO.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name ;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole namee;

    public Role(String role_user) {
        this.name=role_user;
    }

}
