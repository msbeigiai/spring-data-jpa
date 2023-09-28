package com.msbeigi.springdatajpa;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Book")
@Table(name = "book")
public class Book {

   @Id
   @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
   @Column(name = "id", updatable = false)
   private Long id;

   @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
   private LocalDateTime createdAt;

   @Column(name = "book_name", nullable = false)
   private String bookName;

   @ManyToOne
   @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "student_book_fk"))
   private Student student;

   public Book() {
   }

   public Book(LocalDateTime createdAt, String bookName, Student student) {
      this.createdAt = createdAt;
      this.bookName = bookName;
      this.student = student;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public LocalDateTime getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
   }

   public String getBookName() {
      return bookName;
   }

   public void setBookName(String bookName) {
      this.bookName = bookName;
   }

   public Student getStudent() {
      return student;
   }

   public void setStudent(Student student) {
      this.student = student;
   }

   @Override
   public String toString() {
      return "Book [id=" + id + ", createdAt=" + createdAt + ", bookName=" + bookName + ", student=" + student + "]";
   }

}
