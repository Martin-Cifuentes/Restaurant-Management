package model;

public class User extends Employee{
	public String userName;
	public String password;
	/** 
	* this constructor calls the super method Employee to create a User
    * <b>pre:</b> it needs the normal Employee data and some extra User data
    * <b>post:</b> the objet User is crated
    * @param name String, name of the User
    * @param lastName String, last name of the User
    * @param id int, id number of the User
    * @param adress String, adress of the User
    * @param phone Stringn phone of the User
    * @param userName String, nickname of the User
    * @param phone String, phone of the User
    */
	public User(String n, String ln, int id, String a, int p,String un, String pa) {
		super(n, ln, id);
		this.userName = un;
		this.password = pa;
	}

}
