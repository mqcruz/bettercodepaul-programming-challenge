package de.bcxp.challenge.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Weather {
    int day;
    double maxTemp;
    double minTemp;
}
