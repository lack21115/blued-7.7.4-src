package com.geetest.onelogin.listener;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.b.b;
import com.geetest.onelogin.f.b;
import com.geetest.onelogin.j.h;
import org.json.JSONObject;

public class c {
  private static Handler a = new Handler(Looper.getMainLooper()) {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
        try {
          String[] arrayOfString;
          int i = param1Message.what;
          if (i != 112) {
            if (i != 113) {
              if (i != 1111) {
                switch (i) {
                  case 110:
                    if (b.w().o() != null) {
                      b.w().o().onLoginLoading();
                      return;
                    } 
                    return;
                  case 109:
                    if (b.w().o() != null) {
                      b.w().o().onBackButtonClick();
                      return;
                    } 
                    return;
                  case 108:
                    if (b.w().o() != null) {
                      b.w().o().onSwitchButtonClick();
                      return;
                    } 
                    return;
                  case 107:
                    if (b.w().o() != null) {
                      b.w().o().onLoginButtonClick();
                      return;
                    } 
                    return;
                  case 106:
                    if (b.w().o() != null) {
                      b.w().o().onPrivacyCheckBoxClick(((Boolean)param1Message.obj).booleanValue());
                      return;
                    } 
                    return;
                  case 105:
                    if (b.w().o() != null) {
                      arrayOfString = (String[])param1Message.obj;
                      b.w().o().onPrivacyClick(arrayOfString[0], arrayOfString[1]);
                      return;
                    } 
                    return;
                  case 104:
                    c.b((JSONObject)((Message)arrayOfString).obj);
                    return;
                  case 103:
                    c.a((JSONObject)((Message)arrayOfString).obj);
                    return;
                  case 102:
                    a.a().f();
                    return;
                  case 101:
                    a.a().e();
                    return;
                  case 100:
                    a.a().d();
                    return;
                } 
              } else {
                if (b.w().o() != null) {
                  b.w().o().onAuthActivityCreate((Activity)((Message)arrayOfString).obj);
                  return;
                } 
                return;
              } 
            } else {
              if (b.w().o() != null) {
                b.w().o().onRequestTokenSecurityPhone((String)((Message)arrayOfString).obj);
                return;
              } 
              return;
            } 
          } else {
            if (b.w().o() != null) {
              b.w().o().onAuthWebActivityCreate((Activity)((Message)arrayOfString).obj);
              return;
            } 
            return;
          } 
        } catch (Exception exception) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("SDK 内部异常，错误信息为: ");
          stringBuilder.append(exception.toString());
          h.c(stringBuilder.toString());
          return;
        } 
      }
    };
  
  public static void a() {
    a.sendEmptyMessage(102);
  }
  
  public static void a(Activity paramActivity) {
    try {
      h.b("提交 onAuthActivityCreate 接口成功");
      Message message = a.obtainMessage(1111);
      message.obj = paramActivity;
      a.sendMessage(message);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onAuthActivityCreate 接口时发生错误，错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void a(d paramd, JSONObject paramJSONObject, boolean paramBoolean) {
    if (paramd == null) {
      h.c("提交 onResult 接口失败，原因为: OneLoginBean is null");
      return;
    } 
    if (paramd.isCanceled()) {
      h.c("提交 onResult 接口失败，原因为: isCanceled is true");
      return;
    } 
    Message message = a.obtainMessage();
    if (paramBoolean) {
      message.what = 103;
    } else {
      message.what = 104;
    } 
    message.obj = paramJSONObject;
    a.sendMessage(message);
  }
  
  public static void a(String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onRequestTokenSecurityPhone 接口成功，当前的脱敏手机号为: ");
      stringBuilder.append(paramString);
      h.b(stringBuilder.toString());
      Message message = a.obtainMessage(113);
      message.obj = paramString;
      a.sendMessage(message);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onSecurityPhone 接口时发生错误，错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
  
  public static void a(String paramString1, String paramString2) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onPrivacyClick 接口成功，隐私条款名为: ");
      stringBuilder.append(paramString1);
      stringBuilder.append(" 路径为: ");
      stringBuilder.append(paramString2);
      h.b(stringBuilder.toString());
      Message message = a.obtainMessage(105);
      message.obj = new String[] { paramString1, paramString2 };
      a.sendMessage(message);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onPrivacyClick 接口时发生错误，错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
  
  public static void a(boolean paramBoolean) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onPrivacyCheckBoxClick 接口成功，checkbox是否是选择: ");
      stringBuilder.append(paramBoolean);
      h.b(stringBuilder.toString());
      Message message = a.obtainMessage(106);
      message.obj = Boolean.valueOf(paramBoolean);
      a.sendMessage(message);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onPrivacyCheckBoxClick 接口时发生错误，错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
  
  public static void b() {
    a.sendEmptyMessage(101);
  }
  
  public static void b(Activity paramActivity) {
    try {
      h.b("提交 onAuthWebActivityCreate 接口成功");
      Message message = a.obtainMessage(112);
      message.obj = paramActivity;
      a.sendMessage(message);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onAuthWebActivityCreate 接口时发生错误，错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
  
  public static void b(d paramd, JSONObject paramJSONObject, boolean paramBoolean) {
    if (paramd == null) {
      h.c("提交 onTokenResult 接口失败，原因为: OneLoginBean is null");
      return;
    } 
    if (paramd.isTimeout()) {
      h.c("提交 onTokenResult 接口失败，原因为: isTimeout is true");
      return;
    } 
    paramd.setState(true);
    b.w().Q();
    a(paramd, paramJSONObject, paramBoolean);
  }
  
  public static void c() {
    try {
      h.b("提交 onLoginButtonClick 接口成功");
      a.sendEmptyMessage(107);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onLoginButtonClick 接口时发生错误，错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      exception.printStackTrace();
      return;
    } 
  }
  
  private static void c(JSONObject paramJSONObject) {
    // Byte code:
    //   0: invokestatic w : ()Lcom/geetest/onelogin/f/b;
    //   3: invokevirtual v : ()Z
    //   6: istore_1
    //   7: new java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore_2
    //   15: aload_2
    //   16: ldc 'onTokenMainThread preListener='
    //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: invokestatic w : ()Lcom/geetest/onelogin/f/b;
    //   26: invokevirtual n : ()Lcom/geetest/onelogin/listener/AbstractOneLoginListener;
    //   29: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: ldc ', requestListener='
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_2
    //   41: invokestatic w : ()Lcom/geetest/onelogin/f/b;
    //   44: invokevirtual o : ()Lcom/geetest/onelogin/listener/AbstractOneLoginListener;
    //   47: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: ldc ', mode='
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_2
    //   59: invokestatic w : ()Lcom/geetest/onelogin/f/b;
    //   62: invokevirtual k : ()Z
    //   65: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_2
    //   70: ldc ', isRequestTokenSuccess='
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_2
    //   77: invokestatic w : ()Lcom/geetest/onelogin/f/b;
    //   80: invokevirtual H : ()Z
    //   83: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_2
    //   88: ldc ', isAuthCreated='
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_2
    //   95: invokestatic w : ()Lcom/geetest/onelogin/f/b;
    //   98: invokevirtual u : ()Z
    //   101: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_2
    //   106: ldc ', jsonObject='
    //   108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_2
    //   113: aload_0
    //   114: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_2
    //   119: invokevirtual toString : ()Ljava/lang/String;
    //   122: invokestatic a : (Ljava/lang/String;)V
    //   125: invokestatic w : ()Lcom/geetest/onelogin/f/b;
    //   128: invokevirtual l : ()Lcom/geetest/onelogin/a/d;
    //   131: iconst_1
    //   132: invokevirtual setPreGetTokenComplete : (Z)V
    //   135: ldc 'onTokenMainThread'
    //   137: invokestatic a : (Ljava/lang/String;)V
    //   140: invokestatic w : ()Lcom/geetest/onelogin/f/b;
    //   143: invokevirtual z : ()V
    //   146: invokestatic w : ()Lcom/geetest/onelogin/f/b;
    //   149: invokevirtual n : ()Lcom/geetest/onelogin/listener/AbstractOneLoginListener;
    //   152: astore_2
    //   153: aload_2
    //   154: ifnonnull -> 327
    //   157: new java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial <init> : ()V
    //   164: astore_2
    //   165: aload_2
    //   166: ldc 'Token 结果，构造信息为: '
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_2
    //   173: aload_0
    //   174: invokevirtual toString : ()Ljava/lang/String;
    //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_2
    //   182: invokevirtual toString : ()Ljava/lang/String;
    //   185: invokestatic b : (Ljava/lang/String;)V
    //   188: return
    //   189: new java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial <init> : ()V
    //   196: astore_3
    //   197: aload_3
    //   198: ldc 'getPreGetListener 准备提交 onResult 接口, listener: '
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_3
    //   205: invokestatic w : ()Lcom/geetest/onelogin/f/b;
    //   208: invokevirtual n : ()Lcom/geetest/onelogin/listener/AbstractOneLoginListener;
    //   211: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_3
    //   216: ldc ', isReady: '
    //   218: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_3
    //   223: invokestatic w : ()Lcom/geetest/onelogin/f/b;
    //   226: invokevirtual p : ()Z
    //   229: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_3
    //   234: invokevirtual toString : ()Ljava/lang/String;
    //   237: invokestatic a : (Ljava/lang/String;)V
    //   240: invokestatic w : ()Lcom/geetest/onelogin/f/b;
    //   243: invokevirtual p : ()Z
    //   246: ifeq -> 322
    //   249: new java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial <init> : ()V
    //   256: astore_3
    //   257: aload_3
    //   258: ldc '提交预取号 onResult 接口成功，构造信息为: '
    //   260: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_3
    //   265: aload_0
    //   266: invokevirtual toString : ()Ljava/lang/String;
    //   269: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload_3
    //   274: invokevirtual toString : ()Ljava/lang/String;
    //   277: invokestatic b : (Ljava/lang/String;)V
    //   280: aload_2
    //   281: aload_0
    //   282: invokevirtual onResult : (Lorg/json/JSONObject;)V
    //   285: return
    //   286: astore_0
    //   287: new java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial <init> : ()V
    //   294: astore_2
    //   295: aload_2
    //   296: ldc '提交 onResult 接口时发生错误，错误信息为: '
    //   298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_2
    //   303: aload_0
    //   304: invokevirtual toString : ()Ljava/lang/String;
    //   307: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_2
    //   312: invokevirtual toString : ()Ljava/lang/String;
    //   315: invokestatic c : (Ljava/lang/String;)V
    //   318: aload_0
    //   319: invokevirtual printStackTrace : ()V
    //   322: return
    //   323: astore_2
    //   324: goto -> 135
    //   327: iload_1
    //   328: ifeq -> 189
    //   331: return
    // Exception table:
    //   from	to	target	type
    //   0	125	286	java/lang/Exception
    //   125	135	323	java/lang/Exception
    //   135	153	286	java/lang/Exception
    //   157	188	286	java/lang/Exception
    //   189	285	286	java/lang/Exception
  }
  
  public static void d() {
    try {
      h.b("提交 onSwitchButtonClick 接口成功");
      a.sendEmptyMessage(108);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onSwitchButtonClick 接口时发生错误，错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      exception.printStackTrace();
      return;
    } 
  }
  
  private static void d(JSONObject paramJSONObject) {
    try {
      b.w().l().setRequestTokenComplete(true);
    } catch (Exception exception) {}
    try {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getRequestListener 准备提交 onResult 接口, listener: ");
      stringBuilder.append(b.w().o());
      stringBuilder.append(", isReady: ");
      stringBuilder.append(b.w().q());
      com.geetest.onelogin.j.c.a(stringBuilder.toString());
      if (paramJSONObject.has(b.a)) {
        str = paramJSONObject.getString(b.a);
      } else {
        str = "";
      } 
      if (b.w().q() || str.equals("-20303") || str.equals("-20302") || str.equals("-20301")) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("提交取号 onResult 接口成功，构造信息为: ");
        stringBuilder1.append(paramJSONObject.toString());
        h.b(stringBuilder1.toString());
        b.w().o().onResult(paramJSONObject);
        return;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onResult 接口时发生错误，错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      exception.printStackTrace();
    } 
  }
  
  public static void e() {
    try {
      h.b("提交 onBackButtonClick 接口成功");
      a.sendEmptyMessage(109);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onBackButtonClick 接口时发生错误，错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void f() {
    try {
      h.b("提交 onLoginLoading 接口成功");
      a.sendEmptyMessage(110);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onLoginLoading 接口时发生错误，错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      exception.printStackTrace();
      return;
    } 
  }
  
  public static boolean g() {
    try {
      h.b("提交 onRequestOtherVerify 接口成功");
      return b.w().o().onRequestOtherVerify();
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("提交 onRequestOtherVerify 接口时发生错误，错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\listener\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */