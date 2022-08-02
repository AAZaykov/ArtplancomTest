package com.aazaykov.userpets.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pets")
public class Pet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private PetType type;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "petgender", nullable = false)
    private Gender petGender;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", type=" + type +
                ", birthday=" + birthday +
                ", petGender=" + petGender +
                ", name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
