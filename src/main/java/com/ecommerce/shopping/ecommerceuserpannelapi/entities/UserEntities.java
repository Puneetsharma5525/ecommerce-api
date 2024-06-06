package com.ecommerce.shopping.ecommerceuserpannelapi.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Builder
@Data
public class UserEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Username is required!")
    @Size(min = 3, max = 12, message = "Username must be between 3 and 12 characters")
    private String username;
    @NotBlank(message = "Mobile No. is required!")
    @Column(unique = true)
    private String mobile;
    @Email(regexp = "^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$", message = "Invalid Email !!")
    @Column(unique = true)
    @NotBlank(message = "Email is required!")
    private String email;
    private String role;
    @NotBlank(message = "Password is required!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$",
            message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character.")
    @Column(length = 1000)
    private String passWord;
    @Column(length = 1000)
    private String accessToken;
    private String profilePhoto;
    private String walletAmount;
    private String latitude;
    private String longitude;
    private String deviceName;
    private String ios_device_id;
    private String android_device_id;
    private String deviceType;
    private String mobileVerification;
    private String pushNotification;
    private List<GrantedAuthority> authorities;
    private String status;
    private String createAt;
    private String updateAt;
    @PrePersist
    public void prePersist() {
        String current = LocalDateTime.now().toString();
        this.createAt = current;
        this.updateAt = current;
    }

    @PreUpdate
    public void preUpdate() {
        this.updateAt = LocalDateTime.now().toString();
    }
}
