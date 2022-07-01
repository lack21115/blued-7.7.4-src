package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.TabTitleTrackIndicatorWithDot;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.photo.manager.AlbumViewDataManager;
import com.soft.blued.ui.user.adapter.PictureTabAdapter;
import com.soft.blued.ui.user.contract.InterestGalleryContract;
import com.soft.blued.ui.user.model.PictureTabModel;
import com.soft.blued.ui.user.presenter.InterestGalleryPresenter;
import com.soft.blued.utils.NetworkUtils;
import java.util.ArrayList;
import java.util.List;

public class InterestGalleryFragment extends BaseFragment implements PictureTabAdapter.MyItemClickListener, InterestGalleryContract.IView {
  private final int d = 4;
  
  private View e;
  
  private Context f;
  
  private TextView g;
  
  private ImageView h;
  
  private ViewPager i;
  
  private PopupWindow j;
  
  private FrameLayout k;
  
  private LinearLayout l;
  
  private NoDataAndLoadFailView m;
  
  private CommonTopTitleNoTrans n;
  
  private TabTitleTrackIndicatorWithDot o;
  
  private InterestGalleryContract.IPresenter p;
  
  private PictureTabAdapter q;
  
  private TabIndicatorAdapter r;
  
  private String s;
  
  private List<PictureTabModel> t;
  
  private int u;
  
  private void a(View paramView) {
    if (this.e == null)
      return; 
    this.t = new ArrayList<PictureTabModel>();
    this.n = (CommonTopTitleNoTrans)paramView.findViewById(2131296873);
    this.n.setCenterText(2131757068);
    this.n.setLeftImg(2131232743);
    this.n.a();
    this.n.setCenterClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (InterestGalleryFragment.a(this.a) != null && InterestGalleryFragment.a(this.a).a() != null)
              InterestGalleryFragment.a(this.a).a().t(); 
          }
        });
    this.n.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ((Activity)InterestGalleryFragment.b(this.a)).finish();
          }
        });
    this.g = (TextView)paramView.findViewById(2131300720);
    this.l = (LinearLayout)paramView.findViewById(2131297161);
    this.k = (FrameLayout)paramView.findViewById(2131297153);
    this.h = (ImageView)paramView.findViewById(2131297886);
    this.i = (ViewPager)paramView.findViewById(2131301730);
    this.o = (TabTitleTrackIndicatorWithDot)paramView.findViewById(2131300462);
    this.m = (NoDataAndLoadFailView)paramView.findViewById(2131298984);
    this.r = new TabIndicatorAdapter(this, getFragmentManager());
    this.i.setAdapter((PagerAdapter)this.r);
    this.o.setViewPager(this.i);
    k();
    this.h.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            InterestGalleryFragment.d(this.a).showAsDropDown((View)InterestGalleryFragment.c(this.a));
          }
        });
    this.i.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            InterestGalleryFragment.a(this.a, param1Int);
          }
        });
  }
  
  private void k() {
    View view = LayoutInflater.from(this.f).inflate(2131494076, null);
    ImageView imageView = (ImageView)view.findViewById(2131297729);
    RecyclerView recyclerView = (RecyclerView)view.findViewById(2131299795);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f, 4);
    GridItemSpaceDecoration gridItemSpaceDecoration = new GridItemSpaceDecoration(this, 4, DensityUtils.a(this.f, 7.5F));
    this.j = new PopupWindow(-1, -2);
    this.j.setContentView(view);
    this.j.setTouchable(true);
    this.j.setFocusable(true);
    this.j.setBackgroundDrawable((Drawable)new BitmapDrawable());
    this.j.setOutsideTouchable(true);
    this.j.update();
    this.q = new PictureTabAdapter(this.f, this.t);
    recyclerView.setAdapter((RecyclerView.Adapter)this.q);
    recyclerView.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    recyclerView.addItemDecoration(gridItemSpaceDecoration);
    this.q.a(this);
    imageView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            InterestGalleryFragment.d(this.a).dismiss();
          }
        });
    this.j.setOnDismissListener(new PopupWindow.OnDismissListener(this) {
          public void onDismiss() {
            InterestGalleryFragment.f(this.a).setCurrentItem(InterestGalleryFragment.e(this.a));
          }
        });
  }
  
  public void a() {
    this.k.setVisibility(8);
    if (!NetworkUtils.b()) {
      this.g.setVisibility(8);
      this.l.setVisibility(8);
      this.i.setVisibility(8);
      this.m.b();
      return;
    } 
    this.g.setVisibility(0);
    this.l.setVisibility(0);
    this.i.setVisibility(0);
    this.m.c();
  }
  
  public void a(View paramView, int paramInt) {
    this.u = paramInt;
    this.j.dismiss();
  }
  
  public void a(List<PictureTabModel> paramList) {
    this.t.clear();
    this.t.addAll(paramList);
    this.r.notifyDataSetChanged();
    this.o.a();
    this.q.notifyDataSetChanged();
    int j = paramList.size();
    int i = 0;
    if (j == 1) {
      this.l.setVisibility(8);
    } else {
      this.l.setVisibility(0);
    } 
    while (i < this.t.size()) {
      if (Integer.parseInt(this.s) == ((PictureTabModel)this.t.get(i)).classify_id) {
        this.u = i;
        this.i.setCurrentItem(i);
        return;
      } 
      i++;
    } 
  }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    this.f = paramContext;
    if (getArguments() != null)
      this.s = getArguments().getString("tab_id", "0"); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    InstantLog.a("picture_lib_in");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = paramLayoutInflater.inflate(2131493159, paramViewGroup, false);
    this.p = (InterestGalleryContract.IPresenter)new InterestGalleryPresenter(this, (IRequestHost)w_());
    a(this.e);
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    AlbumViewDataManager.a().a(false);
    InstantLog.a("picture_lib_out");
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.p.bb_();
  }
  
  class GridItemSpaceDecoration extends RecyclerView.ItemDecoration {
    private int b;
    
    private int c;
    
    public GridItemSpaceDecoration(InterestGalleryFragment this$0, int param1Int1, int param1Int2) {
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
      int i = param1RecyclerView.getChildAdapterPosition(param1View);
      int j = this.b;
      int k = i % j;
      int m = this.c;
      param1Rect.left = k * m / j;
      param1Rect.right = m - (k + 1) * m / j;
      if (i >= j)
        param1Rect.top = m * 2; 
    }
  }
  
  class TabIndicatorAdapter extends FragmentPagerAdapter {
    PicturesWallFragment a;
    
    public TabIndicatorAdapter(InterestGalleryFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public PicturesWallFragment a() {
      return this.a;
    }
    
    public PicturesWallFragment a(int param1Int) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((PictureTabModel)InterestGalleryFragment.g(this.b).get(param1Int)).classify_id);
      stringBuilder.append("");
      return PicturesWallFragment.a(stringBuilder.toString());
    }
    
    public int getCount() {
      return (InterestGalleryFragment.g(this.b) == null) ? 0 : InterestGalleryFragment.g(this.b).size();
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return ((PictureTabModel)InterestGalleryFragment.g(this.b).get(param1Int)).name;
    }
    
    public void setPrimaryItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.setPrimaryItem(param1ViewGroup, param1Int, param1Object);
      if (param1Object instanceof PicturesWallFragment)
        this.a = (PicturesWallFragment)param1Object; 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\InterestGalleryFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */