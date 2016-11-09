package com.ibrahim.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ibrahim.model.Student;
import com.ibrahim.session.JpaEntityManagerFactory;

public class ReadRecord {

	private static EntityManager entityManager = JpaEntityManagerFactory.buildEntityManager();

	public static void main(String[] args) {
		//readStudentByID(1);
		readStudentByQuery();
		//readStudentByQueryID(1);

	}

	private static void readStudentByID(long id) {
		Student student = entityManager.find(Student.class, id);
		System.out.println(student);
	}

	public static void readStudentByQuery() {
		Query query = entityManager.createNamedQuery("StudentDetail.findAll");
		List<Student> students = query.getResultList();
		System.out.println("Student Sayisi:" + students.size());
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private static void readStudentByQueryID(long id) {
		Query query = entityManager.createNamedQuery("StudentDetail.findByID");
		query.setParameter("id", id);
		List<Student> students = query.getResultList();
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
