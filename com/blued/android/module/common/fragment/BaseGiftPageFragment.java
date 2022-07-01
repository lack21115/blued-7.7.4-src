package com.blued.android.module.common.fragment;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.adapter.BaseGiftAdapter;
import com.blued.android.module.common.event.CommonGiftPageChangeEvent;
import com.blued.android.module.common.event.GiftItemChangeEvent;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseGiftPageFragment<T extends BaseGiftModel> extends SimpleFragment {
  public RecyclerView h;
  
  public BaseGiftAdapter i;
  
  protected View j;
  
  protected final List<T> k = new ArrayList<T>();
  
  protected String l;
  
  protected int m = 0;
  
  protected int n = 0;
  
  private void t() {
    CommonGiftPackageModel commonGiftPackageModel = s().t();
    if (commonGiftPackageModel != null) {
      RecyclerView.LayoutManager layoutManager = this.h.getLayoutManager();
      if (layoutManager == null)
        this.h.setLayoutManager(a(commonGiftPackageModel)); 
      if (layoutManager instanceof GridLayoutManager)
        ((GridLayoutManager)layoutManager).setSpanCount(commonGiftPackageModel.getRow()); 
    } 
  }
  
  public boolean V_() {
    LogUtils.c("");
    return s().V_();
  }
  
  protected RecyclerView.LayoutManager a(CommonGiftPackageModel paramCommonGiftPackageModel) {
    return (RecyclerView.LayoutManager)new GridLayoutManager(getContext(), paramCommonGiftPackageModel.getRow(), 1, false);
  }
  
  public int k() {
    return R.layout.fragment_base_gift_page;
  }
  
  public void l() {
    super.l();
    this.l = this.f.getString("package_index");
    this.m = this.f.getInt("gift_index");
    this.n = this.f.getInt("package_tab_index");
  }
  
  public void n() {
    super.n();
    this.h = (RecyclerView)this.d.findViewById(R.id.base_gift_page_grid);
    r();
    this.h.setAdapter((RecyclerView.Adapter)this.i);
    if (this.h.getItemAnimator() != null)
      ((SimpleItemAnimator)this.h.getItemAnimator()).setSupportsChangeAnimations(false); 
    this.j = this.d.findViewById(R.id.base_gift_page_no_data_layout);
    this.j.setVisibility(0);
  }
  
  public void p() {
    super.p();
    LiveEventBus.get("gift_page_change", CommonGiftPageChangeEvent.class).observe((LifecycleOwner)this, new Observer<CommonGiftPageChangeEvent>(this) {
          public void a(CommonGiftPageChangeEvent param1CommonGiftPageChangeEvent) {
            if (param1CommonGiftPageChangeEvent != null && this.a.n == param1CommonGiftPageChangeEvent.packageTabIndex) {
              if (this.a.m != param1CommonGiftPageChangeEvent.pageIndex)
                return; 
              this.a.q();
            } 
          }
        });
    LiveEventBus.get("gift_page_data_change", Object.class).observe((LifecycleOwner)this, new Observer<Object>(this) {
          public void onChanged(Object param1Object) {
            this.a.q();
          }
        });
    LiveEventBus.get("gift_item_update_by_root", GiftItemChangeEvent.class).observe((LifecycleOwner)this, new Observer<GiftItemChangeEvent>(this) {
          public void a(GiftItemChangeEvent param1GiftItemChangeEvent) {
            if (param1GiftItemChangeEvent != null && this.a.n == param1GiftItemChangeEvent.packageTabIndex && this.a.m == param1GiftItemChangeEvent.pageIndex) {
              if (param1GiftItemChangeEvent.giftModel == null)
                return; 
              for (int i = 0; i < this.a.k.size(); i++) {
                if (StringUtils.a(((BaseGiftModel)this.a.k.get(i)).index, param1GiftItemChangeEvent.giftModel.index)) {
                  this.a.i.a(i, param1GiftItemChangeEvent.giftModel);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("GIFT_ITEM_UPDATE_BY_ROOT: ");
                  stringBuilder.append(i);
                  LogUtils.c(stringBuilder.toString());
                  return;
                } 
              } 
            } 
          }
        });
  }
  
  public void q() {
    super.q();
    List<? extends T> list = s().a(this.m);
    if (list != null) {
      this.k.clear();
      this.k.addAll(list);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("packageIndex: ");
    stringBuilder.append(this.l);
    stringBuilder.append(", pageIndex: ");
    stringBuilder.append(this.m);
    stringBuilder.append(", dataList.size:");
    stringBuilder.append(this.k.size());
    LogUtils.c(stringBuilder.toString());
    t();
    this.i.a(this.k);
    if (this.k.isEmpty()) {
      this.j.setVisibility(0);
      return;
    } 
    this.j.setVisibility(8);
  }
  
  public abstract void r();
  
  protected BaseGiftParentFragment s() {
    return (BaseGiftParentFragment)getParentFragment();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\fragment\BaseGiftPageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */