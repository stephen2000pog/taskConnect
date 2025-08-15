package com.stephen.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AdminDTO extends UserDTO {
    private List<String> permissions;
}

