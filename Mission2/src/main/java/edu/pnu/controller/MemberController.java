package edu.pnu.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.common.JDBConnect;
import edu.pnu.domain.MemberVO;

public class MemberController extends JDBConnect {
	//컨트롤러 서비스 위치 바뀜
	
	public MemberController() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/mvcboard", "sa", "");
	}
	
	public List<MemberVO> getMembers(){
		List<MemberVO> memberList = new ArrayList<MemberVO>();		

        String query = "SELECT * FROM member";  // 쿼리문 템플릿

        try {
            // 쿼리 실행
            psmt = con.prepareStatement(query); // 동적 쿼리문 준비
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
        }
        return memberList;
	}
	
	public MemberVO getMember(String id) {

		MemberVO vo = new MemberVO();  // 회원 정보 VO 객체 생성
        String query = "SELECT * FROM member WHERE id = ?";  // 쿼리문 템플릿

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
        }
		return vo;
	}
	
	public MemberVO addMember(MemberVO memberVO) {

		MemberVO vo = new MemberVO();  // 회원 정보 VO 객체 생성
        String query = "INSERT INTO member (id, pass, name) VALUES (?, ?, ?)";  // 쿼리문 템플릿

        try {
            // 쿼리 실행
            psmt = con.prepareStatement(query); // 동적 쿼리문 준비
            psmt.setString(1, memberVO.getId());
            psmt.setString(2, memberVO.getPass());  
            psmt.setString(3, memberVO.getName());   
            psmt.executeUpdate();  // 쿼리문 실행

            //결과 처리
            vo = getMember(memberVO.getId());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return vo;
	}
	
	public MemberVO updateMember(MemberVO memberVO) {
		
		MemberVO vo = new MemberVO();  // 회원 정보 VO 객체 생성
        String query = "UPDATE member SET name = ? WHERE id = ?";  // 쿼리문 템플릿

        try {
            // 쿼리 실행
            psmt = con.prepareStatement(query); // 동적 쿼리문 준비
            psmt.setString(1, memberVO.getName());  
            psmt.setString(2, memberVO.getId()); 
            psmt.executeUpdate();  // 쿼리문 실행

            //결과 처리
            vo = getMember(memberVO.getId());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return vo;
	}
	
	public MemberVO removeMember(String id) {

		MemberVO vo = new MemberVO();  // 회원 정보 VO 객체 생성
		vo = getMember(id);
        String query = "DELETE FROM member WHERE id = ?";  // 쿼리문 템플릿

        try {
            // 쿼리 실행
            psmt = con.prepareStatement(query); // 동적 쿼리문 준비
            psmt.setString(1, id);             
            psmt.executeUpdate();  // 쿼리문 실행

        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return vo;
	}

}
