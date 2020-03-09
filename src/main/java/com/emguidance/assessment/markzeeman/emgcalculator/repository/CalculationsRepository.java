package com.emguidance.assessment.markzeeman.emgcalculator.repository;

import com.emguidance.assessment.markzeeman.emgcalculator.model.Calculation;
import org.springframework.data.repository.CrudRepository;

public interface CalculationsRepository extends CrudRepository<Calculation,Long> {
}
