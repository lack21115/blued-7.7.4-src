package com.soft.blued.ui.group;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.soft.blued.customview.SearchView;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.ui.group.model.BluedGroupCheck;
import com.soft.blued.user.UserInfo;

public class GroupFragment extends BaseFragment implements View.OnClickListener {
  private static int D = 3;
  
  public static int d = 0;
  
  public static String f = "ISNEARBY";
  
  public static String g = "NEARBYGROUP1";
  
  public static String h = "NEARBYGROUP2";
  
  private boolean A;
  
  private int B;
  
  private ViewPager C;
  
  private ViewPager.OnPageChangeListener E = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        GroupFragment.a(this.a, param1Int);
        if (GroupFragment.b(this.a) != 0);
      }
    };
  
  public BluedGroupCheck.GroupFailureReason e;
  
  GroupFragmentRecommend i;
  
  GroupFragmentNear j;
  
  UserGroupListsFragment k;
  
  private String l = GroupFragment.class.getSimpleName();
  
  private View m;
  
  private Context n;
  
  private LayoutInflater o;
  
  private View p;
  
  private SearchView q;
  
  private TextView r;
  
  private TextView s;
  
  private LinearLayout t;
  
  private View u;
  
  private ViewGroup v;
  
  private TextView w;
  
  private ImageView x;
  
  private ImageView y;
  
  private Bundle z;
  
  private void k() {
    this.u = this.m.findViewById(2131300273);
    this.v = (ViewGroup)this.m.findViewById(2131296869);
    this.v.setVisibility(8);
    this.w = (TextView)this.m.findViewById(2131296871);
    this.y = (ImageView)this.m.findViewById(2131296863);
    this.y.setImageDrawable(BluedSkinUtils.b(this.n, 2131232743));
    this.x = (ImageView)this.m.findViewById(2131296867);
    this.x.setVisibility(8);
    this.w.setText(getString(2131756655));
    this.w.setVisibility(0);
    this.y.setOnClickListener(this);
    this.w.setOnClickListener(this);
  }
  
  private void l() {
    this.z = getArguments();
    Bundle bundle = this.z;
    if (bundle != null)
      this.A = bundle.getBoolean(f); 
    this.o = (LayoutInflater)this.n.getSystemService("layout_inflater");
    if (this.A) {
      d = 0;
    } else {
      d = 1;
    } 
    this.p = this.o.inflate(2131493139, null);
    this.q = (SearchView)this.p.findViewById(2131297300);
    this.q.setMaskLayerOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            TerminalActivity.d(GroupFragment.a(this.a), GroupSearchFragment.class, null);
          }
        });
    this.r = (TextView)this.p.findViewById(2131301297);
    this.s = (TextView)this.p.findViewById(2131301241);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t = (LinearLayout)this.p.findViewById(2131298858);
    this.t.setVisibility(8);
  }
  
  private void m() {
    this.e = new BluedGroupCheck.GroupFailureReason();
    this.C = (ViewPager)this.m.findViewById(2131297297);
    MyAdapter myAdapter = new MyAdapter(this, getChildFragmentManager());
    this.C.setAdapter((PagerAdapter)myAdapter);
    this.C.setOnPageChangeListener(this.E);
    this.C.setOffscreenPageLimit(2);
    if (d == 0)
      this.C.setCurrentItem(1); 
    ((TabPageIndicatorWithDot)this.m.findViewById(2131301725)).setViewPager(this.C);
    D = 3;
    this.i = new GroupFragmentRecommend();
    this.j = new GroupFragmentNear();
    if (d == 0) {
      Bundle bundle1 = new Bundle();
      bundle1.putSerializable(GroupFragmentNear.d, this.z.getSerializable(g));
      bundle1.putSerializable(GroupFragmentNear.e, this.z.getSerializable(h));
      this.j.setArguments(bundle1);
    } 
    Bundle bundle = new Bundle();
    bundle.putString("UID", UserInfo.a().i().getUid());
    bundle.putBoolean("hidetitle", true);
    this.k = new UserGroupListsFragment();
    this.k.setArguments(bundle);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296871)
        return; 
      TerminalActivity.d((Context)getActivity(), GroupCreateFragment.class, null);
      return;
    } 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.n = (Context)getActivity();
    View view = this.m;
    if (view == null) {
      this.m = paramLayoutInflater.inflate(2131493149, paramViewGroup, false);
      k();
      l();
      m();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.m.getParent()).removeView(this.m);
    } 
    return this.m;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    private String[] b = new String[] { GroupFragment.a(this.a).getResources().getString(2131756772), GroupFragment.a(this.a).getResources().getString(2131756735), GroupFragment.a(this.a).getResources().getString(2131756716) };
    
    public MyAdapter(GroupFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return GroupFragment.a();
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : this.a.k) : this.a.j) : this.a.i);
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.b[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */