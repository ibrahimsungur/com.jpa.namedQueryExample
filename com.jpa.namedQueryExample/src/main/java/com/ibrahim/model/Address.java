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
@Table(name = "Address_NamedQuery")
@NamedQueries({ 
	    @NamedQuery(name = "Address.findAll", query = "SELECT v FROM Address v"),
		@NamedQuery(name = "Address.findByID", query = "SELECT v FROM Address v WHERE v.id>:id"),
		@NamedQuery(name = "Address.deleteByID", query = "DELETE FROM Address WHERE id=:id") })
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String city;
	@Column
	private String district;
	@Column(name = "AddDate", updatable = false)
	private Date addDate;
	@Column(name = "UpdateDate")
	private Date updateDate;

	public Address() {

	}

	public Address(long id, String city, String district, Date addDate, Date updateDate) {

		this.id = id;
		this.city = city;
		this.district = district;
		this.addDate = addDate;
		this.updateDate = updateDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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
		return "Address [id=" + id + ", city=" + city + ", district=" + district + ", addDate=" + addDate
				+ ", updateDate=" + updateDate + "]";
	}

}
