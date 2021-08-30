package Han;

import java.util.ArrayList;

public interface Han_inter {
	public void display(); // 초기 화면
	public StDTO one(ArrayList<StDTO> arr);	// 등록
	public void two(ArrayList<StDTO> arr);  // 등록된 전체 보기
	public ArrayList<StDTO> three(ArrayList<StDTO> arr);// 수정
	public ArrayList<StDTO> four(ArrayList<StDTO> arr); // 삭제
	public boolean five(); // 종료
	public int checkStNum(ArrayList<StDTO> arr, String stNum); //학번 존재 체크
}
