package damdorani.dandulendar.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@DynamicInsert
public class User {
    @Id
    private String user_id;
    private String user_name;
    private String phone;
    private String email;
    private String provider;
    private String couple_code;

    private LocalDateTime reg_dt;
    private LocalDateTime mod_dt;

    @PrePersist
    public void createdAt(){
        this.reg_dt = LocalDateTime.now();
        this.mod_dt = LocalDateTime.now();
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<UserGroup> userGroups = new ArrayList<>();

    protected User() {}
}
