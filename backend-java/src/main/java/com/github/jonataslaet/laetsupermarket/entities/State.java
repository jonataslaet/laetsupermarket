package com.github.jonataslaet.laetsupermarket.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "state", cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<City> cities = new ArrayList<>();
}
