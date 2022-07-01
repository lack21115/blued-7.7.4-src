package com.soft.blued.ui.welcome;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.user.UserInfo;
import java.util.ArrayList;
import java.util.List;

public class NewfeatureGuideAdapter extends PagerAdapter implements View.OnClickListener {
  public LayoutInflater a;
  
  private List<View> b = new ArrayList<View>();
  
  private ViewPager c;
  
  private Activity d;
  
  public NewfeatureGuideAdapter(Activity paramActivity, ViewPager paramViewPager) {
    this.d = paramActivity;
    this.c = paramViewPager;
    int i = 0;
    Integer[] arrayOfInteger = new Integer[0];
    this.a = (LayoutInflater)AppInfo.d().getSystemService("layout_inflater");
    while (i < arrayOfInteger.length) {
      View view;
      if (i == arrayOfInteger.length - 1) {
        view = this.a.inflate(2131493781, null);
      } else {
        view = this.a.inflate(2131493780, null);
      } 
      ((ImageView)view.findViewById(2131297488)).setImageResource(arrayOfInteger[i].intValue());
      this.b.add(view);
      i++;
    } 
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
    View view = this.b.get(paramInt);
    if (paramInt == this.b.size() - 1)
      view.findViewById(2131300590).setOnClickListener(this); 
    paramViewGroup.addView(view);
    return view;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject) {
    return (paramView == paramObject);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131300590)
      return; 
    if (UserInfo.a().j()) {
      HomeArgumentHelper.a((Context)this.d);
    } else {
      SignInActivity.a((Context)this.d, new android.os.Bundle[0]);
    } 
    this.c.setEnabled(false);
    this.d.finish();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\welcome\NewfeatureGuideAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */