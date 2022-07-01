package com.bun.miitmdid.core;

import android.content.Context;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JLibrary {
  public static String ASSET;
  
  public static String SeriailizationString;
  
  public static final String TAG = JLibrary.class.getSimpleName();
  
  public static ClassLoader classLoader;
  
  public static Context context;
  
  public static String o00o0a0odod;
  
  public static String o00o0a0odou;
  
  public static String xdata;
  
  public static String ydata;
  
  static {
    ASSET = "assets/";
    xdata = ".00000000000";
    ydata = ".11111111111";
    SeriailizationString = "stub_liu_0_dex_so:39285EFA@com/jdog;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;";
  }
  
  public static ReturnStatus InitEntry(Context paramContext) throws Exception {
    if (paramContext != null) {
      context = paramContext;
      classLoader = JLibrary.class.getClassLoader();
      String str = SeriailizationString;
      System.loadLibrary(str.substring(str.lastIndexOf(':') + 1, SeriailizationString.indexOf('@')));
      a();
      return ReturnStatus.RETURN_OK;
    } 
    throw new ExceptionInInitializerError("pass InitEntry arg(context) is null");
  }
  
  public static ByteBuffer ReadByteBuffer(String paramString) {
    try {
      FileInputStream fileInputStream = new FileInputStream(paramString);
      ByteBuffer byteBuffer = ByteBuffer.allocate(fileInputStream.available());
      for (int i = 0;; i += j) {
        if (i >= fileInputStream.available()) {
          fileInputStream.close();
          return byteBuffer;
        } 
        int j = fileInputStream.read(byteBuffer.array(), i, fileInputStream.available() - i);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static native boolean a();
  
  public static Object[] o0o0o0o0o0(Object paramObject, String paramString1, String paramString2, List<IOException> paramList) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
    String[] arrayOfString = paramString1.split(";");
    ArrayList<ByteBuffer> arrayList = new ArrayList();
    int j = arrayOfString.length;
    int i;
    for (i = 0;; i++) {
      ByteBuffer[] arrayOfByteBuffer;
      if (i >= j) {
        arrayOfByteBuffer = new ByteBuffer[arrayList.size()];
        return (Object[])o0o0o0o0o0o0(paramObject, paramString2, new Class[] { ByteBuffer[].class, List.class }).invoke(paramObject, new Object[] { arrayList.toArray((Object[])arrayOfByteBuffer), paramList });
      } 
      arrayList.add(ReadByteBuffer((String)arrayOfByteBuffer[i]));
    } 
  }
  
  private static Method o0o0o0o0o0o0(Object paramObject, String paramString, Class<?>... paramVarArgs) throws NoSuchMethodException {
    Class<?> clazz = paramObject.getClass();
    while (true) {
      if (clazz != null)
        try {
          Method method = clazz.getDeclaredMethod(paramString, paramVarArgs);
          if (!method.isAccessible())
            method.setAccessible(true); 
          return method;
        } catch (NoSuchMethodException noSuchMethodException) {
          clazz = clazz.getSuperclass();
          continue;
        }  
      StringBuilder stringBuilder = new StringBuilder("Method ");
      stringBuilder.append(paramString);
      stringBuilder.append(" with parameters ");
      stringBuilder.append(Arrays.asList(paramVarArgs));
      stringBuilder.append(" not found in ");
      stringBuilder.append(paramObject.getClass());
      throw new NoSuchMethodException(stringBuilder.toString());
    } 
  }
  
  public static void o0oo0o0(Context paramContext, String paramString) throws Exception {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore #6
    //   10: aload_0
    //   11: ldc ''
    //   13: invokestatic getXdataDir : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   16: putstatic com/bun/miitmdid/core/JLibrary.o00o0a0odod : Ljava/lang/String;
    //   19: aload_0
    //   20: ldc ''
    //   22: invokestatic getYdataDir : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   25: putstatic com/bun/miitmdid/core/JLibrary.o00o0a0odou : Ljava/lang/String;
    //   28: new java/io/File
    //   31: dup
    //   32: getstatic com/bun/miitmdid/core/JLibrary.o00o0a0odod : Ljava/lang/String;
    //   35: invokespecial <init> : (Ljava/lang/String;)V
    //   38: astore #7
    //   40: new java/io/File
    //   43: dup
    //   44: getstatic com/bun/miitmdid/core/JLibrary.o00o0a0odou : Ljava/lang/String;
    //   47: invokespecial <init> : (Ljava/lang/String;)V
    //   50: astore #8
    //   52: aload #7
    //   54: invokevirtual exists : ()Z
    //   57: istore #5
    //   59: iconst_3
    //   60: istore #4
    //   62: iload #5
    //   64: ifne -> 91
    //   67: iconst_3
    //   68: istore_3
    //   69: goto -> 285
    //   72: aload #7
    //   74: invokevirtual mkdir : ()Z
    //   77: istore #5
    //   79: iload_2
    //   80: istore_3
    //   81: iload #5
    //   83: ifne -> 93
    //   86: iload_2
    //   87: istore_3
    //   88: goto -> 285
    //   91: iconst_3
    //   92: istore_3
    //   93: iload_3
    //   94: iconst_m1
    //   95: if_icmpeq -> 246
    //   98: aload #8
    //   100: invokevirtual exists : ()Z
    //   103: ifne -> 311
    //   106: iload #4
    //   108: istore_3
    //   109: goto -> 298
    //   112: iload_2
    //   113: istore_3
    //   114: aload #8
    //   116: invokevirtual mkdir : ()Z
    //   119: ifne -> 127
    //   122: iload_2
    //   123: istore_3
    //   124: goto -> 298
    //   127: iload_3
    //   128: iconst_m1
    //   129: if_icmpeq -> 213
    //   132: aload_0
    //   133: invokestatic update : (Landroid/content/Context;)Z
    //   136: ifne -> 179
    //   139: new java/lang/StringBuilder
    //   142: dup
    //   143: getstatic com/bun/miitmdid/core/JLibrary.o00o0a0odod : Ljava/lang/String;
    //   146: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   149: invokespecial <init> : (Ljava/lang/String;)V
    //   152: astore #7
    //   154: aload #7
    //   156: aload_1
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: new java/io/File
    //   164: dup
    //   165: aload #7
    //   167: invokevirtual toString : ()Ljava/lang/String;
    //   170: invokespecial <init> : (Ljava/lang/String;)V
    //   173: invokevirtual exists : ()Z
    //   176: ifne -> 284
    //   179: new java/lang/StringBuilder
    //   182: dup
    //   183: getstatic com/bun/miitmdid/core/JLibrary.o00o0a0odod : Ljava/lang/String;
    //   186: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   189: invokespecial <init> : (Ljava/lang/String;)V
    //   192: astore #7
    //   194: aload #7
    //   196: aload_1
    //   197: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload #6
    //   203: aload #7
    //   205: invokevirtual toString : ()Ljava/lang/String;
    //   208: aload_0
    //   209: invokestatic x0xooXdata : (Ljava/io/InputStream;Ljava/lang/String;Landroid/content/Context;)V
    //   212: return
    //   213: new java/lang/StringBuilder
    //   216: dup
    //   217: ldc_w 'User dir cannot be created: '
    //   220: invokespecial <init> : (Ljava/lang/String;)V
    //   223: astore_0
    //   224: aload_0
    //   225: aload #8
    //   227: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   230: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: new java/lang/IllegalStateException
    //   237: dup
    //   238: aload_0
    //   239: invokevirtual toString : ()Ljava/lang/String;
    //   242: invokespecial <init> : (Ljava/lang/String;)V
    //   245: athrow
    //   246: new java/lang/StringBuilder
    //   249: dup
    //   250: ldc_w 'User dir cannot be created: '
    //   253: invokespecial <init> : (Ljava/lang/String;)V
    //   256: astore_0
    //   257: aload_0
    //   258: aload #7
    //   260: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: new java/lang/IllegalStateException
    //   270: dup
    //   271: aload_0
    //   272: invokevirtual toString : ()Ljava/lang/String;
    //   275: invokespecial <init> : (Ljava/lang/String;)V
    //   278: athrow
    //   279: astore_0
    //   280: aload_0
    //   281: invokevirtual printStackTrace : ()V
    //   284: return
    //   285: iload_3
    //   286: iconst_1
    //   287: isub
    //   288: istore_2
    //   289: iload_3
    //   290: ifgt -> 72
    //   293: iload_2
    //   294: istore_3
    //   295: goto -> 93
    //   298: iload_3
    //   299: iconst_1
    //   300: isub
    //   301: istore_2
    //   302: iload_3
    //   303: ifgt -> 112
    //   306: iload_2
    //   307: istore_3
    //   308: goto -> 127
    //   311: iconst_3
    //   312: istore_3
    //   313: goto -> 127
    // Exception table:
    //   from	to	target	type
    //   0	59	279	java/io/IOException
    //   72	79	279	java/io/IOException
    //   98	106	279	java/io/IOException
    //   114	122	279	java/io/IOException
    //   132	179	279	java/io/IOException
    //   179	212	279	java/io/IOException
    //   213	246	279	java/io/IOException
    //   246	279	279	java/io/IOException
  }
  
  enum ReturnStatus {
    RETURN_ERR, RETURN_OK;
    
    static {
      ENUM$VALUES = new ReturnStatus[] { RETURN_OK, RETURN_ERR };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\core\JLibrary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */