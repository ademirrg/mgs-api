package com.mgs.repository;

import com.mgs.entity.Costumer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CostumerRepository extends JpaRepository <Costumer, Long>{
    List<Costumer> findByName(String name);
    Costumer findByEmail(String email);
    Costumer findByCpf(String cpf);
}
