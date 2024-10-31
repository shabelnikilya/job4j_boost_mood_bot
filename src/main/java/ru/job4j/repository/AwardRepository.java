package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.entity.Award;

@Repository
public interface AwardRepository extends CrudRepository<Award, Long> {
}
