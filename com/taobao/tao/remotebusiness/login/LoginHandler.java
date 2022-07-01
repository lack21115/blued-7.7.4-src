package com.taobao.tao.remotebusiness.login;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.xstate.a;

class LoginHandler extends Handler implements onLoginListener {
  public static final int LOGIN_CANCEL = 911103;
  
  public static final int LOGIN_FAILED = 911102;
  
  public static final int LOGIN_SUCCESS = 911101;
  
  public static final int LOGIN_TIMEOUT = 911104;
  
  private static final String TAG = "mtop.rb-LoginHandler";
  
  private static LoginHandler mHandler;
  
  private LoginHandler(Looper paramLooper) {
    super(paramLooper);
  }
  
  private static void checkXStateSessionInfo() {
    LoginContext loginContext = RemoteLogin.getLoginContext();
    if (loginContext == null)
      return; 
    try {
      if (StringUtils.a(loginContext.sid) && !loginContext.sid.equals(a.a())) {
        Mtop.a(SDKConfig.a().b()).a(loginContext.sid, loginContext.userId);
        TBSdkLog.b("mtop.rb-LoginHandler", "[checkXStateSessionInfo] invoked");
      } 
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("[checkXStateSessionInfo] error ---");
      stringBuilder.append(exception.toString());
      TBSdkLog.d("mtop.rb-LoginHandler", stringBuilder.toString());
      return;
    } 
  }
  
  public static LoginHandler instance() {
    // Byte code:
    //   0: ldc com/taobao/tao/remotebusiness/login/LoginHandler
    //   2: monitorenter
    //   3: getstatic com/taobao/tao/remotebusiness/login/LoginHandler.mHandler : Lcom/taobao/tao/remotebusiness/login/LoginHandler;
    //   6: ifnonnull -> 22
    //   9: new com/taobao/tao/remotebusiness/login/LoginHandler
    //   12: dup
    //   13: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   16: invokespecial <init> : (Landroid/os/Looper;)V
    //   19: putstatic com/taobao/tao/remotebusiness/login/LoginHandler.mHandler : Lcom/taobao/tao/remotebusiness/login/LoginHandler;
    //   22: getstatic com/taobao/tao/remotebusiness/login/LoginHandler.mHandler : Lcom/taobao/tao/remotebusiness/login/LoginHandler;
    //   25: astore_0
    //   26: ldc com/taobao/tao/remotebusiness/login/LoginHandler
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc com/taobao/tao/remotebusiness/login/LoginHandler
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	31	finally
    //   22	26	31	finally
  }
  
  public void handleMessage(Message paramMessage) {
    // Byte code:
    //   0: ldc 'mtop.rb-LoginHandler'
    //   2: ldc 'The RemoteBusiness handler message received.'
    //   4: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_1
    //   8: getfield what : I
    //   11: tableswitch default -> 40, 911101 -> 102, 911102 -> 86, 911103 -> 61, 911104 -> 41
    //   40: return
    //   41: invokestatic isSessionValid : ()Z
    //   44: ifeq -> 118
    //   47: ldc 'mtop.rb-LoginHandler'
    //   49: ldc 'Session valid, Broadcast may missed!'
    //   51: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   54: invokestatic checkXStateSessionInfo : ()V
    //   57: invokestatic a : ()V
    //   60: return
    //   61: ldc 'mtop.rb-LoginHandler'
    //   63: ldc 'onReceive: NOTIFY_LOGINCANCEL.'
    //   65: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc 'FAIL_SYS_LOGIN_CANCEL'
    //   70: astore_2
    //   71: ldc '登陆被取消'
    //   73: astore_1
    //   74: aload_2
    //   75: aload_1
    //   76: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: ldc 911104
    //   82: invokevirtual removeMessages : (I)V
    //   85: return
    //   86: ldc 'mtop.rb-LoginHandler'
    //   88: ldc 'onReceive: NOTIFY_LOGINFAILED.'
    //   90: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   93: ldc 'FAIL_SYS_LOGIN_FAIL'
    //   95: astore_2
    //   96: ldc '登陆失败'
    //   98: astore_1
    //   99: goto -> 74
    //   102: ldc 'mtop.rb-LoginHandler'
    //   104: ldc 'onReceive: NOTIFY_LOGIN_SUCCESS.'
    //   106: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   109: invokestatic checkXStateSessionInfo : ()V
    //   112: invokestatic a : ()V
    //   115: goto -> 79
    //   118: return
  }
  
  public void onLoginCancel() {
    sendEmptyMessage(911103);
  }
  
  public void onLoginFail() {
    sendEmptyMessage(911102);
  }
  
  public void onLoginSuccess() {
    sendEmptyMessage(911101);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\login\LoginHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */