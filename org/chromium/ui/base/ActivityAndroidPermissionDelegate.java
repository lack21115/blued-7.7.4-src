package org.chromium.ui.base;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ContextUtils;

public class ActivityAndroidPermissionDelegate implements AndroidPermissionDelegate {
  private WeakReference mActivity;
  
  private Handler mHandler;
  
  private int mNextRequestCode;
  
  private SparseArray mOutstandingPermissionRequests;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ActivityAndroidPermissionDelegate(WeakReference paramWeakReference) {
    this.mActivity = paramWeakReference;
    this.mHandler = new Handler();
    this.mOutstandingPermissionRequests = new SparseArray();
  }
  
  private static String getHasRequestedPermissionKey(String paramString) {
    String str = paramString;
    if (Build.VERSION.SDK_INT < 26)
      try {
        PermissionInfo permissionInfo = ContextUtils.sApplicationContext.getPackageManager().getPermissionInfo(paramString, 128);
        str = paramString;
        if (!TextUtils.isEmpty(permissionInfo.group))
          str = permissionInfo.group; 
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        str = paramString;
      }  
    StringBuilder stringBuilder = new StringBuilder("HasRequestedAndroidPermission::");
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  public boolean canRequestPermission(String paramString) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #23
    //   5: if_icmpge -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_0
    //   11: getfield mActivity : Ljava/lang/ref/WeakReference;
    //   14: invokevirtual get : ()Ljava/lang/Object;
    //   17: checkcast android/app/Activity
    //   20: astore_3
    //   21: aload_3
    //   22: ifnonnull -> 27
    //   25: iconst_0
    //   26: ireturn
    //   27: getstatic android/os/Build$VERSION.SDK_INT : I
    //   30: bipush #23
    //   32: if_icmpge -> 40
    //   35: iconst_0
    //   36: istore_2
    //   37: goto -> 75
    //   40: aload_0
    //   41: getfield mActivity : Ljava/lang/ref/WeakReference;
    //   44: invokevirtual get : ()Ljava/lang/Object;
    //   47: checkcast android/app/Activity
    //   50: astore #4
    //   52: aload #4
    //   54: ifnonnull -> 60
    //   57: goto -> 35
    //   60: aload #4
    //   62: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   65: aload_1
    //   66: aload #4
    //   68: invokevirtual getPackageName : ()Ljava/lang/String;
    //   71: invokevirtual isPermissionRevokedByPolicy : (Ljava/lang/String;Ljava/lang/String;)Z
    //   74: istore_2
    //   75: iload_2
    //   76: ifeq -> 81
    //   79: iconst_0
    //   80: ireturn
    //   81: aload_3
    //   82: aload_1
    //   83: invokevirtual shouldShowRequestPermissionRationale : (Ljava/lang/String;)Z
    //   86: ifeq -> 91
    //   89: iconst_1
    //   90: ireturn
    //   91: aload_1
    //   92: invokestatic getHasRequestedPermissionKey : (Ljava/lang/String;)Ljava/lang/String;
    //   95: astore_1
    //   96: invokestatic access$100 : ()Landroid/content/SharedPreferences;
    //   99: aload_1
    //   100: iconst_0
    //   101: invokeinterface getBoolean : (Ljava/lang/String;Z)Z
    //   106: ifne -> 111
    //   109: iconst_1
    //   110: ireturn
    //   111: iconst_0
    //   112: ireturn
  }
  
  public boolean hasPermission(String paramString) {
    return (ApiCompatibilityUtils.checkPermission(ContextUtils.sApplicationContext, paramString, Process.myPid(), Process.myUid()) == 0);
  }
  
  public final void requestPermissions(String[] paramArrayOfString, PermissionCallback paramPermissionCallback) {
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if (j >= 23) {
      Activity activity = this.mActivity.get();
      if (activity != null) {
        i = this.mNextRequestCode + 1000;
        this.mNextRequestCode = (this.mNextRequestCode + 1) % 100;
        this.mOutstandingPermissionRequests.put(i, paramPermissionCallback);
        activity.requestPermissions(paramArrayOfString, i);
        i = 1;
      } 
    } 
    if (i != 0)
      return; 
    this.mHandler.post(new ActivityAndroidPermissionDelegate$1(this, paramArrayOfString, paramPermissionCallback));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\ActivityAndroidPermissionDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */