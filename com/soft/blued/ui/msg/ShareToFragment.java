package com.soft.blued.ui.msg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.PageTabLayout;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;

public class ShareToFragment extends BaseFragment {
  private Bundle d;
  
  private Context e;
  
  private ViewPager f;
  
  private CommonTopTitleNoTrans g;
  
  private PageTabLayout h;
  
  private ShapeTextView i;
  
  private int j = 0;
  
  public static void a(Context paramContext, ShareToMsgEntity paramShareToMsgEntity) {
    Bundle bundle = new Bundle();
    bundle.putParcelable("share_entity", (Parcelable)paramShareToMsgEntity);
    bundle.putInt("share_type", 0);
    TerminalActivity.d(paramContext, ShareToFragment.class, bundle);
  }
  
  public static void a(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("circle_id", paramString);
    bundle.putInt("share_type", 1);
    TerminalActivity.d(paramContext, ShareToFragment.class, bundle);
  }
  
  public String[] a() {
    return new String[] { getResources().getString(2131758529), getResources().getString(2131756565) };
  }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    this.e = paramContext;
    this.d = getArguments();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    return paramLayoutInflater.inflate(2131493315, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.i = (ShapeTextView)paramView.findViewById(2131300163);
    ShapeHelper.b((ShapeHelper.ShapeView)this.i, 2131100881);
    this.f = (ViewPager)paramView.findViewById(2131301729);
    this.g = (CommonTopTitleNoTrans)paramView.findViewById(2131296873);
    this.h = (PageTabLayout)paramView.findViewById(2131300168);
    this.h.setupWithViewPager(this.f);
    this.f.setAdapter((PagerAdapter)new MyAdapter(this, getFragmentManager()));
    this.g.a();
    this.g.setLeftImg(2131232743);
    this.g.setLeftClickListener(new -$$Lambda$ShareToFragment$hkVTXruTIWrlO8a6imuiC8HRji0(this));
    if (getArguments() != null)
      this.j = getArguments().getInt("share_type"); 
    if (this.j != 1) {
      this.g.setCenterText(2131758762);
      return;
    } 
    this.g.setCenterText(2131755895);
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    private String[] b = this.a.a();
    
    public MyAdapter(ShareToFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return this.b.length;
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int != 1) ? ((param1Int != 2) ? ShareToChatRecentFragment.a(ShareToFragment.a(this.a)) : ShareToGroupsFragment.a(ShareToFragment.a(this.a))) : ShareToFriendsFragment.a(ShareToFragment.a(this.a)));
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.b[param1Int];
    }
  }
  
  public static @interface Type {
    public static final int SHARE_CIRCLE = 1;
    
    public static final int SHARE_MSG = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\ShareToFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */