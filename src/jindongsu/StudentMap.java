package jindongsu;

import java.util.*;
import Main.StDTO;

public class StudentMap implements inteface{
	Scanner scan = new Scanner(System.in);
	HashMap<String, StDTO> map = new HashMap<>();
	private String stNum, name, phoneNum, age;
	
	public void enroll() {
		if(map.isEmpty() == false) {
			while(true) {
			System.out.print("등록할 학생학번 입력 : ");
			stNum = scan.next();
			if( map.get(stNum) != null ) {
					System.out.println("학번 중복입니다!!!");
					System.out.println("다시 입력하세요!!!");
					System.out.println("---------------");
				}else { break; }
			}
		}else {
			System.out.print("등록할 학생학번 입력 : ");
			stNum = scan.next();
		}
			System.out.print("등록할 학생이름 입력 : ");
			name = scan.next();
			System.out.print("등록할 학생나이 입력 : ");
			age = scan.next();
			System.out.print("등록할 학생번호 입력 : ");
			phoneNum = scan.next();
			StDTO st = new StDTO();
			st.setName(name); st.setStNum(stNum); 
			st.setAge(age); st.setPhoneNum(phoneNum);
			map.put(stNum, st);
			System.out.println("등록 완료!!!");
	}

	public void allView() {
		System.out.println("--- 전체 보기 ---");
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			StDTO key = map.get( iter.next() );
			System.out.println("학번 : "+ key.getStNum() );
			System.out.println("이름 : " + key.getName() );
			System.out.println("나이 : " + key.getAge() );
			System.out.println("번호 : " + key.getPhoneNum() );
			System.out.println("-----------------");
		}
	}

	public void select() {
		System.out.print("검색할 학생의 학번 입력 : ");
		stNum = scan.next();
		if( map.get(stNum) != null ) {
			System.out.println("학번 : " + map.get(stNum).getStNum());
			System.out.println("이름 : " + map.get(stNum).getName());
			System.out.println("나이 : " + map.get(stNum).getAge());
			System.out.println("번호 : " + map.get(stNum).getPhoneNum());
			System.out.println("-----------------");
		}else {
			System.out.println("해당 학번은 존재하지 않습니다!!!");
			System.out.println("-----------------");
		}
	}

	public void remove() {
		System.out.print("삭제할 학생의 학번 입력 : ");
		stNum = scan.next();
		if( map.remove(stNum) != null ) {
			System.out.println("삭제 완료!!!");
			System.out.println("-----------------");
		}else {
			System.out.println("해당 학번은 존재하지 않습니다!!!");
			System.out.println("-----------------");
		}
	}

	public void amend() {
		System.out.print("수정할 학생의 학번 입력 : ");
		stNum = scan.next();
		if( map.get(stNum) != null ) {
			System.out.println("수정전 학번 : " + map.get(stNum).getStNum());
			System.out.println("수정전 이름 : " + map.get(stNum).getName());
			System.out.println("수정전 나이 : " + map.get(stNum).getAge());
			System.out.println("수정전 번호 : " + map.get(stNum).getPhoneNum());
			System.out.println("-----------------");
			System.out.print("수정할 학생이름 입력 : ");
			name = scan.next();
			System.out.print("수정할 학생나이 입력 : ");
			age = scan.next();
			System.out.print("수정할 학생번호 입력 : ");
			phoneNum = scan.next();
			map.get(stNum).setName(name);
			map.get(stNum).setAge(age);
			map.get(stNum).setPhoneNum(phoneNum);
			map.put(stNum, map.get(stNum));
			System.out.println("수정이 완료되었습니다!!!");
			System.out.println("-----------------");
		}else {
			System.out.println("해당 학번은 존재하지 않습니다!!!");
			System.out.println("-----------------");
		}
	}
	
	public void disp() {
		int choice;
		System.out.println("--- 학생 관리 프로그램입니다 ---");
		while(true) {
			System.out.println("(1)학생등록 (2)전체보기 (3)학생검색\n(4)학생삭제 (5)학생수정 (6)종료");
			choice = scan.nextInt();
			switch(choice) {
				case 1: enroll(); break;
				case 2: allView(); break;
				case 3: select(); break;
				case 4: remove(); break;
				case 5: amend(); break;
				default : System.out.println("프로그램을 종료합니다"); return;
				}
		}
	}

}