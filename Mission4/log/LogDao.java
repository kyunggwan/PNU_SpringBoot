package com.rubypaper.log;

public interface LogDao {

	void addLog(String method, String sqlstring, boolean success);

}