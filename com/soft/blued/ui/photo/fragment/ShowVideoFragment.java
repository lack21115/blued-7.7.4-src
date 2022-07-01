package com.soft.blued.ui.photo.fragment;

import android.content.Context;
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
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.module.media.selector.utils.Tools;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.das.message.MessageProtos;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.msg.pop.BottomMenuPop;
import java.util.ArrayList;

public class ShowVideoFragment extends BasePhotoFragment implements View.OnClickListener {
  private Context f;
  
  private View g;
  
  private ImagePagerAdapter h;
  
  private HackyViewPager i;
  
  private ImageView j;
  
  private int k;
  
  private String l;
  
  private View m;
  
  private TextView n;
  
  private String o;
  
  private String p;
  
  private Boolean q;
  
  private int r;
  
  private int s;
  
  private long t;
  
  private String u = "";
  
  private BottomMenuPop v;
  
  private void a(String paramString) {
    ArrayList<BottomMenuPop.MenuItemInfo> arrayList = new ArrayList();
    BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
    menuItemInfo.a = getResources().getString(2131758642);
    menuItemInfo.b = 2131100716;
    menuItemInfo.c = new View.OnClickListener(this, paramString) {
        public void onClick(View param1View) {
          if (ShowVideoFragment.a(this.b) != null)
            ShowVideoFragment.a(this.b).p(); 
          PermissionHelper.e(new PermissionCallbacks(this) {
                public void a(String[] param2ArrayOfString) {}
                
                public void aa_() {
                  Tools.d(this.a.a);
                  EventTrackMessage.a(MessageProtos.Event.MSG_SAVE_VIDEO_CLICK, MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ShowVideoFragment.b(this.a.b));
                }
              });
        }
      };
    arrayList.add(menuItemInfo);
    this.v = new BottomMenuPop(getContext());
    this.v.b = arrayList;
    (new XPopup.Builder(getContext())).a((BasePopupView)this.v).h();
  }
  
  private void n() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.l = getArguments().getString("key_feed_id");
      this.k = getArguments().getInt("show_photo");
      this.r = getArguments().getInt("video_width");
      this.s = getArguments().getInt("video_height");
      this.p = bundle.getString("video_preview_url");
      this.o = bundle.getString("video_url");
      this.t = bundle.getLong("video_size");
      this.q = Boolean.valueOf(bundle.getBoolean("support_save"));
      this.u = bundle.getString("target_uid");
    } 
  }
  
  private void o() {
    this.i = (HackyViewPager)this.g.findViewById(2131299443);
    this.j = (ImageView)this.g.findViewById(2131296787);
    this.j.setOnClickListener(this);
    this.m = this.g.findViewById(2131300702);
    this.m.setOnClickListener(this);
    this.n = (TextView)this.g.findViewById(2131301182);
    this.h = new ImagePagerAdapter(this, getChildFragmentManager());
    this.i.setAdapter((PagerAdapter)this.h);
    this.j.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.l();
          }
        });
    this.j.setVisibility(0);
    this.m.setVisibility(8);
    this.n.setVisibility(8);
  }
  
  private void p() {}
  
  public void a(View paramView) {
    super.a(paramView);
  }
  
  public void a(Object... paramVarArgs) {
    super.a(paramVarArgs);
    if (!this.q.booleanValue())
      return; 
    if (paramVarArgs != null && paramVarArgs.length > 0)
      try {
        return;
      } finally {
        paramVarArgs = null;
      }  
  }
  
  public void aS_() {
    super.aS_();
    if (!this.d)
      b((View)this.j, (View)this.n, false); 
  }
  
  public void b(View paramView) {
    super.b(paramView);
    l();
  }
  
  public void f_(int paramInt) {
    super.f_(paramInt);
    this.i.getBackground().setAlpha(paramInt);
    if (this.d)
      a((View)this.j, (View)this.n, false); 
  }
  
  public boolean j() {
    return false;
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296787)
      return; 
    k();
  }
  
  public void onCreate(Bundle paramBundle) {
    getActivity().getWindow().setFlags(128, 128);
    super.onCreate(paramBundle);
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
    return this.g;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  class ImagePagerAdapter extends FragmentStatePagerAdapter {
    public ImagePagerAdapter(ShowVideoFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return 1;
    }
    
    public Fragment getItem(int param1Int) {
      VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
      videoPlayConfig.b = ShowVideoFragment.c(this.a);
      videoPlayConfig.a = ShowVideoFragment.d(this.a);
      videoPlayConfig.c = ShowVideoFragment.e(this.a);
      return (Fragment)BizVideoDetailFragment.a(videoPlayConfig, ShowVideoFragment.f(this.a));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\fragment\ShowVideoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */