package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.soft.blued.ui.user.model.WatchWordModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import java.io.Serializable;

public class CommandFragment extends BaseFragment {
  private Activity d;
  
  private View e;
  
  private View f;
  
  private ImageView g;
  
  private WatchWordModel h;
  
  public static void a() {
    ClipboardManager clipboardManager = (ClipboardManager)AppInfo.d().getSystemService("clipboard");
    if (clipboardManager != null)
      try {
        clipboardManager.setPrimaryClip(clipboardManager.getPrimaryClip());
        clipboardManager.setText("");
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static void a(Context paramContext, WatchWordModel paramWatchWordModel) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("model", (Serializable)paramWatchWordModel);
    TerminalActivity.a(bundle);
    TransparentActivity.b(paramContext, CommandFragment.class, bundle);
  }
  
  private void k() {
    Bundle bundle = getArguments();
    if (bundle != null)
      this.h = (WatchWordModel)bundle.getSerializable("model"); 
    if (this.h == null)
      m(); 
  }
  
  private void l() {
    if (this.h == null) {
      m();
      return;
    } 
    this.f = this.e.findViewById(2131297457);
    this.g = (ImageView)this.e.findViewById(2131297458);
    ImageLoader.a((IRequestHost)w_(), this.h.image).a(this.g);
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            CommandFragment.a();
            WebViewShowInfoFragment.show((Context)CommandFragment.a(this.a), (CommandFragment.b(this.a)).url, -1);
            CommandFragment.c(this.a);
          }
        });
    this.f.setOnClickListener(new -$$Lambda$CommandFragment$NQjSiLZIm_fWSHoASOe2dzWeAZ8(this));
    this.g.postDelayed(new -$$Lambda$CommandFragment$bYiVxZs-5BrpCKKpxqtpzhIIgOo(this), 100L);
  }
  
  private void m() {
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
    k();
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493106, paramViewGroup, false);
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\CommandFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */