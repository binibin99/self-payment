package ezen.project.first.team2.app.common.z_test.framework;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import ezen.project.first.team2.app.common.framework.StatusManager;
import ezen.project.first.team2.app.common.pages.splash.SplashPage;
import ezen.project.first.team2.app.common.pages.splash.SplashPageParams;
import ezen.project.first.team2.app.common.pages.splash.views.MainView;
import ezen.project.first.team2.app.common.utils.TimeUtils;
import ezen.project.first.team2.app.common.z_test.framework.pages.first.FirstPage;
import ezen.project.first.team2.app.common.z_test.framework.pages.second.SecondPage;
import ezen.project.first.team2.app.common.z_test.framework.pages.third.ThirdPage;

public class Main extends StatusManager {
	// 페이지 번호 정의
	public static final int PAGE_NUM_FIRST = 100;
	public static final int PAGE_NUM_SECOND = 101;
	public static final int PAGE_NUM_THIRD = 102;

	public Font mFont0;
	public Font mFont1;
	public Font mFont2;
	public Font mFont3;
	public ImageIcon mImg0;

	// 초기화 작업 - DB 커넥션 등
	@Override
	protected void onInit() {
		System.out.println("onInit()");
	}

	// 페이지 추가 작업
	@Override
	protected void onAddPages() {
		System.out.println("onAddPages()");

		try {
			this.addPage(new SplashPage(this.getSplashPageParams()));
			this.addPage(new FirstPage());
			this.addPage(new SecondPage());
			this.addPage(new ThirdPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 이벤트 리스너 추가 작업
	@Override
	protected void onAddEventListeners() {
		System.out.println("onAddEventListeners()");

		//
	}

	// 실행 작업 - 페이지 선택 등
	@Override
	protected void onRun() {
		System.out.println("onRun()");

		try {
			this.setSelectedPageByNum(SplashPage.PAGE_NUM);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 종료 작업 - DB 디스커넥션 등
	@Override
	protected void onExit() {
		System.out.println("onExit()");

		//
	}

	private SplashPageParams getSplashPageParams() {
		SplashPageParams params = new SplashPageParams(new SplashPageParams.Listener() {
			@Override
			public void onLoadResources(Object param, int resourceIndex, int resourceCount) {
				Main main = (Main) param;
				SplashPage splashPage = (SplashPage) main.getPageByNum(SplashPage.PAGE_NUM);
				MainView mainView = (MainView) splashPage.getViewByNum(SplashPage.VIEW_NUM_MAIN);

				final int rsrcIdx = resourceIndex;
				final int rsrcCnt = resourceCount;

				String s = String.format("rsrcIdx: %d, rsrcCnt: %d", rsrcIdx, rsrcCnt);
				System.out.println(s);
				mainView.setLabel0Text(s);

				// 1초가 소요되는 작업이라 가정
				// SystemUtils.sleep(1 * 1000);

				switch (rsrcIdx) {
					case 0:
						main.mFont0 = new Font("맑은 고딕", Font.BOLD, 16);
						break;

					case 1:
						main.mFont1 = new Font("맑은 고딕", Font.BOLD, 32);
						break;

					case 2:
						main.mFont2 = new Font("맑은 고딕", Font.BOLD, 48);
						break;

					case 3:
						main.mFont3 = new Font("맑은 고딕", Font.BOLD, 64);
						break;

					case 4:
						TimeUtils.startElapsedTime();
						main.mImg0 = new ImageIcon("resources/images/retriever0.jpg");
						// main.mImg0 = new ImageIcon("resources/images/img00.jpg");
						System.out.println(TimeUtils.getElapsedTimeStr());
						System.out.println(main.mImg0.getIconWidth());
						break;
				}
			}

			@Override
			public void onCompleteResources(Object param) {
				Main main = (Main) param;
				main.performSetResources();

				try {
					Main.this.setSelectedPageByNum(Main.PAGE_NUM_FIRST);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, this, 5);

		return params;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {

			(new Main()).run();

		});

	}
}