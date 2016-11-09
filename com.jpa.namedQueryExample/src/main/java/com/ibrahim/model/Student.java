package com.ibrahim.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "StudentDetail_NamedQuery")
@NamedQueries({ 
	    @NamedQuery(name = "StudentDetail.findAll", query = "SELECT c FROM Student c"),
		@NamedQuery(name = "StudentDetail.findByID", query = "SELECT c FROM Student c WHERE c.id=:id"),
		@NamedQuery(name = "StudentDetail.deleteByID", query = "DELETE FROM Student WHERE id=:id") })
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private int no;
	@Column(name = "AddDate", updatable = false)
	private Date addDate;
	@Column(name = "UpdateDate")
	private Date updateDate;

	public Student() {

	}

	public Student(long id, String name, String surname, int no, Date addDate, Date updateDate) {

		this.id = id;
		this.name = name;
		this.surname = surname;
		this.no = no;
		this.addDate = addDate;
		this.updateDate = updateDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", no=" + no + ", addDate=" + addDate
				+ ", updateDate=" + updateDate + "]";
	}

}
