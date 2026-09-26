package com.workout.backend.controller;

import com.workout.backend.model.Exercise;
import com.workout.backend.repository.ExerciseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@CrossOrigin(origins = "http://localhost:4200")
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;

    public ExerciseController(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping
    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }

    @PostMapping
    public Exercise create(@RequestBody Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @PutMapping("/{id}")
    public Exercise update(@PathVariable Long id, @RequestBody Exercise updated) {
        Exercise exercise = exerciseRepository.findById(id).orElseThrow();
        exercise.setTitle(updated.getTitle());
        exercise.setDescription(updated.getDescription());
        exercise.setCategory(updated.getCategory());
        exercise.setMuscleGroup(updated.getMuscleGroup());
        return exerciseRepository.save(exercise);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        exerciseRepository.deleteById(id);
    }
}