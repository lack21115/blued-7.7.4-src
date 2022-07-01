package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.presenter.LivePhotoDetailPresenter;
import com.blued.android.module.media.selector.fragment.PhotoDetailFragment;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class LivePhotoDetailFragment extends MvpFragment<LivePhotoDetailPresenter> {
  ImageView d;
  
  ViewPager e;
  
  private PicturePagerAdapter f;
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = (ImageView)this.l.findViewById(R.id.close_album_btn);
    this.e = (ViewPager)this.l.findViewById(R.id.pic_view_pager);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveEventBus.get("live_dialog_cancel").post("cancel");
          }
        });
    this.f = new PicturePagerAdapter(this, getChildFragmentManager());
    this.e.setAdapter((PagerAdapter)this.f);
    this.e.setCurrentItem(0);
  }
  
  public int p() {
    return R.layout.fragment_live_photo_detail;
  }
  
  class PicturePagerAdapter extends FragmentStatePagerAdapter {
    public PicturePagerAdapter(LivePhotoDetailFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return (((LivePhotoDetailPresenter)this.a.s()).h == null) ? 0 : ((LivePhotoDetailPresenter)this.a.s()).h.size();
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)PhotoDetailFragment.a(((LivePhotoDetailPresenter)this.a.s()).h.get(param1Int), ((LivePhotoDetailPresenter)this.a.s()).m(), false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LivePhotoDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */