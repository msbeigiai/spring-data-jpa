package com.msbeigi.springdatajpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.github.javafaker.Faker;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			// generateRandomStudents(studentRepository);

		};
	}

	private void getPage(StudentRepository studentRepository) {
		PageRequest pageRequest = PageRequest.of(0, 20, Sort.by("firstname").ascending());
		Page<Student> page = studentRepository.findAll(pageRequest);
		System.out.println(page);
	}

	private void generateRandomStudents(StudentRepository studentRepository) {
		Faker faker = new Faker();
		FakeStudent fakeStudent = new FakeStudent(faker);
		List<Student> students = fakeStudent.generateStudents();
		studentRepository.saveAll(students);
	}

	private void getSort(StudentRepository studentRepository) {
		Sort sort = Sort.by(Sort.Direction.ASC, "firstname").and(Sort.by("age")).descending();
		studentRepository.findAll(sort)
				.forEach(s -> System.out.println(s.getFirstname() + " " + s.getAge()));
	}

}
