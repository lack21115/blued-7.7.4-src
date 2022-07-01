package com.soft.blued.ui.photo.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.module.common.utils.DialogUtils;
import com.github.chrisbanes.photoview.PhotoView;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.ui.feed.fragment.PhotosRefreshObserver;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.List;

public class ShowPhotoRemoveFragment extends BasePhotoFragment implements View.OnClickListener {
  private Context f;
  
  private View g;
  
  private LayoutInflater h;
  
  private ImagePagerAdapter i;
  
  private LoadOptions j;
  
  private int k;
  
  private int l;
  
  private Dialog m;
  
  private HackyViewPager n;
  
  private ImageView o;
  
  private int p;
  
  private List<ChildImageInfo> q = new ArrayList<ChildImageInfo>();
  
  private View r;
  
  private TextView s;
  
  private void n() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.p = getArguments().getInt("show_photo");
      this.k = bundle.getInt("photo_index", 0);
      this.j = (LoadOptions)bundle.getSerializable("photo_options");
      this.l = this.k;
      this.q.clear();
      for (ChildImageInfo childImageInfo : SelectPhotoManager.a().c()) {
        if (!TextUtils.isEmpty(childImageInfo.mImagePath))
          this.q.add(childImageInfo); 
      } 
    } 
  }
  
  private void o() {
    this.m = DialogUtils.a((Context)getActivity());
    this.h = LayoutInflater.from(this.f);
    this.n = (HackyViewPager)this.g.findViewById(2131299443);
    this.o = (ImageView)this.g.findViewById(2131296787);
    this.o.setOnClickListener(this);
    this.r = this.g.findViewById(2131300702);
    this.r.setOnClickListener(this);
    this.s = (TextView)this.g.findViewById(2131301182);
    this.i = new ImagePagerAdapter(this, getChildFragmentManager());
    this.n.setAdapter((PagerAdapter)this.i);
    this.n.setCurrentItem(this.k);
    this.n.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            ShowPhotoRemoveFragment.a(this.a, param1Int);
            ShowPhotoRemoveFragment.a(this.a);
          }
        });
    this.o.setVisibility(0);
    this.r.setVisibility(0);
    q();
  }
  
  private void p() {
    if (this.p == 1) {
      if (BluedPreferences.bx() == 0) {
        BluedPreferences.n(1);
        return;
      } 
    } else if (BluedPreferences.bw() == 0) {
      BluedPreferences.m(1);
    } 
  }
  
  private void q() {
    if (this.q.size() > 1) {
      TextView textView = this.s;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.k + 1);
      stringBuilder.append("/");
      stringBuilder.append(this.q.size());
      textView.setText(stringBuilder.toString());
      if (this.d) {
        this.s.setVisibility(0);
        return;
      } 
    } else {
      this.s.setVisibility(8);
    } 
  }
  
  public void a(View paramView) {
    super.a(paramView);
    l();
  }
  
  public void aS_() {
    super.aS_();
    if (!this.d) {
      ImageView imageView = this.o;
      TextView textView = this.s;
      int i = this.q.size();
      boolean bool = true;
      if (i <= 1)
        bool = false; 
      b((View)imageView, (View)textView, bool);
    } 
  }
  
  public void b(View paramView) {
    super.b(paramView);
    l();
  }
  
  public void f_(int paramInt) {
    super.f_(paramInt);
    this.n.getBackground().setAlpha(paramInt);
    if (this.d) {
      ImageView imageView = this.o;
      TextView textView = this.s;
      paramInt = this.q.size();
      boolean bool = true;
      if (paramInt <= 1)
        bool = false; 
      a((View)imageView, (View)textView, bool);
    } 
  }
  
  public boolean j() {
    return false;
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296787) {
      if (i != 2131300702)
        return; 
      CommonAlertDialog.a((Context)getActivity(), null, getResources().getString(2131756416), getResources().getString(2131756100), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              param1Int = ShowPhotoRemoveFragment.e(this.a).getCurrentItem();
              SelectPhotoManager.a().b(ShowPhotoRemoveFragment.d(this.a).get(param1Int));
              ShowPhotoRemoveFragment.d(this.a).remove(param1Int);
              ShowPhotoRemoveFragment.e(this.a).setAdapter((PagerAdapter)ShowPhotoRemoveFragment.f(this.a));
              ShowPhotoRemoveFragment.e(this.a).setCurrentItem(param1Int);
              if (param1Int == ShowPhotoRemoveFragment.d(this.a).size()) {
                if (ShowPhotoRemoveFragment.d(this.a).size() == 0) {
                  ShowPhotoRemoveFragment.c(this.a).setText("1/1");
                } else {
                  TextView textView = ShowPhotoRemoveFragment.c(this.a);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(ShowPhotoRemoveFragment.d(this.a).size());
                  stringBuilder.append("/");
                  stringBuilder.append(ShowPhotoRemoveFragment.d(this.a).size());
                  textView.setText(stringBuilder.toString());
                } 
              } else {
                TextView textView = ShowPhotoRemoveFragment.c(this.a);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(param1Int + 1);
                stringBuilder.append("/");
                stringBuilder.append(ShowPhotoRemoveFragment.d(this.a).size());
                textView.setText(stringBuilder.toString());
              } 
              if (param1Int == ShowPhotoRemoveFragment.d(this.a).size() && ShowPhotoRemoveFragment.d(this.a).size() == 0)
                this.a.getActivity().finish(); 
            }
          },  null, null, null);
      return;
    } 
    k();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
      getActivity().postponeEnterTransition(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493320, paramViewGroup, false);
      n();
      o();
      p();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    if (paramBundle != null)
      this.k = paramBundle.getInt("state_position"); 
    return this.g;
  }
  
  public void onDestroy() {
    PhotosRefreshObserver.a().b();
    super.onDestroy();
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    paramBundle.putInt("state_position", this.n.getCurrentItem());
  }
  
  class ImagePagerAdapter extends FragmentStatePagerAdapter {
    public ImagePagerAdapter(ShowPhotoRemoveFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return ShowPhotoRemoveFragment.d(this.a).size();
    }
    
    public Fragment getItem(int param1Int) {
      String str = ((ChildImageInfo)ShowPhotoRemoveFragment.d(this.a).get(param1Int)).mImagePath;
      if (!TextUtils.isEmpty(str))
        str.contains("http"); 
      return (Fragment)BizPhotoDetailFragment.a(str, ShowPhotoRemoveFragment.g(this.a), ShowPhotoRemoveFragment.h(this.a));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\fragment\ShowPhotoRemoveFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */