package com.blued.android.framework.utils.upload.qiniu;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.utils.upload.qiniu.pool.UploadThreadManager;
import com.blued.android.module.base.shortvideo.ITranscodingVideoListener;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;

public class UploadVideoTask extends UploadBaseTask {
  private Pair<String, String> p;
  
  private Pair<String, String> q;
  
  private String r;
  
  private final int s = 50;
  
  private double t = 0.0D;
  
  private boolean u = true;
  
  private String v;
  
  private String w;
  
  public UploadVideoTask(String paramString1, String paramString2, String paramString3, Pair<String, String> paramPair1, Pair<String, String> paramPair2, SenderListener paramSenderListener) {
    super(paramString1, paramSenderListener);
    this.p = paramPair1;
    this.q = paramPair2;
    this.w = paramString2;
    this.v = paramString3;
  }
  
  private void g() {
    // Byte code:
    //   0: aload_0
    //   1: getfield p : Landroidx/core/util/Pair;
    //   4: astore #5
    //   6: aload #5
    //   8: ifnull -> 128
    //   11: aload #5
    //   13: getfield first : Ljava/lang/Object;
    //   16: checkcast java/lang/CharSequence
    //   19: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   22: ifne -> 128
    //   25: aload_0
    //   26: getfield p : Landroidx/core/util/Pair;
    //   29: getfield first : Ljava/lang/Object;
    //   32: checkcast java/lang/String
    //   35: astore #5
    //   37: new java/io/File
    //   40: dup
    //   41: aload #5
    //   43: invokespecial <init> : (Ljava/lang/String;)V
    //   46: astore #6
    //   48: aload #6
    //   50: invokevirtual exists : ()Z
    //   53: ifeq -> 128
    //   56: aload_0
    //   57: getfield c : Ljava/util/List;
    //   60: aload_0
    //   61: getfield p : Landroidx/core/util/Pair;
    //   64: invokeinterface add : (Ljava/lang/Object;)Z
    //   69: pop
    //   70: aload_0
    //   71: getfield d : Ljava/util/List;
    //   74: new androidx/core/util/Pair
    //   77: dup
    //   78: aload #5
    //   80: ldc '0'
    //   82: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   85: invokeinterface add : (Ljava/lang/Object;)Z
    //   90: pop
    //   91: aload #6
    //   93: invokevirtual length : ()J
    //   96: lstore_3
    //   97: aload_0
    //   98: aload_0
    //   99: getfield k : J
    //   102: lload_3
    //   103: ladd
    //   104: putfield k : J
    //   107: aload_0
    //   108: getfield f : Ljava/util/Map;
    //   111: aload #5
    //   113: lload_3
    //   114: invokestatic valueOf : (J)Ljava/lang/Long;
    //   117: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   122: pop
    //   123: iconst_1
    //   124: istore_1
    //   125: goto -> 130
    //   128: iconst_0
    //   129: istore_1
    //   130: aload_0
    //   131: getfield q : Landroidx/core/util/Pair;
    //   134: astore #5
    //   136: iload_1
    //   137: istore_2
    //   138: aload #5
    //   140: ifnull -> 391
    //   143: iload_1
    //   144: istore_2
    //   145: aload #5
    //   147: getfield first : Ljava/lang/Object;
    //   150: checkcast java/lang/CharSequence
    //   153: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   156: ifne -> 391
    //   159: aload_0
    //   160: getfield u : Z
    //   163: ifeq -> 287
    //   166: aload_0
    //   167: getfield q : Landroidx/core/util/Pair;
    //   170: getfield first : Ljava/lang/Object;
    //   173: checkcast java/lang/String
    //   176: astore #5
    //   178: iload_1
    //   179: istore_2
    //   180: aload_0
    //   181: getfield r : Ljava/lang/String;
    //   184: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   187: ifne -> 391
    //   190: new java/io/File
    //   193: dup
    //   194: aload_0
    //   195: getfield r : Ljava/lang/String;
    //   198: invokespecial <init> : (Ljava/lang/String;)V
    //   201: astore #6
    //   203: iload_1
    //   204: istore_2
    //   205: aload #6
    //   207: invokevirtual exists : ()Z
    //   210: ifeq -> 391
    //   213: aload_0
    //   214: getfield c : Ljava/util/List;
    //   217: aload_0
    //   218: getfield q : Landroidx/core/util/Pair;
    //   221: invokeinterface add : (Ljava/lang/Object;)Z
    //   226: pop
    //   227: aload_0
    //   228: getfield d : Ljava/util/List;
    //   231: new androidx/core/util/Pair
    //   234: dup
    //   235: aload #5
    //   237: ldc '1'
    //   239: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   242: invokeinterface add : (Ljava/lang/Object;)Z
    //   247: pop
    //   248: iload_1
    //   249: iconst_1
    //   250: iadd
    //   251: istore_2
    //   252: aload #6
    //   254: invokevirtual length : ()J
    //   257: lstore_3
    //   258: aload_0
    //   259: aload_0
    //   260: getfield k : J
    //   263: lload_3
    //   264: ladd
    //   265: putfield k : J
    //   268: aload_0
    //   269: getfield f : Ljava/util/Map;
    //   272: aload #5
    //   274: lload_3
    //   275: invokestatic valueOf : (J)Ljava/lang/Long;
    //   278: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   283: pop
    //   284: goto -> 391
    //   287: aload_0
    //   288: getfield q : Landroidx/core/util/Pair;
    //   291: getfield first : Ljava/lang/Object;
    //   294: checkcast java/lang/String
    //   297: astore #5
    //   299: new java/io/File
    //   302: dup
    //   303: aload #5
    //   305: invokespecial <init> : (Ljava/lang/String;)V
    //   308: astore #6
    //   310: iload_1
    //   311: istore_2
    //   312: aload #6
    //   314: invokevirtual exists : ()Z
    //   317: ifeq -> 391
    //   320: aload_0
    //   321: getfield c : Ljava/util/List;
    //   324: aload_0
    //   325: getfield q : Landroidx/core/util/Pair;
    //   328: invokeinterface add : (Ljava/lang/Object;)Z
    //   333: pop
    //   334: aload_0
    //   335: getfield d : Ljava/util/List;
    //   338: new androidx/core/util/Pair
    //   341: dup
    //   342: aload #5
    //   344: ldc '1'
    //   346: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   349: invokeinterface add : (Ljava/lang/Object;)Z
    //   354: pop
    //   355: iload_1
    //   356: iconst_1
    //   357: iadd
    //   358: istore_2
    //   359: aload #6
    //   361: invokevirtual length : ()J
    //   364: lstore_3
    //   365: aload_0
    //   366: aload_0
    //   367: getfield k : J
    //   370: lload_3
    //   371: ladd
    //   372: putfield k : J
    //   375: aload_0
    //   376: getfield f : Ljava/util/Map;
    //   379: aload #5
    //   381: lload_3
    //   382: invokestatic valueOf : (J)Ljava/lang/Long;
    //   385: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   390: pop
    //   391: new java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial <init> : ()V
    //   398: astore #5
    //   400: aload #5
    //   402: ldc '需要上传文件 mUploadRecordList.size():'
    //   404: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload #5
    //   410: aload_0
    //   411: getfield d : Ljava/util/List;
    //   414: invokeinterface size : ()I
    //   419: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload_0
    //   424: aload #5
    //   426: invokevirtual toString : ()Ljava/lang/String;
    //   429: invokevirtual b : (Ljava/lang/String;)V
    //   432: aload_0
    //   433: iload_2
    //   434: putfield o : I
    //   437: return
  }
  
  public void a(IUploadTask.IUploadStateListener paramIUploadStateListener) {
    super.a(paramIUploadStateListener);
    this.u = true;
    UploadThreadManager.a().a(new ThreadExecutor(this, "transcodingVideo_thread") {
          public void execute() {
            this.a.b("走转码流程!!!");
            ShortVideoProxy.e().a((String)(UploadVideoTask.a(this.a)).first, new ITranscodingVideoListener(this) {
                  public void a(String param2String, double param2Double) {
                    if (this.a.a.m)
                      return; 
                    param2Double = param2Double * 50.0D / 100.0D;
                    if (param2Double > UploadVideoTask.c(this.a.a)) {
                      UploadVideoTask.a(this.a.a, param2Double);
                      this.a.a.a(param2Double);
                    } 
                  }
                  
                  public void a(String param2String, boolean param2Boolean) {
                    if (!param2Boolean) {
                      this.a.a.b("不需要转码,开启任务消费");
                      UploadVideoTask.a(this.a.a, param2Boolean);
                      UploadVideoTask.b(this.a.a);
                      for (int i = 0; i < this.a.a.o; i++) {
                        UploadVideoTask uploadVideoTask = this.a.a;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("upload_consumer");
                        stringBuilder.append(i);
                        UploadBaseTask.Consumer consumer = new UploadBaseTask.Consumer(uploadVideoTask, stringBuilder.toString());
                        UploadThreadManager.a().a(consumer);
                      } 
                    } else {
                      this.a.a.b("需要转码,转码中...");
                    } 
                  }
                  
                  public void a(boolean param2Boolean, String param2String1, String param2String2) {
                    if (this.a.a.m)
                      return; 
                    int i = 0;
                    if (param2Boolean) {
                      this.a.a.b("需要转码,并转码成功！！！");
                      this.a.a.a(50.0D);
                      UploadVideoTask.a(this.a.a, param2String2);
                      UploadVideoTask.b(this.a.a);
                      while (i < this.a.a.o) {
                        UploadVideoTask uploadVideoTask = this.a.a;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("upload_consumer");
                        stringBuilder.append(i);
                        UploadBaseTask.Consumer consumer = new UploadBaseTask.Consumer(uploadVideoTask, stringBuilder.toString());
                        UploadThreadManager.a().a(consumer);
                        i++;
                      } 
                    } else {
                      this.a.a.c("需要转码,转码失败！！！");
                      this.a.a.e();
                      if (this.a.a.j != null)
                        this.a.a.j.a(this.a.a.a(), false, this.a.a.c); 
                      if (this.a.a.i != null)
                        this.a.a.i.a(); 
                    } 
                  }
                });
          }
        });
  }
  
  public void a(String paramString1, String paramString2, double paramDouble) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast java/lang/Long
    //   15: astore #15
    //   17: lconst_0
    //   18: lstore #11
    //   20: aload #15
    //   22: ifnonnull -> 31
    //   25: lconst_0
    //   26: lstore #9
    //   28: goto -> 38
    //   31: aload #15
    //   33: invokevirtual longValue : ()J
    //   36: lstore #9
    //   38: lload #9
    //   40: lconst_0
    //   41: lcmp
    //   42: ifle -> 242
    //   45: new java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial <init> : ()V
    //   52: astore #15
    //   54: aload #15
    //   56: aload_1
    //   57: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload #15
    //   63: aload_2
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload #15
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: astore_1
    //   74: lload #9
    //   76: l2d
    //   77: dload_3
    //   78: dmul
    //   79: d2l
    //   80: lstore #13
    //   82: aload_0
    //   83: getfield g : Ljava/util/Map;
    //   86: aload_1
    //   87: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast java/lang/Long
    //   95: astore_2
    //   96: aload_2
    //   97: ifnonnull -> 106
    //   100: lconst_0
    //   101: lstore #9
    //   103: goto -> 112
    //   106: aload_2
    //   107: invokevirtual longValue : ()J
    //   110: lstore #9
    //   112: lload #9
    //   114: lload #13
    //   116: lcmp
    //   117: ifge -> 242
    //   120: aload_0
    //   121: getfield g : Ljava/util/Map;
    //   124: aload_1
    //   125: lload #13
    //   127: invokestatic valueOf : (J)Ljava/lang/Long;
    //   130: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: aload_0
    //   137: getfield g : Ljava/util/Map;
    //   140: invokeinterface values : ()Ljava/util/Collection;
    //   145: invokeinterface iterator : ()Ljava/util/Iterator;
    //   150: astore_1
    //   151: lload #11
    //   153: lstore #9
    //   155: aload_1
    //   156: invokeinterface hasNext : ()Z
    //   161: ifeq -> 184
    //   164: lload #9
    //   166: aload_1
    //   167: invokeinterface next : ()Ljava/lang/Object;
    //   172: checkcast java/lang/Long
    //   175: invokevirtual longValue : ()J
    //   178: ladd
    //   179: lstore #9
    //   181: goto -> 155
    //   184: lload #9
    //   186: l2f
    //   187: fconst_1
    //   188: fmul
    //   189: aload_0
    //   190: getfield k : J
    //   193: l2f
    //   194: fdiv
    //   195: fstore #7
    //   197: aload_0
    //   198: getfield u : Z
    //   201: ifeq -> 250
    //   204: bipush #50
    //   206: istore #8
    //   208: goto -> 211
    //   211: fload #7
    //   213: iload #8
    //   215: i2f
    //   216: fmul
    //   217: f2d
    //   218: dstore #5
    //   220: dload #5
    //   222: dstore_3
    //   223: aload_0
    //   224: getfield u : Z
    //   227: ifeq -> 237
    //   230: dload #5
    //   232: ldc2_w 50.0
    //   235: dadd
    //   236: dstore_3
    //   237: aload_0
    //   238: dload_3
    //   239: invokevirtual a : (D)V
    //   242: aload_0
    //   243: monitorexit
    //   244: return
    //   245: astore_1
    //   246: aload_0
    //   247: monitorexit
    //   248: aload_1
    //   249: athrow
    //   250: bipush #100
    //   252: istore #8
    //   254: goto -> 211
    // Exception table:
    //   from	to	target	type
    //   2	17	245	finally
    //   31	38	245	finally
    //   45	74	245	finally
    //   82	96	245	finally
    //   106	112	245	finally
    //   120	151	245	finally
    //   155	181	245	finally
    //   184	204	245	finally
    //   223	230	245	finally
    //   237	242	245	finally
  }
  
  public boolean a(String paramString) {
    long l;
    if (this.f.containsKey(paramString)) {
      l = ((Long)this.f.get(paramString)).longValue();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("上传文件大小:");
      stringBuilder.append(l);
      b(stringBuilder.toString());
    } else {
      l = 0L;
    } 
    return (l >= 3145728L);
  }
  
  public void b() {
    super.b();
    ShortVideoProxy.e().d();
  }
  
  public void b(IUploadTask.IUploadStateListener paramIUploadStateListener) {
    Pair<String, String> pair = d();
    if (pair != null) {
      b("上传视频任务!!!");
      if (!TextUtils.isEmpty((CharSequence)pair.first)) {
        if (((String)pair.second).equals(String.valueOf(1))) {
          pair = this.q;
          if (pair != null && !TextUtils.isEmpty((CharSequence)pair.first)) {
            b("上传视频");
            if (TextUtils.isEmpty(this.r)) {
              String str = this.v;
              Pair<String, String> pair1 = this.q;
              a(str, 1, pair1, (String)pair1.first, paramIUploadStateListener);
              return;
            } 
            a(this.v, 1, this.q, this.r, paramIUploadStateListener);
            return;
          } 
          b("视频文件路径有错");
          a(1, "", "", this.q);
          if (paramIUploadStateListener != null) {
            paramIUploadStateListener.a();
            return;
          } 
        } else {
          b("上传视频封面");
          a(this.w, 0, true, this.p, paramIUploadStateListener);
          return;
        } 
      } else if (paramIUploadStateListener != null) {
        paramIUploadStateListener.a();
        return;
      } 
    } else if (paramIUploadStateListener != null) {
      paramIUploadStateListener.a();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\qiniu\UploadVideoTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */