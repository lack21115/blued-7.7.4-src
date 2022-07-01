package com.huawei.hms.support.api.push.pushselfshow.prepare;

import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.push.pushselfshow.entity.PushSelfShowMessage;
import com.huawei.hms.support.api.push.pushselfshow.utils.ResourceLoader;
import com.huawei.hms.support.log.HMSLog;

public class NotificationIconUtil {
  public static final int ICON_RES_SIZE = 3;
  
  public static final int INDEX_DRAWABLE = 1;
  
  public static final int INDEX_RESNAME = 2;
  
  public static final String SPLIT_CHAR = "/";
  
  public static final String TAG = "PushSelfShowLog";
  
  public static Bitmap buildLeftIcon(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage) {
    if (paramContext != null) {
      if (paramPushSelfShowMessage == null)
        return null; 
      try {
        int i = HwBuildEx.VERSION.EMUI_SDK_INT;
        if (i >= 11) {
          HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
          return null;
        } 
        if (!"com.huawei.android.pushagent".equals(paramPushSelfShowMessage.getDispPkgName())) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("get left bitmap from ");
          stringBuilder.append(paramPushSelfShowMessage.getDispPkgName());
          HMSLog.i("PushSelfShowLog", stringBuilder.toString());
          return ((BitmapDrawable)paramContext.getPackageManager().getApplicationIcon(paramPushSelfShowMessage.getDispPkgName())).getBitmap();
        } 
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(nameNotFoundException.toString());
        HMSLog.e("PushSelfShowLog", stringBuilder.toString(), (Throwable)nameNotFoundException);
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(exception.toString());
        HMSLog.e("PushSelfShowLog", stringBuilder.toString(), exception);
        return null;
      } 
    } 
    return null;
  }
  
  public static int getDefaultSmallIconId(Context paramContext) {
    int j = (paramContext.getApplicationInfo()).icon;
    int i = j;
    if (j == 0) {
      j = paramContext.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
      HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
      i = j;
      if (j == 0) {
        i = 17301651;
        HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
      } 
    } 
    return i;
  }
  
  public static int getSmallIconId(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage) {
    int j = 0;
    if (paramContext == null || paramPushSelfShowMessage == null) {
      HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
      return 0;
    } 
    int i = j;
    if (!TextUtils.isEmpty(paramPushSelfShowMessage.getIcon())) {
      String[] arrayOfString = paramPushSelfShowMessage.getIcon().split("/");
      i = j;
      if (arrayOfString.length == 3)
        i = ResourceLoader.loadResourceId(paramContext, arrayOfString[1], arrayOfString[2]); 
    } 
    j = i;
    if (i == 0)
      j = ResourceLoader.loadDrawableResourceIdByMetaDataName(paramContext, "com.huawei.messaging.default_notification_icon"); 
    return (j != 0) ? j : getDefaultSmallIconId(paramContext);
  }
  
  public static void setSmallIcon(Context paramContext, Notification.Builder paramBuilder, PushSelfShowMessage paramPushSelfShowMessage) {
    if (paramContext == null || paramBuilder == null || paramPushSelfShowMessage == null) {
      HMSLog.e("PushSelfShowLog", "msg is null");
      return;
    } 
    paramBuilder.setSmallIcon(getSmallIconId(paramContext, paramPushSelfShowMessage));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\pushselfshow\prepare\NotificationIconUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */