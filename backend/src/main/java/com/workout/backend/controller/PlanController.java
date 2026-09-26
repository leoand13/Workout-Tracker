package com.workout.backend.controller;

import com.workout.backend.model.Plan;
import com.workout.backend.repository.PlanRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanController {

    private final PlanRepository planRepository;

    public PlanController(PlanRepository planRepository){
        this.planRepository = planRepository;
    }

    @GetMapping
    public List<Plan> getAll() {
        return planRepository.findAll();
    }

    @PostMapping
    public Plan create(@RequestBody Plan plan) {
        return planRepository.save(plan);
    }

    @PutMapping("/{id}")
    public Plan update(@PathVariable Long id, @RequestBody Plan updated) {
        Plan plan = planRepository.findById(id).orElseThrow();
        plan.setTitle(updated.getTitle());
        plan.setDescription(updated.getDescription());
        plan.setDay(updated.getDay());
        plan.setTime(updated.getTime());
        plan.setExercises(updated.getExercises());
        return planRepository.save(plan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        planRepository.deleteById(id);
    }
}