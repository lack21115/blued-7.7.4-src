package com.soft.blued.ui.login_register;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class AdultVerifyFragment_ViewBinding implements Unbinder {
  private AdultVerifyFragment b;
  
  public AdultVerifyFragment_ViewBinding(AdultVerifyFragment paramAdultVerifyFragment, View paramView) {
    this.b = paramAdultVerifyFragment;
    paramAdultVerifyFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramAdultVerifyFragment.flCover = (FrameLayout)Utils.a(paramView, 2131297100, "field 'flCover'", FrameLayout.class);
    paramAdultVerifyFragment.imgCover = (ImageView)Utils.a(paramView, 2131297463, "field 'imgCover'", ImageView.class);
    paramAdultVerifyFragment.imgBtmIcon = (ImageView)Utils.a(paramView, 2131297450, "field 'imgBtmIcon'", ImageView.class);
    paramAdultVerifyFragment.tvUpIdFront = (TextView)Utils.a(paramView, 2131301460, "field 'tvUpIdFront'", TextView.class);
    paramAdultVerifyFragment.tvTitle = (TextView)Utils.a(paramView, 2131301409, "field 'tvTitle'", TextView.class);
    paramAdultVerifyFragment.tvContent = (TextView)Utils.a(paramView, 2131300663, "field 'tvContent'", TextView.class);
    paramAdultVerifyFragment.tvConfirmToSubmit = (TextView)Utils.a(paramView, 2131300657, "field 'tvConfirmToSubmit'", TextView.class);
    paramAdultVerifyFragment.btnSolid = (ShapeTextView)Utils.a(paramView, 2131296607, "field 'btnSolid'", ShapeTextView.class);
    paramAdultVerifyFragment.btnStroke = (ShapeTextView)Utils.a(paramView, 2131296608, "field 'btnStroke'", ShapeTextView.class);
  }
  
  public void unbind() {
    AdultVerifyFragment adultVerifyFragment = this.b;
    if (adultVerifyFragment != null) {
      this.b = null;
      adultVerifyFragment.title = null;
      adultVerifyFragment.flCover = null;
      adultVerifyFragment.imgCover = null;
      adultVerifyFragment.imgBtmIcon = null;
      adultVerifyFragment.tvUpIdFront = null;
      adultVerifyFragment.tvTitle = null;
      adultVerifyFragment.tvContent = null;
      adultVerifyFragment.tvConfirmToSubmit = null;
      adultVerifyFragment.btnSolid = null;
      adultVerifyFragment.btnStroke = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\AdultVerifyFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */