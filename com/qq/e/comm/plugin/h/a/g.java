package com.qq.e.comm.plugin.h.a;

import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.util.Md5Util;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class g {
  private static volatile JSONObject a;
  
  private static String a(a parama, String paramString, long paramLong) throws Exception {
    return Md5Util.encode(String.format("%s%d%d%s", new Object[] { paramString, Integer.valueOf(parama.a()), Long.valueOf(paramLong), parama.b() })).toUpperCase();
  }
  
  private static JSONObject a(a parama) throws Exception {
    JSONObject jSONObject = new JSONObject();
    String str = UUID.randomUUID().toString();
    long l = System.currentTimeMillis();
    jSONObject.put("v", a.a(parama));
    jSONObject.put("u", str);
    jSONObject.put("t", l);
    jSONObject.put("m", a(parama, str, l));
    return jSONObject;
  }
  
  public static JSONObject a(String paramString) {
    // Byte code:
    //   0: ldc com/qq/e/comm/plugin/h/a/g
    //   2: monitorenter
    //   3: getstatic com/qq/e/comm/plugin/h/a/g.a : Lorg/json/JSONObject;
    //   6: ifnull -> 16
    //   9: getstatic com/qq/e/comm/plugin/h/a/g.a : Lorg/json/JSONObject;
    //   12: astore_0
    //   13: goto -> 358
    //   16: new java/io/File
    //   19: dup
    //   20: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   23: ldc 'Tencent/ams/cache'
    //   25: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   28: astore #5
    //   30: new java/io/File
    //   33: dup
    //   34: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   37: ldc 'Android/data/com.tencent.ams/cache'
    //   39: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   42: astore #6
    //   44: aconst_null
    //   45: astore_2
    //   46: aconst_null
    //   47: astore_3
    //   48: iconst_0
    //   49: istore_1
    //   50: aload_0
    //   51: invokestatic b : (Ljava/lang/String;)Ljava/util/List;
    //   54: astore #4
    //   56: aload_3
    //   57: astore_0
    //   58: new java/io/File
    //   61: dup
    //   62: aload #5
    //   64: ldc 'meta.dat'
    //   66: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   69: invokestatic a : (Ljava/io/File;)[B
    //   72: astore_2
    //   73: aload_2
    //   74: astore_0
    //   75: aload_2
    //   76: aload #4
    //   78: invokestatic a : ([BLjava/util/List;)Lorg/json/JSONObject;
    //   81: putstatic com/qq/e/comm/plugin/h/a/g.a : Lorg/json/JSONObject;
    //   84: aload_2
    //   85: astore_0
    //   86: goto -> 96
    //   89: astore_2
    //   90: ldc 'uuid read main file failed.'
    //   92: aload_2
    //   93: invokestatic a : (Ljava/lang/String;Ljava/lang/Exception;)V
    //   96: getstatic com/qq/e/comm/plugin/h/a/g.a : Lorg/json/JSONObject;
    //   99: ifnull -> 116
    //   102: ldc 'read uuid from main'
    //   104: iconst_0
    //   105: anewarray java/lang/Object
    //   108: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: iconst_2
    //   112: istore_1
    //   113: goto -> 292
    //   116: new java/io/File
    //   119: dup
    //   120: aload #6
    //   122: ldc 'meta.dat'
    //   124: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   127: invokestatic a : (Ljava/io/File;)[B
    //   130: astore_2
    //   131: aload_2
    //   132: astore_0
    //   133: aload_2
    //   134: aload #4
    //   136: invokestatic a : ([BLjava/util/List;)Lorg/json/JSONObject;
    //   139: putstatic com/qq/e/comm/plugin/h/a/g.a : Lorg/json/JSONObject;
    //   142: aload_2
    //   143: astore_0
    //   144: goto -> 154
    //   147: astore_2
    //   148: ldc 'uuid read backup file failed.'
    //   150: aload_2
    //   151: invokestatic a : (Ljava/lang/String;Ljava/lang/Exception;)V
    //   154: getstatic com/qq/e/comm/plugin/h/a/g.a : Lorg/json/JSONObject;
    //   157: ifnull -> 174
    //   160: ldc 'read uuid from backup'
    //   162: iconst_0
    //   163: anewarray java/lang/Object
    //   166: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: iconst_1
    //   170: istore_1
    //   171: goto -> 292
    //   174: aload #4
    //   176: aload #4
    //   178: invokeinterface size : ()I
    //   183: iconst_1
    //   184: isub
    //   185: invokeinterface get : (I)Ljava/lang/Object;
    //   190: checkcast com/qq/e/comm/plugin/h/a/g$a
    //   193: astore_2
    //   194: aload_2
    //   195: invokestatic a : (Lcom/qq/e/comm/plugin/h/a/g$a;)Lorg/json/JSONObject;
    //   198: putstatic com/qq/e/comm/plugin/h/a/g.a : Lorg/json/JSONObject;
    //   201: new java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial <init> : ()V
    //   208: astore_3
    //   209: aload_3
    //   210: ldc 'read uuid from new generate uuid:'
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_3
    //   217: getstatic com/qq/e/comm/plugin/h/a/g.a : Lorg/json/JSONObject;
    //   220: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_3
    //   225: ldc ' use salt:'
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_3
    //   232: aload_2
    //   233: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_3
    //   238: invokevirtual toString : ()Ljava/lang/String;
    //   241: iconst_0
    //   242: anewarray java/lang/Object
    //   245: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: getstatic com/qq/e/comm/plugin/h/a/g.a : Lorg/json/JSONObject;
    //   251: invokevirtual toString : ()Ljava/lang/String;
    //   254: ldc 'UTF-8'
    //   256: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   259: astore_2
    //   260: iconst_3
    //   261: istore_1
    //   262: aload_2
    //   263: astore_0
    //   264: goto -> 292
    //   267: astore_3
    //   268: ldc 'generate new uuid error'
    //   270: astore_2
    //   271: aload_2
    //   272: aload_3
    //   273: invokestatic a : (Ljava/lang/String;Ljava/lang/Exception;)V
    //   276: goto -> 292
    //   279: astore_3
    //   280: ldc 'uuid parse slat error.'
    //   282: astore #4
    //   284: aload_2
    //   285: astore_0
    //   286: aload #4
    //   288: astore_2
    //   289: goto -> 271
    //   292: aload_0
    //   293: ifnull -> 9
    //   296: iload_1
    //   297: ifeq -> 9
    //   300: iload_1
    //   301: iconst_1
    //   302: iand
    //   303: ifeq -> 317
    //   306: aload #5
    //   308: ldc 'meta.dat'
    //   310: aload_0
    //   311: invokestatic a : (Ljava/io/File;Ljava/lang/String;[B)V
    //   314: goto -> 317
    //   317: iload_1
    //   318: iconst_2
    //   319: iand
    //   320: ifeq -> 9
    //   323: aload #6
    //   325: ldc 'meta.dat'
    //   327: aload_0
    //   328: invokestatic a : (Ljava/io/File;Ljava/lang/String;[B)V
    //   331: goto -> 9
    //   334: iload_1
    //   335: iconst_3
    //   336: if_icmpne -> 349
    //   339: new org/json/JSONObject
    //   342: dup
    //   343: invokespecial <init> : ()V
    //   346: putstatic com/qq/e/comm/plugin/h/a/g.a : Lorg/json/JSONObject;
    //   349: ldc 'write uuid to file error'
    //   351: aload_0
    //   352: invokestatic a : (Ljava/lang/String;Ljava/lang/Exception;)V
    //   355: goto -> 9
    //   358: ldc com/qq/e/comm/plugin/h/a/g
    //   360: monitorexit
    //   361: aload_0
    //   362: areturn
    //   363: astore_0
    //   364: ldc com/qq/e/comm/plugin/h/a/g
    //   366: monitorexit
    //   367: aload_0
    //   368: athrow
    //   369: astore_0
    //   370: goto -> 334
    // Exception table:
    //   from	to	target	type
    //   3	9	363	finally
    //   9	13	363	finally
    //   16	44	363	finally
    //   50	56	279	org/json/JSONException
    //   50	56	363	finally
    //   58	73	89	java/lang/Exception
    //   58	73	363	finally
    //   75	84	89	java/lang/Exception
    //   75	84	363	finally
    //   90	96	363	finally
    //   96	111	363	finally
    //   116	131	147	java/lang/Exception
    //   116	131	363	finally
    //   133	142	147	java/lang/Exception
    //   133	142	363	finally
    //   148	154	363	finally
    //   154	169	363	finally
    //   174	260	267	java/lang/Exception
    //   174	260	363	finally
    //   271	276	363	finally
    //   306	314	369	java/lang/Exception
    //   306	314	363	finally
    //   323	331	369	java/lang/Exception
    //   323	331	363	finally
    //   339	349	363	finally
    //   349	355	363	finally
  }
  
  private static JSONObject a(byte[] paramArrayOfbyte, List<a> paramList) throws Exception {
    JSONObject jSONObject = new JSONObject(new String(paramArrayOfbyte, 0, paramArrayOfbyte.length, "UTF-8"));
    int i = jSONObject.getInt("v");
    String str2 = jSONObject.getString("u");
    long l = jSONObject.getLong("t");
    String str1 = jSONObject.getString("m");
    Iterator<a> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      a a = iterator.next();
      if (a.a(a) == i) {
        String str = a(a, str2, l);
        if (str1.equals(str))
          return jSONObject; 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("file signature:");
        stringBuilder1.append(str1);
        stringBuilder1.append(" not match calculate signature:");
        stringBuilder1.append(str);
        throw new Exception(stringBuilder1.toString());
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("file version not exist:");
    stringBuilder.append(i);
    throw new Exception(stringBuilder.toString());
  }
  
  private static void a(File paramFile, String paramString, byte[] paramArrayOfbyte) throws Exception {
    FileLock fileLock1;
    if (!paramFile.exists() && !paramFile.mkdirs())
      ak.a("create dir error", new Object[0]); 
    FileLock fileLock2 = null;
    File file = null;
    try {
      RandomAccessFile randomAccessFile = new RandomAccessFile(new File(paramFile, paramString), "rwd");
    } finally {
      paramString = null;
      paramFile = null;
    } 
    if (fileLock1 != null)
      try {
        fileLock1.release();
      } catch (IOException iOException) {} 
    if (paramFile != null)
      paramFile.close(); 
    throw paramString;
  }
  
  private static byte[] a(File paramFile) throws Exception {
    FileLock fileLock2 = null;
    FileLock fileLock1 = null;
    try {
      RandomAccessFile randomAccessFile = new RandomAccessFile(paramFile, "rwd");
    } finally {
      fileLock1 = null;
    } 
    if (fileLock2 != null)
      try {
        fileLock2.release();
      } catch (IOException iOException) {} 
    if (paramFile != null)
      paramFile.close(); 
    throw fileLock1;
  }
  
  private static List<a> b(String paramString) throws JSONException {
    JSONArray jSONArray = new JSONArray(paramString);
    ArrayList<a> arrayList = new ArrayList();
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject jSONObject = jSONArray.getJSONObject(i);
      arrayList.add(new a(jSONObject.getInt("v"), jSONObject.getString("s")));
    } 
    return arrayList;
  }
  
  static final class a {
    private final int a;
    
    private final String b;
    
    public a(int param1Int, String param1String) {
      this.a = param1Int;
      this.b = param1String;
    }
    
    public int a() {
      return this.a;
    }
    
    public String b() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\h\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */