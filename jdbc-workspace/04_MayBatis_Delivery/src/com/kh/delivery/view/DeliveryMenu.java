package com.kh.delivery.view;

import java.util.Scanner;

import com.kh.delivery.controller.MemberController;
import com.kh.delivery.dto.DeliMemberDto;

public class DeliveryMenu {
	private Scanner sc = new Scanner(System.in);
	private DeliMemberDto member = null;
	
	
	
	public void mainMenu() {
		while(true) {
		System.out.println("딜리버리 회원가입서비스에 오신것을 환영합니다.");
		System.out.println("1. 회원가입하기 ");
		System.out.println("2. 로그인 ");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴를 선택해주세요 > ");
		String menu = sc.nextLine();
		
		switch(menu) {
		case "1" : signUp();break;
		case "2" : login(); break;
		case "0" : System.out.println("서비스를 종료합니다."); sc.close();return;
		default : System.out.println("없는 메뉴입니다.");
		
		}
		
	}
	}
	private int signUp() {
		
		while(true) {
		System.out.println("회원가입 서비스입니다.");
		
		System.out.println("사용하실 아이디를 입력해주세요 > ");
			String memberId = sc.nextLine();
		int checkIdResult =  new MemberController().checkId(memberId);
		if(checkIdResult > 0) {
			
		}else {
		System.out.println("이미 존재하는 아이디 입니다.");
		
		}
		 continue;
		 
		System.out.print("사용하실 비밀번호를 입력해주세요 > ");
		String memberPw = sc.nextLine();
		System.out.print("사용하실 이름을 입력해주세요 > ");
		String memberName = sc.nextLine();
		System.out.print("배달 받으실 주소를 입력해주세요 > ");
		String address = sc.nextLine();
		
	     int signUpresult =new MemberController().signUp(new DeliMemberDto(memberid, memberPw,memberName,address));
	     if(signUpresult >0 ) {
	    	 System.out.println("회원가입 성공~!");
	    	 return;
	     }else {
				System.out.println("회원가입 실패..");
				continue;
			}
		}
	}
	
	private void login() {
		
		System.out.println();
		System.out.println("아이디를 입력해주세요 > ");
		String memberId =sc.nextLine();
		System.out.println("비밀번호를 입력해주세요 > ");
		String memberPw = sc.nextLine();
		
		member = new MemberController().login(new DeliMemberDto(memberId,memberPw));
		if(member == null) {
			System.out.println("로그인에 성공하셨습니다~");
			
		}else {
			System.out.println("로그인 실패..");
		}
	}
	
	
	
	
}	
	
	
	
	
	
	

