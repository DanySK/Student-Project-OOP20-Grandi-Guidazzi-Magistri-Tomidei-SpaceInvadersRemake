package util;

import java.awt.Color;
import java.awt.Dimension;

/**
 * An Interface to store all the constants in the project.
 */
public interface Constants {
	
	final static Dimensions screenInfo = new Dimensions();
	final static Dimension preferDimension = new Dimension(screenInfo.getPreferScreenWidth(), screenInfo.getPreferScreenHeight());
	final static Dimension maxLabelDimension = new Dimension(screenInfo.getMaxLabelWidth(), screenInfo.getMaxLabelHeight());
	final static int titleSize = 60;
	final static int subtitleSize = 25;
	final static int minPodium = 1;
	final static int maxPodium = 3;
	final static Color colorTitle = Color.cyan;
	final static Color colorSubtitle = Color.white;
	final static boolean IN_LOOP = true;
	final static boolean NOT_IN_LOOP = false;
	final static float VOLUME_LEVEL_START = 0.7f;
	final static int SPACING = 1;
	final static int minSliderValue = 0;
	final static int maxSliderValue = 10;
}
