////////////////////////////////////////////////////////////////////////////////
//
// [SGLEE:20231117FRI_124500] Created
//
////////////////////////////////////////////////////////////////////////////////

package ezen.project.first.team2.app.manager.pages.main;

import java.awt.Dimension;

import ezen.project.first.team2.app.common.framework.Page;
import ezen.project.first.team2.app.common.modules.MemberInfo;
import ezen.project.first.team2.app.common.modules.MemberManagerMem;
import ezen.project.first.team2.app.manager.Main;
import ezen.project.first.team2.app.manager.pages.main.views.MainView;

public class MainPage extends Page {
	// -------------------------------------------------------------------------

	// 페이지 정보 상수 정의

	public static final String TITLE = "관리 프로그램";
	public static final Dimension SIZE = new Dimension(1280, 720);

	public static final int VIEW_NUM_MAIN = 0;

	public static final int VIEW_NUM_LEFT = 100;
	public static final int VIEW_NUM_RIGHT = 200;

	// 고객
	public static final int VIEW_NUM_CUST_LIST = 211;
	public static final int VIEW_NUM_CUST_ADD = 212;
	public static final int VIEW_NUM_CUST_UPDATE = 213;
	public static final int VIEW_NUM_CUST_DELETE = 214;
	// 상품
	public static final int VIEW_NUM_PROD_LIST = 221;
	public static final int VIEW_NUM_PROD_ADD = 222;
	public static final int VIEW_NUM_PROD_UPDATE = 223;
	public static final int VIEW_NUM_PROD_DELETE = 224;
	// 재고
	public static final int VIEW_NUM_STOCK_LIST = 231;
	public static final int VIEW_NUM_STOCK_UPDATE = 232;
	// -------------------------------------------------------------------------

	//

	// -------------------------------------------------------------------------

	// 생성자
	public MainPage() {
		super(Main.PAGE_NUM_MAIN, TITLE, SIZE,
				OPTION_CENTER_IN_SCREEN |
						OPTION_VISIBLE * 0 |
						OPTION_BORDERLESS * 0 |
						OPTION_FULL_SCREEN * 0 |
						OPTION_FIXED_SIZE);
	}

	// -------------------------------------------------------------------------

	// 초기화 작업
	@Override
	protected void onInit() {
		super.onInit();

		try {
			MemberManagerMem memMngr = MemberManagerMem.getInstance();
			memMngr.init();

			final MemberInfo sglee = MemberInfo.getDummyData(MemberInfo.DummyDataIndex._0_SiGwanLEE);
			final MemberInfo gygil = MemberInfo.getDummyData(MemberInfo.DummyDataIndex._1_GeunYoungGil);
			final MemberInfo hwjo = MemberInfo.getDummyData(MemberInfo.DummyDataIndex._2_HyunWooJo);
			final MemberInfo jhkim = MemberInfo.getDummyData(MemberInfo.DummyDataIndex._3_JunHyungKim);
			final MemberInfo cjpark = MemberInfo.getDummyData(MemberInfo.DummyDataIndex._4_CheolJinPark);
			final MemberInfo bseo = MemberInfo.getDummyData(MemberInfo.DummyDataIndex._5_BinSeo);

			try {
				memMngr.add(sglee);
				System.out.println("  -> " + sglee.getName());
				memMngr.add(gygil);
				System.out.println("  -> " + gygil.getName());
				memMngr.add(hwjo);
				System.out.println("  -> " + hwjo.getName());
				memMngr.add(jhkim);
				System.out.println("  -> " + jhkim.getName());
				memMngr.add(cjpark);
				System.out.println("  -> " + cjpark.getName());
				memMngr.add(bseo);
				System.out.println("  -> " + bseo.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 뷰 추가
	@Override
	protected void onAddViews() {
		try {
			this.addView(new MainView());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 이벤트 리스너 추가
	@Override
	protected void onAddEventListeners() {
	}

	// 페이지가 표시될 때
	@Override
	protected void onShow(boolean firstTime) {
		System.out.println("[MainPage.onShow()]");

		try {
			this.setSelectedViewByNum(MainPage.VIEW_NUM_MAIN);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 페이지가 숨겨질 때
	@Override
	protected void onHide() {
		System.out.println("[MainPage.onHide()]");
	}
}
