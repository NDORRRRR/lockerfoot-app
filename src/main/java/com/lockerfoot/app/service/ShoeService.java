package com.lockerfoot.app.service;

import com.lockerfoot.app.model.Shoe;
import com.lockerfoot.app.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoeService {

    private final ShoeRepository shoeRepository;

    @Autowired
    public ShoeService(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    // Mendapatkan semua sepatu
    public List<Shoe> getAllShoes() {
        return shoeRepository.findAll();
    }

    // Mendapatkan sepatu berdasarkan ID
    public Optional<Shoe> getShoeById(Long id) {
        return shoeRepository.findById(id);
    }

    // Menambahkan sepatu baru
    public Shoe addShoe(Shoe shoe) {
        return shoeRepository.save(shoe);
    }

    // Memperbarui sepatu yang sudah ada
    public Shoe updateShoe(Long id, Shoe shoeDetails) {
        Optional<Shoe> optionalShoe = shoeRepository.findById(id);
        if (optionalShoe.isPresent()) {
            Shoe existingShoe = optionalShoe.get();
            existingShoe.setName(shoeDetails.getName());
            existingShoe.setBrand(shoeDetails.getBrand());
            existingShoe.setSize(shoeDetails.getSize());
            existingShoe.setPrice(shoeDetails.getPrice());
            existingShoe.setStock(shoeDetails.getStock());
            existingShoe.setDescription(shoeDetails.getDescription());
            existingShoe.setImageUrl(shoeDetails.getImageUrl());
            return shoeRepository.save(existingShoe);
        } else {
            // Atau lempar pengecualian jika sepatu tidak ditemukan
            return null; // Untuk saat ini, kita kembalikan null
        }
    }

    // Menghapus sepatu berdasarkan ID
    public void deleteShoe(Long id) {
        shoeRepository.deleteById(id);
    }
}