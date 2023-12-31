package com.msbeigi.springdatajpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Cource")
@Table(name = "course")
public class Course {

   @Id
   @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
   @Column(name = "id", updatable = false)
   private Long id;

   @Column(name = "name", nullable = false, columnDefinition = "TEXT")
   private String name;

   @Column(name = "department", nullable = false, columnDefinition = "TEXT")
   private String department;

   @OneToMany(mappedBy = "course", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
   private List<Enrolment> enrolments = new ArrayList<>();

   public Course() {
   }

   public Course(String name, String department) {
      this.name = name;
      this.department = department;
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

   public String getDepartment() {
      return department;
   }

   public void setDepartment(String department) {
      this.department = department;
   }

   public List<Enrolment> getEnrolments() {
      return enrolments;
   }

   public void setEnrolments(List<Enrolment> enrolments) {
      this.enrolments = enrolments;
   }

   @Override
   public String toString() {
      return "Course [id=" + id + ", name=" + name + ", department=" + department + "]";
   }

}
