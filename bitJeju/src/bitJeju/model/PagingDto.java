package bitJeju.model;

public class PagingDto {
	private int lineCnt = 0;	// 한 화면에 구성하는 게시판 글 개수
	private int pageCnt = 0;	// 한 화면에 표시되는 페이지 개수
	private int postCnt = 0;	// 데이터베이스 상 게시글의 전체 개수
	private int pgNum = 0;		// 현재 페이지 넘버
	
	
	public PagingDto(int lineCnt, int pageCnt, int postCnt, int pgNum) {
		this.lineCnt = lineCnt; // 한 화면에 구성하는 게시판 글 개수
		this.pageCnt = pageCnt; // 한 화면에 보여질 페이지 개수
		this.postCnt = postCnt; // 게시글의 전체 개수
		this.pgNum = pgNum; // 현재 페이지 넘버
	}
	
	public int getPageCount() { // 글의 개수에 따른 페이지 개수 계산
		//((게시글의 전체 게수 -1)/한 화면에 보여지는 게시글 수 + 1
		return ((postCnt - 1) / lineCnt) + 1;
	}
	public int getPageStart() { // 각 화면별 시작 페이지 번호
		//(현재 페이지 넘버 - 1 /한 화면에 보여질 페이지 게수 ) * 한 화면에 보여질 페이지 게수 + 1
		return ((pgNum - 1) / pageCnt) * pageCnt + 1;
	}
	public int getPageEnd() { // 각 화면별 종료 페이지 번호
		// (페이지 첫 시작 게시글 번호 + 화면을 구성하는 게시글 개수 - 1), 페이지 첫 시작 게시글 번호
		return Math.min(getPageStart() + pageCnt - 1, getPageCount());
	}
	public boolean isPreData() { //이전 페이지들을 출력하는 왼쪽 이미지 표시 여부 결정
		// 페이지의 시작 번호가 1이 아니면 true. 즉, 이전 데이터가 있으니 true 입니다
		return getPageStart() != 1;
	}
	public boolean isNextData() { //다음 페이지들을 출력하는 오른쪽 이미지 표시 여부 결정
		// 각 화면에 표시 되는 종료 페이지 넘버가, 총 페이지 게수 보다 적으면 true. 즉 이후 페이터가 있으니 다음 버튼 출력
		return getPageEnd() < getPageCount();
	}
	public int getWritingStart() { // 현재 화면의 첫 번째 게시글 넘버는?
		 // 현재 페이지에 표시할 마지막 게시글 넘버 - 한 화면에 표시할 게시글 수 + 1
		return getWritingEnd() - lineCnt + 1;
	}
	public int getWritingEnd() { // 현재 화면의 마지막 게시글 넘버는?
		//현제 페이지 넘버 * 한 화면에 표시할 게시글 수
		return pgNum * lineCnt; 
	}
	
}
