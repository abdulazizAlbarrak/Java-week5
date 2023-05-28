package com.example.week5hw21.TDO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressTDO {
    private Integer teacher_id;
    @NotEmpty
    private String area;
    @NotEmpty
    private String street;
    @NotEmpty
    private String buildingNo;
}
