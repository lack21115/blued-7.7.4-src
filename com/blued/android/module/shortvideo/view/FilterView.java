package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.adapter.FilterAdapter;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.widget.SpacesItemDecoration;

public class FilterView extends EditBottomBaseView implements EventObserver {
  protected RecyclerView d;
  
  protected FilterAdapter e;
  
  private CommonModel f;
  
  private int g;
  
  private int h;
  
  public FilterView(Context paramContext) {
    super(paramContext);
  }
  
  public FilterView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public FilterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a() {
    this.d = (RecyclerView)LayoutInflater.from(getContext()).inflate(R.layout.stv_recyclerview, null);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(0);
    this.d.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.d.addItemDecoration((RecyclerView.ItemDecoration)new SpacesItemDecoration(0, 30));
  }
  
  public void a(int paramInt) {
    FilterAdapter filterAdapter = this.e;
    if (filterAdapter != null)
      filterAdapter.a(paramInt); 
    RecyclerView recyclerView = this.d;
    if (recyclerView != null)
      recyclerView.smoothScrollToPosition(paramInt); 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    if (this.f == null)
      return; 
    this.h = paramInt2;
    this.g = paramInt3;
    if (paramInt1 != 2) {
      int i = this.g;
      if (i == 1 || (i == 4 && paramInt2 == 3) || this.g == 5) {
        if (this.e == null) {
          this.e = new FilterAdapter(getContext(), this.f);
          this.d.setAdapter((RecyclerView.Adapter)this.e);
        } 
        this.e.a(paramInt1, paramInt2, paramInt3);
      } 
    } 
  }
  
  public void a(CommonModel paramCommonModel) {
    this.f = paramCommonModel;
  }
  
  public void a(EventType.VALUE paramVALUE) {
    if (this.f == null)
      return; 
    int i = null.a[paramVALUE.ordinal()];
    if (i != 1) {
      if (i != 2)
        return; 
      if (this.g == 4 && this.h == 3) {
        i = this.f.getSelectFilterPosition();
      } else {
        i = this.f.getSelectFilterPosition();
      } 
      a(i);
      return;
    } 
    c();
  }
  
  protected void b() {
    StvViewUtils.a((View)this.c, 15, 16, 15, 20);
  }
  
  public void c() {
    super.c();
    CommonModel commonModel = this.f;
    if (commonModel == null)
      return; 
    if (this.g == 1) {
      commonModel.setShowVType(2);
    } else {
      commonModel.setShowVType(2);
    } 
    this.d.postDelayed(new Runnable(this) {
          public void run() {
            this.a.d.smoothScrollToPosition(FilterView.a(this.a).getSelectFilterPosition());
          }
        },  50L);
  }
  
  public void d() {
    super.d();
    CommonModel commonModel = this.f;
    if (commonModel != null)
      commonModel.setShowVType(0); 
  }
  
  protected void e() {
    ObserverMgr.a().a(EventType.VALUE.o);
    d();
  }
  
  protected void f() {}
  
  protected boolean g() {
    return true;
  }
  
  protected View getContentV() {
    return (View)this.d;
  }
  
  protected int getTitleId() {
    return R.string.stv_select_filter_title;
  }
  
  public void h() {
    ObserverMgr.a().a(this);
  }
  
  public void i() {}
  
  public void j() {
    ObserverMgr.a().b(this);
  }
  
  public void k() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\FilterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */