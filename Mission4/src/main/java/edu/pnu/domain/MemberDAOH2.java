package edu.pnu.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.pnu.common.JDBConnect;

@Repository
public class MemberDAOH2 extends JDBConnect	implements MemberDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;

	public MemberDAOH2() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/mvcboard", "sa", "");
	}

	public List<MemberVO> getMembers(){
		List<MemberVO> memberList = new ArrayList<MemberVO>();

        sql = "SELECT * FROM member";  // 쿼리문 템플릿

        try {
            // 쿼리 실행
            psmt = con.prepareStatement(sql); // 동적 쿼리문 준비
            rs = psmt.executeQuery();  // 쿼리문 실행

            // 결과 처리
            while (rs.next()) {
            	MemberVO vo = new MemberVO();
                // 쿼리 결과로 얻은 회원 정보를 VO 객체에 저장
                vo.setId(rs.getString("id"));
                vo.setPass(rs.getString("pass"));
                vo.setName(rs.getString(3));
                vo.setRegidate(rs.getString(4));
                memberList.add(vo);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return memberList;
	}
	
	public MemberVO getMember(String id) {
		MemberVO vo = new MemberVO();  // 회원 정보 VO 객체 생성
        String query = "SELECT * FROM member WHERE id = ?";  // 쿼리문 템플릿
		sql = String.format("SELECT * FROM member WHERE id = '%s'", id);

        try {
            // 쿼리 실행
            psmt = con.prepareStatement(query); // 동적 쿼리문 준비
            psmt.setString(1, id);    // 쿼리문의 첫 번째 인파라미터에 값 설정
            rs = psmt.executeQuery();  // 쿼리문 실행

            // 결과 처리
            while (rs.next()) {
                // 쿼리 결과로 얻은 회원 정보를 VO 객체에 저장
                vo.setId(rs.getString("id"));
                vo.setPass(rs.getString("pass"));
                vo.setName(rs.getString(3));
                vo.setRegidate(rs.getString(4));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		return vo;
	}
	
	public MemberVO addMember(MemberVO memberVO) {
//        String query = "INSERT INTO member (id, pass, name) VALUES (?, ?, ?)";  // 쿼리문 템플릿

        try {
            // 쿼리 실행
//            psmt = con.prepareStatement(query); // 동적 쿼리문 준비
//            psmt.setString(1, memberVO.getId());
//            psmt.setString(2, memberVO.getPass());  
//            psmt.setString(3, memberVO.getName());   
//            psmt.executeUpdate();  // 쿼리문 실행
            
            sql = String.format("INSERT INTO member (id, pass, name) VALUES ('%s', '%s', '%s')", 
            		memberVO.getId(), memberVO.getPass(), memberVO.getName());
            
            stmt = con.createStatement();
            if (stmt.executeUpdate(sql) == 0) {
				return null;
			}
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		return memberVO;
	}
	
	public MemberVO updateMember(MemberVO memberVO) {
		MemberVO vo = getMember(memberVO.getId());  // 회원 정보 VO 객체 생성
//        String query = "UPDATE member SET name = ? WHERE id = ?";  // 쿼리문 템플릿

        try {
            // 쿼리 실행
//            psmt = con.prepareStatement(query); // 동적 쿼리문 준비
//            psmt.setString(1, memberVO.getName());  
//            psmt.setString(2, memberVO.getId()); 
//            psmt.executeUpdate();  // 쿼리문 실행
        	sql = String.format("UPDATE member SET name = '%s' WHERE id = '%s'", 
            		memberVO.getName(), memberVO.getId());
        	stmt = con.createStatement();
            if (stmt.executeUpdate(sql) == 0) {
				return null;
			}
            vo.setName(memberVO.getName());
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		return vo;
	}
	
	public MemberVO removeMember(String id) {
		MemberVO vo = new MemberVO();  // 회원 정보 VO 객체 생성
		vo = getMember(id);
//        String query = "DELETE FROM member WHERE id = ?";  // 쿼리문 템플릿
		sql = String.format("DELETE FROM member WHERE id = '%s'", 
        		id);

        try {
            // 쿼리 실행
//            psmt = con.prepareStatement(query); // 동적 쿼리문 준비
//            psmt.setString(1, id);
//            psmt.executeUpdate();  // 쿼리문 실행
        	stmt = con.createStatement();
            if (stmt.executeUpdate(sql) == 0) {
				return null;
			}

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		return vo;
	}
	
	public String getSql() {
		return sql;
	}

}
