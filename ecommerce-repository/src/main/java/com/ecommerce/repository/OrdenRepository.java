package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.domain.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long>{

}
