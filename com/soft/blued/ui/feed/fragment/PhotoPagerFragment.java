package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
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
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.FileUtils;
import com.soft.blued.constant.PhotoConstants;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.ui.feed.manager.ChildPhotoManager;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.utils.AppUtils;
import java.util.ArrayList;
import java.util.List;

public class PhotoPagerFragment extends BaseFragment {
  private Context d;
  
  private View e;
  
  private HackyViewPager f;
  
  private LayoutInflater g;
  
  private ImagePagerAdapter h;
  
  private TextView i;
  
  private TextView j;
  
  private View k;
  
  private TextView l;
  
  private ImageView m;
  
  private ImageView n;
  
  private int o;
  
  private List<ChildImageInfo> p = new ArrayList<ChildImageInfo>();
  
  private boolean q = true;
  
  private int r;
  
  private String s;
  
  private void a() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.r = bundle.getInt("select_photo", 0);
      this.o = bundle.getInt("photo_index", 0);
      this.s = bundle.getString("super_topic_id");
      this.o--;
    } 
    this.p.addAll(ChildPhotoManager.a().c());
    if (this.p.size() > 0)
      this.p.remove(0); 
  }
  
  private void a(int paramInt) {
    if ((ChildPhotoManager.a().a(paramInt)).mSelect) {
      this.n.setImageResource(2131233514);
      return;
    } 
    this.n.setImageResource(2131233518);
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, int paramInt2, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putInt("select_photo", paramInt2);
    bundle.putInt("photo_index", paramInt1);
    bundle.putString("super_topic_id", paramString);
    TerminalActivity.a((Fragment)paramBaseFragment, PhotoPagerFragment.class, bundle, 1);
  }
  
  private void k() {
    this.g = LayoutInflater.from(this.d);
    this.f = (HackyViewPager)this.e.findViewById(2131299443);
    this.h = new ImagePagerAdapter(this, getChildFragmentManager());
    this.f.setAdapter((PagerAdapter)this.h);
    this.k = this.e.findViewById(2131300273);
    this.m = (ImageView)this.k.findViewById(2131296863);
    this.l = (TextView)this.k.findViewById(2131296857);
    this.n = (ImageView)this.k.findViewById(2131296867);
    this.j = (TextView)this.e.findViewById(2131299407);
    this.i = (TextView)this.e.findViewById(2131296954);
    this.n.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ChildImageInfo childImageInfo = ChildPhotoManager.a().a(PhotoPagerFragment.a(this.a) + 1);
            if (childImageInfo.mSelect) {
              childImageInfo.mSelect = false;
              PhotoPagerFragment.b(this.a).setImageResource(2131233518);
              SelectPhotoManager.a().b(childImageInfo);
              PhotoPagerFragment.c(this.a);
              return;
            } 
            if (SelectPhotoManager.a().b() + PhotoSelectFragment.d.size() < PhotoConstants.CONFIG.a) {
              childImageInfo.mSelect = true;
              PhotoPagerFragment.b(this.a).setImageResource(2131233514);
              SelectPhotoManager.a().a(childImageInfo);
              PhotoPagerFragment.c(this.a);
              return;
            } 
            AppMethods.a(String.format(this.a.getResources().getString(2131757865), new Object[] { Integer.valueOf(PhotoConstants.CONFIG.a) }));
          }
        });
    this.m.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            Intent intent = new Intent();
            intent.putExtra("page_state", 0);
            this.a.getActivity().setResult(-1, intent);
            this.a.getActivity().finish();
          }
        });
    this.f.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            PhotoPagerFragment.a(this.a, param1Int);
            PhotoPagerFragment.b(this.a, param1Int + 1);
          }
        });
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (SelectPhotoManager.a().b() == 0) {
              ChildImageInfo childImageInfo = new ChildImageInfo();
              childImageInfo.mImagePath = ((ChildImageInfo)PhotoPagerFragment.d(this.a).get(PhotoPagerFragment.a(this.a))).mImagePath;
              childImageInfo.mSelect = true;
              SelectPhotoManager.a().a(childImageInfo);
              PhotoPagerFragment.b(this.a).setImageResource(2131233514);
            } 
            if (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy())
              for (int j = 0; j < SelectPhotoManager.a().c().size(); j++) {
                ChildImageInfo childImageInfo = SelectPhotoManager.a().c().get(j);
                if (childImageInfo != null && !TextUtils.isEmpty(childImageInfo.imgUri) && !AppUtils.b(childImageInfo.mImagePath)) {
                  String str = RecyclingUtils.e("photo");
                  FileUtils.a(childImageInfo.imgUri, str);
                  childImageInfo.mImagePath = str;
                } 
              }  
            int i = PhotoPagerFragment.e(this.a);
            if (i != 5) {
              if (i != 7) {
                FeedPostFragment.a(PhotoPagerFragment.f(this.a));
              } else {
                SelectPhotoManager.a().c().addAll(0, PhotoSelectFragment.d);
              } 
            } else {
              SelectPhotoManager.a().c().addAll(0, PhotoSelectFragment.d);
              PhotosRefreshObserver.a().b();
            } 
            Intent intent = new Intent();
            intent.putExtra("page_state", 1);
            this.a.getActivity().setResult(-1, intent);
            this.a.getActivity().finish();
          }
        });
    a(this.o + 1);
    this.f.setCurrentItem(this.o);
  }
  
  private void l() {
    int i = SelectPhotoManager.a().b();
    if (i == 0) {
      this.j.setVisibility(8);
      return;
    } 
    this.j.setVisibility(0);
    TextView textView = this.j;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
  }
  
  public boolean V_() {
    getActivity().setResult(-1);
    return false;
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493264, paramViewGroup, false);
      a();
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  class ImagePagerAdapter extends FragmentStatePagerAdapter {
    public ImagePagerAdapter(PhotoPagerFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return PhotoPagerFragment.d(this.a).size();
    }
    
    public Fragment getItem(int param1Int) {
      String str;
      if (!TextUtils.isEmpty(((ChildImageInfo)PhotoPagerFragment.d(this.a).get(param1Int)).imgUri)) {
        str = ((ChildImageInfo)PhotoPagerFragment.d(this.a).get(param1Int)).imgUri;
      } else {
        str = ((ChildImageInfo)PhotoPagerFragment.d(this.a).get(param1Int)).mImagePath;
      } 
      return (Fragment)ImageDetailFragment.a(str, true, 4, null, param1Int, PhotoPagerFragment.d(this.a).size());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\PhotoPagerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */