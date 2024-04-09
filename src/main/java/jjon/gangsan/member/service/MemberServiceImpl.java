package jjon.gangsan.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jjon.gangsan.member.mapper.MemberDaoImpl;
import jjon.gangsan.model.MemberVo;



@Service
public class MemberServiceImpl {
	
	@Autowired
	private	MemberDaoImpl memberDao;
	
	//회원가입
	public int member_join_go(MemberVo member) {
		return memberDao.member_join_go(member);
	}

	//로그인 인증
	public MemberVo user_check(String userId) {
		System.out.println("서비스 in");
		return memberDao.user_check(userId);
	}

	//id 중복검사
	public int user_id_check(String userId) {
		int result = memberDao.user_id_check(userId);
		
		return result;
	}

	//회원수정
	public void member_edit_go(MemberVo member) {
		memberDao.member_edit_go(member);
	}

	public void member_delete_go(MemberVo member) {
		memberDao.member_delete_go(member);
	}




	
	
}