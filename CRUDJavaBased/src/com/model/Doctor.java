package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "doctor")
public class Doctor {
	@Id 
	@Column (name ="doc_id")
	private int docid;
	@Column (name ="doc_name")
	private String docname;
	@Column (name ="doc_degree")
	private String docdegree;
	@Column (name ="doc_speciality")
	private String speciality;
	
	@Override
	public String toString() {
		return "Doctor data\n"+"ID=" + docid + "\nName=" + docname + "\nDegree=" + docdegree + "\nSpeciality="
				+ speciality;
	}
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getDocdegree() {
		return docdegree;
	}
	public void setDocdegree(String docdegree) {
		this.docdegree = docdegree;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
}
