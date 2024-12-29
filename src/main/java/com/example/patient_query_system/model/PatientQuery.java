package com.example.patient_query_system.model;

import jakarta.persistence.Entity; // Import JPA annotations
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Marks this class as a database entity
@Entity
public class PatientQuery {

    // Primary Key (ID)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    // Fields for storing patient query and response
    private String question;  // Patient's question
    private String response;  // Automated response

    // Default constructor (required by JPA)
    public PatientQuery() {}

    // Parameterized constructor
    public PatientQuery(String question, String response) {
        this.question = question;   // Assign values using 'this'
        this.response = response;
    }

    // Getters and Setters for 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters and Setters for 'question'
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    // Getters and Setters for 'response'
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
