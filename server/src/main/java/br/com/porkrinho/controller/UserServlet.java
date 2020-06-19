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

import br.com.porkrinho.bean.UserBean;
import br.com.porkrinho.bo.UserBO;

@Path("/user")
public class UserServlet {
  private static UserBO userBO = new UserBO();
  private static Gson gson = new Gson();

  @GET
  @Path("/{userId}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getUserById(@PathParam("userId") int id) {
    try {
      return userBO.getUserById(id);
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @GET
  @Path("/find/{userCpf}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getUserById(@PathParam("userCpf") String cpf) {
    try {
      return userBO.getUserByCpf(gson.fromJson(cpf, String.class));
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @POST
  @Path("add")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String addUser(String json) {
    try {
      UserBean user = gson.fromJson(json, UserBean.class);
      String result = userBO.addUser(user);

      return result;
      //URI uri = URI.create(result);
      //return Response.seeOther(uri).build();
    } catch (Exception e) {
      //return Response.status(Status.BAD_REQUEST).entity("ERROR: "+e).build();
      return "ERROR: "+e;
    }
  }

  @GET
  @Path("all")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllUsers() {
    try {
      List<UserBean> users = userBO.listAllUsers();

      String json = gson.toJson(users);
      return json;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }
}