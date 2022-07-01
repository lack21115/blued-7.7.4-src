package com.blued.android.framework.utils.upload.qiniu;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import java.util.ArrayList;

public class UploadTaskHandle {
  private static final String a = UploadTaskHandle.class.getSimpleName();
  
  private static UploadTaskHandle b;
  
  private ArrayList<IUploadTask> c = new ArrayList<IUploadTask>();
  
  private IUploadTask d;
  
  private ArrayList<String> e = new ArrayList<String>();
  
  public static UploadTaskHandle a() {
    // Byte code:
    //   0: getstatic com/blued/android/framework/utils/upload/qiniu/UploadTaskHandle.b : Lcom/blued/android/framework/utils/upload/qiniu/UploadTaskHandle;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/framework/utils/upload/qiniu/UploadTaskHandle
    //   8: monitorenter
    //   9: getstatic com/blued/android/framework/utils/upload/qiniu/UploadTaskHandle.b : Lcom/blued/android/framework/utils/upload/qiniu/UploadTaskHandle;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/framework/utils/upload/qiniu/UploadTaskHandle
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/framework/utils/upload/qiniu/UploadTaskHandle.b : Lcom/blued/android/framework/utils/upload/qiniu/UploadTaskHandle;
    //   25: ldc com/blued/android/framework/utils/upload/qiniu/UploadTaskHandle
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/framework/utils/upload/qiniu/UploadTaskHandle
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/framework/utils/upload/qiniu/UploadTaskHandle.b : Lcom/blued/android/framework/utils/upload/qiniu/UploadTaskHandle;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private IUploadTask b() {
    b("getStackTopTask");
    if (this.c.size() > 0) {
      IUploadTask iUploadTask = this.c.remove(0);
      if (iUploadTask != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getStackTopTask  | taskId:");
        stringBuilder.append(iUploadTask.a());
        b(stringBuilder.toString());
        return iUploadTask;
      } 
    } 
    return null;
  }
  
  private void b(String paramString) {
    if (AppInfo.m())
      Logger.c(MediaSender.a, new Object[] { paramString }); 
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask;
    //   6: ifnonnull -> 90
    //   9: aload_0
    //   10: aload_0
    //   11: invokespecial b : ()Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask;
    //   14: putfield d : Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask;
    //   17: aload_0
    //   18: getfield d : Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask;
    //   21: ifnull -> 81
    //   24: new java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial <init> : ()V
    //   31: astore_1
    //   32: aload_1
    //   33: ldc '开始消费下一个任务:'
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_1
    //   40: aload_0
    //   41: getfield d : Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask;
    //   44: invokeinterface a : ()Ljava/lang/String;
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual toString : ()Ljava/lang/String;
    //   58: invokespecial b : (Ljava/lang/String;)V
    //   61: aload_0
    //   62: getfield d : Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask;
    //   65: new com/blued/android/framework/utils/upload/qiniu/UploadTaskHandle$1
    //   68: dup
    //   69: aload_0
    //   70: invokespecial <init> : (Lcom/blued/android/framework/utils/upload/qiniu/UploadTaskHandle;)V
    //   73: invokeinterface a : (Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask$IUploadStateListener;)V
    //   78: goto -> 96
    //   81: aload_0
    //   82: ldc '没有可消费的任务!!!'
    //   84: invokespecial b : (Ljava/lang/String;)V
    //   87: goto -> 96
    //   90: aload_0
    //   91: ldc '没有可消费的任务!!!'
    //   93: invokespecial b : (Ljava/lang/String;)V
    //   96: aload_0
    //   97: monitorexit
    //   98: return
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Exception table:
    //   from	to	target	type
    //   2	78	99	finally
    //   81	87	99	finally
    //   90	96	99	finally
  }
  
  public void a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask;
    //   6: astore_2
    //   7: aconst_null
    //   8: astore_3
    //   9: aload_2
    //   10: ifnull -> 57
    //   13: aload_0
    //   14: getfield d : Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask;
    //   17: invokeinterface a : ()Ljava/lang/String;
    //   22: aload_1
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifeq -> 57
    //   29: aload_0
    //   30: getfield d : Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask;
    //   33: astore_2
    //   34: aload_2
    //   35: invokeinterface b : ()V
    //   40: aload_0
    //   41: getfield c : Ljava/util/ArrayList;
    //   44: aload_2
    //   45: invokevirtual remove : (Ljava/lang/Object;)Z
    //   48: pop
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield d : Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask;
    //   54: goto -> 125
    //   57: aload_0
    //   58: getfield c : Ljava/util/ArrayList;
    //   61: invokevirtual iterator : ()Ljava/util/Iterator;
    //   64: astore #4
    //   66: aload_3
    //   67: astore_2
    //   68: aload #4
    //   70: invokeinterface hasNext : ()Z
    //   75: ifeq -> 112
    //   78: aload #4
    //   80: invokeinterface next : ()Ljava/lang/Object;
    //   85: checkcast com/blued/android/framework/utils/upload/qiniu/IUploadTask
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull -> 66
    //   93: aload_2
    //   94: invokeinterface a : ()Ljava/lang/String;
    //   99: aload_1
    //   100: invokevirtual equals : (Ljava/lang/Object;)Z
    //   103: ifeq -> 66
    //   106: aload_2
    //   107: invokeinterface b : ()V
    //   112: aload_2
    //   113: ifnull -> 125
    //   116: aload_0
    //   117: getfield c : Ljava/util/ArrayList;
    //   120: aload_2
    //   121: invokevirtual remove : (Ljava/lang/Object;)Z
    //   124: pop
    //   125: aload_0
    //   126: getfield e : Ljava/util/ArrayList;
    //   129: aload_1
    //   130: invokevirtual remove : (Ljava/lang/Object;)Z
    //   133: pop
    //   134: aload_0
    //   135: monitorexit
    //   136: return
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	137	finally
    //   13	54	137	finally
    //   57	66	137	finally
    //   68	89	137	finally
    //   93	112	137	finally
    //   116	125	137	finally
    //   125	134	137	finally
  }
  
  public boolean a(IUploadTask paramIUploadTask) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_0
    //   11: getfield e : Ljava/util/ArrayList;
    //   14: aload_1
    //   15: invokeinterface a : ()Ljava/lang/String;
    //   20: invokevirtual contains : (Ljava/lang/Object;)Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifeq -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: getfield c : Ljava/util/ArrayList;
    //   36: aload_1
    //   37: invokevirtual add : (Ljava/lang/Object;)Z
    //   40: pop
    //   41: aload_0
    //   42: getfield e : Ljava/util/ArrayList;
    //   45: aload_1
    //   46: invokeinterface a : ()Ljava/lang/String;
    //   51: invokevirtual add : (Ljava/lang/Object;)Z
    //   54: pop
    //   55: aload_0
    //   56: invokespecial c : ()V
    //   59: new java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial <init> : ()V
    //   66: astore_3
    //   67: aload_3
    //   68: ldc '添加上传任务, taskId'
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_3
    //   75: aload_1
    //   76: invokeinterface a : ()Ljava/lang/String;
    //   81: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_0
    //   86: aload_3
    //   87: invokevirtual toString : ()Ljava/lang/String;
    //   90: invokespecial b : (Ljava/lang/String;)V
    //   93: aload_0
    //   94: monitorexit
    //   95: iconst_1
    //   96: ireturn
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Exception table:
    //   from	to	target	type
    //   10	24	97	finally
    //   32	93	97	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\qiniu\UploadTaskHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */