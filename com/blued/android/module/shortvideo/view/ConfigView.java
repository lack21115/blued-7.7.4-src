package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.shortvideo.adapter.ConfigAdapter;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.observer.ReturnObserver;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.widget.SpacesItemDecoration;

public class ConfigView extends RecyclerView implements EventObserver, ReturnObserver {
  private ConfigAdapter L;
  
  public ConfigView(Context paramContext) {
    super(paramContext);
    B();
  }
  
  public ConfigView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    B();
  }
  
  public ConfigView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    B();
  }
  
  private void B() {
    setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext(), 1, false));
    setClipChildren(false);
  }
  
  public void A() {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 != 2) {
      this.L.a(paramInt1, paramInt2, paramInt3);
      setAdapter((RecyclerView.Adapter)this.L);
      a(0, 0L);
      return;
    } 
    w();
  }
  
  public void a(int paramInt, long paramLong) {
    ConfigAdapter configAdapter = this.L;
    if (configAdapter != null)
      configAdapter.a(paramInt, paramLong); 
  }
  
  public void a(CommonModel paramCommonModel) {
    this.L = new ConfigAdapter(paramCommonModel);
    addItemDecoration((RecyclerView.ItemDecoration)new SpacesItemDecoration(1, DensityUtils.a(getContext(), 18.0F)));
  }
  
  public void a(EventType.VALUE paramVALUE) {
    ConfigAdapter configAdapter;
    switch (null.a[paramVALUE.ordinal()]) {
      default:
        return;
      case 11:
        configAdapter = this.L;
        if (configAdapter != null) {
          configAdapter.b();
          return;
        } 
        return;
      case 5:
        configAdapter = this.L;
        if (configAdapter != null)
          configAdapter.a(); 
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
        v();
        return;
      case 1:
      case 2:
      case 3:
      case 4:
        break;
    } 
    w();
  }
  
  public void a(EventType.VALUE paramVALUE, boolean paramBoolean) {
    if (paramBoolean) {
      if (paramVALUE == EventType.VALUE.g) {
        w();
        return;
      } 
      if (paramVALUE == EventType.VALUE.h)
        v(); 
    } 
  }
  
  public int d(boolean paramBoolean) {
    ConfigAdapter configAdapter = this.L;
    return (configAdapter != null) ? configAdapter.a(paramBoolean) : -1;
  }
  
  public void v() {
    if (getVisibility() == 8) {
      setVisibility(0);
      StvViewUtils.c(getContext(), (View)this);
    } 
  }
  
  public void w() {
    if (getVisibility() == 0)
      StvViewUtils.d(getContext(), (View)this); 
  }
  
  public void x() {
    ObserverMgr.a().a(this);
    ObserverMgr.a().a(this);
  }
  
  public void y() {
    v();
  }
  
  public void z() {
    ObserverMgr.a().b(this);
    ObserverMgr.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\ConfigView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */