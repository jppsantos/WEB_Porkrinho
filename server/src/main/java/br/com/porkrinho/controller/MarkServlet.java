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

import br.com.porkrinho.bean.MarkBean;
import br.com.porkrinho.bo.MarkBO;

@Path("/mark")
public class MarkServlet {
  private static MarkBO markBO = new MarkBO();
  private static Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
  
  @GET
  @Path("/getbyid/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getMarkById(@PathParam("id") int id) {
    try {
      MarkBean mark = markBO.getMarkById(id);
      if(mark != null) {
        String json = gson.toJson(mark);
        return json;
      }

      return gson.toJson("Meta não encontrada!");
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String addMark(String json) {
    try {
      MarkBean mark = gson.fromJson(json, MarkBean.class);
      String result = markBO.addMark(mark);

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
      MarkBean mark = gson.fromJson(json, MarkBean.class);
      mark.setIdMark(id);
      for(MarkBean markBean : markBO.listAllMarks()) {
        if(markBean.getIdMark() == id) {
          result = markBO.updateMark(mark);
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
  public String deleteMark(@PathParam("id") int id) {
    try {
      String result = markBO.deleteMark(id);
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
      List<MarkBean> marks = markBO.listAllMarks();

      String json = gson.toJson(marks);
      return json;
    } catch (Exception e) {
      return "ERROR: "+e;
    }
  }

}