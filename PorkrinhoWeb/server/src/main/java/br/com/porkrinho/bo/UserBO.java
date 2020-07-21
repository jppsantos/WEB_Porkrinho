package br.com.porkrinho.bo;

import java.util.List;

import com.google.gson.Gson;

import br.com.porkrinho.bean.UserBean;
import br.com.porkrinho.dao.UserDAO;

public class UserBO {
	private static UserDAO userDAO = new UserDAO();
	private static Gson gson = new Gson();
	
	public String addUser(UserBean user) {
		if(userDAO.add(user)) {
			return gson.toJson("ok");
		} else {
			return gson.toJson("Erro ao adicionar usuário!");
		}
	}

	public String updateUser(UserBean user) {
    if(userDAO.update(user)) {
      return gson.toJson("ok");
    } else {
      return gson.toJson("Erro ao atualizar meta!");
    }
  }

  public String deleteUser(int id) {
    for(UserBean user : userDAO.getByInt("idUser", id)) {
      if(user.getIdUser() == id) {
        if(userDAO.delete(user)) {
          return gson.toJson("ok");
        } else {
          return gson.toJson("Erro ao deletar meta!");
        }
      }
    }
    return gson.toJson("Meta não encontrada!");
  }

  public List<UserBean> listAllUsers() {
    return userDAO.getAll();
  }

  public UserBean login(String cpf, String password) {
		UserBean user = new UserBean(cpf, password);
		
		for (UserBean userBean : userDAO.getByString("cpf", cpf)) {
			if(userBean.getCpf().equals(user.getCpf()) && userBean.getPassword().equals(user.getPassword()))
				return getUserByCpf(cpf);
		}
		return null;
  }
	
	public UserBean getUserById(int id) {
		for(UserBean user : userDAO.getByInt("idUser", id)) {
			if(user.getIdUser() == id) {
				return user;
			}
		}

		return null;
	}

	public UserBean getUserByCpf(String cpf) {
		for(UserBean user : userDAO.getByString("cpf", cpf)) {
			if(user.getCpf().equals(cpf)) {
				return user;
			}
		}

		return null;
	}
}