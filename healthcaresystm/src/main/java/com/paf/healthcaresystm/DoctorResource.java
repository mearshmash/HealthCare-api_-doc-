package com.paf.healthcaresystm;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("doctors")
public class DoctorResource {
	
	DoctorRepository repo = new DoctorRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	
	public List<Doctor> getDoctors() {
		
		System.out.println("getDoctorcalled");
		 
		 return repo.getDoctors(); 
	}
	
	@GET
	@Path("doctor/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})// server to client
	
	public Doctor getDoctor(@PathParam("id") int id)
	{
		return repo.getDoctor(id);
	}

	@POST
	@Path("doctor")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})  //from client (data) -> server
	public Doctor createDoctor(Doctor d1)
	{
		System.out.println(d1);
		repo.create(d1);
		
		return d1; 
	}
	
	@PUT
	@Path("doctor")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})  //from client (data) -> server
	public Doctor updateDoctor(Doctor d1)
	{
		System.out.println(d1);
		
		if(repo.getDoctor(d1.getId()).getId()==0)
		{
     		repo.create(d1);
		}else
		{
			repo.update(d1);
		}
		return d1;
	}
	
	@DELETE
	@Path("doctor/{id}")
	public Doctor DeleteDoctor(@PathParam("id") int d)
	{
		Doctor d = repo.getDoctor(id);
		
		if(d.getId()!=0)
			repo.delete(id);
		
		return d;
	}
}
