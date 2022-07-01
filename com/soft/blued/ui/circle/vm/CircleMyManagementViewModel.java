package com.soft.blued.ui.circle.vm;

import androidx.lifecycle.MutableLiveData;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.ui.circle.model.MyCircleExtra;
import com.soft.blued.ui.circle.model.MyCircleModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\000,\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020 \n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\005\n\002\020\002\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002J\b\020\017\032\0020\020H\002J\006\020\021\032\0020\020J\006\020\022\032\0020\020R\035\020\003\032\016\022\n\022\b\022\004\022\0020\0060\0050\004¢\006\b\n\000\032\004\b\007\020\bR\032\020\t\032\0020\nX\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016¨\006\023"}, d2 = {"Lcom/soft/blued/ui/circle/vm/CircleMyManagementViewModel;", "Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "()V", "dataListLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/soft/blued/ui/circle/model/MyCircleModel;", "getDataListLiveData", "()Landroidx/lifecycle/MutableLiveData;", "page", "", "getPage", "()I", "setPage", "(I)V", "getData", "", "onLoadMoreData", "onRefreshData", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class CircleMyManagementViewModel extends BaseViewModel {
  private final MutableLiveData<List<MyCircleModel>> a = new MutableLiveData();
  
  private int b = 1;
  
  private final void g() {
    CircleHttpUtils.b(new CircleMyManagementViewModel$getData$1(this), this.b);
  }
  
  public final void a(int paramInt) {
    this.b = paramInt;
  }
  
  public final MutableLiveData<List<MyCircleModel>> c() {
    return this.a;
  }
  
  public final int d() {
    return this.b;
  }
  
  public final void e() {
    this.b = 1;
    g();
  }
  
  public final void f() {
    this.b++;
    g();
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000%\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\013\n\002\b\003*\001\000\b\n\030\0002\026\022\022\022\020\022\004\022\0020\003\022\004\022\0020\004\030\0010\0020\001J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\024J\036\020\t\032\0020\0062\024\020\n\032\020\022\004\022\0020\003\022\004\022\0020\004\030\0010\002H\024¨\006\013"}, d2 = {"com/soft/blued/ui/circle/vm/CircleMyManagementViewModel$getData$1", "Lcom/blued/android/framework/http/BluedUIHttpResponse;", "Lcom/blued/android/framework/http/parser/BluedEntity;", "Lcom/soft/blued/ui/circle/model/MyCircleModel;", "Lcom/soft/blued/ui/circle/model/MyCircleExtra;", "onUIFinish", "", "success", "", "onUIUpdate", "parseData", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class CircleMyManagementViewModel$getData$1 extends BluedUIHttpResponse<BluedEntity<MyCircleModel, MyCircleExtra>> {
    CircleMyManagementViewModel$getData$1(CircleMyManagementViewModel param1CircleMyManagementViewModel) {}
    
    public void onUIFinish(boolean param1Boolean) {
      super.onUIFinish(param1Boolean);
      if (!param1Boolean) {
        CircleMyManagementViewModel circleMyManagementViewModel = this.a;
        circleMyManagementViewModel.a(circleMyManagementViewModel.d() - 1);
      } 
      CircleMyManagementViewModel.b(this.a, param1Boolean);
    }
    
    public void onUIUpdate(BluedEntity<MyCircleModel, MyCircleExtra> param1BluedEntity) {
      if (param1BluedEntity != null && param1BluedEntity.hasData()) {
        this.a.c().setValue(param1BluedEntity.data);
        CircleMyManagementViewModel.a(this.a, param1BluedEntity.hasMore());
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\vm\CircleMyManagementViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */