package logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Control implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<User> misUsers;
	private static Control control;
	private static User LoginUser;
	
	private Control() {
		super();
		this.misUsers = new ArrayList<User>();
	}
	
	public static Control getInstance() {
		if(control == null) {
			control = new Control();
		}
		return control;
	}

	public ArrayList<User> getMisUsers() {
		return misUsers;
	}

	public void setMisUsers(ArrayList<User> misUsers) {
		this.misUsers = misUsers;
	}

	public static Control getControl() {
		return control;
	}

	public static void setControl(Control control) {
		Control.control = control;
	}

	public static User getLoginUser() {
		return LoginUser;
	}

	public static void setLoginUser(User loginUser) {
		Control.LoginUser = loginUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void regUser(User aux) {
		misUsers.add(aux);
	}

	public boolean confirmLogin(String username, String pass) {
		boolean login = false;
		for(User user : misUsers) {
			if(user.getUserName().equals(username) && user.getPass().equals(pass)) {
				LoginUser = user;
				login = true;
			}
		}
		return login;
	}
}
