package br.com.porkrinho.controller;

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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.porkrinho.bean.GoalBean;
import br.com.porkrinho.bo.GoalBO;

@Path("/goal")
public class GoalService {
  private static GoalBO goalBO = new GoalBO();
  //private static Gson gson = new Gson();
  private static Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();

  @GET
  @Path("/getbyid/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getGoalById(@PathParam("id") int id) {
    try {
      GoalBean goal = goalBO.getGoalById(id);
      if(goal != null) {
        String json = gson.toJson(goal);
        return json;
      }

      return gson.toJson("Meta não encontrada!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @POST
  @Path("/getbyid")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String getGoalByIdPost(String id) {
    try {
      GoalBean goal = goalBO.getGoalById(Integer.parseInt(id));
      if(goal != null) {
        String json = gson.toJson(goal);
        return json;
      }

      return gson.toJson("Meta não encontrada!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @GET
  @Path("/getbytitle/{title}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getUserByTitle(@PathParam("title") String title) {
    try {
      List<GoalBean> goals = goalBO.getGoalByTitle(title);
      if(goals != null) {
        String json = gson.toJson(goals);
        return json;
      }

      return gson.toJson("Meta não encontrado!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @POST
  @Path("/getbytitle/{title}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String getUserByTitlePost(String title) {
    try {
      List<GoalBean> goals = goalBO.getGoalByTitle(title);
      if(goals != null) {
        String json = gson.toJson(goals);
        return json;
      }

      return gson.toJson("Meta não encontrado!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @POST
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public String addGoal(String json) {
    try {
      GoalBean goal = gson.fromJson(json, GoalBean.class);
      String result = goalBO.addGoal(goal);

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
      String result = "Meta não encontrada!";
      GoalBean goal = gson.fromJson(json, GoalBean.class);
      goal.setIdGoal(id);
      for(GoalBean goalBean : goalBO.listAllGoals()) {
        if(goalBean.getIdGoal() == id) {
          result = goalBO.updateGoal(goal);
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
      String result = goalBO.deleteGoal(id);
      return result;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllMarks() {
    try {
      List<GoalBean> goals = goalBO.listAllGoals();
      if(goals.isEmpty()) {
        return gson.toJson("Não há metas cadastradas!");
      }

      String json = gson.toJson(goals);
      return json;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }
}