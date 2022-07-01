package com.taobao.tao.remotebusiness.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Method;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;

public final class DefaultLoginImpl implements IRemoteLogin {
  private static final String MTOP_API_REFERENCE = "apiReferer";
  
  private static final String TAG = "mtop.rb-DefaultLoginImpl";
  
  public static volatile DefaultLoginImpl instance;
  
  private static ThreadLocal threadLocal = new ThreadLocal();
  
  private Method checkSessionValidMethod;
  
  private Method getNickMethod;
  
  private Method getSidMethod;
  
  private Method getUserIdMethod;
  
  private Method isLoginingMethod;
  
  private Class loginBroadcastHelperCls = null;
  
  private Class loginCls = null;
  
  private LoginContext loginContext = new LoginContext();
  
  private Method loginMethod;
  
  private Class loginStatusCls = null;
  
  protected BroadcastReceiver receiver = null;
  
  private Method registerReceiverMethod;
  
  static {
    instance = null;
  }
  
  private DefaultLoginImpl() {
    try {
      this.loginCls = Class.forName("com.taobao.login4android.Login");
    } catch (ClassNotFoundException classNotFoundException) {
      this.loginCls = Class.forName("com.taobao.login4android.api.Login");
    } 
    this.loginMethod = this.loginCls.getDeclaredMethod("login", new Class[] { boolean.class, Bundle.class });
    this.checkSessionValidMethod = this.loginCls.getDeclaredMethod("checkSessionValid", new Class[0]);
    this.getSidMethod = this.loginCls.getDeclaredMethod("getSid", new Class[0]);
    this.getUserIdMethod = this.loginCls.getDeclaredMethod("getUserId", new Class[0]);
    this.getNickMethod = this.loginCls.getDeclaredMethod("getNick", new Class[0]);
    this.loginStatusCls = Class.forName("com.taobao.login4android.constants.LoginStatus");
    this.isLoginingMethod = this.loginStatusCls.getDeclaredMethod("isLogining", new Class[0]);
    this.loginBroadcastHelperCls = Class.forName("com.taobao.login4android.broadcast.LoginBroadcastHelper");
    this.registerReceiverMethod = this.loginBroadcastHelperCls.getMethod("registerLoginReceiver", new Class[] { Context.class, BroadcastReceiver.class });
    registerReceiver();
    TBSdkLog.b("mtop.rb-DefaultLoginImpl", "register login event receiver");
  }
  
  public static DefaultLoginImpl getDefaultLoginImpl() {
    // Byte code:
    //   0: getstatic com/taobao/tao/remotebusiness/login/DefaultLoginImpl.instance : Lcom/taobao/tao/remotebusiness/login/DefaultLoginImpl;
    //   3: ifnonnull -> 55
    //   6: ldc com/taobao/tao/remotebusiness/login/DefaultLoginImpl
    //   8: monitorenter
    //   9: getstatic com/taobao/tao/remotebusiness/login/DefaultLoginImpl.instance : Lcom/taobao/tao/remotebusiness/login/DefaultLoginImpl;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull -> 43
    //   17: new com/taobao/tao/remotebusiness/login/DefaultLoginImpl
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: putstatic com/taobao/tao/remotebusiness/login/DefaultLoginImpl.instance : Lcom/taobao/tao/remotebusiness/login/DefaultLoginImpl;
    //   27: goto -> 43
    //   30: astore_0
    //   31: aconst_null
    //   32: putstatic com/taobao/tao/remotebusiness/login/DefaultLoginImpl.instance : Lcom/taobao/tao/remotebusiness/login/DefaultLoginImpl;
    //   35: ldc 'mtop.rb-DefaultLoginImpl'
    //   37: ldc 'DefaultLoginImpl instance error'
    //   39: aload_0
    //   40: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   43: ldc com/taobao/tao/remotebusiness/login/DefaultLoginImpl
    //   45: monitorexit
    //   46: goto -> 55
    //   49: astore_0
    //   50: ldc com/taobao/tao/remotebusiness/login/DefaultLoginImpl
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    //   55: getstatic com/taobao/tao/remotebusiness/login/DefaultLoginImpl.instance : Lcom/taobao/tao/remotebusiness/login/DefaultLoginImpl;
    //   58: areturn
    // Exception table:
    //   from	to	target	type
    //   9	13	49	finally
    //   17	27	30	java/lang/Exception
    //   17	27	49	finally
    //   31	43	49	finally
    //   43	46	49	finally
  }
  
  private Object invokeMethod(Method paramMethod, Object... paramVarArgs) {
    if (paramMethod != null)
      try {
        return paramMethod.invoke(this.loginCls, paramVarArgs);
      } catch (Exception exception) {
        TBSdkLog.b("mtop.rb-DefaultLoginImpl", "invokeMethod error", exception);
      }  
    return null;
  }
  
  private void registerReceiver() {
    // Byte code:
    //   0: aload_0
    //   1: getfield receiver : Landroid/content/BroadcastReceiver;
    //   4: ifnonnull -> 82
    //   7: invokestatic a : ()Lmtopsdk/mtop/global/SDKConfig;
    //   10: invokevirtual b : ()Landroid/content/Context;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull -> 26
    //   18: ldc 'mtop.rb-DefaultLoginImpl'
    //   20: ldc 'Context is null, register receiver fail.'
    //   22: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   25: return
    //   26: ldc com/taobao/tao/remotebusiness/login/DefaultLoginImpl
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield receiver : Landroid/content/BroadcastReceiver;
    //   33: ifnonnull -> 72
    //   36: aload_0
    //   37: new com/taobao/tao/remotebusiness/login/DefaultLoginImpl$1
    //   40: dup
    //   41: aload_0
    //   42: invokespecial <init> : (Lcom/taobao/tao/remotebusiness/login/DefaultLoginImpl;)V
    //   45: putfield receiver : Landroid/content/BroadcastReceiver;
    //   48: aload_0
    //   49: aload_0
    //   50: getfield registerReceiverMethod : Ljava/lang/reflect/Method;
    //   53: iconst_2
    //   54: anewarray java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload_0
    //   64: getfield receiver : Landroid/content/BroadcastReceiver;
    //   67: aastore
    //   68: invokespecial invokeMethod : (Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
    //   71: pop
    //   72: ldc com/taobao/tao/remotebusiness/login/DefaultLoginImpl
    //   74: monitorexit
    //   75: return
    //   76: astore_1
    //   77: ldc com/taobao/tao/remotebusiness/login/DefaultLoginImpl
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: return
    // Exception table:
    //   from	to	target	type
    //   29	72	76	finally
    //   72	75	76	finally
  }
  
  public final LoginContext getLoginContext() {
    this.loginContext.sid = (String)invokeMethod(this.getSidMethod, new Object[0]);
    this.loginContext.userId = (String)invokeMethod(this.getUserIdMethod, new Object[0]);
    this.loginContext.nickname = (String)invokeMethod(this.getNickMethod, new Object[0]);
    return this.loginContext;
  }
  
  public final boolean isLogining() {
    Boolean bool = (Boolean)invokeMethod(this.isLoginingMethod, new Object[0]);
    return (bool != null) ? bool.booleanValue() : false;
  }
  
  public final boolean isSessionValid() {
    Boolean bool = (Boolean)invokeMethod(this.checkSessionValidMethod, new Object[0]);
    return (bool != null) ? bool.booleanValue() : false;
  }
  
  public final void login(onLoginListener paramonLoginListener, boolean paramBoolean) {
    TBSdkLog.b("mtop.rb-DefaultLoginImpl", "call login");
    DefaultLoginImpl$SessionInvalidEvent defaultLoginImpl$SessionInvalidEvent = threadLocal.get();
    paramonLoginListener = null;
    String str = null;
    if (defaultLoginImpl$SessionInvalidEvent != null) {
      try {
        Bundle bundle = new Bundle();
      } catch (Exception exception1) {
      
      } finally {
        threadLocal.remove();
      } 
      threadLocal.remove();
    } 
    registerReceiver();
    invokeMethod(this.loginMethod, new Object[] { Boolean.valueOf(paramBoolean), paramonLoginListener });
  }
  
  public final void setSessionInvalid(Object paramObject) {
    if (paramObject instanceof MtopResponse) {
      threadLocal.set(new DefaultLoginImpl$SessionInvalidEvent((MtopResponse)paramObject, (String)invokeMethod(this.getNickMethod, new Object[0])));
      return;
    } 
    if (paramObject instanceof MtopRequest)
      threadLocal.set(new DefaultLoginImpl$SessionInvalidEvent((MtopRequest)paramObject)); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\login\DefaultLoginImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */