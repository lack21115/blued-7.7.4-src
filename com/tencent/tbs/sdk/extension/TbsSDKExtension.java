package com.tencent.tbs.sdk.extension;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;

public class TbsSDKExtension {
  public static final boolean BUILD_TARGET_PARTNER = true;
  
  public static String mNotLoadSo;
  
  private b a;
  
  private c b;
  
  private d c;
  
  private String d;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public TbsSDKExtension(Context paramContext1, Context paramContext2) {
    this(paramContext1, paramContext2, null, null, null);
  }
  
  public TbsSDKExtension(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String paramString3) {
    try {
      this.d = paramString2;
      mNotLoadSo = paramString3;
      this.a = Class.forName("com.tencent.tbs.sdk.extension.partner.PartnerSDKExtensionServiceImpl").getConstructor(new Class[] { Context.class, Context.class, String.class }).newInstance(new Object[] { paramContext1, paramContext2, this.d });
      this.b = (c)this.a;
      return;
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    } 
  }
  
  public static boolean canOpenMimeFileType(String paramString) {
    return (paramString != null) ? ((paramString.length() == 0) ? false : ((paramString.equals("audio/mpeg") || paramString.equals("application/pdf") || paramString.equals("application/vnd.ms-powerpoint") || paramString.equals("application/msword") || paramString.equals("application/vnd.ms-excel") || paramString.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") || paramString.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.template") || paramString.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document") || paramString.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.template") || paramString.equals("application/zip") || paramString.equals("text/plain") || paramString.equals("ext/x-c++hdr")))) : false;
  }
  
  public static File getTbsFolderDir(Context paramContext) {
    if (paramContext == null)
      return null; 
    try {
      if (is64BitImpl())
        return paramContext.getDir("tbs_64", 0); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return paramContext.getDir("tbs", 0);
  }
  
  public static boolean is64BitImpl() {
    try {
      if (Build.VERSION.SDK_INT < 21)
        return false; 
      Class<?> clazz = Class.forName("dalvik.system.VMRuntime");
      if (clazz == null)
        return false; 
      Method method2 = clazz.getDeclaredMethod("getRuntime", new Class[0]);
      if (method2 == null)
        return false; 
      Object object2 = method2.invoke(null, new Object[0]);
      if (object2 == null)
        return false; 
      Method method1 = clazz.getDeclaredMethod("is64Bit", new Class[0]);
      if (method1 == null)
        return false; 
      Object object1 = method1.invoke(object2, new Object[0]);
      if (object1 instanceof Boolean)
        return ((Boolean)object1).booleanValue(); 
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
    return false;
  }
  
  public static boolean isSuiteableGetSensitative() {
    return true;
  }
  
  public boolean canLoadVideo(int paramInt) {
    return this.a.b(paramInt);
  }
  
  public boolean canLoadX5(int paramInt) {
    return this.a.c(paramInt);
  }
  
  public Bundle canLoadX5Core(int paramInt) {
    return this.b.d(paramInt);
  }
  
  public Bundle canLoadX5CoreAndNotLoadSo(int paramInt) {
    return this.b.e(paramInt);
  }
  
  public Boolean canLoadX5CoreForThirdApp() {
    return Boolean.valueOf(true);
  }
  
  public boolean canUseGamePlayer() {
    return this.b.c();
  }
  
  public boolean canUseVideoFeatrue(int paramInt) {
    return this.b.f(paramInt);
  }
  
  public void dispatchEmergencyCommand(Integer paramInteger, Map<Integer, String> paramMap) {
    this.b.d();
  }
  
  public String getCanLoadX5FailedReason() {
    return this.c.a();
  }
  
  public int getErrorCodeForLogReport() {
    return this.b.b();
  }
  
  public String[] getJarFiles(Context paramContext1, Context paramContext2, String paramString) {
    return this.a.a(paramContext1, paramContext2, paramString);
  }
  
  public String[] getJarFiles(Context paramContext1, Context paramContext2, String paramString, int paramInt) {
    return null;
  }
  
  public String getLibraryPath(Context paramContext1, Context paramContext2) {
    return this.a.a(paramContext1, paramContext2);
  }
  
  public Bundle incrUpdate(Context paramContext, Bundle paramBundle) {
    return this.b.a(paramContext, paramBundle);
  }
  
  public boolean isX5Disabled(int paramInt1, int paramInt2) {
    return this.a.a(paramInt1, paramInt2);
  }
  
  public boolean isX5Disabled(int paramInt1, int paramInt2, int paramInt3) {
    return this.b.a(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean isX5DisabledSync(int paramInt1, int paramInt2) {
    return this.b.b(paramInt1, paramInt2);
  }
  
  public Object miscCall(String paramString, Bundle paramBundle) {
    return this.a.a(paramString, paramBundle);
  }
  
  public void putInfo(String paramString1, String paramString2, String paramString3, String paramString4) {
    this.b.a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setClientVersion(int paramInt) {}
  
  public void setHostContext(Context paramContext) {}
  
  public boolean useSoftWare() {
    return this.b.a();
  }
  
  public boolean useSoftWare(int paramInt) {
    return this.a.a(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\TbsSDKExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */