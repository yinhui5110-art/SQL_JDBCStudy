package com.kh.crosc.view;

import java.util.Scanner;

import com.kh.crosc.controller.CroscController;

public class CrocsView {

	private Scanner sc = new Scanner(System.in);
	private CroscController croscController = new CroscController();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println();
			System.out.println("크록스클럽 회원서비스에 오신것을 환영합니다");
			if()
		String menu = sc.nextLine();
		
		switch(menu) {
		case "1" : signUp();break;
		case "2" : break;		
		case "0" : return;
	
		}
		
	  }
	}	
	
	private void signUp() {
		System.out.println("크록스클럽 회원가입 서비스입니다. ");
		
		while(true) {
		System.out.println("사용하실 아이디를 입력해주세요 >");
		String crocsId = sc.nextLine();
		System.out.println("사용하실 비번을 입력해주세요 > ");
		String crocsPwd = sc.nextLine();
		System.out.println("사용하실 닉네임을 입력해주세요 > ");
		String crocsNickName = sc.nextLine();
		try {
			if
		}catch() {
			
		}
		
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
