package br.com.porkrinho.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;

import java.util.List;

import br.com.porkrinho.bean.BankBean;
import br.com.porkrinho.bo.BankBO;

@Path("bank")
public class BankServlet {
  
  @GET
  @Path("all")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllBanks() {
    try {
      BankBO bankBO = new BankBO();
      List<BankBean> banks = bankBO.listAllBanks();

      String json = new Gson().toJson(banks);
      return json;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }
}