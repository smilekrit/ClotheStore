package space.leafpy.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClotheDto {

    private Integer id;
    private String name;
    private String type;
    private String color;
    private Integer price;


}
