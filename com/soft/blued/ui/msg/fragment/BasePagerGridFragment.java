package com.soft.blued.ui.msg.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.DensityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.customview.CirclePageIndicator;
import com.soft.blued.customview.SpacesItemDecoration;
import com.soft.blued.ui.msg.model.Selectable;
import com.soft.blued.utils.RecyclerViewAnimUtil;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePagerGridFragment<P extends MvpPresenter, A extends BaseQuickAdapter, M extends Selectable> extends MvpFragment<P> {
  protected List<M> d;
  
  protected FrameLayout[] e;
  
  protected List<A> f = new ArrayList<A>();
  
  protected int g;
  
  protected int h;
  
  public M i;
  
  private ViewHolder j;
  
  private Unbinder n;
  
  private FrameLayout a(int paramInt) {
    View view = View.inflate(getContext(), 2131493550, null);
    this.j = new ViewHolder(this);
    this.n = ButterKnife.a(this.j, view);
    RecyclerView recyclerView = this.j.recyclerView;
    RecyclerViewAnimUtil.a(recyclerView);
    recyclerView.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(getContext(), l()));
    SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(0, 0, DensityUtils.a(getContext(), 4.0F), DensityUtils.a(getContext(), 4.0F));
    spacesItemDecoration.a(5);
    recyclerView.addItemDecoration((RecyclerView.ItemDecoration)spacesItemDecoration);
    ArrayList<M> arrayList = new ArrayList();
    if (paramInt != this.g) {
      arrayList.addAll(this.d.subList(this.h, k() * paramInt));
      this.h += k();
    } else {
      List<M> list = this.d;
      arrayList.addAll(list.subList(this.h, list.size()));
    } 
    arrayList = (ArrayList<M>)a(arrayList);
    this.f.add((A)arrayList);
    arrayList.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            if (this.a.i != null && this.a.i.equals(param1BaseQuickAdapter.n().get(param1Int)))
              return; 
            this.a.m();
            Selectable selectable = param1BaseQuickAdapter.n().get(param1Int);
            this.a.b(selectable);
            param1BaseQuickAdapter.notifyItemChanged(param1Int);
          }
        });
    recyclerView.setAdapter((RecyclerView.Adapter)arrayList);
    FrameLayout frameLayout = new FrameLayout(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    layoutParams.leftMargin = DensityUtils.a(getContext(), 4.0F);
    layoutParams.rightMargin = DensityUtils.a(getContext(), 4.0F);
    frameLayout.addView((View)recyclerView, (ViewGroup.LayoutParams)layoutParams);
    return frameLayout;
  }
  
  protected abstract A a(List<M> paramList);
  
  protected void a(ViewPager paramViewPager, CirclePageIndicator paramCirclePageIndicator) {
    List<M> list = this.d;
    if (list == null)
      return; 
    int i = list.size();
    int j = i / k();
    if (i % k() == 0) {
      i = 0;
    } else {
      i = 1;
    } 
    this.g = j + i;
    paramViewPager.setOffscreenPageLimit(this.g);
    this.e = new FrameLayout[this.g];
    i = 0;
    while (true) {
      j = this.g;
      if (i < j) {
        FrameLayout[] arrayOfFrameLayout = this.e;
        j = i + 1;
        arrayOfFrameLayout[i] = a(j);
        i = j;
        continue;
      } 
      if (j <= 1) {
        paramCirclePageIndicator.setVisibility(4);
      } else {
        paramCirclePageIndicator.setVisibility(0);
      } 
      paramViewPager.setAdapter(new GridPagerAdapter(this.e));
      paramCirclePageIndicator.setViewPager(paramViewPager);
      return;
    } 
  }
  
  protected void a(M paramM) {
    if (paramM != null)
      for (BaseQuickAdapter baseQuickAdapter : this.f) {
        int i = baseQuickAdapter.n().indexOf(paramM);
        if (i != -1) {
          baseQuickAdapter.notifyItemChanged(i);
          break;
        } 
      }  
  }
  
  public void aL_() {
    super.aL_();
    Unbinder unbinder = this.n;
    if (unbinder != null)
      unbinder.unbind(); 
  }
  
  protected void b(M paramM) {
    this.i = paramM;
    ((Selectable)this.i).chosen = true;
  }
  
  protected int k() {
    return 8;
  }
  
  protected int l() {
    return 4;
  }
  
  protected void m() {
    M m = this.i;
    if (m != null) {
      ((Selectable)m).chosen = false;
      for (BaseQuickAdapter baseQuickAdapter : this.f) {
        int i = baseQuickAdapter.n().indexOf(this.i);
        if (i != -1) {
          baseQuickAdapter.notifyItemChanged(i);
          break;
        } 
      } 
      this.i = null;
    } 
  }
  
  public void n() {
    b(this.i);
  }
  
  public static class GridPagerAdapter extends PagerAdapter {
    private final FrameLayout[] a;
    
    public GridPagerAdapter(FrameLayout[] param1ArrayOfFrameLayout) {
      this.a = param1ArrayOfFrameLayout;
    }
    
    public void destroyItem(View param1View, int param1Int, Object param1Object) {
      ((ViewGroup)param1View).removeView((View)this.a[param1Int]);
    }
    
    public int getCount() {
      return this.a.length;
    }
    
    public int getItemPosition(Object param1Object) {
      return super.getItemPosition(param1Object);
    }
    
    public Object instantiateItem(View param1View, int param1Int) {
      FrameLayout frameLayout = this.a[param1Int];
      if (frameLayout.getParent() != null)
        ((ViewGroup)frameLayout.getParent()).removeView((View)frameLayout); 
      ((ViewGroup)param1View).addView((View)this.a[param1Int]);
      return frameLayout;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
  
  class ViewHolder {
    @BindView(2131299601)
    public RecyclerView recyclerView;
    
    ViewHolder(BasePagerGridFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\fragment\BasePagerGridFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */