package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.IDataObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONObject;

public class a implements IDataObserver {
  private static ArrayList<WeakReference<IDataObserver>> a = new ArrayList<WeakReference<IDataObserver>>(4);
  
  public void a(IDataObserver paramIDataObserver) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 29
    //   6: getstatic com/bytedance/embedapplog/util/a.a : Ljava/util/ArrayList;
    //   9: new java/lang/ref/WeakReference
    //   12: dup
    //   13: aload_1
    //   14: invokespecial <init> : (Ljava/lang/Object;)V
    //   17: invokevirtual add : (Ljava/lang/Object;)Z
    //   20: pop
    //   21: goto -> 29
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    // Exception table:
    //   from	to	target	type
    //   6	21	24	finally
  }
  
  public void b(IDataObserver paramIDataObserver) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/bytedance/embedapplog/util/a.a : Ljava/util/ArrayList;
    //   5: invokevirtual iterator : ()Ljava/util/Iterator;
    //   8: astore_2
    //   9: aload_2
    //   10: invokeinterface hasNext : ()Z
    //   15: ifeq -> 64
    //   18: aload_2
    //   19: invokeinterface next : ()Ljava/lang/Object;
    //   24: checkcast java/lang/ref/WeakReference
    //   27: invokevirtual get : ()Ljava/lang/Object;
    //   30: checkcast com/bytedance/embedapplog/IDataObserver
    //   33: astore_3
    //   34: aload_3
    //   35: ifnonnull -> 47
    //   38: aload_2
    //   39: invokeinterface remove : ()V
    //   44: goto -> 9
    //   47: aload_3
    //   48: aload_1
    //   49: invokevirtual equals : (Ljava/lang/Object;)Z
    //   52: ifeq -> 9
    //   55: aload_2
    //   56: invokeinterface remove : ()V
    //   61: goto -> 9
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	67	finally
    //   9	34	67	finally
    //   38	44	67	finally
    //   47	61	67	finally
  }
  
  public void onIdLoaded(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/bytedance/embedapplog/util/a.a : Ljava/util/ArrayList;
    //   5: invokevirtual iterator : ()Ljava/util/Iterator;
    //   8: astore #4
    //   10: aload #4
    //   12: invokeinterface hasNext : ()Z
    //   17: ifeq -> 66
    //   20: aload #4
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast java/lang/ref/WeakReference
    //   30: invokevirtual get : ()Ljava/lang/Object;
    //   33: checkcast com/bytedance/embedapplog/IDataObserver
    //   36: astore #5
    //   38: aload #5
    //   40: ifnonnull -> 53
    //   43: aload #4
    //   45: invokeinterface remove : ()V
    //   50: goto -> 10
    //   53: aload #5
    //   55: aload_1
    //   56: aload_2
    //   57: aload_3
    //   58: invokeinterface onIdLoaded : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   63: goto -> 10
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	69	finally
    //   10	38	69	finally
    //   43	50	69	finally
    //   53	63	69	finally
  }
  
  public void onRemoteAbConfigGet(boolean paramBoolean, JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/bytedance/embedapplog/util/a.a : Ljava/util/ArrayList;
    //   5: invokevirtual iterator : ()Ljava/util/Iterator;
    //   8: astore_3
    //   9: aload_3
    //   10: invokeinterface hasNext : ()Z
    //   15: ifeq -> 61
    //   18: aload_3
    //   19: invokeinterface next : ()Ljava/lang/Object;
    //   24: checkcast java/lang/ref/WeakReference
    //   27: invokevirtual get : ()Ljava/lang/Object;
    //   30: checkcast com/bytedance/embedapplog/IDataObserver
    //   33: astore #4
    //   35: aload #4
    //   37: ifnonnull -> 49
    //   40: aload_3
    //   41: invokeinterface remove : ()V
    //   46: goto -> 9
    //   49: aload #4
    //   51: iload_1
    //   52: aload_2
    //   53: invokeinterface onRemoteAbConfigGet : (ZLorg/json/JSONObject;)V
    //   58: goto -> 9
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	64	finally
    //   9	35	64	finally
    //   40	46	64	finally
    //   49	58	64	finally
  }
  
  public void onRemoteConfigGet(boolean paramBoolean, JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/bytedance/embedapplog/util/a.a : Ljava/util/ArrayList;
    //   5: invokevirtual iterator : ()Ljava/util/Iterator;
    //   8: astore_3
    //   9: aload_3
    //   10: invokeinterface hasNext : ()Z
    //   15: ifeq -> 61
    //   18: aload_3
    //   19: invokeinterface next : ()Ljava/lang/Object;
    //   24: checkcast java/lang/ref/WeakReference
    //   27: invokevirtual get : ()Ljava/lang/Object;
    //   30: checkcast com/bytedance/embedapplog/IDataObserver
    //   33: astore #4
    //   35: aload #4
    //   37: ifnonnull -> 49
    //   40: aload_3
    //   41: invokeinterface remove : ()V
    //   46: goto -> 9
    //   49: aload #4
    //   51: iload_1
    //   52: aload_2
    //   53: invokeinterface onRemoteConfigGet : (ZLorg/json/JSONObject;)V
    //   58: goto -> 9
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	64	finally
    //   9	35	64	finally
    //   40	46	64	finally
    //   49	58	64	finally
  }
  
  public void onRemoteIdGet(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/bytedance/embedapplog/util/a.a : Ljava/util/ArrayList;
    //   5: invokevirtual iterator : ()Ljava/util/Iterator;
    //   8: astore #8
    //   10: aload #8
    //   12: invokeinterface hasNext : ()Z
    //   17: ifeq -> 74
    //   20: aload #8
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast java/lang/ref/WeakReference
    //   30: invokevirtual get : ()Ljava/lang/Object;
    //   33: checkcast com/bytedance/embedapplog/IDataObserver
    //   36: astore #9
    //   38: aload #9
    //   40: ifnonnull -> 53
    //   43: aload #8
    //   45: invokeinterface remove : ()V
    //   50: goto -> 10
    //   53: aload #9
    //   55: iload_1
    //   56: aload_2
    //   57: aload_3
    //   58: aload #4
    //   60: aload #5
    //   62: aload #6
    //   64: aload #7
    //   66: invokeinterface onRemoteIdGet : (ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   71: goto -> 10
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	77	finally
    //   10	38	77	finally
    //   43	50	77	finally
    //   53	71	77	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplo\\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */