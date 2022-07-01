package com.blued.android.module.live_china.manager;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.liveForMsg.LiveMsgManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.observer.BeansRefreshObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GiftAnimManager extends Thread {
  private static long P = System.currentTimeMillis();
  
  public static String c = "";
  
  public static long d;
  
  private LiveMsgManager A;
  
  private Anim1Runnable B = new Anim1Runnable();
  
  private Anim2Runnable C = new Anim2Runnable();
  
  private LiveGiftModel D;
  
  private LiveGiftModel E;
  
  private List<ChattingModel> F = Collections.synchronizedList(new LinkedList<ChattingModel>());
  
  private List<LiveGiftModel> G = Collections.synchronizedList(new LinkedList<LiveGiftModel>());
  
  private List<LiveGiftModel> H = Collections.synchronizedList(new LinkedList<LiveGiftModel>());
  
  private List<LiveGiftModel> I = new ArrayList<LiveGiftModel>();
  
  private List<LiveGiftModel> J = new ArrayList<LiveGiftModel>();
  
  private boolean K;
  
  private boolean L;
  
  private GiftHandler M;
  
  private BatchCountDownTimer1 N;
  
  private BatchCountDownTimer2 O;
  
  public boolean a = true;
  
  public boolean b = true;
  
  private boolean e = false;
  
  private LinearLayout f;
  
  private View g;
  
  private View h;
  
  private ImageView i;
  
  private ImageView j;
  
  private ImageView k;
  
  private ImageView l;
  
  private TextView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private ImageView q;
  
  private ImageView r;
  
  private ImageView s;
  
  private ImageView t;
  
  private TextView u;
  
  private TextView v;
  
  private LinearLayout w;
  
  private LinearLayout x;
  
  private LoadOptions y;
  
  private LoadOptions z;
  
  public GiftAnimManager() {
    h();
  }
  
  private void a(View paramView) {
    a(paramView, (LiveGiftModel)null);
  }
  
  private void a(View paramView, LiveGiftModel paramLiveGiftModel) {
    float f;
    if (f(paramLiveGiftModel)) {
      f = 1.5F;
    } else {
      f = 3.0F;
    } 
    ScaleAnimation scaleAnimation1 = new ScaleAnimation(f, 0.5F, f, 0.5F, 1, 0.5F, 1, 0.5F);
    scaleAnimation1.setDuration(250L);
    ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
    scaleAnimation2.setDuration(100L);
    scaleAnimation1.setAnimationListener(new Animation.AnimationListener(this, paramView, scaleAnimation2) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.startAnimation((Animation)this.b);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    scaleAnimation2.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {}
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    paramView.startAnimation((Animation)scaleAnimation1);
  }
  
  private void d(ChattingModel paramChattingModel) {
    if (paramChattingModel.msgMapExtra != null) {
      LiveGiftModel liveGiftModel = (LiveGiftModel)paramChattingModel.msgMapExtra.get("gift_model");
    } else {
      try {
        LiveGiftModel liveGiftModel = (LiveGiftModel)AppInfo.f().fromJson(paramChattingModel.getMsgExtra(), LiveGiftModel.class);
      } catch (Exception exception) {
        exception.printStackTrace();
        exception = null;
      } 
    } 
    if (exception != null) {
      StringBuilder stringBuilder;
      LiveGiftModel liveGiftModel = this.D;
      if (liveGiftModel != null && liveGiftModel.hit_id == ((LiveGiftModel)exception).hit_id && this.D.userId == paramChattingModel.fromId) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("和第一条有关系 hit_count：");
        stringBuilder.append(((LiveGiftModel)exception).hit_count);
        stringBuilder.append("-- hit_id：");
        stringBuilder.append(((LiveGiftModel)exception).hit_id);
        stringBuilder.append("-- isPlayHit1 = ");
        stringBuilder.append(this.K);
        LogUtils.c(stringBuilder.toString());
        this.M.removeCallbacks(this.B);
        this.I.add(exception);
        if (!this.K) {
          m();
          return;
        } 
      } else {
        liveGiftModel = this.E;
        if (liveGiftModel != null && liveGiftModel.hit_id == ((LiveGiftModel)exception).hit_id && this.E.userId == ((ChattingModel)stringBuilder).fromId) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("和第二条有关系 hit_count：");
          stringBuilder.append(((LiveGiftModel)exception).hit_count);
          stringBuilder.append("-- hit_id：");
          stringBuilder.append(((LiveGiftModel)exception).hit_id);
          stringBuilder.append("-- isPlayHit2 = ");
          stringBuilder.append(this.L);
          LogUtils.c(stringBuilder.toString());
          this.M.removeCallbacks(this.C);
          this.J.add(exception);
          if (!this.L) {
            n();
            return;
          } 
        } 
      } 
    } else {
      this.a = true;
      this.b = true;
    } 
  }
  
  private void e(ChattingModel paramChattingModel) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield a : Z
    //   7: aload_1
    //   8: getfield msgMapExtra : Ljava/util/Map;
    //   11: ifnull -> 32
    //   14: aload_1
    //   15: getfield msgMapExtra : Ljava/util/Map;
    //   18: ldc 'gift_model'
    //   20: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast com/blued/android/module/live_china/model/LiveGiftModel
    //   28: astore_2
    //   29: goto -> 58
    //   32: invokestatic f : ()Lcom/google/gson/Gson;
    //   35: aload_1
    //   36: invokevirtual getMsgExtra : ()Ljava/lang/String;
    //   39: ldc com/blued/android/module/live_china/model/LiveGiftModel
    //   41: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   44: checkcast com/blued/android/module/live_china/model/LiveGiftModel
    //   47: astore_2
    //   48: goto -> 58
    //   51: astore_2
    //   52: aload_2
    //   53: invokevirtual printStackTrace : ()V
    //   56: aconst_null
    //   57: astore_2
    //   58: aload_2
    //   59: ifnonnull -> 70
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield a : Z
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_2
    //   71: getfield animation : I
    //   74: ifeq -> 431
    //   77: aload_0
    //   78: getfield f : Landroid/widget/LinearLayout;
    //   81: invokevirtual getVisibility : ()I
    //   84: bipush #8
    //   86: if_icmpne -> 92
    //   89: goto -> 431
    //   92: aload_0
    //   93: aload_2
    //   94: putfield D : Lcom/blued/android/module/live_china/model/LiveGiftModel;
    //   97: aload_0
    //   98: getfield D : Lcom/blued/android/module/live_china/model/LiveGiftModel;
    //   101: aload_1
    //   102: getfield fromId : J
    //   105: putfield userId : J
    //   108: aload_0
    //   109: getfield o : Landroid/widget/TextView;
    //   112: new com/blued/android/module/live_china/manager/GiftAnimManager$9
    //   115: dup
    //   116: aload_0
    //   117: aload_1
    //   118: invokespecial <init> : (Lcom/blued/android/module/live_china/manager/GiftAnimManager;Lcom/blued/android/chat/model/ChattingModel;)V
    //   121: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   124: aload_2
    //   125: getfield hit_count : I
    //   128: ifle -> 142
    //   131: aload_0
    //   132: getfield w : Landroid/widget/LinearLayout;
    //   135: iconst_0
    //   136: invokevirtual setVisibility : (I)V
    //   139: goto -> 151
    //   142: aload_0
    //   143: getfield w : Landroid/widget/LinearLayout;
    //   146: bipush #8
    //   148: invokevirtual setVisibility : (I)V
    //   151: aload_0
    //   152: getfield o : Landroid/widget/TextView;
    //   155: aload_1
    //   156: getfield fromNickName : Ljava/lang/String;
    //   159: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   162: aload_0
    //   163: getfield m : Landroid/widget/TextView;
    //   166: astore_3
    //   167: new java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial <init> : ()V
    //   174: astore #4
    //   176: aload #4
    //   178: invokestatic d : ()Landroid/content/Context;
    //   181: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   184: getstatic com/blued/android/module/live_china/R$string.Live_SendPresent_send : I
    //   187: invokevirtual getString : (I)Ljava/lang/String;
    //   190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload #4
    //   196: aload_2
    //   197: getfield name : Ljava/lang/String;
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_3
    //   205: aload #4
    //   207: invokevirtual toString : ()Ljava/lang/String;
    //   210: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   213: aload_0
    //   214: aload_2
    //   215: invokespecial f : (Lcom/blued/android/module/live_china/model/LiveGiftModel;)Z
    //   218: ifne -> 262
    //   221: aload_0
    //   222: getfield u : Landroid/widget/TextView;
    //   225: astore_3
    //   226: new java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial <init> : ()V
    //   233: astore #4
    //   235: aload #4
    //   237: aload_2
    //   238: getfield hit_count : I
    //   241: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload #4
    //   247: ldc ''
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_3
    //   254: aload #4
    //   256: invokevirtual toString : ()Ljava/lang/String;
    //   259: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   262: aconst_null
    //   263: aload_1
    //   264: getfield fromAvatar : Ljava/lang/String;
    //   267: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
    //   270: invokevirtual c : ()Lcom/blued/android/core/image/ImageWrapper;
    //   273: getstatic com/blued/android/module/live_china/R$drawable.user_bg_round : I
    //   276: invokevirtual a : (I)Lcom/blued/android/core/image/ImageWrapper;
    //   279: aload_0
    //   280: getfield q : Landroid/widget/ImageView;
    //   283: invokevirtual a : (Landroid/widget/ImageView;)V
    //   286: ldc_w 'aniGiftView1 gift_pic_url = '
    //   289: aload_2
    //   290: getfield images_static : Ljava/lang/String;
    //   293: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   296: pop
    //   297: aconst_null
    //   298: aload_2
    //   299: getfield images_static : Ljava/lang/String;
    //   302: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
    //   305: getstatic com/blued/android/module/live_china/R$drawable.gift_default_icon : I
    //   308: invokevirtual a : (I)Lcom/blued/android/core/image/ImageWrapper;
    //   311: aload_0
    //   312: getfield s : Landroid/widget/ImageView;
    //   315: invokevirtual a : (Landroid/widget/ImageView;)V
    //   318: invokestatic d : ()Landroid/content/Context;
    //   321: aload_0
    //   322: getfield i : Landroid/widget/ImageView;
    //   325: aload_1
    //   326: getfield fromRichLevel : I
    //   329: invokestatic a : (Landroid/content/Context;Landroid/widget/ImageView;I)I
    //   332: pop
    //   333: aload_1
    //   334: invokestatic b : (Lcom/blued/android/chat/model/ChattingModel;)Lcom/blued/android/module/live_china/model/LiveLiangModel;
    //   337: astore_1
    //   338: aload_1
    //   339: ifnull -> 361
    //   342: aload_1
    //   343: getfield liang_type : I
    //   346: iconst_2
    //   347: if_icmplt -> 361
    //   350: aload_0
    //   351: getfield k : Landroid/widget/ImageView;
    //   354: iconst_0
    //   355: invokevirtual setVisibility : (I)V
    //   358: goto -> 370
    //   361: aload_0
    //   362: getfield k : Landroid/widget/ImageView;
    //   365: bipush #8
    //   367: invokevirtual setVisibility : (I)V
    //   370: invokestatic d : ()Landroid/content/Context;
    //   373: getstatic com/blued/android/module/live_china/R$anim.live_msg_gift_in_from_left : I
    //   376: invokestatic loadAnimation : (Landroid/content/Context;I)Landroid/view/animation/Animation;
    //   379: astore_1
    //   380: aload_0
    //   381: getfield g : Landroid/view/View;
    //   384: aload_1
    //   385: invokevirtual setAnimation : (Landroid/view/animation/Animation;)V
    //   388: aload_1
    //   389: new com/blued/android/module/live_china/manager/GiftAnimManager$10
    //   392: dup
    //   393: aload_0
    //   394: invokespecial <init> : (Lcom/blued/android/module/live_china/manager/GiftAnimManager;)V
    //   397: invokevirtual setAnimationListener : (Landroid/view/animation/Animation$AnimationListener;)V
    //   400: aload_0
    //   401: getfield M : Lcom/blued/android/module/live_china/manager/GiftAnimManager$GiftHandler;
    //   404: aload_0
    //   405: getfield B : Lcom/blued/android/module/live_china/manager/GiftAnimManager$Anim1Runnable;
    //   408: aload_0
    //   409: aload_2
    //   410: invokespecial g : (Lcom/blued/android/module/live_china/model/LiveGiftModel;)J
    //   413: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   416: pop
    //   417: aload_0
    //   418: invokevirtual d : ()V
    //   421: ldc_w '弹道一唤醒线程 继续轮询任务'
    //   424: invokestatic c : (Ljava/lang/String;)I
    //   427: pop
    //   428: aload_0
    //   429: monitorexit
    //   430: return
    //   431: new java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial <init> : ()V
    //   438: astore_1
    //   439: aload_1
    //   440: ldc_w '普通礼物没动画更新弯豆：'
    //   443: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload_1
    //   448: aload_2
    //   449: getfield beans_count : D
    //   452: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: ldc_w 'beans'
    //   459: aload_1
    //   460: invokevirtual toString : ()Ljava/lang/String;
    //   463: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   466: pop
    //   467: invokestatic a : ()Lcom/blued/android/module/live_china/observer/BeansRefreshObserver;
    //   470: aload_2
    //   471: getfield beans_count : D
    //   474: aload_2
    //   475: getfield beans_current_count : D
    //   478: invokevirtual a : (DD)V
    //   481: aload_0
    //   482: iconst_1
    //   483: putfield a : Z
    //   486: aload_0
    //   487: monitorexit
    //   488: return
    //   489: astore_1
    //   490: aload_0
    //   491: monitorexit
    //   492: aload_1
    //   493: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	489	finally
    //   32	48	51	java/lang/Exception
    //   32	48	489	finally
    //   52	56	489	finally
    //   62	67	489	finally
    //   70	89	489	finally
    //   92	139	489	finally
    //   142	151	489	finally
    //   151	262	489	finally
    //   262	338	489	finally
    //   342	358	489	finally
    //   361	370	489	finally
    //   370	428	489	finally
    //   431	486	489	finally
  }
  
  private void f(ChattingModel paramChattingModel) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield b : Z
    //   7: aload_1
    //   8: getfield msgMapExtra : Ljava/util/Map;
    //   11: ifnull -> 32
    //   14: aload_1
    //   15: getfield msgMapExtra : Ljava/util/Map;
    //   18: ldc 'gift_model'
    //   20: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast com/blued/android/module/live_china/model/LiveGiftModel
    //   28: astore_2
    //   29: goto -> 58
    //   32: invokestatic f : ()Lcom/google/gson/Gson;
    //   35: aload_1
    //   36: invokevirtual getMsgExtra : ()Ljava/lang/String;
    //   39: ldc com/blued/android/module/live_china/model/LiveGiftModel
    //   41: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   44: checkcast com/blued/android/module/live_china/model/LiveGiftModel
    //   47: astore_2
    //   48: goto -> 58
    //   51: astore_2
    //   52: aload_2
    //   53: invokevirtual printStackTrace : ()V
    //   56: aconst_null
    //   57: astore_2
    //   58: aload_2
    //   59: ifnonnull -> 70
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield b : Z
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_2
    //   71: getfield animation : I
    //   74: ifeq -> 431
    //   77: aload_0
    //   78: getfield f : Landroid/widget/LinearLayout;
    //   81: invokevirtual getVisibility : ()I
    //   84: bipush #8
    //   86: if_icmpne -> 92
    //   89: goto -> 431
    //   92: aload_0
    //   93: aload_2
    //   94: putfield E : Lcom/blued/android/module/live_china/model/LiveGiftModel;
    //   97: aload_0
    //   98: getfield E : Lcom/blued/android/module/live_china/model/LiveGiftModel;
    //   101: aload_1
    //   102: getfield fromId : J
    //   105: putfield userId : J
    //   108: aload_0
    //   109: getfield o : Landroid/widget/TextView;
    //   112: new com/blued/android/module/live_china/manager/GiftAnimManager$11
    //   115: dup
    //   116: aload_0
    //   117: aload_1
    //   118: invokespecial <init> : (Lcom/blued/android/module/live_china/manager/GiftAnimManager;Lcom/blued/android/chat/model/ChattingModel;)V
    //   121: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   124: aload_2
    //   125: getfield hit_count : I
    //   128: ifle -> 142
    //   131: aload_0
    //   132: getfield x : Landroid/widget/LinearLayout;
    //   135: iconst_0
    //   136: invokevirtual setVisibility : (I)V
    //   139: goto -> 151
    //   142: aload_0
    //   143: getfield x : Landroid/widget/LinearLayout;
    //   146: bipush #8
    //   148: invokevirtual setVisibility : (I)V
    //   151: aload_0
    //   152: getfield p : Landroid/widget/TextView;
    //   155: aload_1
    //   156: getfield fromNickName : Ljava/lang/String;
    //   159: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   162: aload_0
    //   163: getfield n : Landroid/widget/TextView;
    //   166: astore_3
    //   167: new java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial <init> : ()V
    //   174: astore #4
    //   176: aload #4
    //   178: invokestatic d : ()Landroid/content/Context;
    //   181: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   184: getstatic com/blued/android/module/live_china/R$string.Live_SendPresent_send : I
    //   187: invokevirtual getString : (I)Ljava/lang/String;
    //   190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload #4
    //   196: aload_2
    //   197: getfield name : Ljava/lang/String;
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_3
    //   205: aload #4
    //   207: invokevirtual toString : ()Ljava/lang/String;
    //   210: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   213: aload_0
    //   214: aload_2
    //   215: invokespecial f : (Lcom/blued/android/module/live_china/model/LiveGiftModel;)Z
    //   218: ifne -> 262
    //   221: aload_0
    //   222: getfield v : Landroid/widget/TextView;
    //   225: astore_3
    //   226: new java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial <init> : ()V
    //   233: astore #4
    //   235: aload #4
    //   237: aload_2
    //   238: getfield hit_count : I
    //   241: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload #4
    //   247: ldc ''
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_3
    //   254: aload #4
    //   256: invokevirtual toString : ()Ljava/lang/String;
    //   259: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   262: aconst_null
    //   263: aload_1
    //   264: getfield fromAvatar : Ljava/lang/String;
    //   267: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
    //   270: invokevirtual c : ()Lcom/blued/android/core/image/ImageWrapper;
    //   273: getstatic com/blued/android/module/live_china/R$drawable.user_bg_round : I
    //   276: invokevirtual a : (I)Lcom/blued/android/core/image/ImageWrapper;
    //   279: aload_0
    //   280: getfield r : Landroid/widget/ImageView;
    //   283: invokevirtual a : (Landroid/widget/ImageView;)V
    //   286: ldc_w 'aniGiftView2 gift_pic_url = '
    //   289: aload_2
    //   290: getfield images_static : Ljava/lang/String;
    //   293: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   296: pop
    //   297: aconst_null
    //   298: aload_2
    //   299: getfield images_static : Ljava/lang/String;
    //   302: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
    //   305: getstatic com/blued/android/module/live_china/R$drawable.gift_default_icon : I
    //   308: invokevirtual a : (I)Lcom/blued/android/core/image/ImageWrapper;
    //   311: aload_0
    //   312: getfield t : Landroid/widget/ImageView;
    //   315: invokevirtual a : (Landroid/widget/ImageView;)V
    //   318: invokestatic d : ()Landroid/content/Context;
    //   321: aload_0
    //   322: getfield j : Landroid/widget/ImageView;
    //   325: aload_1
    //   326: getfield fromRichLevel : I
    //   329: invokestatic a : (Landroid/content/Context;Landroid/widget/ImageView;I)I
    //   332: pop
    //   333: aload_1
    //   334: invokestatic b : (Lcom/blued/android/chat/model/ChattingModel;)Lcom/blued/android/module/live_china/model/LiveLiangModel;
    //   337: astore_1
    //   338: aload_1
    //   339: ifnull -> 361
    //   342: aload_1
    //   343: getfield liang_type : I
    //   346: iconst_2
    //   347: if_icmplt -> 361
    //   350: aload_0
    //   351: getfield l : Landroid/widget/ImageView;
    //   354: iconst_0
    //   355: invokevirtual setVisibility : (I)V
    //   358: goto -> 370
    //   361: aload_0
    //   362: getfield l : Landroid/widget/ImageView;
    //   365: bipush #8
    //   367: invokevirtual setVisibility : (I)V
    //   370: invokestatic d : ()Landroid/content/Context;
    //   373: getstatic com/blued/android/module/live_china/R$anim.live_msg_gift_in_from_left : I
    //   376: invokestatic loadAnimation : (Landroid/content/Context;I)Landroid/view/animation/Animation;
    //   379: astore_1
    //   380: aload_0
    //   381: getfield h : Landroid/view/View;
    //   384: aload_1
    //   385: invokevirtual setAnimation : (Landroid/view/animation/Animation;)V
    //   388: aload_1
    //   389: new com/blued/android/module/live_china/manager/GiftAnimManager$12
    //   392: dup
    //   393: aload_0
    //   394: invokespecial <init> : (Lcom/blued/android/module/live_china/manager/GiftAnimManager;)V
    //   397: invokevirtual setAnimationListener : (Landroid/view/animation/Animation$AnimationListener;)V
    //   400: aload_0
    //   401: getfield M : Lcom/blued/android/module/live_china/manager/GiftAnimManager$GiftHandler;
    //   404: aload_0
    //   405: getfield C : Lcom/blued/android/module/live_china/manager/GiftAnimManager$Anim2Runnable;
    //   408: aload_0
    //   409: aload_2
    //   410: invokespecial g : (Lcom/blued/android/module/live_china/model/LiveGiftModel;)J
    //   413: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   416: pop
    //   417: aload_0
    //   418: invokevirtual d : ()V
    //   421: ldc_w '弹道二唤醒线程 继续轮询任务'
    //   424: invokestatic c : (Ljava/lang/String;)I
    //   427: pop
    //   428: aload_0
    //   429: monitorexit
    //   430: return
    //   431: new java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial <init> : ()V
    //   438: astore_1
    //   439: aload_1
    //   440: ldc_w '普通礼物没动画更新弯豆：'
    //   443: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload_1
    //   448: aload_2
    //   449: getfield beans_count : D
    //   452: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: ldc_w 'beans'
    //   459: aload_1
    //   460: invokevirtual toString : ()Ljava/lang/String;
    //   463: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   466: pop
    //   467: invokestatic a : ()Lcom/blued/android/module/live_china/observer/BeansRefreshObserver;
    //   470: aload_2
    //   471: getfield beans_count : D
    //   474: aload_2
    //   475: getfield beans_current_count : D
    //   478: invokevirtual a : (DD)V
    //   481: aload_0
    //   482: iconst_1
    //   483: putfield b : Z
    //   486: aload_0
    //   487: monitorexit
    //   488: return
    //   489: astore_1
    //   490: aload_0
    //   491: monitorexit
    //   492: aload_1
    //   493: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	489	finally
    //   32	48	51	java/lang/Exception
    //   32	48	489	finally
    //   52	56	489	finally
    //   62	67	489	finally
    //   70	89	489	finally
    //   92	139	489	finally
    //   142	151	489	finally
    //   151	262	489	finally
    //   262	338	489	finally
    //   342	358	489	finally
    //   361	370	489	finally
    //   370	428	489	finally
    //   431	486	489	finally
  }
  
  private boolean f(LiveGiftModel paramLiveGiftModel) {
    return (paramLiveGiftModel != null && paramLiveGiftModel.hit_batch == 1);
  }
  
  private long g(LiveGiftModel paramLiveGiftModel) {
    if (paramLiveGiftModel != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("动画礼物更新弯豆：");
      stringBuilder.append(paramLiveGiftModel.beans_count);
      Log.v("beans", stringBuilder.toString());
      BeansRefreshObserver.a().a(paramLiveGiftModel.beans_count, paramLiveGiftModel.beans_current_count);
      LogUtils.a(new Object[] { "pk", "msgExtra.type_name = ", paramLiveGiftModel.type_name });
      LogUtils.a(new Object[] { "pk", "msgExtra.resource_url = ", paramLiveGiftModel.resource_url });
      LogUtils.a(new Object[] { "pk", "msgExtra.anim_code = ", paramLiveGiftModel.anim_code });
      if (TextUtils.equals(paramLiveGiftModel.type_name, "normal_goods")) {
        if (!TextUtils.isEmpty(paramLiveGiftModel.images_gif) || !TextUtils.isEmpty(paramLiveGiftModel.images_apng2) || !TextUtils.isEmpty(paramLiveGiftModel.images_mp4)) {
          this.G.add(paramLiveGiftModel);
          PlayGifObserver.a().b();
          return 4000L;
        } 
      } else if (TextUtils.equals(paramLiveGiftModel.type_name, "ar_goods")) {
        e(paramLiveGiftModel);
        return 4000L;
      } 
    } 
    return 2000L;
  }
  
  private void g(ChattingModel paramChattingModel) {
    LiveMsgManager liveMsgManager = this.A;
    if (liveMsgManager != null)
      liveMsgManager.d(paramChattingModel.fromNickName); 
  }
  
  private void h() {
    this.M = new GiftHandler();
  }
  
  private ChattingModel i() {
    if (this.F.size() > 0)
      try {
        return this.F.remove(0);
      } catch (Exception exception) {
        return new ChattingModel();
      }  
    return new ChattingModel();
  }
  
  private ChattingModel j() {
    return (this.F.size() > 0) ? this.F.get(0) : new ChattingModel();
  }
  
  private boolean k() {
    return (this.F.size() > 0);
  }
  
  private void l() {
    BatchCountDownTimer1 batchCountDownTimer1 = this.N;
    if (batchCountDownTimer1 != null)
      batchCountDownTimer1.cancel(); 
    BatchCountDownTimer2 batchCountDownTimer2 = this.O;
    if (batchCountDownTimer2 != null)
      batchCountDownTimer2.cancel(); 
  }
  
  private void m() {
    if (this.I.size() > 0) {
      LogUtils.c("playHitGiftList1");
      this.K = true;
      this.M.removeCallbacks(this.B);
      LiveGiftModel liveGiftModel = this.I.get(0);
      AppInfo.n().postDelayed(new Runnable(this, liveGiftModel) {
            public void run() {
              LogUtils.c("onAnimationEnd--------");
              GiftAnimManager.a(this.b, false);
              GiftAnimManager.a(this.b).remove(this.a);
              GiftAnimManager.b(this.b);
              GiftAnimManager.d(this.b).removeCallbacks(GiftAnimManager.c(this.b));
              GiftAnimManager.d(this.b).postDelayed(GiftAnimManager.c(this.b), GiftAnimManager.a(this.b, this.a));
            }
          }200L);
      if (liveGiftModel.hit_count > 0) {
        this.w.setVisibility(0);
      } else {
        this.w.setVisibility(8);
      } 
      this.g.setVisibility(0);
      TextView textView = this.u;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(liveGiftModel.hit_count);
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
      ScaleAnimation scaleAnimation1 = new ScaleAnimation(2.0F, 0.5F, 2.0F, 0.5F, 1, 0.5F, 1, 0.5F);
      scaleAnimation1.setDuration(250L);
      ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
      scaleAnimation2.setDuration(100L);
      scaleAnimation1.setAnimationListener(new Animation.AnimationListener(this, scaleAnimation2) {
            public void onAnimationEnd(Animation param1Animation) {
              GiftAnimManager.e(this.b).startAnimation((Animation)this.a);
            }
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      scaleAnimation2.setAnimationListener(new Animation.AnimationListener(this) {
            public void onAnimationEnd(Animation param1Animation) {}
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      this.w.startAnimation((Animation)scaleAnimation1);
    } 
  }
  
  private void n() {
    LogUtils.c("playHitGiftList2");
    if (this.J.size() > 0) {
      this.L = true;
      this.M.removeCallbacks(this.C);
      LiveGiftModel liveGiftModel = this.J.get(0);
      AppInfo.n().postDelayed(new Runnable(this, liveGiftModel) {
            public void run() {
              LogUtils.c("onAnimationEnd2--------");
              GiftAnimManager.b(this.b, false);
              GiftAnimManager.f(this.b).remove(this.a);
              GiftAnimManager.g(this.b);
              GiftAnimManager.d(this.b).removeCallbacks(GiftAnimManager.h(this.b));
              GiftAnimManager.d(this.b).postDelayed(GiftAnimManager.h(this.b), GiftAnimManager.a(this.b, this.a));
            }
          }200L);
      if (liveGiftModel.hit_count > 0) {
        this.x.setVisibility(0);
      } else {
        this.x.setVisibility(8);
      } 
      this.h.setVisibility(0);
      TextView textView = this.v;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(liveGiftModel.hit_count);
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
      ScaleAnimation scaleAnimation1 = new ScaleAnimation(2.0F, 0.5F, 2.0F, 0.5F, 1, 0.5F, 1, 0.5F);
      scaleAnimation1.setDuration(250L);
      ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
      scaleAnimation2.setDuration(100L);
      scaleAnimation1.setAnimationListener(new Animation.AnimationListener(this, scaleAnimation2) {
            public void onAnimationEnd(Animation param1Animation) {
              GiftAnimManager.i(this.b).startAnimation((Animation)this.a);
            }
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      scaleAnimation2.setAnimationListener(new Animation.AnimationListener(this) {
            public void onAnimationEnd(Animation param1Animation) {}
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      this.x.startAnimation((Animation)scaleAnimation1);
    } 
  }
  
  public void a() {
    c = "";
    d = 0L;
  }
  
  public void a(int paramInt) {
    LinearLayout linearLayout = this.f;
    if (linearLayout != null)
      linearLayout.setVisibility(paramInt); 
  }
  
  public void a(ChattingModel paramChattingModel) {
    // Byte code:
    //   0: aload_0
    //   1: getfield A : Lcom/blued/android/module/live_china/liveForMsg/LiveMsgManager;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull -> 20
    //   9: aload_2
    //   10: getfield u : I
    //   13: getstatic com/blued/android/module/live_china/fragment/PlayingOnliveFragment.co : I
    //   16: if_icmpeq -> 20
    //   19: return
    //   20: invokestatic g : ()Z
    //   23: ifeq -> 27
    //   26: return
    //   27: aload_0
    //   28: getfield F : Ljava/util/List;
    //   31: invokeinterface size : ()I
    //   36: bipush #100
    //   38: if_icmple -> 42
    //   41: return
    //   42: aload_0
    //   43: getfield F : Ljava/util/List;
    //   46: aload_1
    //   47: invokeinterface add : (Ljava/lang/Object;)Z
    //   52: pop
    //   53: aload_0
    //   54: monitorenter
    //   55: aload_0
    //   56: invokevirtual notify : ()V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Exception table:
    //   from	to	target	type
    //   55	61	62	finally
    //   63	65	62	finally
  }
  
  public void a(ChattingModel paramChattingModel, int paramInt) {
    Message message = this.M.obtainMessage();
    message.obj = paramChattingModel;
    message.arg1 = paramInt;
    message.sendToTarget();
  }
  
  public void a(LiveMsgManager paramLiveMsgManager, LinearLayout paramLinearLayout) {
    if (this.f == null)
      start(); 
    this.A = paramLiveMsgManager;
    this.f = paramLinearLayout;
    this.g = this.f.findViewById(R.id.ll_gift_ani_c1);
    this.h = this.f.findViewById(R.id.ll_gift_ani_c2);
    this.o = (TextView)this.g.findViewById(R.id.tv_from_gift_nickname);
    this.p = (TextView)this.h.findViewById(R.id.tv_from_gift_nickname);
    this.i = (ImageView)this.g.findViewById(R.id.msg_user_level);
    this.j = (ImageView)this.h.findViewById(R.id.msg_user_level);
    this.k = (ImageView)this.g.findViewById(R.id.msg_user_liang);
    this.l = (ImageView)this.h.findViewById(R.id.msg_user_liang);
    this.m = (TextView)this.g.findViewById(R.id.live_msg_send_gift_name);
    this.n = (TextView)this.h.findViewById(R.id.live_msg_send_gift_name);
    this.q = (ImageView)this.g.findViewById(R.id.from_gift_avatar);
    this.r = (ImageView)this.h.findViewById(R.id.from_gift_avatar);
    this.s = (ImageView)this.g.findViewById(R.id.from_gift_url);
    this.t = (ImageView)this.h.findViewById(R.id.from_gift_url);
    this.u = (TextView)this.g.findViewById(R.id.hit_count_view);
    this.v = (TextView)this.h.findViewById(R.id.hit_count_view);
    this.w = (LinearLayout)this.g.findViewById(R.id.hit_layout);
    this.x = (LinearLayout)this.h.findViewById(R.id.hit_layout);
    this.y = new LoadOptions();
    this.y.b = R.drawable.user_bg_round;
    this.y.d = R.drawable.user_bg_round;
    this.y.a(AppMethods.a(40), AppMethods.a(40));
    this.z = new LoadOptions();
    this.z.d = R.drawable.gift_default_icon;
    this.z.b = R.drawable.gift_default_icon;
    LoadOptions loadOptions = this.z;
    loadOptions.l = false;
    loadOptions.a(AppMethods.a(60), AppMethods.a(60));
    this.a = true;
    this.b = true;
  }
  
  public void a(LiveGiftModel paramLiveGiftModel) {
    if (!this.G.remove(paramLiveGiftModel) && this.G.size() > 0)
      this.G.remove(0); 
  }
  
  public List<LiveGiftModel> b() {
    return this.G;
  }
  
  public void b(ChattingModel paramChattingModel) {
    // Byte code:
    //   0: aload_0
    //   1: getfield A : Lcom/blued/android/module/live_china/liveForMsg/LiveMsgManager;
    //   4: getfield u : I
    //   7: getstatic com/blued/android/module/live_china/fragment/PlayingOnliveFragment.co : I
    //   10: if_icmpeq -> 14
    //   13: return
    //   14: invokestatic a : ()Lcom/blued/android/module/live_china/live_info/LiveRoomInfo;
    //   17: invokevirtual f : ()Ljava/lang/String;
    //   20: astore_3
    //   21: iconst_0
    //   22: istore_2
    //   23: iload_2
    //   24: aload_0
    //   25: getfield F : Ljava/util/List;
    //   28: invokeinterface size : ()I
    //   33: if_icmpge -> 70
    //   36: aload_0
    //   37: getfield F : Ljava/util/List;
    //   40: iload_2
    //   41: invokeinterface get : (I)Ljava/lang/Object;
    //   46: checkcast com/blued/android/chat/model/ChattingModel
    //   49: getfield fromId : J
    //   52: aload_3
    //   53: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   56: invokevirtual longValue : ()J
    //   59: lcmp
    //   60: ifne -> 63
    //   63: iload_2
    //   64: iconst_1
    //   65: iadd
    //   66: istore_2
    //   67: goto -> 23
    //   70: aload_0
    //   71: getfield F : Ljava/util/List;
    //   74: aload_1
    //   75: invokeinterface add : (Ljava/lang/Object;)Z
    //   80: pop
    //   81: aload_0
    //   82: monitorenter
    //   83: aload_0
    //   84: invokevirtual notify : ()V
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   83	89	90	finally
    //   91	93	90	finally
  }
  
  public void b(LiveGiftModel paramLiveGiftModel) {
    if (!this.H.remove(paramLiveGiftModel) && this.H.size() > 0)
      this.H.remove(0); 
  }
  
  public List<LiveGiftModel> c() {
    return this.H;
  }
  
  public void c(LiveGiftModel paramLiveGiftModel) {
    this.G.add(0, paramLiveGiftModel);
    PlayGifObserver.a().b();
  }
  
  public boolean c(ChattingModel paramChattingModel) {
    // Byte code:
    //   0: aload_1
    //   1: astore #6
    //   3: aload_1
    //   4: ifnonnull -> 13
    //   7: aload_0
    //   8: invokespecial j : ()Lcom/blued/android/chat/model/ChattingModel;
    //   11: astore #6
    //   13: aload #6
    //   15: getfield msgMapExtra : Ljava/util/Map;
    //   18: astore #7
    //   20: aconst_null
    //   21: astore_1
    //   22: aload #7
    //   24: ifnull -> 130
    //   27: aload #6
    //   29: getfield msgMapExtra : Ljava/util/Map;
    //   32: ldc 'gift_model'
    //   34: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   39: astore #6
    //   41: aload #6
    //   43: instanceof com/blued/android/module/live_china/model/LiveGiftModel
    //   46: ifeq -> 135
    //   49: aload #6
    //   51: checkcast com/blued/android/module/live_china/model/LiveGiftModel
    //   54: astore_1
    //   55: goto -> 135
    //   58: aload_0
    //   59: getfield D : Lcom/blued/android/module/live_china/model/LiveGiftModel;
    //   62: ifnull -> 91
    //   65: aload_1
    //   66: getfield hit_id : J
    //   69: lconst_0
    //   70: lcmp
    //   71: ifeq -> 91
    //   74: aload_0
    //   75: getfield D : Lcom/blued/android/module/live_china/model/LiveGiftModel;
    //   78: getfield hit_id : J
    //   81: aload_1
    //   82: getfield hit_id : J
    //   85: lcmp
    //   86: ifne -> 91
    //   89: iconst_1
    //   90: ireturn
    //   91: aload_0
    //   92: getfield E : Lcom/blued/android/module/live_china/model/LiveGiftModel;
    //   95: ifnull -> 130
    //   98: aload_1
    //   99: getfield hit_id : J
    //   102: lconst_0
    //   103: lcmp
    //   104: ifeq -> 130
    //   107: aload_0
    //   108: getfield E : Lcom/blued/android/module/live_china/model/LiveGiftModel;
    //   111: getfield hit_id : J
    //   114: lstore_2
    //   115: aload_1
    //   116: getfield hit_id : J
    //   119: lstore #4
    //   121: lload_2
    //   122: lload #4
    //   124: lcmp
    //   125: ifne -> 130
    //   128: iconst_1
    //   129: ireturn
    //   130: iconst_0
    //   131: ireturn
    //   132: astore_1
    //   133: iconst_0
    //   134: ireturn
    //   135: aload_1
    //   136: ifnonnull -> 58
    //   139: iconst_0
    //   140: ireturn
    // Exception table:
    //   from	to	target	type
    //   7	13	132	java/lang/Exception
    //   13	20	132	java/lang/Exception
    //   27	41	132	java/lang/Exception
    //   41	55	132	java/lang/Exception
    //   58	89	132	java/lang/Exception
    //   91	121	132	java/lang/Exception
  }
  
  public void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual notify : ()V
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	9	finally
    //   10	12	9	finally
  }
  
  public void d(LiveGiftModel paramLiveGiftModel) {
    this.G.add(0, paramLiveGiftModel);
  }
  
  public void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual notify : ()V
    //   6: aload_0
    //   7: monitorexit
    //   8: aload_0
    //   9: iconst_1
    //   10: putfield a : Z
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield b : Z
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield K : Z
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield L : Z
    //   28: aload_0
    //   29: getfield F : Ljava/util/List;
    //   32: invokeinterface clear : ()V
    //   37: aload_0
    //   38: getfield G : Ljava/util/List;
    //   41: invokeinterface clear : ()V
    //   46: aload_0
    //   47: getfield H : Ljava/util/List;
    //   50: invokeinterface clear : ()V
    //   55: aload_0
    //   56: getfield I : Ljava/util/List;
    //   59: invokeinterface clear : ()V
    //   64: aload_0
    //   65: getfield J : Ljava/util/List;
    //   68: invokeinterface clear : ()V
    //   73: aload_0
    //   74: invokevirtual g : ()V
    //   77: aload_0
    //   78: invokevirtual a : ()V
    //   81: aload_0
    //   82: getfield M : Lcom/blued/android/module/live_china/manager/GiftAnimManager$GiftHandler;
    //   85: aconst_null
    //   86: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
    //   89: aload_0
    //   90: invokespecial l : ()V
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield A : Lcom/blued/android/module/live_china/liveForMsg/LiveMsgManager;
    //   98: return
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	99	finally
    //   100	102	99	finally
  }
  
  public void e(LiveGiftModel paramLiveGiftModel) {
    LiveMsgManager liveMsgManager = this.A;
    if (liveMsgManager == null)
      return; 
    if (liveMsgManager.c instanceof com.blued.android.module.live_china.fragment.RecordingOnliveFragment) {
      this.H.add(paramLiveGiftModel);
      PlayARObserver.a().b();
    } 
  }
  
  public void f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual notify : ()V
    //   6: aload_0
    //   7: monitorexit
    //   8: aload_0
    //   9: getfield g : Landroid/view/View;
    //   12: iconst_4
    //   13: invokevirtual setVisibility : (I)V
    //   16: aload_0
    //   17: getfield h : Landroid/view/View;
    //   20: iconst_4
    //   21: invokevirtual setVisibility : (I)V
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield a : Z
    //   29: aload_0
    //   30: iconst_1
    //   31: putfield b : Z
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield K : Z
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield L : Z
    //   44: aload_0
    //   45: getfield F : Ljava/util/List;
    //   48: invokeinterface clear : ()V
    //   53: aload_0
    //   54: getfield G : Ljava/util/List;
    //   57: invokeinterface clear : ()V
    //   62: aload_0
    //   63: getfield H : Ljava/util/List;
    //   66: invokeinterface clear : ()V
    //   71: aload_0
    //   72: getfield I : Ljava/util/List;
    //   75: invokeinterface clear : ()V
    //   80: aload_0
    //   81: getfield J : Ljava/util/List;
    //   84: invokeinterface clear : ()V
    //   89: aload_0
    //   90: getfield M : Lcom/blued/android/module/live_china/manager/GiftAnimManager$GiftHandler;
    //   93: aconst_null
    //   94: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
    //   97: aload_0
    //   98: invokespecial l : ()V
    //   101: aload_0
    //   102: invokevirtual a : ()V
    //   105: return
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	106	finally
    //   107	109	106	finally
  }
  
  public void g() {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield e : Z
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual notify : ()V
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   7	13	14	finally
    //   15	17	14	finally
  }
  
  public void run() {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : Z
    //   4: ifne -> 199
    //   7: aload_0
    //   8: invokespecial k : ()Z
    //   11: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   14: invokevirtual booleanValue : ()Z
    //   17: ifne -> 42
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: invokevirtual wait : ()V
    //   26: aload_0
    //   27: monitorexit
    //   28: goto -> 0
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    //   36: astore_1
    //   37: aload_1
    //   38: invokevirtual printStackTrace : ()V
    //   41: return
    //   42: aload_0
    //   43: getfield a : Z
    //   46: ifne -> 100
    //   49: aload_0
    //   50: getfield b : Z
    //   53: ifne -> 100
    //   56: aload_0
    //   57: getfield e : Z
    //   60: ifne -> 100
    //   63: aload_0
    //   64: aconst_null
    //   65: invokevirtual c : (Lcom/blued/android/chat/model/ChattingModel;)Z
    //   68: ifne -> 100
    //   71: aload_0
    //   72: monitorenter
    //   73: ldc_w '等待任务 wait -----'
    //   76: invokestatic c : (Ljava/lang/String;)I
    //   79: pop
    //   80: aload_0
    //   81: invokevirtual wait : ()V
    //   84: aload_0
    //   85: monitorexit
    //   86: goto -> 42
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual printStackTrace : ()V
    //   99: return
    //   100: aload_0
    //   101: invokespecial i : ()Lcom/blued/android/chat/model/ChattingModel;
    //   104: astore_1
    //   105: aload_0
    //   106: aload_1
    //   107: invokevirtual c : (Lcom/blued/android/chat/model/ChattingModel;)Z
    //   110: ifeq -> 143
    //   113: ldc2_w 10
    //   116: invokestatic sleep : (J)V
    //   119: goto -> 127
    //   122: astore_2
    //   123: aload_2
    //   124: invokevirtual printStackTrace : ()V
    //   127: aload_0
    //   128: aload_1
    //   129: iconst_3
    //   130: invokevirtual a : (Lcom/blued/android/chat/model/ChattingModel;I)V
    //   133: ldc_w '发送相同任务消息'
    //   136: invokestatic c : (Ljava/lang/String;)I
    //   139: pop
    //   140: goto -> 0
    //   143: aload_0
    //   144: getfield a : Z
    //   147: ifeq -> 171
    //   150: aload_0
    //   151: iconst_0
    //   152: putfield a : Z
    //   155: aload_0
    //   156: aload_1
    //   157: iconst_1
    //   158: invokevirtual a : (Lcom/blued/android/chat/model/ChattingModel;I)V
    //   161: ldc_w '开始弹道一任务'
    //   164: invokestatic c : (Ljava/lang/String;)I
    //   167: pop
    //   168: goto -> 0
    //   171: aload_0
    //   172: getfield b : Z
    //   175: ifeq -> 0
    //   178: aload_0
    //   179: iconst_0
    //   180: putfield b : Z
    //   183: aload_0
    //   184: aload_1
    //   185: iconst_2
    //   186: invokevirtual a : (Lcom/blued/android/chat/model/ChattingModel;I)V
    //   189: ldc_w '开始弹道二任务'
    //   192: invokestatic c : (Ljava/lang/String;)I
    //   195: pop
    //   196: goto -> 0
    //   199: return
    // Exception table:
    //   from	to	target	type
    //   20	22	36	java/lang/InterruptedException
    //   22	28	31	finally
    //   32	34	31	finally
    //   34	36	36	java/lang/InterruptedException
    //   71	73	94	java/lang/InterruptedException
    //   73	86	89	finally
    //   90	92	89	finally
    //   92	94	94	java/lang/InterruptedException
    //   113	119	122	java/lang/InterruptedException
  }
  
  class Anim1Runnable implements Runnable {
    private Anim1Runnable(GiftAnimManager this$0) {}
    
    public void run() {
      GiftAnimManager giftAnimManager = this.a;
      giftAnimManager.a = true;
      GiftAnimManager.n(giftAnimManager).setVisibility(4);
      GiftAnimManager.j(this.a).setText("");
      this.a.d();
      LogUtils.c("释放第一条弹道");
    }
  }
  
  class Anim2Runnable implements Runnable {
    private Anim2Runnable(GiftAnimManager this$0) {}
    
    public void run() {
      GiftAnimManager giftAnimManager = this.a;
      giftAnimManager.b = true;
      GiftAnimManager.p(giftAnimManager).setVisibility(4);
      GiftAnimManager.l(this.a).setText("");
      this.a.d();
      LogUtils.c("释放第二条弹道");
    }
  }
  
  class BatchCountDownTimer1 extends CountDownTimer {
    private LiveGiftModel b;
    
    private int c = 0;
    
    private int d;
    
    public BatchCountDownTimer1(GiftAnimManager this$0, long param1Long1, long param1Long2, LiveGiftModel param1LiveGiftModel, int param1Int1, int param1Int2) {
      super(param1Long1, param1Long2);
      this.b = param1LiveGiftModel;
      this.c = param1Int1;
      this.d = param1Int2;
    }
    
    public void onFinish() {
      LogUtils.a(new Object[] { "onFinish 11 count = ", Integer.valueOf(this.c) });
      int i = this.c;
      int j = this.d;
      if (i < j) {
        if (j - i == 1) {
          this.c = i + 1;
          TextView textView = GiftAnimManager.j(this.a);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.c);
          stringBuilder.append("");
          textView.setText(stringBuilder.toString());
          GiftAnimManager giftAnimManager1 = this.a;
          GiftAnimManager.a(giftAnimManager1, (View)GiftAnimManager.e(giftAnimManager1), this.b);
          GiftAnimManager.d(this.a).postDelayed(GiftAnimManager.c(this.a), GiftAnimManager.a(this.a, this.b));
          return;
        } 
        GiftAnimManager giftAnimManager = this.a;
        GiftAnimManager.a(giftAnimManager, new BatchCountDownTimer1(giftAnimManager, ((j - i) * 100), 100L, this.b, i, j));
        GiftAnimManager.k(this.a).start();
        return;
      } 
      GiftAnimManager.d(this.a).postDelayed(GiftAnimManager.c(this.a), GiftAnimManager.a(this.a, this.b));
    }
    
    public void onTick(long param1Long) {
      this.c++;
      TextView textView = GiftAnimManager.j(this.a);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.c);
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
      GiftAnimManager giftAnimManager = this.a;
      GiftAnimManager.a(giftAnimManager, (View)GiftAnimManager.e(giftAnimManager), this.b);
      LogUtils.a(new Object[] { "onTick 11 count = ", Integer.valueOf(this.c) });
    }
  }
  
  class BatchCountDownTimer2 extends CountDownTimer {
    private LiveGiftModel b;
    
    private int c = 0;
    
    private int d;
    
    public BatchCountDownTimer2(GiftAnimManager this$0, long param1Long1, long param1Long2, LiveGiftModel param1LiveGiftModel, int param1Int1, int param1Int2) {
      super(param1Long1, param1Long2);
      this.b = param1LiveGiftModel;
      this.c = param1Int1;
      this.d = param1Int2;
    }
    
    public void onFinish() {
      LogUtils.a(new Object[] { "onFinish 22 count = ", Integer.valueOf(this.c) });
      int i = this.c;
      int j = this.d;
      if (i < j) {
        if (j - i == 1) {
          this.c = i + 1;
          TextView textView = GiftAnimManager.l(this.a);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.c);
          stringBuilder.append("");
          textView.setText(stringBuilder.toString());
          GiftAnimManager giftAnimManager1 = this.a;
          GiftAnimManager.a(giftAnimManager1, (View)GiftAnimManager.i(giftAnimManager1), this.b);
          GiftAnimManager.d(this.a).postDelayed(GiftAnimManager.h(this.a), GiftAnimManager.a(this.a, this.b));
          return;
        } 
        GiftAnimManager giftAnimManager = this.a;
        GiftAnimManager.a(giftAnimManager, new BatchCountDownTimer2(giftAnimManager, ((j - i) * 100), 100L, this.b, i, j));
        GiftAnimManager.m(this.a).start();
        return;
      } 
      GiftAnimManager.d(this.a).postDelayed(GiftAnimManager.h(this.a), GiftAnimManager.a(this.a, this.b));
    }
    
    public void onTick(long param1Long) {
      this.c++;
      TextView textView = GiftAnimManager.l(this.a);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.c);
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
      GiftAnimManager giftAnimManager = this.a;
      GiftAnimManager.a(giftAnimManager, (View)GiftAnimManager.i(giftAnimManager), this.b);
      LogUtils.a(new Object[] { "onTick 22 count = ", Integer.valueOf(this.c) });
    }
  }
  
  final class GiftHandler extends Handler {
    private GiftHandler(GiftAnimManager this$0) {}
    
    public void handleMessage(Message param1Message) {
      ChattingModel chattingModel = (ChattingModel)param1Message.obj;
      int i = param1Message.arg1;
      if (i == 1) {
        GiftAnimManager.a(this.a, chattingModel);
        return;
      } 
      if (i == 2) {
        GiftAnimManager.b(this.a, chattingModel);
        return;
      } 
      if (i == 3)
        GiftAnimManager.c(this.a, chattingModel); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\GiftAnimManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */