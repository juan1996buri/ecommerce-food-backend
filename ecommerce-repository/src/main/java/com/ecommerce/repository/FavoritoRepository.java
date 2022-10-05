package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.domain.Favorito;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Long>{

}
