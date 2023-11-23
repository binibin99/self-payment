package ezen.project.first.team2.app.common.z_test.framework.pages.first;

import java.awt.Dimension;

import ezen.project.first.team2.app.common.framework.Page;
import ezen.project.first.team2.app.common.z_test.framework.Main;
import ezen.project.first.team2.app.common.z_test.framework.pages.first.views.MyView;

public class FirstPage extends Page {
	// 페이지 정보 정의
	private static final String TITLE = "첫 번째 페이지";
	private static final Dimension SIZE = new Dimension(640, 360);

	// 뷰 번호 정의
	public static final int VIEW_NUM_MY = 0;
	public static final int POPUP_VIEW_NUM_MY = 100;

	public FirstPage() {
		super(Main.PAGE_NUM_FIRST, TITLE, SIZE,
				Page.OPTION_CENTER_IN_SCREEN |
						Page.OPTION_BORDERLESS * 0 |
						Page.OPTION_FULL_SCREEN * 0 |
						Page.OPTION_FIXED_SIZE);
	}

	@Override
	protected void onInit() {
		System.out.println(this.getTitle() + " => onInit()");
	}

	@Override
	protected void onAddViews() {
		System.out.println(this.getTitle() + " => onAddViews()");

		try {
			this.addView(new MyView());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onAddEventListeners() {
		System.out.println(this.getTitle() + " => onAddEventListeners()");
	}

	@Override
	protected void onShow(boolean firstTime) {
		System.out.println(this.getTitle() + " => onShow()");

		try {
			this.setSelectedViewByNum(FirstPage.VIEW_NUM_MY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onHide() {
		System.out.println(this.getTitle() + " => onHide()");
	}
}
