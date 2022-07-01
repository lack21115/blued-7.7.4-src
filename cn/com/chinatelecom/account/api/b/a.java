package cn.com.chinatelecom.account.api.b;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import cn.com.chinatelecom.account.api.a.d;
import cn.com.chinatelecom.account.api.c.g;
import cn.com.chinatelecom.account.api.d.b;
import cn.com.chinatelecom.account.api.d.d;
import cn.com.chinatelecom.account.api.d.e;
import cn.com.chinatelecom.account.api.d.f;
import cn.com.chinatelecom.account.api.d.g;
import cn.com.chinatelecom.account.api.d.h;
import cn.com.chinatelecom.account.api.d.j;
import org.json.JSONObject;

public final class a {
  private static final String a = a.class.getSimpleName();
  
  private boolean b = false;
  
  private Context c;
  
  private String d;
  
  private String e;
  
  private c f;
  
  public a(Context paramContext, String paramString1, String paramString2) {
    this.c = paramContext;
    this.d = paramString1;
    this.e = paramString2;
  }
  
  private String a(Context paramContext, String paramString1, String paramString2, String paramString3, CtSetting paramCtSetting, Network paramNetwork, String paramString4, String paramString5) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic a : (Landroid/content/Context;)J
    //   4: lstore #9
    //   6: aload_1
    //   7: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   10: astore #13
    //   12: aload #13
    //   14: astore #12
    //   16: invokestatic a : ()Ljava/lang/String;
    //   19: ifnull -> 38
    //   22: aload #13
    //   24: getstatic cn/com/chinatelecom/account/api/d/b.e : [B
    //   27: invokestatic a : ([B)Ljava/lang/String;
    //   30: invokestatic a : ()Ljava/lang/String;
    //   33: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   36: astore #12
    //   38: new org/json/JSONObject
    //   41: dup
    //   42: aload_1
    //   43: aload_2
    //   44: aload_3
    //   45: aload #4
    //   47: lload #9
    //   49: ldc ''
    //   51: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;
    //   54: invokespecial <init> : (Ljava/lang/String;)V
    //   57: astore #13
    //   59: aload #13
    //   61: ldc 'p'
    //   63: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   66: astore #14
    //   68: aload #13
    //   70: ldc 'k'
    //   72: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   75: astore #15
    //   77: aload #6
    //   79: ifnull -> 392
    //   82: invokestatic a : ()Ljava/lang/String;
    //   85: ifnonnull -> 392
    //   88: iconst_1
    //   89: istore #11
    //   91: goto -> 94
    //   94: new cn/com/chinatelecom/account/api/c/g$a
    //   97: dup
    //   98: invokespecial <init> : ()V
    //   101: astore #16
    //   103: aload #16
    //   105: aload #8
    //   107: invokevirtual a : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/c/g$a;
    //   110: pop
    //   111: aload #16
    //   113: iload #11
    //   115: invokestatic a : ()Ljava/lang/String;
    //   118: getstatic cn/com/chinatelecom/account/api/d/b.e : [B
    //   121: invokestatic a : ([B)Ljava/lang/String;
    //   124: invokevirtual a : (ZLjava/lang/String;Ljava/lang/String;)Lcn/com/chinatelecom/account/api/c/g$a;
    //   127: pop
    //   128: aload #16
    //   130: aload #7
    //   132: invokevirtual b : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/c/g$a;
    //   135: pop
    //   136: aload #16
    //   138: aload #6
    //   140: invokevirtual a : (Landroid/net/Network;)Lcn/com/chinatelecom/account/api/c/g$a;
    //   143: pop
    //   144: aload #16
    //   146: aload #5
    //   148: invokestatic getConnTimeout : (Lcn/com/chinatelecom/account/api/CtSetting;)I
    //   151: invokevirtual a : (I)Lcn/com/chinatelecom/account/api/c/g$a;
    //   154: pop
    //   155: aload #16
    //   157: aload #5
    //   159: invokestatic getReadTimeout : (Lcn/com/chinatelecom/account/api/CtSetting;)I
    //   162: invokevirtual b : (I)Lcn/com/chinatelecom/account/api/c/g$a;
    //   165: pop
    //   166: aload #16
    //   168: invokevirtual a : ()Lcn/com/chinatelecom/account/api/c/g;
    //   171: astore #13
    //   173: new cn/com/chinatelecom/account/api/c/b
    //   176: dup
    //   177: aload_1
    //   178: invokespecial <init> : (Landroid/content/Context;)V
    //   181: astore #17
    //   183: aload #17
    //   185: aload #12
    //   187: aload #14
    //   189: iconst_1
    //   190: aload #13
    //   192: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;ILcn/com/chinatelecom/account/api/c/g;)Lcn/com/chinatelecom/account/api/c/h;
    //   197: astore #13
    //   199: aload #13
    //   201: getfield c : Z
    //   204: ifeq -> 225
    //   207: aload_0
    //   208: aload_1
    //   209: aload #7
    //   211: aload_2
    //   212: aload_3
    //   213: aload #4
    //   215: aload #5
    //   217: aload #6
    //   219: aload #8
    //   221: invokespecial a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcn/com/chinatelecom/account/api/CtSetting;Landroid/net/Network;Ljava/lang/String;)Ljava/lang/String;
    //   224: areturn
    //   225: aload #13
    //   227: getfield e : Z
    //   230: ifeq -> 398
    //   233: aload_0
    //   234: monitorenter
    //   235: aload_0
    //   236: getfield b : Z
    //   239: istore #11
    //   241: aload_0
    //   242: monitorexit
    //   243: iload #11
    //   245: ifne -> 398
    //   248: aload #17
    //   250: aload #12
    //   252: aload #14
    //   254: iconst_1
    //   255: aload #16
    //   257: iconst_1
    //   258: invokevirtual a : (Z)Lcn/com/chinatelecom/account/api/c/g$a;
    //   261: iconst_0
    //   262: ldc ''
    //   264: ldc ''
    //   266: invokevirtual a : (ZLjava/lang/String;Ljava/lang/String;)Lcn/com/chinatelecom/account/api/c/g$a;
    //   269: invokevirtual a : ()Lcn/com/chinatelecom/account/api/c/g;
    //   272: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;ILcn/com/chinatelecom/account/api/c/g;)Lcn/com/chinatelecom/account/api/c/h;
    //   277: astore_2
    //   278: aload #7
    //   280: invokestatic a : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
    //   283: iconst_1
    //   284: invokevirtual b : (I)Lcn/com/chinatelecom/account/api/d/e;
    //   287: pop
    //   288: goto -> 296
    //   291: astore_1
    //   292: aload_0
    //   293: monitorexit
    //   294: aload_1
    //   295: athrow
    //   296: aload_1
    //   297: aload_2
    //   298: aload #15
    //   300: aload #6
    //   302: iconst_1
    //   303: aload #7
    //   305: invokestatic a : (Landroid/content/Context;Lcn/com/chinatelecom/account/api/c/h;Ljava/lang/String;Landroid/net/Network;ZLjava/lang/String;)Ljava/lang/String;
    //   308: astore_1
    //   309: aload #7
    //   311: aload_1
    //   312: aload #14
    //   314: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_1
    //   318: areturn
    //   319: astore_1
    //   320: invokestatic f : ()Ljava/lang/String;
    //   323: astore_2
    //   324: aload #7
    //   326: invokestatic a : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
    //   329: astore_3
    //   330: new java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial <init> : ()V
    //   337: astore #4
    //   339: aload #4
    //   341: ldc 'gpm ：'
    //   343: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload #4
    //   349: aload_1
    //   350: invokevirtual getMessage : ()Ljava/lang/String;
    //   353: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload_3
    //   358: aload #4
    //   360: invokevirtual toString : ()Ljava/lang/String;
    //   363: invokevirtual g : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
    //   366: ldc 80102
    //   368: invokevirtual a : (I)Lcn/com/chinatelecom/account/api/d/e;
    //   371: getstatic cn/com/chinatelecom/account/api/d/j.k : [B
    //   374: invokestatic a : ([B)Ljava/lang/String;
    //   377: invokevirtual e : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
    //   380: pop
    //   381: getstatic cn/com/chinatelecom/account/api/b/a.a : Ljava/lang/String;
    //   384: ldc 'GPM Throwable'
    //   386: aload_1
    //   387: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   390: aload_2
    //   391: areturn
    //   392: iconst_0
    //   393: istore #11
    //   395: goto -> 94
    //   398: aload #13
    //   400: astore_2
    //   401: goto -> 296
    // Exception table:
    //   from	to	target	type
    //   0	12	319	finally
    //   16	38	319	finally
    //   38	77	319	finally
    //   82	88	319	finally
    //   94	225	319	finally
    //   225	235	319	finally
    //   235	243	291	finally
    //   248	288	319	finally
    //   292	294	291	finally
    //   294	296	319	finally
    //   296	317	319	finally
  }
  
  private String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, CtSetting paramCtSetting, Network paramNetwork, String paramString5) {
    try {
      long l = cn.com.chinatelecom.account.api.d.a.a(paramContext);
      String str4 = h.a(paramContext);
      String str3 = str4;
      if (g.a() != null)
        str3 = str4.replace(d.a(b.e), g.a()); 
      JSONObject jSONObject = new JSONObject(h.a(paramContext, paramString2, paramString3, paramString4, l, ""));
      paramString2 = jSONObject.optString("p");
      String str2 = jSONObject.optString("k");
      f.a(paramString1).g("spr_req");
      g.a a1 = new g.a();
      a1.a(paramString5);
      return str1;
    } finally {
      paramContext = null;
      paramString2 = j.f();
      e e = f.a(paramString1);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("spr ：");
      stringBuilder.append(paramContext.getMessage());
      e.g(stringBuilder.toString()).a(80102).e(d.a(j.k));
      CtAuth.warn(a, "SPR Throwable", (Throwable)paramContext);
    } 
  }
  
  private void a() {
    c c1 = this.f;
    if (c1 != null)
      c1.a(); 
  }
  
  private void a(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3, ResultListener paramResultListener) {
    f.a(paramString2).a(paramInt).e(paramString1).b(paramLong).g(paramString3);
    f.c(paramString2);
    paramString1 = j.a(paramInt, paramString1, paramString2);
    if (paramResultListener != null)
      paramResultListener.onResult(paramString1); 
  }
  
  private void a(String paramString1, CtSetting paramCtSetting, Network paramNetwork, ResultListener paramResultListener, long paramLong, String paramString2, String paramString3) {
    (new d()).a(new e(this, paramLong, paramString1, paramCtSetting, paramNetwork, paramString2, paramString3, paramResultListener) {
          public void a() {
            // Byte code:
            //   0: aload_0
            //   1: getfield g : Lcn/com/chinatelecom/account/api/b/a;
            //   4: astore_1
            //   5: aload_1
            //   6: aload_1
            //   7: invokestatic b : (Lcn/com/chinatelecom/account/api/b/a;)Landroid/content/Context;
            //   10: aload_0
            //   11: getfield g : Lcn/com/chinatelecom/account/api/b/a;
            //   14: invokestatic c : (Lcn/com/chinatelecom/account/api/b/a;)Ljava/lang/String;
            //   17: aload_0
            //   18: getfield g : Lcn/com/chinatelecom/account/api/b/a;
            //   21: invokestatic d : (Lcn/com/chinatelecom/account/api/b/a;)Ljava/lang/String;
            //   24: aload_0
            //   25: getfield a : Ljava/lang/String;
            //   28: aload_0
            //   29: getfield b : Lcn/com/chinatelecom/account/api/CtSetting;
            //   32: aload_0
            //   33: getfield c : Landroid/net/Network;
            //   36: aload_0
            //   37: getfield d : Ljava/lang/String;
            //   40: aload_0
            //   41: getfield e : Ljava/lang/String;
            //   44: invokestatic a : (Lcn/com/chinatelecom/account/api/b/a;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcn/com/chinatelecom/account/api/CtSetting;Landroid/net/Network;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   47: astore_1
            //   48: aload_0
            //   49: monitorenter
            //   50: aload_0
            //   51: invokevirtual c : ()Z
            //   54: ifne -> 78
            //   57: aload_0
            //   58: iconst_1
            //   59: invokevirtual a : (Z)V
            //   62: aload_0
            //   63: invokevirtual d : ()V
            //   66: aload_0
            //   67: getfield d : Ljava/lang/String;
            //   70: aload_1
            //   71: aload_0
            //   72: getfield f : Lcn/com/chinatelecom/account/api/ResultListener;
            //   75: invokestatic postResultOnMainThread : (Ljava/lang/String;Ljava/lang/String;Lcn/com/chinatelecom/account/api/ResultListener;)V
            //   78: aload_0
            //   79: monitorexit
            //   80: aload_0
            //   81: getfield c : Landroid/net/Network;
            //   84: ifnull -> 94
            //   87: aload_0
            //   88: getfield g : Lcn/com/chinatelecom/account/api/b/a;
            //   91: invokestatic a : (Lcn/com/chinatelecom/account/api/b/a;)V
            //   94: return
            //   95: astore_1
            //   96: aload_0
            //   97: monitorexit
            //   98: aload_1
            //   99: athrow
            // Exception table:
            //   from	to	target	type
            //   50	78	95	finally
            //   78	80	95	finally
            //   96	98	95	finally
          }
          
          public void b() {
            // Byte code:
            //   0: aload_0
            //   1: invokespecial b : ()V
            //   4: aload_0
            //   5: getfield g : Lcn/com/chinatelecom/account/api/b/a;
            //   8: astore_1
            //   9: aload_1
            //   10: monitorenter
            //   11: aload_0
            //   12: getfield g : Lcn/com/chinatelecom/account/api/b/a;
            //   15: iconst_1
            //   16: invokestatic a : (Lcn/com/chinatelecom/account/api/b/a;Z)Z
            //   19: pop
            //   20: aload_1
            //   21: monitorexit
            //   22: aload_0
            //   23: monitorenter
            //   24: aload_0
            //   25: invokevirtual c : ()Z
            //   28: ifne -> 62
            //   31: aload_0
            //   32: iconst_1
            //   33: invokevirtual a : (Z)V
            //   36: aload_0
            //   37: getfield g : Lcn/com/chinatelecom/account/api/b/a;
            //   40: ldc 80000
            //   42: getstatic cn/com/chinatelecom/account/api/d/j.a : [B
            //   45: invokestatic a : ([B)Ljava/lang/String;
            //   48: aload_0
            //   49: getfield d : Ljava/lang/String;
            //   52: lconst_0
            //   53: ldc ''
            //   55: aload_0
            //   56: getfield f : Lcn/com/chinatelecom/account/api/ResultListener;
            //   59: invokestatic a : (Lcn/com/chinatelecom/account/api/b/a;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcn/com/chinatelecom/account/api/ResultListener;)V
            //   62: aload_0
            //   63: monitorexit
            //   64: aload_0
            //   65: getfield c : Landroid/net/Network;
            //   68: ifnull -> 78
            //   71: aload_0
            //   72: getfield g : Lcn/com/chinatelecom/account/api/b/a;
            //   75: invokestatic a : (Lcn/com/chinatelecom/account/api/b/a;)V
            //   78: return
            //   79: astore_1
            //   80: aload_0
            //   81: monitorexit
            //   82: aload_1
            //   83: athrow
            //   84: astore_2
            //   85: aload_1
            //   86: monitorexit
            //   87: aload_2
            //   88: athrow
            // Exception table:
            //   from	to	target	type
            //   11	22	84	finally
            //   24	62	79	finally
            //   62	64	79	finally
            //   80	82	79	finally
            //   85	87	84	finally
          }
        });
  }
  
  public void a(String paramString, CtSetting paramCtSetting, ResultListener paramResultListener) {
    int i = CtSetting.getTotalTimeout(paramCtSetting);
    String str1 = d.a();
    String str2 = d.a(this.c);
    String str3 = cn.com.chinatelecom.account.api.d.a.c(this.c);
    f.a(str1).a(str2).c(str3).b(g.e(this.c));
    a(paramString, paramCtSetting, (Network)null, paramResultListener, i, str1, str3);
  }
  
  public void b(String paramString, CtSetting paramCtSetting, ResultListener paramResultListener) {
    int i = CtSetting.getTotalTimeout(paramCtSetting);
    String str3 = d.a();
    String str1 = d.a(this.c);
    String str4 = cn.com.chinatelecom.account.api.d.a.c(this.c);
    f.a(str3).a(str1).c(str4).b("BOTH");
    if (Build.VERSION.SDK_INT >= 21) {
      this.f = new c(this.c);
      this.f.a(new b(this, i, paramString, paramCtSetting, paramResultListener, str3, str4) {
            public void a() {
              a.a(this.g);
              a.a(this.g, 80800, d.a(j.o), this.e, 2500L, "", this.d);
            }
            
            public void a(long param1Long) {
              a.a(this.g);
              a.a(this.g, 80801, d.a(j.p), this.e, param1Long, "", this.d);
            }
            
            public void a(Network param1Network, long param1Long) {
              long l = this.a - param1Long;
              if (l > 100L) {
                a.a(this.g, this.b, this.c, param1Network, this.d, l, this.e, this.f);
              } else {
                a.a(this.g);
                CtAuth.postResultOnMainThread(this.e, j.c(), this.d);
              } 
              f.a(this.e).b(param1Long);
            }
          });
      return;
    } 
    this.f = new c(this.c);
    String str2 = h.a(this.c);
    str1 = str2;
    if (g.a() != null)
      str1 = str2.replace(d.a(b.e), g.a()); 
    this.f.a(new b(this, i, paramString, paramCtSetting, paramResultListener, str3, str4) {
          public void a() {
            a.a(this.g, 80800, d.a(j.o), this.e, 2500L, "Switching network timeout (4.x)", this.d);
          }
          
          public void a(long param1Long) {
            a.a(this.g, 80801, d.a(j.p), this.e, param1Long, "Switching network failed (4.x)", this.d);
          }
          
          public void a(Network param1Network, long param1Long) {
            long l = this.a - param1Long;
            if (l > 100L) {
              a.a(this.g, this.b, this.c, (Network)null, this.d, l, this.e, this.f);
            } else {
              CtAuth.postResultOnMainThread(this.e, j.c(), this.d);
            } 
            f.a(this.e).b(param1Long);
          }
        }str1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */