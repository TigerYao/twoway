package com.example.twoway;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class DensityUtils {

	public static float pxToDp(float pixels) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return pixels / (metrics.densityDpi / 160f);
    }

    /**
     * Converts the given dp measurement to pixels.
     * @param dp The measurement, in dp
     * @return The corresponding amount of pixels based on the device's screen density
     */
    public static float dpToPx(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * (metrics.densityDpi / 160f);
    }
}
