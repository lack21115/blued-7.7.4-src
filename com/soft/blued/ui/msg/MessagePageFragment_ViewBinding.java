package com.soft.blued.ui.msg;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;

public class MessagePageFragment_ViewBinding implements Unbinder {
  private MessagePageFragment b;
  
  public MessagePageFragment_ViewBinding(MessagePageFragment paramMessagePageFragment, View paramView) {
    this.b = paramMessagePageFragment;
    paramMessagePageFragment.vpIndicator = (TabPageIndicatorWithDot)Utils.a(paramView, 2131301725, "field 'vpIndicator'", TabPageIndicatorWithDot.class);
    paramMessagePageFragment.cttLeft = (ImageView)Utils.a(paramView, 2131296863, "field 'cttLeft'", ImageView.class);
    paramMessagePageFragment.cttRight = (ImageView)Utils.a(paramView, 2131296867, "field 'cttRight'", ImageView.class);
    paramMessagePageFragment.mainMsgViewpager = (CustomViewPager)Utils.a(paramView, 2131299195, "field 'mainMsgViewpager'", CustomViewPager.class);
    paramMessagePageFragment.findBadgeContainer = (QBadgeContainer)Utils.a(paramView, 2131297060, "field 'findBadgeContainer'", QBadgeContainer.class);
  }
  
  public void unbind() {
    MessagePageFragment messagePageFragment = this.b;
    if (messagePageFragment != null) {
      this.b = null;
      messagePageFragment.vpIndicator = null;
      messagePageFragment.cttLeft = null;
      messagePageFragment.cttRight = null;
      messagePageFragment.mainMsgViewpager = null;
      messagePageFragment.findBadgeContainer = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MessagePageFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */