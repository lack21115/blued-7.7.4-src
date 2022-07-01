package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.c.a.a;
import com.huawei.hms.framework.network.grs.c.b.c;
import com.huawei.hms.framework.network.grs.local.model.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

public class d implements a {
  private static final String a = "d";
  
  private GrsBaseInfo b;
  
  private Context c;
  
  private a d;
  
  private e e;
  
  private ArrayList<Future<e>> f = new ArrayList<Future<e>>();
  
  private ArrayList<e> g = new ArrayList<e>();
  
  private JSONArray h = new JSONArray();
  
  private ArrayList<String> i = new ArrayList<String>();
  
  private ArrayList<String> j = new ArrayList<String>();
  
  private c k;
  
  private long l = 1L;
  
  public d(GrsBaseInfo paramGrsBaseInfo, Context paramContext, a parama) {
    this.b = paramGrsBaseInfo;
    this.c = paramContext;
    this.d = parama;
    b();
  }
  
  private e a(ExecutorService paramExecutorService, ArrayList<String> paramArrayList, String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #7
    //   3: iconst_0
    //   4: istore #5
    //   6: aload #7
    //   8: astore #8
    //   10: iload #5
    //   12: aload_2
    //   13: invokevirtual size : ()I
    //   16: if_icmpge -> 270
    //   19: aload_2
    //   20: iload #5
    //   22: invokevirtual get : (I)Ljava/lang/Object;
    //   25: checkcast java/lang/String
    //   28: astore #9
    //   30: aload #9
    //   32: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   35: istore #6
    //   37: iconst_1
    //   38: istore #4
    //   40: aload #7
    //   42: astore #8
    //   44: iload #6
    //   46: ifne -> 234
    //   49: aload_1
    //   50: new com/huawei/hms/framework/network/grs/c/b
    //   53: dup
    //   54: aload #9
    //   56: iload #5
    //   58: aload_0
    //   59: aload_0
    //   60: getfield c : Landroid/content/Context;
    //   63: aload_3
    //   64: aload_0
    //   65: getfield b : Lcom/huawei/hms/framework/network/grs/GrsBaseInfo;
    //   68: invokespecial <init> : (Ljava/lang/String;ILcom/huawei/hms/framework/network/grs/c/a;Landroid/content/Context;Ljava/lang/String;Lcom/huawei/hms/framework/network/grs/GrsBaseInfo;)V
    //   71: invokevirtual f : ()Ljava/util/concurrent/Callable;
    //   74: invokeinterface submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   79: astore #8
    //   81: aload_0
    //   82: getfield f : Ljava/util/ArrayList;
    //   85: aload #8
    //   87: invokevirtual add : (Ljava/lang/Object;)Z
    //   90: pop
    //   91: aload #8
    //   93: aload_0
    //   94: getfield l : J
    //   97: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   100: invokeinterface get : (JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   105: checkcast com/huawei/hms/framework/network/grs/c/e
    //   108: astore #8
    //   110: aload #8
    //   112: ifnull -> 148
    //   115: aload #8
    //   117: invokevirtual m : ()Z
    //   120: ifeq -> 148
    //   123: getstatic com/huawei/hms/framework/network/grs/c/d.a : Ljava/lang/String;
    //   126: astore #7
    //   128: aload #7
    //   130: ldc 'grs request return body is not null and is OK.'
    //   132: invokestatic i : (Ljava/lang/String;Ljava/lang/Object;)V
    //   135: goto -> 227
    //   138: astore #9
    //   140: goto -> 179
    //   143: astore #9
    //   145: goto -> 202
    //   148: iconst_0
    //   149: istore #4
    //   151: goto -> 227
    //   154: aload #7
    //   156: astore #8
    //   158: getstatic com/huawei/hms/framework/network/grs/c/d.a : Ljava/lang/String;
    //   161: ldc 'the wait timed out'
    //   163: invokestatic w : (Ljava/lang/String;Ljava/lang/Object;)V
    //   166: goto -> 212
    //   169: astore #8
    //   171: aload #8
    //   173: astore #9
    //   175: aload #7
    //   177: astore #8
    //   179: getstatic com/huawei/hms/framework/network/grs/c/d.a : Ljava/lang/String;
    //   182: ldc 'the current thread was interrupted while waiting'
    //   184: aload #9
    //   186: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   189: goto -> 227
    //   192: astore #8
    //   194: aload #8
    //   196: astore #9
    //   198: aload #7
    //   200: astore #8
    //   202: getstatic com/huawei/hms/framework/network/grs/c/d.a : Ljava/lang/String;
    //   205: ldc 'the computation threw an ExecutionException'
    //   207: aload #9
    //   209: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   212: goto -> 234
    //   215: aload #7
    //   217: astore #8
    //   219: getstatic com/huawei/hms/framework/network/grs/c/d.a : Ljava/lang/String;
    //   222: ldc '{requestServer} the computation was cancelled'
    //   224: invokestatic i : (Ljava/lang/String;Ljava/lang/Object;)V
    //   227: aload #8
    //   229: astore #7
    //   231: goto -> 241
    //   234: iconst_0
    //   235: istore #4
    //   237: aload #8
    //   239: astore #7
    //   241: iload #4
    //   243: ifeq -> 261
    //   246: getstatic com/huawei/hms/framework/network/grs/c/d.a : Ljava/lang/String;
    //   249: ldc 'needBreak is true so need break current circulation'
    //   251: invokestatic v : (Ljava/lang/String;Ljava/lang/Object;)V
    //   254: aload #7
    //   256: astore #8
    //   258: goto -> 270
    //   261: iload #5
    //   263: iconst_1
    //   264: iadd
    //   265: istore #5
    //   267: goto -> 6
    //   270: aload_0
    //   271: aload #8
    //   273: invokespecial b : (Lcom/huawei/hms/framework/network/grs/c/e;)Lcom/huawei/hms/framework/network/grs/c/e;
    //   276: areturn
    //   277: astore #8
    //   279: goto -> 215
    //   282: astore #8
    //   284: goto -> 154
    //   287: astore #7
    //   289: goto -> 219
    //   292: astore #7
    //   294: goto -> 158
    // Exception table:
    //   from	to	target	type
    //   91	110	277	java/util/concurrent/CancellationException
    //   91	110	192	java/util/concurrent/ExecutionException
    //   91	110	169	java/lang/InterruptedException
    //   91	110	282	java/util/concurrent/TimeoutException
    //   115	128	287	java/util/concurrent/CancellationException
    //   115	128	143	java/util/concurrent/ExecutionException
    //   115	128	138	java/lang/InterruptedException
    //   115	128	292	java/util/concurrent/TimeoutException
    //   128	135	287	java/util/concurrent/CancellationException
    //   128	135	143	java/util/concurrent/ExecutionException
    //   128	135	138	java/lang/InterruptedException
    //   128	135	292	java/util/concurrent/TimeoutException
  }
  
  private e b(e parame) {
    int j = this.f.size();
    int i = 0;
    while (true) {
      if (i < j && (parame == null || !parame.m())) {
        e e1;
        try {
          e1 = ((Future<e>)this.f.get(i)).get(40000L, TimeUnit.MILLISECONDS);
        } catch (CancellationException cancellationException) {
          Logger.i(a, "{checkResponse} when check result, find CancellationException, check others");
          e1 = parame;
        } catch (ExecutionException executionException) {
          String str1 = a;
          String str2 = "{checkResponse} when check result, find ExecutionException, check others";
          Logger.w(str1, str2, executionException);
          e1 = parame;
        } catch (InterruptedException interruptedException) {
          String str1 = a;
          String str2 = "{checkResponse} when check result, find InterruptedException, check others";
          Logger.w(str1, str2, interruptedException);
          e1 = parame;
        } catch (TimeoutException timeoutException) {
          Logger.w(a, "{checkResponse} when check result, find TimeoutException, cancel current request task");
          e1 = parame;
          if (!((Future)this.f.get(i)).isCancelled()) {
            ((Future)this.f.get(i)).cancel(true);
            e1 = parame;
          } 
        } 
        i++;
        parame = e1;
        continue;
      } 
      return parame;
    } 
  }
  
  private e b(ExecutorService paramExecutorService, String paramString) {
    int i;
    long l1 = SystemClock.elapsedRealtime();
    e e1 = a(paramExecutorService, this.j, paramString);
    if (e1 == null) {
      i = 0;
    } else {
      i = e1.b();
    } 
    Logger.v(a, "use 2.0 interface return http's code is：{%s}", new Object[] { Integer.valueOf(i) });
    if (i == 404 || i == 401) {
      if (TextUtils.isEmpty(c()) && TextUtils.isEmpty(this.b.getAppName())) {
        Logger.i(a, "request grs server use 1.0 API must set appName,please check.");
        return null;
      } 
      this.f.clear();
      Logger.i(a, "this env has not deploy new interface,so use old interface.");
      e1 = a(paramExecutorService, this.i, paramString);
    } 
    long l2 = SystemClock.elapsedRealtime();
    g.a(this.g, l2 - l1, this.h, this.c);
    return e1;
  }
  
  private void b() {
    c c1 = a.a(this.c);
    if (c1 == null) {
      Logger.w(a, "g*s***_se****er_conf*** maybe has a big error");
      return;
    } 
    a(c1);
    List list = c1.a();
    if (list == null || list.size() <= 0) {
      Logger.v(a, "maybe grs_base_url config with [],please check.");
      return;
    } 
    if (list.size() <= 10) {
      String str1 = c1.c();
      String str2 = c1.b();
      if (list.size() > 0)
        for (String str4 : list) {
          if (!str4.startsWith("https://")) {
            Logger.w(a, "grs server just support https scheme url,please check.");
            continue;
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(str4);
          Locale locale = Locale.ROOT;
          if (TextUtils.isEmpty(c())) {
            str3 = this.b.getAppName();
          } else {
            str3 = c();
          } 
          stringBuilder2.append(String.format(locale, str1, new Object[] { str3 }));
          String str3 = this.b.getGrsReqParamJoint(false, false, "1.0", this.c);
          if (!TextUtils.isEmpty(str3)) {
            stringBuilder2.append("?");
            stringBuilder2.append(str3);
          } 
          str3 = stringBuilder2.toString();
          this.i.add(str3);
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str4);
          stringBuilder1.append(str2);
          str4 = this.b.getGrsReqParamJoint(false, false, c(), this.c);
          if (!TextUtils.isEmpty(str4)) {
            stringBuilder1.append("?");
            stringBuilder1.append(str4);
          } 
          this.j.add(stringBuilder1.toString());
        }  
      Logger.v(a, "request to GRS server url is{%s} and {%s}", new Object[] { this.i, this.j });
      return;
    } 
    throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
  }
  
  private String c() {
    a a1 = b.a(this.c.getPackageName(), this.b).a();
    if (a1 != null) {
      String str = a1.a();
      Logger.v(a, "get appName from local assets is{%s}", new Object[] { str });
      return str;
    } 
    return "";
  }
  
  public c a() {
    return this.k;
  }
  
  public e a(ExecutorService paramExecutorService, String paramString) {
    String str;
    if (this.i != null) {
      if (this.j == null)
        return null; 
      try {
        c c1 = a();
        if (c1 != null) {
          int i = c1.d();
          return paramExecutorService.<e>submit(new c(this, paramExecutorService, paramString)).get(i, TimeUnit.SECONDS);
        } 
      } catch (CancellationException cancellationException) {
        Logger.i(a, "{submitExcutorTaskWithTimeout} the computation was cancelled");
        return null;
      } catch (ExecutionException null) {
        String str1 = a;
        str = "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException";
        Logger.w(str1, str, exception);
        return null;
      } catch (InterruptedException null) {
        String str1 = a;
        str = "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting";
        Logger.w(str1, str, exception);
        return null;
      } catch (TimeoutException timeoutException) {
        Logger.w(a, "{submitExcutorTaskWithTimeout} the wait timed out");
        return null;
      } catch (Exception exception) {
        String str1 = a;
        str = "{submitExcutorTaskWithTimeout} catch Exception";
        Logger.w(str1, str, exception);
        return null;
      } 
    } else {
      return null;
    } 
    byte b = 10;
    return str.<e>submit(new c(this, (ExecutorService)str, (String)exception)).get(b, TimeUnit.SECONDS);
  }
  
  public void a(c paramc) {
    this.k = paramc;
  }
  
  public void a(e parame) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual add : (Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield e : Lcom/huawei/hms/framework/network/grs/c/e;
    //   15: astore #4
    //   17: aload #4
    //   19: ifnull -> 42
    //   22: aload #4
    //   24: invokevirtual m : ()Z
    //   27: ifeq -> 42
    //   30: getstatic com/huawei/hms/framework/network/grs/c/d.a : Ljava/lang/String;
    //   33: ldc_w 'grsResponseResult is ok'
    //   36: invokestatic v : (Ljava/lang/String;Ljava/lang/Object;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_1
    //   43: invokevirtual l : ()Z
    //   46: istore_3
    //   47: iconst_0
    //   48: istore_2
    //   49: iload_3
    //   50: ifeq -> 95
    //   53: getstatic com/huawei/hms/framework/network/grs/c/d.a : Ljava/lang/String;
    //   56: ldc_w 'GRS server open 503 limiting strategy.'
    //   59: invokestatic i : (Ljava/lang/String;Ljava/lang/Object;)V
    //   62: aload_0
    //   63: getfield b : Lcom/huawei/hms/framework/network/grs/GrsBaseInfo;
    //   66: iconst_0
    //   67: iconst_1
    //   68: aload_0
    //   69: getfield c : Landroid/content/Context;
    //   72: invokevirtual getGrsParasKey : (ZZLandroid/content/Context;)Ljava/lang/String;
    //   75: new com/huawei/hms/framework/network/grs/d/d$a
    //   78: dup
    //   79: aload_1
    //   80: invokevirtual j : ()J
    //   83: invokestatic elapsedRealtime : ()J
    //   86: invokespecial <init> : (JJ)V
    //   89: invokestatic a : (Ljava/lang/String;Lcom/huawei/hms/framework/network/grs/d/d$a;)V
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: aload_1
    //   96: invokevirtual m : ()Z
    //   99: ifne -> 114
    //   102: getstatic com/huawei/hms/framework/network/grs/c/d.a : Ljava/lang/String;
    //   105: ldc_w 'grsResponseResult has exception so need return'
    //   108: invokestatic v : (Ljava/lang/String;Ljava/lang/Object;)V
    //   111: aload_0
    //   112: monitorexit
    //   113: return
    //   114: aload_0
    //   115: aload_1
    //   116: putfield e : Lcom/huawei/hms/framework/network/grs/c/e;
    //   119: aload_0
    //   120: getfield d : Lcom/huawei/hms/framework/network/grs/a/a;
    //   123: aload_0
    //   124: getfield b : Lcom/huawei/hms/framework/network/grs/GrsBaseInfo;
    //   127: aload_0
    //   128: getfield e : Lcom/huawei/hms/framework/network/grs/c/e;
    //   131: aload_0
    //   132: getfield c : Landroid/content/Context;
    //   135: invokevirtual a : (Lcom/huawei/hms/framework/network/grs/GrsBaseInfo;Lcom/huawei/hms/framework/network/grs/c/e;Landroid/content/Context;)V
    //   138: iload_2
    //   139: aload_0
    //   140: getfield f : Ljava/util/ArrayList;
    //   143: invokevirtual size : ()I
    //   146: if_icmpge -> 244
    //   149: aload_0
    //   150: getfield i : Ljava/util/ArrayList;
    //   153: iload_2
    //   154: invokevirtual get : (I)Ljava/lang/Object;
    //   157: checkcast java/lang/String
    //   160: aload_1
    //   161: invokevirtual k : ()Ljava/lang/String;
    //   164: invokevirtual equals : (Ljava/lang/Object;)Z
    //   167: ifne -> 237
    //   170: aload_0
    //   171: getfield j : Ljava/util/ArrayList;
    //   174: iload_2
    //   175: invokevirtual get : (I)Ljava/lang/Object;
    //   178: checkcast java/lang/String
    //   181: aload_1
    //   182: invokevirtual k : ()Ljava/lang/String;
    //   185: invokevirtual equals : (Ljava/lang/Object;)Z
    //   188: ifne -> 237
    //   191: aload_0
    //   192: getfield f : Ljava/util/ArrayList;
    //   195: iload_2
    //   196: invokevirtual get : (I)Ljava/lang/Object;
    //   199: checkcast java/util/concurrent/Future
    //   202: invokeinterface isCancelled : ()Z
    //   207: ifne -> 237
    //   210: getstatic com/huawei/hms/framework/network/grs/c/d.a : Ljava/lang/String;
    //   213: ldc_w 'future cancel'
    //   216: invokestatic i : (Ljava/lang/String;Ljava/lang/Object;)V
    //   219: aload_0
    //   220: getfield f : Ljava/util/ArrayList;
    //   223: iload_2
    //   224: invokevirtual get : (I)Ljava/lang/Object;
    //   227: checkcast java/util/concurrent/Future
    //   230: iconst_1
    //   231: invokeinterface cancel : (Z)Z
    //   236: pop
    //   237: iload_2
    //   238: iconst_1
    //   239: iadd
    //   240: istore_2
    //   241: goto -> 138
    //   244: aload_0
    //   245: monitorexit
    //   246: return
    //   247: astore_1
    //   248: aload_0
    //   249: monitorexit
    //   250: aload_1
    //   251: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	247	finally
    //   22	39	247	finally
    //   42	47	247	finally
    //   53	92	247	finally
    //   95	111	247	finally
    //   114	138	247	finally
    //   138	237	247	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */