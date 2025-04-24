package com.nc.max;

import com.nc.max.tools.HelperFunctions;
import java.awt.Color;
import java.util.Locale;

public class Globals {

    public static final int HEIGHT = 430;
    public static final int WIDTH = 480;

    public static final boolean MAXIMIZED = false;
    public static final boolean DEBUG = true;
    
    public static final Locale DEFAULT_LOCALE = Locale.US;

    public static final String BUNDLE_PATH = "com.nc.max.bundle.max";

    //Images
    public static final String APP_LOGO_PATH = System.getProperty("user.dir") + "/images/kdf.png";

    //Colors
    public static final Color COLOR_BLUE = HelperFunctions.getColorFromHex("#2196F3");
    public static final Color COLOR_INDIGO = HelperFunctions.getColorFromHex("#3f51b5");
}
