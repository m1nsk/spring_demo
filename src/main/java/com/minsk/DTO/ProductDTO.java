package com.minsk.DTO;

/**
 * Created by korolm on 24.12.2017.
 */
import com.minsk.entity.entity.Category;
import com.minsk.entity.entity.Image;
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
public class ProductDTO {
    private int id;

    private String name;

    private String description;

    private BigDecimal price;

    private BigDecimal sale;

    private Boolean hot;

    private ImageDTO image;

    private Set<ImageDTO> images;

    private CategoryDTO category;

    public ImageDTO getImage() {
        return image;
    }

    public void setImage(ImageDTO image) {
        this.image = image;
    }

    public Set<ImageDTO> getImages() {
        return images;
    }

    public void setImages(Set<ImageDTO> images) {
        this.images = images;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}