package br.com.porkrinho.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.porkrinho.bean.BootyBean;
import br.com.porkrinho.bo.BootyBO;

@Path("/booty")
public class BootyService {
  private static BootyBO bootyBO = new BootyBO();
  private static Gson gson = new Gson();
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String addBooty(String json) {
    try {
      BootyBean booty = gson.fromJson(json, BootyBean.class);
      String result = bootyBO.addBooty(booty);

      return result;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllBootys() {
    try {
      List<BootyBean> bootys = bootyBO.listAllBootys();
      if(bootys.isEmpty()) {
        return gson.toJson("Não há saques cadastrados!");
      }

      String json = gson.toJson(bootys);
      return json;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }
}