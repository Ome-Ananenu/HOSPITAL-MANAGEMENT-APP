package com.ome.springbootcrudoperation.model;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class PatientDto {

    @NotBlank(message = "First name is required.")
    private String firstName;
}
