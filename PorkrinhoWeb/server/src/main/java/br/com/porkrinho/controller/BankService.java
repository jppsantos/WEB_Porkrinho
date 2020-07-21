package br.com.porkrinho.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;

import java.util.List;

import br.com.porkrinho.bean.BankBean;
import br.com.porkrinho.bo.BankBO;

@Path("/bank")
public class BankService {
  private static BankBO bankBO = new BankBO();
  private static Gson gson = new Gson();
  
  @GET
  @Path("/getbyid/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getBankById(@PathParam("id") int id) {
    try {
      BankBean bank = bankBO.getBankById(id);
      if(bank != null) {
        String json = gson.toJson(bank);
        return json;
      }

      return gson.toJson("Banco não encontrado!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @POST
  @Path("/getbyid")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String getBankByIdPost(String id) {
    try {
      BankBean bank = gson.fromJson(id, BankBean.class);
      bank = bankBO.getBankById(bank.getIdBank());
      if(bank != null) {
        String json = gson.toJson(bank);
        return json;
      }

      return gson.toJson("Banco não encontrado!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @GET
  @Path("/getbyname/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getBankByName(@PathParam("name") String name) {
    try {
      List<BankBean> banks = bankBO.getBankByName(name);
      if(banks.isEmpty()) {
        return gson.toJson("Banco não encontrado!");
      }

      String json = gson.toJson(banks);
      return json;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @POST
  @Path("/getbyname")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String getBankByNamePost(String name) {
    try {
      BankBean bank = gson.fromJson(name, BankBean.class);
      List<BankBean> banks = bankBO.getBankByName(bank.getName());
      if(banks.isEmpty()) {
        return gson.toJson("Banco não encontrado!");
      }

      String json = gson.toJson(banks);
      return json;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @GET
  @Path("/getbycode/{code}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getBankByCode(@PathParam("code") int code) {
    try {
      BankBean bank = bankBO.getBankByCode(code);
      if(bank != null) {
        String json = gson.toJson(bank);
        return json;
      }

      return gson.toJson("Banco não encontrado!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @POST
  @Path("/getbycode")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String getBankByCodePost(String code) {
    try {
      BankBean bank = gson.fromJson(code, BankBean.class);
      bank = bankBO.getBankByCode(bank.getCode());
      if(bank != null) {
        String json = gson.toJson(bank);
        return json;
      }

      return gson.toJson("Banco não encontrado!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllBanks() {
    try {
      BankBO bankBO = new BankBO();
      List<BankBean> banks = bankBO.listAllBanks();
      if(banks.isEmpty()) {
        return gson.toJson("Não há bancos cadastrados!");
      }
      
      String json = new Gson().toJson(banks);
      return json;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }
}