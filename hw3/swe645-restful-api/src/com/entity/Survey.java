package com.entity;

import javax.annotation.Resource;
import javax.persistence.*;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.ws.rs.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "SUR_TBL")
@XmlRootElement
@NamedQueries({
			@NamedQuery(name="Survey.findAll",query="SELECT s FROM Survey s")
//			@NamedQuery(name="Survey.findAddress",query="SELECT s FROM SUR_TBL WHERE s.address=:address") 
})
public class Survey implements java.io.Serializable{
	
	

	//Natural key
	@Id
	@Column(name="F_NAME",length=255 ,nullable=false)
	private String fName;
	@Column(name="L_NAME",length=255 ,nullable=false)
	private String lName;
	@Column(name="ADDRESS",length=255 ,nullable=false)
	private String address;
//	@Column(name="CITY",length=255 ,nullable=false)
//	private String city;
//	@Column(name="STATE",length=255 ,nullable=false)
//	private String state;
//	@Column(name="ZIP",length=255 ,nullable=false)
//	private String zip;
//	@Column(name="PHONE",length=255 ,nullable=false)
//	private String phone;
//	@Column(name="EMAIL",length=255 ,nullable=false)
//	private String email;
//	@Column(name="DATE",length=255 ,nullable=false)
//	private String date;

	
	
	public void setInfo(String fName, String lName, String address
			//,String city, String state, String zip, String phone
			//,String email, String date, int campus, int reason, int likelihood
			) {
				this.fName = fName;
				this.lName = lName;
				this.address = address;
				//this.city = city;
				//this.state = state;
				//this.zip = zip;
				//this.phone = phone;
				//this.email = email;
				//this.date = date;
				//this.campus = campus;
				//this.reason = reason;
				//this.likelihood = likelihood;
	
				}
	public String getInfo() {
		return this.fName+" "+this.lName+" "+this.address;
	}
}
