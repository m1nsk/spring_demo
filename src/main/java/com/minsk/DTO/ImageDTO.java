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
public class ImageDTO {
    private int id;
    private String name;
}
