package com.ibrahim.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ibrahim.model.Student;
import com.ibrahim.session.JpaEntityManagerFactory;

public class DeleteRecord {

	private static EntityManager entityManager = JpaEntityManagerFactory.buildEntityManager();
	private static EntityTransaction transaction = JpaEntityManagerFactory.transaction();

	public static void main(String[] args) {
	//	deleteStudent();
		//deleteStudentById(13);
		deleteStudentByIdQuery(11);
	}

	@SuppressWarnings("unused")
	private static void deleteStudent() {
		Student student = entityManager.getReference(Student.class, (long) 1);
		transaction.begin();
		entityManager.remove(student);
		transaction.commit();
	}

	@SuppressWarnings("unused")
	private static void deleteStudentById(long id) {
		Student student = entityManager.getReference(Student.class, id);
		transaction.begin();
		if (student != null)
			entityManager.remove(student);
		transaction.commit();
	}

	private static void deleteStudentByIdQuery(long id) {
		Query query = entityManager.createNamedQuery("StudentDetail.deleteByID");
		transaction.begin();
		query.setParameter("id", id);
		query.executeUpdate();
		transaction.commit();
	}
}
