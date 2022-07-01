package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.ref.WeakReference;

public final class TabLayoutMediator {
  private final TabLayout a;
  
  private final ViewPager2 b;
  
  private final TabConfigurationStrategy c;
  
  private RecyclerView.Adapter<?> d;
  
  void a() {
    this.a.c();
    RecyclerView.Adapter<?> adapter = this.d;
    if (adapter != null) {
      int j = adapter.getItemCount();
      int i;
      for (i = 0; i < j; i++) {
        TabLayout.Tab tab = this.a.a();
        this.c.a(tab, i);
        this.a.a(tab, false);
      } 
      if (j > 0) {
        i = this.a.getTabCount();
        i = Math.min(this.b.getCurrentItem(), i - 1);
        if (i != this.a.getSelectedTabPosition()) {
          TabLayout tabLayout = this.a;
          tabLayout.c(tabLayout.a(i));
        } 
      } 
    } 
  }
  
  class PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
    public void onChanged() {
      this.a.a();
    }
    
    public void onItemRangeChanged(int param1Int1, int param1Int2) {
      this.a.a();
    }
    
    public void onItemRangeChanged(int param1Int1, int param1Int2, Object param1Object) {
      this.a.a();
    }
    
    public void onItemRangeInserted(int param1Int1, int param1Int2) {
      this.a.a();
    }
    
    public void onItemRangeMoved(int param1Int1, int param1Int2, int param1Int3) {
      this.a.a();
    }
    
    public void onItemRangeRemoved(int param1Int1, int param1Int2) {
      this.a.a();
    }
  }
  
  public static interface TabConfigurationStrategy {
    void a(TabLayout.Tab param1Tab, int param1Int);
  }
  
  static class TabLayoutOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
    private final WeakReference<TabLayout> a;
    
    private int b;
    
    private int c;
    
    public void onPageScrollStateChanged(int param1Int) {
      this.b = this.c;
      this.c = param1Int;
    }
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {
      TabLayout tabLayout = this.a.get();
      if (tabLayout != null) {
        boolean bool1;
        param1Int2 = this.c;
        boolean bool2 = false;
        if (param1Int2 != 2 || this.b == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (this.c != 2 || this.b != 0)
          bool2 = true; 
        tabLayout.a(param1Int1, param1Float, bool1, bool2);
      } 
    }
    
    public void onPageSelected(int param1Int) {
      TabLayout tabLayout = this.a.get();
      if (tabLayout != null && tabLayout.getSelectedTabPosition() != param1Int && param1Int < tabLayout.getTabCount()) {
        boolean bool;
        int i = this.c;
        if (i == 0 || (i == 2 && this.b == 0)) {
          bool = true;
        } else {
          bool = false;
        } 
        tabLayout.b(tabLayout.a(param1Int), bool);
      } 
    }
  }
  
  static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
    private final ViewPager2 a;
    
    private final boolean b;
    
    public void a(TabLayout.Tab param1Tab) {
      this.a.setCurrentItem(param1Tab.c(), this.b);
    }
    
    public void b(TabLayout.Tab param1Tab) {}
    
    public void c(TabLayout.Tab param1Tab) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\tabs\TabLayoutMediator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */