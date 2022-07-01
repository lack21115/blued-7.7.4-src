package com.ta.utdid2.device;

import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import com.ta.utdid2.a.a.b;
import com.ta.utdid2.a.a.d;
import com.ta.utdid2.a.a.e;
import com.ta.utdid2.a.a.f;
import com.ta.utdid2.a.a.g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class c {
  private static c a;
  
  private static final Object e = new Object();
  
  private static final String k;
  
  private com.ta.utdid2.b.a.c a;
  
  private d a = null;
  
  private com.ta.utdid2.b.a.c b;
  
  private Pattern b;
  
  private String h = null;
  
  private String i = "xx_utdid_key";
  
  private String j = "xx_utdid_domain";
  
  private Context mContext = null;
  
  static {
    a = null;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(".UTSystemConfig");
    stringBuilder.append(File.separator);
    stringBuilder.append("Global");
    k = stringBuilder.toString();
  }
  
  private c(Context paramContext) {
    this.a = null;
    this.b = null;
    this.b = Pattern.compile("[^0-9a-zA-Z=/+]+");
    this.mContext = paramContext;
    this.b = (Pattern)new com.ta.utdid2.b.a.c(paramContext, k, "Alvin2", false, true);
    this.a = (d)new com.ta.utdid2.b.a.c(paramContext, ".DataStorage", "ContextData", false, true);
    this.a = new d();
    this.i = String.format("K_%d", new Object[] { Integer.valueOf(g.a(this.i)) });
    this.j = String.format("D_%d", new Object[] { Integer.valueOf(g.a(this.j)) });
  }
  
  public static c a(Context paramContext) {
    if (paramContext != null && a == null)
      synchronized (e) {
        if (a == null) {
          a = (d)new c(paramContext);
          a.c();
        } 
      }  
    return (c)a;
  }
  
  public static String b(byte[] paramArrayOfbyte) throws Exception {
    Mac mac = Mac.getInstance("HmacSHA1");
    mac.init(new SecretKeySpec(f.a(new byte[] { 
              69, 114, 116, -33, 125, -54, -31, 86, -11, 11, 
              -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 
              113, 116, -16, -103, 49, -30, 9, -39, 33, -80, 
              -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 
              106, 85, -38, -93 }, ), mac.getAlgorithm()));
    return b.encodeToString(mac.doFinal(paramArrayOfbyte), 2);
  }
  
  private boolean b(String paramString) {
    if (paramString != null) {
      String str = paramString;
      if (paramString.endsWith("\n"))
        str = paramString.substring(0, paramString.length() - 1); 
      if (24 == str.length() && !this.b.matcher(str).find())
        return true; 
    } 
    return false;
  }
  
  private void c() {
    Pattern pattern = this.b;
    if (pattern != null) {
      if (g.a(pattern.getString("UTDID2"))) {
        String str = this.b.getString("UTDID");
        if (!g.a(str))
          f(str); 
      } 
      boolean bool = false;
      if (!g.a(this.b.getString("DID"))) {
        this.b.remove("DID");
        bool = true;
      } 
      if (!g.a(this.b.getString("EI"))) {
        this.b.remove("EI");
        bool = true;
      } 
      if (!g.a(this.b.getString("SI"))) {
        this.b.remove("SI");
        bool = true;
      } 
      if (bool)
        this.b.commit(); 
    } 
  }
  
  private byte[] c() throws Exception {
    String str;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = (new Random()).nextInt();
    byte[] arrayOfByte1 = d.getBytes(i);
    byte[] arrayOfByte2 = d.getBytes(j);
    byteArrayOutputStream.write(arrayOfByte1, 0, 4);
    byteArrayOutputStream.write(arrayOfByte2, 0, 4);
    byteArrayOutputStream.write(3);
    byteArrayOutputStream.write(0);
    try {
      str = e.a(this.mContext);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append((new Random()).nextInt());
      str = stringBuilder.toString();
    } 
    byteArrayOutputStream.write(d.getBytes(g.a(str)), 0, 4);
    byteArrayOutputStream.write(d.getBytes(g.a(b(byteArrayOutputStream.toByteArray()))));
    return byteArrayOutputStream.toByteArray();
  }
  
  private void f(String paramString) {
    if (b(paramString)) {
      String str = paramString;
      if (paramString.endsWith("\n"))
        str = paramString.substring(0, paramString.length() - 1); 
      if (str.length() == 24) {
        Pattern pattern = this.b;
        if (pattern != null) {
          pattern.putString("UTDID2", str);
          this.b.commit();
        } 
      } 
    } 
  }
  
  private boolean f() {
    return (this.mContext.checkPermission("android.permission.WRITE_SETTINGS", Binder.getCallingPid(), Binder.getCallingUid()) == 0);
  }
  
  private String g() {
    Pattern pattern = this.b;
    if (pattern != null) {
      String str = pattern.getString("UTDID2");
      if (!g.a(str) && this.a.c(str) != null)
        return str; 
    } 
    return null;
  }
  
  private void g(String paramString) {
    if (paramString != null) {
      d d1 = this.a;
      if (d1 != null && !paramString.equals(d1.getString(this.i))) {
        this.a.putString(this.i, paramString);
        this.a.commit();
      } 
    } 
  }
  
  private void h(String paramString) {
    if (f() && b(paramString)) {
      String str = paramString;
      if (paramString.endsWith("\n"))
        str = paramString.substring(0, paramString.length() - 1); 
      if (24 == str.length()) {
        paramString = null;
        try {
          String str1 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
          paramString = str1;
        } catch (Exception exception) {}
        if (!b(paramString))
          try {
            Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str);
            return;
          } catch (Exception exception) {
            return;
          }  
      } 
    } 
  }
  
  private void i(String paramString) {
    try {
      String str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
    } catch (Exception exception) {
      exception = null;
    } 
    if (!paramString.equals(exception))
      try {
        Settings.System.putString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp", paramString);
        return;
      } catch (Exception exception1) {
        return;
      }  
  }
  
  private void j(String paramString) {
    if (f() && paramString != null)
      i(paramString); 
  }
  
  public String getValue() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Ljava/lang/String;
    //   6: ifnull -> 18
    //   9: aload_0
    //   10: getfield h : Ljava/lang/String;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual h : ()Ljava/lang/String;
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	27	finally
    //   18	23	27	finally
  }
  
  public String h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: invokevirtual i : ()Ljava/lang/String;
    //   7: putfield h : Ljava/lang/String;
    //   10: aload_0
    //   11: getfield h : Ljava/lang/String;
    //   14: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   17: ifne -> 29
    //   20: aload_0
    //   21: getfield h : Ljava/lang/String;
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: aload_0
    //   30: invokespecial c : ()[B
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull -> 92
    //   38: aload_0
    //   39: aload_1
    //   40: iconst_2
    //   41: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   44: putfield h : Ljava/lang/String;
    //   47: aload_0
    //   48: aload_0
    //   49: getfield h : Ljava/lang/String;
    //   52: invokespecial f : (Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield a : Lcom/ta/utdid2/device/d;
    //   59: aload_1
    //   60: invokevirtual c : ([B)Ljava/lang/String;
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull -> 78
    //   68: aload_0
    //   69: aload_1
    //   70: invokespecial j : (Ljava/lang/String;)V
    //   73: aload_0
    //   74: aload_1
    //   75: invokespecial g : (Ljava/lang/String;)V
    //   78: aload_0
    //   79: getfield h : Ljava/lang/String;
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: areturn
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual printStackTrace : ()V
    //   92: aload_0
    //   93: monitorexit
    //   94: aconst_null
    //   95: areturn
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	96	finally
    //   29	34	87	java/lang/Exception
    //   29	34	96	finally
    //   38	64	87	java/lang/Exception
    //   38	64	96	finally
    //   68	78	87	java/lang/Exception
    //   68	78	96	finally
    //   78	83	87	java/lang/Exception
    //   78	83	96	finally
    //   88	92	96	finally
  }
  
  public String i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w ''
    //   5: astore_3
    //   6: aload_0
    //   7: getfield mContext : Landroid/content/Context;
    //   10: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   13: ldc_w 'mqBRboGZkQPcAkyk'
    //   16: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   19: astore #4
    //   21: aload #4
    //   23: astore_3
    //   24: aload_0
    //   25: aload_3
    //   26: invokespecial b : (Ljava/lang/String;)Z
    //   29: istore_2
    //   30: iload_2
    //   31: ifeq -> 38
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_3
    //   37: areturn
    //   38: new com/ta/utdid2/device/e
    //   41: dup
    //   42: invokespecial <init> : ()V
    //   45: astore #5
    //   47: iconst_0
    //   48: istore_1
    //   49: aload_0
    //   50: getfield mContext : Landroid/content/Context;
    //   53: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   56: ldc_w 'dxCRMxhQkdGePGnp'
    //   59: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_3
    //   63: goto -> 68
    //   66: aconst_null
    //   67: astore_3
    //   68: aload_3
    //   69: invokestatic a : (Ljava/lang/String;)Z
    //   72: ifne -> 217
    //   75: aload #5
    //   77: aload_3
    //   78: invokevirtual e : (Ljava/lang/String;)Ljava/lang/String;
    //   81: astore #4
    //   83: aload_0
    //   84: aload #4
    //   86: invokespecial b : (Ljava/lang/String;)Z
    //   89: ifeq -> 103
    //   92: aload_0
    //   93: aload #4
    //   95: invokespecial h : (Ljava/lang/String;)V
    //   98: aload_0
    //   99: monitorexit
    //   100: aload #4
    //   102: areturn
    //   103: aload #5
    //   105: aload_3
    //   106: invokevirtual d : (Ljava/lang/String;)Ljava/lang/String;
    //   109: astore #6
    //   111: aload_3
    //   112: astore #4
    //   114: aload_0
    //   115: aload #6
    //   117: invokespecial b : (Ljava/lang/String;)Z
    //   120: ifeq -> 166
    //   123: aload_0
    //   124: getfield a : Lcom/ta/utdid2/device/d;
    //   127: aload #6
    //   129: invokevirtual c : (Ljava/lang/String;)Ljava/lang/String;
    //   132: astore #6
    //   134: aload_3
    //   135: astore #4
    //   137: aload #6
    //   139: invokestatic a : (Ljava/lang/String;)Z
    //   142: ifne -> 166
    //   145: aload_0
    //   146: aload #6
    //   148: invokespecial j : (Ljava/lang/String;)V
    //   151: aload_0
    //   152: getfield mContext : Landroid/content/Context;
    //   155: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   158: ldc_w 'dxCRMxhQkdGePGnp'
    //   161: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   164: astore #4
    //   166: aload_0
    //   167: getfield a : Lcom/ta/utdid2/device/d;
    //   170: aload #4
    //   172: invokevirtual d : (Ljava/lang/String;)Ljava/lang/String;
    //   175: astore_3
    //   176: aload_0
    //   177: aload_3
    //   178: invokespecial b : (Ljava/lang/String;)Z
    //   181: ifeq -> 219
    //   184: aload_0
    //   185: aload_3
    //   186: putfield h : Ljava/lang/String;
    //   189: aload_0
    //   190: aload_3
    //   191: invokespecial f : (Ljava/lang/String;)V
    //   194: aload_0
    //   195: aload #4
    //   197: invokespecial g : (Ljava/lang/String;)V
    //   200: aload_0
    //   201: aload_0
    //   202: getfield h : Ljava/lang/String;
    //   205: invokespecial h : (Ljava/lang/String;)V
    //   208: aload_0
    //   209: getfield h : Ljava/lang/String;
    //   212: astore_3
    //   213: aload_0
    //   214: monitorexit
    //   215: aload_3
    //   216: areturn
    //   217: iconst_1
    //   218: istore_1
    //   219: aload_0
    //   220: invokespecial g : ()Ljava/lang/String;
    //   223: astore_3
    //   224: aload_0
    //   225: aload_3
    //   226: invokespecial b : (Ljava/lang/String;)Z
    //   229: ifeq -> 272
    //   232: aload_0
    //   233: getfield a : Lcom/ta/utdid2/device/d;
    //   236: aload_3
    //   237: invokevirtual c : (Ljava/lang/String;)Ljava/lang/String;
    //   240: astore #4
    //   242: iload_1
    //   243: ifeq -> 252
    //   246: aload_0
    //   247: aload #4
    //   249: invokespecial j : (Ljava/lang/String;)V
    //   252: aload_0
    //   253: aload_3
    //   254: invokespecial h : (Ljava/lang/String;)V
    //   257: aload_0
    //   258: aload #4
    //   260: invokespecial g : (Ljava/lang/String;)V
    //   263: aload_0
    //   264: aload_3
    //   265: putfield h : Ljava/lang/String;
    //   268: aload_0
    //   269: monitorexit
    //   270: aload_3
    //   271: areturn
    //   272: aload_0
    //   273: getfield a : Lcom/ta/utdid2/b/a/c;
    //   276: aload_0
    //   277: getfield i : Ljava/lang/String;
    //   280: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   283: astore #6
    //   285: aload #6
    //   287: invokestatic a : (Ljava/lang/String;)Z
    //   290: ifne -> 381
    //   293: aload #5
    //   295: aload #6
    //   297: invokevirtual d : (Ljava/lang/String;)Ljava/lang/String;
    //   300: astore #4
    //   302: aload #4
    //   304: astore_3
    //   305: aload_0
    //   306: aload #4
    //   308: invokespecial b : (Ljava/lang/String;)Z
    //   311: ifne -> 324
    //   314: aload_0
    //   315: getfield a : Lcom/ta/utdid2/device/d;
    //   318: aload #6
    //   320: invokevirtual d : (Ljava/lang/String;)Ljava/lang/String;
    //   323: astore_3
    //   324: aload_0
    //   325: aload_3
    //   326: invokespecial b : (Ljava/lang/String;)Z
    //   329: ifeq -> 381
    //   332: aload_0
    //   333: getfield a : Lcom/ta/utdid2/device/d;
    //   336: aload_3
    //   337: invokevirtual c : (Ljava/lang/String;)Ljava/lang/String;
    //   340: astore #4
    //   342: aload_3
    //   343: invokestatic a : (Ljava/lang/String;)Z
    //   346: ifne -> 381
    //   349: aload_0
    //   350: aload_3
    //   351: putfield h : Ljava/lang/String;
    //   354: iload_1
    //   355: ifeq -> 364
    //   358: aload_0
    //   359: aload #4
    //   361: invokespecial j : (Ljava/lang/String;)V
    //   364: aload_0
    //   365: aload_0
    //   366: getfield h : Ljava/lang/String;
    //   369: invokespecial f : (Ljava/lang/String;)V
    //   372: aload_0
    //   373: getfield h : Ljava/lang/String;
    //   376: astore_3
    //   377: aload_0
    //   378: monitorexit
    //   379: aload_3
    //   380: areturn
    //   381: aload_0
    //   382: monitorexit
    //   383: aconst_null
    //   384: areturn
    //   385: astore_3
    //   386: aload_0
    //   387: monitorexit
    //   388: aload_3
    //   389: athrow
    //   390: astore #4
    //   392: goto -> 24
    //   395: astore_3
    //   396: goto -> 66
    //   399: astore #4
    //   401: aload_3
    //   402: astore #4
    //   404: goto -> 166
    // Exception table:
    //   from	to	target	type
    //   6	21	390	java/lang/Exception
    //   6	21	385	finally
    //   24	30	385	finally
    //   38	47	385	finally
    //   49	63	395	java/lang/Exception
    //   49	63	385	finally
    //   68	98	385	finally
    //   103	111	385	finally
    //   114	134	385	finally
    //   137	151	385	finally
    //   151	166	399	java/lang/Exception
    //   151	166	385	finally
    //   166	176	385	finally
    //   176	213	385	finally
    //   219	242	385	finally
    //   246	252	385	finally
    //   252	268	385	finally
    //   272	302	385	finally
    //   305	324	385	finally
    //   324	354	385	finally
    //   358	364	385	finally
    //   364	377	385	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\t\\utdid2\device\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */