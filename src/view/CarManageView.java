package view;

import java.util.Scanner;

import dao.CarDAO;
import dao.Session;
import dto.CarDTO;

public class CarManageView {
	public CarManageView(){
		// caruse : true -> 사용가능
		// caruse : false -> 사용불가(사용중)
		CarDAO cdao = new CarDAO();
		CarDTO c = (CarDTO)Session.getData("c");
		Scanner sc = new Scanner(System.in);
		System.out.println("====차량관리 페이지입니다====");
		System.out.println("관리하려는 정보의 숫자 입력 : ");
		System.out.println("1. 신규차량 등록\n2. 차량 조회\n3. 차량 정보 수정\n4. 차량 폐기\n5. 나가기");
		int choice = sc.nextInt();
		if(choice == 1) {
			// 신규차량 등록
			new AddCarView();
		}else if(choice == 2) {
			// 차량 조회
			new CarListView();
		}else if(choice == 3) {
			// 차량 정보 수정
			new CarEditView();
		}else if(choice == 4) {
			// 차량 폐기
			new Cardel();
		}else if(choice == 5) {
			// 나가기
		}else {
			System.out.println("잘못된 입력입니다.");
		}
	}
}
