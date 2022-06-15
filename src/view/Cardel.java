package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.CarDAO;
import dao.Session;
import dto.CarDTO;

public class Cardel {
	public Cardel() {
		while(true) { // 차량이 폐차되면 나가지도록 설정
			CarDTO c = (CarDTO)Session.getData("c");
			if(c == null) {
				break;
			}
		}
		CarDAO cdao = new CarDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("폐차시킬 차량번호를 입력하십시오 : ");
		String carnum = sc.next();
		if(cdao.cardel(carnum)) {
			System.out.println(carnum+"의 차량 폐차 완료되었습니다.");
		}else {
			System.out.println("폐차실패 / 다시시도하십시오.");
		}
	}
}
