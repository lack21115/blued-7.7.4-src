package com.tencent.connect.auth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.webkit.CookieSyncManager;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.connect.a.a;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.a.f;
import com.tencent.open.utils.Global;
import com.tencent.tauth.IUiListener;

public class QQAuth {
  private AuthAgent a;
  
  private QQToken b;
  
  private QQAuth(String paramString, Context paramContext) {
    f.c("openSDK_LOG.QQAuth", "new QQAuth() --start");
    this.b = new QQToken(paramString);
    this.a = new AuthAgent(this.b);
    a.c(paramContext, this.b);
    f.c("openSDK_LOG.QQAuth", "new QQAuth() --end");
  }
  
  private int a(Activity paramActivity, Fragment paramFragment, String paramString1, IUiListener paramIUiListener, String paramString2) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   4: invokevirtual getPackageName : ()Ljava/lang/String;
    //   7: astore #5
    //   9: aload_1
    //   10: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   13: sipush #128
    //   16: invokevirtual getInstalledApplications : (I)Ljava/util/List;
    //   19: invokeinterface iterator : ()Ljava/util/Iterator;
    //   24: astore #7
    //   26: aload #7
    //   28: invokeinterface hasNext : ()Z
    //   33: ifeq -> 71
    //   36: aload #7
    //   38: invokeinterface next : ()Ljava/lang/Object;
    //   43: checkcast android/content/pm/ApplicationInfo
    //   46: astore #8
    //   48: aload #5
    //   50: aload #8
    //   52: getfield packageName : Ljava/lang/String;
    //   55: invokevirtual equals : (Ljava/lang/Object;)Z
    //   58: ifeq -> 26
    //   61: aload #8
    //   63: getfield sourceDir : Ljava/lang/String;
    //   66: astore #5
    //   68: goto -> 74
    //   71: aconst_null
    //   72: astore #5
    //   74: aload #5
    //   76: ifnull -> 171
    //   79: new java/io/File
    //   82: dup
    //   83: aload #5
    //   85: invokespecial <init> : (Ljava/lang/String;)V
    //   88: invokestatic readChannelId : (Ljava/io/File;)Ljava/lang/String;
    //   91: astore #5
    //   93: aload #5
    //   95: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   98: ifne -> 171
    //   101: new java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial <init> : ()V
    //   108: astore #7
    //   110: aload #7
    //   112: ldc '-->login channelId: '
    //   114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload #7
    //   120: aload #5
    //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: ldc 'openSDK_LOG.QQAuth'
    //   128: aload #7
    //   130: invokevirtual toString : ()Ljava/lang/String;
    //   133: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_0
    //   137: aload_1
    //   138: aload_3
    //   139: aload #4
    //   141: aload #5
    //   143: aload #5
    //   145: ldc ''
    //   147: invokevirtual loginWithOEM : (Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/tauth/IUiListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   150: istore #6
    //   152: iload #6
    //   154: ireturn
    //   155: astore #5
    //   157: ldc 'openSDK_LOG.QQAuth'
    //   159: ldc '-->login get channel id exception.'
    //   161: aload #5
    //   163: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   166: aload #5
    //   168: invokevirtual printStackTrace : ()V
    //   171: ldc 'openSDK_LOG.QQAuth'
    //   173: ldc '-->login channelId is null '
    //   175: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   178: iconst_0
    //   179: putstatic com/tencent/connect/common/BaseApi.isOEM : Z
    //   182: aload_0
    //   183: getfield a : Lcom/tencent/connect/auth/AuthAgent;
    //   186: aload_1
    //   187: aload_3
    //   188: aload #4
    //   190: iconst_0
    //   191: aload_2
    //   192: invokevirtual doLogin : (Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/tauth/IUiListener;ZLandroidx/fragment/app/Fragment;)I
    //   195: ireturn
    // Exception table:
    //   from	to	target	type
    //   79	152	155	java/io/IOException
  }
  
  public static QQAuth createInstance(String paramString, Context paramContext) {
    Global.setContext(paramContext.getApplicationContext());
    f.c("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      packageManager.getActivityInfo(new ComponentName(paramContext.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
      packageManager.getActivityInfo(new ComponentName(paramContext.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
      QQAuth qQAuth = new QQAuth(paramString, paramContext);
      f.c("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
      return qQAuth;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      f.b("openSDK_LOG.QQAuth", "createInstance() error --end", (Throwable)nameNotFoundException);
      Toast.makeText(paramContext.getApplicationContext(), "请参照文档在Androidmanifest.xml加上AuthActivity和AssitActivity的定义 ", 1).show();
      return null;
    } 
  }
  
  public void checkLogin(IUiListener paramIUiListener) {
    this.a.b(paramIUiListener);
  }
  
  public QQToken getQQToken() {
    return this.b;
  }
  
  public boolean isSessionValid() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isSessionValid(), result = ");
    if (this.b.isSessionValid()) {
      str = "true";
    } else {
      str = "false";
    } 
    stringBuilder.append(str);
    stringBuilder.append("");
    f.a("openSDK_LOG.QQAuth", stringBuilder.toString());
    return this.b.isSessionValid();
  }
  
  public int login(Activity paramActivity, String paramString, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.QQAuth", "login()");
    return login(paramActivity, paramString, paramIUiListener, "");
  }
  
  public int login(Activity paramActivity, String paramString1, IUiListener paramIUiListener, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("-->login activity: ");
    stringBuilder.append(paramActivity);
    f.c("openSDK_LOG.QQAuth", stringBuilder.toString());
    return a(paramActivity, null, paramString1, paramIUiListener, paramString2);
  }
  
  public int login(Fragment paramFragment, String paramString1, IUiListener paramIUiListener, String paramString2) {
    FragmentActivity fragmentActivity = paramFragment.getActivity();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("-->login activity: ");
    stringBuilder.append(fragmentActivity);
    f.c("openSDK_LOG.QQAuth", stringBuilder.toString());
    return a((Activity)fragmentActivity, paramFragment, paramString1, paramIUiListener, paramString2);
  }
  
  @Deprecated
  public int loginWithOEM(Activity paramActivity, String paramString1, IUiListener paramIUiListener, String paramString2, String paramString3, String paramString4) {
    f.c("openSDK_LOG.QQAuth", "loginWithOEM");
    BaseApi.isOEM = true;
    String str = paramString2;
    if (paramString2.equals(""))
      str = "null"; 
    paramString2 = paramString3;
    if (paramString3.equals(""))
      paramString2 = "null"; 
    paramString3 = paramString4;
    if (paramString4.equals(""))
      paramString3 = "null"; 
    BaseApi.installChannel = paramString2;
    BaseApi.registerChannel = str;
    BaseApi.businessId = paramString3;
    return this.a.doLogin(paramActivity, paramString1, paramIUiListener);
  }
  
  public void logout(Context paramContext) {
    f.c("openSDK_LOG.QQAuth", "logout() --start");
    CookieSyncManager.createInstance(paramContext);
    setAccessToken(null, null);
    setOpenId(paramContext, null);
    f.c("openSDK_LOG.QQAuth", "logout() --end");
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onActivityResult() ,resultCode = ");
    stringBuilder.append(paramInt2);
    stringBuilder.append("");
    f.c("openSDK_LOG.QQAuth", stringBuilder.toString());
    return true;
  }
  
  public int reAuth(Activity paramActivity, String paramString, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.QQAuth", "reAuth()");
    return this.a.doLogin(paramActivity, paramString, paramIUiListener, true, null);
  }
  
  public void reportDAU() {
    this.a.a((IUiListener)null);
  }
  
  public void setAccessToken(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setAccessToken(), validTimeInSecond = ");
    stringBuilder.append(paramString2);
    stringBuilder.append("");
    f.a("openSDK_LOG.QQAuth", stringBuilder.toString());
    this.b.setAccessToken(paramString1, paramString2);
  }
  
  public void setOpenId(Context paramContext, String paramString) {
    f.a("openSDK_LOG.QQAuth", "setOpenId() --start");
    this.b.setOpenId(paramString);
    a.d(paramContext, this.b);
    f.a("openSDK_LOG.QQAuth", "setOpenId() --end");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\auth\QQAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */