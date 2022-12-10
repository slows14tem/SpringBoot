package edu.pnu.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.pnu.common.JDBConnect;

public class LogDAO extends JDBConnect {
	public LogDAO() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/mvcboard", "sa", "");
	}
	
	public void insertLog(String methodL, String queryL, boolean t) {
		Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss");
        String str = format.format(date);	//데이터베이스에 디폴트값으로 설정하면 날짜시간 넣을 필요 없어짐
		
		String query = "INSERT INTO log (method, query, exedate, success) VALUES (?, ?, ?, ?)";
		
		try {
            // 쿼리 실행
            psmt = con.prepareStatement(query); // 동적 쿼리문 준비
            psmt.setString(1, methodL);
            psmt.setString(2, queryL);
            psmt.setString(3, str);
            psmt.setBoolean(4, t);
            psmt.executeUpdate();  // 쿼리문 실행

        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
}
