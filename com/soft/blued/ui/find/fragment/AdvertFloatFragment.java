package com.soft.blued.ui.find.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.soft.blued.constant.ADConstants;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.find.model.AdvertFloatModel;
import com.soft.blued.ui.user.utils.ADClosePopOptionsUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import java.io.Serializable;

public class AdvertFloatFragment extends BaseFragment {
  private Activity d;
  
  private View e;
  
  private View f;
  
  private ImageView g;
  
  private AdvertFloatModel h;
  
  private BluedADConstraintLayout i;
  
  private ADConstants.AD_POSITION j;
  
  private void a() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.h = (AdvertFloatModel)bundle.getSerializable("model");
      this.j = (ADConstants.AD_POSITION)bundle.getSerializable("KEY_AD_POSITION");
    } 
    if (this.h == null)
      l(); 
  }
  
  public static void a(Context paramContext, AdvertFloatModel paramAdvertFloatModel, ADConstants.AD_POSITION paramAD_POSITION) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("model", (Serializable)paramAdvertFloatModel);
    bundle.putSerializable("KEY_AD_POSITION", (Serializable)paramAD_POSITION);
    TerminalActivity.a(bundle);
    TransparentActivity.b(paramContext, AdvertFloatFragment.class, bundle);
  }
  
  private void k() {
    if (this.h == null) {
      l();
      return;
    } 
    this.i = (BluedADConstraintLayout)this.e.findViewById(2131296537);
    this.i.a((BluedADExtra)this.h, new -$$Lambda$AdvertFloatFragment$KfZ1GnDkByCVVPpRBA0fBmcLd0U(this));
    this.f = this.e.findViewById(2131297457);
    this.g = (ImageView)this.e.findViewById(2131297423);
    ImageLoader.a((IRequestHost)w_(), this.h.advert_pic).a(this.g);
    this.f.setOnClickListener(new -$$Lambda$AdvertFloatFragment$nQbj0YiutdxXk0wIppqVjH6mJsA(this));
    this.g.postDelayed(new -$$Lambda$AdvertFloatFragment$o-b3v2ZLeWtSPyY4GT0S7OKKct8(this), 100L);
  }
  
  private void l() {
    getActivity().finish();
    ActivityChangeAnimationUtils.i((Activity)getActivity());
  }
  
  public boolean V_() {
    this.f.performClick();
    return true;
  }
  
  public boolean j() {
    return false;
  }
  
  public void onCreate(Bundle paramBundle) {
    this.d = (Activity)getActivity();
    ActivityChangeAnimationUtils.f((Activity)getActivity());
    a();
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493073, paramViewGroup, false);
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\AdvertFloatFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */