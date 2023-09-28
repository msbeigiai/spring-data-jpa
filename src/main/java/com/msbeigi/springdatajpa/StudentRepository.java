package com.msbeigi.springdatajpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
   Optional<Student> findStudentByEmail(String email);

   List<Student> findByFirstnameEqualsAndAgeEquals(String firstname, Integer age);

   @Query(value = "SELECT * from student where email = ?1 and age <= ?2", nativeQuery = true)
   List<Student> findStudentByFirstNameAndAgeIsGreaterThan(String firstname, Integer age);

   @Transactional
   @Modifying
   @Query(value = "delete from student where id = ?1", nativeQuery = true)
   int deleteStudentById(Long id);
}
