package br.com.porkrinho.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.porkrinho.bean.DonationBean;
import br.com.porkrinho.bo.DonationBO;

import java.util.List;

@Path("/donation")
public class DonationService {
  private static DonationBO donationBO = new DonationBO();
  private static Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();

  @GET
  @Path("/getbyid/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getUserById(@PathParam("id") int id) {
    try {
      DonationBean donation = donationBO.getDonationById(id);
      if(donation != null) {
        String json = gson.toJson(donation);
        return json;
      }

      return gson.toJson("Doacao não encontrado!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @POST
  @Path("/getbyid")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String getUserByIdPost(String id) {
    try {
      DonationBean donation = donationBO.getDonationById(Integer.parseInt(id));
      if(donation != null) {
        String json = gson.toJson(donation);
        return json;
      }

      return gson.toJson("Doacao não encontrado!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String addDonation(String json) {
    try {
      DonationBean donation = gson.fromJson(json, DonationBean.class);
      String result = donationBO.addDonation(donation);

      return result;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public String updateMark(@PathParam("id") int id, String json) {
    try {
      String result = "Doacao não encontrado!";
      DonationBean donation = gson.fromJson(json, DonationBean.class);
      donation.setIdDonation(id);
      for(DonationBean donationBean : donationBO.listAllDonations()) {
        if(donationBean.getIdDonation() == id) {
          result = donationBO.updateDonation(donation);
          return gson.toJson(result);
        }
      }

      return result;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @DELETE
  @Path("/{id}")
  public String deleteGoal(@PathParam("id") int id) {
    try {
      String result = donationBO.deleteDonation(id);
      return result;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAll() {
    try {
      List<DonationBean> donations = donationBO.listAllDonations();
      if(donations.isEmpty()) {
        return gson.toJson("Não há doacoes cadastradas!");
      }

      String json = gson.toJson(donations);
      return json;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }
}