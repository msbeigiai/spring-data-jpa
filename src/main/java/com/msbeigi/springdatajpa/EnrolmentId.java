package com.msbeigi.springdatajpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnrolmentId implements Serializable {

   @Column(name = "student_id")
   private Long studentId;

   @Column(name = "course_id")
   private Long courseId;

   public EnrolmentId() {
   }

   public EnrolmentId(Long studentId, Long courseId) {
      this.studentId = studentId;
      this.courseId = courseId;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
      result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
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
      EnrolmentId other = (EnrolmentId) obj;
      if (studentId == null) {
         if (other.studentId != null)
            return false;
      } else if (!studentId.equals(other.studentId))
         return false;
      if (courseId == null) {
         if (other.courseId != null)
            return false;
      } else if (!courseId.equals(other.courseId))
         return false;
      return true;
   }

}
