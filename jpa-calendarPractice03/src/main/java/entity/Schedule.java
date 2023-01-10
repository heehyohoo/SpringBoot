package entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Schedule {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;
    @Column
    private String date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    private User user;


}
