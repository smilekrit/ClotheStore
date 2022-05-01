package space.leafpy.store.converter.jpa;

import java.util.List;

public interface ModelConverter<ENTITY, DTO> {

    List<DTO> toDto(Iterable<ENTITY> entities);

    DTO toDto(ENTITY entity);

    List<ENTITY> toEntity(Iterable<DTO> dtos);

    ENTITY toEntity(DTO dto);

    void map(ENTITY source, ENTITY destination);
}