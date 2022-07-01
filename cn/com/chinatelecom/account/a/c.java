package cn.com.chinatelecom.account.a;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.Helper;
import cn.com.chinatelecom.account.api.c.a;
import cn.com.chinatelecom.account.api.d.g;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class c extends a {
  private static final String b = c.class.getSimpleName();
  
  private static void a(Context paramContext, int paramInt) {
    try {
      cn.com.chinatelecom.account.api.d.c.a(paramContext, "key_c_l_l_v", paramInt);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void a(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual hashCode : ()I
    //   4: istore_2
    //   5: iconst_m1
    //   6: istore_3
    //   7: iload_2
    //   8: ldc 64897
    //   10: if_icmpeq -> 56
    //   13: iload_2
    //   14: ldc 78159
    //   16: if_icmpeq -> 42
    //   19: iload_2
    //   20: ldc 66247144
    //   22: if_icmpeq -> 28
    //   25: goto -> 70
    //   28: aload_1
    //   29: ldc 'ERROR'
    //   31: invokevirtual equals : (Ljava/lang/Object;)Z
    //   34: ifeq -> 70
    //   37: iconst_1
    //   38: istore_2
    //   39: goto -> 72
    //   42: aload_1
    //   43: ldc 'OFF'
    //   45: invokevirtual equals : (Ljava/lang/Object;)Z
    //   48: ifeq -> 70
    //   51: iconst_2
    //   52: istore_2
    //   53: goto -> 72
    //   56: aload_1
    //   57: ldc 'ALL'
    //   59: invokevirtual equals : (Ljava/lang/Object;)Z
    //   62: ifeq -> 70
    //   65: iconst_0
    //   66: istore_2
    //   67: goto -> 72
    //   70: iconst_m1
    //   71: istore_2
    //   72: iload_2
    //   73: ifeq -> 86
    //   76: iload_2
    //   77: iconst_1
    //   78: if_icmpeq -> 94
    //   81: iload_2
    //   82: iconst_2
    //   83: if_icmpeq -> 91
    //   86: iconst_0
    //   87: istore_3
    //   88: goto -> 94
    //   91: bipush #-2
    //   93: istore_3
    //   94: aload_0
    //   95: iload_3
    //   96: invokestatic a : (Landroid/content/Context;I)V
    //   99: return
  }
  
  public static void a(Context paramContext, List<String> paramList) {
    int i = b(paramContext);
    if (i == -2)
      return; 
    b(paramContext, paramList, i);
  }
  
  private static int b(Context paramContext) {
    try {
      return cn.com.chinatelecom.account.api.d.c.b(paramContext, "key_c_l_l_v", 0);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  private static String b(Context paramContext, String paramString) {
    return a.a(paramContext, g.c(), paramString);
  }
  
  private static String b(Context paramContext, Queue<String> paramQueue) {
    JSONArray jSONArray = new JSONArray();
    String str2 = jSONArray.toString();
    if (!paramQueue.isEmpty())
      for (String str : paramQueue) {
        try {
          jSONArray.put(new JSONObject(str));
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      }  
    if (jSONArray.length() <= 0)
      return ""; 
    String str3 = jSONArray.toString();
    String str1 = str2;
    if (!TextUtils.isEmpty(str3))
      try {
        str1 = URLEncoder.encode(Helper.guulam(paramContext, str3), "UTF-8");
      } catch (Exception exception) {
        exception.printStackTrace();
        str1 = str2;
      }  
    return b(paramContext, str1);
  }
  
  private static void b(Context paramContext, List<String> paramList, int paramInt) {
    a(new Runnable(paramContext, paramList, paramInt) {
          public void run() {
            try {
              Queue queue = c.a(this.a, this.b, this.c);
              if (!queue.isEmpty()) {
                Exception exception1;
                String str = c.a(this.a, queue);
                JSONObject jSONObject = null;
                exception2 = null;
                byte b = -1;
                int i = b;
                try {
                  if (!TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject(str);
                    try {
                      i = jSONObject.getInt("code");
                    } catch (Exception exception2) {
                      exception2.printStackTrace();
                      i = b;
                    } 
                  } 
                } catch (Exception exception) {
                  exception1 = exception2;
                  exception2 = exception;
                  exception2.printStackTrace();
                  i = b;
                } 
                if (exception1 != null && i == 0) {
                  c.a(this.a);
                  return;
                } 
                return;
              } 
            } finally {
              Exception exception = null;
            } 
          }
        });
  }
  
  private static void b(Context paramContext, Queue<String> paramQueue, int paramInt) {
    String str;
    JSONArray jSONArray = new JSONArray();
    if (paramQueue != null && !paramQueue.isEmpty()) {
      Iterator<String> iterator = paramQueue.iterator();
      int i = 0;
      while (iterator.hasNext()) {
        String str1 = iterator.next();
        try {
          JSONObject jSONObject = new JSONObject(str1);
          if (paramInt == -1 && jSONObject.getInt("rt") == 0)
            continue; 
          jSONArray.put(jSONObject);
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        int j = i + 1;
        i = j;
        if (j > 10)
          break; 
      } 
    } 
    if (jSONArray.length() > 0) {
      try {
        str = Helper.eneulret(jSONArray.toString());
      } catch (Exception exception) {
        exception.printStackTrace();
        exception = null;
      } 
    } else {
      str = "";
    } 
    if (!TextUtils.isEmpty(str))
      b.a(paramContext, str); 
  }
  
  private static Queue<String> c(Context paramContext, List<String> paramList, int paramInt) {
    // Byte code:
    //   0: ldc cn/com/chinatelecom/account/a/c
    //   2: monitorenter
    //   3: new java/util/concurrent/ConcurrentLinkedQueue
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore #5
    //   12: aload_0
    //   13: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   16: astore #6
    //   18: aload #6
    //   20: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   23: ifne -> 118
    //   26: new java/lang/String
    //   29: dup
    //   30: aload #6
    //   32: invokestatic a : (Ljava/lang/String;)[B
    //   35: invokestatic dneulret : ([B)[B
    //   38: invokespecial <init> : ([B)V
    //   41: astore #6
    //   43: new org/json/JSONArray
    //   46: dup
    //   47: aload #6
    //   49: invokespecial <init> : (Ljava/lang/String;)V
    //   52: astore #6
    //   54: iconst_0
    //   55: istore_3
    //   56: aload #6
    //   58: invokevirtual length : ()I
    //   61: istore #4
    //   63: iload_3
    //   64: iload #4
    //   66: if_icmpge -> 104
    //   69: iload_3
    //   70: bipush #10
    //   72: if_icmpgt -> 104
    //   75: aload #6
    //   77: iload_3
    //   78: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   81: astore #7
    //   83: aload #7
    //   85: ifnull -> 233
    //   88: aload #5
    //   90: aload #7
    //   92: invokevirtual toString : ()Ljava/lang/String;
    //   95: invokeinterface add : (Ljava/lang/Object;)Z
    //   100: pop
    //   101: goto -> 233
    //   104: aload_0
    //   105: ldc ''
    //   107: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   110: goto -> 118
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual printStackTrace : ()V
    //   118: iload_2
    //   119: iconst_m1
    //   120: if_icmpne -> 185
    //   123: aload_1
    //   124: invokeinterface iterator : ()Ljava/util/Iterator;
    //   129: astore_0
    //   130: aload_0
    //   131: invokeinterface hasNext : ()Z
    //   136: ifeq -> 198
    //   139: aload_0
    //   140: invokeinterface next : ()Ljava/lang/Object;
    //   145: checkcast java/lang/String
    //   148: astore_1
    //   149: new org/json/JSONObject
    //   152: dup
    //   153: aload_1
    //   154: invokespecial <init> : (Ljava/lang/String;)V
    //   157: ldc 'rt'
    //   159: invokevirtual getInt : (Ljava/lang/String;)I
    //   162: ifeq -> 130
    //   165: aload #5
    //   167: aload_1
    //   168: invokeinterface add : (Ljava/lang/Object;)Z
    //   173: pop
    //   174: goto -> 130
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual printStackTrace : ()V
    //   182: goto -> 130
    //   185: iload_2
    //   186: ifne -> 198
    //   189: aload #5
    //   191: aload_1
    //   192: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   197: pop
    //   198: aload #5
    //   200: invokeinterface size : ()I
    //   205: bipush #10
    //   207: if_icmple -> 221
    //   210: aload #5
    //   212: invokeinterface poll : ()Ljava/lang/Object;
    //   217: pop
    //   218: goto -> 198
    //   221: ldc cn/com/chinatelecom/account/a/c
    //   223: monitorexit
    //   224: aload #5
    //   226: areturn
    //   227: astore_0
    //   228: ldc cn/com/chinatelecom/account/a/c
    //   230: monitorexit
    //   231: aload_0
    //   232: athrow
    //   233: iload_3
    //   234: iconst_1
    //   235: iadd
    //   236: istore_3
    //   237: goto -> 63
    // Exception table:
    //   from	to	target	type
    //   3	43	227	finally
    //   43	54	113	java/lang/Exception
    //   43	54	227	finally
    //   56	63	113	java/lang/Exception
    //   56	63	227	finally
    //   75	83	113	java/lang/Exception
    //   75	83	227	finally
    //   88	101	113	java/lang/Exception
    //   88	101	227	finally
    //   104	110	113	java/lang/Exception
    //   104	110	227	finally
    //   114	118	227	finally
    //   123	130	227	finally
    //   130	149	227	finally
    //   149	174	177	java/lang/Exception
    //   149	174	227	finally
    //   178	182	227	finally
    //   189	198	227	finally
    //   198	218	227	finally
  }
  
  private static void c(Context paramContext) {
    b.a(paramContext, "");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */