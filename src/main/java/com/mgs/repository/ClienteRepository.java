package com.mgs.repository;

import com.mgs.entity.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long>{
    List<Cliente> findByName(String name);
}
