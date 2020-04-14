package com.restful;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.annotation.Resource;
import javax.persistence.*;
import javax.transaction.*;
import javax.xml.bind.JAXB; //for common JAXB op
import javax.xml.bind.annotation.XmlRootElement;

import com.entity.Survey;

//GET   http://localhost:8080/swe645-restful-api/webresources/survey
@Path("survey")
public class SurveyResource{
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SurveyUnit");
	
	public SurveyResource() {}
	
	@GET
	@Produces({"application/json","application/xml"})
	public List<Survey> findAll(){
		List<Survey> surveyList = null;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT s FROM Survey s");
		surveyList = query.getResultList();
		em.close();
		for(Survey temp : surveyList) {
			System.out.printf("%s \n",temp.getInfo());
		}
		return surveyList;
	}
	
	
	@POST
	@Path("create")
	@Consumes({"*/*"})
	public Survey createSurvey(@FormParam("fName")String fName,
								@FormParam("lName")String lName,
								@FormParam("address")String address
//								@FormParam("city")String city,
//								@FormParam("state")String state,
//								@FormParam("zip")String zip,
//								@FormParam("phone")String phone,
//								@FormParam("email")String email,
//								@FormParam("date")String date
								) {
		Survey newSurvey = new Survey();
		newSurvey.setInfo(fName, lName, address);

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(newSurvey);
		em.getTransaction().commit();
		em.close();
		return newSurvey;
	}
	

	
	
}


