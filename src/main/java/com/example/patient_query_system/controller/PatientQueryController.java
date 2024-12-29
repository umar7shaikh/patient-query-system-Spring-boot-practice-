package com.example.patient_query_system.controller;

import com.example.patient_query_system.model.PatientQuery;
import com.example.patient_query_system.repository.PatientQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Marks this as a REST Controller
@RestController
@RequestMapping("/api/patient-queries")
public class PatientQueryController {

    // Inject the repository
    @Autowired
    private PatientQueryRepository repository;

    // GET: Fetch all queries
    @GetMapping
    public List<PatientQuery> getAllQueries() {
        return repository.findAll();
    }

    // GET: Fetch a query by ID
    @GetMapping("/{id}")
    public Optional<PatientQuery> getQueryById(@PathVariable Long id) {
        return repository.findById(id);
    }

    // POST: Add a new query
    @PostMapping
    public PatientQuery createQuery(@RequestBody PatientQuery query) {
        return repository.save(query);
    }

    // PUT: Update an existing query
    @PutMapping("/{id}")
    public PatientQuery updateQuery(@PathVariable Long id, @RequestBody PatientQuery updatedQuery) {
        return repository.findById(id).map(query -> {
            query.setQuestion(updatedQuery.getQuestion());
            query.setResponse(updatedQuery.getResponse());
            return repository.save(query);
        }).orElseThrow(() -> new RuntimeException("Query not found with id " + id));
    }

    // DELETE: Delete a query by ID
    @DeleteMapping("/{id}")
    public void deleteQuery(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
