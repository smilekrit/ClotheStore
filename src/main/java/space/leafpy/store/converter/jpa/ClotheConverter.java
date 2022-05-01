package space.leafpy.store.converter.jpa;

import org.modelmapper.ModelMapper;
import space.leafpy.store.dto.ClotheDto;
import space.leafpy.store.entity.ClotheEntity;


@Converter
public class ClotheConverter extends AbstractConverter<ClotheEntity, ClotheDto> {
    public ClotheConverter(ModelMapper modelMapper){
          super(ClotheEntity.class, ClotheDto.class,modelMapper);
    }
}
