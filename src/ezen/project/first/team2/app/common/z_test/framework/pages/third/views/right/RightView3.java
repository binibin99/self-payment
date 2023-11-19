package ezen.project.first.team2.app.common.z_test.framework.pages.third.views.right;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import ezen.project.first.team2.app.common.framework.View;
import ezen.project.first.team2.app.common.z_test.framework.pages.third.ThirdPage;

public class RightView3 extends View {
	private static final int PADDING = 10;

	public RightView3() {
		super(ThirdPage.RIGHT_VIEW_NUM_3);
	}

	@Override
	protected void onInit() {
		//
	}

	@Override
	protected void onSetLayout() {
		this.setBorder(BorderFactory.createEmptyBorder(
				PADDING, PADDING, PADDING, PADDING));
	}

	@Override
	protected void onAddCtrls() {
		this.add(new JLabel("네 번째 뷰"));
	}

	@Override
	protected void onAddEventListeners() {
	}

	@Override
	protected void onShow() {
		System.out.println("[RightView3.onShow()]");
	}

	@Override
	protected void onHide() {
		System.out.println("[RightView3.onHide()]");
	}
}
