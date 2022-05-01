package space.leafpy.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import space.leafpy.store.converter.jpa.ClotheConverter;
import space.leafpy.store.dto.ClotheDto;
import space.leafpy.store.entity.ClotheEntity;
import space.leafpy.store.exception.HTTPException;
import space.leafpy.store.repository.StoreRepository;

import java.util.List;
import java.util.Objects;


@Service
public class ClotheService {

    @Autowired
    private StoreRepository repository;

    @Autowired
    private ClotheConverter converter;


    public ClotheDto saveToStorage(ClotheDto clotheDto) {
        ClotheEntity clotheEntity = ClotheEntity.builder()
                .color(clotheDto.getColor())
                .name(clotheDto.getName())
                .type(clotheDto.getType())
                .price(clotheDto.getPrice())
                .build();

        return converter.toDto(repository.save(clotheEntity));

    }
    public List<ClotheDto> saveToStorageAll(List<ClotheDto> clotheDtos){
        return converter.toDto(repository.saveAll(converter.toEntity(clotheDtos)));
    }

    public List<ClotheDto> showAll(){
        return converter.toDto(repository.findAll());
    }

    public ClotheDto showFromStorageById(int id){
        return converter.toDto(repository.getById(id));
    }

    public List<ClotheDto>  showFromStorageByName(String name){
        return converter.toDto(repository.findByName(name));
    }

    public String deleteClothe(int id){
        repository.deleteById(id);
        return id + "successfully deleted";
    }

    public ClotheDto updateClothe(ClotheDto clotheDto){
/*
        TshirtEntity build1 = TshirtEntity.builder()
                .color("white")
                .name("Adidas")
                .type("shirt")
                .price(45)
                .build();
        TshirtEntity build2 = TshirtEntity.builder()
                .color("black")
                .name("Nike")
                .type("T-shirt")
                .price(78)
                .build();
        List<TshirtEntity> ls = new ArrayList<>();
        ls.add( build1);
        ls.add( build2);
        List<TshirtEntity> white = ls.stream()
                .filter(tshirtEntity -> tshirtEntity.getColor().equals("white"))
                .toList();

        List<String> collect = ls.stream()
                .map(TshirtEntity::getName)
                .toList();
        List<TshirtEntity> a = ls.stream()
                .peek(tshirtEntity -> tshirtEntity.setName("a")).toList();

 */
        if(Objects.isNull(clotheDto.getId())){
            throw new HTTPException("Clothe id is required field", HttpStatus.FORBIDDEN);
        }
        return repository.findById(clotheDto.getId())
                .map(existingEntity -> {
                    if(Objects.nonNull(clotheDto.getColor())){
                        existingEntity.setColor(clotheDto.getColor());
                    }
                    if(Objects.nonNull(clotheDto.getName())){
                        existingEntity.setName(clotheDto.getName());
                    }
                    if(Objects.nonNull(clotheDto.getType())){
                        existingEntity.setType(clotheDto.getType());
                    }
                    if(Objects.nonNull(clotheDto.getPrice())){
                        existingEntity.setPrice(clotheDto.getPrice());
                    }

                    return converter.toDto(repository.save(existingEntity));
                } ).
                orElseThrow(()->new HTTPException("Clothe by id not found", HttpStatus.NOT_FOUND));

    }
}
