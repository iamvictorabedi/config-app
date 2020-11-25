package com.kyosk.config.repository;

import java.util.List;

import com.kyosk.config.domain.Config;
import com.kyosk.config.service.dto.ConfigRequestDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import static com.kyosk.config.repository.ConfigSpecification.getSpecifications;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {
    Config findByName(String name);

    void deleteByName(String name);

   default List<Config> findByConfig(ConfigRequestDto searchParams) {
       return findAll(getSpecifications(searchParams));
    }

    List<Config> findAll(Specification<Config> specifications);

}
