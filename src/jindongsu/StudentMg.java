package jindongsu;

import java.util.*;
import Main.StDTO;

public class StudentMg implements inter{
	
	private String stNum, name, phoneNum, age;
	private int choice, index;
	Scanner scan = new Scanner(System.in);
	ArrayList<StDTO> arr = new ArrayList<StDTO>();
	
	public void enroll() {
		
		if(arr.size() != 0) {
			loop: while(true) {
				System.out.print("등록할 학생학번 입력 : ");
				stNum = scan.next();
				index = func(stNum);
				if(index != -1) {
						System.out.println("학번 중복입니다!!!");
						}else {
							break loop;
						}
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
		arr.add(st);
		System.out.println("등록이 완료되었습니다!!!");
		}
	
	public void allView() {
		if(arr.isEmpty()) {
			System.out.println("저장된 학생이 없습니다!!");
		}else {
		System.out.println("------ 전체 보기 ------");
		for(int i =0; i < arr.size(); i++) {
			System.out.println("학생 이름 : "+arr.get(i).getName());
			System.out.println("학생 학번 : "+arr.get(i).getStNum());
			System.out.println("학생 나이 : "+arr.get(i).getAge());
			System.out.println("학생 번호 : "+arr.get(i).getPhoneNum());
			System.out.println("---------------------");
			}
		}
	}

	public void select() {
		System.out.print("검색할 학생의 학번을 입력하세요 : ");
		stNum = scan.next();
		index = func(stNum);
		if(index != -1) {
				System.out.println("학생 이름 : "+arr.get(index).getName());
				System.out.println("학생 학번 : "+arr.get(index).getStNum());
				System.out.println("학생 나이 : "+arr.get(index).getAge());
				System.out.println("학생 번호 : "+arr.get(index).getPhoneNum());
				return;
		}
		System.out.println("해당 학생의 학번을 존재하지 않습니다!");
	}

	public void remove() {
		System.out.print("삭제할 학생의 학번을 입력하세요 : ");
		stNum = scan.next();
		index = func(stNum);
		if(index != -1) {
				arr.remove(index);
				System.out.println("삭제를 완료했습니다!!!");
				return;
			}
		System.out.println("해당 학생의 학번을 존재하지 않습니다!");
	}
	
	public void amend() {
		System.out.print("수정할 학생 학번 입력 : ");
		stNum = scan.next();
		index = func(stNum);
		if(index != -1) {
				System.out.println("수정전 학생 이름 : "+arr.get(index).getName());
				System.out.println("수정전 학생 학번 : "+arr.get(index).getStNum());
				System.out.println("수정전 학생 나이 : "+arr.get(index).getAge());
				System.out.println("수정전 학생 번호 : "+arr.get(index).getPhoneNum());
				System.out.println("------------------------");
				System.out.print("수정 이름 입력 : ");
				name = scan.next();
				System.out.print("수정 나이 입력 : ");
				age = scan.next();
				System.out.print("수정 번호 입력 : ");
				phoneNum = scan.next();
				arr.get(index).setName(name); 
				arr.get(index).setAge(age);
				arr.get(index).setPhoneNum(phoneNum);
				System.out.println("수정이 완료되었습니다!!!");
				return;
				
			}
		System.out.println("해당 학생의 학번을 존재하지 않습니다!");
	}
	
	public int func(String stNum) {
		for(int i =0; i < arr.size(); i++) {
			if(arr.get(i).getStNum().equals(stNum)) {
				return i;
			}
		}
		return -1;
	}
	
	public void disp() {
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
