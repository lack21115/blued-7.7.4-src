package com.blued.android.framework.utils.upload.qiniu;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.utils.Houyi;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.ThreadUtils;
import com.blued.android.framework.utils.upload.QiniuUpload;
import com.blued.android.framework.utils.upload.QiniuUploadExtra;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class UploadBaseTask implements IUploadTask, UploadProcessManager.IUpdateProcessListener {
  protected static final String a = UploadVideoTask.class.getSimpleName();
  
  protected String b;
  
  protected List<Pair<String, String>> c = new ArrayList<Pair<String, String>>();
  
  protected List<Pair<String, String>> d = new ArrayList<Pair<String, String>>();
  
  protected List<Pair<String, String>> e = new ArrayList<Pair<String, String>>();
  
  protected Map<String, Long> f = new HashMap<String, Long>();
  
  protected Map<String, Long> g = new HashMap<String, Long>();
  
  protected List<Pair<String, String>> h;
  
  protected IUploadTask.IUploadStateListener i;
  
  protected SenderListener j;
  
  protected long k = 0L;
  
  protected boolean l = true;
  
  protected boolean m = false;
  
  protected UploadProcessManager n;
  
  protected int o = 2;
  
  public UploadBaseTask(String paramString, SenderListener paramSenderListener) {
    this.b = paramString;
    this.j = paramSenderListener;
  }
  
  private void d(String paramString) {
    if (this.m) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("取消任务 消费者 ");
      stringBuilder1.append(paramString);
      stringBuilder1.append(" 退出");
      b(stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(":消费者消费任务");
    b(stringBuilder.toString());
    if (c()) {
      b("有待上传文件!!!");
      b(new IUploadTask.IUploadStateListener(this, paramString) {
            public void a() {
              UploadBaseTask.a(this.b, this.a);
            }
          });
      return;
    } 
    b("没可上传文件!!!");
  }
  
  public String a() {
    return this.b;
  }
  
  protected void a(double paramDouble) {
    UploadProcessManager uploadProcessManager = this.n;
    if (uploadProcessManager != null)
      uploadProcessManager.a(paramDouble); 
  }
  
  public void a(int paramInt) {
    a(new Runnable(this, paramInt) {
          public void run() {
            UploadBaseTask uploadBaseTask = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("更新进度runInUIThread:");
            stringBuilder.append(this.a);
            stringBuilder.append("%");
            uploadBaseTask.b(stringBuilder.toString());
            if (this.b.j != null)
              this.b.j.a(this.b.a(), this.a); 
          }
        });
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, Pair<String, String> paramPair) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Ljava/util/List;
    //   6: aload #4
    //   8: invokeinterface add : (Ljava/lang/Object;)Z
    //   13: pop
    //   14: aload #4
    //   16: getfield first : Ljava/lang/Object;
    //   19: checkcast java/lang/CharSequence
    //   22: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   25: ifne -> 62
    //   28: aload #4
    //   30: getfield second : Ljava/lang/Object;
    //   33: checkcast java/lang/CharSequence
    //   36: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   39: ifeq -> 45
    //   42: goto -> 62
    //   45: aload_0
    //   46: aload #4
    //   48: getfield first : Ljava/lang/Object;
    //   51: checkcast java/lang/String
    //   54: aload_3
    //   55: dconst_1
    //   56: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;D)V
    //   59: goto -> 92
    //   62: aload_0
    //   63: getfield h : Ljava/util/List;
    //   66: ifnonnull -> 80
    //   69: aload_0
    //   70: new java/util/ArrayList
    //   73: dup
    //   74: invokespecial <init> : ()V
    //   77: putfield h : Ljava/util/List;
    //   80: aload_0
    //   81: getfield h : Ljava/util/List;
    //   84: aload #4
    //   86: invokeinterface add : (Ljava/lang/Object;)Z
    //   91: pop
    //   92: new com/blued/android/framework/utils/upload/qiniu/UploadModel
    //   95: dup
    //   96: invokespecial <init> : ()V
    //   99: astore_3
    //   100: aload_3
    //   101: aload #4
    //   103: getfield second : Ljava/lang/Object;
    //   106: checkcast java/lang/String
    //   109: putfield url : Ljava/lang/String;
    //   112: aload_3
    //   113: aload_2
    //   114: putfield compressPath : Ljava/lang/String;
    //   117: aload_3
    //   118: iload_1
    //   119: putfield type : I
    //   122: new androidx/core/util/Pair
    //   125: dup
    //   126: aload #4
    //   128: getfield first : Ljava/lang/Object;
    //   131: aload_3
    //   132: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   135: astore_2
    //   136: new java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial <init> : ()V
    //   143: astore_3
    //   144: aload_3
    //   145: ldc '更新记录并回调:'
    //   147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_3
    //   152: aload_2
    //   153: invokevirtual toString : ()Ljava/lang/String;
    //   156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_0
    //   161: aload_3
    //   162: invokevirtual toString : ()Ljava/lang/String;
    //   165: invokevirtual b : (Ljava/lang/String;)V
    //   168: aload_0
    //   169: new com/blued/android/framework/utils/upload/qiniu/UploadBaseTask$4
    //   172: dup
    //   173: aload_0
    //   174: aload_2
    //   175: invokespecial <init> : (Lcom/blued/android/framework/utils/upload/qiniu/UploadBaseTask;Landroidx/core/util/Pair;)V
    //   178: invokevirtual a : (Ljava/lang/Runnable;)V
    //   181: aload_0
    //   182: invokevirtual f : ()V
    //   185: aload_0
    //   186: monitorexit
    //   187: return
    //   188: astore_2
    //   189: aload_0
    //   190: monitorexit
    //   191: aload_2
    //   192: athrow
    // Exception table:
    //   from	to	target	type
    //   2	42	188	finally
    //   45	59	188	finally
    //   62	80	188	finally
    //   80	92	188	finally
    //   92	185	188	finally
  }
  
  public void a(IUploadTask.IUploadStateListener paramIUploadStateListener) {
    this.i = paramIUploadStateListener;
    this.n = new UploadProcessManager(this);
  }
  
  protected void a(Runnable paramRunnable) {
    ThreadUtils.a(paramRunnable);
  }
  
  protected void a(String paramString1, int paramInt, Pair<String, String> paramPair, String paramString2, IUploadTask.IUploadStateListener paramIUploadStateListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iload_2
    //   5: iconst_0
    //   6: aload_3
    //   7: aload #4
    //   9: aload #5
    //   11: invokevirtual a : (Ljava/lang/String;IZLandroidx/core/util/Pair;Ljava/lang/String;Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask$IUploadStateListener;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	17	finally
  }
  
  protected void a(String paramString, int paramInt, boolean paramBoolean, Pair<String, String> paramPair, IUploadTask.IUploadStateListener paramIUploadStateListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iload_2
    //   5: iload_3
    //   6: aload #4
    //   8: aload #4
    //   10: getfield first : Ljava/lang/Object;
    //   13: checkcast java/lang/String
    //   16: aload #5
    //   18: invokevirtual a : (Ljava/lang/String;IZLandroidx/core/util/Pair;Ljava/lang/String;Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask$IUploadStateListener;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	24	finally
  }
  
  protected void a(String paramString1, int paramInt, boolean paramBoolean, Pair<String, String> paramPair, String paramString2, IUploadTask.IUploadStateListener paramIUploadStateListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc '获取token！'
    //   5: invokevirtual b : (Ljava/lang/String;)V
    //   8: aload_1
    //   9: iconst_1
    //   10: new com/blued/android/framework/utils/upload/qiniu/UploadBaseTask$3
    //   13: dup
    //   14: aload_0
    //   15: iload_3
    //   16: aload #4
    //   18: aload #6
    //   20: iload_2
    //   21: aload #5
    //   23: invokespecial <init> : (Lcom/blued/android/framework/utils/upload/qiniu/UploadBaseTask;ZLandroidx/core/util/Pair;Lcom/blued/android/framework/utils/upload/qiniu/IUploadTask$IUploadStateListener;ILjava/lang/String;)V
    //   26: aconst_null
    //   27: invokestatic a : (Ljava/lang/String;ILcom/blued/android/core/net/StringHttpResponseHandler;Lcom/blued/android/core/net/IRequestHost;)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	33	finally
  }
  
  abstract void a(String paramString1, String paramString2, double paramDouble);
  
  protected void a(String paramString1, String paramString2, QiniuUploadExtra paramQiniuUploadExtra, int paramInt1, Pair<String, String> paramPair, String paramString3, IUploadTask.IUploadStateListener paramIUploadStateListener, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("开始走上传流程:");
    stringBuilder.append((String)paramPair.first);
    b(stringBuilder.toString());
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      a(paramInt1, paramString3, paramString1, new Pair(paramPair.first, ""));
      if (paramIUploadStateListener != null)
        paramIUploadStateListener.a(); 
      return;
    } 
    if (paramPair == null || TextUtils.isEmpty((CharSequence)paramPair.first)) {
      if (paramIUploadStateListener != null)
        paramIUploadStateListener.a(); 
      return;
    } 
    QiniuUpload qiniuUpload2 = new QiniuUpload();
    QiniuUpload qiniuUpload1 = qiniuUpload2;
    if (paramQiniuUploadExtra != null) {
      qiniuUpload1 = qiniuUpload2;
      if (paramQiniuUploadExtra.upload != null)
        qiniuUpload1 = paramQiniuUploadExtra.upload; 
    } 
    QiniuUploadTools.QiNiuListener qiNiuListener = new QiniuUploadTools.QiNiuListener(this, paramPair, paramInt1, paramString3, paramString1, paramIUploadStateListener, paramInt2, paramString2, paramQiniuUploadExtra, a((String)paramPair.first)) {
        public void a(String param1String) {
          if (this.f <= 0) {
            UploadBaseTask uploadBaseTask1 = this.j;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("上传第一次失败: ");
            stringBuilder1.append((String)this.a.first);
            uploadBaseTask1.c(stringBuilder1.toString());
            this.j.a(this.d, this.g, this.h, this.b, this.a, this.c, this.e, this.f + 1);
            return;
          } 
          Pair<String, String> pair = new Pair(this.a.first, "");
          UploadBaseTask uploadBaseTask = this.j;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("上传第二次失败:");
          stringBuilder.append(pair.toString());
          uploadBaseTask.c(stringBuilder.toString());
          this.j.a(this.b, this.c, this.d, pair);
          IUploadTask.IUploadStateListener iUploadStateListener = this.e;
          if (iUploadStateListener != null)
            iUploadStateListener.a(); 
        }
        
        public void a(String param1String, double param1Double) {
          if (this.i) {
            UploadBaseTask uploadBaseTask = this.j;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onProgress:");
            stringBuilder.append(param1Double);
            stringBuilder.append(" | ");
            stringBuilder.append((String)this.a.first);
            uploadBaseTask.b(stringBuilder.toString());
            this.j.a((String)this.a.first, this.d, param1Double);
          } 
        }
        
        public void a(String param1String1, String param1String2) {
          UploadBaseTask uploadBaseTask = this.j;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("上传完成 url:");
          stringBuilder.append(param1String1);
          stringBuilder.append(" | originalPath:");
          stringBuilder.append((String)this.a.first);
          uploadBaseTask.b(stringBuilder.toString());
          this.j.a(this.b, this.c, this.d, new Pair(this.a.first, param1String1));
          this.j.a(new Runnable(this) {
                public void run() {
                  if (this.a.e != null)
                    this.a.e.a(); 
                }
              });
        }
        
        public boolean a() {
          return this.j.m;
        }
      };
    QiniuUploadUtils.a(paramInt1, qiniuUpload1.host, qiniuUpload1.backup, paramString3, paramString1, paramString2, qiNiuListener);
  }
  
  protected void a(String paramString1, String paramString2, QiniuUploadExtra paramQiniuUploadExtra, Pair<String, String> paramPair, IUploadTask.IUploadStateListener paramIUploadStateListener, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder;
    if (!TextUtils.isEmpty((CharSequence)paramPair.second)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("检测当前图已上传完成 更新记录:");
      stringBuilder.append((String)paramPair.first);
      b(stringBuilder.toString());
      a(0, (String)paramPair.first, paramString1, new Pair(paramPair.first, paramPair.second));
      if (paramIUploadStateListener != null) {
        paramIUploadStateListener.a();
        return;
      } 
    } else {
      String str = RecyclingUtils.e((String)paramPair.first);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("压缩图:");
      stringBuilder1.append((String)paramPair.first);
      stringBuilder1.append(" | 压缩后地址：");
      stringBuilder1.append(str);
      b(stringBuilder1.toString());
      Houyi.a().a((String)paramPair.first, str).a(new Houyi.OnCompressListener(this, paramString1, (String)stringBuilder, paramQiniuUploadExtra, paramPair, str, paramIUploadStateListener, paramInt1, paramInt2) {
            public void a() {}
            
            public void a(String param1String) {
              UploadBaseTask uploadBaseTask = this.i;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("压缩完成:");
              stringBuilder.append(param1String);
              uploadBaseTask.b(stringBuilder.toString());
              this.i.a(this.a, this.b, this.c, 0, this.d, this.e, this.f, 0);
            }
            
            public void a(Throwable param1Throwable) {
              if (this.g <= 1) {
                UploadBaseTask uploadBaseTask = this.i;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("第一次压缩失败:");
                stringBuilder.append((String)this.d.first);
                stringBuilder.append(" | ");
                stringBuilder.append(param1Throwable.toString());
                uploadBaseTask.c(stringBuilder.toString());
                this.i.a(this.a, this.b, this.c, this.d, this.f, this.g + 1, this.h);
                return;
              } 
              UploadBaseTask uploadBaseTask2 = this.i;
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("第二次压缩失败:");
              stringBuilder2.append((String)this.d.first);
              stringBuilder2.append(" | ");
              stringBuilder2.append(param1Throwable.toString());
              uploadBaseTask2.c(stringBuilder2.toString());
              Pair<String, String> pair = new Pair(this.d.first, "");
              this.i.a(0, (String)this.d.first, this.a, pair);
              UploadBaseTask uploadBaseTask1 = this.i;
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("回调上传失败:");
              stringBuilder1.append((String)this.d.first);
              uploadBaseTask1.b(stringBuilder1.toString());
              this.i.a(new Runnable(this) {
                    public void run() {
                      if (this.a.f != null)
                        this.a.f.a(); 
                    }
                  });
            }
          }).a();
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  protected boolean a(BluedToken paramBluedToken, QiniuUploadExtra paramQiniuUploadExtra) {
    if (paramBluedToken != null && !TextUtils.isEmpty(paramBluedToken.token)) {
      if (AppInfo.p())
        return true; 
      if (paramQiniuUploadExtra != null && paramQiniuUploadExtra.upload != null) {
        QiniuUpload qiniuUpload = paramQiniuUploadExtra.upload;
        if (qiniuUpload != null && !TextUtils.isEmpty(qiniuUpload.host))
          return true; 
      } 
    } 
    return false;
  }
  
  abstract boolean a(String paramString);
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield m : Z
    //   7: aload_0
    //   8: getfield n : Lcom/blued/android/framework/utils/upload/qiniu/UploadProcessManager;
    //   11: ifnull -> 21
    //   14: aload_0
    //   15: getfield n : Lcom/blued/android/framework/utils/upload/qiniu/UploadProcessManager;
    //   18: invokevirtual c : ()V
    //   21: aload_0
    //   22: getfield d : Ljava/util/List;
    //   25: ifnull -> 37
    //   28: aload_0
    //   29: getfield d : Ljava/util/List;
    //   32: invokeinterface clear : ()V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	40	finally
    //   21	37	40	finally
  }
  
  abstract void b(IUploadTask.IUploadStateListener paramIUploadStateListener);
  
  protected void b(String paramString) {
    if (AppInfo.m())
      Logger.c(MediaSender.a, new Object[] { paramString }); 
  }
  
  protected void c(String paramString) {
    if (AppInfo.m())
      Logger.e(MediaSender.a, new Object[] { paramString }); 
  }
  
  protected boolean c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc_w '判断是否有下一个上传文件 mUploadRecordList.size():'
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_2
    //   19: aload_0
    //   20: getfield d : Ljava/util/List;
    //   23: invokeinterface size : ()I
    //   28: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual toString : ()Ljava/lang/String;
    //   37: invokevirtual b : (Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield d : Ljava/util/List;
    //   44: invokeinterface size : ()I
    //   49: istore_1
    //   50: iload_1
    //   51: ifle -> 58
    //   54: aload_0
    //   55: monitorexit
    //   56: iconst_1
    //   57: ireturn
    //   58: aload_0
    //   59: monitorexit
    //   60: iconst_0
    //   61: ireturn
    //   62: astore_2
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_2
    //   66: athrow
    // Exception table:
    //   from	to	target	type
    //   2	50	62	finally
  }
  
  protected Pair<String, String> d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Ljava/util/List;
    //   6: invokeinterface size : ()I
    //   11: ifle -> 70
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore_1
    //   22: aload_1
    //   23: ldc_w '获取下一个文件 mUploadRecordList.size():'
    //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: aload_0
    //   32: getfield d : Ljava/util/List;
    //   35: invokeinterface size : ()I
    //   40: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_0
    //   45: aload_1
    //   46: invokevirtual toString : ()Ljava/lang/String;
    //   49: invokevirtual b : (Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield d : Ljava/util/List;
    //   56: iconst_0
    //   57: invokeinterface remove : (I)Ljava/lang/Object;
    //   62: checkcast androidx/core/util/Pair
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: areturn
    //   70: aload_0
    //   71: monitorexit
    //   72: aconst_null
    //   73: areturn
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Exception table:
    //   from	to	target	type
    //   2	66	74	finally
  }
  
  protected void e() {
    UploadProcessManager uploadProcessManager = this.n;
    if (uploadProcessManager != null)
      uploadProcessManager.a(); 
  }
  
  protected void f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Ljava/util/List;
    //   6: invokeinterface size : ()I
    //   11: aload_0
    //   12: getfield c : Ljava/util/List;
    //   15: invokeinterface size : ()I
    //   20: if_icmplt -> 306
    //   23: iconst_1
    //   24: istore_2
    //   25: iload_2
    //   26: istore_1
    //   27: aload_0
    //   28: getfield h : Ljava/util/List;
    //   31: ifnull -> 50
    //   34: iload_2
    //   35: istore_1
    //   36: aload_0
    //   37: getfield h : Ljava/util/List;
    //   40: invokeinterface size : ()I
    //   45: ifle -> 50
    //   48: iconst_0
    //   49: istore_1
    //   50: new java/util/ArrayList
    //   53: dup
    //   54: invokespecial <init> : ()V
    //   57: astore #4
    //   59: ldc_w ''
    //   62: astore_3
    //   63: aload_0
    //   64: getfield c : Ljava/util/List;
    //   67: invokeinterface iterator : ()Ljava/util/Iterator;
    //   72: astore #5
    //   74: aload #5
    //   76: invokeinterface hasNext : ()Z
    //   81: ifeq -> 218
    //   84: aload #5
    //   86: invokeinterface next : ()Ljava/lang/Object;
    //   91: checkcast androidx/core/util/Pair
    //   94: astore #6
    //   96: aload_0
    //   97: getfield e : Ljava/util/List;
    //   100: invokeinterface iterator : ()Ljava/util/Iterator;
    //   105: astore #7
    //   107: aload #7
    //   109: invokeinterface hasNext : ()Z
    //   114: ifeq -> 74
    //   117: aload #7
    //   119: invokeinterface next : ()Ljava/lang/Object;
    //   124: checkcast androidx/core/util/Pair
    //   127: astore #8
    //   129: aload #8
    //   131: ifnull -> 107
    //   134: aload #6
    //   136: getfield first : Ljava/lang/Object;
    //   139: checkcast java/lang/String
    //   142: aload #8
    //   144: getfield first : Ljava/lang/Object;
    //   147: invokevirtual equals : (Ljava/lang/Object;)Z
    //   150: ifeq -> 107
    //   153: new androidx/core/util/Pair
    //   156: dup
    //   157: aload #6
    //   159: getfield first : Ljava/lang/Object;
    //   162: aload #8
    //   164: getfield second : Ljava/lang/Object;
    //   167: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   170: astore #6
    //   172: aload #4
    //   174: aload #6
    //   176: invokeinterface add : (Ljava/lang/Object;)Z
    //   181: pop
    //   182: new java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial <init> : ()V
    //   189: astore #7
    //   191: aload #7
    //   193: aload_3
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload #7
    //   200: aload #6
    //   202: invokevirtual toString : ()Ljava/lang/String;
    //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload #7
    //   211: invokevirtual toString : ()Ljava/lang/String;
    //   214: astore_3
    //   215: goto -> 74
    //   218: aload_0
    //   219: invokevirtual e : ()V
    //   222: new java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial <init> : ()V
    //   229: astore #5
    //   231: aload #5
    //   233: ldc_w '任务完成 taskId: '
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload #5
    //   242: aload_0
    //   243: invokevirtual a : ()Ljava/lang/String;
    //   246: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload #5
    //   252: ldc_w ' | isSuccess:'
    //   255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload #5
    //   261: iload_1
    //   262: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload #5
    //   268: ldc_w ' | uploadLocalPathToUrlList:'
    //   271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload #5
    //   277: aload_3
    //   278: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_0
    //   283: aload #5
    //   285: invokevirtual toString : ()Ljava/lang/String;
    //   288: invokevirtual b : (Ljava/lang/String;)V
    //   291: aload_0
    //   292: new com/blued/android/framework/utils/upload/qiniu/UploadBaseTask$5
    //   295: dup
    //   296: aload_0
    //   297: iload_1
    //   298: aload #4
    //   300: invokespecial <init> : (Lcom/blued/android/framework/utils/upload/qiniu/UploadBaseTask;ZLjava/util/List;)V
    //   303: invokevirtual a : (Ljava/lang/Runnable;)V
    //   306: aload_0
    //   307: monitorexit
    //   308: return
    //   309: astore_3
    //   310: aload_0
    //   311: monitorexit
    //   312: aload_3
    //   313: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	309	finally
    //   27	34	309	finally
    //   36	48	309	finally
    //   50	59	309	finally
    //   63	74	309	finally
    //   74	107	309	finally
    //   107	129	309	finally
    //   134	215	309	finally
    //   218	306	309	finally
  }
  
  public class Consumer extends ThreadExecutor {
    public Consumer(UploadBaseTask this$0, String param1String) {
      super(param1String);
    }
    
    public void execute() {
      UploadBaseTask.a(this.a, getThreadName());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\qiniu\UploadBaseTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */