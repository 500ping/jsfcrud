/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.UserDAO;
import entities.Users;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;

/**
 *
 * @author 500PING-PC
 */
@ManagedBean
@SessionScoped
public class UserController {

    UserDAO userDAO;
    List<Users> users;
    private Users currentUser;

    public UserController() {
        userDAO = new UserDAO();
    }

    public Users getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Users currentUser) {
        this.currentUser = currentUser;
    }

    public List<Users> getAll() {
        users = userDAO.getAll();
        return users;
    }
    
    public String createPage() {
        this.currentUser = new Users();
        return "createUser.xhtml?faces-redirect=true";
    }

    public String createUser() {
        userDAO.createUser(this.currentUser);
        return "index.xhtml?faces-redirect=true";
    }

    public String updatePage(int id) {
        this.currentUser = userDAO.getUserById(id);

        return "updateUser.xhtml?faces-redirect=true";
    }
    
    public String updateUser() {
        userDAO.updateUser(this.currentUser);
        return "index.xhtml?faces-redirect=true";
    }

    public void deleteUser(int id) {
        Users user = userDAO.getUserById(id);
        userDAO.deleteUser(user);
    }

}
