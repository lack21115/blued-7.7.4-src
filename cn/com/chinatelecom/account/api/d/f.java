package cn.com.chinatelecom.account.api.d;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.account.a.c;
import cn.com.chinatelecom.account.api.CtAuth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

public class f {
  private static final String a = f.class.getSimpleName();
  
  private static int b = 0;
  
  private static Map<String, e> c = new HashMap<String, e>();
  
  private static List<e> d = new ArrayList<e>();
  
  private static e e = null;
  
  public static e a(String paramString) {
    // Byte code:
    //   0: ldc cn/com/chinatelecom/account/api/d/f
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore_1
    //   5: getstatic cn/com/chinatelecom/account/api/d/f.c : Ljava/util/Map;
    //   8: aload_0
    //   9: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   14: ifeq -> 30
    //   17: getstatic cn/com/chinatelecom/account/api/d/f.c : Ljava/util/Map;
    //   20: aload_0
    //   21: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast cn/com/chinatelecom/account/api/d/e
    //   29: astore_1
    //   30: aload_1
    //   31: astore_2
    //   32: aload_1
    //   33: ifnonnull -> 56
    //   36: new cn/com/chinatelecom/account/api/d/e
    //   39: dup
    //   40: aload_0
    //   41: invokespecial <init> : (Ljava/lang/String;)V
    //   44: astore_2
    //   45: getstatic cn/com/chinatelecom/account/api/d/f.c : Ljava/util/Map;
    //   48: aload_0
    //   49: aload_2
    //   50: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: ldc cn/com/chinatelecom/account/api/d/f
    //   58: monitorexit
    //   59: aload_2
    //   60: areturn
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual printStackTrace : ()V
    //   66: new cn/com/chinatelecom/account/api/d/e
    //   69: dup
    //   70: aload_0
    //   71: invokespecial <init> : (Ljava/lang/String;)V
    //   74: astore_0
    //   75: ldc cn/com/chinatelecom/account/api/d/f
    //   77: monitorexit
    //   78: aload_0
    //   79: areturn
    //   80: astore_0
    //   81: ldc cn/com/chinatelecom/account/api/d/f
    //   83: monitorexit
    //   84: aload_0
    //   85: athrow
    // Exception table:
    //   from	to	target	type
    //   5	30	61	finally
    //   36	56	61	finally
    //   62	75	80	finally
  }
  
  public static void a(Context paramContext, String paramString) {
    c.a(paramContext, paramString);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc cn/com/chinatelecom/account/api/d/f
    //   2: monitorenter
    //   3: getstatic cn/com/chinatelecom/account/api/d/f.c : Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   12: ifeq -> 36
    //   15: getstatic cn/com/chinatelecom/account/api/d/f.c : Ljava/util/Map;
    //   18: aload_0
    //   19: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast cn/com/chinatelecom/account/api/d/e
    //   27: aload_2
    //   28: invokevirtual g : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
    //   31: pop
    //   32: ldc cn/com/chinatelecom/account/api/d/f
    //   34: monitorexit
    //   35: return
    //   36: getstatic cn/com/chinatelecom/account/api/d/f.d : Ljava/util/List;
    //   39: invokeinterface size : ()I
    //   44: ifle -> 140
    //   47: getstatic cn/com/chinatelecom/account/api/d/f.d : Ljava/util/List;
    //   50: invokeinterface iterator : ()Ljava/util/Iterator;
    //   55: astore_3
    //   56: aload_3
    //   57: invokeinterface hasNext : ()Z
    //   62: ifeq -> 140
    //   65: aload_3
    //   66: invokeinterface next : ()Ljava/lang/Object;
    //   71: checkcast cn/com/chinatelecom/account/api/d/e
    //   74: astore #4
    //   76: aload #4
    //   78: invokevirtual a : ()Ljava/lang/String;
    //   81: ifnull -> 56
    //   84: aload #4
    //   86: invokevirtual a : ()Ljava/lang/String;
    //   89: aload_0
    //   90: invokevirtual equals : (Ljava/lang/Object;)Z
    //   93: ifeq -> 56
    //   96: new org/json/JSONObject
    //   99: dup
    //   100: aload_1
    //   101: invokespecial <init> : (Ljava/lang/String;)V
    //   104: astore #5
    //   106: aload #5
    //   108: ldc 'data'
    //   110: invokevirtual remove : (Ljava/lang/String;)Ljava/lang/Object;
    //   113: pop
    //   114: aload #4
    //   116: aload #5
    //   118: invokevirtual toString : ()Ljava/lang/String;
    //   121: invokevirtual g : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
    //   124: pop
    //   125: aload #4
    //   127: aload_2
    //   128: invokevirtual g : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
    //   131: pop
    //   132: goto -> 56
    //   135: astore_0
    //   136: aload_0
    //   137: invokevirtual printStackTrace : ()V
    //   140: ldc cn/com/chinatelecom/account/api/d/f
    //   142: monitorexit
    //   143: return
    //   144: astore_0
    //   145: ldc cn/com/chinatelecom/account/api/d/f
    //   147: monitorexit
    //   148: aload_0
    //   149: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	135	finally
    //   36	56	135	finally
    //   56	132	135	finally
    //   136	140	144	finally
  }
  
  private static void b(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 5
    //   4: return
    //   5: new java/util/ArrayList
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore_1
    //   13: ldc cn/com/chinatelecom/account/api/d/f
    //   15: monitorenter
    //   16: getstatic cn/com/chinatelecom/account/api/d/f.e : Lcn/com/chinatelecom/account/api/d/e;
    //   19: ifnull -> 39
    //   22: aload_1
    //   23: getstatic cn/com/chinatelecom/account/api/d/f.e : Lcn/com/chinatelecom/account/api/d/e;
    //   26: invokevirtual toString : ()Ljava/lang/String;
    //   29: invokeinterface add : (Ljava/lang/Object;)Z
    //   34: pop
    //   35: aconst_null
    //   36: putstatic cn/com/chinatelecom/account/api/d/f.e : Lcn/com/chinatelecom/account/api/d/e;
    //   39: getstatic cn/com/chinatelecom/account/api/d/f.d : Ljava/util/List;
    //   42: invokeinterface iterator : ()Ljava/util/Iterator;
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface hasNext : ()Z
    //   54: ifeq -> 79
    //   57: aload_1
    //   58: aload_2
    //   59: invokeinterface next : ()Ljava/lang/Object;
    //   64: checkcast cn/com/chinatelecom/account/api/d/e
    //   67: invokevirtual toString : ()Ljava/lang/String;
    //   70: invokeinterface add : (Ljava/lang/Object;)Z
    //   75: pop
    //   76: goto -> 48
    //   79: iconst_0
    //   80: putstatic cn/com/chinatelecom/account/api/d/f.b : I
    //   83: getstatic cn/com/chinatelecom/account/api/d/f.d : Ljava/util/List;
    //   86: invokeinterface clear : ()V
    //   91: ldc cn/com/chinatelecom/account/api/d/f
    //   93: monitorexit
    //   94: aload_1
    //   95: invokeinterface isEmpty : ()Z
    //   100: ifeq -> 104
    //   103: return
    //   104: aload_0
    //   105: aload_1
    //   106: invokestatic a : (Landroid/content/Context;Ljava/util/List;)V
    //   109: return
    //   110: astore_0
    //   111: ldc cn/com/chinatelecom/account/api/d/f
    //   113: monitorexit
    //   114: aload_0
    //   115: athrow
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual printStackTrace : ()V
    //   121: return
    // Exception table:
    //   from	to	target	type
    //   5	16	116	finally
    //   16	39	110	finally
    //   39	48	110	finally
    //   48	76	110	finally
    //   79	94	110	finally
    //   94	103	116	finally
    //   104	109	116	finally
    //   111	114	110	finally
    //   114	116	116	finally
  }
  
  public static void b(String paramString) {
    // Byte code:
    //   0: ldc cn/com/chinatelecom/account/api/d/f
    //   2: monitorenter
    //   3: getstatic cn/com/chinatelecom/account/api/d/f.c : Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   12: ifeq -> 54
    //   15: getstatic cn/com/chinatelecom/account/api/d/f.c : Ljava/util/Map;
    //   18: aload_0
    //   19: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast cn/com/chinatelecom/account/api/d/e
    //   27: putstatic cn/com/chinatelecom/account/api/d/f.e : Lcn/com/chinatelecom/account/api/d/e;
    //   30: getstatic cn/com/chinatelecom/account/api/d/f.e : Lcn/com/chinatelecom/account/api/d/e;
    //   33: invokevirtual b : ()V
    //   36: getstatic cn/com/chinatelecom/account/api/d/f.c : Ljava/util/Map;
    //   39: aload_0
    //   40: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   45: pop
    //   46: goto -> 54
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual printStackTrace : ()V
    //   54: ldc cn/com/chinatelecom/account/api/d/f
    //   56: monitorexit
    //   57: return
    //   58: astore_0
    //   59: ldc cn/com/chinatelecom/account/api/d/f
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Exception table:
    //   from	to	target	type
    //   3	46	49	finally
    //   50	54	58	finally
  }
  
  public static void b(String paramString1, String paramString2, String paramString3) {
    String str2 = "";
    byte b = -1;
    int i = b;
    String str1 = str2;
    int j = b;
    try {
      if (!TextUtils.isEmpty(paramString2)) {
        i = b;
        JSONObject jSONObject = new JSONObject(paramString2);
        i = b;
        j = jSONObject.getInt("result");
        i = j;
        str1 = jSONObject.optString("msg");
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      j = i;
      str1 = str2;
    } 
    e e1 = a(paramString1).a(j);
    if (j == 0) {
      e1.e(str1);
      return;
    } 
    e1.e(str1).d(paramString3);
  }
  
  public static void c(String paramString) {
    // Byte code:
    //   0: ldc cn/com/chinatelecom/account/api/d/f
    //   2: monitorenter
    //   3: getstatic cn/com/chinatelecom/account/api/d/f.c : Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   12: ifeq -> 52
    //   15: getstatic cn/com/chinatelecom/account/api/d/f.c : Ljava/util/Map;
    //   18: aload_0
    //   19: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast cn/com/chinatelecom/account/api/d/e
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual b : ()V
    //   32: getstatic cn/com/chinatelecom/account/api/d/f.d : Ljava/util/List;
    //   35: aload_1
    //   36: invokeinterface add : (Ljava/lang/Object;)Z
    //   41: pop
    //   42: getstatic cn/com/chinatelecom/account/api/d/f.c : Ljava/util/Map;
    //   45: aload_0
    //   46: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: getstatic cn/com/chinatelecom/account/api/d/f.b : I
    //   55: iconst_1
    //   56: if_icmpeq -> 103
    //   59: getstatic cn/com/chinatelecom/account/api/d/f.d : Ljava/util/List;
    //   62: invokeinterface isEmpty : ()Z
    //   67: ifeq -> 73
    //   70: goto -> 103
    //   73: iconst_1
    //   74: putstatic cn/com/chinatelecom/account/api/d/f.b : I
    //   77: ldc cn/com/chinatelecom/account/api/d/f
    //   79: monitorexit
    //   80: new cn/com/chinatelecom/account/api/d/f$1
    //   83: dup
    //   84: invokespecial <init> : ()V
    //   87: astore_0
    //   88: new java/util/Timer
    //   91: dup
    //   92: invokespecial <init> : ()V
    //   95: aload_0
    //   96: ldc2_w 8000
    //   99: invokevirtual schedule : (Ljava/util/TimerTask;J)V
    //   102: return
    //   103: ldc cn/com/chinatelecom/account/api/d/f
    //   105: monitorexit
    //   106: return
    //   107: astore_0
    //   108: ldc cn/com/chinatelecom/account/api/d/f
    //   110: monitorexit
    //   111: aload_0
    //   112: athrow
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual printStackTrace : ()V
    //   118: return
    // Exception table:
    //   from	to	target	type
    //   0	3	113	finally
    //   3	52	107	finally
    //   52	70	107	finally
    //   73	80	107	finally
    //   80	102	113	finally
    //   103	106	107	finally
    //   108	111	107	finally
    //   111	113	113	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */