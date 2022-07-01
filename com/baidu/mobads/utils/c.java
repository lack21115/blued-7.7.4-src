package com.baidu.mobads.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;

public class c {
  private static c b;
  
  private com.baidu.mobads.nativecpu.a.c a;
  
  private c(Context paramContext) {
    this.a = com.baidu.mobads.nativecpu.a.c.a(paramContext, "com.component.interfaces.RemoteReflectInterface");
  }
  
  public static c a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/baidu/mobads/utils/c.b : Lcom/baidu/mobads/utils/c;
    //   3: ifnonnull -> 38
    //   6: ldc com/baidu/mobads/utils/c
    //   8: monitorenter
    //   9: getstatic com/baidu/mobads/utils/c.b : Lcom/baidu/mobads/utils/c;
    //   12: ifnonnull -> 26
    //   15: new com/baidu/mobads/utils/c
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/baidu/mobads/utils/c.b : Lcom/baidu/mobads/utils/c;
    //   26: ldc com/baidu/mobads/utils/c
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/baidu/mobads/utils/c
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/baidu/mobads/utils/c.b : Lcom/baidu/mobads/utils/c;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public int a(Context paramContext, String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      if (XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(paramContext, paramString))
        return 103; 
      Object object = this.a.b(null, "getDownloadStatus", new Object[] { paramString });
      if (object instanceof Integer)
        return ((Integer)object).intValue(); 
    } 
    return -1;
  }
  
  public void a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.a.a(null, "pauseDlByPk", new Object[] { paramString }); 
  }
  
  public boolean a(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, String paramString1, String paramString2) {
    if (paramContext != null && paramIXAdInstanceInfo != null) {
      Object object = this.a.b(null, "resumeDownload", new Object[] { paramContext, paramIXAdInstanceInfo, paramString1, paramString2 });
      if (object instanceof Boolean)
        return ((Boolean)object).booleanValue(); 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */