package com.alibaba.mtl.appmonitor.b;

import android.content.Context;
import com.alibaba.mtl.appmonitor.SdkMeta;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.a.h;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.d;
import com.alibaba.mtl.appmonitor.f.c;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

public class b {
  private static String a(Throwable paramThrowable) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramThrowable.getClass().getName());
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    if (arrayOfStackTraceElement != null) {
      int j = arrayOfStackTraceElement.length;
      for (int i = 0; i < j; i++)
        stringBuilder.append(arrayOfStackTraceElement[i].toString()); 
    } 
    String str2 = stringBuilder.toString();
    String str1 = str2;
    if (com.alibaba.mtl.appmonitor.f.b.isBlank(str2))
      str1 = paramThrowable.toString(); 
    return str1;
  }
  
  private static JSONObject a(Context paramContext, Throwable paramThrowable) throws IOException {
    // Byte code:
    //   0: invokestatic a : ()Lcom/alibaba/mtl/appmonitor/c/a;
    //   3: ldc com/alibaba/mtl/appmonitor/c/e
    //   5: iconst_0
    //   6: anewarray java/lang/Object
    //   9: invokevirtual a : (Ljava/lang/Class;[Ljava/lang/Object;)Lcom/alibaba/mtl/appmonitor/c/b;
    //   12: checkcast org/json/JSONObject
    //   15: astore_2
    //   16: aload_0
    //   17: ifnull -> 31
    //   20: aload_2
    //   21: ldc 'pname'
    //   23: aload_0
    //   24: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   27: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   30: pop
    //   31: aload_2
    //   32: ldc 'page'
    //   34: ldc 'APPMONITOR'
    //   36: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   39: pop
    //   40: aload_2
    //   41: ldc 'monitorPoint'
    //   43: ldc 'sdk-exception'
    //   45: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   48: pop
    //   49: aload_2
    //   50: ldc 'arg'
    //   52: aload_1
    //   53: invokevirtual getClass : ()Ljava/lang/Class;
    //   56: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   59: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   62: pop
    //   63: aload_2
    //   64: ldc 'successCount'
    //   66: iconst_0
    //   67: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   70: pop
    //   71: aload_2
    //   72: ldc 'failCount'
    //   74: iconst_1
    //   75: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   78: pop
    //   79: new java/util/ArrayList
    //   82: dup
    //   83: invokespecial <init> : ()V
    //   86: astore_0
    //   87: aload_1
    //   88: invokestatic a : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull -> 136
    //   96: invokestatic a : ()Lcom/alibaba/mtl/appmonitor/c/a;
    //   99: ldc com/alibaba/mtl/appmonitor/c/e
    //   101: iconst_0
    //   102: anewarray java/lang/Object
    //   105: invokevirtual a : (Ljava/lang/Class;[Ljava/lang/Object;)Lcom/alibaba/mtl/appmonitor/c/b;
    //   108: checkcast org/json/JSONObject
    //   111: astore_3
    //   112: aload_3
    //   113: ldc 'errorCode'
    //   115: aload_1
    //   116: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   119: pop
    //   120: aload_3
    //   121: ldc 'errorCount'
    //   123: iconst_1
    //   124: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   127: pop
    //   128: aload_0
    //   129: aload_3
    //   130: invokeinterface add : (Ljava/lang/Object;)Z
    //   135: pop
    //   136: aload_2
    //   137: ldc 'errors'
    //   139: aload_0
    //   140: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload_2
    //   145: areturn
    //   146: astore_0
    //   147: aload_2
    //   148: areturn
    // Exception table:
    //   from	to	target	type
    //   20	31	146	java/lang/Exception
    //   31	92	146	java/lang/Exception
    //   96	136	146	java/lang/Exception
    //   136	144	146	java/lang/Exception
  }
  
  public static void a(Context paramContext, Throwable paramThrowable) {
    if (paramThrowable != null)
      try {
        h h = (h)a.a().a(h.class, new Object[0]);
        h.e = f.a.a();
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("meta", SdkMeta.getSDKMetaData());
        d d = (d)a.a().a(d.class, new Object[0]);
        d.put(a(paramContext, paramThrowable));
        hashMap.put("data", d);
        String str = f.a.a();
        h.k.put(str, (new JSONObject(hashMap)).toString());
        h.v = "APPMONITOR";
        h.w = "sdk-exception";
        c.a(h);
        return;
      } finally {
        paramContext = null;
      }  
  }
  
  public static void a(Throwable paramThrowable) {
    a((Context)null, paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */