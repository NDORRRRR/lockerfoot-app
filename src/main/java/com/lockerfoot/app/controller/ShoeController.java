package com.lockerfoot.app.controller;

import com.lockerfoot.app.model.Shoe;
import com.lockerfoot.app.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shoes")
public class ShoeController {

    private final ShoeService shoeService;

    @Autowired
    public ShoeController(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    // Endpoint untuk mendapatkan semua sepatu
    // GET http://localhost:8080/api/shoes
    @GetMapping
    public ResponseEntity<List<Shoe>> getAllShoes() {
        List<Shoe> shoes = shoeService.getAllShoes();
        return new ResponseEntity<>(shoes, HttpStatus.OK);
    }

    // Endpoint untuk mendapatkan sepatu berdasarkan ID
    // GET http://localhost:8080/api/shoes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Shoe> getShoeById(@PathVariable Long id) {
        Optional<Shoe> shoe = shoeService.getShoeById(id);
        return shoe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint untuk menambahkan sepatu baru
    // POST http://localhost:8080/api/shoes
    @PostMapping
    public ResponseEntity<Shoe> addShoe(@RequestBody Shoe shoe) {
        Shoe newShoe = shoeService.addShoe(shoe);
        return new ResponseEntity<>(newShoe, HttpStatus.CREATED);
    }

    // Endpoint untuk memperbarui sepatu yang sudah ada
    // PUT http://localhost:8080/api/shoes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Shoe> updateShoe(@PathVariable Long id, @RequestBody Shoe shoeDetails) {
        Shoe updatedShoe = shoeService.updateShoe(id, shoeDetails);
        if (updatedShoe != null) {
            return new ResponseEntity<>(updatedShoe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint untuk menghapus sepatu
    // DELETE http://localhost:8080/api/shoes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteShoe(@PathVariable Long id) {
        shoeService.deleteShoe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}