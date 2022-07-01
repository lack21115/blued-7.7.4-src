package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;

final class f implements Runnable {
  f(long paramLong, Context paramContext, ArrayList paramArrayList, JSONArray paramJSONArray) {}
  
  public void run() {
    // Byte code:
    //   0: new com/huawei/hms/framework/network/grs/c/b/a
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 'total_time'
    //   11: aload_0
    //   12: getfield a : J
    //   15: invokevirtual put : (Ljava/lang/String;J)Lcom/huawei/hms/framework/common/hianalytics/HianalyticsBaseData;
    //   18: pop
    //   19: aload_2
    //   20: ldc 'network_type'
    //   22: aload_0
    //   23: getfield b : Landroid/content/Context;
    //   26: invokestatic getNetworkType : (Landroid/content/Context;)I
    //   29: i2l
    //   30: invokevirtual put : (Ljava/lang/String;J)Lcom/huawei/hms/framework/common/hianalytics/HianalyticsBaseData;
    //   33: pop
    //   34: aload_0
    //   35: getfield c : Ljava/util/ArrayList;
    //   38: invokevirtual iterator : ()Ljava/util/Iterator;
    //   41: astore_3
    //   42: aload_3
    //   43: invokeinterface hasNext : ()Z
    //   48: ifeq -> 91
    //   51: aload_3
    //   52: invokeinterface next : ()Ljava/lang/Object;
    //   57: checkcast com/huawei/hms/framework/network/grs/c/e
    //   60: astore #4
    //   62: aload #4
    //   64: invokevirtual m : ()Z
    //   67: ifeq -> 42
    //   70: aload_2
    //   71: aload #4
    //   73: invokestatic a : (Lcom/huawei/hms/framework/network/grs/c/e;)Ljava/util/LinkedHashMap;
    //   76: invokevirtual put : (Ljava/util/LinkedHashMap;)Lcom/huawei/hms/framework/common/hianalytics/HianalyticsBaseData;
    //   79: pop
    //   80: aload_3
    //   81: invokeinterface remove : ()V
    //   86: iconst_1
    //   87: istore_1
    //   88: goto -> 93
    //   91: iconst_0
    //   92: istore_1
    //   93: iload_1
    //   94: ifne -> 144
    //   97: aload_0
    //   98: getfield c : Ljava/util/ArrayList;
    //   101: invokevirtual size : ()I
    //   104: ifle -> 144
    //   107: aload_0
    //   108: getfield c : Ljava/util/ArrayList;
    //   111: astore_3
    //   112: aload_3
    //   113: aload_3
    //   114: invokevirtual size : ()I
    //   117: iconst_1
    //   118: isub
    //   119: invokevirtual get : (I)Ljava/lang/Object;
    //   122: checkcast com/huawei/hms/framework/network/grs/c/e
    //   125: astore_3
    //   126: aload_2
    //   127: aload_3
    //   128: invokestatic a : (Lcom/huawei/hms/framework/network/grs/c/e;)Ljava/util/LinkedHashMap;
    //   131: invokevirtual put : (Ljava/util/LinkedHashMap;)Lcom/huawei/hms/framework/common/hianalytics/HianalyticsBaseData;
    //   134: pop
    //   135: aload_0
    //   136: getfield c : Ljava/util/ArrayList;
    //   139: aload_3
    //   140: invokevirtual remove : (Ljava/lang/Object;)Z
    //   143: pop
    //   144: aload_0
    //   145: getfield c : Ljava/util/ArrayList;
    //   148: invokevirtual size : ()I
    //   151: ifle -> 205
    //   154: aload_0
    //   155: getfield c : Ljava/util/ArrayList;
    //   158: invokevirtual iterator : ()Ljava/util/Iterator;
    //   161: astore_3
    //   162: aload_3
    //   163: invokeinterface hasNext : ()Z
    //   168: ifeq -> 205
    //   171: new org/json/JSONObject
    //   174: dup
    //   175: aload_3
    //   176: invokeinterface next : ()Ljava/lang/Object;
    //   181: checkcast com/huawei/hms/framework/network/grs/c/e
    //   184: invokestatic a : (Lcom/huawei/hms/framework/network/grs/c/e;)Ljava/util/LinkedHashMap;
    //   187: invokespecial <init> : (Ljava/util/Map;)V
    //   190: astore #4
    //   192: aload_0
    //   193: getfield d : Lorg/json/JSONArray;
    //   196: aload #4
    //   198: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   201: pop
    //   202: goto -> 162
    //   205: aload_0
    //   206: getfield d : Lorg/json/JSONArray;
    //   209: invokevirtual length : ()I
    //   212: ifle -> 229
    //   215: aload_2
    //   216: ldc 'failed_info'
    //   218: aload_0
    //   219: getfield d : Lorg/json/JSONArray;
    //   222: invokevirtual toString : ()Ljava/lang/String;
    //   225: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)Lcom/huawei/hms/framework/common/hianalytics/HianalyticsBaseData;
    //   228: pop
    //   229: ldc 'HaReportHelper'
    //   231: ldc 'grssdk report data to aiops is: %s'
    //   233: iconst_1
    //   234: anewarray java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: new org/json/JSONObject
    //   242: dup
    //   243: aload_2
    //   244: invokevirtual get : ()Ljava/util/LinkedHashMap;
    //   247: invokespecial <init> : (Ljava/util/Map;)V
    //   250: aastore
    //   251: invokestatic d : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: invokestatic getInstance : ()Lcom/huawei/hms/framework/common/hianalytics/HianalyticsHelper;
    //   257: aload_2
    //   258: invokevirtual get : ()Ljava/util/LinkedHashMap;
    //   261: ldc 'networkkit_grs'
    //   263: invokevirtual onEvent : (Ljava/util/LinkedHashMap;Ljava/lang/String;)V
    //   266: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */