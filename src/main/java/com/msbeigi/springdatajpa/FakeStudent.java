package com.msbeigi.springdatajpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.github.javafaker.Faker;

public class FakeStudent {

   private Integer generateStudent;
   private Integer generateStudentIdCard;

   private final Faker faker;

   public FakeStudent(Faker faker, Integer generateStudent, Integer generateStudentIdCard) {
      this.faker = faker;
      this.generateStudent = generateStudent;
      this.generateStudentIdCard = generateStudentIdCard;
   }

   public FakeStudent(Faker faker) {
      this(faker, 100, 100);
   }

   public List<Student> generateStudents() {
      Random random = new Random();
      List<Student> students = new ArrayList<>();

      for (int i = 0; i < generateStudent; i++) {
         String firstname = faker.name().firstName();
         String lastname = faker.name().lastName();
         String email = String.format("%s.%s@gmail.com", firstname.toLowerCase(), lastname.toLowerCase());
         Integer age = random.nextInt(20, 55);

         Student student = new Student(
               firstname,
               lastname,
               email,
               age);

         students.add(student);
      }
      return students;
   }

   public List<StudentIdCard> generateStudentIdCrad() {
      Random random = new Random();
      List<StudentIdCard> studentIdCars = new ArrayList<>();

      for (int i = 0; i < generateStudentIdCard; i++) {
         String cardNumber = UUID.randomUUID().toString();
         Integer studentId = random.nextInt(20, 55);

         StudentIdCard studentIdCard = new StudentIdCard(
               cardNumber);

         studentIdCars.add(studentIdCard);
      }
      return studentIdCars;
   }
}
