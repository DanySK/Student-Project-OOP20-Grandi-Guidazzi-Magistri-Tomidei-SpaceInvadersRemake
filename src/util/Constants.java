package util;

import java.awt.Color;
import java.awt.Dimension;

/**
 * An Interface to store all the constants in the project.
 */
public interface Constants {
	
	Dimensions screenInfo = new Dimensions();
	Dimension preferDimension = new Dimension(screenInfo.getPreferScreenWidth(), screenInfo.getPreferScreenHeight());
	Dimension maxLabelDimension = new Dimension(screenInfo.getMaxLabelWidth(), screenInfo.getMaxLabelHeight());
	int titleSize = 60;
	int subtitleSize = 25;
	int minPodium = 1;
	int maxPodium = 3;
	Color colorTitle = Color.cyan;
	Color colorSubtitle = Color.white;
	boolean IN_LOOP = true;
	boolean NOT_IN_LOOP = false;
	
}
