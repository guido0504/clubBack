package com.login.entity;

import com.login.model.UserRoleId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_roles")
@IdClass(UserRoleId.class)
public class UserRoleEntity implements Serializable {

    @Id
    @Column(nullable = false)
    private String username;

    @Id
    @Column(nullable = false)
    private String role;

    @Column(name="granted_date",nullable = false,columnDefinition = "TIMESTAMP")
    private LocalDateTime grantedDate;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name="username", referencedColumnName = "username")
    private UserEntity user;

    public UserRoleEntity() {

    }

    public UserRoleEntity(UserEntity username, String role) {
        this.user = username;
        this.role = role;
        this.grantedDate = LocalDateTime.now();
        this.username = username.getUsername();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getGrantedDate() {
        return grantedDate;
    }

    public void setGrantedDate(LocalDateTime grantedDate) {
        this.grantedDate = grantedDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
