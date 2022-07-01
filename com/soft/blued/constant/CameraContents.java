package com.soft.blued.constant;

import com.soft.blued.ui.login_register.AdultVerifyFragment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CameraContents {
  public static ExecutorService a = Executors.newSingleThreadExecutor();
  
  public static String b = "camera_background_thread";
  
  public static String c = "face_";
  
  public static final SimpleDateFormat d = new SimpleDateFormat("yy_MM_dd_HH-mm_ss");
  
  public static AdultVerifyFragment.AV_START_PAGE e;
  
  public static interface From {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FromDef {}
  
  public static interface INTENT_DATA_KEY {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\constant\CameraContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */