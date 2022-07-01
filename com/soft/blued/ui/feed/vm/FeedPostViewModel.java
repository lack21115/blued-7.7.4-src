package com.soft.blued.ui.feed.vm;

import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.location.LocationService;
import com.blued.android.module.location.listener.OnPoiRequestListener;
import com.blued.android.module.location.model.LocationPOIModel;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.statistics.BluedStatistics;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.adapter.SuperTopicAdapter;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.ui.feed.model.BluedTopicExtra;
import com.soft.blued.ui.msg.model.PositionPOIModel;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000t\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\t\n\002\020\013\n\002\b\025\n\002\020!\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\017\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\025\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\b\030\0002\0020\001:\001wB\005¢\006\002\020\002J\006\020g\032\0020\026J\006\020h\032\0020\005J\026\020i\032\0020j2\006\020k\032\0020\0262\006\020l\032\0020mJ\036\020n\032\0020j2\006\020o\032\0020p2\006\020k\032\0020\0262\006\020q\032\0020\fJ\006\020r\032\0020jJ\036\020s\032\0020j2\006\020k\032\0020\0262\006\020t\032\0020\f2\006\020l\032\0020mJ\006\020u\032\0020jJ\006\020v\032\0020\026R\027\020\003\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\006\020\007R\027\020\b\032\b\022\004\022\0020\t0\004¢\006\b\n\000\032\004\b\n\020\007R\027\020\013\032\b\022\004\022\0020\f0\004¢\006\b\n\000\032\004\b\r\020\007R\027\020\016\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\017\020\007R\034\020\020\032\0020\0058FX\016¢\006\016\n\000\032\004\b\021\020\022\"\004\b\023\020\024R\027\020\025\032\b\022\004\022\0020\0260\004¢\006\b\n\000\032\004\b\027\020\007R\032\020\030\032\0020\026X\016¢\006\016\n\000\032\004\b\030\020\031\"\004\b\032\020\033R\032\020\034\032\0020\026X\016¢\006\016\n\000\032\004\b\034\020\031\"\004\b\035\020\033R\027\020\036\032\b\022\004\022\0020\0260\004¢\006\b\n\000\032\004\b\037\020\007R\032\020 \032\0020\fX\016¢\006\016\n\000\032\004\b!\020\"\"\004\b#\020$R\032\020%\032\0020\005X\016¢\006\016\n\000\032\004\b&\020\022\"\004\b'\020\024R\032\020(\032\0020\005X\016¢\006\016\n\000\032\004\b)\020\022\"\004\b*\020\024R\024\020+\032\b\022\004\022\0020-0,X\016¢\006\002\n\000R\035\020.\032\016\022\n\022\b\022\004\022\0020-0,0\004¢\006\b\n\000\032\004\b/\020\007R\016\0200\032\0020\005X\016¢\006\002\n\000R\016\0201\032\0020\005X\016¢\006\002\n\000R\016\0202\032\0020\005XD¢\006\002\n\000R\032\0203\032\00204X\016¢\006\016\n\000\032\004\b5\0206\"\004\b7\0208R\027\0209\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b:\020\007R\035\020;\032\016\022\n\022\b\022\004\022\0020<0,0\004¢\006\b\n\000\032\004\b=\020\007R\032\020>\032\0020\005X\016¢\006\016\n\000\032\004\b?\020\022\"\004\b@\020\024R \020A\032\b\022\004\022\0020\f0\004X\016¢\006\016\n\000\032\004\bB\020\007\"\004\bC\020DR\034\020E\032\004\030\0010\fX\016¢\006\016\n\000\032\004\bF\020\"\"\004\bG\020$R\034\020H\032\004\030\0010\fX\016¢\006\016\n\000\032\004\bI\020\"\"\004\bJ\020$R\027\020K\032\b\022\004\022\0020L0\004¢\006\b\n\000\032\004\bM\020\007R\034\020N\032\004\030\0010\fX\016¢\006\016\n\000\032\004\bO\020\"\"\004\bP\020$R\027\020Q\032\b\022\004\022\0020<0\004¢\006\b\n\000\032\004\bR\020\007R\022\020S\032\006\022\002\b\0030TX\004¢\006\002\n\000R\027\020U\032\b\022\004\022\0020\f0\004¢\006\b\n\000\032\004\bV\020\007R\032\020W\032\0020\005X\016¢\006\016\n\000\032\004\bX\020\022\"\004\bY\020\024R\032\020Z\032\0020\005X\016¢\006\016\n\000\032\004\b[\020\022\"\004\b\\\020\024R\024\020]\032\b\022\004\022\0020<0,X\016¢\006\002\n\000R\035\020^\032\016\022\n\022\b\022\004\022\0020<0,0\004¢\006\b\n\000\032\004\b_\020\007R\027\020`\032\b\022\004\022\0020\0260\004¢\006\b\n\000\032\004\ba\020\007R\022\020b\032\006\022\002\b\0030TX\004¢\006\002\n\000R\027\020c\032\b\022\004\022\0020\0260\004¢\006\b\n\000\032\004\bd\020\007R\027\020e\032\b\022\004\022\0020\0260\004¢\006\b\n\000\032\004\bf\020\007¨\006x"}, d2 = {"Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;", "Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "()V", "albumSelectDialogHeight", "Landroidx/lifecycle/MutableLiveData;", "", "getAlbumSelectDialogHeight", "()Landroidx/lifecycle/MutableLiveData;", "albumSelectInfoLiveData", "Lcom/blued/android/module/media/selector/model/AlbumSelectInfo;", "getAlbumSelectInfoLiveData", "albumSelectRemoveLiveData", "", "getAlbumSelectRemoveLiveData", "commentPermission", "getCommentPermission", "dialogHeight", "getDialogHeight", "()I", "setDialogHeight", "(I)V", "footerViewTextLiveData", "", "getFooterViewTextLiveData", "isPeek", "()Z", "setPeek", "(Z)V", "isTopicHasData", "setTopicHasData", "locationHasMoreListLiveData", "getLocationHasMoreListLiveData", "locationKeyWords", "getLocationKeyWords", "()Ljava/lang/String;", "setLocationKeyWords", "(Ljava/lang/String;)V", "locationLastOffset", "getLocationLastOffset", "setLocationLastOffset", "locationLastPosition", "getLocationLastPosition", "setLocationLastPosition", "locationList", "", "Lcom/soft/blued/ui/msg/model/PositionPOIModel;", "locationListLiveData", "getLocationListLiveData", "mLocationPage", "mTopicPage", "mTopicSize", "postType", "Lcom/blued/das/client/feed/FeedProtos$FeedType;", "getPostType", "()Lcom/blued/das/client/feed/FeedProtos$FeedType;", "setPostType", "(Lcom/blued/das/client/feed/FeedProtos$FeedType;)V", "readAuthPermission", "getReadAuthPermission", "recommendTopicListLiveData", "Lcom/soft/blued/ui/feed/model/BluedTopic;", "getRecommendTopicListLiveData", "searchLvl", "getSearchLvl", "setSearchLvl", "selectAddressLiveData", "getSelectAddressLiveData", "setSelectAddressLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "selectLat", "getSelectLat", "setSelectLat", "selectLng", "getSelectLng", "setSelectLng", "shineOrTakePhotoLiveData", "Landroid/content/Intent;", "getShineOrTakePhotoLiveData", "superTopicAvatar", "getSuperTopicAvatar", "setSuperTopicAvatar", "superTopicLiveData", "getSuperTopicLiveData", "topicHotCallBack", "Lcom/blued/android/framework/http/BluedUIHttpResponse;", "topicKeyWords", "getTopicKeyWords", "topicLastOffset", "getTopicLastOffset", "setTopicLastOffset", "topicLastPosition", "getTopicLastPosition", "setTopicLastPosition", "topicList", "topicListLiveData", "getTopicListLiveData", "topicLoadSuccessLiveData", "getTopicLoadSuccessLiveData", "topicSearchCallBack", "topicShowNoDataLiveData", "getTopicShowNoDataLiveData", "updatePhotoLiveData", "getUpdatePhotoLiveData", "addSearchLvl", "getFooterViewText", "getHotTopicList", "", "outRefresh", "superTopicAdapter", "Lcom/soft/blued/ui/feed/adapter/SuperTopicAdapter;", "getPOIList", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "keyWords", "getRecommendTopicList", "getTopicSearch", "searchKeyWord", "initSearchLvl", "isSuperTopic", "SEARCH_LVL", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class FeedPostViewModel extends BaseViewModel {
  private final MutableLiveData<Boolean> A = new MutableLiveData();
  
  private final MutableLiveData<Integer> B = new MutableLiveData();
  
  private final MutableLiveData<AlbumSelectInfo> C = new MutableLiveData();
  
  private final MutableLiveData<Intent> D = new MutableLiveData();
  
  private final MutableLiveData<String> E = new MutableLiveData();
  
  private boolean F = true;
  
  private final MutableLiveData<Boolean> G = new MutableLiveData();
  
  private FeedProtos.FeedType H = FeedProtos.FeedType.UNKNOWN_FEED_TYPE;
  
  private int I;
  
  private final BluedUIHttpResponse<?> J;
  
  private final BluedUIHttpResponse<?> K;
  
  private final MutableLiveData<Integer> a = new MutableLiveData();
  
  private final MutableLiveData<Integer> b = new MutableLiveData();
  
  private final MutableLiveData<List<BluedTopic>> c = new MutableLiveData();
  
  private final MutableLiveData<BluedTopic> d = new MutableLiveData();
  
  private String e;
  
  private int f;
  
  private int g;
  
  private int h = 1;
  
  private final int i = 20;
  
  private boolean j = true;
  
  private List<BluedTopic> k = new ArrayList<BluedTopic>();
  
  private final MutableLiveData<List<BluedTopic>> l = new MutableLiveData();
  
  private final MutableLiveData<String> m = new MutableLiveData();
  
  private final MutableLiveData<Boolean> n = new MutableLiveData();
  
  private final MutableLiveData<Boolean> o = new MutableLiveData();
  
  private MutableLiveData<String> p = new MutableLiveData();
  
  private String q;
  
  private String r;
  
  private int s;
  
  private int t;
  
  private int u;
  
  private String v = "";
  
  private int w;
  
  private final MutableLiveData<Boolean> x = new MutableLiveData();
  
  private List<PositionPOIModel> y = new ArrayList<PositionPOIModel>();
  
  private final MutableLiveData<List<PositionPOIModel>> z = new MutableLiveData();
  
  public FeedPostViewModel() {
    MutableLiveData<Integer> mutableLiveData = this.a;
    Integer integer = Integer.valueOf(0);
    mutableLiveData.setValue(integer);
    this.b.setValue(integer);
    this.J = new FeedPostViewModel$topicHotCallBack$1(this);
    this.K = new FeedPostViewModel$topicSearchCallBack$1(this);
  }
  
  public final MutableLiveData<Intent> A() {
    return this.D;
  }
  
  public final MutableLiveData<String> B() {
    return this.E;
  }
  
  public final boolean C() {
    return this.F;
  }
  
  public final MutableLiveData<Boolean> D() {
    return this.G;
  }
  
  public final FeedProtos.FeedType E() {
    return this.H;
  }
  
  public final int F() {
    int i = this.I;
    return (i > 0) ? i : (AppInfo.m - StatusBarHelper.a(AppInfo.d()));
  }
  
  public final boolean G() {
    if (this.d.getValue() != null) {
      BluedTopic bluedTopic1 = (BluedTopic)this.d.getValue();
      BluedTopic bluedTopic2 = null;
      if (bluedTopic1 != null) {
        String str = bluedTopic1.name;
      } else {
        bluedTopic1 = null;
      } 
      if (!TextUtils.isEmpty((CharSequence)bluedTopic1)) {
        String str;
        BluedTopic bluedTopic = (BluedTopic)this.d.getValue();
        bluedTopic1 = bluedTopic2;
        if (bluedTopic != null)
          str = bluedTopic.super_did; 
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(this.e))
          return true; 
      } 
    } 
    return false;
  }
  
  public final void H() {
    FeedHttpUtils.a(new FeedPostViewModel$getRecommendTopicList$1(this), null);
  }
  
  public final void I() {
    this.w = 0;
  }
  
  public final boolean J() {
    int i = this.w;
    if (i + 1 >= 2) {
      this.w = 2;
      return true;
    } 
    this.w = i + 1;
    return false;
  }
  
  public final int K() {
    return (this.w == 1) ? 2131756369 : 2131756368;
  }
  
  public final void a(int paramInt) {
    this.f = paramInt;
  }
  
  public final void a(LifecycleOwner paramLifecycleOwner, boolean paramBoolean, String paramString) {
    Intrinsics.b(paramLifecycleOwner, "lifecycleOwner");
    Intrinsics.b(paramString, "keyWords");
    if (paramBoolean) {
      this.u = 0;
    } else {
      this.u++;
    } 
    this.v = paramString;
    FeedPostViewModel$getPOIList$poiRequestListener$1 feedPostViewModel$getPOIList$poiRequestListener$1 = new FeedPostViewModel$getPOIList$poiRequestListener$1(this);
    if (StringUtils.e(paramString)) {
      LocationService.a(paramLifecycleOwner, this.u, feedPostViewModel$getPOIList$poiRequestListener$1);
      return;
    } 
    int i = this.w;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          LocationService.c(paramLifecycleOwner, this.u, paramString, feedPostViewModel$getPOIList$poiRequestListener$1);
          return;
        } 
        LocationService.a(paramLifecycleOwner, this.u, paramString, feedPostViewModel$getPOIList$poiRequestListener$1);
        return;
      } 
      LocationService.b(paramLifecycleOwner, this.u, paramString, feedPostViewModel$getPOIList$poiRequestListener$1);
      return;
    } 
    LocationService.c(paramLifecycleOwner, this.u, paramString, feedPostViewModel$getPOIList$poiRequestListener$1);
  }
  
  public final void a(FeedProtos.FeedType paramFeedType) {
    Intrinsics.b(paramFeedType, "<set-?>");
    this.H = paramFeedType;
  }
  
  public final void a(String paramString) {
    this.e = paramString;
  }
  
  public final void a(boolean paramBoolean, SuperTopicAdapter paramSuperTopicAdapter) {
    Intrinsics.b(paramSuperTopicAdapter, "superTopicAdapter");
    if (paramBoolean) {
      this.h = 1;
    } else {
      this.h++;
    } 
    if (this.h == 1)
      this.j = true; 
    if (!this.j) {
      int i = this.h;
      if (i != 1) {
        this.h = i - 1;
        AppMethods.a(AppInfo.d().getString(2131756083));
        paramSuperTopicAdapter.k();
        return;
      } 
    } 
    this.m.setValue("");
    FeedHttpUtils.a(AppInfo.d(), this.J, this.h, this.i, null);
  }
  
  public final void a(boolean paramBoolean, String paramString, SuperTopicAdapter paramSuperTopicAdapter) {
    Intrinsics.b(paramString, "searchKeyWord");
    Intrinsics.b(paramSuperTopicAdapter, "superTopicAdapter");
    if (paramBoolean) {
      this.h = 1;
    } else {
      this.h++;
    } 
    if (this.h == 1)
      this.j = true; 
    if (!this.j) {
      int i = this.h;
      if (i != 1) {
        this.h = i - 1;
        AppMethods.d(2131756083);
        paramSuperTopicAdapter.k();
        return;
      } 
    } 
    EventTrackFeed.e(FeedProtos.Event.SUPER_TOPIC_SEARCH_KEYWORD, paramString);
    FeedHttpUtils.a(this.K, this.h, this.i, paramString, null);
  }
  
  public final void b(int paramInt) {
    this.g = paramInt;
  }
  
  public final void b(String paramString) {
    this.q = paramString;
  }
  
  public final MutableLiveData<Integer> c() {
    return this.a;
  }
  
  public final void c(int paramInt) {
    this.s = paramInt;
  }
  
  public final void c(String paramString) {
    this.r = paramString;
  }
  
  public final void c(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public final MutableLiveData<Integer> d() {
    return this.b;
  }
  
  public final void d(int paramInt) {
    this.t = paramInt;
  }
  
  public final void d(boolean paramBoolean) {
    this.F = paramBoolean;
  }
  
  public final MutableLiveData<List<BluedTopic>> e() {
    return this.c;
  }
  
  public final void e(int paramInt) {
    this.I = paramInt;
  }
  
  public final MutableLiveData<BluedTopic> f() {
    return this.d;
  }
  
  public final String g() {
    return this.e;
  }
  
  public final int h() {
    return this.f;
  }
  
  public final int i() {
    return this.g;
  }
  
  public final boolean j() {
    return this.j;
  }
  
  public final MutableLiveData<List<BluedTopic>> k() {
    return this.l;
  }
  
  public final MutableLiveData<String> l() {
    return this.m;
  }
  
  public final MutableLiveData<Boolean> m() {
    return this.n;
  }
  
  public final MutableLiveData<Boolean> n() {
    return this.o;
  }
  
  public final MutableLiveData<String> o() {
    return this.p;
  }
  
  public final String p() {
    return this.q;
  }
  
  public final String q() {
    return this.r;
  }
  
  public final int r() {
    return this.s;
  }
  
  public final int s() {
    return this.t;
  }
  
  public final String t() {
    return this.v;
  }
  
  public final int u() {
    return this.w;
  }
  
  public final MutableLiveData<Boolean> v() {
    return this.x;
  }
  
  public final MutableLiveData<List<PositionPOIModel>> w() {
    return this.z;
  }
  
  public final MutableLiveData<Boolean> x() {
    return this.A;
  }
  
  public final MutableLiveData<Integer> y() {
    return this.B;
  }
  
  public final MutableLiveData<AlbumSelectInfo> z() {
    return this.C;
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\f\n\002\030\002\n\002\020\000\n\002\b\002\bf\030\000 \0022\0020\001:\001\002¨\006\003"}, d2 = {"Lcom/soft/blued/ui/feed/vm/FeedPostViewModel$SEARCH_LVL;", "", "Companion", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static interface SEARCH_LVL {
    public static final Companion a = Companion.a;
    
    @Metadata(bv = {1, 0, 3}, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000R\016\020\006\032\0020\004XT¢\006\002\n\000¨\006\007"}, d2 = {"Lcom/soft/blued/ui/feed/vm/FeedPostViewModel$SEARCH_LVL$Companion;", "", "()V", "CITY_KEY_WORD", "", "COUNTRY_KEY_WORD", "NEARBY_KEY_WORD", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {}
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000R\016\020\006\032\0020\004XT¢\006\002\n\000¨\006\007"}, d2 = {"Lcom/soft/blued/ui/feed/vm/FeedPostViewModel$SEARCH_LVL$Companion;", "", "()V", "CITY_KEY_WORD", "", "COUNTRY_KEY_WORD", "NEARBY_KEY_WORD", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class Companion {}
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\036\n\000\n\002\020\002\n\000\n\002\020\b\n\000\n\002\020 \n\002\030\002\n\000\n\002\020\013\n\000\020\000\032\0020\0012\006\020\002\032\0020\0032\020\020\004\032\f\022\006\022\004\030\0010\006\030\0010\0052\006\020\007\032\0020\bH\n¢\006\002\b\t"}, d2 = {"<anonymous>", "", "errorCode", "", "mList", "", "Lcom/blued/android/module/location/model/LocationPOIModel;", "hasMore", "", "onComplete"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostViewModel$getPOIList$poiRequestListener$1 implements OnPoiRequestListener {
    FeedPostViewModel$getPOIList$poiRequestListener$1(FeedPostViewModel param1FeedPostViewModel) {}
    
    public final void onComplete(int param1Int, List<? extends LocationPOIModel> param1List, boolean param1Boolean) {
      if (param1Int != 0)
        BluedStatistics.c().a("FEED_POI", 0L, param1Int, null); 
      if (param1Int == 0) {
        if (FeedPostViewModel.a(this.a) == 0 && this.a.u() == 0) {
          ArrayList<PositionPOIModel> arrayList = new ArrayList();
          if (param1List == null)
            Intrinsics.a(); 
          int i = param1List.size();
          for (param1Int = 0; param1Int < i; param1Int++) {
            PositionPOIModel positionPOIModel = PositionPOIModel.getFromLocationPOIModel(param1List.get(param1Int));
            Intrinsics.a(positionPOIModel, "ppModel");
            arrayList.add(positionPOIModel);
          } 
          FeedPostViewModel.a(this.a, arrayList);
          this.a.w().setValue(FeedPostViewModel.b(this.a));
        } else if (param1List != null) {
          List<? extends LocationPOIModel> list = param1List;
          if ((list.isEmpty() ^ true) != 0) {
            ArrayList<PositionPOIModel> arrayList = new ArrayList();
            int i = list.size();
            for (param1Int = 0; param1Int < i; param1Int++) {
              PositionPOIModel positionPOIModel = PositionPOIModel.getFromLocationPOIModel(param1List.get(param1Int));
              Intrinsics.a(positionPOIModel, "ppModel");
              arrayList.add(positionPOIModel);
            } 
            FeedPostViewModel.b(this.a).addAll(arrayList);
            this.a.w().setValue(FeedPostViewModel.b(this.a));
          } 
        } 
        if (!param1Boolean) {
          MutableLiveData<Boolean> mutableLiveData = this.a.v();
          if (this.a.u() < 2) {
            param1Boolean = true;
          } else {
            param1Boolean = false;
          } 
          mutableLiveData.setValue(Boolean.valueOf(param1Boolean));
          this.a.x().setValue(Boolean.valueOf(false));
        } else {
          this.a.v().setValue(Boolean.valueOf(false));
          this.a.x().setValue(Boolean.valueOf(true));
        } 
      } else if (FeedPostViewModel.a(this.a) == 0 && this.a.u() == 0) {
        FeedPostViewModel.b(this.a).clear();
        this.a.w().setValue(FeedPostViewModel.b(this.a));
        this.a.v().setValue(Boolean.valueOf(true));
      } 
      this.a.x().setValue(Boolean.valueOf(true));
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\033\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\002\b\002*\001\000\b\n\030\0002\020\022\f\022\n\022\004\022\0020\003\030\0010\0020\001J\030\020\004\032\0020\0052\016\020\006\032\n\022\004\022\0020\003\030\0010\002H\024¨\006\007"}, d2 = {"com/soft/blued/ui/feed/vm/FeedPostViewModel$getRecommendTopicList$1", "Lcom/blued/android/framework/http/BluedUIHttpResponse;", "Lcom/blued/android/framework/http/parser/BluedEntityA;", "Lcom/soft/blued/ui/feed/model/BluedTopic;", "onUIUpdate", "", "parseData", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class FeedPostViewModel$getRecommendTopicList$1 extends BluedUIHttpResponse<BluedEntityA<BluedTopic>> {
    FeedPostViewModel$getRecommendTopicList$1(FeedPostViewModel param1FeedPostViewModel) {}
    
    protected void a(BluedEntityA<BluedTopic> param1BluedEntityA) {
      if (param1BluedEntityA != null)
        this.a.e().setValue(param1BluedEntityA.data); 
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000%\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\013\n\002\b\003*\001\000\b\n\030\0002\026\022\022\022\020\022\004\022\0020\003\022\004\022\0020\004\030\0010\0020\001J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\024J\036\020\t\032\0020\0062\024\020\n\032\020\022\004\022\0020\003\022\004\022\0020\004\030\0010\002H\024¨\006\013"}, d2 = {"com/soft/blued/ui/feed/vm/FeedPostViewModel$topicHotCallBack$1", "Lcom/blued/android/framework/http/BluedUIHttpResponse;", "Lcom/blued/android/framework/http/parser/BluedEntity;", "Lcom/soft/blued/ui/feed/model/BluedTopic;", "Lcom/soft/blued/ui/feed/model/BluedTopicExtra;", "onUIFinish", "", "success", "", "onUIUpdate", "parseData", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class FeedPostViewModel$topicHotCallBack$1 extends BluedUIHttpResponse<BluedEntity<BluedTopic, BluedTopicExtra>> {
    FeedPostViewModel$topicHotCallBack$1(FeedPostViewModel param1FeedPostViewModel) {}
    
    public void onUIFinish(boolean param1Boolean) {
      onUIFinish();
      this.a.m().setValue(Boolean.valueOf(param1Boolean));
      this.a.n().setValue(Boolean.valueOf(param1Boolean));
      if (!param1Boolean && FeedPostViewModel.c(this.a) != 1) {
        FeedPostViewModel feedPostViewModel = this.a;
        FeedPostViewModel.a(feedPostViewModel, FeedPostViewModel.c(feedPostViewModel) - 1);
      } 
    }
    
    public void onUIUpdate(BluedEntity<BluedTopic, BluedTopicExtra> param1BluedEntity) {
      if (param1BluedEntity != null && param1BluedEntity.hasData()) {
        this.a.c(param1BluedEntity.hasMore());
        if (FeedPostViewModel.c(this.a) == 1) {
          FeedPostViewModel feedPostViewModel = this.a;
          list1 = param1BluedEntity.data;
          Intrinsics.a(list1, "parseData.data");
          FeedPostViewModel.b(feedPostViewModel, list1);
          this.a.k().setValue(FeedPostViewModel.d(this.a));
          return;
        } 
        List list2 = FeedPostViewModel.d(this.a);
        List list1 = ((BluedEntity)list1).data;
        Intrinsics.a(list1, "parseData.data");
        list2.addAll(list1);
        this.a.k().setValue(FeedPostViewModel.d(this.a));
      } 
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000%\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\013\n\002\b\003*\001\000\b\n\030\0002\026\022\022\022\020\022\004\022\0020\003\022\004\022\0020\004\030\0010\0020\001J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\024J\036\020\t\032\0020\0062\024\020\n\032\020\022\004\022\0020\003\022\004\022\0020\004\030\0010\002H\024¨\006\013"}, d2 = {"com/soft/blued/ui/feed/vm/FeedPostViewModel$topicSearchCallBack$1", "Lcom/blued/android/framework/http/BluedUIHttpResponse;", "Lcom/blued/android/framework/http/parser/BluedEntity;", "Lcom/soft/blued/ui/feed/model/BluedTopic;", "Lcom/soft/blued/ui/feed/model/BluedTopicExtra;", "onUIFinish", "", "success", "", "onUIUpdate", "parseData", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class FeedPostViewModel$topicSearchCallBack$1 extends BluedUIHttpResponse<BluedEntity<BluedTopic, BluedTopicExtra>> {
    FeedPostViewModel$topicSearchCallBack$1(FeedPostViewModel param1FeedPostViewModel) {}
    
    public void onUIFinish(boolean param1Boolean) {
      onUIFinish();
      this.a.m().setValue(Boolean.valueOf(param1Boolean));
      this.a.n().setValue(Boolean.valueOf(param1Boolean));
      if (!param1Boolean && FeedPostViewModel.c(this.a) != 1) {
        FeedPostViewModel feedPostViewModel = this.a;
        FeedPostViewModel.a(feedPostViewModel, FeedPostViewModel.c(feedPostViewModel) - 1);
      } 
    }
    
    public void onUIUpdate(BluedEntity<BluedTopic, BluedTopicExtra> param1BluedEntity) {
      if (param1BluedEntity != null) {
        BluedTopicExtra bluedTopicExtra = (BluedTopicExtra)param1BluedEntity.extra;
        if (bluedTopicExtra != null && bluedTopicExtra.topics_exist == 0)
          this.a.m().setValue(Boolean.valueOf(true)); 
        if (param1BluedEntity.hasData()) {
          this.a.c(param1BluedEntity.hasMore());
          if (FeedPostViewModel.c(this.a) == 1 && bluedTopicExtra != null && !TextUtils.isEmpty(bluedTopicExtra.q)) {
            this.a.l().setValue(bluedTopicExtra.q);
            FeedPostViewModel feedPostViewModel = this.a;
            list1 = param1BluedEntity.data;
            Intrinsics.a(list1, "parseData.data");
            FeedPostViewModel.b(feedPostViewModel, list1);
            this.a.k().setValue(FeedPostViewModel.d(this.a));
            return;
          } 
          List list2 = FeedPostViewModel.d(this.a);
          List list1 = ((BluedEntity)list1).data;
          Intrinsics.a(list1, "parseData.data");
          list2.addAll(list1);
          this.a.k().setValue(FeedPostViewModel.d(this.a));
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\vm\FeedPostViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */