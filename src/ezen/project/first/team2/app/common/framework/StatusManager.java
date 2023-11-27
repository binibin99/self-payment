////////////////////////////////////////////////////////////////////////////////
//
// [SGLEE:20231114TUE_101700] Created
// [SGLEE:20231114TUE_102000] Page, View, Pane 전환 상태 관리
// [SGLEE:20231115WED_124200] 페이지 관리
//
////////////////////////////////////////////////////////////////////////////////

package ezen.project.first.team2.app.common.framework;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class StatusManager {
	// -------------------------------------------------------------------------

	//
	// private static boolean DEBUG_MODE = true;
	// private static boolean TEST_MODE = true;
	//

	// -------------------------------------------------------------------------

	private List<Page> mPageList = new ArrayList<>();
	private int mSelectedPageNum = -1;

	// -------------------------------------------------------------------------

	// 생성자
	public StatusManager() {
		//
	}

	// -------------------------------------------------------------------------

	// 상태 관리자 실행 - 상속 받은 클래스에서 호출
	public void run() {
		this.onInit();
		this.onAddPages();
		this.onAddEventListeners();
		this.onRun();
	}

	// 페이지 추가 - 추가하면서 init() 메소드 호출
	public void addPage(Page page) throws Exception {
		// 페이지 번호 유효성 확인
		int pageNum = page.getNumber();
		if (pageNum == -1 || this.isValidPageNum(pageNum)) {
			String msg = String.format(
					"[StatusManager.addPage()] " +
							" Invalid or duplicated page number! => %d",
					pageNum);
			throw new Exception(msg);
		}

		// 페이지 초기화
		page.init(this);

		// 뷰 개수 확인
		if (page.getViewCount() == 0) {
			String msg = String.format(
					"[StatusManager.addPage()] " +
							" There is no views in page number(%d)!",
					pageNum);
			throw new Exception(msg);
		}

		// 리스트에 추가
		this.mPageList.add(page);

		// 윈도우 클로즈 리스너 추가
		page.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// 현재 뷰와 페이지 숨김
				Page selPage = StatusManager.this.getSelectedPage();
				View selView = selPage.getSelectedView();

				if (selView != null) {
					if (selView instanceof DualView) {
						DualView dualView = (DualView) selView;
						View selLeftView = dualView.getSelectedLeftView();
						View selRightView = dualView.getSelectedRightView();

						if (selLeftView != null)
							selLeftView.performHide();

						if (selRightView != null)
							selRightView.performHide();
					}

					selView.performHide();
				}

				if (selPage != null)
					selPage.performHide();

				// Status Manager 종료
				StatusManager.this.onExit();
			}
		});
	}

	// 페이지 번호로 객체 얻기
	public Page getPageByNum(int num) {
		for (Page page : this.mPageList) {
			if (page.getNumber() == num)
				return page;
		}

		return null;
	}

	// 페이지 번호로 선택
	public void setSelectedPageByNum(int num) throws Exception {
		// 현재 페이지를 선택한다면 메시지 출력 후 리턴
		if (num == this.mSelectedPageNum) {
			System.out.printf(
					"[StatusManager.selectPageByNum()] Same page number(%d)! \n",
					num);
			return;
		}

		// 페이지 번호가 유효한지 확인
		if (!this.isValidPageNum(num)) {
			String msg = String.format(
					"[StatusManager.selectPageByNum()] " +
							"Invalid page number(%d)!",
					num);
			throw new Exception(msg);
		}

		// 현재 페이지 숨김
		Page currPage = this.getSelectedPage();
		if (currPage != null)
			currPage.performHide();

		// 선택한 페이지 표시
		this.mSelectedPageNum = num;
		Page newPage = this.getPageByNum(num);
		newPage.performShow();
	}

	// 선택된 페이지 번호 얻기
	public int getSelectedPageNum() {
		return this.mSelectedPageNum;
	}

	// 선택된 페이지 객체 얻기
	public Page getSelectedPage() {
		return this.getPageByNum(this.getSelectedPageNum());
	}

	// 페이지 리스트 얻기
	public List<Page> getPageList() {
		return this.mPageList;
	}

	// 리소스 설정
	public void performSetResources() {
		for (Page page : this.mPageList) {
			page.performSetResources();
		}
	}

	// -------------------------------------------------------------------------

	// 초기화 작업 - DB 커넥션 등
	protected void onInit() {
	}

	// 페이지 추가 작업
	protected void onAddPages() {
	}

	// 이벤트 리스너 추가 작업
	protected void onAddEventListeners() {
	}

	// 실행 작업 - 페이지 선택 등
	protected void onRun() {
	}

	// 종료 작업 - DB 디스커넥션 등
	protected void onExit() {
	}

	// -------------------------------------------------------------------------

	// 페이지 번호 유효성 확인
	private boolean isValidPageNum(int num) {
		for (Page page : this.mPageList) {
			// System.out.printf("[StatusManager.isValidPageIdx()] " +
			// "idx:%d, page.getIndex():%d \n",
			// num, page.getNumber());

			if (page.getNumber() == num)
				return true;
		}

		return false;
	}
}