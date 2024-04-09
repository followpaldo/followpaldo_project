package jjon.gangsan.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import jjon.gangsan.model.MemberVo;

@Mapper
public interface MemberDaoImpl {
	
	//회원가입
	public int member_join_go(MemberVo member);

	//로그인 인증
	public MemberVo user_check(String userId);

	//id중복검사
	public int user_id_check(String userId);

	//회원수정
	public void member_edit_go(MemberVo member);

	//회원삭제
	public void member_delete_go(MemberVo member);
}
