package com.bytedance.tea.crash.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.tea.crash.e;
import com.bytedance.tea.crash.g.f;
import com.bytedance.tea.crash.h;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class c {
  static volatile boolean a = true;
  
  private a b;
  
  private d c;
  
  private final Context d;
  
  private volatile long e;
  
  private volatile boolean f = false;
  
  private final SharedPreferences g;
  
  public c(Context paramContext) {
    if (paramContext != null && paramContext instanceof android.app.Application) {
      this.d = paramContext;
      this.g = this.d.getSharedPreferences("anr_monitor_table", 0);
      this.e = this.g.getLong("trace_anr_happen_time", 0L);
      g.a(100, 100);
      return;
    } 
    throw new IllegalArgumentException("context must not be null or not application");
  }
  
  private String a(BufferedReader paramBufferedReader) throws IOException {
    if (paramBufferedReader == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    while (true) {
      String str = paramBufferedReader.readLine();
      if (str != null && str.trim().length() > 0) {
        stringBuilder.append(str);
        stringBuilder.append("\n");
        continue;
      } 
      break;
    } 
    return stringBuilder.toString();
  }
  
  private static void a(String paramString) {
    Iterator<e> iterator = h.b().c().iterator();
    while (iterator.hasNext())
      ((e)iterator.next()).a(com.bytedance.tea.crash.c.d, paramString, null); 
  }
  
  private Object[] a(BufferedReader paramBufferedReader, Pattern... paramVarArgs) throws IOException {
    if (paramBufferedReader != null && paramVarArgs != null) {
      if (paramVarArgs.length <= 0)
        return null; 
      try {
        return null;
      } finally {
        paramBufferedReader = null;
      } 
    } 
    return null;
  }
  
  public JSONObject a(String paramString1, int paramInt, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      return null; 
    File file = new File(paramString1);
    if (file.exists()) {
      if (!file.canRead())
        return null; 
      try {
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
        BufferedReader bufferedReader1 = bufferedReader2;
      } catch (Exception exception) {
      
      } finally {
        file = null;
      } 
    } else {
      return null;
    } 
    String str = paramString2;
    exception.printStackTrace();
    f.a((Closeable)paramString2);
    return null;
  }
  
  public void a() {
    if (this.f)
      return; 
    if (Build.VERSION.SDK_INT < 21) {
      this.b = new a(this, "/data/anr/", 8);
      this.b.startWatching();
    } else {
      this.c = new d(this);
    } 
    this.f = true;
  }
  
  boolean a(int paramInt1, String paramString, int paramInt2) {
    // Byte code:
    //   0: invokestatic b : ()Lorg/json/JSONArray;
    //   3: astore #7
    //   5: invokestatic uptimeMillis : ()J
    //   8: lstore #4
    //   10: lload #4
    //   12: invokestatic a : (J)Lorg/json/JSONObject;
    //   15: astore #8
    //   17: bipush #100
    //   19: lload #4
    //   21: invokestatic a : (IJ)Lorg/json/JSONArray;
    //   24: astore #9
    //   26: getstatic com/bytedance/tea/crash/a/c.a : Z
    //   29: invokestatic a : (Z)Lorg/json/JSONObject;
    //   32: astore #6
    //   34: goto -> 47
    //   37: astore #6
    //   39: aload #6
    //   41: invokevirtual printStackTrace : ()V
    //   44: aconst_null
    //   45: astore #6
    //   47: aload_0
    //   48: getfield d : Landroid/content/Context;
    //   51: iload_3
    //   52: invokestatic a : (Landroid/content/Context;I)Ljava/lang/String;
    //   55: astore #10
    //   57: aload #10
    //   59: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   62: ifeq -> 67
    //   65: iconst_0
    //   66: ireturn
    //   67: iload_1
    //   68: sipush #200
    //   71: if_icmpne -> 104
    //   74: aload_0
    //   75: aload_2
    //   76: invokestatic myPid : ()I
    //   79: aload_0
    //   80: getfield d : Landroid/content/Context;
    //   83: invokevirtual getPackageName : ()Ljava/lang/String;
    //   86: invokevirtual a : (Ljava/lang/String;ILjava/lang/String;)Lorg/json/JSONObject;
    //   89: astore_2
    //   90: aload_2
    //   91: ifnull -> 104
    //   94: aload_2
    //   95: invokevirtual length : ()I
    //   98: ifle -> 104
    //   101: goto -> 107
    //   104: aload #6
    //   106: astore_2
    //   107: aload_2
    //   108: ifnull -> 346
    //   111: aload_2
    //   112: invokevirtual length : ()I
    //   115: ifle -> 346
    //   118: aload_2
    //   119: ldc_w 'pid'
    //   122: invokestatic myPid : ()I
    //   125: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   128: pop
    //   129: aload_2
    //   130: ldc_w 'package'
    //   133: aload_0
    //   134: getfield d : Landroid/content/Context;
    //   137: invokevirtual getPackageName : ()Ljava/lang/String;
    //   140: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload_2
    //   145: ldc_w 'is_remote_process'
    //   148: iconst_0
    //   149: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   152: pop
    //   153: new com/bytedance/tea/crash/c/a
    //   156: dup
    //   157: new org/json/JSONObject
    //   160: dup
    //   161: invokespecial <init> : ()V
    //   164: invokespecial <init> : (Lorg/json/JSONObject;)V
    //   167: astore #6
    //   169: aload #6
    //   171: ldc_w 'data'
    //   174: aload_2
    //   175: invokevirtual toString : ()Ljava/lang/String;
    //   178: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   181: aload #6
    //   183: ldc_w 'is_anr'
    //   186: iconst_1
    //   187: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   190: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   193: aload #6
    //   195: ldc_w 'timestamp'
    //   198: invokestatic currentTimeMillis : ()J
    //   201: invokestatic valueOf : (J)Ljava/lang/Long;
    //   204: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   207: aload #6
    //   209: ldc_w 'event_type'
    //   212: ldc_w 'anr'
    //   215: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   218: aload #6
    //   220: ldc_w 'history_message'
    //   223: aload #7
    //   225: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   228: aload #6
    //   230: ldc_w 'current_message'
    //   233: aload #8
    //   235: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   238: aload #6
    //   240: ldc_w 'pending_messages'
    //   243: aload #9
    //   245: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   248: aload #6
    //   250: ldc_w 'anr_time'
    //   253: invokestatic currentTimeMillis : ()J
    //   256: invokestatic valueOf : (J)Ljava/lang/Long;
    //   259: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   262: aload #6
    //   264: ldc_w 'crash_time'
    //   267: invokestatic currentTimeMillis : ()J
    //   270: invokestatic valueOf : (J)Ljava/lang/Long;
    //   273: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   276: aload #6
    //   278: ldc_w 'anr_info'
    //   281: aload #10
    //   283: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   286: aload #6
    //   288: ldc_w 'all_thread_stacks'
    //   291: aconst_null
    //   292: invokestatic a : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   295: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   298: invokestatic a : ()Lcom/bytedance/tea/crash/e/a/e;
    //   301: getstatic com/bytedance/tea/crash/c.d : Lcom/bytedance/tea/crash/c;
    //   304: aload #6
    //   306: invokevirtual a : (Lcom/bytedance/tea/crash/c;Lcom/bytedance/tea/crash/c/a;)Lcom/bytedance/tea/crash/c/a;
    //   309: astore_2
    //   310: aload_0
    //   311: getfield d : Landroid/content/Context;
    //   314: getstatic com/bytedance/tea/crash/c.d : Lcom/bytedance/tea/crash/c;
    //   317: invokevirtual a : ()Ljava/lang/String;
    //   320: aconst_null
    //   321: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   324: invokestatic a : ()Lcom/bytedance/tea/crash/upload/a;
    //   327: aload_2
    //   328: invokevirtual a : ()Lorg/json/JSONObject;
    //   331: invokevirtual b : (Lorg/json/JSONObject;)V
    //   334: aload #10
    //   336: invokestatic a : (Ljava/lang/String;)V
    //   339: iconst_1
    //   340: ireturn
    //   341: astore_2
    //   342: aload_2
    //   343: invokestatic b : (Ljava/lang/Throwable;)V
    //   346: iconst_1
    //   347: ireturn
    // Exception table:
    //   from	to	target	type
    //   26	34	37	org/json/JSONException
    //   118	339	341	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */