package com.lockerfoot.app.repository;

import com.lockerfoot.app.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Long> {
    // Spring Data JPA secara otomatis menyediakan metode CRUD dasar
    // Kamu juga bisa menambahkan metode kueri khusus di sini, misalnya:
    // List<Shoe> findByBrand(String brand);
    // List<Shoe> findByNameContainingIgnoreCase(String name);
}