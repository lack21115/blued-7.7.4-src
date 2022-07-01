package com.soft.blued.ui.msg.manager;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.google.common.reflect.TypeToken;
import com.soft.blued.ui.msg.MsgPreferences;
import com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback;
import com.soft.blued.ui.msg.model.MsgRecentPhotoInfo;
import com.soft.blued.utils.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RecentPhotoManager {
  private static final String a;
  
  private static int b = 5;
  
  private static int c = 5;
  
  private Vector<MsgRecentPhotoInfo> d = new Vector<MsgRecentPhotoInfo>();
  
  private Vector<MsgRecentPhotoInfo> e = new Vector<MsgRecentPhotoInfo>();
  
  public RecentPhotoManager() {
    ThreadManager.a().a(new ThreadExecutor(this, "RecentPhoto_Thread") {
          public void execute() {
            RecentPhotoManager.a(this.a);
          }
        });
  }
  
  private void a(List<MsgRecentPhotoInfo> paramList) {
    try {
      String str = AppInfo.f().toJson(paramList);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    if (!TextUtils.isEmpty((CharSequence)exception))
      MsgPreferences.a((String)exception); 
  }
  
  private void d() {
    String str = MsgPreferences.b();
    if (TextUtils.isEmpty(str))
      return; 
    List<MsgRecentPhotoInfo> list = (List)AppInfo.f().fromJson(str, (new TypeToken<ArrayList<MsgRecentPhotoInfo>>(this) {
        
        }).c());
    if (list != null) {
      if (list.size() > 0)
        for (int k = 0; k < list.size(); k = SYNTHETIC_LOCAL_VARIABLE_2 + 1) {
          MsgRecentPhotoInfo msgRecentPhotoInfo = list.get(k);
          if (msgRecentPhotoInfo == null) {
            list.remove(k);
          } else {
            int n = k;
            if (!(new File(msgRecentPhotoInfo.imgPath)).exists()) {
              list.remove(k);
            } else {
              continue;
            } 
          } 
          int m = k - 1;
          continue;
        }  
      int i = list.size();
      int j = b;
      null = list;
      if (i > j)
        null = list.subList(0, j); 
      synchronized (this.e) {
        this.d.clear();
        this.d.addAll(null);
        e();
        return;
      } 
    } 
  }
  
  private void e() {
    synchronized (this.e) {
      this.e.clear();
      int i = Math.min(this.d.size(), c);
      if (i > 0)
        this.e.addAll(this.d.subList(0, i)); 
      return;
    } 
  }
  
  public MsgRecentPhotoInfo a(String paramString, int paramInt1, int paramInt2) {
    if (!TextUtils.isEmpty(paramString)) {
      MsgRecentPhotoInfo msgRecentPhotoInfo = new MsgRecentPhotoInfo();
      msgRecentPhotoInfo.imgPath = paramString;
      msgRecentPhotoInfo.width = paramInt1;
      msgRecentPhotoInfo.height = paramInt2;
      return msgRecentPhotoInfo;
    } 
    return null;
  }
  
  public List<MsgRecentPhotoInfo> a() {
    return this.e;
  }
  
  public void a(IRecentPhotoAdapterCallback.IGetPhotoListCallback paramIGetPhotoListCallback) {
    if (this.e.size() <= 0) {
      ThreadManager.a().a(new ThreadExecutor(this, "RecentPhoto_Thread", paramIGetPhotoListCallback) {
            public void execute() {
              RecentPhotoManager.a(this.b);
              AppInfo.n().post(new Runnable(this) {
                    public void run() {
                      if (this.a.a != null)
                        this.a.a.a(RecentPhotoManager.b(this.a.b)); 
                    }
                  });
            }
          });
      return;
    } 
    if (paramIGetPhotoListCallback != null)
      paramIGetPhotoListCallback.a(this.e); 
  }
  
  public void a(MsgRecentPhotoInfo paramMsgRecentPhotoInfo) {
    this.d.remove(paramMsgRecentPhotoInfo);
    this.e.remove(paramMsgRecentPhotoInfo);
    ThreadManager.a().a((Runnable)new ThreadExecutor(this, "RecentPhoto_Thread") {
          public void execute() {
            RecentPhotoManager recentPhotoManager = this.a;
            RecentPhotoManager.a(recentPhotoManager, RecentPhotoManager.c(recentPhotoManager));
          }
        });
  }
  
  public void a(MsgRecentPhotoInfo paramMsgRecentPhotoInfo, IRecordPicCallback paramIRecordPicCallback) {
    if (paramMsgRecentPhotoInfo == null || TextUtils.isEmpty(paramMsgRecentPhotoInfo.imgPath)) {
      Logger.c(a, new Object[] { "photoInfo == null || TextUtils.isEmpty(photoInfo.imgPath) ！！！" });
      return;
    } 
    ThreadManager.a().a((Runnable)new ThreadExecutor(this, "RecentPhoto_Thread", paramMsgRecentPhotoInfo, paramIRecordPicCallback) {
          public void execute() {
            // Byte code:
            //   0: aload_0
            //   1: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   4: getfield imgPath : Ljava/lang/String;
            //   7: invokestatic c : (Ljava/lang/String;)I
            //   10: istore_2
            //   11: iload_2
            //   12: bipush #90
            //   14: if_icmpeq -> 34
            //   17: iload_2
            //   18: sipush #180
            //   21: if_icmpeq -> 66
            //   24: iload_2
            //   25: sipush #270
            //   28: if_icmpeq -> 34
            //   31: goto -> 147
            //   34: aload_0
            //   35: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   38: getfield width : I
            //   41: istore_3
            //   42: aload_0
            //   43: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   46: astore #5
            //   48: aload #5
            //   50: aload #5
            //   52: getfield height : I
            //   55: putfield width : I
            //   58: aload_0
            //   59: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   62: iload_3
            //   63: putfield height : I
            //   66: iload_2
            //   67: aload_0
            //   68: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   71: getfield imgPath : Ljava/lang/String;
            //   74: sipush #1620
            //   77: invokestatic a : (Ljava/lang/String;I)Landroid/graphics/Bitmap;
            //   80: invokestatic a : (ILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
            //   83: astore #5
            //   85: new java/lang/StringBuilder
            //   88: dup
            //   89: invokespecial <init> : ()V
            //   92: astore #6
            //   94: aload #6
            //   96: ldc 'recent'
            //   98: invokestatic e : (Ljava/lang/String;)Ljava/lang/String;
            //   101: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   104: pop
            //   105: aload #6
            //   107: ldc '.jpg'
            //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   112: pop
            //   113: aload #6
            //   115: invokevirtual toString : ()Ljava/lang/String;
            //   118: astore #6
            //   120: aload #5
            //   122: aload #6
            //   124: bipush #100
            //   126: invokestatic a : (Landroid/graphics/Bitmap;Ljava/lang/String;I)V
            //   129: aload_0
            //   130: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   133: aload #6
            //   135: putfield imgPath : Ljava/lang/String;
            //   138: goto -> 147
            //   141: invokestatic a : ()Lcom/blued/android/core/imagecache/MemoryRequest;
            //   144: invokevirtual b : ()V
            //   147: aload_0
            //   148: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   151: getfield height : I
            //   154: i2f
            //   155: fconst_1
            //   156: fmul
            //   157: aload_0
            //   158: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   161: getfield width : I
            //   164: i2f
            //   165: fdiv
            //   166: fstore_1
            //   167: iconst_0
            //   168: istore #4
            //   170: fload_1
            //   171: ldc 1.7777778
            //   173: fcmpl
            //   174: ifle -> 188
            //   177: aload_0
            //   178: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   181: iconst_1
            //   182: putfield isNormalImg : I
            //   185: goto -> 232
            //   188: aload_0
            //   189: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   192: getfield width : I
            //   195: i2f
            //   196: fconst_1
            //   197: fmul
            //   198: aload_0
            //   199: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   202: getfield height : I
            //   205: i2f
            //   206: fdiv
            //   207: ldc 1.7777778
            //   209: fcmpl
            //   210: ifle -> 224
            //   213: aload_0
            //   214: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   217: iconst_2
            //   218: putfield isNormalImg : I
            //   221: goto -> 232
            //   224: aload_0
            //   225: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   228: iconst_0
            //   229: putfield isNormalImg : I
            //   232: aload_0
            //   233: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   236: invokestatic b : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   239: astore #5
            //   241: aload #5
            //   243: monitorenter
            //   244: aload_0
            //   245: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   248: invokestatic c : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   251: invokevirtual size : ()I
            //   254: ifle -> 362
            //   257: iconst_0
            //   258: istore_2
            //   259: iload_2
            //   260: aload_0
            //   261: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   264: invokestatic c : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   267: invokevirtual size : ()I
            //   270: if_icmpge -> 362
            //   273: aload_0
            //   274: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   277: invokestatic c : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   280: iload_2
            //   281: invokevirtual get : (I)Ljava/lang/Object;
            //   284: checkcast com/soft/blued/ui/msg/model/MsgRecentPhotoInfo
            //   287: astore #6
            //   289: iload_2
            //   290: istore_3
            //   291: aload #6
            //   293: ifnull -> 609
            //   296: iload_2
            //   297: istore_3
            //   298: aload #6
            //   300: getfield imgPath : Ljava/lang/String;
            //   303: aload_0
            //   304: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   307: getfield imgPath : Ljava/lang/String;
            //   310: invokevirtual equals : (Ljava/lang/Object;)Z
            //   313: ifeq -> 609
            //   316: aload #6
            //   318: getfield isPin : Z
            //   321: ifne -> 343
            //   324: aload_0
            //   325: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   328: invokestatic c : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   331: iload_2
            //   332: invokevirtual remove : (I)Ljava/lang/Object;
            //   335: pop
            //   336: iload_2
            //   337: iconst_1
            //   338: isub
            //   339: istore_3
            //   340: goto -> 609
            //   343: aload_0
            //   344: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   347: iconst_1
            //   348: putfield isPin : Z
            //   351: aload #6
            //   353: iconst_0
            //   354: putfield isSelected : Z
            //   357: iload_2
            //   358: istore_3
            //   359: goto -> 609
            //   362: aload_0
            //   363: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   366: getfield isPin : Z
            //   369: ifne -> 567
            //   372: aload_0
            //   373: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   376: invokestatic c : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   379: aload_0
            //   380: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   383: invokevirtual contains : (Ljava/lang/Object;)Z
            //   386: ifne -> 567
            //   389: iconst_0
            //   390: istore_2
            //   391: iload_2
            //   392: aload_0
            //   393: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   396: invokestatic c : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   399: invokevirtual size : ()I
            //   402: if_icmpge -> 623
            //   405: aload_0
            //   406: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   409: invokestatic c : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   412: iload_2
            //   413: invokevirtual get : (I)Ljava/lang/Object;
            //   416: checkcast com/soft/blued/ui/msg/model/MsgRecentPhotoInfo
            //   419: getfield isPin : Z
            //   422: ifne -> 616
            //   425: goto -> 428
            //   428: iload_2
            //   429: iconst_m1
            //   430: if_icmpeq -> 448
            //   433: aload_0
            //   434: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   437: invokestatic c : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   440: iload_2
            //   441: aload_0
            //   442: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   445: invokevirtual add : (ILjava/lang/Object;)V
            //   448: iload_2
            //   449: iconst_m1
            //   450: if_icmpne -> 484
            //   453: aload_0
            //   454: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   457: invokestatic c : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   460: invokevirtual size : ()I
            //   463: invokestatic c : ()I
            //   466: if_icmpge -> 484
            //   469: aload_0
            //   470: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   473: invokestatic c : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   476: aload_0
            //   477: getfield a : Lcom/soft/blued/ui/msg/model/MsgRecentPhotoInfo;
            //   480: invokevirtual add : (Ljava/lang/Object;)Z
            //   483: pop
            //   484: aload_0
            //   485: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   488: invokestatic c : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   491: invokevirtual size : ()I
            //   494: invokestatic c : ()I
            //   497: if_icmple -> 553
            //   500: new java/util/Vector
            //   503: dup
            //   504: invokespecial <init> : ()V
            //   507: astore #6
            //   509: iload #4
            //   511: istore_2
            //   512: iload_2
            //   513: invokestatic c : ()I
            //   516: if_icmpge -> 543
            //   519: aload #6
            //   521: aload_0
            //   522: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   525: invokestatic c : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   528: iload_2
            //   529: invokevirtual get : (I)Ljava/lang/Object;
            //   532: invokevirtual add : (Ljava/lang/Object;)Z
            //   535: pop
            //   536: iload_2
            //   537: iconst_1
            //   538: iadd
            //   539: istore_2
            //   540: goto -> 512
            //   543: aload_0
            //   544: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   547: aload #6
            //   549: invokestatic a : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;Ljava/util/Vector;)Ljava/util/Vector;
            //   552: pop
            //   553: aload_0
            //   554: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   557: aload_0
            //   558: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   561: invokestatic c : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)Ljava/util/Vector;
            //   564: invokestatic a : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;Ljava/util/List;)V
            //   567: aload #5
            //   569: monitorexit
            //   570: aload_0
            //   571: getfield c : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;
            //   574: invokestatic d : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;)V
            //   577: aload_0
            //   578: getfield b : Lcom/soft/blued/ui/msg/manager/RecentPhotoManager$IRecordPicCallback;
            //   581: astore #5
            //   583: aload #5
            //   585: ifnull -> 595
            //   588: aload #5
            //   590: invokeinterface a : ()V
            //   595: return
            //   596: astore #6
            //   598: aload #5
            //   600: monitorexit
            //   601: aload #6
            //   603: athrow
            //   604: astore #5
            //   606: goto -> 141
            //   609: iload_3
            //   610: iconst_1
            //   611: iadd
            //   612: istore_2
            //   613: goto -> 259
            //   616: iload_2
            //   617: iconst_1
            //   618: iadd
            //   619: istore_2
            //   620: goto -> 391
            //   623: iconst_m1
            //   624: istore_2
            //   625: goto -> 428
            // Exception table:
            //   from	to	target	type
            //   66	138	604	java/lang/OutOfMemoryError
            //   244	257	596	finally
            //   259	289	596	finally
            //   298	336	596	finally
            //   343	357	596	finally
            //   362	389	596	finally
            //   391	425	596	finally
            //   433	448	596	finally
            //   453	484	596	finally
            //   484	509	596	finally
            //   512	536	596	finally
            //   543	553	596	finally
            //   553	567	596	finally
            //   567	570	596	finally
            //   598	601	596	finally
          }
        });
  }
  
  public void b() {
    this.d.clear();
    this.e.clear();
    MsgPreferences.a(null);
  }
  
  public void b(IRecentPhotoAdapterCallback.IGetPhotoListCallback paramIGetPhotoListCallback) {
    ThreadManager.a().a((Runnable)new ThreadExecutor(this, "GetSelectPhotoThreadName", paramIGetPhotoListCallback) {
          public void execute() {
            ArrayList<MsgRecentPhotoInfo> arrayList = new ArrayList();
            ArrayList arrayList1 = new ArrayList();
            arrayList1.addAll(RecentPhotoManager.b(this.b));
            for (MsgRecentPhotoInfo msgRecentPhotoInfo : arrayList1) {
              if (msgRecentPhotoInfo != null && msgRecentPhotoInfo.isSelected)
                arrayList.add(msgRecentPhotoInfo); 
            } 
            IRecentPhotoAdapterCallback.IGetPhotoListCallback iGetPhotoListCallback = this.a;
            if (iGetPhotoListCallback != null)
              iGetPhotoListCallback.a(arrayList); 
          }
        });
  }
  
  public void b(MsgRecentPhotoInfo paramMsgRecentPhotoInfo) {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : Ljava/util/Vector;
    //   4: aload_1
    //   5: invokevirtual remove : (Ljava/lang/Object;)Z
    //   8: pop
    //   9: aload_0
    //   10: getfield e : Ljava/util/Vector;
    //   13: aload_1
    //   14: invokevirtual remove : (Ljava/lang/Object;)Z
    //   17: pop
    //   18: aload_1
    //   19: aload_1
    //   20: getfield isPin : Z
    //   23: iconst_1
    //   24: ixor
    //   25: putfield isPin : Z
    //   28: aload_1
    //   29: getfield isPin : Z
    //   32: istore #4
    //   34: iconst_0
    //   35: istore_2
    //   36: iload #4
    //   38: ifeq -> 62
    //   41: aload_0
    //   42: getfield d : Ljava/util/Vector;
    //   45: iconst_0
    //   46: aload_1
    //   47: invokevirtual add : (ILjava/lang/Object;)V
    //   50: aload_0
    //   51: getfield e : Ljava/util/Vector;
    //   54: iconst_0
    //   55: aload_1
    //   56: invokevirtual add : (ILjava/lang/Object;)V
    //   59: goto -> 188
    //   62: iload_2
    //   63: aload_0
    //   64: getfield e : Ljava/util/Vector;
    //   67: invokevirtual size : ()I
    //   70: if_icmpge -> 100
    //   73: aload_0
    //   74: getfield e : Ljava/util/Vector;
    //   77: iload_2
    //   78: invokevirtual get : (I)Ljava/lang/Object;
    //   81: checkcast com/soft/blued/ui/msg/model/MsgRecentPhotoInfo
    //   84: getfield isPin : Z
    //   87: ifne -> 93
    //   90: goto -> 102
    //   93: iload_2
    //   94: iconst_1
    //   95: iadd
    //   96: istore_2
    //   97: goto -> 62
    //   100: iconst_m1
    //   101: istore_2
    //   102: iload_2
    //   103: iconst_m1
    //   104: if_icmpne -> 159
    //   107: aload_0
    //   108: getfield e : Ljava/util/Vector;
    //   111: aload_1
    //   112: invokevirtual add : (Ljava/lang/Object;)Z
    //   115: pop
    //   116: aload_0
    //   117: getfield d : Ljava/util/Vector;
    //   120: invokevirtual size : ()I
    //   123: istore_2
    //   124: getstatic com/soft/blued/ui/msg/manager/RecentPhotoManager.c : I
    //   127: istore_3
    //   128: iload_2
    //   129: iload_3
    //   130: if_icmplt -> 147
    //   133: aload_0
    //   134: getfield d : Ljava/util/Vector;
    //   137: iload_3
    //   138: iconst_1
    //   139: isub
    //   140: aload_1
    //   141: invokevirtual add : (ILjava/lang/Object;)V
    //   144: goto -> 188
    //   147: aload_0
    //   148: getfield d : Ljava/util/Vector;
    //   151: aload_1
    //   152: invokevirtual add : (Ljava/lang/Object;)Z
    //   155: pop
    //   156: goto -> 188
    //   159: aload_0
    //   160: getfield e : Ljava/util/Vector;
    //   163: iload_2
    //   164: aload_1
    //   165: invokevirtual add : (ILjava/lang/Object;)V
    //   168: aload_0
    //   169: getfield d : Ljava/util/Vector;
    //   172: invokevirtual size : ()I
    //   175: iload_2
    //   176: if_icmple -> 188
    //   179: aload_0
    //   180: getfield d : Ljava/util/Vector;
    //   183: iload_2
    //   184: aload_1
    //   185: invokevirtual add : (ILjava/lang/Object;)V
    //   188: invokestatic a : ()Lcom/blued/android/framework/pool/ThreadManager;
    //   191: new com/soft/blued/ui/msg/manager/RecentPhotoManager$7
    //   194: dup
    //   195: aload_0
    //   196: ldc 'RecentPhoto_Thread'
    //   198: invokespecial <init> : (Lcom/soft/blued/ui/msg/manager/RecentPhotoManager;Ljava/lang/String;)V
    //   201: invokevirtual a : (Ljava/lang/Runnable;)V
    //   204: return
  }
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CHAT_");
    stringBuilder.append(RecentPhotoManager.class.getSimpleName());
    a = stringBuilder.toString();
  }
  
  public static interface IRecordPicCallback {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\manager\RecentPhotoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */