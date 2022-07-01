package com.geetest.onepassv2.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import com.geetest.onelogin.b.a;
import com.geetest.onelogin.j.c;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.i;
import com.geetest.onelogin.j.o;
import com.geetest.onepassv2.a.a;
import com.geetest.onepassv2.b.a;
import com.geetest.onepassv2.b.c;
import com.geetest.onepassv2.f.a;
import com.geetest.onepassv2.listener.OnePassListener;
import com.geetest.onepassv2.listener.a;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class b {
  private static boolean o = false;
  
  public a a;
  
  public OnePassListener b;
  
  public Context c;
  
  public Long d;
  
  public a e;
  
  public com.geetest.onepassv2.f.b f;
  
  public Network g;
  
  public ConnectivityManager h;
  
  public ConnectivityManager.NetworkCallback i;
  
  private boolean j = false;
  
  private final Handler k = new Handler(this, Looper.getMainLooper()) {
      public void handleMessage(Message param1Message) {
        String str;
        super.handleMessage(param1Message);
        int i = param1Message.what;
        if (i != 4) {
          if (i != 5) {
            if (i != 6) {
              if (i != 7) {
                str = null;
              } else {
                str = a.I;
              } 
            } else {
              str = a.M;
            } 
          } else {
            str = a.L;
          } 
        } else {
          str = a.K;
        } 
        a.a(this.a.b, str, param1Message.obj.toString(), this.a.a);
      }
    };
  
  private boolean l;
  
  private ScheduledExecutorService m;
  
  private boolean n = false;
  
  public b(a parama, OnePassListener paramOnePassListener, Context paramContext) {
    this.a = parama;
    this.b = paramOnePassListener;
    this.c = paramContext;
  }
  
  private void a(int paramInt, Object paramObject) {
    Message message = new Message();
    message.what = paramInt;
    message.obj = paramObject;
    this.k.sendMessage(message);
  }
  
  private void a(Context paramContext, String paramString) {
    this.l = true;
    try {
      ConnectivityManager.NetworkCallback networkCallback;
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (Build.VERSION.SDK_INT >= 21) {
        this.m = new ScheduledThreadPoolExecutor(1);
        this.m.schedule(new Runnable(this) {
              public void run() {
                if (!b.b(this.a)) {
                  b.a(true);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("scheduledExecutorService-->isConnectTimeout: ");
                  stringBuilder.append(b.c());
                  h.b(stringBuilder.toString());
                  h.c("check network timeout or no money");
                  b.a(this.a, 4, "check network timeout or no money");
                } 
              }
            }this.a.b(), TimeUnit.MILLISECONDS);
        NetworkRequest networkRequest = (new NetworkRequest.Builder()).addCapability(12).addTransportType(0).build();
        networkCallback = new ConnectivityManager.NetworkCallback(this, connectivityManager, paramString) {
            public void onAvailable(Network param1Network) {
              super.onAvailable(param1Network);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onAvailable-->isConnectTimeout: ");
              stringBuilder.append(b.c());
              h.b(stringBuilder.toString());
              if (b.c(this.c) && !b.c()) {
                if (b.d(this.c) != null && !b.d(this.c).isShutdown())
                  b.d(this.c).shutdownNow(); 
                b.a(this.c, false);
                b.b(this.c, true);
                b b1 = this.c;
                b1.h = this.a;
                b1.i = this;
                b1.g = param1Network;
                b.a(b1, this.b);
              } 
            }
          };
        if (connectivityManager != null) {
          connectivityManager.requestNetwork(networkRequest, networkCallback);
          return;
        } 
        if (this.m != null && !this.m.isShutdown())
          this.m.shutdownNow(); 
        h.c("ConnectivityManager is not exist");
        a.a(this.b, a.I, "ConnectivityManager is not exist", this.a);
        return;
      } 
      o.a().a(new Runnable(this, connectivityManager, (String)networkCallback) {
            public void run() {
              ConnectivityManager connectivityManager = this.a;
              if (connectivityManager != null) {
                int i = 0;
                a.a(connectivityManager, 0, "enableHIPRI");
                try {
                  while (true) {
                    int j;
                    if (this.c.a.b() < 1000) {
                      j = 1;
                    } else {
                      j = this.c.a.b() / 1000;
                    } 
                    if (i >= j || this.a.getNetworkInfo(5).getState().compareTo((Enum)NetworkInfo.State.CONNECTED) == 0)
                      break; 
                    Thread.sleep(1000L);
                    i++;
                  } 
                  i = -1;
                  if (!TextUtils.isEmpty(this.b))
                    i = com.geetest.onelogin.j.b.a(com.geetest.onelogin.j.b.b(this.b)); 
                  if (a.a(this.a, 5, i)) {
                    b b1 = this.c;
                    b1.h = this.a;
                    b1.i = null;
                    b1.g = null;
                    b.a(b1, this.b);
                    return;
                  } 
                  h.c("Switch network failure or no data network");
                  b.a(this.c, 6, "Switch network failure or no data network");
                  return;
                } catch (InterruptedException interruptedException) {
                  h.c("check hipri failed");
                  b.a(this.c, 5, "check hipri failed");
                  return;
                } 
              } 
              h.c("ConnectivityManager is not exist");
              b.a(this.c, 7, "ConnectivityManager is not exist");
            }
          });
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("wifiToIntent error: ");
      stringBuilder1.append(exception.toString());
      h.c(stringBuilder1.toString());
      ScheduledExecutorService scheduledExecutorService = this.m;
      if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown())
        this.m.shutdownNow(); 
      OnePassListener onePassListener = this.b;
      String str = a.J;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("wifiToIntent error: ");
      stringBuilder2.append(exception.toString());
      a.a(onePassListener, str, stringBuilder2.toString(), this.a);
      return;
    } 
  }
  
  private void d() {
    this.d = Long.valueOf(System.currentTimeMillis());
    if (this.b.onAlgorithmSelf()) {
      this.a.s(this.b.onAlgorithmPhone("CT", null));
    } else if (this.b.onAlgorithm()) {
      a a1 = this.a;
      a1.s(a.a(a1.D()).toUpperCase());
    } else {
      a a1 = this.a;
      a1.s(a1.D());
    } 
    try {
      String str1 = i.b(this.c);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.a.v());
      stringBuilder1.append("?");
      stringBuilder1.append(com.geetest.onepassv2.b.b.a(this.a.w(), this.a.x(), this.a));
      String str2 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("startCTFlower url=");
      stringBuilder2.append(str2);
      stringBuilder2.append(", gopBean=");
      stringBuilder2.append(this.a);
      c.b(stringBuilder2.toString());
      this.a.d(str2);
      byte b1 = -1;
      int i = str1.hashCode();
      if (i != 1621) {
        if (i != 1652) {
          if (i == 2664213 && str1.equals("WIFI"))
            b1 = 0; 
        } else if (str1.equals("3G")) {
          b1 = 2;
        } 
      } else if (str1.equals("2G")) {
        b1 = 1;
      } 
      if (b1 != 0) {
        if (b1 != 1) {
          if (b1 != 2) {
            this.h = null;
            this.i = null;
            this.g = null;
            h.b("当前网络环境为 4G 或其他");
            b(str2);
            return;
          } 
          h.c("当前网络环境为 3G，电信不支持 3G 网络环境");
          a.a(this.b, a.C, "CT does not support 3G network environment", this.a);
          return;
        } 
        h.c("当前网络环境为 2G，电信不支持 2G 网络环境");
        a.a(this.b, a.B, "CT does not support 2G network environment", this.a);
        return;
      } 
      h.b("当前网络环境为 WIFI");
      a(str2);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("获取当前网络环境错误，错误信息为: ");
      stringBuilder1.append(exception.toString());
      h.c(stringBuilder1.toString());
      OnePassListener onePassListener = this.b;
      String str = a.D;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Get the current network environment error, the error message is: ");
      stringBuilder2.append(exception.toString());
      a.a(onePassListener, str, stringBuilder2.toString(), this.a);
      return;
    } 
  }
  
  private void d(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Lcom/geetest/onepassv2/a/a;
    //   4: invokevirtual u : ()Ljava/lang/String;
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual hashCode : ()I
    //   12: istore_2
    //   13: iload_2
    //   14: sipush #2161
    //   17: if_icmpeq -> 45
    //   20: iload_2
    //   21: sipush #2162
    //   24: if_icmpeq -> 30
    //   27: goto -> 59
    //   30: aload_3
    //   31: ldc_w 'CU'
    //   34: invokevirtual equals : (Ljava/lang/Object;)Z
    //   37: ifeq -> 59
    //   40: iconst_0
    //   41: istore_2
    //   42: goto -> 61
    //   45: aload_3
    //   46: ldc 'CT'
    //   48: invokevirtual equals : (Ljava/lang/Object;)Z
    //   51: ifeq -> 59
    //   54: iconst_1
    //   55: istore_2
    //   56: goto -> 61
    //   59: iconst_m1
    //   60: istore_2
    //   61: iload_2
    //   62: ifeq -> 117
    //   65: iload_2
    //   66: iconst_1
    //   67: if_icmpeq -> 111
    //   70: new java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial <init> : ()V
    //   77: astore_3
    //   78: aload_3
    //   79: ldc_w '当前从 PreGateWay 获取的运营商有误: '
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: aload_0
    //   88: getfield a : Lcom/geetest/onepassv2/a/a;
    //   91: invokevirtual u : ()Ljava/lang/String;
    //   94: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_3
    //   99: invokevirtual toString : ()Ljava/lang/String;
    //   102: invokestatic c : (Ljava/lang/String;)V
    //   105: aload_0
    //   106: aload_1
    //   107: invokevirtual b : (Ljava/lang/String;)V
    //   110: return
    //   111: aload_0
    //   112: aload_1
    //   113: invokevirtual b : (Ljava/lang/String;)V
    //   116: return
    //   117: aload_0
    //   118: aload_1
    //   119: invokevirtual c : (Ljava/lang/String;)V
    //   122: return
  }
  
  private void e() {
    this.d = Long.valueOf(System.currentTimeMillis());
    if (this.b.onAlgorithmSelf()) {
      a a1 = this.a;
      a1.s(this.b.onAlgorithmPhone("CU", a1.x()));
    } else if (this.b.onAlgorithm()) {
      a a1 = this.a;
      a1.s(c.a(a1.D(), this.a.x()).toUpperCase());
    } else {
      a a1 = this.a;
      a1.s(a1.D());
    } 
    try {
      String str1 = i.b(this.c);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.v());
      stringBuilder.append("?unikey=010005");
      stringBuilder.append(UUID.randomUUID().toString().replaceAll("-", "").substring(6));
      String str2 = stringBuilder.toString();
      this.a.d(str2);
      byte b1 = -1;
      int i = str1.hashCode();
      if (i != 1621) {
        if (i == 2664213 && str1.equals("WIFI"))
          b1 = 0; 
      } else if (str1.equals("2G")) {
        b1 = 1;
      } 
      if (b1 != 0) {
        if (b1 != 1) {
          this.h = null;
          this.i = null;
          this.g = null;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("当前网络环境为 ");
          stringBuilder1.append(str1);
          h.b(stringBuilder1.toString());
          c(str2);
          return;
        } 
        h.c("当前网络环境为 2G，联通不支持 2G 网络环境");
        a.a(this.b, a.H, "CU does not support 2G network environment", this.a);
        return;
      } 
      h.b("当前网络环境为 WIFI");
      a(str2);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("获取当前网络环境错误，错误信息为: ");
      stringBuilder1.append(exception.toString());
      h.c(stringBuilder1.toString());
      OnePassListener onePassListener = this.b;
      String str = a.F;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Get the current network environment error, the error message is: ");
      stringBuilder2.append(exception.toString());
      a.a(onePassListener, str, stringBuilder2.toString(), this.a);
      return;
    } 
  }
  
  private void f() {
    if (this.b.onAlgorithmSelf()) {
      a a1 = this.a;
      OnePassListener onePassListener = this.b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.x());
      stringBuilder.append(this.a.a());
      a1.s(onePassListener.onAlgorithmPhone("CM", stringBuilder.toString()));
    } else if (this.b.onAlgorithm()) {
      a a1 = this.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.D());
      stringBuilder.append(this.a.x());
      stringBuilder.append(this.a.a());
      a1.s(a.a(stringBuilder.toString()).toUpperCase());
    } else {
      a a1 = this.a;
      a1.s(a1.D());
    } 
    try {
      String str = i.b(this.c);
      byte b1 = -1;
      if (str.hashCode() == 2664213 && str.equals("WIFI"))
        b1 = 0; 
      if (b1 != 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("当前网络环境为 ");
        stringBuilder.append(str);
        h.b(stringBuilder.toString());
        g();
        return;
      } 
      h.b("当前网络环境为 WIFI");
      if (com.geetest.onelogin.j.b.a(this.c)) {
        h.b("当前手机有电话卡");
        if (com.geetest.onelogin.j.b.b(this.c)) {
          h.b("当前手机有电话卡并且也有数据网络");
          g();
          return;
        } 
        h.c("当前手机有电话卡但是没有数据网络");
        a.a(this.b, a.g, "network is not open", this.a);
        return;
      } 
      h.c("当前手机没有电话卡");
      a.a(this.b, a.f, "there is no sim", this.a);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("获取当前网络环境错误，错误信息为: ");
      stringBuilder1.append(exception.toString());
      h.c(stringBuilder1.toString());
      OnePassListener onePassListener = this.b;
      String str = a.A;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Get the current network environment error, the error message is: ");
      stringBuilder2.append(exception.toString());
      a.a(onePassListener, str, stringBuilder2.toString(), this.a);
      return;
    } 
  }
  
  private void g() {
    this.d = Long.valueOf(System.currentTimeMillis());
    h.b("移动运营商开始请求");
    this.j = false;
    AuthnHelper.getInstance(this.c).mobileAuth(this.a.w(), this.a.x(), new TokenListener(this) {
          public void onGetTokenComplete(int param1Int, JSONObject param1JSONObject) {
            a a = this.a.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis() - this.a.d.longValue());
            stringBuilder.append("");
            a.r(stringBuilder.toString());
            if (b.a(this.a)) {
              h.b("移动运营商请求结果之前关闭了 OnePass");
              return;
            } 
            try {
              if ("103000".equals(param1JSONObject.getString("resultCode"))) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("移动运营商请求成功，结果为: ");
                stringBuilder2.append(param1JSONObject.toString());
                h.b(stringBuilder2.toString());
                this.a.a.q(param1JSONObject.getString("token"));
                a.a(this.a.b, this.a.a);
                return;
              } 
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("移动运营商请求失败，原因为: ");
              stringBuilder1.append(param1JSONObject.toString());
              h.c(stringBuilder1.toString());
              a.a(this.a.b, a.y, param1JSONObject, this.a.a);
              return;
            } catch (Exception exception) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("移动运营商请求错误，原因为: ");
              stringBuilder1.append(exception.toString());
              h.c(stringBuilder1.toString());
              a.a(this.a.b, a.z, exception.toString(), this.a.a);
              return;
            } 
          }
        });
  }
  
  public void a() {
    this.j = true;
    this.h = null;
    this.i = null;
    this.g = null;
    this.k.removeCallbacksAndMessages(null);
    if (this.b != null)
      this.b = null; 
    ScheduledExecutorService scheduledExecutorService = this.m;
    if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown())
      this.m.shutdownNow(); 
    com.geetest.onepassv2.f.b b1 = this.f;
    if (b1 != null && !b1.isCancelled() && this.f.getStatus() == AsyncTask.Status.RUNNING)
      this.f.cancel(true); 
    a a1 = this.e;
    if (a1 != null && !a1.isCancelled() && this.e.getStatus() == AsyncTask.Status.RUNNING)
      this.e.cancel(true); 
  }
  
  protected void a(String paramString) {
    if (com.geetest.onelogin.j.b.a(this.c)) {
      h.b("当前手机有电话卡");
      if (com.geetest.onelogin.j.b.b(this.c)) {
        h.b("当前手机有电话卡并且也有数据网络");
        a(this.c, paramString);
        return;
      } 
      h.c("当前手机有电话卡但是没有数据网络");
      a.a(this.b, a.g, "network is not open", this.a);
      return;
    } 
    h.c("当前手机没有电话卡");
    a.a(this.b, a.f, "there is no sim", this.a);
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Lcom/geetest/onepassv2/a/a;
    //   4: invokevirtual u : ()Ljava/lang/String;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual hashCode : ()I
    //   12: istore_1
    //   13: iload_1
    //   14: sipush #2154
    //   17: if_icmpeq -> 66
    //   20: iload_1
    //   21: sipush #2161
    //   24: if_icmpeq -> 52
    //   27: iload_1
    //   28: sipush #2162
    //   31: if_icmpeq -> 37
    //   34: goto -> 81
    //   37: aload_2
    //   38: ldc_w 'CU'
    //   41: invokevirtual equals : (Ljava/lang/Object;)Z
    //   44: ifeq -> 81
    //   47: iconst_1
    //   48: istore_1
    //   49: goto -> 83
    //   52: aload_2
    //   53: ldc 'CT'
    //   55: invokevirtual equals : (Ljava/lang/Object;)Z
    //   58: ifeq -> 81
    //   61: iconst_2
    //   62: istore_1
    //   63: goto -> 83
    //   66: aload_2
    //   67: ldc_w 'CM'
    //   70: invokevirtual equals : (Ljava/lang/Object;)Z
    //   73: ifeq -> 81
    //   76: iconst_0
    //   77: istore_1
    //   78: goto -> 83
    //   81: iconst_m1
    //   82: istore_1
    //   83: iload_1
    //   84: ifeq -> 131
    //   87: iload_1
    //   88: iconst_1
    //   89: if_icmpeq -> 126
    //   92: iload_1
    //   93: iconst_2
    //   94: if_icmpeq -> 121
    //   97: ldc_w '获取返回的运营商错误'
    //   100: invokestatic c : (Ljava/lang/String;)V
    //   103: aload_0
    //   104: getfield b : Lcom/geetest/onepassv2/listener/OnePassListener;
    //   107: getstatic com/geetest/onelogin/b/a.x : Ljava/lang/String;
    //   110: ldc_w 'Get the returned carrier error'
    //   113: aload_0
    //   114: getfield a : Lcom/geetest/onepassv2/a/a;
    //   117: invokestatic a : (Lcom/geetest/onepassv2/listener/OnePassListener;Ljava/lang/String;Ljava/lang/String;Lcom/geetest/onepassv2/a/a;)V
    //   120: return
    //   121: aload_0
    //   122: invokespecial d : ()V
    //   125: return
    //   126: aload_0
    //   127: invokespecial e : ()V
    //   130: return
    //   131: aload_0
    //   132: invokespecial f : ()V
    //   135: return
  }
  
  protected void b(String paramString) {
    this.e = new a(this.a, this.b, this.g, this.h, this.i);
    this.e.executeOnExecutor(Executors.newCachedThreadPool(), (Object[])new String[] { paramString });
  }
  
  protected void c(String paramString) {
    this.f = new com.geetest.onepassv2.f.b(this.a, this.b, this.c, this.g, this.h, this.i);
    this.f.executeOnExecutor(Executors.newCachedThreadPool(), (Object[])new String[] { paramString });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */