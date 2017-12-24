package com.minsk.DTO;

/**
 * Created by korolm on 24.12.2017.
 */
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by korolm on 24.12.2017.
 */
@Getter
@Setter
@Component
public class ShopDTO {
    private int id;

    private String name;

    private String address;

    private String workTime;

    private String phone;

    private String status;
}