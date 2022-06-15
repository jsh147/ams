package view;

import java.util.Scanner;

import dao.SoldierDAO;
import dto.SoldierDTO;

public class AddSoldierView {
	public AddSoldierView() {
		SoldierDAO sdao = new SoldierDAO();
		Scanner sc = new Scanner(System.in);
		System.out.print("병사 군번 : ");
		String sarmycode = sc.next();
		System.out.print("병사 계급 : ");
		String sgrade = sc.next();
		System.out.print("병사 이름 : ");
		String sname = sc.next();
		System.out.print("병사 생년월일(6자리) : ");
		String sbirth = sc.next();
		System.out.print("병사 상태 : ");
		String sstate = sc.next();
		System.out.print("병사 총기번호 : ");
		int sgunnum = sc.nextInt();
		System.out.print("병사 소속 사단 : ");
		int scamp = sc.nextInt();
		
		SoldierDTO newSoldier = new SoldierDTO(sarmycode, sgrade, sname, sbirth, sstate, sgunnum, scamp);
		
		if(sdao.addSoldier(newSoldier)) {
			System.out.println(sarmycode + "/" + sname + " 추가 완료!");
		}else {
			System.out.println("병사 추가 실패 / 다시시도부탁드립니다.");
		}
	}
}
