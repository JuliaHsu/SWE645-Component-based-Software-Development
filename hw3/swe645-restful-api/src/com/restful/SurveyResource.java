package com.restful;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.annotation.Resource;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.*;
import javax.xml.bind.JAXB; //for common JAXB op
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.transform.Transformers;

//import javax.ejb.Stateless;
import com.entity.Survey;

//GET   http://localhost:8080/swe645-restful-api/webresources/survey
//@Stateless
@Path("survey")
public class SurveyResource{
	@PersistenceContext(unitName = "SurveyUnit")
	private EntityManager em = Persistence.createEntityManagerFactory("SurveyUnit").createEntityManager();
	
	public SurveyResource() {}
	
	
	@GET
	@Produces({"application/json"})
	@Consumes({"*/*"})
	public List<Survey> findAll(){
		List<Survey> surveyList = null;
		surveyList = em.createQuery("SELECT s FROM Survey s").getResultList();
		em.close();
		
		return surveyList;
	}
	
	
	@POST
	@Path("create")
	@Consumes({"*/*"})
	public Survey createSurvey(@FormParam("fName")String fName,
								@FormParam("lName")String lName,
								@FormParam("address")String address,
								@FormParam("city")String city,
								@FormParam("state")String state,
								@FormParam("zip")String zip,
								@FormParam("phone")String phone,
								@FormParam("email")String email,
								@FormParam("date")String date,
								@FormParam("campus")String campus,
								@FormParam("reason")String reason,
								@FormParam("likelihood")String likelihood
								) {
		Survey newSurvey = new Survey();
		newSurvey.setFirstName(fName);
		newSurvey.setLastName(lName);
		newSurvey.setAddress(address);
		newSurvey.setCity(city);
		newSurvey.setState(state);
		newSurvey.setZip(zip);
		newSurvey.setPhone(phone);
		newSurvey.setEmail(email);
		newSurvey.setDate(date);
		newSurvey.setCampus(campus);
		newSurvey.setReason(reason);
		newSurvey.setLikelihood(likelihood);
		
		em.getTransaction().begin();
		em.persist(newSurvey);
		em.getTransaction().commit();
		em.close();
		return newSurvey;
	}
	

	
	
}


