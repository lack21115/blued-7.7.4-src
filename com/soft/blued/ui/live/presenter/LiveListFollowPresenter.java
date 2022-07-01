package com.soft.blued.ui.live.presenter;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.live.contract.LiveListFollowContract;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.model.LiveListCommonModel;
import com.soft.blued.ui.live.model.LiveListRecommendModel;
import com.soft.blued.ui.live.model.LiveRecommendExtra;
import com.soft.blued.ui.live.model.LiveRecommendModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.NetworkUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

public class LiveListFollowPresenter implements LiveListFollowContract.IPresenter {
  private final String a = LiveListFollowPresenter.class.getSimpleName();
  
  private BaseFragment b;
  
  private Context c;
  
  private LiveListFollowContract.IView d;
  
  private LiveListCommonModel e;
  
  private LiveListRecommendModel f;
  
  private List<LiveRecommendModel> g = new ArrayList<LiveRecommendModel>();
  
  private boolean h;
  
  public LiveListFollowPresenter(BaseFragment paramBaseFragment, LiveListFollowContract.IView paramIView, LiveListCommonModel paramLiveListCommonModel, LiveListRecommendModel paramLiveListRecommendModel) {
    this.b = paramBaseFragment;
    this.c = paramBaseFragment.getContext();
    this.d = paramIView;
    this.e = paramLiveListCommonModel;
    this.f = paramLiveListRecommendModel;
  }
  
  public void a(BluedLiveListData paramBluedLiveListData) {
    UserHttpUtils.a(this.c, new UserRelationshipUtils.IAddOrRemoveAttentionDone(this, paramBluedLiveListData) {
          public void a() {}
          
          public void a(String param1String) {}
          
          public void b() {}
          
          public void b(String param1String) {
            LiveListFollowPresenter.a(this.b).a(this.a);
          }
          
          public void c() {}
        }paramBluedLiveListData.uid, "", null);
  }
  
  public void a(boolean paramBoolean) {
    this.d.aN_();
    if (!NetworkUtils.b()) {
      AppMethods.d(2131758203);
      this.d.d();
      this.d.b(null);
      this.d.k();
      return;
    } 
    if (!paramBoolean)
      this.h = false; 
    LiveHttpUtils.a(new BluedUIHttpResponse<BluedEntity<LiveRecommendModel, LiveRecommendExtra>>(this, paramBoolean) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            AppInfo.n().post(new Runnable(this) {
                  public void run() {
                    this.a.b.b();
                  }
                });
          }
          
          public void onUIFinish() {
            LiveListFollowPresenter.a(this.b).d();
            LiveListFollowPresenter.a(this.b).l();
            LiveListFollowPresenter.a(this.b).k();
          }
          
          public void onUIUpdate(BluedEntity<LiveRecommendModel, LiveRecommendExtra> param1BluedEntity) {
            if (param1BluedEntity.extra != null) {
              LiveRecommendExtra liveRecommendExtra = (LiveRecommendExtra)param1BluedEntity.extra;
              if (liveRecommendExtra.is_new == 1) {
                LiveListFollowPresenter.a(this.b).a(true);
                LiveListFollowPresenter.a(this.b).b(param1BluedEntity.data);
              } else {
                if (param1BluedEntity != null && param1BluedEntity.hasData()) {
                  (LiveListFollowPresenter.h(this.b)).hasData = true;
                  LiveListFollowPresenter.a(this.b).b(true);
                } else {
                  (LiveListFollowPresenter.h(this.b)).hasData = false;
                  LiveListFollowPresenter.a(this.b).b(false);
                } 
                if (this.a) {
                  LiveListFollowPresenter.a(this.b).c(param1BluedEntity.data);
                } else {
                  LiveListFollowPresenter.a(this.b, param1BluedEntity.data);
                  this.b.b();
                } 
              } 
              (LiveListFollowPresenter.h(this.b)).lastUid = liveRecommendExtra.last_id;
              return;
            } 
            this.b.b();
          }
        }null, this.f.page, this.f.lastUid);
    Logger.a("drb", new Object[] { "mRecommendModel.lastUid = ", this.f.lastUid });
  }
  
  public void b() {
    AppInfo.n().post(new Runnable(this) {
          public void run() {
            LiveListFollowPresenter.a(this.a).aM_();
            LiveHttpUtils.a(LiveListFollowPresenter.b(this.a), new BluedUIHttpResponse<BluedEntityA<BluedLiveListData>>(this, (IRequestHost)LiveListFollowPresenter.c(this.a).w_()) {
                  protected BluedEntityA<BluedLiveListData> a(String param2String) {
                    Logger.a(LiveListFollowPresenter.d(this.a.a), new Object[] { "getLiveListFollow, content:", param2String });
                    return (BluedEntityA<BluedLiveListData>)super.parseData(param2String);
                  }
                  
                  public void a(BluedEntityA<BluedLiveListData> param2BluedEntityA) {
                    // Byte code:
                    //   0: aload_1
                    //   1: ifnull -> 457
                    //   4: aload_1
                    //   5: invokevirtual hasData : ()Z
                    //   8: ifeq -> 457
                    //   11: aload_1
                    //   12: invokevirtual hasMore : ()Z
                    //   15: ifeq -> 50
                    //   18: aload_0
                    //   19: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   22: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   25: invokestatic e : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/model/LiveListCommonModel;
                    //   28: iconst_1
                    //   29: invokevirtual setHasData : (Z)V
                    //   32: aload_0
                    //   33: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   36: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   39: invokestatic a : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/contract/LiveListFollowContract$IView;
                    //   42: invokeinterface aO_ : ()V
                    //   47: goto -> 79
                    //   50: aload_0
                    //   51: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   54: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   57: invokestatic e : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/model/LiveListCommonModel;
                    //   60: iconst_0
                    //   61: invokevirtual setHasData : (Z)V
                    //   64: aload_0
                    //   65: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   68: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   71: invokestatic a : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/contract/LiveListFollowContract$IView;
                    //   74: invokeinterface b : ()V
                    //   79: aload_0
                    //   80: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   83: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   86: invokestatic f : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Z
                    //   89: ifne -> 378
                    //   92: aload_0
                    //   93: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   96: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   99: invokestatic g : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Ljava/util/List;
                    //   102: ifnull -> 378
                    //   105: aload_0
                    //   106: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   109: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   112: invokestatic g : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Ljava/util/List;
                    //   115: invokeinterface size : ()I
                    //   120: ifle -> 378
                    //   123: iconst_0
                    //   124: istore_2
                    //   125: iload_2
                    //   126: aload_1
                    //   127: getfield data : Ljava/util/List;
                    //   130: invokeinterface size : ()I
                    //   135: if_icmpge -> 378
                    //   138: aload_1
                    //   139: getfield data : Ljava/util/List;
                    //   142: iload_2
                    //   143: invokeinterface get : (I)Ljava/lang/Object;
                    //   148: checkcast com/soft/blued/ui/live/model/BluedLiveListData
                    //   151: astore_3
                    //   152: aload_3
                    //   153: getfield livetype : I
                    //   156: ifne -> 653
                    //   159: ldc 'ddrb'
                    //   161: iconst_2
                    //   162: anewarray java/lang/Object
                    //   165: dup
                    //   166: iconst_0
                    //   167: ldc '推荐数为：'
                    //   169: aastore
                    //   170: dup
                    //   171: iconst_1
                    //   172: aload_0
                    //   173: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   176: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   179: invokestatic g : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Ljava/util/List;
                    //   182: invokeinterface size : ()I
                    //   187: invokestatic valueOf : (I)Ljava/lang/Integer;
                    //   190: aastore
                    //   191: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
                    //   194: new java/lang/StringBuilder
                    //   197: dup
                    //   198: invokespecial <init> : ()V
                    //   201: astore #4
                    //   203: aload #4
                    //   205: ldc 'position = '
                    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
                    //   210: pop
                    //   211: aload #4
                    //   213: iload_2
                    //   214: invokevirtual append : (I)Ljava/lang/StringBuilder;
                    //   217: pop
                    //   218: ldc 'ddrb'
                    //   220: iconst_1
                    //   221: anewarray java/lang/Object
                    //   224: dup
                    //   225: iconst_0
                    //   226: aload #4
                    //   228: invokevirtual toString : ()Ljava/lang/String;
                    //   231: aastore
                    //   232: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
                    //   235: new com/soft/blued/ui/live/model/BluedLiveListData
                    //   238: dup
                    //   239: invokespecial <init> : ()V
                    //   242: astore #4
                    //   244: aload #4
                    //   246: aload_0
                    //   247: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   250: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   253: invokestatic g : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Ljava/util/List;
                    //   256: putfield liveRecommendModelList : Ljava/util/List;
                    //   259: aload #4
                    //   261: iconst_1
                    //   262: putfield recommendType : I
                    //   265: aload #4
                    //   267: ldc '0'
                    //   269: putfield lid : Ljava/lang/String;
                    //   272: aload #4
                    //   274: new com/soft/blued/ui/find/model/UserBasicModel
                    //   277: dup
                    //   278: invokespecial <init> : ()V
                    //   281: putfield anchor : Lcom/soft/blued/ui/find/model/UserBasicModel;
                    //   284: aload_3
                    //   285: getfield anchor : Lcom/soft/blued/ui/find/model/UserBasicModel;
                    //   288: ifnull -> 351
                    //   291: aload #4
                    //   293: getfield anchor : Lcom/soft/blued/ui/find/model/UserBasicModel;
                    //   296: aload_3
                    //   297: getfield anchor : Lcom/soft/blued/ui/find/model/UserBasicModel;
                    //   300: getfield uid : Ljava/lang/String;
                    //   303: putfield uid : Ljava/lang/String;
                    //   306: aload #4
                    //   308: getfield anchor : Lcom/soft/blued/ui/find/model/UserBasicModel;
                    //   311: aload_3
                    //   312: getfield anchor : Lcom/soft/blued/ui/find/model/UserBasicModel;
                    //   315: getfield name : Ljava/lang/String;
                    //   318: putfield name : Ljava/lang/String;
                    //   321: aload #4
                    //   323: getfield anchor : Lcom/soft/blued/ui/find/model/UserBasicModel;
                    //   326: aload_3
                    //   327: getfield anchor : Lcom/soft/blued/ui/find/model/UserBasicModel;
                    //   330: getfield avatar : Ljava/lang/String;
                    //   333: putfield avatar : Ljava/lang/String;
                    //   336: aload #4
                    //   338: getfield anchor : Lcom/soft/blued/ui/find/model/UserBasicModel;
                    //   341: aload_3
                    //   342: getfield anchor : Lcom/soft/blued/ui/find/model/UserBasicModel;
                    //   345: getfield vbadge : I
                    //   348: putfield vbadge : I
                    //   351: aload_1
                    //   352: getfield data : Ljava/util/List;
                    //   355: iload_2
                    //   356: aload #4
                    //   358: invokeinterface add : (ILjava/lang/Object;)V
                    //   363: aload_0
                    //   364: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   367: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   370: iconst_1
                    //   371: invokestatic a : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;Z)Z
                    //   374: pop
                    //   375: goto -> 378
                    //   378: aload_0
                    //   379: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   382: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   385: invokestatic a : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/contract/LiveListFollowContract$IView;
                    //   388: aload_1
                    //   389: getfield data : Ljava/util/List;
                    //   392: invokeinterface a : (Ljava/util/List;)V
                    //   397: aload_0
                    //   398: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   401: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   404: invokestatic a : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/contract/LiveListFollowContract$IView;
                    //   407: invokeinterface h : ()V
                    //   412: aload_0
                    //   413: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   416: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   419: invokestatic a : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/contract/LiveListFollowContract$IView;
                    //   422: invokeinterface a : ()V
                    //   427: aload_0
                    //   428: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   431: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   434: invokestatic e : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/model/LiveListCommonModel;
                    //   437: iconst_1
                    //   438: invokevirtual setHasFollowData : (Z)V
                    //   441: aload_0
                    //   442: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   445: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   448: invokestatic a : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/contract/LiveListFollowContract$IView;
                    //   451: invokeinterface i : ()V
                    //   456: return
                    //   457: aload_0
                    //   458: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   461: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   464: invokestatic a : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/contract/LiveListFollowContract$IView;
                    //   467: aload_1
                    //   468: getfield data : Ljava/util/List;
                    //   471: invokeinterface a : (Ljava/util/List;)V
                    //   476: aload_0
                    //   477: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   480: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   483: invokestatic a : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/contract/LiveListFollowContract$IView;
                    //   486: invokeinterface b : ()V
                    //   491: aload_0
                    //   492: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   495: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   498: invokestatic a : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/contract/LiveListFollowContract$IView;
                    //   501: invokeinterface i : ()V
                    //   506: aload_0
                    //   507: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   510: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   513: invokestatic e : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/model/LiveListCommonModel;
                    //   516: invokevirtual getPage : ()I
                    //   519: iconst_1
                    //   520: if_icmpeq -> 552
                    //   523: aload_0
                    //   524: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   527: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   530: invokestatic e : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/model/LiveListCommonModel;
                    //   533: aload_0
                    //   534: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   537: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   540: invokestatic e : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/model/LiveListCommonModel;
                    //   543: invokevirtual getPage : ()I
                    //   546: iconst_1
                    //   547: isub
                    //   548: invokevirtual setPage : (I)V
                    //   551: return
                    //   552: aload_0
                    //   553: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   556: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   559: invokestatic e : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/model/LiveListCommonModel;
                    //   562: iconst_0
                    //   563: invokevirtual setHasFollowData : (Z)V
                    //   566: aload_0
                    //   567: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   570: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   573: invokestatic e : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/model/LiveListCommonModel;
                    //   576: iconst_0
                    //   577: invokevirtual setTipShow : (Z)V
                    //   580: return
                    //   581: astore_1
                    //   582: aload_1
                    //   583: invokevirtual printStackTrace : ()V
                    //   586: aload_0
                    //   587: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   590: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   593: invokestatic e : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/model/LiveListCommonModel;
                    //   596: invokevirtual getPage : ()I
                    //   599: iconst_1
                    //   600: if_icmpeq -> 631
                    //   603: aload_0
                    //   604: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   607: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   610: invokestatic e : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/model/LiveListCommonModel;
                    //   613: aload_0
                    //   614: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   617: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   620: invokestatic e : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Lcom/soft/blued/ui/live/model/LiveListCommonModel;
                    //   623: invokevirtual getPage : ()I
                    //   626: iconst_1
                    //   627: isub
                    //   628: invokevirtual setPage : (I)V
                    //   631: aload_0
                    //   632: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter$2;
                    //   635: getfield a : Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;
                    //   638: invokestatic b : (Lcom/soft/blued/ui/live/presenter/LiveListFollowPresenter;)Landroid/content/Context;
                    //   641: invokevirtual getResources : ()Landroid/content/res/Resources;
                    //   644: ldc 2131756082
                    //   646: invokevirtual getString : (I)Ljava/lang/String;
                    //   649: invokestatic a : (Ljava/lang/CharSequence;)V
                    //   652: return
                    //   653: iload_2
                    //   654: iconst_1
                    //   655: iadd
                    //   656: istore_2
                    //   657: goto -> 125
                    // Exception table:
                    //   from	to	target	type
                    //   4	47	581	java/lang/Exception
                    //   50	79	581	java/lang/Exception
                    //   79	123	581	java/lang/Exception
                    //   125	351	581	java/lang/Exception
                    //   351	375	581	java/lang/Exception
                    //   378	456	581	java/lang/Exception
                    //   457	551	581	java/lang/Exception
                    //   552	580	581	java/lang/Exception
                  }
                  
                  public void onFailure(Throwable param2Throwable, int param2Int, String param2String) {
                    super.onFailure(param2Throwable, param2Int, param2String);
                    if (LiveListFollowPresenter.e(this.a.a).getPage() != 1)
                      LiveListFollowPresenter.e(this.a.a).setPage(LiveListFollowPresenter.e(this.a.a).getPage() - 1); 
                  }
                  
                  public void onUIFinish() {
                    Logger.a(LiveListFollowPresenter.d(this.a.a), new Object[] { "onFinish" });
                    LiveListFollowPresenter.a(this.a.a).e();
                    LiveListFollowPresenter.a(this.a.a).c();
                    LiveListFollowPresenter.a(this.a.a).k();
                    LiveListFollowPresenter.a(this.a.a).a(false);
                  }
                }UserInfo.a().i().getUid(), String.valueOf(LiveListFollowPresenter.e(this.a).getPage()), (IRequestHost)LiveListFollowPresenter.c(this.a).w_());
          }
        });
  }
  
  public void bb_() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\presenter\LiveListFollowPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */