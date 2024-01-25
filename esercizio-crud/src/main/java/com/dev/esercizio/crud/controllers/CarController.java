package com.dev.esercizio.crud.controllers;

import com.dev.esercizio.crud.entities.CarEntity;
import com.dev.esercizio.crud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping("/createCar")
    public CarEntity createCar(@RequestBody CarEntity car) {
        CarEntity ca1 = carRepository.saveAndFlush(car);
        return ca1;
    }

    @GetMapping("/getAll")
    public List<CarEntity> listCar() {
        List<CarEntity> listCars = carRepository.findAll();
        return listCars;
    }

    @GetMapping("/getCar/{id}")
    public Optional<CarEntity> getCarById(@PathVariable Long id) {
        Optional<CarEntity> optionalCar = carRepository.findById(id);
        return carRepository.findById(id);
    }

    @PatchMapping("/updateType/{id}")
    public CarEntity updateTypeCar(@PathVariable long id, @RequestBody CarEntity updatedCar) {
        Optional<CarEntity> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            CarEntity existingCar = optionalCar.get();

            // Aggiorna solo se il nuovo tipo non è nullo
            if (updatedCar.getType() != null) {
                existingCar.setType(updatedCar.getType());
            }

            // Aggiungi altri aggiornamenti se necessario

            // Salva l'auto aggiornata nel repository
            return carRepository.saveAndFlush(existingCar);
        }

        // Se l'ID non è stato trovato, restituisci null o un nuovo CarEntity vuoto, a seconda delle tue esigenze
        return null;
    }


    @DeleteMapping("/deleteCar/{id}")
    public void deleteCar(@PathVariable Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
        }
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}
