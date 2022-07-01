package cn.com.chinatelecom.account.a;

import android.content.Context;
import java.io.File;

public class b {
  public static String a(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic c : (Landroid/content/Context;)Ljava/io/File;
    //   4: astore_1
    //   5: new java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore #6
    //   14: aload_1
    //   15: ifnull -> 255
    //   18: aload_1
    //   19: invokevirtual exists : ()Z
    //   22: ifne -> 28
    //   25: goto -> 255
    //   28: aconst_null
    //   29: astore_3
    //   30: aconst_null
    //   31: astore_0
    //   32: new java/io/FileInputStream
    //   35: dup
    //   36: aload_1
    //   37: invokespecial <init> : (Ljava/io/File;)V
    //   40: astore_1
    //   41: new java/io/InputStreamReader
    //   44: dup
    //   45: aload_1
    //   46: invokespecial <init> : (Ljava/io/InputStream;)V
    //   49: astore #4
    //   51: new java/io/BufferedReader
    //   54: dup
    //   55: aload #4
    //   57: invokespecial <init> : (Ljava/io/Reader;)V
    //   60: astore_3
    //   61: aload_3
    //   62: invokevirtual readLine : ()Ljava/lang/String;
    //   65: astore_0
    //   66: aload_0
    //   67: ifnull -> 80
    //   70: aload #6
    //   72: aload_0
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: goto -> 61
    //   80: aload_3
    //   81: invokevirtual close : ()V
    //   84: goto -> 92
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual printStackTrace : ()V
    //   92: aload #4
    //   94: invokevirtual close : ()V
    //   97: goto -> 105
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual printStackTrace : ()V
    //   105: aload_1
    //   106: invokevirtual close : ()V
    //   109: goto -> 198
    //   112: astore_2
    //   113: aload_3
    //   114: astore_0
    //   115: goto -> 119
    //   118: astore_2
    //   119: aload_1
    //   120: astore #5
    //   122: aload_0
    //   123: astore_3
    //   124: aload #4
    //   126: astore_1
    //   127: aload #5
    //   129: astore_0
    //   130: goto -> 146
    //   133: astore_2
    //   134: aload_1
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_1
    //   138: goto -> 146
    //   141: astore_2
    //   142: aconst_null
    //   143: astore_1
    //   144: aload_1
    //   145: astore_0
    //   146: aload_2
    //   147: invokevirtual printStackTrace : ()V
    //   150: aload_3
    //   151: ifnull -> 166
    //   154: aload_3
    //   155: invokevirtual close : ()V
    //   158: goto -> 166
    //   161: astore_2
    //   162: aload_2
    //   163: invokevirtual printStackTrace : ()V
    //   166: aload_1
    //   167: ifnull -> 182
    //   170: aload_1
    //   171: invokevirtual close : ()V
    //   174: goto -> 182
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual printStackTrace : ()V
    //   182: aload_0
    //   183: ifnull -> 198
    //   186: aload_0
    //   187: invokevirtual close : ()V
    //   190: goto -> 198
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual printStackTrace : ()V
    //   198: aload #6
    //   200: invokevirtual toString : ()Ljava/lang/String;
    //   203: areturn
    //   204: astore_2
    //   205: aload_3
    //   206: ifnull -> 221
    //   209: aload_3
    //   210: invokevirtual close : ()V
    //   213: goto -> 221
    //   216: astore_3
    //   217: aload_3
    //   218: invokevirtual printStackTrace : ()V
    //   221: aload_1
    //   222: ifnull -> 237
    //   225: aload_1
    //   226: invokevirtual close : ()V
    //   229: goto -> 237
    //   232: astore_1
    //   233: aload_1
    //   234: invokevirtual printStackTrace : ()V
    //   237: aload_0
    //   238: ifnull -> 253
    //   241: aload_0
    //   242: invokevirtual close : ()V
    //   245: goto -> 253
    //   248: astore_0
    //   249: aload_0
    //   250: invokevirtual printStackTrace : ()V
    //   253: aload_2
    //   254: athrow
    //   255: ldc ''
    //   257: areturn
    // Exception table:
    //   from	to	target	type
    //   32	41	141	finally
    //   41	51	133	finally
    //   51	61	118	finally
    //   61	66	112	finally
    //   70	77	112	finally
    //   80	84	87	java/lang/Exception
    //   92	97	100	java/lang/Exception
    //   105	109	193	java/lang/Exception
    //   146	150	204	finally
    //   154	158	161	java/lang/Exception
    //   170	174	177	java/lang/Exception
    //   186	190	193	java/lang/Exception
    //   209	213	216	java/lang/Exception
    //   225	229	232	java/lang/Exception
    //   241	245	248	java/lang/Exception
  }
  
  public static void a(Context paramContext, String paramString) {
    File file = c(paramContext);
    if (file != null && file.exists()) {
      a(file, paramString);
      return;
    } 
    a(b(paramContext), paramString);
  }
  
  private static void a(File paramFile, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 196
    //   4: aload_0
    //   5: invokevirtual exists : ()Z
    //   8: ifeq -> 196
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore #5
    //   16: new java/io/FileWriter
    //   19: dup
    //   20: aload_0
    //   21: iconst_0
    //   22: invokespecial <init> : (Ljava/io/File;Z)V
    //   25: astore_0
    //   26: aload_0
    //   27: astore_2
    //   28: new java/io/BufferedWriter
    //   31: dup
    //   32: aload_0
    //   33: invokespecial <init> : (Ljava/io/Writer;)V
    //   36: astore #4
    //   38: aload_1
    //   39: astore_2
    //   40: aload_1
    //   41: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   44: ifeq -> 50
    //   47: ldc ''
    //   49: astore_2
    //   50: aload #4
    //   52: aload_2
    //   53: invokevirtual write : (Ljava/lang/String;)V
    //   56: aload #4
    //   58: invokevirtual flush : ()V
    //   61: aload #4
    //   63: invokevirtual close : ()V
    //   66: goto -> 74
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual printStackTrace : ()V
    //   74: aload_0
    //   75: invokevirtual close : ()V
    //   78: return
    //   79: astore_1
    //   80: aload #4
    //   82: astore_3
    //   83: goto -> 162
    //   86: astore_2
    //   87: aload #4
    //   89: astore_1
    //   90: aload_2
    //   91: astore #4
    //   93: goto -> 119
    //   96: astore #4
    //   98: aload #5
    //   100: astore_1
    //   101: goto -> 119
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_3
    //   107: aload_3
    //   108: astore_0
    //   109: goto -> 162
    //   112: astore #4
    //   114: aconst_null
    //   115: astore_0
    //   116: aload #5
    //   118: astore_1
    //   119: aload_1
    //   120: astore_3
    //   121: aload_0
    //   122: astore_2
    //   123: aload #4
    //   125: invokevirtual printStackTrace : ()V
    //   128: aload_1
    //   129: ifnull -> 144
    //   132: aload_1
    //   133: invokevirtual close : ()V
    //   136: goto -> 144
    //   139: astore_1
    //   140: aload_1
    //   141: invokevirtual printStackTrace : ()V
    //   144: aload_0
    //   145: ifnull -> 196
    //   148: aload_0
    //   149: invokevirtual close : ()V
    //   152: return
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual printStackTrace : ()V
    //   158: return
    //   159: astore_1
    //   160: aload_2
    //   161: astore_0
    //   162: aload_3
    //   163: ifnull -> 178
    //   166: aload_3
    //   167: invokevirtual close : ()V
    //   170: goto -> 178
    //   173: astore_2
    //   174: aload_2
    //   175: invokevirtual printStackTrace : ()V
    //   178: aload_0
    //   179: ifnull -> 194
    //   182: aload_0
    //   183: invokevirtual close : ()V
    //   186: goto -> 194
    //   189: astore_0
    //   190: aload_0
    //   191: invokevirtual printStackTrace : ()V
    //   194: aload_1
    //   195: athrow
    //   196: return
    // Exception table:
    //   from	to	target	type
    //   16	26	112	java/lang/Exception
    //   16	26	104	finally
    //   28	38	96	java/lang/Exception
    //   28	38	159	finally
    //   40	47	86	java/lang/Exception
    //   40	47	79	finally
    //   50	61	86	java/lang/Exception
    //   50	61	79	finally
    //   61	66	69	java/lang/Exception
    //   74	78	153	java/lang/Exception
    //   123	128	159	finally
    //   132	136	139	java/lang/Exception
    //   148	152	153	java/lang/Exception
    //   166	170	173	java/lang/Exception
    //   182	186	189	java/lang/Exception
  }
  
  private static File b(Context paramContext) {
    if (paramContext != null)
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramContext.getFilesDir());
        stringBuilder.append("/eAccount/Log/");
        File file = new File(stringBuilder.toString());
        if (!file.exists())
          file.mkdirs(); 
        file = new File(file, "ipa_ol.ds");
        if (file.exists())
          file.delete(); 
        file.createNewFile();
        return file;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return null;
  }
  
  private static File c(Context paramContext) {
    if (paramContext != null)
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramContext.getFilesDir());
        stringBuilder.append("/eAccount/Log/");
        File file = new File(stringBuilder.toString());
        if (!file.exists())
          return null; 
        file = new File(file, "ipa_ol.ds");
        boolean bool = file.exists();
        return !bool ? null : file;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */