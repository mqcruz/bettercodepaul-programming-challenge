package de.bcxp.challenge.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Country {
    String name;
    double population;
    double area;

    public double getPopulationDensity() {
        return population/area;
    }
}
