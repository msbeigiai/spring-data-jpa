package com.msbeigi.springdatajpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "student")
@Table(name = "student", uniqueConstraints = {
      @UniqueConstraint(name = "student_email_unique", columnNames = "email")
})
public class Student {

   @Id
   @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
   @Column(name = "id", updatable = false)
   private Long id;

   @Column(name = "first_name", nullable = false, columnDefinition = "text")
   private String firstname;

   @Column(name = "last_name", nullable = false, columnDefinition = "text")
   private String lastname;

   @Column(name = "email", nullable = false, columnDefinition = "text")
   private String email;

   @Column(name = "age", nullable = false)
   private Integer age;

   @OneToOne(mappedBy = "student", orphanRemoval = true)
   private StudentIdCard studentIdCard;

   @OneToMany(mappedBy = "student", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
   private List<Book> books = new ArrayList<>();

   @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "student")
   private List<Enrolment> enrolments = new ArrayList<>();

   public Student() {
   }

   public Student(String firstname, String lastname, String email, Integer age) {
      this.firstname = firstname;
      this.lastname = lastname;
      this.email = email;
      this.age = age;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstname() {
      return firstname;
   }

   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   public String getLastname() {
      return lastname;
   }

   public void setLastname(String lastname) {
      this.lastname = lastname;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Integer getAge() {
      return age;
   }

   public void setAge(Integer age) {
      this.age = age;
   }

   public void addBook(Book book) {
      if (!this.books.contains(book)) {
         this.books.add(book);
         book.setStudent(this);
      }
   }

   public void removeBook(Book book) {
      if (this.books.contains(book)) {
         this.books.remove(book);
         book.setStudent(null);
      }
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
      result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      result = prime * result + ((age == null) ? 0 : age.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Student other = (Student) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      if (firstname == null) {
         if (other.firstname != null)
            return false;
      } else if (!firstname.equals(other.firstname))
         return false;
      if (lastname == null) {
         if (other.lastname != null)
            return false;
      } else if (!lastname.equals(other.lastname))
         return false;
      if (email == null) {
         if (other.email != null)
            return false;
      } else if (!email.equals(other.email))
         return false;
      if (age == null) {
         if (other.age != null)
            return false;
      } else if (!age.equals(other.age))
         return false;
      return true;
   }

   @Override
   public String toString() {
      return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", age="
            + age + "]";
   }

}
