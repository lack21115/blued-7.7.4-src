package com.soft.blued.ui.yy_room.fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.view.PageTabLayout;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.ui.msg.ShareToGroupsFragment;

public class YYInviteFragment extends BaseDialogFragment {
  private Context a;
  
  private ViewPager b;
  
  private PageTabLayout c;
  
  private Bundle d;
  
  private View e;
  
  private View f;
  
  private void g() {
    this.f = this.e.findViewById(2131297600);
    this.b = (ViewPager)this.e.findViewById(2131297601);
    this.c = (PageTabLayout)this.e.findViewById(2131297603);
    this.b.setId(2131297601);
    this.c.setupWithViewPager(this.b);
    this.b.setAdapter((PagerAdapter)new MyAdapter(this, getChildFragmentManager()));
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.dismiss();
          }
        });
  }
  
  public String[] f() {
    return new String[] { getResources().getString(2131759479), getResources().getString(2131759441) };
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    getDialog().getWindow().requestFeature(1);
    super.onActivityCreated(paramBundle);
    if (Build.VERSION.SDK_INT >= 23)
      getDialog().getWindow().getDecorView().setSystemUiVisibility(9216); 
    getDialog().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    getDialog().getWindow().setLayout(-1, -1);
    this.d = getArguments();
    g();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.a = (Context)getActivity();
    setStyle(0, 2131820778);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = paramLayoutInflater.inflate(2131493375, paramViewGroup, false);
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    LiveEventBus.get("inner_fragment_close").post("");
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString) {
    try {
      ReflectionUtils.a(this, "mDismissed", Boolean.valueOf(false));
      ReflectionUtils.a(this, "mShownByMe", Boolean.valueOf(true));
      FragmentTransaction fragmentTransaction = paramFragmentManager.beginTransaction();
      fragmentTransaction.add((Fragment)this, paramString);
      fragmentTransaction.commitAllowingStateLoss();
      return;
    } catch (Exception exception) {
      super.show(paramFragmentManager, paramString);
      return;
    } 
  }
  
  class MyAdapter extends FragmentPagerAdapter {
    private String[] b = this.a.f();
    
    public MyAdapter(YYInviteFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return this.b.length;
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int != 1) ? ((param1Int != 2) ? InviteChatRecentFragment.a(YYInviteFragment.a(this.a)) : ShareToGroupsFragment.a(YYInviteFragment.a(this.a))) : InviteFriendsFragment.a(YYInviteFragment.a(this.a)));
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.b[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\fragment\YYInviteFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */