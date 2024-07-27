package model;

import javax.ejb.Remote;

import entity.Details;
@Remote
public interface UserRemote {
	public String InsertData(Details D) throws Exception ;

	public Details getUserByUsername(String username);

	public boolean verifyPassword(String password, String password2);
}
