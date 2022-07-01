package cn.com.chinatelecom.account.api;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import cn.com.chinatelecom.account.api.a.b;
import cn.com.chinatelecom.account.api.d.d;
import cn.com.chinatelecom.account.api.d.g;
import java.security.interfaces.RSAPublicKey;

public final class ClientUtils {
  private static final String TAG = ClientUtils.class.getSimpleName();
  
  public static final int TYPE_SDK_API = 0;
  
  public static final int TYPE_SDK_HY = 1;
  
  private static int sdkType = 0;
  
  public static String enrdata(String paramString1, String paramString2) {
    try {
      return b.a(paramString1, (RSAPublicKey)b.a(paramString2));
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public static String getAT(Context paramContext) {
    try {
      return ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static String getApiVersion() {
    return "3.0";
  }
  
  public static String getCurrentNetworkType(Context paramContext) {
    return g.f(paramContext);
  }
  
  public static boolean getHealthy(Context paramContext) {
    try {
      return d.d(paramContext);
    } finally {
      paramContext = null;
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getHealthy error ：");
      stringBuilder.append(paramContext.getMessage());
      CtAuth.warn(str, stringBuilder.toString(), (Throwable)paramContext);
    } 
  }
  
  public static boolean getMacData() {
    try {
      return d.c();
    } finally {
      Exception exception = null;
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getMacData error ：");
      stringBuilder.append(exception.getMessage());
      CtAuth.warn(str, stringBuilder.toString(), exception);
    } 
  }
  
  public static String getMobileBrand() {
    return Build.BRAND;
  }
  
  public static String getModel() {
    return Build.MODEL;
  }
  
  public static boolean getNetSafe(Context paramContext) {
    try {
      return d.c(paramContext);
    } finally {
      paramContext = null;
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getNetSafe error ：");
      stringBuilder.append(paramContext.getMessage());
      CtAuth.warn(str, stringBuilder.toString(), (Throwable)paramContext);
    } 
  }
  
  public static String getOnlineType(Context paramContext) {
    return g.g(paramContext);
  }
  
  public static String getOperatorType(Context paramContext) {
    return "";
  }
  
  public static String getOs() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getMobileBrand());
    stringBuilder.append("-");
    stringBuilder.append(getModel());
    stringBuilder.append("-A:");
    stringBuilder.append(Build.VERSION.RELEASE);
    return stringBuilder.toString();
  }
  
  public static String getPID() {
    String str2 = "";
    String str1 = str2;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      str1 = str2;
      stringBuilder.append(Thread.currentThread().getId());
      str1 = str2;
      stringBuilder.append("");
      str1 = str2;
      stringBuilder.append(Process.myPid());
      str1 = str2;
      str2 = stringBuilder.toString();
      str1 = str2;
      if (str2.length() > 6) {
        str1 = str2;
        return str2.substring(0, 6);
      } 
      return "ctacco";
    } catch (Exception exception) {
      exception.printStackTrace();
      return str1;
    } 
  }
  
  public static int getSdkType() {
    return sdkType;
  }
  
  public static String getSdkVersion() {
    return (sdkType == 1) ? "SDK-HY-v3.7.3" : "SDK-API-v3.7.3";
  }
  
  public static boolean getTimePass(Context paramContext) {
    boolean bool = false;
    try {
      return true;
    } finally {
      paramContext = null;
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getTimePass error ：");
      stringBuilder.append(paramContext.getMessage());
      CtAuth.warn(str, stringBuilder.toString(), (Throwable)paramContext);
    } 
  }
  
  public static long getTp() {
    return System.currentTimeMillis();
  }
  
  public static boolean isAT(Context paramContext, String paramString) {
    try {
      return ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName().equals(paramString);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static boolean objChange(Object paramObject, String paramString) {
    try {
      return d.a(paramObject, paramString);
    } finally {
      paramObject = null;
      paramString = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("objChange error ：");
      stringBuilder.append(paramObject.getMessage());
      CtAuth.warn(paramString, stringBuilder.toString(), (Throwable)paramObject);
    } 
  }
  
  public static void setSdkType(int paramInt) {
    sdkType = paramInt;
  }
  
  public static String strBuf() {
    try {
      return d.b().toString();
    } finally {
      Exception exception = null;
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("strBuf error ：");
      stringBuilder.append(exception.getMessage());
      CtAuth.warn(str, stringBuilder.toString(), exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\ClientUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */