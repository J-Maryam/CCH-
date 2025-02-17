package com.cch.entities;

import com.cch.entities.enums.StageType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Stage {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotNull
    private Integer number;

    @NotNull
    private String startLocation;

    @NotNull
    private String endLocation;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime startTime;

    @Enumerated(EnumType.STRING)
    private StageType stageType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StageResult> results = new HashSet<>();

    public Stage (Integer number, String startLocation, String endLocation, LocalDate date, LocalTime startTime, StageType stageType, Competition competition) {
        this.number = number;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.date = date;
        this.startTime = startTime;
        this.stageType = stageType;
        this.competition = competition;
    }
}