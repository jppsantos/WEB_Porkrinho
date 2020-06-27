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

import java.util.List;

import br.com.porkrinho.bean.UserBean;
import br.com.porkrinho.bo.UserBO;

@Path("/user")
public class UserService {
  private static UserBO userBO = new UserBO();
  private static Gson gson = new Gson();

  @GET
  @Path("/getbyid/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getUserById(@PathParam("id") int id) {
    try {
      UserBean user = userBO.getUserById(id);
      if(user != null) {
        String json = gson.toJson(user);
        return json;
      }

      return gson.toJson("Usuario não encontrado!");
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
      UserBean user = gson.fromJson(id, UserBean.class);
      user = userBO.getUserById(user.getIdUser());
      if(user != null) {
        String json = gson.toJson(user);
        return json;
      }

      return gson.toJson("Usuario não encontrado!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @GET
  @Path("/getbycpf/{cpf}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getUserByCpf(@PathParam("cpf") String cpf) {
    try {
      UserBean user = userBO.getUserByCpf(cpf);
      if(user != null) {
        String json = gson.toJson(user);
        return json;
      }

      return gson.toJson("Usuario não encontrado!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @POST
  @Path("/getbycpf")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String getUserByCpfPost(String cpf) {
    try {
      UserBean user = gson.fromJson(cpf, UserBean.class);
      user = userBO.getUserByCpf(user.getCpf());
      if(user != null) {
        String json = gson.toJson(user);
        return json;
      }

      return gson.toJson("Usuario não encontrado!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @POST
  @Path("/login")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String login(String json) {
    try {
      UserBean user = gson.fromJson(json, UserBean.class);
      String result = userBO.login(user.getCpf(), user.getPassword());
      return result;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String addUser(String json) {
    try {
      UserBean user = gson.fromJson(json, UserBean.class);
      String result = userBO.addUser(user);

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
      String result = "Usuario não encontrado!";
      UserBean user = gson.fromJson(json, UserBean.class);
      user.setIdUser(id);
      for(UserBean userBean : userBO.listAllUsers()) {
        if(userBean.getIdUser() == id) {
          result = userBO.updateUser(user);
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
      String result = userBO.deleteUser(id);
      return result;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllUsers() {
    try {
      List<UserBean> users = userBO.listAllUsers();
      if(users.isEmpty()) {
        return gson.toJson("Não há usuários cadastrados!");
      }

      String json = gson.toJson(users);
      return json;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }
}