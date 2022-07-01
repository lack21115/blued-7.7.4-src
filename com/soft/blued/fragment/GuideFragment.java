package com.soft.blued.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.ui.BaseDialogFragment;
import com.soft.blued.customview.ProhibitedSlidingViewPager;
import java.util.ArrayList;
import java.util.List;

public class GuideFragment extends BaseDialogFragment {
  private ProhibitedSlidingViewPager a;
  
  private GuideAdapter b;
  
  private int[] c;
  
  private boolean d = false;
  
  private void a(View paramView) {
    this.a = (ProhibitedSlidingViewPager)paramView.findViewById(2131297336);
    this.a.setAllowedSwipeDirection(ProhibitedSlidingViewPager.SwipeDirection.c);
    this.a.setLastPageToRightListener(new ProhibitedSlidingViewPager.ILastPageScrollToRightListener(this) {
          public boolean a() {
            this.a.getActivity().setResult(-1);
            this.a.getActivity().finish();
            return true;
          }
        });
    this.b = new GuideAdapter((Activity)getActivity(), this.a, this.c, this.d);
    this.a.setAdapter(this.b);
  }
  
  private void f() {
    Bundle bundle = getArguments();
    if (bundle == null) {
      getActivity().finish();
      return;
    } 
    this.c = bundle.getIntArray("guide_ids");
    int[] arrayOfInt = this.c;
    if (arrayOfInt == null || arrayOfInt.length <= 0) {
      getActivity().finish();
      return;
    } 
    this.d = bundle.getBoolean("guide_is_layout");
  }
  
  public boolean V_() {
    return true;
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setCancelable(false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131493108, null);
    f();
    a(view);
    return view;
  }
  
  public static class GuideAdapter extends PagerAdapter implements View.OnClickListener {
    private List<View> a = new ArrayList<View>();
    
    private LayoutInflater b;
    
    private ProhibitedSlidingViewPager c;
    
    private Activity d;
    
    private boolean e;
    
    public GuideAdapter(Activity param1Activity, ProhibitedSlidingViewPager param1ProhibitedSlidingViewPager, int[] param1ArrayOfint, boolean param1Boolean) {
      int j = 0;
      int i = 0;
      this.e = false;
      this.d = param1Activity;
      this.c = param1ProhibitedSlidingViewPager;
      this.e = param1Boolean;
      this.b = LayoutInflater.from((Context)param1Activity);
      if (param1Boolean) {
        j = param1ArrayOfint.length;
        while (i < j) {
          int k = param1ArrayOfint[i];
          this.a.add(this.b.inflate(k, null));
          i++;
        } 
      } else {
        int k = param1ArrayOfint.length;
        for (i = j; i < k; i++) {
          j = param1ArrayOfint[i];
          View view = this.b.inflate(2131493753, null);
          ((ImageView)view.findViewById(2131297488)).setImageResource(j);
          this.a.add(view);
        } 
      } 
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return this.a.size();
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      View view = this.a.get(param1Int);
      view.setTag(Integer.valueOf(param1Int));
      view.setOnClickListener(this);
      param1ViewGroup.addView(view);
      return view;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
    
    public void onClick(View param1View) {
      int i = ((Integer)param1View.getTag()).intValue();
      if (i == this.a.size() - 1) {
        this.d.setResult(-1);
        this.d.finish();
        return;
      } 
      this.c.setCurrentItem(i + 1, true);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\fragment\GuideFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */