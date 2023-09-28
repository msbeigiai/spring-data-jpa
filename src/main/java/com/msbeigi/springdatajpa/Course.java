package com.msbeigi.springdatajpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

   @ManyToMany(mappedBy = "courses")
   private List<Student> students = new ArrayList<>();

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

   public List<Student> getStudents() {
      return students;
   }

   public void setStudents(List<Student> students) {
      this.students = students;
   }

   @Override
   public String toString() {
      return "Course [id=" + id + ", name=" + name + ", department=" + department + "]";
   }

}
