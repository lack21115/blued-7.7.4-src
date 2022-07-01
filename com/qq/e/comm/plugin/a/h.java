package com.qq.e.comm.plugin.a;

import android.graphics.Bitmap;
import com.qq.e.comm.plugin.t.j;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

class h implements Callable<Bitmap> {
  private static final ConcurrentHashMap<String, String> a = new ConcurrentHashMap<String, String>();
  
  private String b = "";
  
  private int c;
  
  private int d;
  
  public h(String paramString) {
    this(paramString, 0, 0);
  }
  
  public h(String paramString, int paramInt1, int paramInt2) {
    this.b = paramString;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  private Bitmap a(Bitmap paramBitmap) {
    int i = this.c;
    Bitmap bitmap = paramBitmap;
    if (i > 0) {
      int j = this.d;
      bitmap = paramBitmap;
      if (j > 0)
        bitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true); 
    } 
    return bitmap;
  }
  
  private Bitmap b() {
    // Byte code:
    //   0: invokestatic i : ()Ljava/io/File;
    //   3: astore_3
    //   4: aconst_null
    //   5: astore_2
    //   6: aload_3
    //   7: ifnull -> 241
    //   10: aload_3
    //   11: invokevirtual mkdirs : ()Z
    //   14: pop
    //   15: aload_0
    //   16: getfield b : Ljava/lang/String;
    //   19: invokestatic encode : (Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_2
    //   23: getstatic com/qq/e/comm/plugin/a/h.a : Ljava/util/concurrent/ConcurrentHashMap;
    //   26: aload_2
    //   27: invokevirtual contains : (Ljava/lang/Object;)Z
    //   30: ifeq -> 35
    //   33: aconst_null
    //   34: areturn
    //   35: new java/io/File
    //   38: dup
    //   39: aload_3
    //   40: aload_2
    //   41: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   44: astore #4
    //   46: aload #4
    //   48: invokevirtual exists : ()Z
    //   51: ifne -> 174
    //   54: aload_0
    //   55: invokespecial c : ()Ljava/net/HttpURLConnection;
    //   58: astore_3
    //   59: aload_3
    //   60: astore_2
    //   61: aload_3
    //   62: invokestatic a : (Ljava/net/HttpURLConnection;)Ljava/net/HttpURLConnection;
    //   65: astore_3
    //   66: aload_3
    //   67: astore_2
    //   68: aload_3
    //   69: invokevirtual getResponseCode : ()I
    //   72: istore_1
    //   73: iload_1
    //   74: sipush #200
    //   77: if_icmpne -> 132
    //   80: aload_3
    //   81: astore_2
    //   82: new java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial <init> : ()V
    //   89: astore #5
    //   91: aload_3
    //   92: astore_2
    //   93: aload #5
    //   95: ldc 'Icon url resp code'
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_3
    //   102: astore_2
    //   103: aload #5
    //   105: iload_1
    //   106: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_3
    //   111: astore_2
    //   112: aload #5
    //   114: invokevirtual toString : ()Ljava/lang/String;
    //   117: invokestatic d : (Ljava/lang/String;)V
    //   120: aload_3
    //   121: astore_2
    //   122: aload_3
    //   123: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   126: aload #4
    //   128: invokestatic copyTo : (Ljava/io/InputStream;Ljava/io/File;)Z
    //   131: pop
    //   132: aload_3
    //   133: ifnull -> 174
    //   136: aload_3
    //   137: astore_2
    //   138: goto -> 156
    //   141: astore_3
    //   142: goto -> 148
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_2
    //   148: aload_3
    //   149: invokevirtual printStackTrace : ()V
    //   152: aload_2
    //   153: ifnull -> 174
    //   156: aload_2
    //   157: invokevirtual disconnect : ()V
    //   160: goto -> 174
    //   163: astore_3
    //   164: aload_2
    //   165: ifnull -> 172
    //   168: aload_2
    //   169: invokevirtual disconnect : ()V
    //   172: aload_3
    //   173: athrow
    //   174: aload #4
    //   176: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   179: invokestatic decodeFile : (Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   182: astore_2
    //   183: aload_2
    //   184: ifnonnull -> 235
    //   187: new java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial <init> : ()V
    //   194: astore_3
    //   195: aload_3
    //   196: ldc 'DecodeIconImageFail\\turl:'
    //   198: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_3
    //   203: aload_0
    //   204: getfield b : Ljava/lang/String;
    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_3
    //   212: ldc '\\tfilemd5:'
    //   214: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_3
    //   219: aload #4
    //   221: invokestatic encode : (Ljava/io/File;)Ljava/lang/String;
    //   224: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_3
    //   229: invokevirtual toString : ()Ljava/lang/String;
    //   232: invokestatic report : (Ljava/lang/String;)V
    //   235: aload_0
    //   236: aload_2
    //   237: invokespecial a : (Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   240: astore_2
    //   241: aload_2
    //   242: areturn
    // Exception table:
    //   from	to	target	type
    //   54	59	145	finally
    //   61	66	141	finally
    //   68	73	141	finally
    //   82	91	141	finally
    //   93	101	141	finally
    //   103	110	141	finally
    //   112	120	141	finally
    //   122	132	141	finally
    //   148	152	163	finally
  }
  
  private HttpURLConnection c() throws IOException {
    HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(this.b)).openConnection();
    httpURLConnection.setRequestProperty("User-Agent", j.a);
    httpURLConnection.setConnectTimeout(5000);
    httpURLConnection.setReadTimeout(5000);
    return httpURLConnection;
  }
  
  public Bitmap a() throws Exception {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial b : ()Landroid/graphics/Bitmap;
    //   4: astore_1
    //   5: aconst_null
    //   6: astore #4
    //   8: aconst_null
    //   9: astore #5
    //   11: aload_1
    //   12: ifnull -> 17
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: invokespecial c : ()Ljava/net/HttpURLConnection;
    //   21: astore_2
    //   22: aload_2
    //   23: astore_1
    //   24: aload_2
    //   25: invokestatic a : (Ljava/net/HttpURLConnection;)Ljava/net/HttpURLConnection;
    //   28: astore_2
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokevirtual getResponseCode : ()I
    //   35: sipush #200
    //   38: if_icmpne -> 70
    //   41: aload_2
    //   42: astore_1
    //   43: aload_0
    //   44: aload_2
    //   45: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   48: invokestatic decodeStream : (Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   51: invokespecial a : (Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   54: astore_3
    //   55: aload_3
    //   56: astore #4
    //   58: aload_2
    //   59: ifnull -> 103
    //   62: aload_2
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual disconnect : ()V
    //   68: aload_3
    //   69: areturn
    //   70: aload_2
    //   71: ifnull -> 103
    //   74: aload_2
    //   75: astore_1
    //   76: aload #5
    //   78: astore_3
    //   79: goto -> 64
    //   82: astore_2
    //   83: goto -> 89
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_2
    //   90: invokevirtual printStackTrace : ()V
    //   93: aload_1
    //   94: ifnull -> 103
    //   97: aload #5
    //   99: astore_3
    //   100: goto -> 64
    //   103: aload #4
    //   105: areturn
    //   106: astore_2
    //   107: aload_1
    //   108: ifnull -> 115
    //   111: aload_1
    //   112: invokevirtual disconnect : ()V
    //   115: aload_2
    //   116: athrow
    // Exception table:
    //   from	to	target	type
    //   17	22	86	finally
    //   24	29	82	finally
    //   31	41	82	finally
    //   43	55	82	finally
    //   89	93	106	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */