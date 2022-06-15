package view;

import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.Session;

import dao.GunDAO;
import dto.GunDTO;
import dto.ManagerDTO;

public class GunView {
	public GunView() {
		GunDAO gdao = new GunDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("------총기관리화면------");
		while(true) {
			ManagerDTO loginManager = (ManagerDTO)dao.Session.getData("loginManager");
			if(loginManager == null) {
				System.out.println("로그인 후 이용하세요");
				break;
			}
			System.out.println("1. 총기 등록");
			System.out.println("2. 총기 조회");
	        System.out.println("3. 총기 검색");
	        System.out.println("4. 총기 정보 수정");
	        System.out.println("5. 총기 반납");
	        System.out.println("6. 뒤로가기");	
			int choice = sc.nextInt();
			
			if(choice == 5) {
				break;
			}
			ArrayList<GunDTO> result = null;
			int gunnum = 0;
			switch(choice) {
			case 1:
				//�ѱ� ���
				new AddGunView();
				break;
			case 2:
	            //총기 조회
	            result = gdao.getList();
	            System.out.println("총기 목록");
	            if(result.size() == 0) {
	               System.out.println("등록된 총기가 없습니다.");
	            }
	            for (GunDTO g : result) {
	               System.out.printf("총기번호 : %d\n총기명  : %s\n",g.gunnum,g.gunname);
	            }
	            break;
			case 3:
				//�ѱ� ���� ����
				new ModifyGunView();
				break;
			case 4:
				//�ѱ� �ݳ�
				
				System.out.print("반납할 총기의 총기번호 : ");
				gunnum = sc.nextInt();
				if(gdao.removeGun(gunnum)) {
					System.out.println(gunnum+" 한자루 반납 완료");
				}
				else {
					System.out.println("총기 반납 실패 / 다음에 다시 반납해 주세요.");
				}
				break;
			}
		}
	}
}
