package ezen.project.first.team2.app.common.utils;

import java.awt.Dimension;

public class UnitUtils {
	public static String dimToStr(Dimension dim) {
		return String.format("%dx%d", dim.width, dim.height);
	}

}
