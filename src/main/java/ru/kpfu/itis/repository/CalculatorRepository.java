package ru.kpfu.itis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Calculator;

import java.util.Date;
import java.util.List;

@Repository
public interface CalculatorRepository  extends JpaRepository<Calculator, Long> {
    @Query(value = "from Calculator c where c.time < ?1")
    public List<Calculator> findAllByTime(Date dateTime);
}
