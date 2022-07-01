package a.a.a.a.a.e;

import android.os.Build;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;

public class d {
  public static final String[] a = new String[] { "com.yaoyao.live" };
  
  public static final String b;
  
  public static final CameraStreamingSetting.PREVIEW_SIZE_RATIO c = CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_16_9;
  
  public static final CameraStreamingSetting.PREVIEW_SIZE_LEVEL d = CameraStreamingSetting.PREVIEW_SIZE_LEVEL.MEDIUM;
  
  public static final String[] e = new String[] { "GT-I9260" };
  
  public static final String[] f = new String[] { "GT-I9260" };
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("FMLE/3.0(compatible;librtmp-1.1.0;PLDroidCameraStreaming-3.0.0;Android-");
    stringBuilder.append(Build.VERSION.RELEASE);
    stringBuilder.append(";");
    stringBuilder.append(Build.BRAND);
    stringBuilder.append("-");
    stringBuilder.append(Build.MODEL);
    stringBuilder.append(")");
    b = stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */