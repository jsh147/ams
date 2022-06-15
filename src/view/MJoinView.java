package view;

import java.util.Scanner;

import dao.ManagerDao;
import dto.ManagerDTO;

public class MJoinView {
	public MJoinView() {
		Scanner sc = new Scanner(System.in);
		ManagerDao mdao = new ManagerDao();
		System.out.println("---간부 회원가입 페이지 입니다---");
		System.out.print("군번 입력 : ");
		String Marmycode = sc.next();
		if(mdao.checkId(Marmycode)) {
			System.out.print("비밀번호(8자리이상): ");
			String Mpassword = sc.next();
			if(Mpassword.length() >= 8) {
				System.out.print("계급 : ");
				String Mgrade = sc.next();
				System.out.print("직책 : ");
				String Mjob = sc.next();
				System.out.print("이름 : ");
				String Mname = sc.next();
				System.out.println("생년월일 6자리 : ");
				String Mbirth = sc.next();
				System.out.print("총기번호 : ");
				int Mgunnum = sc.nextInt();
				System.out.print("사단번호 입력 : ");
				int Mbelong = sc.nextInt();
				// 1. 지역변수로 만든 변수들에 해당 값들을 입력받아 저장하고 ManagerDTO를 객체화시켜 저장값들을 매개변수로 넘겨준다.
				ManagerDTO newManager = new ManagerDTO(Marmycode, Mpassword, Mgrade, Mjob, Mname, Mbirth, Mgunnum, Mbelong);
				// 3. ManagerDTO에서 만든 newManager의 값들을 mdao에게 보내주어 db에 저장한 후 회원가입 성공
				if(mdao.join(newManager)) {
					System.out.println("회원가입 성공했습니다!");
				}else {
					System.out.println("회원가입 실패. 다시 시도 바랍니다");
				}
			}else {
				System.out.println("비밀번호는 8자리 이상이여야합니다.");
			}
		}else {
			System.out.println("군번 오류입니다.");
		}
	}
}
