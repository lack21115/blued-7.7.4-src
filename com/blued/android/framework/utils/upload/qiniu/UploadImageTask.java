package com.blued.android.framework.utils.upload.qiniu;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.utils.upload.QiniuUploadExtra;
import com.blued.android.framework.utils.upload.qiniu.pool.UploadThreadManager;
import java.io.File;
import java.util.List;

public class UploadImageTask extends UploadBaseTask {
  private String p;
  
  private BluedToken q;
  
  private QiniuUploadExtra r;
  
  private boolean s = false;
  
  private int t = 0;
  
  public UploadImageTask(String paramString1, List<Pair<String, String>> paramList, String paramString2, boolean paramBoolean, SenderListener paramSenderListener) {
    super(paramString1, paramSenderListener);
    this.c = paramList;
    this.d.addAll(this.c);
    this.p = paramString2;
    this.s = paramBoolean;
    if (paramList != null) {
      int j = Runtime.getRuntime().availableProcessors();
      byte b = 2;
      int i = b;
      if (j > 0) {
        i = (int)(j * 2.0F / 3.0F);
        if (i <= 0)
          i = b; 
      } 
      if (paramList.size() >= i) {
        this.o = i;
      } else {
        this.o = paramList.size();
      } 
      if (paramList.size() == 1)
        this.s = true; 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("是否进行单文件进度回调:");
    stringBuilder.append(this.s);
    b(stringBuilder.toString());
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
    //   10: new com/blued/android/framework/utils/upload/qiniu/UploadImageTask$2
    //   13: dup
    //   14: aload_0
    //   15: aload_3
    //   16: invokespecial <init> : (Lcom/blued/android/framework/utils/upload/qiniu/UploadImageTask;Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask$IUploadStateListener;)V
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
  
  private void g() {
    for (int i = 0; i < this.o; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("upload_consumer");
      stringBuilder.append(i);
      UploadBaseTask.Consumer consumer = new UploadBaseTask.Consumer(this, stringBuilder.toString());
      UploadThreadManager.a().a(consumer);
    } 
  }
  
  private String h() {
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
            UploadImageTask uploadImageTask = this.a;
            if (uploadImageTask.a(UploadImageTask.a(uploadImageTask), UploadImageTask.b(this.a))) {
              if (UploadImageTask.c(this.a)) {
                UploadThreadManager.a().a(new ThreadExecutor(this, "readFileSize_thread") {
                      public void execute() {
                        for (Pair<String, String> pair : this.a.a.c) {
                          if (pair != null && !TextUtils.isEmpty((CharSequence)pair.first)) {
                            File file = new File((String)pair.first);
                            if (file.exists()) {
                              long l = file.length();
                              UploadImageTask uploadImageTask1 = this.a.a;
                              StringBuilder stringBuilder1 = new StringBuilder();
                              stringBuilder1.append((String)pair.first);
                              stringBuilder1.append("大小:");
                              stringBuilder1.append(l);
                              uploadImageTask1.b(stringBuilder1.toString());
                              uploadImageTask1 = this.a.a;
                              uploadImageTask1.k += l;
                              this.a.a.f.put(pair.first, Long.valueOf(l));
                            } 
                          } 
                        } 
                        UploadImageTask uploadImageTask = this.a.a;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("上传文件总大小:");
                        stringBuilder.append(this.a.a.k);
                        uploadImageTask.b(stringBuilder.toString());
                        UploadImageTask.d(this.a.a);
                      }
                    });
                return;
              } 
              UploadImageTask.d(this.a);
              return;
            } 
            if (UploadImageTask.e(this.a) <= 0) {
              UploadImageTask.f(this.a);
              uploadImageTask = this.a;
              UploadImageTask.a(uploadImageTask, UploadImageTask.g(uploadImageTask), this.a.c.size(), this);
              return;
            } 
            this.a.e();
            if (this.a.j != null)
              this.a.j.a(this.a.a(), false, this.a.c); 
            if (this.a.i != null)
              this.a.i.a(); 
          }
        });
  }
  
  public void a(String paramString1, String paramString2, double paramDouble) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield s : Z
    //   6: ifeq -> 322
    //   9: new java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore #11
    //   18: aload #11
    //   20: aload_1
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload #11
    //   27: aload_2
    //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload #11
    //   34: invokevirtual toString : ()Ljava/lang/String;
    //   37: astore_2
    //   38: aload_0
    //   39: getfield f : Ljava/util/Map;
    //   42: aload_1
    //   43: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast java/lang/Long
    //   51: astore #11
    //   53: lconst_0
    //   54: lstore #7
    //   56: aload #11
    //   58: ifnonnull -> 67
    //   61: lconst_0
    //   62: lstore #5
    //   64: goto -> 74
    //   67: aload #11
    //   69: invokevirtual longValue : ()J
    //   72: lstore #5
    //   74: lload #5
    //   76: lconst_0
    //   77: lcmp
    //   78: ifle -> 353
    //   81: lload #5
    //   83: l2d
    //   84: dload_3
    //   85: dmul
    //   86: d2l
    //   87: lstore #9
    //   89: new java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial <init> : ()V
    //   96: astore #11
    //   98: aload #11
    //   100: ldc 'updateUploadProcess | finishFileSize：'
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload #11
    //   108: lload #9
    //   110: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload #11
    //   116: ldc ' | uploadFileSize：'
    //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload #11
    //   124: lload #5
    //   126: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload #11
    //   132: ldc ' | originalPath：'
    //   134: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload #11
    //   140: aload_1
    //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_0
    //   146: aload #11
    //   148: invokevirtual toString : ()Ljava/lang/String;
    //   151: invokevirtual b : (Ljava/lang/String;)V
    //   154: aload_0
    //   155: getfield g : Ljava/util/Map;
    //   158: aload_2
    //   159: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   164: checkcast java/lang/Long
    //   167: astore_1
    //   168: aload_1
    //   169: ifnonnull -> 178
    //   172: lconst_0
    //   173: lstore #5
    //   175: goto -> 184
    //   178: aload_1
    //   179: invokevirtual longValue : ()J
    //   182: lstore #5
    //   184: lload #9
    //   186: lload #5
    //   188: lcmp
    //   189: ifle -> 353
    //   192: aload_0
    //   193: getfield g : Ljava/util/Map;
    //   196: aload_2
    //   197: lload #9
    //   199: invokestatic valueOf : (J)Ljava/lang/Long;
    //   202: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   207: pop
    //   208: aload_0
    //   209: getfield g : Ljava/util/Map;
    //   212: invokeinterface values : ()Ljava/util/Collection;
    //   217: invokeinterface iterator : ()Ljava/util/Iterator;
    //   222: astore_1
    //   223: lload #7
    //   225: lstore #5
    //   227: aload_1
    //   228: invokeinterface hasNext : ()Z
    //   233: ifeq -> 256
    //   236: lload #5
    //   238: aload_1
    //   239: invokeinterface next : ()Ljava/lang/Object;
    //   244: checkcast java/lang/Long
    //   247: invokevirtual longValue : ()J
    //   250: ladd
    //   251: lstore #5
    //   253: goto -> 227
    //   256: new java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial <init> : ()V
    //   263: astore_1
    //   264: aload_1
    //   265: ldc 'updateUploadProcess | uploadFinishSize：'
    //   267: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_1
    //   272: lload #5
    //   274: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_1
    //   279: ldc ' | totalSize：'
    //   281: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_1
    //   286: aload_0
    //   287: getfield k : J
    //   290: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload_0
    //   295: aload_1
    //   296: invokevirtual toString : ()Ljava/lang/String;
    //   299: invokevirtual b : (Ljava/lang/String;)V
    //   302: aload_0
    //   303: lload #5
    //   305: l2f
    //   306: ldc 100.0
    //   308: fmul
    //   309: aload_0
    //   310: getfield k : J
    //   313: l2f
    //   314: fdiv
    //   315: f2d
    //   316: invokevirtual a : (D)V
    //   319: goto -> 353
    //   322: aload_0
    //   323: aload_0
    //   324: getfield e : Ljava/util/List;
    //   327: invokeinterface size : ()I
    //   332: i2f
    //   333: fconst_1
    //   334: fmul
    //   335: ldc 100.0
    //   337: fmul
    //   338: aload_0
    //   339: getfield c : Ljava/util/List;
    //   342: invokeinterface size : ()I
    //   347: i2f
    //   348: fdiv
    //   349: f2d
    //   350: invokevirtual a : (D)V
    //   353: aload_0
    //   354: monitorexit
    //   355: return
    //   356: astore_1
    //   357: aload_0
    //   358: monitorexit
    //   359: aload_1
    //   360: athrow
    // Exception table:
    //   from	to	target	type
    //   2	53	356	finally
    //   67	74	356	finally
    //   89	168	356	finally
    //   178	184	356	finally
    //   192	223	356	finally
    //   227	253	356	finally
    //   256	319	356	finally
    //   322	353	356	finally
  }
  
  public boolean a(String paramString) {
    return this.s;
  }
  
  public void b(IUploadTask.IUploadStateListener paramIUploadStateListener) {
    Pair<String, String> pair = d();
    if (pair != null) {
      b("上传图片");
      String str1 = h();
      String str2 = this.q.token;
      if (TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2)) {
        a(0, "", "", pair);
        if (paramIUploadStateListener != null) {
          paramIUploadStateListener.a();
          return;
        } 
        return;
      } 
      if (this.l) {
        a(str1, str2, this.r, pair, paramIUploadStateListener, 0, 0);
        return;
      } 
      a(str1, str2, this.r, 0, pair, (String)pair.first, paramIUploadStateListener, 0);
      return;
    } 
    if (paramIUploadStateListener != null)
      paramIUploadStateListener.a(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\qiniu\UploadImageTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */