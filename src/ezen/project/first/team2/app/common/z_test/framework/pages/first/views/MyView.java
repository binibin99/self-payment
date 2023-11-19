package ezen.project.first.team2.app.common.z_test.framework.pages.first.views;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import ezen.project.first.team2.app.common.framework.View;
import ezen.project.first.team2.app.common.z_test.framework.Main;
import ezen.project.first.team2.app.common.z_test.framework.pages.first.FirstPage;

public class MyView extends View {
	private static final int PADDING = 10;

	// private Font mFont = null;

	JButton m2ndPageBtn = new JButton();
	JButton m3rdPageBtn = new JButton();

	public MyView() {
		super(FirstPage.VIEW_NUM_MY);
	}

	@Override
	protected void onInit() {
		// this.setBackground(Color.BLUE);

		// this.mFont = new Font("맑은 고딕", Font.PLAIN, 16);
	}

	@Override
	protected void onSetLayout() {
		this.setBorder(BorderFactory.createEmptyBorder(
				PADDING, PADDING, PADDING, PADDING));
		this.setLayout(new GridLayout(1, 1, 10, 10));
	}

	@Override
	protected void onAddCtrls() {
		this.m2ndPageBtn.setText("두 번째 페이지");
		this.m3rdPageBtn.setText("세 번째 페이지");

		// this.m2ndPageBtn.setFont(this.mFont);

		this.add(this.m2ndPageBtn);
		this.add(this.m3rdPageBtn);
	}

	@Override
	protected void onAddEventListeners() {
		this.m2ndPageBtn.addActionListener(e -> {
			try {
				// FirstPage page = (FirstPage)MyView.this.getPage();
				// Main main = (Main)page.getStatusManager();
				Main main = (Main) MyView.this.getStatusManager();
				main.setSelectedPageByNum(Main.PAGE_NUM_SECOND);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		this.m3rdPageBtn.addActionListener(e -> {
			try {
				Main main = (Main) MyView.this.getStatusManager();
				main.setSelectedPageByNum(Main.PAGE_NUM_THIRD);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

	@Override
	protected void onShow(boolean firstTime) {
		System.out.println("FirstView.onShow()");
	}

	@Override
	protected void onHide() {
		System.out.println("FirstView.onHide()");
	}

	@Override
	protected void onSetResources() {
		Main main = (Main) this.getStatusManager();
		this.m2ndPageBtn.setFont(main.mFont0);
	}
}
