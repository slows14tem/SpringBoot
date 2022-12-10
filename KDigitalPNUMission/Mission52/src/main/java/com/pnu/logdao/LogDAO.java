package com.pnu.logdao;

public interface LogDAO {
	
	void addlog(String method, String sql, boolean success);

}
