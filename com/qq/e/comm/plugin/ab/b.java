package com.qq.e.comm.plugin.ab;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.g;
import com.qq.e.comm.plugin.y.u;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;

public class b {
  public static int b = 1;
  
  public static int c = 2;
  
  public static int d = 3;
  
  public static int e = 10;
  
  public static int f = 11;
  
  public static int g = 12;
  
  String a;
  
  int h = 100;
  
  a i = a.a;
  
  long j;
  
  public b(String paramString, long paramLong) {
    this.a = paramString;
    this.j = paramLong;
    a();
    ak.b("CGIWebReporter", ":report url = %s", new Object[] { this.a });
  }
  
  private void a() {
    if (!TextUtils.isEmpty(this.a))
      this.a = this.a.replaceAll("__VERSION__", GDTADManager.getInstance().getAppStatus().getAPPVersion()).replaceAll("__CLICK_LPP__", c()).replaceAll("__OS_TYPE__", "2"); 
  }
  
  public static void a(int paramInt, long paramLong, c paramc, String paramString1, String paramString2) {
    g g = (new g(paramInt)).b(System.currentTimeMillis() - paramLong);
    g.a(paramc);
    g.a((new d()).a("url", paramString1).a("msg", paramString2));
    u.a(g);
  }
  
  public static boolean a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        return (new URL(paramString)).getHost().contains("gdt.qq.com");
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return false;
  }
  
  private long b() {
    return System.currentTimeMillis() - this.j;
  }
  
  private String c() {
    try {
      long l;
      JSONObject jSONObject = new JSONObject();
      if (this.j > 0L) {
        l = this.j;
      } else {
        l = System.currentTimeMillis();
      } 
      jSONObject.put("click_time", l);
      return URLEncoder.encode(jSONObject.toString(), "UTF-8");
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  void a(int paramInt, long paramLong) {
    String str2 = this.a;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
      str1 = str2.replaceAll("__PAGE_ACTION_ID__", String.valueOf(paramInt)).replaceAll("__PAGE_TIME__", String.valueOf(paramLong)); 
    ak.b("CGIWebReporter", ":report now,action is %d ", new Object[] { Integer.valueOf(paramInt) });
    ak.b("CGIWebReporter", ":report time %d ", new Object[] { Long.valueOf(paramLong) });
    ak.b("CGIWebReporter", ":report last url %s", new Object[] { str1 });
    ah.a(str1);
  }
  
  public void a(String paramString, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/lang/String;
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: ifeq -> 11
    //   10: return
    //   11: ldc 'CGIWebReporter'
    //   13: ldc ':cur load url = %s'
    //   15: iconst_1
    //   16: anewarray java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: aload_1
    //   22: aastore
    //   23: invokestatic b : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: getstatic com/qq/e/comm/plugin/ab/b$1.a : [I
    //   29: aload_0
    //   30: getfield i : Lcom/qq/e/comm/plugin/ab/b$a;
    //   33: invokevirtual ordinal : ()I
    //   36: iaload
    //   37: istore_3
    //   38: iload_3
    //   39: iconst_1
    //   40: if_icmpeq -> 245
    //   43: iload_3
    //   44: iconst_2
    //   45: if_icmpeq -> 138
    //   48: iload_3
    //   49: iconst_3
    //   50: if_icmpeq -> 104
    //   53: iload_3
    //   54: iconst_4
    //   55: if_icmpeq -> 61
    //   58: goto -> 297
    //   61: iload_2
    //   62: getstatic com/qq/e/comm/plugin/ab/b.b : I
    //   65: if_icmpne -> 94
    //   68: aload_0
    //   69: getstatic com/qq/e/comm/plugin/ab/b$a.e : Lcom/qq/e/comm/plugin/ab/b$a;
    //   72: putfield i : Lcom/qq/e/comm/plugin/ab/b$a;
    //   75: aload_0
    //   76: iconst_4
    //   77: aload_0
    //   78: invokespecial b : ()J
    //   81: invokevirtual a : (IJ)V
    //   84: aload_0
    //   85: invokestatic currentTimeMillis : ()J
    //   88: putfield j : J
    //   91: goto -> 297
    //   94: iload_2
    //   95: getstatic com/qq/e/comm/plugin/ab/b.f : I
    //   98: if_icmpne -> 297
    //   101: goto -> 118
    //   104: iload_2
    //   105: getstatic com/qq/e/comm/plugin/ab/b.e : I
    //   108: if_icmpeq -> 118
    //   111: iload_2
    //   112: getstatic com/qq/e/comm/plugin/ab/b.f : I
    //   115: if_icmpne -> 297
    //   118: aload_0
    //   119: getstatic com/qq/e/comm/plugin/ab/b$a.e : Lcom/qq/e/comm/plugin/ab/b$a;
    //   122: putfield i : Lcom/qq/e/comm/plugin/ab/b$a;
    //   125: aload_0
    //   126: bipush #7
    //   128: aload_0
    //   129: invokespecial b : ()J
    //   132: invokevirtual a : (IJ)V
    //   135: goto -> 297
    //   138: iload_2
    //   139: getstatic com/qq/e/comm/plugin/ab/b.c : I
    //   142: if_icmpne -> 164
    //   145: aload_0
    //   146: getstatic com/qq/e/comm/plugin/ab/b$a.c : Lcom/qq/e/comm/plugin/ab/b$a;
    //   149: putfield i : Lcom/qq/e/comm/plugin/ab/b$a;
    //   152: aload_0
    //   153: iconst_3
    //   154: aload_0
    //   155: invokespecial b : ()J
    //   158: invokevirtual a : (IJ)V
    //   161: goto -> 297
    //   164: iload_2
    //   165: getstatic com/qq/e/comm/plugin/ab/b.d : I
    //   168: if_icmpne -> 197
    //   171: aload_0
    //   172: getstatic com/qq/e/comm/plugin/ab/b$a.d : Lcom/qq/e/comm/plugin/ab/b$a;
    //   175: putfield i : Lcom/qq/e/comm/plugin/ab/b$a;
    //   178: aload_1
    //   179: invokestatic a : (Ljava/lang/String;)Z
    //   182: ifne -> 297
    //   185: aload_0
    //   186: iconst_4
    //   187: aload_0
    //   188: invokespecial b : ()J
    //   191: invokevirtual a : (IJ)V
    //   194: goto -> 297
    //   197: iload_2
    //   198: getstatic com/qq/e/comm/plugin/ab/b.e : I
    //   201: if_icmpne -> 225
    //   204: aload_0
    //   205: getstatic com/qq/e/comm/plugin/ab/b$a.e : Lcom/qq/e/comm/plugin/ab/b$a;
    //   208: putfield i : Lcom/qq/e/comm/plugin/ab/b$a;
    //   211: iconst_5
    //   212: istore_3
    //   213: aload_0
    //   214: iload_3
    //   215: aload_0
    //   216: invokespecial b : ()J
    //   219: invokevirtual a : (IJ)V
    //   222: goto -> 297
    //   225: iload_2
    //   226: getstatic com/qq/e/comm/plugin/ab/b.f : I
    //   229: if_icmpne -> 297
    //   232: aload_0
    //   233: getstatic com/qq/e/comm/plugin/ab/b$a.e : Lcom/qq/e/comm/plugin/ab/b$a;
    //   236: putfield i : Lcom/qq/e/comm/plugin/ab/b$a;
    //   239: bipush #6
    //   241: istore_3
    //   242: goto -> 213
    //   245: iload_2
    //   246: getstatic com/qq/e/comm/plugin/ab/b.b : I
    //   249: if_icmpne -> 297
    //   252: aload_1
    //   253: invokestatic a : (Ljava/lang/String;)Z
    //   256: ifeq -> 274
    //   259: aload_0
    //   260: getfield h : I
    //   263: bipush #100
    //   265: if_icmpne -> 274
    //   268: aload_0
    //   269: bipush #101
    //   271: putfield h : I
    //   274: aload_0
    //   275: getfield j : J
    //   278: lconst_0
    //   279: lcmp
    //   280: ifgt -> 290
    //   283: aload_0
    //   284: invokestatic currentTimeMillis : ()J
    //   287: putfield j : J
    //   290: aload_0
    //   291: getstatic com/qq/e/comm/plugin/ab/b$a.b : Lcom/qq/e/comm/plugin/ab/b$a;
    //   294: putfield i : Lcom/qq/e/comm/plugin/ab/b$a;
    //   297: aload_0
    //   298: getfield h : I
    //   301: bipush #101
    //   303: if_icmpne -> 382
    //   306: iload_2
    //   307: getstatic com/qq/e/comm/plugin/ab/b.b : I
    //   310: if_icmpne -> 346
    //   313: aload_0
    //   314: getfield i : Lcom/qq/e/comm/plugin/ab/b$a;
    //   317: getstatic com/qq/e/comm/plugin/ab/b$a.b : Lcom/qq/e/comm/plugin/ab/b$a;
    //   320: if_acmpne -> 346
    //   323: aload_1
    //   324: invokestatic a : (Ljava/lang/String;)Z
    //   327: ifne -> 346
    //   330: aload_0
    //   331: iconst_1
    //   332: aload_0
    //   333: invokespecial b : ()J
    //   336: invokevirtual a : (IJ)V
    //   339: aload_0
    //   340: bipush #102
    //   342: putfield h : I
    //   345: return
    //   346: aload_1
    //   347: invokestatic a : (Ljava/lang/String;)Z
    //   350: ifeq -> 382
    //   353: iload_2
    //   354: getstatic com/qq/e/comm/plugin/ab/b.g : I
    //   357: if_icmpeq -> 367
    //   360: iload_2
    //   361: getstatic com/qq/e/comm/plugin/ab/b.d : I
    //   364: if_icmpne -> 382
    //   367: aload_0
    //   368: bipush #102
    //   370: putfield h : I
    //   373: aload_0
    //   374: iconst_2
    //   375: aload_0
    //   376: invokespecial b : ()J
    //   379: invokevirtual a : (IJ)V
    //   382: return
  }
  
  enum a {
    a, b, c, d, e;
    
    public static a[] a() {
      return (a[])f.clone();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */