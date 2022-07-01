package com.soft.blued.ui.user.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.customview.AutoScrollViewPager;
import com.soft.blued.ui.user.adapter.VIPPrivilegeAdapter;
import com.soft.blued.ui.user.model.VIPPrivilegeModel;
import java.util.ArrayList;
import java.util.List;

public class VIPPrivilegePageView extends AutoScrollViewPager {
  private Context d;
  
  private IRequestHost e;
  
  private List<VIPPrivilegeModel> f;
  
  private ViewPagerAdapter g;
  
  private List<View> h = new ArrayList<View>();
  
  private IViewStateListener i;
  
  private List<VIPPrivilegeAdapter> j = new ArrayList<VIPPrivilegeAdapter>();
  
  public VIPPrivilegePageView(Context paramContext) {
    super(paramContext);
    this.d = paramContext;
  }
  
  public VIPPrivilegePageView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
  }
  
  public void a(IRequestHost paramIRequestHost, List<VIPPrivilegeModel> paramList) {
    this.e = paramIRequestHost;
    this.f = paramList;
  }
  
  public int getPageCount() {
    return (int)Math.ceil(this.f.size() / 4.0D);
  }
  
  public void i() {
    int i;
    if (this.f == null)
      return; 
    if (this.g == null) {
      this.g = new ViewPagerAdapter();
      setAdapter(this.g);
      IViewStateListener iViewStateListener = this.i;
      if (iViewStateListener != null)
        iViewStateListener.onSetAdapter(); 
    } 
    this.h.clear();
    this.j.clear();
    this.g.notifyDataSetChanged();
    int n = getPageCount();
    int k = this.f.size();
    if (4 > k) {
      i = k;
    } else {
      i = 4;
    } 
    int m = 0;
    int j = 0;
    while (m < n) {
      View view = LayoutInflater.from(this.d).inflate(2131493385, null);
      GridView gridView = (GridView)view.findViewById(2131297289);
      ArrayList arrayList = new ArrayList();
      while (j < i) {
        arrayList.add(this.f.get(j));
        j++;
      } 
      while (arrayList.size() < 4)
        arrayList.add(null); 
      VIPPrivilegeAdapter vIPPrivilegeAdapter = new VIPPrivilegeAdapter(this.d, this.e, arrayList, gridView);
      gridView.setNumColumns(4);
      this.j.add(vIPPrivilegeAdapter);
      gridView.setAdapter((ListAdapter)vIPPrivilegeAdapter);
      this.h.add(view);
      int i1 = m * 4 + 4;
      int i2 = m + 1;
      int i3 = i2 * 4 + 4;
      j = i1;
      m = i2;
      i = i3;
      if (i3 >= k) {
        i = k;
        j = i1;
        m = i2;
      } 
    } 
    this.g.notifyDataSetChanged();
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    post(new Runnable(this) {
          public void run() {
            this.a.i();
          }
        });
  }
  
  public void setIViewListener(IViewStateListener paramIViewStateListener) {
    this.i = paramIViewStateListener;
  }
  
  class ViewPagerAdapter extends PagerAdapter {
    private ViewPagerAdapter(VIPPrivilegePageView this$0) {}
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      ((ViewPager)param1ViewGroup).removeView((View)param1Object);
    }
    
    public int getCount() {
      return VIPPrivilegePageView.a(this.a).size();
    }
    
    public int getItemPosition(Object param1Object) {
      return -2;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      ((ViewPager)param1ViewGroup).addView(VIPPrivilegePageView.a(this.a).get(param1Int));
      return VIPPrivilegePageView.a(this.a).get(param1Int);
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\views\VIPPrivilegePageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */