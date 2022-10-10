package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.domain.Slider;

@Repository
public interface SliderRepository extends JpaRepository<Slider, Long>{

}
