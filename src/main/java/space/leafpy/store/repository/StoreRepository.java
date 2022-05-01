package space.leafpy.store.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.leafpy.store.entity.ClotheEntity;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<ClotheEntity,Integer> {

    List<ClotheEntity> findByName(String name);

}
