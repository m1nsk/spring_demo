package com.minsk.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by korolm on 24.12.2017.
 */
@Getter
@Setter
@Component
public class CategoryDTO {
    private int id;
    private String name;
}
