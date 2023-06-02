package com.NseDataFeed.Repository;

import com.NseDataFeed.Entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {

    Optional<ProductImage> findByName(String fileName);
}
