package com.soft.blued.ui.circle.vm;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.ui.circle.model.CircleTypeListModel;
import com.soft.blued.ui.circle.model.CircleTypeModel;
import com.soft.blued.ui.circle.model.MyCircleExtra;
import com.soft.blued.ui.circle.model.MyCircleModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000X\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020%\n\002\020\016\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\n\002\020 \n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\005\n\002\020\013\n\002\b\016\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\t\030\0002\0020\001B\005¢\006\002\020\002J\032\020(\032\0020)2\b\b\002\020*\032\0020\0322\006\020+\032\0020,H\002J\006\020-\032\0020)J\006\020.\032\0020\024J\006\020/\032\0020\006J\022\0200\032\0020)2\b\0201\032\004\030\00102H\026J\006\0203\032\0020\032J\006\0204\032\0020)J\016\0205\032\0020)2\006\020+\032\0020,J\016\0206\032\0020)2\006\020+\032\0020,J\016\0207\032\0020)2\006\0208\032\0020\032J\016\0209\032\0020)2\006\020:\032\0020\024R&\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0060\004X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\027\020\013\032\b\022\004\022\0020\0060\f¢\006\b\n\000\032\004\b\r\020\016R\035\020\017\032\016\022\n\022\b\022\004\022\0020\0210\0200\f¢\006\b\n\000\032\004\b\022\020\016R\032\020\023\032\0020\024X\016¢\006\016\n\000\032\004\b\025\020\026\"\004\b\027\020\030R\032\020\031\032\0020\032X\016¢\006\016\n\000\032\004\b\031\020\033\"\004\b\034\020\035R\032\020\036\032\0020\024X\016¢\006\016\n\000\032\004\b\037\020\026\"\004\b \020\030R\032\020!\032\0020\005X\016¢\006\016\n\000\032\004\b\"\020#\"\004\b$\020%R\027\020&\032\b\022\004\022\0020\0320\f¢\006\b\n\000\032\004\b'\020\016¨\006;"}, d2 = {"Lcom/soft/blued/ui/circle/vm/CircleTypeListViewModel;", "Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "()V", "circleListCache", "", "", "Lcom/soft/blued/ui/circle/model/CircleTypeListModel;", "getCircleListCache", "()Ljava/util/Map;", "setCircleListCache", "(Ljava/util/Map;)V", "circleListLiveData", "Landroidx/lifecycle/MutableLiveData;", "getCircleListLiveData", "()Landroidx/lifecycle/MutableLiveData;", "circleTypeListLiveData", "", "Lcom/soft/blued/ui/circle/model/CircleTypeModel$DataBean;", "getCircleTypeListLiveData", "classifyId", "", "getClassifyId", "()I", "setClassifyId", "(I)V", "isClickType", "", "()Z", "setClickType", "(Z)V", "size", "getSize", "setSize", "typeId", "getTypeId", "()Ljava/lang/String;", "setTypeId", "(Ljava/lang/String;)V", "typeListLiveData", "getTypeListLiveData", "getCircleListData", "", "isRefresh", "requestActive", "Lcom/blued/android/core/net/IRequestHost;", "getCircleTypeData", "getPage", "getTypeListMode", "init", "arguments", "Landroid/os/Bundle;", "isHasCache", "onLoadCache", "onLoadMoreData", "onRefreshData", "setLoadState", "success", "setPage", "page", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class CircleTypeListViewModel extends BaseViewModel {
  private final MutableLiveData<CircleTypeListModel> a = new MutableLiveData();
  
  private final MutableLiveData<List<CircleTypeModel.DataBean>> b = new MutableLiveData();
  
  private final MutableLiveData<Boolean> c = new MutableLiveData();
  
  private int d = 20;
  
  private String e = "";
  
  private int f = -1;
  
  private Map<String, CircleTypeListModel> g = new LinkedHashMap<String, CircleTypeListModel>();
  
  private boolean h;
  
  private final void a(boolean paramBoolean, IRequestHost paramIRequestHost) {
    boolean bool;
    if (((CharSequence)this.e).length() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      return; 
    CircleHttpUtils.a(new CircleTypeListViewModel$getCircleListData$1(this, paramBoolean, paramIRequestHost, paramIRequestHost), k(), this.d, this.e);
  }
  
  public final void a(int paramInt) {
    this.f = paramInt;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    j();
  }
  
  public final void a(IRequestHost paramIRequestHost) {
    Intrinsics.b(paramIRequestHost, "requestActive");
    b(1);
    a(true, paramIRequestHost);
  }
  
  public final void a(String paramString) {
    Intrinsics.b(paramString, "<set-?>");
    this.e = paramString;
  }
  
  public final void b(int paramInt) {
    CircleTypeListModel circleTypeListModel = this.g.get(this.e);
    if (circleTypeListModel != null)
      circleTypeListModel.setPage(paramInt); 
  }
  
  public final void b(IRequestHost paramIRequestHost) {
    Intrinsics.b(paramIRequestHost, "requestActive");
    b(k() + 1);
    a(false, paramIRequestHost);
  }
  
  public final MutableLiveData<CircleTypeListModel> c() {
    return this.a;
  }
  
  public final void c(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public final MutableLiveData<List<CircleTypeModel.DataBean>> d() {
    return this.b;
  }
  
  public final void d(boolean paramBoolean) {
    CircleTypeListModel circleTypeListModel = this.g.get(this.e);
    if (circleTypeListModel != null)
      circleTypeListModel.setSuccess(paramBoolean); 
  }
  
  public final MutableLiveData<Boolean> e() {
    return this.c;
  }
  
  public final int f() {
    return this.f;
  }
  
  public final boolean g() {
    return this.h;
  }
  
  public final boolean h() {
    return (this.g.get(this.e) != null);
  }
  
  public final void i() {
    this.a.setValue(l());
    b(l().getHasMore());
  }
  
  public final void j() {
    CircleHttpUtils.a(new CircleTypeListViewModel$getCircleTypeData$1(this));
  }
  
  public final int k() {
    CircleTypeListModel circleTypeListModel = this.g.get(this.e);
    return (circleTypeListModel != null) ? circleTypeListModel.getPage() : 1;
  }
  
  public final CircleTypeListModel l() {
    CircleTypeListModel circleTypeListModel = this.g.get(this.e);
    if (circleTypeListModel == null)
      circleTypeListModel = new CircleTypeListModel(); 
    this.g.put(this.e, circleTypeListModel);
    return circleTypeListModel;
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000%\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\013\n\002\b\003*\001\000\b\n\030\0002\026\022\022\022\020\022\004\022\0020\003\022\004\022\0020\004\030\0010\0020\001J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\024J\036\020\t\032\0020\0062\024\020\n\032\020\022\004\022\0020\003\022\004\022\0020\004\030\0010\002H\024¨\006\013"}, d2 = {"com/soft/blued/ui/circle/vm/CircleTypeListViewModel$getCircleListData$1", "Lcom/blued/android/framework/http/BluedUIHttpResponse;", "Lcom/blued/android/framework/http/parser/BluedEntity;", "Lcom/soft/blued/ui/circle/model/MyCircleModel;", "Lcom/soft/blued/ui/circle/model/MyCircleExtra;", "onUIFinish", "", "success", "", "onUIUpdate", "parseData", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class CircleTypeListViewModel$getCircleListData$1 extends BluedUIHttpResponse<BluedEntity<MyCircleModel, MyCircleExtra>> {
    CircleTypeListViewModel$getCircleListData$1(CircleTypeListViewModel param1CircleTypeListViewModel, boolean param1Boolean, IRequestHost param1IRequestHost1, IRequestHost param1IRequestHost2) {
      super(param1IRequestHost2);
    }
    
    public void onUIFinish(boolean param1Boolean) {
      super.onUIFinish(param1Boolean);
      if (!param1Boolean) {
        CircleTypeListViewModel circleTypeListViewModel = this.a;
        circleTypeListViewModel.b(circleTypeListViewModel.k() - 1);
      } 
      CircleTypeListViewModel.b(this.a, param1Boolean);
      this.a.d(param1Boolean);
    }
    
    public void onUIUpdate(BluedEntity<MyCircleModel, MyCircleExtra> param1BluedEntity) {
      if (param1BluedEntity != null && param1BluedEntity.hasData()) {
        if (this.b) {
          CircleTypeListModel circleTypeListModel = this.a.l();
          List list = param1BluedEntity.data;
          Intrinsics.a(list, "parseData.data");
          circleTypeListModel.setCircleList(list);
        } else {
          CircleTypeListModel circleTypeListModel = this.a.l();
          List list1 = circleTypeListModel.getCircleList();
          List list2 = param1BluedEntity.data;
          Intrinsics.a(list2, "parseData.data");
          circleTypeListModel.setCircleList(CollectionsKt.b(list1, list2));
        } 
        this.a.l().setHasMore(param1BluedEntity.hasMore());
      } 
      this.a.c().setValue(this.a.l());
      CircleTypeListViewModel circleTypeListViewModel = this.a;
      CircleTypeListViewModel.a(circleTypeListViewModel, circleTypeListViewModel.l().getHasMore());
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000!\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\013\n\002\b\003*\001\000\b\n\030\0002\020\022\f\022\n\022\004\022\0020\003\030\0010\0020\001J\020\020\004\032\0020\0052\006\020\006\032\0020\007H\024J\030\020\b\032\0020\0052\016\020\t\032\n\022\004\022\0020\003\030\0010\002H\024¨\006\n"}, d2 = {"com/soft/blued/ui/circle/vm/CircleTypeListViewModel$getCircleTypeData$1", "Lcom/blued/android/framework/http/BluedUIHttpResponse;", "Lcom/blued/android/framework/http/parser/BluedEntityA;", "Lcom/soft/blued/ui/circle/model/CircleTypeModel$DataBean;", "onUIFinish", "", "success", "", "onUIUpdate", "parseData", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class CircleTypeListViewModel$getCircleTypeData$1 extends BluedUIHttpResponse<BluedEntityA<CircleTypeModel.DataBean>> {
    CircleTypeListViewModel$getCircleTypeData$1(CircleTypeListViewModel param1CircleTypeListViewModel) {}
    
    protected void a(BluedEntityA<CircleTypeModel.DataBean> param1BluedEntityA) {
      MutableLiveData<List<CircleTypeModel.DataBean>> mutableLiveData = this.a.d();
      if (param1BluedEntityA != null) {
        List list = param1BluedEntityA.data;
      } else {
        param1BluedEntityA = null;
      } 
      mutableLiveData.setValue(param1BluedEntityA);
    }
    
    public void onUIFinish(boolean param1Boolean) {
      super.onUIFinish(param1Boolean);
      CircleTypeListViewModel.b(this.a, param1Boolean);
      this.a.e().setValue(Boolean.valueOf(param1Boolean));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\vm\CircleTypeListViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */