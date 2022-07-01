package com.sina.weibo.sdk.component;

import android.content.Context;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import java.util.HashMap;
import java.util.Map;

public class WeiboCallbackManager {
  private static WeiboCallbackManager sInstance;
  
  private Context mContext;
  
  private Map<String, WeiboAuthListener> mWeiboAuthListenerMap;
  
  private Map<String, WidgetRequestParam.WidgetRequestCallback> mWidgetRequestCallbackMap;
  
  private WeiboCallbackManager(Context paramContext) {
    this.mContext = paramContext;
    this.mWeiboAuthListenerMap = new HashMap<String, WeiboAuthListener>();
    this.mWidgetRequestCallbackMap = new HashMap<String, WidgetRequestParam.WidgetRequestCallback>();
  }
  
  public static WeiboCallbackManager getInstance(Context paramContext) {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/component/WeiboCallbackManager
    //   2: monitorenter
    //   3: getstatic com/sina/weibo/sdk/component/WeiboCallbackManager.sInstance : Lcom/sina/weibo/sdk/component/WeiboCallbackManager;
    //   6: ifnonnull -> 20
    //   9: new com/sina/weibo/sdk/component/WeiboCallbackManager
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/sina/weibo/sdk/component/WeiboCallbackManager.sInstance : Lcom/sina/weibo/sdk/component/WeiboCallbackManager;
    //   20: getstatic com/sina/weibo/sdk/component/WeiboCallbackManager.sInstance : Lcom/sina/weibo/sdk/component/WeiboCallbackManager;
    //   23: astore_0
    //   24: ldc com/sina/weibo/sdk/component/WeiboCallbackManager
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/sina/weibo/sdk/component/WeiboCallbackManager
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  public String genCallbackKey() {
    return String.valueOf(System.currentTimeMillis());
  }
  
  public WeiboAuthListener getWeiboAuthListener(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield mWeiboAuthListenerMap : Ljava/util/Map;
    //   19: aload_1
    //   20: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast com/sina/weibo/sdk/auth/WeiboAuthListener
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   15	29	33	finally
  }
  
  public WidgetRequestParam.WidgetRequestCallback getWidgetRequestCallback(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield mWidgetRequestCallbackMap : Ljava/util/Map;
    //   19: aload_1
    //   20: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast com/sina/weibo/sdk/component/WidgetRequestParam$WidgetRequestCallback
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   15	29	33	finally
  }
  
  public void removeWeiboAuthListener(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield mWeiboAuthListenerMap : Ljava/util/Map;
    //   18: aload_1
    //   19: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   24: pop
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   14	25	28	finally
  }
  
  public void removeWidgetRequestCallback(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield mWidgetRequestCallbackMap : Ljava/util/Map;
    //   18: aload_1
    //   19: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   24: pop
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   14	25	28	finally
  }
  
  public void setWeiboAuthListener(String paramString, WeiboAuthListener paramWeiboAuthListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifne -> 31
    //   9: aload_2
    //   10: ifnonnull -> 16
    //   13: goto -> 31
    //   16: aload_0
    //   17: getfield mWeiboAuthListenerMap : Ljava/util/Map;
    //   20: aload_1
    //   21: aload_2
    //   22: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   27: pop
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	34	finally
    //   16	28	34	finally
  }
  
  public void setWidgetRequestCallback(String paramString, WidgetRequestParam.WidgetRequestCallback paramWidgetRequestCallback) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifne -> 31
    //   9: aload_2
    //   10: ifnonnull -> 16
    //   13: goto -> 31
    //   16: aload_0
    //   17: getfield mWidgetRequestCallbackMap : Ljava/util/Map;
    //   20: aload_1
    //   21: aload_2
    //   22: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   27: pop
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	34	finally
    //   16	28	34	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\WeiboCallbackManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */