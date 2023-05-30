package com.example.week5hw21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private Integer id;
    @NotEmpty
    private String area;
    @NotEmpty
    private String street;
    @NotEmpty
    private String buildingNo;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
