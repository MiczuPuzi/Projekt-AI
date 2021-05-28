package com.example.projektai.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @NotNull
    @NaturalId
    @Enumerated(EnumType.STRING)
    private RoleName name;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users;

    public Role(){
        this.users = new HashSet<>();
    }

    protected void addUser(User user){
        this.users.add(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(name,role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, users);
    }


    @Override
    public String getAuthority() {
        return name.toString();
    }
}
