package com.blued.android.module.media.selector.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.contract.IAlbumPreviewBaseView;
import com.blued.android.module.media.selector.model.AlbumDataManager;
import com.blued.android.module.media.selector.observer.PLVideoObserver;
import com.blued.android.module.media.selector.present.AlbumPreviewBasePresenter;
import com.blued.android.module.media.selector.present.MediaBasePresent;
import com.blued.android.module.media.selector.utils.ViewUtils;
import com.blued.android.module.media.selector.view.HackyViewPager;
import com.blued.android.module.player.media.fragment.VideoDetailFragment;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.observer.EventCallBackAdapter;
import com.blued.android.module.player.media.observer.EventCallBackListener;
import com.blued.android.module.player.media.observer.EventCallbackObserver;

public abstract class AlbumPreviewBaseFragment extends MediaBaseFragment<IAlbumPreviewBaseView, AlbumPreviewBasePresenter> implements IAlbumPreviewBaseView, PLVideoObserver.IPLVideoObserver {
  EventCallBackAdapter d = new EventCallBackAdapter(this) {
      public void a(View param1View) {
        super.a(param1View);
        AlbumPreviewBaseFragment.b(this.a);
      }
      
      public void aT_() {
        super.aT_();
        this.a.getActivity().finish();
      }
      
      public void b(View param1View) {
        super.b(param1View);
        AlbumPreviewBaseFragment.b(this.a);
      }
    };
  
  private View g;
  
  private HackyViewPager h;
  
  private TextView i;
  
  private TextView j;
  
  private View k;
  
  private View l;
  
  private View m;
  
  private ImageView n;
  
  private ImageView o;
  
  private FragmentStatePagerAdapter p;
  
  public static void a(BaseFragment paramBaseFragment, Bundle paramBundle, int paramInt1, int paramInt2) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = b(paramInt1); 
    TerminalActivity.a((Fragment)paramBaseFragment, AlbumPreviewBaseFragment.class, bundle, paramInt2);
  }
  
  public static Bundle b(int paramInt) {
    Bundle bundle = new Bundle();
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    AlbumDataManager.setCurrentPosition(paramInt);
    return bundle;
  }
  
  private void m() {
    if (this.e != null) {
      this.e.d();
      this.e.a(null);
    } 
  }
  
  private void n() {
    if (this.e == null)
      return; 
    AlbumPreviewBasePresenter albumPreviewBasePresenter2 = this.e;
    MediaInfo mediaInfo = AlbumPreviewBasePresenter.f();
    if (mediaInfo == null) {
      V_();
      return;
    } 
    if (mediaInfo.media_type == AlbumPreviewBasePresenter.g()) {
      this.j.setVisibility(8);
      return;
    } 
    AlbumPreviewBasePresenter albumPreviewBasePresenter1 = this.e;
    if (AlbumPreviewBasePresenter.i() == 0) {
      this.j.setVisibility(8);
      return;
    } 
    this.j.setVisibility(0);
    TextView textView = this.j;
    StringBuilder stringBuilder = new StringBuilder();
    AlbumPreviewBasePresenter albumPreviewBasePresenter3 = this.e;
    stringBuilder.append(AlbumPreviewBasePresenter.i());
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
  }
  
  private void o() {
    View view = this.k;
    if (view != null)
      if (view.getVisibility() == 0) {
        ViewUtils.d(getContext(), this.k);
      } else {
        this.k.setVisibility(0);
        ViewUtils.c(getContext(), this.k);
      }  
    view = this.l;
    if (view != null) {
      if (view.getVisibility() == 0) {
        ViewUtils.b(getContext(), this.l);
        return;
      } 
      this.l.setVisibility(0);
      ViewUtils.a(getContext(), this.l);
    } 
  }
  
  protected void B() {
    AlbumPreviewBasePresenter albumPreviewBasePresenter1 = this.e;
    a(AlbumPreviewBasePresenter.e());
    this.p = k();
    FragmentStatePagerAdapter fragmentStatePagerAdapter = this.p;
    if (fragmentStatePagerAdapter == null) {
      getActivity().finish();
      return;
    } 
    this.h.setAdapter((PagerAdapter)fragmentStatePagerAdapter);
    HackyViewPager hackyViewPager = this.h;
    AlbumPreviewBasePresenter albumPreviewBasePresenter2 = this.e;
    hackyViewPager.setCurrentItem(AlbumPreviewBasePresenter.e());
  }
  
  public BaseFragment a() {
    return this;
  }
  
  public BaseFragment a(VideoPlayConfig paramVideoPlayConfig) {
    return (BaseFragment)VideoDetailFragment.a(paramVideoPlayConfig);
  }
  
  public void a(int paramInt) {
    MediaInfo mediaInfo = this.e.a(paramInt);
    if (mediaInfo != null) {
      AlbumPreviewBasePresenter albumPreviewBasePresenter;
      if (mediaInfo.media_type == AlbumPreviewBasePresenter.g()) {
        albumPreviewBasePresenter = this.e;
        if (AlbumPreviewBasePresenter.i() > 0)
          this.m.setVisibility(0); 
        this.o.setVisibility(4);
        return;
      } 
      this.m.setVisibility(4);
      this.o.setVisibility(0);
      this.o.setSelected(((MediaInfo)albumPreviewBasePresenter).isSelected);
    } 
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    return false;
  }
  
  public boolean a(Bundle paramBundle) {
    return false;
  }
  
  protected void b(Bundle paramBundle) {
    this.h = (HackyViewPager)this.g.findViewById(R.id.vr_viewpager);
    this.h.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            AlbumPreviewBaseFragment albumPreviewBaseFragment = this.a;
            AlbumPreviewBasePresenter albumPreviewBasePresenter = albumPreviewBaseFragment.e;
            albumPreviewBaseFragment.a(AlbumPreviewBasePresenter.b(param1Int));
          }
        });
    this.k = this.g.findViewById(R.id.vr_vpg_title_v);
    StatusBarHelper.a((Activity)getActivity(), this.k);
    this.n = (ImageView)this.g.findViewById(R.id.vr_vpg_ctt_left);
    this.o = (ImageView)this.g.findViewById(R.id.vr_vpg_ctt_right);
    this.l = this.g.findViewById(R.id.vr_vpg_bottom_v);
    this.m = this.g.findViewById(R.id.vr_warn_ll);
    this.j = (TextView)this.g.findViewById(R.id.vr_vpg_num_view);
    this.i = (TextView)this.g.findViewById(R.id.vr_vpg_done_text_view);
    this.o.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            AlbumPreviewBasePresenter albumPreviewBasePresenter = this.a.e;
            MediaInfo mediaInfo = AlbumPreviewBasePresenter.f();
            if (mediaInfo == null) {
              this.a.V_();
              return;
            } 
            if (mediaInfo.isSelected) {
              mediaInfo.isSelected = false;
              AlbumPreviewBaseFragment.c(this.a).setSelected(mediaInfo.isSelected);
              this.a.e.a(mediaInfo);
              AlbumPreviewBaseFragment.d(this.a);
              return;
            } 
            if (this.a.e.c()) {
              ViewUtils.a((View)AlbumPreviewBaseFragment.c(this.a));
              AlbumPreviewBaseFragment.c(this.a).setSelected(mediaInfo.isSelected);
              AlbumPreviewBaseFragment.d(this.a);
            } 
          }
        });
    this.n.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            AlbumPreviewBaseFragment.e(this.a);
          }
        });
  }
  
  public FragmentStatePagerAdapter k() {
    return (this.e != null) ? this.e.b() : null;
  }
  
  protected AlbumPreviewBasePresenter l() {
    return new AlbumPreviewBasePresenter();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(R.layout.photo_preview_v, paramViewGroup, false);
      super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      n();
      EventCallbackObserver.a().a((EventCallBackListener)this.d);
      PLVideoObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    AlbumDataManager.getCurrentListChangeLiveData().observe((LifecycleOwner)this, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            if (AlbumPreviewBaseFragment.a(this.a) != null)
              AlbumPreviewBaseFragment.a(this.a).notifyDataSetChanged(); 
          }
        });
    return this.g;
  }
  
  public void onDestroyView() {
    EventCallbackObserver.a().b((EventCallBackListener)this.d);
    PLVideoObserver.a().b(this);
    super.onDestroyView();
  }
  
  public void y() {
    a(true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\fragment\AlbumPreviewBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */