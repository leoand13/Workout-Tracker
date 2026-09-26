package com.workout.backend.repository;

import com.workout.backend.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciceRepository extends JpaRepository<Exercise, Long> {
}