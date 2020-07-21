package br.com.porkrinho.bo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.com.porkrinho.bean.GoalBean;
import br.com.porkrinho.dao.GoalDAO;

public class GoalBO {
  private static GoalDAO goalDAO = new GoalDAO();
  private static Gson gson = new Gson();

  public String addGoal(GoalBean goal) {
    if(goalDAO.add(goal)) {
      return gson.toJson("ok");
		} else {
			return gson.toJson("Erro ao cadastrar meta!");
		}
  }

  public String updateGoal(GoalBean goal) {
    if(goalDAO.update(goal)) {
      return gson.toJson("ok");
    } else {
      return gson.toJson("Erro ao atualizar meta!");
    }
  }

  public String deleteGoal(int id) {
    for(GoalBean goal : goalDAO.getByInt("idGoal", id)) {
      if(goal.getIdGoal() == id) {
        if(goalDAO.delete(goal)) {
          return gson.toJson("ok");
        } else {
          return gson.toJson("Erro ao deletar meta!");
        }
      }
    }
    return gson.toJson("Meta não encontrada!");
  }

  public List<GoalBean> listAllGoals() {
    return goalDAO.getAll();
  }

  public GoalBean getGoalById(int id) {
    for(GoalBean goal : goalDAO.getByInt("idGoal", id)) {
      if(goal.getIdGoal() == id) {
        return goal;
      }
    }
    return null;
  }

  public List<GoalBean> getUserGoalsById(int id) {
    return goalDAO.getByInt("idUser", id);
  }

  public List<GoalBean> getGoalByTitle(String title) {
    List<GoalBean> goals = new ArrayList<GoalBean>();

    for(GoalBean goal : goalDAO.getByString("title", title)) {
      if(goal.getTitle().toLowerCase().contains(title)) {
        goals.add(goal);
      }
    }

    return goals;
  }
}