package com.soft.blued.ui.msg;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.ui.discover.observer.SystemNoticeViewModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.msg.model.MessageTabModel;
import com.soft.blued.ui.msg.observer.MessageSetSelectedTab;
import com.soft.blued.ui.msg.presenter.MsgPresenter;
import com.soft.blued.ui.notify.fragment.SystemNoticeFragment;
import com.soft.blued.utils.Logger;
import java.util.List;

public class MessagePageFragment extends MvpFragment<MvpPresenter> implements HomeTabClick.TabClickListener, MessageSetSelectedTab.IMessageSetSelectedTab {
  @BindView(2131296863)
  ImageView cttLeft;
  
  @BindView(2131296867)
  ImageView cttRight;
  
  public List<MessageTabModel> d;
  
  private Context e;
  
  private int f;
  
  @BindView(2131297060)
  QBadgeContainer findBadgeContainer;
  
  private MyAdapter g;
  
  private int h = 0;
  
  private MsgFragment i;
  
  private SystemNoticeFragment j;
  
  @BindView(2131299195)
  CustomViewPager mainMsgViewpager;
  
  private int n = 1;
  
  @BindView(2131301725)
  TabPageIndicatorWithDot vpIndicator;
  
  private void a(boolean paramBoolean, String paramString) {
    if (this.n == 1) {
      MsgFragment msgFragment = this.i;
      if (msgFragment != null) {
        if (paramBoolean) {
          msgFragment.d(paramString);
          return;
        } 
        msgFragment.c(paramString);
        return;
      } 
    } 
    SystemNoticeFragment systemNoticeFragment = this.j;
    if (systemNoticeFragment != null) {
      if (paramBoolean) {
        systemNoticeFragment.d(paramString);
        return;
      } 
      systemNoticeFragment.c(paramString);
    } 
  }
  
  private void b(int paramInt) {
    if (paramInt == 1) {
      this.cttRight.setImageDrawable(BluedSkinUtils.b(this.e, 2131232748));
      return;
    } 
    this.cttRight.setImageDrawable(BluedSkinUtils.b(this.e, 2131232747));
  }
  
  private void l() {
    if (StatusBarHelper.a())
      this.findBadgeContainer.setPadding(0, StatusBarHelper.a((Context)getActivity()), 0, 0); 
    this.vpIndicator.b(2131100728, 2);
    ViewGroup.LayoutParams layoutParams = this.vpIndicator.getLayoutParams();
    int i = DensityUtils.a(this.e, 50.0F);
    ((ViewGroup.MarginLayoutParams)layoutParams).setMargins(i, 0, i, 0);
    this.vpIndicator.setLayoutParams(layoutParams);
    if (!BlueAppLocal.d())
      this.vpIndicator.setTabPaddingLeftRight(DensityUtils.a(this.e, 5.0F)); 
  }
  
  private void m() {
    this.cttLeft.setVisibility(4);
    this.cttRight.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.mainMsgViewpager.getCurrentItem() == 0) {
              LiveEventBus.get("click_right_delete").post(param1View);
              return;
            } 
            LiveEventBus.get("click_right_pop_menu").post(param1View);
          }
        });
  }
  
  private void n() {
    this.g = new MyAdapter(this, getChildFragmentManager());
    this.mainMsgViewpager.setAdapter((PagerAdapter)this.g);
    this.vpIndicator.setViewPager((ViewPager)this.mainMsgViewpager);
    this.mainMsgViewpager.setOffscreenPageLimit(1);
    a(this.n);
    this.vpIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            MessagePageFragment.c(this.a, param1Int);
            MessagePageFragment.d(this.a, param1Int);
            if (this.a.getActivity() != null && this.a.getActivity() instanceof HomeActivity)
              ((HomeActivity)this.a.getActivity()).b(param1Int); 
            if (param1Int == 1)
              for (Fragment fragment : this.a.getChildFragmentManager().getFragments()) {
                if (fragment instanceof MsgFragment)
                  ((MsgPresenter)((MsgFragment)fragment).s()).x(); 
              }  
          }
        });
    this.vpIndicator.setOnTitleClickListener(new TabPageIndicatorWithDot.OnTitleClickListener(this) {
          public void a(int param1Int) {
            if (this.a.getActivity() != null && this.a.getActivity() instanceof HomeActivity)
              ((HomeActivity)this.a.getActivity()).b(param1Int); 
            if (param1Int == 0 && MessagePageFragment.c(this.a) != null)
              MessagePageFragment.c(this.a).d("msg"); 
          }
        });
  }
  
  public void a(int paramInt) {
    if (this.mainMsgViewpager != null && paramInt >= 0) {
      if (this.g.getCount() < paramInt)
        return; 
      this.mainMsgViewpager.setCurrentItem(paramInt);
      b(paramInt);
    } 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = MessageTabModel.getMessageTabs(this.e);
    if (getActivity() != null && getActivity() instanceof HomeActivity)
      this.n = ((HomeActivity)getActivity()).i(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("currentIndex = ");
    stringBuilder.append(this.n);
    Logger.c("MessagePageFragment", new Object[] { stringBuilder.toString() });
    l();
    n();
    m();
    TabPageIndicatorWithDot tabPageIndicatorWithDot = this.vpIndicator;
    if (tabPageIndicatorWithDot != null)
      tabPageIndicatorWithDot.a(1, this.f); 
    if (this.vpIndicator != null && getActivity() instanceof HomeActivity) {
      if (((HomeActivity)getActivity()).d) {
        this.vpIndicator.a(0);
        return;
      } 
      this.vpIndicator.c(0);
    } 
  }
  
  public void c(String paramString) {
    a(false, paramString);
  }
  
  public void d(String paramString) {
    a(true, paramString);
  }
  
  public int k() {
    return this.n;
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    HomeTabClick.a("msg", this);
    this.e = (Context)getActivity();
    MessageSetSelectedTab.a().a(this);
    SystemNoticeViewModel systemNoticeViewModel = (SystemNoticeViewModel)ViewModelProviders.of(getActivity()).get(SystemNoticeViewModel.class);
    systemNoticeViewModel.f.observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            MessagePageFragment.a(this.a, param1Integer.intValue());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("new_system_msg_count = ");
            stringBuilder.append(param1Integer);
            stringBuilder.append("=vpIndicator==");
            stringBuilder.append(this.a.vpIndicator);
            Logger.c("MessagePageFragment", new Object[] { stringBuilder.toString() });
            if (this.a.vpIndicator != null)
              this.a.vpIndicator.a(0, MessagePageFragment.a(this.a)); 
          }
        });
    systemNoticeViewModel.e.observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            MessagePageFragment.b(this.a, param1Integer.intValue());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("new_private_msg_count = ");
            stringBuilder.append(param1Integer);
            Logger.c("MessagePageFragment", new Object[] { stringBuilder.toString() });
            if (this.a.vpIndicator != null)
              this.a.vpIndicator.a(1, MessagePageFragment.b(this.a)); 
          }
        });
    LiveEventBus.get("new_system_msg_read_count", Integer.class).observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("new_system_msg_read_count = ");
            stringBuilder.append(param1Integer);
            Logger.e("MessagePageFragment", new Object[] { stringBuilder.toString() });
            if (this.a.vpIndicator != null) {
              MessagePageFragment messagePageFragment = this.a;
              MessagePageFragment.a(messagePageFragment, MessagePageFragment.a(messagePageFragment) - param1Integer.intValue());
              if (MessagePageFragment.a(this.a) <= 0)
                this.a.vpIndicator.c(0); 
            } 
          }
        });
  }
  
  public void onDestroy() {
    super.onDestroy();
    Logger.e("MessagePageFragment", new Object[] { "onDestroy ... " });
    MessageSetSelectedTab.a().b(this);
    HomeTabClick.b("msg", this);
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    Logger.e("MessagePageFragment", new Object[] { "onDestroyView ... " });
  }
  
  public int p() {
    return 2131493221;
  }
  
  public boolean z() {
    return true;
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(MessagePageFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return this.a.d.size();
    }
    
    public Fragment getItem(int param1Int) {
      if (param1Int == 1) {
        MessagePageFragment messagePageFragment1 = this.a;
        MessagePageFragment.a(messagePageFragment1, (MsgFragment)((MessageTabModel)messagePageFragment1.d.get(param1Int)).getFragment());
        return (Fragment)MessagePageFragment.d(this.a);
      } 
      MessagePageFragment messagePageFragment = this.a;
      MessagePageFragment.a(messagePageFragment, (SystemNoticeFragment)((MessageTabModel)messagePageFragment.d.get(param1Int)).getFragment());
      return (Fragment)MessagePageFragment.c(this.a);
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return ((MessageTabModel)this.a.d.get(param1Int)).title;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MessagePageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */