package com.blued.android.module.common.fragment;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.event.CommonGiftPageChangeEvent;
import com.blued.android.module.common.event.GiftItemChangeEvent;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.view.CommonGiftTabView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.OverridingMethodsMustInvokeSuper;

public abstract class BaseGiftRootFragment<T extends CommonGiftPackageModel> extends BaseViewPagerParentFragment {
  protected CommonGiftTabView h;
  
  protected final List<T> i = new ArrayList<T>();
  
  protected String j;
  
  protected int k = 0;
  
  protected boolean l = false;
  
  protected String m = null;
  
  private void a(String paramString, boolean paramBoolean) {
    if (paramString == null)
      return; 
    String str = this.j;
    if (str != null) {
      String[] arrayOfString = str.split("_");
      if (arrayOfString.length > 1) {
        int i = CommonStringUtils.a(arrayOfString[0]);
        int j = CommonStringUtils.a(arrayOfString[1]);
        if (this.i.size() > i && ((CommonGiftPackageModel)this.i.get(i)).goods.size() > j) {
          ((BaseGiftModel)((CommonGiftPackageModel)this.i.get(i)).goods.get(j)).isSelected = false;
          LiveEventBus.get("gift_page_change").post(new CommonGiftPageChangeEvent(i, a(i, j)));
        } 
      } 
    } 
    this.j = paramString;
    if (paramString != null) {
      String[] arrayOfString = paramString.split("_");
      if (arrayOfString.length > 1) {
        int i = CommonStringUtils.a(arrayOfString[0]);
        int j = CommonStringUtils.a(arrayOfString[1]);
        if (this.i.size() > i && ((CommonGiftPackageModel)this.i.get(i)).goods.size() > j) {
          BaseGiftModel baseGiftModel = ((CommonGiftPackageModel)this.i.get(i)).goods.get(j);
          if (!baseGiftModel.isSelected) {
            baseGiftModel.isSelected = true;
            LiveEventBus.get("gift_page_change").post(new CommonGiftPageChangeEvent(i, a(i, j)));
            a(baseGiftModel, paramBoolean);
          } 
        } 
      } 
    } 
  }
  
  public int a(int paramInt1, int paramInt2) {
    if (paramInt1 < this.i.size() && paramInt2 < ((CommonGiftPackageModel)this.i.get(paramInt1)).goods.size()) {
      int i = ((CommonGiftPackageModel)this.i.get(paramInt1)).getLine();
      paramInt1 = ((CommonGiftPackageModel)this.i.get(paramInt1)).getRow();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("event: ItemPage=");
      paramInt1 = paramInt2 / i * paramInt1;
      stringBuilder.append(paramInt1);
      LogUtils.c(stringBuilder.toString());
      return paramInt1;
    } 
    return -1;
  }
  
  protected abstract BaseFragment a(CommonGiftPackageModel paramCommonGiftPackageModel, @Nonnull Bundle paramBundle);
  
  protected BaseGiftModel a(String paramString) {
    if (paramString == null)
      return null; 
    String[] arrayOfString = paramString.split("_");
    if (arrayOfString.length > 1) {
      int i = CommonStringUtils.a(arrayOfString[0]);
      int j = CommonStringUtils.a(arrayOfString[1]);
      if (this.i.size() > i && ((CommonGiftPackageModel)this.i.get(i)).goods.size() > j)
        return ((CommonGiftPackageModel)this.i.get(i)).goods.get(j); 
    } 
    return null;
  }
  
  protected void a(int paramInt) {}
  
  public void a(BaseGiftModel paramBaseGiftModel, boolean paramBoolean) {}
  
  protected void a(CommonGiftPackageModel paramCommonGiftPackageModel) {
    int j = paramCommonGiftPackageModel.getLine() * paramCommonGiftPackageModel.getRow();
    for (int i = 0; i < paramCommonGiftPackageModel.goods.size(); i++) {
      BaseGiftModel baseGiftModel = paramCommonGiftPackageModel.goods.get(i);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramCommonGiftPackageModel.index);
      stringBuilder.append("_");
      stringBuilder.append(i);
      baseGiftModel.index = stringBuilder.toString();
      baseGiftModel.packageIndex = paramCommonGiftPackageModel.index;
      baseGiftModel.packageTabIndex = paramCommonGiftPackageModel.tabIndex;
      baseGiftModel.pageIndex = i / j;
      baseGiftModel.positionInPage = i % j;
    } 
  }
  
  protected void a(List<CommonGiftPackageModel> paramList) {
    if (paramList == null)
      return; 
    for (int i = 0; i < paramList.size(); i++) {
      CommonGiftPackageModel commonGiftPackageModel = paramList.get(i);
      commonGiftPackageModel.index = String.valueOf(i);
      commonGiftPackageModel.tabIndex = i;
      a(commonGiftPackageModel);
    } 
  }
  
  protected BaseFragment b(int paramInt) {
    CommonGiftPackageModel commonGiftPackageModel = (CommonGiftPackageModel)this.i.get(paramInt);
    Bundle bundle = new Bundle();
    if (commonGiftPackageModel != null) {
      bundle.putString("package_index", commonGiftPackageModel.index);
      bundle.putInt("package_tab_index", commonGiftPackageModel.tabIndex);
    } 
    BaseFragment baseFragment = a(commonGiftPackageModel, bundle);
    baseFragment.setArguments(bundle);
    return baseFragment;
  }
  
  protected CommonGiftPackageModel b(String paramString) {
    if (paramString == null)
      return null; 
    String[] arrayOfString = paramString.split("_");
    if (arrayOfString.length > 1) {
      int i = CommonStringUtils.a(arrayOfString[0]);
      if (this.i.size() > i)
        return (CommonGiftPackageModel)this.i.get(i); 
    } 
    return null;
  }
  
  public int k() {
    return R.layout.fragment_base_gift;
  }
  
  public void n() {
    super.n();
    this.h = (CommonGiftTabView)this.d.findViewById(R.id.base_gift_toolbar_view);
  }
  
  @OverridingMethodsMustInvokeSuper
  public void p() {
    super.p();
    this.n.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {
            if (param1Int == 1)
              this.a.l = true; 
          }
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            this.a.h.setToolBtnSelect(param1Int);
            this.a.a(param1Int);
            if (this.a.l && this.a.p.size() > param1Int && this.a.p.get(param1Int) != null && ((BaseFragment)this.a.p.get(param1Int)).isAdded() && this.a.p.get(param1Int) instanceof BaseGiftParentFragment)
              if (this.a.k < param1Int) {
                ((BaseGiftParentFragment)this.a.p.get(param1Int)).a(false);
              } else {
                ((BaseGiftParentFragment)this.a.p.get(param1Int)).b(false);
              }  
            BaseGiftRootFragment baseGiftRootFragment = this.a;
            baseGiftRootFragment.l = false;
            baseGiftRootFragment.k = param1Int;
          }
        });
    LiveEventBus.get("gift_item_selected", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            BaseGiftRootFragment.a(this.a, param1String, false);
          }
        });
    LiveEventBus.get("gift_item_clicked", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            BaseGiftRootFragment.a(this.a, param1String, true);
          }
        });
    LiveEventBus.get("gift_item_update", BaseGiftModel.class).observe((LifecycleOwner)this, new Observer<BaseGiftModel>(this) {
          public void a(BaseGiftModel param1BaseGiftModel) {
            if (param1BaseGiftModel != null) {
              if (param1BaseGiftModel.index == null)
                return; 
              String[] arrayOfString = param1BaseGiftModel.index.split("_");
              if (arrayOfString.length > 1) {
                int i = CommonStringUtils.a(arrayOfString[0]);
                int j = CommonStringUtils.a(arrayOfString[1]);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("GIFT_ITEM_UPDATE: ");
                stringBuilder.append(param1BaseGiftModel.index);
                LogUtils.c(stringBuilder.toString());
                if (this.a.i.size() > i && ((CommonGiftPackageModel)this.a.i.get(i)).goods.size() > j) {
                  BaseGiftRootFragment baseGiftRootFragment;
                  BaseGiftModel baseGiftModel = ((CommonGiftPackageModel)this.a.i.get(i)).goods.get(j);
                  if (((CommonGiftPackageModel)this.a.i.get(i)).deleteItemIfZeroCount && baseGiftModel.count <= 0) {
                    ((CommonGiftPackageModel)this.a.i.get(i)).goods.remove(j);
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append("GIFT_ITEM_UPDATE: remove ");
                    stringBuilder1.append(param1BaseGiftModel.index);
                    LogUtils.c(stringBuilder1.toString());
                    baseGiftRootFragment = this.a;
                    baseGiftRootFragment.j = null;
                    baseGiftRootFragment.a(baseGiftRootFragment.i.get(i));
                    LiveEventBus.get("gift_package_change").post(((CommonGiftPackageModel)this.a.i.get(i)).index);
                    return;
                  } 
                  ((CommonGiftPackageModel)this.a.i.get(i)).goods.set(j, baseGiftRootFragment);
                  LiveEventBus.get("gift_item_update_by_root").post(new GiftItemChangeEvent(i, this.a.a(i, j), (BaseGiftModel)baseGiftRootFragment));
                } 
              } 
            } 
          }
        });
    LiveEventBus.get("gift_package_selected", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            if (param1String == null)
              return; 
            int i = 0;
            Iterator iterator = this.a.i.iterator();
            while (iterator.hasNext()) {
              if (StringUtils.a(param1String, ((CommonGiftPackageModel)iterator.next()).index)) {
                this.a.n.setCurrentItem(i);
                break;
              } 
              i++;
            } 
            this.a.h.setToolBtnSelect(i);
            this.a.a(i);
          }
        });
  }
  
  protected String t() {
    if (this.m == null)
      this.m = u(); 
    return this.m;
  }
  
  protected String u() {
    return "0_0";
  }
  
  public void v() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("dataListSize: ");
    stringBuilder.append(this.i.size());
    stringBuilder.append(", fragmentList: ");
    stringBuilder.append(this.p.size());
    LogUtils.c(stringBuilder.toString());
    if (this.i.size() > this.p.size()) {
      for (int i = this.p.size(); i < this.i.size(); i++) {
        this.p.add(b(i));
        this.q.add(String.valueOf(i));
      } 
    } else if (this.p.size() > this.i.size()) {
      for (int i = this.p.size() - 1; i >= this.i.size(); i--)
        this.p.remove(i); 
    } 
    w();
    if (this.n.getCurrentItem() >= this.i.size() && this.i.size() > 0)
      this.n.setCurrentItem(this.i.size() - 1, false); 
    LiveEventBus.get("gift_data_change").post("All");
  }
  
  protected void w() {
    this.o.notifyDataSetChanged();
    this.h.setData(this.i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\fragment\BaseGiftRootFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */