package com.kh.delivery.view;

import java.util.Scanner;

import com.kh.delivery.controller.MemberController;
import com.kh.delivery.dto.DeliMemberDto;

public class DeliveryMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	
	public void mainMenu() {
		while(true) {
		System.out.println("회원가입서비스에 오신것을 환영합니다.");
		System.out.println("1. 회원가입하기 ");
		System.out.println("2. 로그인 ");
		System.out.println("0. 프로그램 종료");
		System.out.print("원하시는 메뉴를 선택해주세요 > ");
		String menu = sc.nextLine();
		
		switch(menu) {
		case "1" : signUp();break;
		case "2" : login(); break;
		case "0" : sc.close();return;
		
		}
		
	}
	}
	private void signUp() {
		System.out.println("회원가입 서비스입니다.");
		String memberId;
		while(true) {
		System.out.println("사용하실 아이디를 입력해주세요 > ");
			memberId = sc.nextLine();
		
		if(!mc.idCheck(memberId)) {
			break;
		}
		System.out.println("이미 존재하는 아이디 입니다.");
		
		}
		
		System.out.print("사용하실 비밀번호를 입력해주세요 > ");
		String memberPw = sc.nextLine();
		System.out.print("사용하실 이름을 입력해주세요 > ");
		String memberName = sc.nextLine();
		System.out.print("배달 받으실 주소를 입력해주세요 > ");
		String address = sc.nextLine();
		
	     int result =
			mc.signUp(new DeliMemberDto(memberId,memberPw,memberName,address));
	     if(result >0 ) {
	    	 System.out.println("회원가입 성공~!");
	     }else {
				System.out.println("회원가입 실패..");
			}
		
	}
	
	private void login() {
		
		System.out.println("아이디를 입력해주세요 > ");
		String memberId =sc.nextLine();
		System.out.println("비밀번호를 입력해주세요 > ");
		String memberPw = sc.nextLine();
		
		DeliMemberDto loginMember = new DeliMemberDto();
		loginMember.setMember_Id(memberId);
		loginMember.setMember_Pw(memberPw);
		LoginResponse lr = mc.login(loginMember);
		
		if(lr != null) {
			System.out.println("로그인에 성공하셨습니다~");
			
		}else {
			System.out.println("로그인 실패..");
		}
	}
	
	
	
	
}	
	
	
	
	
	
	

