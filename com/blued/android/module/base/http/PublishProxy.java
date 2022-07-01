package com.blued.android.module.base.http;

import android.content.Context;
import com.blued.android.module.base.base.BaseProxy;

public class PublishProxy extends BaseProxy<IPublish> implements IPublish {
  private static PublishProxy b;
  
  public static PublishProxy a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/base/http/PublishProxy.b : Lcom/blued/android/module/base/http/PublishProxy;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/base/http/PublishProxy
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/base/http/PublishProxy.b : Lcom/blued/android/module/base/http/PublishProxy;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/base/http/PublishProxy
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/base/http/PublishProxy.b : Lcom/blued/android/module/base/http/PublishProxy;
    //   25: ldc com/blued/android/module/base/http/PublishProxy
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/base/http/PublishProxy
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/base/http/PublishProxy.b : Lcom/blued/android/module/base/http/PublishProxy;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(Context paramContext, int paramInt, ILiveApplyListener paramILiveApplyListener) {
    if (this.a != null)
      ((IPublish)this.a).a(paramContext, paramInt, paramILiveApplyListener); 
  }
  
  public void a(Context paramContext, String paramString, int paramInt, IUploadAuthVideoListener paramIUploadAuthVideoListener) {
    if (this.a != null)
      ((IPublish)this.a).a(paramContext, paramString, paramInt, paramIUploadAuthVideoListener); 
  }
  
  public static interface ILiveApplyListener {
    void a();
    
    void a(int param1Int, String param1String);
  }
  
  public static interface IUploadAuthVideoListener {
    void a(int param1Int, String param1String);
    
    void a(String param1String, double param1Double);
    
    boolean a();
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\base\http\PublishProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */