package main.controllers.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Builder
public class ItemResponse {

    private Integer id;
    private String name;
    private Integer age;

}
