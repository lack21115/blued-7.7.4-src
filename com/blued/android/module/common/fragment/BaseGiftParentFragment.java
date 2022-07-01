package com.blued.android.module.common.fragment;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.view.LiveGiftIndicatorView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;

public abstract class BaseGiftParentFragment<T extends BaseGiftModel> extends BaseViewPagerParentFragment {
  protected LiveGiftIndicatorView h;
  
  protected String i;
  
  protected int j = 0;
  
  protected boolean k = true;
  
  private int a(CommonGiftPackageModel paramCommonGiftPackageModel) {
    if (paramCommonGiftPackageModel != null && paramCommonGiftPackageModel.goods.size() > 0) {
      int i = paramCommonGiftPackageModel.getRow();
      int j = paramCommonGiftPackageModel.getLine();
      return (int)Math.ceil((paramCommonGiftPackageModel.goods.size() / (i * j)));
    } 
    return 0;
  }
  
  public boolean V_() {
    LogUtils.c("");
    return u().V_();
  }
  
  protected abstract BaseFragment a(int paramInt, @Nonnull Bundle paramBundle);
  
  public List a(int paramInt) {
    ArrayList arrayList = new ArrayList();
    if ((u()).i.size() > this.j) {
      CommonGiftPackageModel commonGiftPackageModel = (u()).i.get(this.j);
      int i = commonGiftPackageModel.getRow() * commonGiftPackageModel.getLine();
      for (paramInt *= i; paramInt < commonGiftPackageModel.goods.size(); paramInt++) {
        arrayList.add(commonGiftPackageModel.goods.get(paramInt));
        if (arrayList.size() == i)
          return arrayList; 
      } 
    } 
    return arrayList;
  }
  
  public void a(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("size; ");
    stringBuilder.append(this.p.size());
    LogUtils.c(stringBuilder.toString());
    if (this.p.size() > 0)
      this.n.setCurrentItem(0, paramBoolean); 
  }
  
  protected BaseFragment b(int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putInt("gift_index", paramInt);
    bundle.putString("package_index", this.i);
    bundle.putInt("package_tab_index", this.j);
    BaseFragment baseFragment = a(paramInt, bundle);
    baseFragment.setArguments(bundle);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("packageIndex: ");
    stringBuilder.append(this.i);
    stringBuilder.append(", index: ");
    stringBuilder.append(paramInt);
    LogUtils.c(stringBuilder.toString());
    return baseFragment;
  }
  
  public void b(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("size; ");
    stringBuilder.append(this.p.size());
    LogUtils.c(stringBuilder.toString());
    if (this.p.size() > 0)
      this.n.setCurrentItem(this.p.size() - 1, paramBoolean); 
  }
  
  public int k() {
    return R.layout.fragment_base_gift_parent;
  }
  
  public void l() {
    this.i = this.f.getString("package_index");
    this.j = this.f.getInt("package_tab_index");
  }
  
  public void n() {
    super.n();
    this.h = (LiveGiftIndicatorView)this.d.findViewById(R.id.base_gift_indicator_view);
    if (this.k) {
      this.h.setVisibility(0);
    } else {
      this.h.setVisibility(8);
    } 
    this.n.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            this.a.h.b(param1Int);
          }
        });
  }
  
  public void p() {
    super.p();
    LiveEventBus.get("gift_data_change", String.class).observe((LifecycleOwner)this, new -$$Lambda$BaseGiftParentFragment$RIR5xFkYD59EHSU5gIvZaY1mvEQ(this));
    LiveEventBus.get("gift_package_change", String.class).observe((LifecycleOwner)this, new -$$Lambda$BaseGiftParentFragment$e1zorwy6vEJtdiU2EAIzC5WgWcM(this));
    LiveEventBus.get("gift_package_selected", String.class).observe((LifecycleOwner)this, new -$$Lambda$BaseGiftParentFragment$y_OrFL8cQZ0Z11ZvJQmodQkx_7Q(this));
  }
  
  public void q() {
    super.q();
    s();
  }
  
  protected void r() {}
  
  protected void s() {
    byte b;
    CommonGiftPackageModel commonGiftPackageModel = t();
    if (commonGiftPackageModel != null) {
      int i = a(commonGiftPackageModel);
      b = i;
      if (i == 0)
        b = 1; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("packageIndex: ");
      stringBuilder.append(this.i);
      stringBuilder.append(", goods.size:");
      stringBuilder.append(commonGiftPackageModel.goods.size());
      stringBuilder.append(", getPageCount: ");
      stringBuilder.append(b);
      stringBuilder.append(", fragmentCount:");
      stringBuilder.append(this.p.size());
      stringBuilder.append(", getCurrentItem:");
      stringBuilder.append(this.n.getCurrentItem());
      LogUtils.c(stringBuilder.toString());
      if (b > this.p.size()) {
        for (i = this.p.size(); i < b; i++) {
          this.p.add(b(i));
          this.q.add(String.valueOf(i));
        } 
      } else if (this.p.size() > b) {
        for (i = this.p.size() - 1; i >= b; i--)
          this.p.remove(i); 
      } 
      this.h.a(b);
      this.h.setIndicatorCount(b);
      if (!this.k) {
        this.h.setVisibility(8);
      } else if (b == 1) {
        this.h.setVisibility(4);
      } else {
        this.h.setVisibility(0);
      } 
      LiveEventBus.get("gift_page_data_change").post(null);
    } else {
      b = 0;
    } 
    this.o.notifyDataSetChanged();
    if (this.n.getCurrentItem() >= b)
      this.n.setCurrentItem(b - 1, false); 
  }
  
  public CommonGiftPackageModel t() {
    return ((u()).i.size() > this.j) ? (u()).i.get(this.j) : null;
  }
  
  protected BaseGiftRootFragment u() {
    return (BaseGiftRootFragment)getParentFragment();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\fragment\BaseGiftParentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */