package space.leafpy.store.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import space.leafpy.store.dto.ClotheDto;
import space.leafpy.store.entity.ClotheEntity;
import space.leafpy.store.service.ClotheService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clothe")
public class ClotheController {


    private final ClotheService service;


    @PostMapping
    public ClotheDto addToStorage(@RequestBody ClotheDto clotheEntity){
        return service.saveToStorage(clotheEntity);
    }

    @PostMapping("/all")
    public List<ClotheDto> addToStorageAll(@RequestBody List<ClotheDto> clotheDtoes){
        return service.saveToStorageAll(clotheDtoes);
    }

    @GetMapping("/{id}")
    public ClotheDto getFromStorage(@PathVariable int id){
        return service.showFromStorageById(id);
    }

    @GetMapping("/all")
    public List<ClotheDto> getAllFromStorage(){
        return service.showAll();
    }

    @GetMapping("/name/{name}")
    public List<ClotheDto> getFromStorageByName(@PathVariable String name){
        return service.showFromStorageByName(name);
    }

    @PutMapping
    public ClotheDto updateClothe(@RequestBody ClotheDto clotheDto){
        return service.updateClothe(clotheDto);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        return service.deleteClothe(id);
    }
}
