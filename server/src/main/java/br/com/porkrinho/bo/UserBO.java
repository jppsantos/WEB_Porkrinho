package br.com.porkrinho.bo;

import java.util.List;

import com.google.gson.Gson;

import br.com.porkrinho.bean.UserBean;
import br.com.porkrinho.dao.UserDAO;

public class UserBO {
	private static UserDAO userDAO = new UserDAO();
	private static Gson gson = new Gson();

	public String addUser(UserBean user) {
		if(userDAO.addUser(user)) {
			return gson.toJson("ok");
		} else {
			return gson.toJson("Erro ao adicionar usuário!");
		}
	}

  public String login(String cpf, String password) {
		UserBean user = new UserBean(cpf, password);
		
		for (UserBean userBean : userDAO.getAllUsers()) {
			if(userBean.getCpf().equals(user.getCpf()) && userBean.getPassword().equals(user.getPassword()))
				return gson.toJson("ok");
		}
		return gson.toJson("Erro ao realizar login!");
  }
	
	public String getUserById(int id) {
		UserBean user = userDAO.getUserById(id);
		if(user != null) {
			String json = new Gson().toJson(user);
			return json;
		}
		return gson.toJson("Usuário não encontrado!");
	}

	public String getUserByCpf(String cpf) {
		List<UserBean> users = userDAO.getUserByCpf(cpf);
		if(users != null) {
			String json = new Gson().toJson(users);
			return json;
		}
		return gson.toJson("Usuário não encontrado!");
	}

  public List<UserBean> listAllUsers() {
    return userDAO.getAllUsers();
  }
}