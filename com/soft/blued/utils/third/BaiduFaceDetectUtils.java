package com.soft.blued.utils.third;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.aip.FaceSDKManager;
import com.baidu.idl.facesdk.FaceTracker;

public class BaiduFaceDetectUtils {
  public static int a(Activity paramActivity) {
    ContentResolver contentResolver = paramActivity.getContentResolver();
    try {
      return Settings.System.getInt(contentResolver, "screen_brightness");
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0;
    } 
  }
  
  public static void a(Activity paramActivity, int paramInt) {
    WindowManager.LayoutParams layoutParams = paramActivity.getWindow().getAttributes();
    layoutParams.screenBrightness = Float.valueOf(paramInt).floatValue() * 0.003921569F;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("set  lp.screenBrightness == ");
    stringBuilder.append(layoutParams.screenBrightness);
    Log.d("lxy", stringBuilder.toString());
    paramActivity.getWindow().setAttributes(layoutParams);
  }
  
  public static void a(Context paramContext) {
    FaceSDKManager.getInstance().init(paramContext, "Blued-China-face-android", "idl-license.face-android");
    b(paramContext);
  }
  
  private static void b(Context paramContext) {
    FaceTracker faceTracker = FaceSDKManager.getInstance().getFaceTracker(paramContext);
    faceTracker.set_blur_thr(0.7F);
    faceTracker.set_illum_thr(40.0F);
    faceTracker.set_cropFaceSize(400);
    faceTracker.set_eulur_angle_thr(10, 10, 10);
    faceTracker.set_min_face_size(200);
    faceTracker.set_notFace_thr(0.6F);
    faceTracker.set_occlu_thr(0.5F);
    faceTracker.set_isCheckQuality(true);
    faceTracker.set_isVerifyLive(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\third\BaiduFaceDetectUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */