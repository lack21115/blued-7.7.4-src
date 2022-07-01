package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.info.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class z {
  private static Map<String, String> a;
  
  private static boolean b = false;
  
  public static Context a(Context paramContext) {
    if (paramContext == null)
      return paramContext; 
    Context context = paramContext.getApplicationContext();
    return (context == null) ? paramContext : context;
  }
  
  public static SharedPreferences a(String paramString, Context paramContext) {
    return (paramContext != null) ? paramContext.getSharedPreferences(paramString, 0) : null;
  }
  
  private static BufferedReader a(File paramFile) {
    if (paramFile != null && paramFile.exists()) {
      if (!paramFile.canRead())
        return null; 
      try {
        return new BufferedReader(new InputStreamReader(new FileInputStream(paramFile), "utf-8"));
      } finally {
        paramFile = null;
      } 
    } 
    return null;
  }
  
  public static BufferedReader a(String paramString1, String paramString2) {
    if (paramString1 == null)
      return null; 
    try {
      File file = new File(paramString1, paramString2);
      return file.exists() ? (!file.canRead() ? null : a(file)) : null;
    } catch (NullPointerException nullPointerException) {
      x.a(nullPointerException);
      return null;
    } 
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
    try {
      Method method = Class.forName(paramString1).getDeclaredMethod(paramString2, paramArrayOfClass);
      method.setAccessible(true);
      return method.invoke((Object)null, paramArrayOfObject);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static <T> T a(byte[] paramArrayOfbyte, Parcelable.Creator<T> paramCreator) {
    Parcel parcel = Parcel.obtain();
    parcel.unmarshall(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    parcel.setDataPosition(0);
    try {
      return (T)paramCreator.createFromParcel(parcel);
    } finally {
      paramArrayOfbyte = null;
    } 
  }
  
  public static String a() {
    return a(System.currentTimeMillis());
  }
  
  public static String a(long paramLong) {
    try {
      return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)).format(new Date(paramLong));
    } catch (Exception exception) {
      return (new Date()).toString();
    } 
  }
  
  public static String a(Context paramContext, int paramInt, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'android.permission.READ_LOGS'
    //   3: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   6: istore_3
    //   7: aconst_null
    //   8: astore_0
    //   9: iload_3
    //   10: ifne -> 25
    //   13: ldc 'no read_log permission!'
    //   15: iconst_0
    //   16: anewarray java/lang/Object
    //   19: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   22: pop
    //   23: aconst_null
    //   24: areturn
    //   25: aload_2
    //   26: ifnonnull -> 57
    //   29: iconst_4
    //   30: anewarray java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc 'logcat'
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc '-d'
    //   42: aastore
    //   43: dup
    //   44: iconst_2
    //   45: ldc '-v'
    //   47: aastore
    //   48: dup
    //   49: iconst_3
    //   50: ldc 'threadtime'
    //   52: aastore
    //   53: astore_2
    //   54: goto -> 92
    //   57: bipush #6
    //   59: anewarray java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: ldc 'logcat'
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: ldc '-d'
    //   71: aastore
    //   72: dup
    //   73: iconst_2
    //   74: ldc '-v'
    //   76: aastore
    //   77: dup
    //   78: iconst_3
    //   79: ldc 'threadtime'
    //   81: aastore
    //   82: dup
    //   83: iconst_4
    //   84: ldc '-s'
    //   86: aastore
    //   87: dup
    //   88: iconst_5
    //   89: aload_2
    //   90: aastore
    //   91: astore_2
    //   92: new java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial <init> : ()V
    //   99: astore #4
    //   101: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   104: aload_2
    //   105: invokevirtual exec : ([Ljava/lang/String;)Ljava/lang/Process;
    //   108: astore_2
    //   109: aload_2
    //   110: astore_0
    //   111: new java/io/BufferedReader
    //   114: dup
    //   115: new java/io/InputStreamReader
    //   118: dup
    //   119: aload_2
    //   120: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   123: invokespecial <init> : (Ljava/io/InputStream;)V
    //   126: invokespecial <init> : (Ljava/io/Reader;)V
    //   129: astore #5
    //   131: aload_2
    //   132: astore_0
    //   133: aload #5
    //   135: invokevirtual readLine : ()Ljava/lang/String;
    //   138: astore #6
    //   140: aload #6
    //   142: ifnull -> 199
    //   145: aload_2
    //   146: astore_0
    //   147: aload #4
    //   149: aload #6
    //   151: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_2
    //   156: astore_0
    //   157: aload #4
    //   159: ldc '\\n'
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: iload_1
    //   166: ifle -> 131
    //   169: aload_2
    //   170: astore_0
    //   171: aload #4
    //   173: invokevirtual length : ()I
    //   176: iload_1
    //   177: if_icmple -> 131
    //   180: aload_2
    //   181: astore_0
    //   182: aload #4
    //   184: iconst_0
    //   185: aload #4
    //   187: invokevirtual length : ()I
    //   190: iload_1
    //   191: isub
    //   192: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: goto -> 131
    //   199: aload_2
    //   200: astore_0
    //   201: aload #4
    //   203: invokevirtual toString : ()Ljava/lang/String;
    //   206: astore #5
    //   208: aload_2
    //   209: ifnull -> 257
    //   212: aload_2
    //   213: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   216: invokevirtual close : ()V
    //   219: goto -> 227
    //   222: astore_0
    //   223: aload_0
    //   224: invokevirtual printStackTrace : ()V
    //   227: aload_2
    //   228: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   231: invokevirtual close : ()V
    //   234: goto -> 242
    //   237: astore_0
    //   238: aload_0
    //   239: invokevirtual printStackTrace : ()V
    //   242: aload_2
    //   243: invokevirtual getErrorStream : ()Ljava/io/InputStream;
    //   246: invokevirtual close : ()V
    //   249: aload #5
    //   251: areturn
    //   252: astore_0
    //   253: aload_0
    //   254: invokevirtual printStackTrace : ()V
    //   257: aload #5
    //   259: areturn
    //   260: astore_2
    //   261: aload_2
    //   262: invokestatic a : (Ljava/lang/Throwable;)Z
    //   265: ifne -> 272
    //   268: aload_2
    //   269: invokevirtual printStackTrace : ()V
    //   272: new java/lang/StringBuilder
    //   275: dup
    //   276: ldc '\\n[error:'
    //   278: invokespecial <init> : (Ljava/lang/String;)V
    //   281: astore #5
    //   283: aload #5
    //   285: aload_2
    //   286: invokevirtual toString : ()Ljava/lang/String;
    //   289: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload #5
    //   295: ldc ']'
    //   297: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload #4
    //   303: aload #5
    //   305: invokevirtual toString : ()Ljava/lang/String;
    //   308: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload #4
    //   314: invokevirtual toString : ()Ljava/lang/String;
    //   317: astore_2
    //   318: aload_0
    //   319: ifnull -> 370
    //   322: aload_0
    //   323: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   326: invokevirtual close : ()V
    //   329: goto -> 339
    //   332: astore #4
    //   334: aload #4
    //   336: invokevirtual printStackTrace : ()V
    //   339: aload_0
    //   340: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   343: invokevirtual close : ()V
    //   346: goto -> 356
    //   349: astore #4
    //   351: aload #4
    //   353: invokevirtual printStackTrace : ()V
    //   356: aload_0
    //   357: invokevirtual getErrorStream : ()Ljava/io/InputStream;
    //   360: invokevirtual close : ()V
    //   363: aload_2
    //   364: areturn
    //   365: astore_0
    //   366: aload_0
    //   367: invokevirtual printStackTrace : ()V
    //   370: aload_2
    //   371: areturn
    //   372: astore_2
    //   373: aload_0
    //   374: ifnull -> 426
    //   377: aload_0
    //   378: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   381: invokevirtual close : ()V
    //   384: goto -> 394
    //   387: astore #4
    //   389: aload #4
    //   391: invokevirtual printStackTrace : ()V
    //   394: aload_0
    //   395: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   398: invokevirtual close : ()V
    //   401: goto -> 411
    //   404: astore #4
    //   406: aload #4
    //   408: invokevirtual printStackTrace : ()V
    //   411: aload_0
    //   412: invokevirtual getErrorStream : ()Ljava/io/InputStream;
    //   415: invokevirtual close : ()V
    //   418: goto -> 426
    //   421: astore_0
    //   422: aload_0
    //   423: invokevirtual printStackTrace : ()V
    //   426: aload_2
    //   427: athrow
    // Exception table:
    //   from	to	target	type
    //   101	109	260	finally
    //   111	131	260	finally
    //   133	140	260	finally
    //   147	155	260	finally
    //   157	165	260	finally
    //   171	180	260	finally
    //   182	196	260	finally
    //   201	208	260	finally
    //   212	219	222	java/io/IOException
    //   227	234	237	java/io/IOException
    //   242	249	252	java/io/IOException
    //   261	272	372	finally
    //   272	318	372	finally
    //   322	329	332	java/io/IOException
    //   339	346	349	java/io/IOException
    //   356	363	365	java/io/IOException
    //   377	384	387	java/io/IOException
    //   394	401	404	java/io/IOException
    //   411	418	421	java/io/IOException
  }
  
  public static String a(Context paramContext, String paramString) {
    if (paramString != null) {
      if (paramString.trim().equals(""))
        return ""; 
      if (a == null) {
        a = new HashMap<String, String>();
        ArrayList<String> arrayList = c(paramContext, "getprop");
        if (arrayList != null && arrayList.size() > 0) {
          x.b(z.class, "Successfully get 'getprop' list.", new Object[0]);
          Pattern pattern = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
          Iterator<String> iterator = arrayList.iterator();
          while (iterator.hasNext()) {
            Matcher matcher = pattern.matcher(iterator.next());
            if (matcher.find())
              a.put(matcher.group(1), matcher.group(2)); 
          } 
          x.b(z.class, "System properties number: %d.", new Object[] { Integer.valueOf(a.size()) });
        } 
      } 
      return a.containsKey(paramString) ? a.get(paramString) : "fail";
    } 
    return "";
  }
  
  public static String a(File paramFile, int paramInt, boolean paramBoolean) {
    if (paramFile != null && paramFile.exists()) {
      if (!paramFile.canRead())
        return null; 
      try {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(paramFile), "utf-8"));
      } finally {
        null = null;
      } 
      try {
        x.a(null);
        return null;
      } finally {
        if (exception != null)
          try {
            exception.close();
          } catch (Exception exception1) {
            x.a(exception1);
          }  
      } 
    } 
    return null;
  }
  
  public static String a(Throwable paramThrowable) {
    if (paramThrowable == null)
      return ""; 
    try {
      return stringWriter.getBuffer().toString();
    } finally {
      paramThrowable = null;
      if (!x.a(paramThrowable))
        paramThrowable.printStackTrace(); 
    } 
  }
  
  public static String a(Date paramDate) {
    if (paramDate == null)
      return null; 
    try {
      return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)).format(paramDate);
    } catch (Exception exception) {
      return (new Date()).toString();
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      String str = Integer.toHexString(paramArrayOfbyte[i] & 0xFF);
      if (str.length() == 1)
        stringBuffer.append("0"); 
      stringBuffer.append(str);
    } 
    return stringBuffer.toString().toUpperCase();
  }
  
  public static Thread a(Runnable paramRunnable, String paramString) {
    try {
      paramRunnable = new Thread(paramRunnable);
      return (Thread)paramRunnable;
    } finally {
      paramRunnable = null;
      x.e("[Util] Failed to start a thread to execute task with message: %s", new Object[] { paramRunnable.getMessage() });
    } 
  }
  
  public static Map<String, String> a(int paramInt, boolean paramBoolean) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(12);
    Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
    if (map == null)
      return null; 
    Thread thread = Looper.getMainLooper().getThread();
    if (!map.containsKey(thread))
      map.put(thread, thread.getStackTrace()); 
    Thread.currentThread().getId();
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<Thread, StackTraceElement> entry : map.entrySet()) {
      int i = 0;
      stringBuilder.setLength(0);
      if (entry.getValue() != null && ((StackTraceElement[])entry.getValue()).length != 0) {
        StackTraceElement[] arrayOfStackTraceElement = (StackTraceElement[])entry.getValue();
        int j = arrayOfStackTraceElement.length;
        while (i < j) {
          StackTraceElement stackTraceElement = arrayOfStackTraceElement[i];
          if (paramInt > 0 && stringBuilder.length() >= paramInt) {
            StringBuilder stringBuilder2 = new StringBuilder("\n[Stack over limit size :");
            stringBuilder2.append(paramInt);
            stringBuilder2.append(" , has been cut!]");
            stringBuilder.append(stringBuilder2.toString());
            break;
          } 
          stringBuilder.append(stackTraceElement.toString());
          stringBuilder.append("\n");
          i++;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(((Thread)entry.getKey()).getName());
        stringBuilder1.append("(");
        stringBuilder1.append(((Thread)entry.getKey()).getId());
        stringBuilder1.append(")");
        hashMap.put(stringBuilder1.toString(), stringBuilder.toString());
      } 
    } 
    return (Map)hashMap;
  }
  
  public static Map<String, PlugInBean> a(Parcel paramParcel) {
    HashMap<Object, Object> hashMap;
    Bundle bundle = paramParcel.readBundle();
    paramParcel = null;
    if (bundle == null)
      return null; 
    ArrayList<String> arrayList = new ArrayList();
    ArrayList<PlugInBean> arrayList1 = new ArrayList();
    int j = ((Integer)bundle.get("pluginNum")).intValue();
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++) {
      StringBuilder stringBuilder = new StringBuilder("pluginKey");
      stringBuilder.append(i);
      arrayList.add(bundle.getString(stringBuilder.toString()));
    } 
    for (i = 0; i < j; i++) {
      StringBuilder stringBuilder1 = new StringBuilder("pluginVal");
      stringBuilder1.append(i);
      stringBuilder1.append("plugInId");
      String str1 = bundle.getString(stringBuilder1.toString());
      StringBuilder stringBuilder2 = new StringBuilder("pluginVal");
      stringBuilder2.append(i);
      stringBuilder2.append("plugInUUID");
      String str2 = bundle.getString(stringBuilder2.toString());
      StringBuilder stringBuilder3 = new StringBuilder("pluginVal");
      stringBuilder3.append(i);
      stringBuilder3.append("plugInVersion");
      arrayList1.add(new PlugInBean(str1, bundle.getString(stringBuilder3.toString()), str2));
    } 
    if (arrayList.size() == arrayList1.size()) {
      HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>(arrayList.size());
      i = bool;
      while (true) {
        hashMap = hashMap1;
        if (i < arrayList.size()) {
          hashMap1.put(arrayList.get(i), PlugInBean.class.cast(arrayList1.get(i)));
          i++;
          continue;
        } 
        break;
      } 
    } else {
      x.e("map plugin parcel error!", new Object[0]);
    } 
    return (Map)hashMap;
  }
  
  public static void a(Parcel paramParcel, Map<String, PlugInBean> paramMap) {
    int j;
    if (paramMap == null || paramMap.size() <= 0) {
      paramParcel.writeBundle(null);
      return;
    } 
    int i = paramMap.size();
    ArrayList<String> arrayList = new ArrayList(i);
    ArrayList arrayList1 = new ArrayList(i);
    for (Map.Entry<String, PlugInBean> entry : paramMap.entrySet()) {
      arrayList.add(entry.getKey());
      arrayList1.add(entry.getValue());
    } 
    Bundle bundle = new Bundle();
    bundle.putInt("pluginNum", arrayList.size());
    byte b = 0;
    i = 0;
    while (true) {
      j = b;
      if (i < arrayList.size()) {
        StringBuilder stringBuilder = new StringBuilder("pluginKey");
        stringBuilder.append(i);
        bundle.putString(stringBuilder.toString(), arrayList.get(i));
        i++;
        continue;
      } 
      break;
    } 
    while (j < arrayList.size()) {
      StringBuilder stringBuilder = new StringBuilder("pluginVal");
      stringBuilder.append(j);
      stringBuilder.append("plugInId");
      bundle.putString(stringBuilder.toString(), ((PlugInBean)arrayList1.get(j)).a);
      stringBuilder = new StringBuilder("pluginVal");
      stringBuilder.append(j);
      stringBuilder.append("plugInUUID");
      bundle.putString(stringBuilder.toString(), ((PlugInBean)arrayList1.get(j)).c);
      stringBuilder = new StringBuilder("pluginVal");
      stringBuilder.append(j);
      stringBuilder.append("plugInVersion");
      bundle.putString(stringBuilder.toString(), ((PlugInBean)arrayList1.get(j)).b);
      j++;
    } 
    paramParcel.writeBundle(bundle);
  }
  
  public static void a(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2) {
    try {
      Field field = paramClass.getDeclaredField(paramString);
      field.setAccessible(true);
      field.set((Object)null, paramObject1);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong) {
    x.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getFilesDir());
      stringBuilder.append(File.separator);
      stringBuilder.append(paramString);
      File file = new File(stringBuilder.toString());
      if (file.exists()) {
        if (System.currentTimeMillis() - file.lastModified() < paramLong)
          return false; 
        x.c("[Util] Lock file (%s) is expired, unlock it.", new Object[] { paramString });
        b(paramContext, paramString);
      } 
      return false;
    } finally {
      paramContext = null;
      x.a((Throwable)paramContext);
    } 
  }
  
  public static boolean a(File paramFile1, File paramFile2, int paramInt) {
    // Byte code:
    //   0: ldc_w 'rqdp{  ZF start}'
    //   3: iconst_0
    //   4: anewarray java/lang/Object
    //   7: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull -> 377
    //   15: aload_1
    //   16: ifnull -> 377
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual equals : (Ljava/lang/Object;)Z
    //   24: ifeq -> 30
    //   27: goto -> 377
    //   30: aload_0
    //   31: invokevirtual exists : ()Z
    //   34: ifeq -> 364
    //   37: aload_0
    //   38: invokevirtual canRead : ()Z
    //   41: ifne -> 47
    //   44: goto -> 364
    //   47: aload_1
    //   48: invokevirtual getParentFile : ()Ljava/io/File;
    //   51: ifnull -> 72
    //   54: aload_1
    //   55: invokevirtual getParentFile : ()Ljava/io/File;
    //   58: invokevirtual exists : ()Z
    //   61: ifne -> 72
    //   64: aload_1
    //   65: invokevirtual getParentFile : ()Ljava/io/File;
    //   68: invokevirtual mkdirs : ()Z
    //   71: pop
    //   72: aload_1
    //   73: invokevirtual exists : ()Z
    //   76: ifne -> 99
    //   79: aload_1
    //   80: invokevirtual createNewFile : ()Z
    //   83: pop
    //   84: goto -> 99
    //   87: astore_3
    //   88: aload_3
    //   89: invokestatic a : (Ljava/lang/Throwable;)Z
    //   92: ifne -> 99
    //   95: aload_3
    //   96: invokevirtual printStackTrace : ()V
    //   99: aload_1
    //   100: invokevirtual exists : ()Z
    //   103: ifeq -> 362
    //   106: aload_1
    //   107: invokevirtual canRead : ()Z
    //   110: ifne -> 115
    //   113: iconst_0
    //   114: ireturn
    //   115: new java/io/FileInputStream
    //   118: dup
    //   119: aload_0
    //   120: invokespecial <init> : (Ljava/io/File;)V
    //   123: astore_3
    //   124: new java/util/zip/ZipOutputStream
    //   127: dup
    //   128: new java/io/BufferedOutputStream
    //   131: dup
    //   132: new java/io/FileOutputStream
    //   135: dup
    //   136: aload_1
    //   137: invokespecial <init> : (Ljava/io/File;)V
    //   140: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   143: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   146: astore_1
    //   147: aload_1
    //   148: bipush #8
    //   150: invokevirtual setMethod : (I)V
    //   153: aload_1
    //   154: new java/util/zip/ZipEntry
    //   157: dup
    //   158: aload_0
    //   159: invokevirtual getName : ()Ljava/lang/String;
    //   162: invokespecial <init> : (Ljava/lang/String;)V
    //   165: invokevirtual putNextEntry : (Ljava/util/zip/ZipEntry;)V
    //   168: sipush #5000
    //   171: newarray byte
    //   173: astore_0
    //   174: aload_3
    //   175: aload_0
    //   176: invokevirtual read : ([B)I
    //   179: istore_2
    //   180: iload_2
    //   181: ifle -> 194
    //   184: aload_1
    //   185: aload_0
    //   186: iconst_0
    //   187: iload_2
    //   188: invokevirtual write : ([BII)V
    //   191: goto -> 174
    //   194: aload_1
    //   195: invokevirtual flush : ()V
    //   198: aload_1
    //   199: invokevirtual closeEntry : ()V
    //   202: aload_3
    //   203: invokevirtual close : ()V
    //   206: goto -> 214
    //   209: astore_0
    //   210: aload_0
    //   211: invokevirtual printStackTrace : ()V
    //   214: aload_1
    //   215: invokevirtual close : ()V
    //   218: goto -> 226
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual printStackTrace : ()V
    //   226: ldc_w 'rqdp{  ZF end}'
    //   229: iconst_0
    //   230: anewarray java/lang/Object
    //   233: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   236: pop
    //   237: iconst_1
    //   238: ireturn
    //   239: astore #4
    //   241: aload_1
    //   242: astore_0
    //   243: aload #4
    //   245: astore_1
    //   246: goto -> 260
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_0
    //   252: goto -> 260
    //   255: astore_1
    //   256: aconst_null
    //   257: astore_3
    //   258: aload_3
    //   259: astore_0
    //   260: aload_1
    //   261: invokestatic a : (Ljava/lang/Throwable;)Z
    //   264: ifne -> 271
    //   267: aload_1
    //   268: invokevirtual printStackTrace : ()V
    //   271: aload_3
    //   272: ifnull -> 287
    //   275: aload_3
    //   276: invokevirtual close : ()V
    //   279: goto -> 287
    //   282: astore_1
    //   283: aload_1
    //   284: invokevirtual printStackTrace : ()V
    //   287: aload_0
    //   288: ifnull -> 303
    //   291: aload_0
    //   292: invokevirtual close : ()V
    //   295: goto -> 303
    //   298: astore_0
    //   299: aload_0
    //   300: invokevirtual printStackTrace : ()V
    //   303: ldc_w 'rqdp{  ZF end}'
    //   306: iconst_0
    //   307: anewarray java/lang/Object
    //   310: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   313: pop
    //   314: iconst_0
    //   315: ireturn
    //   316: astore_1
    //   317: aload_3
    //   318: ifnull -> 333
    //   321: aload_3
    //   322: invokevirtual close : ()V
    //   325: goto -> 333
    //   328: astore_3
    //   329: aload_3
    //   330: invokevirtual printStackTrace : ()V
    //   333: aload_0
    //   334: ifnull -> 349
    //   337: aload_0
    //   338: invokevirtual close : ()V
    //   341: goto -> 349
    //   344: astore_0
    //   345: aload_0
    //   346: invokevirtual printStackTrace : ()V
    //   349: ldc_w 'rqdp{  ZF end}'
    //   352: iconst_0
    //   353: anewarray java/lang/Object
    //   356: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   359: pop
    //   360: aload_1
    //   361: athrow
    //   362: iconst_0
    //   363: ireturn
    //   364: ldc_w 'rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}'
    //   367: iconst_0
    //   368: anewarray java/lang/Object
    //   371: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   374: pop
    //   375: iconst_0
    //   376: ireturn
    //   377: ldc_w 'rqdp{  err ZF 1R!}'
    //   380: iconst_0
    //   381: anewarray java/lang/Object
    //   384: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   387: pop
    //   388: iconst_0
    //   389: ireturn
    // Exception table:
    //   from	to	target	type
    //   47	72	87	finally
    //   72	84	87	finally
    //   115	124	255	finally
    //   124	147	249	finally
    //   147	174	239	finally
    //   174	180	239	finally
    //   184	191	239	finally
    //   194	202	239	finally
    //   202	206	209	java/io/IOException
    //   214	218	221	java/io/IOException
    //   260	271	316	finally
    //   275	279	282	java/io/IOException
    //   291	295	298	java/io/IOException
    //   321	325	328	java/io/IOException
    //   337	341	344	java/io/IOException
  }
  
  public static boolean a(Runnable paramRunnable) {
    if (paramRunnable != null) {
      w w = w.a();
      if (w != null)
        return w.a(paramRunnable); 
      String[] arrayOfString = paramRunnable.getClass().getName().split("\\.");
      if (a(paramRunnable, arrayOfString[arrayOfString.length - 1]) != null)
        return true; 
    } 
    return false;
  }
  
  public static boolean a(String paramString) {
    return !(paramString != null && paramString.trim().length() > 0);
  }
  
  public static byte[] a(int paramInt) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/z
    //   2: monitorenter
    //   3: bipush #16
    //   5: newarray byte
    //   7: astore_3
    //   8: new java/io/DataInputStream
    //   11: dup
    //   12: new java/io/FileInputStream
    //   15: dup
    //   16: new java/io/File
    //   19: dup
    //   20: ldc_w '/dev/urandom'
    //   23: invokespecial <init> : (Ljava/lang/String;)V
    //   26: invokespecial <init> : (Ljava/io/File;)V
    //   29: invokespecial <init> : (Ljava/io/InputStream;)V
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: aload_3
    //   37: invokevirtual readFully : ([B)V
    //   40: aload_2
    //   41: invokevirtual close : ()V
    //   44: ldc com/tencent/bugly/proguard/z
    //   46: monitorexit
    //   47: aload_3
    //   48: areturn
    //   49: astore_3
    //   50: goto -> 62
    //   53: astore_1
    //   54: aconst_null
    //   55: astore_2
    //   56: goto -> 128
    //   59: astore_3
    //   60: aconst_null
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: ldc_w 'Failed to read from /dev/urandom : %s'
    //   67: iconst_1
    //   68: anewarray java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_3
    //   74: aastore
    //   75: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   78: pop
    //   79: aload_2
    //   80: ifnull -> 87
    //   83: aload_2
    //   84: invokevirtual close : ()V
    //   87: ldc_w 'AES'
    //   90: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/KeyGenerator;
    //   93: astore_1
    //   94: aload_1
    //   95: sipush #128
    //   98: new java/security/SecureRandom
    //   101: dup
    //   102: invokespecial <init> : ()V
    //   105: invokevirtual init : (ILjava/security/SecureRandom;)V
    //   108: aload_1
    //   109: invokevirtual generateKey : ()Ljavax/crypto/SecretKey;
    //   112: invokeinterface getEncoded : ()[B
    //   117: astore_1
    //   118: ldc com/tencent/bugly/proguard/z
    //   120: monitorexit
    //   121: aload_1
    //   122: areturn
    //   123: astore_3
    //   124: aload_1
    //   125: astore_2
    //   126: aload_3
    //   127: astore_1
    //   128: aload_2
    //   129: ifnull -> 136
    //   132: aload_2
    //   133: invokevirtual close : ()V
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: goto -> 159
    //   142: astore_1
    //   143: aload_1
    //   144: invokestatic b : (Ljava/lang/Throwable;)Z
    //   147: ifne -> 154
    //   150: aload_1
    //   151: invokevirtual printStackTrace : ()V
    //   154: ldc com/tencent/bugly/proguard/z
    //   156: monitorexit
    //   157: aconst_null
    //   158: areturn
    //   159: ldc com/tencent/bugly/proguard/z
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Exception table:
    //   from	to	target	type
    //   3	33	59	java/lang/Exception
    //   3	33	53	finally
    //   35	40	49	java/lang/Exception
    //   35	40	123	finally
    //   40	44	142	java/lang/Exception
    //   40	44	138	finally
    //   64	79	123	finally
    //   83	87	142	java/lang/Exception
    //   83	87	138	finally
    //   87	118	142	java/lang/Exception
    //   87	118	138	finally
    //   132	136	142	java/lang/Exception
    //   132	136	138	finally
    //   136	138	142	java/lang/Exception
    //   136	138	138	finally
    //   143	154	138	finally
  }
  
  public static byte[] a(int paramInt, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte2, "AES");
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      if (Build.VERSION.SDK_INT < 21 || b) {
        cipher.init(paramInt, secretKeySpec, new IvParameterSpec(paramArrayOfbyte2));
        return cipher.doFinal(paramArrayOfbyte1);
      } 
      GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(cipher.getBlockSize() << 3, paramArrayOfbyte2);
      try {
        cipher.init(paramInt, secretKeySpec, gCMParameterSpec);
      } catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
        b = true;
        throw invalidAlgorithmParameterException;
      } 
      return cipher.doFinal((byte[])invalidAlgorithmParameterException);
    } catch (Exception exception) {
      if (!x.b(exception))
        exception.printStackTrace(); 
      return null;
    } 
  }
  
  public static byte[] a(Parcelable paramParcelable) {
    Parcel parcel = Parcel.obtain();
    paramParcelable.writeToParcel(parcel, 0);
    byte[] arrayOfByte = parcel.marshall();
    parcel.recycle();
    return arrayOfByte;
  }
  
  public static byte[] a(File paramFile, String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 222
    //   4: aload_1
    //   5: invokevirtual length : ()I
    //   8: ifne -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: ldc_w 'rqdp{  ZF start}'
    //   16: iconst_0
    //   17: anewarray java/lang/Object
    //   20: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   23: pop
    //   24: new java/io/ByteArrayInputStream
    //   27: dup
    //   28: aload_1
    //   29: ldc_w 'UTF-8'
    //   32: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   35: invokespecial <init> : ([B)V
    //   38: astore_1
    //   39: new java/io/ByteArrayOutputStream
    //   42: dup
    //   43: invokespecial <init> : ()V
    //   46: astore #4
    //   48: new java/util/zip/ZipOutputStream
    //   51: dup
    //   52: aload #4
    //   54: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   57: astore_0
    //   58: aload_0
    //   59: bipush #8
    //   61: invokevirtual setMethod : (I)V
    //   64: aload_0
    //   65: new java/util/zip/ZipEntry
    //   68: dup
    //   69: aload_2
    //   70: invokespecial <init> : (Ljava/lang/String;)V
    //   73: invokevirtual putNextEntry : (Ljava/util/zip/ZipEntry;)V
    //   76: sipush #1024
    //   79: newarray byte
    //   81: astore_2
    //   82: aload_1
    //   83: aload_2
    //   84: invokevirtual read : ([B)I
    //   87: istore_3
    //   88: iload_3
    //   89: ifle -> 102
    //   92: aload_0
    //   93: aload_2
    //   94: iconst_0
    //   95: iload_3
    //   96: invokevirtual write : ([BII)V
    //   99: goto -> 82
    //   102: aload_0
    //   103: invokevirtual closeEntry : ()V
    //   106: aload_0
    //   107: invokevirtual flush : ()V
    //   110: aload_0
    //   111: invokevirtual finish : ()V
    //   114: aload #4
    //   116: invokevirtual toByteArray : ()[B
    //   119: astore_1
    //   120: aload_0
    //   121: invokevirtual close : ()V
    //   124: goto -> 132
    //   127: astore_0
    //   128: aload_0
    //   129: invokevirtual printStackTrace : ()V
    //   132: ldc_w 'rqdp{  ZF end}'
    //   135: iconst_0
    //   136: anewarray java/lang/Object
    //   139: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   142: pop
    //   143: aload_1
    //   144: areturn
    //   145: astore_1
    //   146: goto -> 152
    //   149: astore_1
    //   150: aconst_null
    //   151: astore_0
    //   152: aload_1
    //   153: invokestatic a : (Ljava/lang/Throwable;)Z
    //   156: ifne -> 163
    //   159: aload_1
    //   160: invokevirtual printStackTrace : ()V
    //   163: aload_0
    //   164: ifnull -> 179
    //   167: aload_0
    //   168: invokevirtual close : ()V
    //   171: goto -> 179
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual printStackTrace : ()V
    //   179: ldc_w 'rqdp{  ZF end}'
    //   182: iconst_0
    //   183: anewarray java/lang/Object
    //   186: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   189: pop
    //   190: aconst_null
    //   191: areturn
    //   192: astore_1
    //   193: aload_0
    //   194: ifnull -> 209
    //   197: aload_0
    //   198: invokevirtual close : ()V
    //   201: goto -> 209
    //   204: astore_0
    //   205: aload_0
    //   206: invokevirtual printStackTrace : ()V
    //   209: ldc_w 'rqdp{  ZF end}'
    //   212: iconst_0
    //   213: anewarray java/lang/Object
    //   216: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   219: pop
    //   220: aload_1
    //   221: athrow
    //   222: aconst_null
    //   223: areturn
    // Exception table:
    //   from	to	target	type
    //   24	58	149	finally
    //   58	82	145	finally
    //   82	88	145	finally
    //   92	99	145	finally
    //   102	120	145	finally
    //   120	124	127	java/io/IOException
    //   152	163	192	finally
    //   167	171	174	java/io/IOException
    //   197	201	204	java/io/IOException
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, int paramInt) {
    if (paramArrayOfbyte != null) {
      String str;
      if (paramInt == -1)
        return paramArrayOfbyte; 
      int i = paramArrayOfbyte.length;
      if (paramInt == 2) {
        str = "Gzip";
      } else {
        str = "zip";
      } 
      x.c("[Util] Zip %d bytes data with type %s", new Object[] { Integer.valueOf(i), str });
      try {
        return (ae == null) ? null : ae.a(paramArrayOfbyte);
      } finally {
        paramArrayOfbyte = null;
        if (!x.a((Throwable)paramArrayOfbyte))
          paramArrayOfbyte.printStackTrace(); 
      } 
    } 
    return paramArrayOfbyte;
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, String paramString) {
    if (paramArrayOfbyte == null)
      return null; 
    try {
      return a(a(paramArrayOfbyte, 2), 1, paramString);
    } finally {
      paramArrayOfbyte = null;
      if (!x.a((Throwable)paramArrayOfbyte))
        paramArrayOfbyte.printStackTrace(); 
    } 
  }
  
  private static byte[] a(byte[] paramArrayOfbyte, int paramInt, String paramString) {
    if (paramArrayOfbyte != null) {
      if (paramInt == -1)
        return paramArrayOfbyte; 
      x.c("rqdp{  enD:} %d %d", new Object[] { Integer.valueOf(paramArrayOfbyte.length), Integer.valueOf(paramInt) });
      try {
        aj aj = a.a(paramInt);
        return aj.b(paramArrayOfbyte);
      } finally {
        paramArrayOfbyte = null;
        if (!x.a((Throwable)paramArrayOfbyte))
          paramArrayOfbyte.printStackTrace(); 
      } 
    } 
    return paramArrayOfbyte;
  }
  
  public static long b() {
    try {
      return l * 86400000L - i;
    } finally {
      Exception exception = null;
      if (!x.a(exception))
        exception.printStackTrace(); 
    } 
  }
  
  public static String b(String paramString1, String paramString2) {
    return (a.b() != null && (a.b()).G != null) ? (a.b()).G.getString(paramString1, paramString2) : "";
  }
  
  public static String b(Throwable paramThrowable) {
    if (paramThrowable == null)
      return ""; 
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    paramThrowable.printStackTrace(printWriter);
    printWriter.flush();
    return stringWriter.toString();
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return "NULL"; 
    try {
      return a(messageDigest.digest());
    } finally {
      paramArrayOfbyte = null;
      if (!x.a((Throwable)paramArrayOfbyte))
        paramArrayOfbyte.printStackTrace(); 
    } 
  }
  
  public static Map<String, String> b(Parcel paramParcel) {
    HashMap<Object, Object> hashMap;
    Bundle bundle = paramParcel.readBundle();
    paramParcel = null;
    if (bundle == null)
      return null; 
    ArrayList arrayList1 = bundle.getStringArrayList("keys");
    ArrayList arrayList2 = bundle.getStringArrayList("values");
    int i = 0;
    if (arrayList1 != null && arrayList2 != null && arrayList1.size() == arrayList2.size()) {
      HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>(arrayList1.size());
      while (true) {
        hashMap = hashMap1;
        if (i < arrayList1.size()) {
          hashMap1.put(arrayList1.get(i), arrayList2.get(i));
          i++;
          continue;
        } 
        break;
      } 
    } else {
      x.e("map parcel error!", new Object[0]);
    } 
    return (Map)hashMap;
  }
  
  public static void b(long paramLong) {
    try {
      Thread.sleep(paramLong);
      return;
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
      return;
    } 
  }
  
  public static void b(Parcel paramParcel, Map<String, String> paramMap) {
    if (paramMap == null || paramMap.size() <= 0) {
      paramParcel.writeBundle(null);
      return;
    } 
    int i = paramMap.size();
    ArrayList arrayList1 = new ArrayList(i);
    ArrayList arrayList2 = new ArrayList(i);
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      arrayList1.add(entry.getKey());
      arrayList2.add(entry.getValue());
    } 
    Bundle bundle = new Bundle();
    bundle.putStringArrayList("keys", arrayList1);
    bundle.putStringArrayList("values", arrayList2);
    paramParcel.writeBundle(bundle);
  }
  
  public static void b(String paramString) {
    if (paramString == null)
      return; 
    File file = new File(paramString);
    if (file.isFile() && file.exists() && file.canWrite())
      file.delete(); 
  }
  
  public static boolean b(Context paramContext, String paramString) {
    x.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getFilesDir());
      stringBuilder.append(File.separator);
      stringBuilder.append(paramString);
      return true;
    } finally {
      paramContext = null;
      x.a((Throwable)paramContext);
    } 
  }
  
  public static byte[] b(int paramInt, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramArrayOfbyte2));
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(1, publicKey);
      return cipher.doFinal(paramArrayOfbyte1);
    } catch (Exception exception) {
      if (!x.b(exception))
        exception.printStackTrace(); 
      return null;
    } 
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, int paramInt) {
    if (paramArrayOfbyte != null) {
      String str;
      if (paramInt == -1)
        return paramArrayOfbyte; 
      int i = paramArrayOfbyte.length;
      if (paramInt == 2) {
        str = "Gzip";
      } else {
        str = "zip";
      } 
      x.c("[Util] Unzip %d bytes data with type %s", new Object[] { Integer.valueOf(i), str });
      try {
        return (ae == null) ? null : ae.b(paramArrayOfbyte);
      } finally {
        paramArrayOfbyte = null;
        if (!x.a((Throwable)paramArrayOfbyte))
          paramArrayOfbyte.printStackTrace(); 
      } 
    } 
    return paramArrayOfbyte;
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, String paramString) {
    try {
      return b(b(paramArrayOfbyte, 1, paramString), 2);
    } catch (Exception exception) {
      if (!x.a(exception))
        exception.printStackTrace(); 
      return null;
    } 
  }
  
  private static byte[] b(byte[] paramArrayOfbyte, int paramInt, String paramString) {
    if (paramArrayOfbyte != null) {
      if (paramInt == -1)
        return paramArrayOfbyte; 
      try {
        return aj.a(paramArrayOfbyte);
      } finally {
        paramArrayOfbyte = null;
        if (!x.a((Throwable)paramArrayOfbyte))
          paramArrayOfbyte.printStackTrace(); 
        x.d("encrytype %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
      } 
    } 
    return paramArrayOfbyte;
  }
  
  public static long c(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return -1L; 
    try {
      return Long.parseLong(new String(paramArrayOfbyte, "utf-8"));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
      return -1L;
    } 
  }
  
  private static ArrayList<String> c(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic f : (Landroid/content/Context;)Z
    //   4: ifeq -> 28
    //   7: new java/util/ArrayList
    //   10: dup
    //   11: iconst_1
    //   12: anewarray java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: ldc_w 'unknown(low memory)'
    //   20: aastore
    //   21: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   24: invokespecial <init> : (Ljava/util/Collection;)V
    //   27: areturn
    //   28: new java/util/ArrayList
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore_3
    //   36: ldc_w '/system/bin/sh'
    //   39: astore_0
    //   40: new java/io/File
    //   43: dup
    //   44: ldc_w '/system/bin/sh'
    //   47: invokespecial <init> : (Ljava/lang/String;)V
    //   50: invokevirtual exists : ()Z
    //   53: ifeq -> 321
    //   56: new java/io/File
    //   59: dup
    //   60: ldc_w '/system/bin/sh'
    //   63: invokespecial <init> : (Ljava/lang/String;)V
    //   66: invokevirtual canExecute : ()Z
    //   69: ifne -> 75
    //   72: goto -> 321
    //   75: new java/util/ArrayList
    //   78: dup
    //   79: iconst_2
    //   80: anewarray java/lang/String
    //   83: dup
    //   84: iconst_0
    //   85: aload_0
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: ldc_w '-c'
    //   92: aastore
    //   93: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   96: invokespecial <init> : (Ljava/util/Collection;)V
    //   99: astore_0
    //   100: aload_0
    //   101: aload_1
    //   102: invokeinterface add : (Ljava/lang/Object;)Z
    //   107: pop
    //   108: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   111: aload_0
    //   112: iconst_3
    //   113: anewarray java/lang/String
    //   116: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   121: checkcast [Ljava/lang/String;
    //   124: invokevirtual exec : ([Ljava/lang/String;)Ljava/lang/Process;
    //   127: astore_0
    //   128: new java/io/BufferedReader
    //   131: dup
    //   132: new java/io/InputStreamReader
    //   135: dup
    //   136: aload_0
    //   137: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   140: invokespecial <init> : (Ljava/io/InputStream;)V
    //   143: invokespecial <init> : (Ljava/io/Reader;)V
    //   146: astore_2
    //   147: aload_2
    //   148: invokevirtual readLine : ()Ljava/lang/String;
    //   151: astore_1
    //   152: aload_1
    //   153: ifnull -> 165
    //   156: aload_3
    //   157: aload_1
    //   158: invokevirtual add : (Ljava/lang/Object;)Z
    //   161: pop
    //   162: goto -> 147
    //   165: new java/io/BufferedReader
    //   168: dup
    //   169: new java/io/InputStreamReader
    //   172: dup
    //   173: aload_0
    //   174: invokevirtual getErrorStream : ()Ljava/io/InputStream;
    //   177: invokespecial <init> : (Ljava/io/InputStream;)V
    //   180: invokespecial <init> : (Ljava/io/Reader;)V
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual readLine : ()Ljava/lang/String;
    //   188: astore_1
    //   189: aload_1
    //   190: ifnull -> 202
    //   193: aload_3
    //   194: aload_1
    //   195: invokevirtual add : (Ljava/lang/Object;)Z
    //   198: pop
    //   199: goto -> 184
    //   202: aload_2
    //   203: invokevirtual close : ()V
    //   206: goto -> 214
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual printStackTrace : ()V
    //   214: aload_0
    //   215: invokevirtual close : ()V
    //   218: aload_3
    //   219: areturn
    //   220: astore_0
    //   221: aload_0
    //   222: invokevirtual printStackTrace : ()V
    //   225: aload_3
    //   226: areturn
    //   227: astore_1
    //   228: goto -> 242
    //   231: astore_1
    //   232: aconst_null
    //   233: astore_0
    //   234: goto -> 242
    //   237: astore_1
    //   238: aconst_null
    //   239: astore_2
    //   240: aload_2
    //   241: astore_0
    //   242: aload_1
    //   243: invokestatic a : (Ljava/lang/Throwable;)Z
    //   246: ifne -> 253
    //   249: aload_1
    //   250: invokevirtual printStackTrace : ()V
    //   253: aload_2
    //   254: ifnull -> 269
    //   257: aload_2
    //   258: invokevirtual close : ()V
    //   261: goto -> 269
    //   264: astore_1
    //   265: aload_1
    //   266: invokevirtual printStackTrace : ()V
    //   269: aload_0
    //   270: ifnull -> 284
    //   273: aload_0
    //   274: invokevirtual close : ()V
    //   277: aconst_null
    //   278: areturn
    //   279: astore_0
    //   280: aload_0
    //   281: invokevirtual printStackTrace : ()V
    //   284: aconst_null
    //   285: areturn
    //   286: astore_1
    //   287: aload_2
    //   288: ifnull -> 303
    //   291: aload_2
    //   292: invokevirtual close : ()V
    //   295: goto -> 303
    //   298: astore_2
    //   299: aload_2
    //   300: invokevirtual printStackTrace : ()V
    //   303: aload_0
    //   304: ifnull -> 319
    //   307: aload_0
    //   308: invokevirtual close : ()V
    //   311: goto -> 319
    //   314: astore_0
    //   315: aload_0
    //   316: invokevirtual printStackTrace : ()V
    //   319: aload_1
    //   320: athrow
    //   321: ldc_w 'sh'
    //   324: astore_0
    //   325: goto -> 75
    // Exception table:
    //   from	to	target	type
    //   40	56	237	finally
    //   56	72	237	finally
    //   75	147	237	finally
    //   147	152	231	finally
    //   156	162	231	finally
    //   165	184	231	finally
    //   184	189	227	finally
    //   193	199	227	finally
    //   202	206	209	java/io/IOException
    //   214	218	220	java/io/IOException
    //   242	253	286	finally
    //   257	261	264	java/io/IOException
    //   273	277	279	java/io/IOException
    //   291	295	298	java/io/IOException
    //   307	311	314	java/io/IOException
  }
  
  public static boolean c(String paramString) {
    boolean bool;
    if (paramString != null && paramString.trim().length() > 0) {
      bool = false;
    } else {
      bool = true;
    } 
    if (bool)
      return false; 
    if (paramString.length() > 255) {
      x.a("URL(%s)'s length is larger than 255.", new Object[] { paramString });
      return false;
    } 
    if (!paramString.toLowerCase().startsWith("http")) {
      x.a("URL(%s) is not start with \"http\".", new Object[] { paramString });
      return false;
    } 
    return true;
  }
  
  public static byte[] c(long paramLong) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong);
      return stringBuilder.toString().getBytes("utf-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */