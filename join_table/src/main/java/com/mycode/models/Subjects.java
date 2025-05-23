package com.mycode.models;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Subjects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subject_id;
	
	 private String subjectName;

	    private String subjectCode;

	    @ManyToMany(mappedBy = "subject")
	    private Set<Coordinator> coordinators;

	    // ✅ Use only business keys or immutable fields here
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Subjects)) return false;
	        Subjects subject = (Subjects) o;
	        return Objects.equals(subjectName, subject.subjectName) &&
	               Objects.equals(subjectCode, subject.subjectCode);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(subjectName, subjectCode);
	    }
	}