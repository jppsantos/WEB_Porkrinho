package br.com.porkrinho.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;

import br.com.porkrinho.bean.MarkBean;
import br.com.porkrinho.bo.MarkBO;

@Path("/mark")
public class MarkServlet {
  private static MarkBO markBO = new MarkBO();
  private static Gson gson = new Gson();
  
  @POST
  @Path("/add")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String addUser(String json) {
    try {
      MarkBean mark = gson.fromJson(json, MarkBean.class);
      String result = markBO.addMark(mark);

      return result;
      //URI uri = URI.create(result);
      //return Response.seeOther(uri).build();
    } catch (Exception e) {
      //return Response.status(Status.BAD_REQUEST).entity("ERROR: "+e).build();
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