package Han;

import java.util.ArrayList;
import java.util.Scanner;

public class han implements Han_inter{

	@Override
	public void display() { //초기 화면
		// TODO Auto-generated method stub
		StDTO dto = new StDTO();
		ArrayList<StDTO> arr = new ArrayList<StDTO>();
		dto.setBool(true);
		while(dto.isBool()) {
			System.out.println("학생 정보 관리 시스템");
			System.out.println("1. 등록  2. 전체 보기  3. 수정  4. 삭제  5. 종료 ");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			switch(num) {
			case 1 : arr.add(one(arr)); break;
			case 2 : 
				System.out.println("전체보기 메뉴입니다.");
				two(arr); break;
			case 3 : arr = three(arr); break;
			case 4 : arr = four(arr); break;
			case 5 : dto.setBool(five());
			}
		}
	}

	@Override
	public StDTO one(ArrayList<StDTO> arr) { // 등록
		// TODO Auto-generated method stub
		System.out.println("등록 메뉴입니다.");
		String name, stnum , phoneNum, age;
		Scanner sc = new Scanner(System.in);
		boolean bool = true;
		StDTO dto = new StDTO();
		while(bool) {
			System.out.print("이름 : ");
			name = sc.next();
			System.out.print("학번 : ");
			stnum = sc.next();
			System.out.print("전화번호 : ");
			phoneNum = sc.next();
			System.out.print("나이 : ");
			age = sc.next();
			int num = checkStNum(arr , stnum);
			if(num == -1) {
				dto.setName(name); dto.setAge(age); dto.setPhoneNum(phoneNum); dto.setStNum(stnum);
				bool = false;
				System.out.println("저장이 완료 되었습니다 !! ");
			}else {
				System.out.println("학번이 이미 존재합니다.");
			}
		}
		return dto;
	}

	public void two(ArrayList<StDTO> arr) { // 전체보기
		// TODO Auto-generated method stub
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.println("이름 : " + arr.get(i).getName());
			System.out.println("학번 : " + arr.get(i).getStNum());
			System.out.println("전화번호 : " + arr.get(i).getPhoneNum());
			System.out.println("나이 : " + arr.get(i).getAge());
			System.out.println("---------------------");
		}
	}

	@Override
	public ArrayList<StDTO> three(ArrayList<StDTO> arr) { //수정
		// TODO Auto-generated method stub
		System.out.println("수정 메뉴입니다.");
		Scanner sc = new Scanner(System.in);
		System.out.println("학번을 입력하여 주십시오");
		String stNum = sc.next();
		for(int i = 0 ; i<arr.size(); i++) {
			if(stNum.equals(arr.get(i).getStNum())) {
				//학번에 대한 정보 제공
				System.out.println("1. 이름수정 2. 나이수정 3. 전화번호수정");
				int num = sc.nextInt();
				switch(num) {
				case 1 : 
					System.out.print("수정할 이름 :");
					String name = sc.next();
					arr.get(i).setName(name);
					
					break;
				case 2 : 
					System.out.print("수정할 나이 :");
					String age = sc.next();
					arr.get(i).setAge(age);
					break;
				case 3 : 
					System.out.print("수정할 전화번호 :");
					String phoneNum = sc.next();
					arr.get(i).setPhoneNum(phoneNum);
					break;
				}
			}
		}
		System.out.println("수정 완료!");
		return arr;
	}

	@Override
	public ArrayList<StDTO> four(ArrayList<StDTO> arr) { // 삭제
		// TODO Auto-generated method stub
		System.out.println("삭제 메뉴입니다.");
		System.out.println("학번을 입력하여 주십시오!");
		Scanner sc = new Scanner(System.in);
		String stNum = sc.next();
		int num = checkStNum(arr , stNum);
		if(num > -1) {
			System.out.println("정말 삭제하시겠습니까 ? Yes or No");
			String YesOrNo = sc.next();
			if(YesOrNo.equals("Yes") || YesOrNo.equals("yes")) {
				arr.remove(num);
				System.out.println(stNum + " 학번이 삭제 되었습니다.");	
			}else {
				System.out.println("삭제기능이 종료되었습니다.");
			}
		}else {
			System.out.println("삭제할 학번이 존재하지 않습니다. ");
		}
		return arr;
	}

	@Override
	public boolean five() { //종료
		// TODO Auto-generated method stub
		System.out.println("종료하겠습니다.");
		return false;
	}
	public int checkStNum(ArrayList<StDTO> arr , String stNum) {
		for(int i=0;i<arr.size();i++) {
			if(stNum.equals(arr.get(i).getStNum())) {
				return i;
			}
		}
		return -1;
	}
}
