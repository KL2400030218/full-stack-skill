package com.fsad.skill16.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Student model used in CRUD operations")
public class Student {

    @Schema(description = "Unique student id", example = "1")
    private Long id;

    @NotBlank(message = "Name is required")
    @Schema(description = "Student full name", example = "Keerthana")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    @Schema(description = "Student email address", example = "keerthana@example.com")
    private String email;

    @NotBlank(message = "Course is required")
    @Schema(description = "Course enrolled by the student", example = "React")
    private String course;

    public Student() {
    }

    public Student(Long id, String name, String email, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
