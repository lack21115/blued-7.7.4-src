package com.blued.android.framework.utils.upload.qiniu;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.upload.QiniuUploadExtra;
import com.blued.android.framework.utils.upload.qiniu.pool.UploadThreadManager;
import java.util.List;

public class UploadAudioTask extends UploadBaseTask {
  private String p;
  
  private BluedToken q;
  
  private QiniuUploadExtra r;
  
  private int s = 0;
  
  public UploadAudioTask(String paramString1, List<Pair<String, String>> paramList, String paramString2, SenderListener paramSenderListener) {
    super(paramString1, paramSenderListener);
    this.c = paramList;
    this.d.addAll(this.c);
    this.p = paramString2;
    a(false);
    this.o = 1;
  }
  
  private void a(String paramString, int paramInt, IUploadTask.IUploadStateListener paramIUploadStateListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc '获取Task token！'
    //   5: invokevirtual b : (Ljava/lang/String;)V
    //   8: aload_1
    //   9: iload_2
    //   10: new com/blued/android/framework/utils/upload/qiniu/UploadAudioTask$2
    //   13: dup
    //   14: aload_0
    //   15: aload_3
    //   16: invokespecial <init> : (Lcom/blued/android/framework/utils/upload/qiniu/UploadAudioTask;Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask$IUploadStateListener;)V
    //   19: aconst_null
    //   20: invokestatic a : (Ljava/lang/String;ILcom/blued/android/core/net/StringHttpResponseHandler;Lcom/blued/android/core/net/IRequestHost;)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	26	finally
  }
  
  private String g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield q : Lcom/blued/android/framework/utils/upload/qiniu/BluedToken;
    //   6: getfield uploading_keys : Ljava/util/List;
    //   9: ifnull -> 92
    //   12: aload_0
    //   13: getfield q : Lcom/blued/android/framework/utils/upload/qiniu/BluedToken;
    //   16: getfield uploading_keys : Ljava/util/List;
    //   19: invokeinterface size : ()I
    //   24: ifle -> 92
    //   27: new java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial <init> : ()V
    //   34: astore_1
    //   35: aload_1
    //   36: ldc '获取 列表中的key:'
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: aload_0
    //   44: getfield q : Lcom/blued/android/framework/utils/upload/qiniu/BluedToken;
    //   47: getfield uploading_keys : Ljava/util/List;
    //   50: iconst_0
    //   51: invokeinterface get : (I)Ljava/lang/Object;
    //   56: checkcast java/lang/String
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual toString : ()Ljava/lang/String;
    //   68: invokevirtual b : (Ljava/lang/String;)V
    //   71: aload_0
    //   72: getfield q : Lcom/blued/android/framework/utils/upload/qiniu/BluedToken;
    //   75: getfield uploading_keys : Ljava/util/List;
    //   78: iconst_0
    //   79: invokeinterface remove : (I)Ljava/lang/Object;
    //   84: checkcast java/lang/String
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: areturn
    //   92: new java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial <init> : ()V
    //   99: astore_1
    //   100: aload_1
    //   101: ldc '获取key:'
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_1
    //   108: aload_0
    //   109: getfield q : Lcom/blued/android/framework/utils/upload/qiniu/BluedToken;
    //   112: getfield key : Ljava/lang/String;
    //   115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_0
    //   120: aload_1
    //   121: invokevirtual toString : ()Ljava/lang/String;
    //   124: invokevirtual b : (Ljava/lang/String;)V
    //   127: aload_0
    //   128: getfield q : Lcom/blued/android/framework/utils/upload/qiniu/BluedToken;
    //   131: getfield key : Ljava/lang/String;
    //   134: astore_1
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_1
    //   138: areturn
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    // Exception table:
    //   from	to	target	type
    //   2	88	139	finally
    //   92	135	139	finally
  }
  
  public void a(IUploadTask.IUploadStateListener paramIUploadStateListener) {
    super.a(paramIUploadStateListener);
    a(this.p, this.c.size(), new IUploadTask.IUploadStateListener(this) {
          public void a() {
            UploadAudioTask uploadAudioTask = this.a;
            boolean bool = uploadAudioTask.a(UploadAudioTask.a(uploadAudioTask), UploadAudioTask.b(this.a));
            int i = 0;
            if (bool) {
              while (i < this.a.o) {
                uploadAudioTask = this.a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("upload_consumer");
                stringBuilder.append(i);
                UploadBaseTask.Consumer consumer = new UploadBaseTask.Consumer(uploadAudioTask, stringBuilder.toString());
                UploadThreadManager.a().a(consumer);
                i++;
              } 
            } else {
              if (UploadAudioTask.c(this.a) <= 0) {
                UploadAudioTask.d(this.a);
                uploadAudioTask = this.a;
                UploadAudioTask.a(uploadAudioTask, UploadAudioTask.e(uploadAudioTask), this.a.c.size(), this);
                return;
              } 
              this.a.e();
              if (this.a.j != null)
                this.a.j.a(this.a.a(), false, this.a.c); 
              if (this.a.i != null)
                this.a.i.a(); 
            } 
          }
        });
  }
  
  public void a(String paramString1, String paramString2, double paramDouble) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield e : Ljava/util/List;
    //   7: invokeinterface size : ()I
    //   12: i2f
    //   13: fconst_1
    //   14: fmul
    //   15: aload_0
    //   16: getfield c : Ljava/util/List;
    //   19: invokeinterface size : ()I
    //   24: i2f
    //   25: fdiv
    //   26: ldc 100.0
    //   28: fmul
    //   29: f2i
    //   30: i2d
    //   31: invokevirtual a : (D)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	34	37	finally
  }
  
  public boolean a(String paramString) {
    return false;
  }
  
  public void b(IUploadTask.IUploadStateListener paramIUploadStateListener) {
    Pair<String, String> pair = d();
    if (pair != null) {
      b("上传语音");
      String str1 = g();
      String str2 = this.q.token;
      if (TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2)) {
        a(2, "", "", pair);
        if (paramIUploadStateListener != null) {
          paramIUploadStateListener.a();
          return;
        } 
        return;
      } 
      a(str1, str2, this.r, 2, pair, (String)pair.first, paramIUploadStateListener, 0);
      return;
    } 
    if (paramIUploadStateListener != null)
      paramIUploadStateListener.a(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\qiniu\UploadAudioTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */