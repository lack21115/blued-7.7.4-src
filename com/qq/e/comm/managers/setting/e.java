package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class e {
  protected JSONObject a;
  
  e() {
    this(null);
  }
  
  e(String paramString) {
    String str = getClass().getSimpleName();
    StringBuilder stringBuilder = new StringBuilder("Initialize ");
    stringBuilder.append(str);
    stringBuilder.append(",Json=");
    stringBuilder.append(paramString);
    GDTLogger.d(stringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
      try {
        this.a = new JSONObject(paramString);
      } catch (JSONException jSONException) {
        stringBuilder = new StringBuilder("JsonException While build");
        stringBuilder.append(str);
        stringBuilder.append(" Instance from JSON");
        GDTLogger.e(stringBuilder.toString(), (Throwable)jSONException);
      }  
    if (this.a == null)
      this.a = new JSONObject(); 
  }
  
  private static Pair<String, String> a(Context paramContext, String paramString) {
    File file = paramContext.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
    if (file.exists()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append(".sig");
      File file1 = new File(file, stringBuilder1.toString());
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramString);
      stringBuilder2.append(".cfg");
      file = new File(file, stringBuilder2.toString());
      if (file1.exists() && file.exists())
        try {
          String str2 = StringUtil.readAll(file1);
          String str1 = StringUtil.readAll(file);
          if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str1) && com.qq.e.comm.util.a.a().a(str2, str1))
            return new Pair(str2, new String(Base64.decode(str1, 0), "UTF-8")); 
          StringBuilder stringBuilder = new StringBuilder("verify ");
          stringBuilder.append(paramString);
          stringBuilder.append(" setting fail");
          GDTLogger.e(stringBuilder.toString());
        } catch (Exception exception) {
          StringBuilder stringBuilder = new StringBuilder("exception while loading local ");
          stringBuilder.append(paramString);
          GDTLogger.e(stringBuilder.toString(), exception);
        }  
    } 
    return null;
  }
  
  static a<a> a(Context paramContext) {
    Pair<String, String> pair = a(paramContext, "devCloudSetting");
    return (pair == null) ? null : new a<a>((String)pair.first, new a((String)pair.second), (byte)0);
  }
  
  static boolean a(Context paramContext, String paramString1, String paramString2) {
    return a(paramContext, "sdkCloudSetting", paramString1, paramString2);
  }
  
  private static final boolean a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    String str;
    if (!StringUtil.isEmpty(paramString2) && !StringUtil.isEmpty(paramString3)) {
      if (com.qq.e.comm.util.a.a().a(paramString2, paramString3))
        return b(paramContext, paramString1, paramString2, paramString3); 
      str = String.format("Fail to update Cloud setting due to sig verify fail,name=%s\tsig=%s\tsetting=%s", new Object[] { paramString1, paramString2, paramString3 });
    } else {
      str = String.format("Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s", new Object[] { paramString1, paramString2, paramString3 });
    } 
    GDTLogger.e(str);
    return false;
  }
  
  static a<d> b(Context paramContext) {
    Pair<String, String> pair = a(paramContext, "sdkCloudSetting");
    return (pair == null) ? null : new a<d>((String)pair.first, new d((String)pair.second), (byte)0);
  }
  
  static boolean b(Context paramContext, String paramString1, String paramString2) {
    return a(paramContext, "devCloudSetting", paramString1, paramString2);
  }
  
  private static boolean b(Context paramContext, String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'e_qq_com_setting'
    //   3: invokestatic buildNewPathByProcessName : (Ljava/lang/String;)Ljava/lang/String;
    //   6: iconst_0
    //   7: invokevirtual getDir : (Ljava/lang/String;I)Ljava/io/File;
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual exists : ()Z
    //   15: ifne -> 23
    //   18: aload_0
    //   19: invokevirtual mkdirs : ()Z
    //   22: pop
    //   23: new java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: astore #4
    //   32: aload #4
    //   34: aload_1
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload #4
    //   41: ldc '.cfg'
    //   43: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: new java/io/File
    //   50: dup
    //   51: aload_0
    //   52: aload #4
    //   54: invokevirtual toString : ()Ljava/lang/String;
    //   57: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   60: astore #7
    //   62: new java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial <init> : ()V
    //   69: astore #4
    //   71: aload #4
    //   73: aload_1
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload #4
    //   80: ldc '.sig'
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: new java/io/File
    //   89: dup
    //   90: aload_0
    //   91: aload #4
    //   93: invokevirtual toString : ()Ljava/lang/String;
    //   96: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   99: astore #8
    //   101: aconst_null
    //   102: astore #6
    //   104: aconst_null
    //   105: astore_1
    //   106: aconst_null
    //   107: astore #5
    //   109: new java/io/FileWriter
    //   112: dup
    //   113: aload #7
    //   115: invokespecial <init> : (Ljava/io/File;)V
    //   118: astore_0
    //   119: aload #6
    //   121: astore #4
    //   123: aload_0
    //   124: astore_1
    //   125: aload_0
    //   126: aload_3
    //   127: invokevirtual write : (Ljava/lang/String;)V
    //   130: aload #6
    //   132: astore #4
    //   134: aload_0
    //   135: astore_1
    //   136: new java/io/FileWriter
    //   139: dup
    //   140: aload #8
    //   142: invokespecial <init> : (Ljava/io/File;)V
    //   145: astore_3
    //   146: aload_3
    //   147: aload_2
    //   148: invokevirtual write : (Ljava/lang/String;)V
    //   151: aload_0
    //   152: invokevirtual close : ()V
    //   155: aload_3
    //   156: invokevirtual close : ()V
    //   159: iconst_1
    //   160: ireturn
    //   161: astore_2
    //   162: aload_0
    //   163: astore_1
    //   164: aload_3
    //   165: astore_0
    //   166: goto -> 177
    //   169: aload_3
    //   170: astore_2
    //   171: goto -> 191
    //   174: aload #4
    //   176: astore_0
    //   177: goto -> 235
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_0
    //   183: goto -> 235
    //   186: aconst_null
    //   187: astore_0
    //   188: aload #5
    //   190: astore_2
    //   191: aload_2
    //   192: astore #4
    //   194: aload_0
    //   195: astore_1
    //   196: aload #7
    //   198: invokevirtual delete : ()Z
    //   201: pop
    //   202: aload_2
    //   203: astore #4
    //   205: aload_0
    //   206: astore_1
    //   207: aload #8
    //   209: invokevirtual delete : ()Z
    //   212: pop
    //   213: aload_0
    //   214: ifnull -> 221
    //   217: aload_0
    //   218: invokevirtual close : ()V
    //   221: aload_2
    //   222: ifnull -> 229
    //   225: aload_2
    //   226: invokevirtual close : ()V
    //   229: iconst_0
    //   230: ireturn
    //   231: astore_2
    //   232: goto -> 174
    //   235: aload_1
    //   236: ifnull -> 243
    //   239: aload_1
    //   240: invokevirtual close : ()V
    //   243: aload_0
    //   244: ifnull -> 251
    //   247: aload_0
    //   248: invokevirtual close : ()V
    //   251: aload_2
    //   252: athrow
    //   253: astore_0
    //   254: goto -> 186
    //   257: astore_1
    //   258: aload #5
    //   260: astore_2
    //   261: goto -> 191
    //   264: astore_1
    //   265: goto -> 169
    //   268: astore_0
    //   269: goto -> 159
    //   272: astore_0
    //   273: iconst_0
    //   274: ireturn
    //   275: astore_0
    //   276: goto -> 251
    // Exception table:
    //   from	to	target	type
    //   109	119	253	java/lang/Exception
    //   109	119	180	finally
    //   125	130	257	java/lang/Exception
    //   125	130	231	finally
    //   136	146	257	java/lang/Exception
    //   136	146	231	finally
    //   146	151	264	java/lang/Exception
    //   146	151	161	finally
    //   151	159	268	java/lang/Exception
    //   196	202	231	finally
    //   207	213	231	finally
    //   217	221	272	java/lang/Exception
    //   225	229	272	java/lang/Exception
    //   239	243	275	java/lang/Exception
    //   247	251	275	java/lang/Exception
  }
  
  static a<c> c(Context paramContext) {
    Pair<String, String> pair = a(paramContext, "placementCloudSetting");
    return (pair == null) ? null : new a<c>((String)pair.first, new c((String)pair.second), (byte)0);
  }
  
  static boolean c(Context paramContext, String paramString1, String paramString2) {
    return a(paramContext, "placementCloudSetting", paramString1, paramString2);
  }
  
  static void d(Context paramContext) {
    File file = paramContext.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
    if (file.exists()) {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("placementCloudSetting");
      stringBuilder2.append(".cfg");
      File file1 = new File(file, stringBuilder2.toString());
      if (file1.exists())
        file1.delete(); 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("placementCloudSetting");
      stringBuilder1.append(".sig");
      file = new File(file, stringBuilder1.toString());
      if (file.exists())
        file.delete(); 
    } 
  }
  
  static final class a<T> {
    private final String a;
    
    private final T b;
    
    private a(String param1String, T param1T) {
      this.a = param1String;
      this.b = param1T;
    }
    
    public final String a() {
      return this.a;
    }
    
    public final T b() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\setting\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */