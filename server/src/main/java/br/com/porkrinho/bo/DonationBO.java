package br.com.porkrinho.bo;

import java.util.List;

import com.google.gson.Gson;

import br.com.porkrinho.bean.DonationBean;
import br.com.porkrinho.dao.DonationDAO;

public class DonationBO {
  private static DonationDAO donationDAO = new DonationDAO();
  private static Gson gson = new Gson();

  public String addDonation(DonationBean donation) {
		if(donationDAO.add(donation)) {
			return gson.toJson("ok");
		} else {
			return gson.toJson("Erro ao adicionar usuário!");
		}
	}

	public String updateDonation(DonationBean donation) {
    if(donationDAO.update(donation)) {
      return gson.toJson("ok");
    } else {
      return gson.toJson("Erro ao atualizar meta!");
    }
  }

  public String deleteDonation(int id) {
    for(DonationBean donation : donationDAO.getByInt("idDonation", id)) {
      if(donation.getIdDonation() == id) {
        if(donationDAO.delete(donation)) {
          return gson.toJson("ok");
        } else {
          return gson.toJson("Erro ao deletar meta!");
        }
      }
    }
    return gson.toJson("Meta não encontrada!");
  }

  public List<DonationBean> listAllDonations() {
    return donationDAO.getAll();
  }

  public List<DonationBean> listAllGoalDonations(int id) {
    return donationDAO.getByInt("goal_idGoal",id);
  }

  

  public DonationBean getDonationById(int id) {
		for(DonationBean donation : donationDAO.getByInt("idDonation", id)) {
			if(donation.getIdDonation() == id) {
				return donation;
			}
		}

		return null;
  }
}