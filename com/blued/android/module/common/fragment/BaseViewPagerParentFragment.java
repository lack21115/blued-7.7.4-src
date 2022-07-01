package com.blued.android.module.common.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.module.common.R;
import com.blued.android.module.common.adapter.BaseViewPagerFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseViewPagerParentFragment extends SimpleFragment {
  public ViewPager n;
  
  protected BaseViewPagerFragmentPagerAdapter o;
  
  public List<BaseFragment> p = new ArrayList<BaseFragment>();
  
  protected List<String> q = new ArrayList<String>();
  
  protected abstract BaseFragment b(int paramInt);
  
  public void n() {
    super.n();
    this.n = (ViewPager)this.d.findViewById(R.id.base_view_pager_id);
    this.o = new BaseViewPagerFragmentPagerAdapter(this, getChildFragmentManager()) {
        public BaseFragment b(int param1Int) {
          return this.d.b(param1Int);
        }
      };
    this.o.a(R.id.base_view_pager_id);
    this.n.setAdapter((PagerAdapter)this.o);
  }
  
  public void o() {
    super.o();
    s();
    r();
    if (this.q.size() < this.p.size())
      for (int i = this.q.size(); i < this.p.size(); i++)
        this.q.add(String.valueOf(i));  
    this.o.a(this.p);
    this.o.b(this.q);
    this.o.notifyDataSetChanged();
  }
  
  protected abstract void r();
  
  protected abstract void s();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\fragment\BaseViewPagerParentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */