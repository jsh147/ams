package view;

import java.util.Scanner;

import dao.ManagerDao;
import dao.Session;
import dto.ManagerDTO;

public class LoginView {
	LoginView(){
		Scanner sc = new Scanner(System.in);
		ManagerDao mdao = new ManagerDao();
		System.out.print("군번 : ");
		String Marmycode = sc.next();
		System.out.print("비밀번호 : ");
		String Mpassword = sc.next();
		
		if(mdao.login(Marmycode, Mpassword)) {
			// 메인뷰
			String Mname = ((ManagerDTO)Session.getData("loginManager")).Mname;
			System.out.println(Mname + "님 반갑습니다!");
			new MainView();
		}else {
			System.out.println("로그인 실패(군번 혹은 비밀번호 확인 바랍니다)");
		}
	}
}
