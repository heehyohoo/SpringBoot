package entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "schedule_user")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    @Column
    private String email;

    @Column
    private String password;

    @OneToMany
    @OrderBy("date DESC")
    private List<Schedule> schedules;

}
