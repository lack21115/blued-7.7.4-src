package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.List;

public class PhotoRemoveFragment extends BaseFragment implements View.OnClickListener {
  private View d;
  
  private HackyViewPager e;
  
  private ImagePagerAdapter f;
  
  private View g;
  
  private ImageView h;
  
  private ImageView i;
  
  private TextView j;
  
  private int k;
  
  private List<ChildImageInfo> l = new ArrayList<ChildImageInfo>();
  
  private void a() {
    this.g = this.d.findViewById(2131300273);
    this.h = (ImageView)this.g.findViewById(2131296863);
    this.j = (TextView)this.g.findViewById(2131296857);
    this.i = (ImageView)this.g.findViewById(2131296867);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    TextView textView = this.j;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.k + 1);
    stringBuilder.append("/");
    stringBuilder.append(this.l.size());
    textView.setText(stringBuilder.toString());
  }
  
  private void k() {
    Bundle bundle = getArguments();
    if (bundle != null)
      this.k = bundle.getInt("photo_index"); 
    this.l.clear();
    this.l.addAll(SelectPhotoManager.a().c());
  }
  
  private void l() {
    this.e = (HackyViewPager)this.d.findViewById(2131299443);
    this.f = new ImagePagerAdapter(this, getChildFragmentManager());
    this.e.setAdapter((PagerAdapter)this.f);
    this.e.setCurrentItem(this.k);
    this.e.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            PhotoRemoveFragment.a(this.a, param1Int);
            TextView textView = PhotoRemoveFragment.c(this.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(PhotoRemoveFragment.a(this.a) + 1);
            stringBuilder.append("/");
            stringBuilder.append(PhotoRemoveFragment.b(this.a).size());
            textView.setText(stringBuilder.toString());
          }
        });
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      CommonAlertDialog.a((Context)getActivity(), null, getResources().getString(2131756416), getResources().getString(2131756100), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              param1Int = PhotoRemoveFragment.d(this.a).getCurrentItem();
              SelectPhotoManager.a().a(((ChildImageInfo)PhotoRemoveFragment.b(this.a).get(param1Int)).mImagePath);
              PhotoRemoveFragment.b(this.a).remove(param1Int);
              PhotoRemoveFragment.d(this.a).setAdapter((PagerAdapter)PhotoRemoveFragment.e(this.a));
              PhotoRemoveFragment.d(this.a).setCurrentItem(param1Int);
              if (param1Int == PhotoRemoveFragment.b(this.a).size()) {
                if (PhotoRemoveFragment.b(this.a).size() == 0) {
                  PhotoRemoveFragment.c(this.a).setText("1/1");
                } else {
                  TextView textView = PhotoRemoveFragment.c(this.a);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(PhotoRemoveFragment.b(this.a).size());
                  stringBuilder.append("/");
                  stringBuilder.append(PhotoRemoveFragment.b(this.a).size());
                  textView.setText(stringBuilder.toString());
                } 
              } else {
                TextView textView = PhotoRemoveFragment.c(this.a);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(param1Int + 1);
                stringBuilder.append("/");
                stringBuilder.append(PhotoRemoveFragment.b(this.a).size());
                textView.setText(stringBuilder.toString());
              } 
              if (param1Int == PhotoRemoveFragment.b(this.a).size() && PhotoRemoveFragment.b(this.a).size() == 0)
                this.a.getActivity().finish(); 
            }
          },  null, null, null);
      return;
    } 
    PhotosRefreshObserver.a().b();
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493125, paramViewGroup, false);
      k();
      l();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
  
  class ImagePagerAdapter extends FragmentStatePagerAdapter {
    public ImagePagerAdapter(PhotoRemoveFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return PhotoRemoveFragment.b(this.a).size();
    }
    
    public Fragment getItem(int param1Int) {
      String str = ((ChildImageInfo)PhotoRemoveFragment.b(this.a).get(param1Int)).mImagePath;
      return (Fragment)ImageDetailFragment.a(str, str.contains("http://") ^ true, 4, null, param1Int, PhotoRemoveFragment.b(this.a).size());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\PhotoRemoveFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */