package com.soft.blued.ui.photo.camera.fragment;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.media.selector.fragment.MediaBaseFragment;
import com.blued.android.module.media.selector.present.MediaBasePresent;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.ui.login_register.AdultVerifyFragment;
import com.soft.blued.ui.photo.camera.contract.ICameraPreView;
import com.soft.blued.ui.photo.camera.model.CameraModel;
import com.soft.blued.ui.photo.camera.presenter.CameraPreViewPresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.io.Serializable;

public class CameraPreViewFragment extends MediaBaseFragment<ICameraPreView, CameraPreViewPresenter> implements ICameraPreView {
  private View d;
  
  private RelativeLayout g;
  
  private ImageView h;
  
  private View i;
  
  private ShapeTextView j;
  
  private CommonTopTitleNoTrans k;
  
  public static void a(Object paramObject, CameraModel paramCameraModel, int paramInt) {
    Context context;
    if (paramCameraModel == null)
      return; 
    boolean bool = paramObject instanceof Fragment;
    if (bool) {
      context = ((Fragment)paramObject).getContext();
    } else {
      context = (Context)paramObject;
    } 
    if (context == null)
      return; 
    Bundle bundle = new Bundle();
    bundle.putSerializable("camera_model_key", (Serializable)paramCameraModel);
    if (paramObject instanceof Activity) {
      TerminalActivity.a((Context)paramObject, CameraPreViewFragment.class, bundle, paramInt);
      return;
    } 
    if (bool) {
      TerminalActivity.a((Fragment)paramObject, CameraPreViewFragment.class, bundle, paramInt);
      return;
    } 
    TerminalActivity.d((Context)paramObject, CameraPreViewFragment.class, bundle);
  }
  
  private void l() {
    ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
    int i = AppInfo.l - DensityUtils.a(AppInfo.d(), 60.0F);
    int j = (int)(i / 1.0F);
    layoutParams.width = i;
    layoutParams.height = j;
    this.g.setLayoutParams(layoutParams);
  }
  
  public void B() {}
  
  public boolean V_() {
    getActivity().setResult(0);
    getActivity().finish();
    return true;
  }
  
  public void a(int paramInt) {}
  
  public void a(Bitmap paramBitmap) {
    b(new Runnable(this, paramBitmap) {
          public void run() {
            if (CameraPreViewFragment.f(this.b) != null && this.a != null)
              CameraPreViewFragment.f(this.b).setImageBitmap(this.a); 
          }
        });
  }
  
  public void a(String paramString) {
    this.k = (CommonTopTitleNoTrans)this.d.findViewById(2131300300);
    this.k.a();
    this.k.c();
    this.k.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            CommonAlertDialog.a((Context)this.a.getActivity(), null, this.a.getResources().getString(2131755377), this.a.getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    UserRelationshipUtils.a("", new int[0]);
                  }
                }null, null, null);
          }
        });
    this.k.setCenterText(paramString);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(Bundle paramBundle) {
    return false;
  }
  
  public void aY_() {
    this.k.d();
  }
  
  public IRequestHost b() {
    return (IRequestHost)w_();
  }
  
  public void b(Bitmap paramBitmap) {
    ImageView imageView = this.h;
    if (imageView != null && paramBitmap != null)
      imageView.setImageBitmap(paramBitmap); 
  }
  
  public void b(Bundle paramBundle) {
    this.g = (RelativeLayout)this.d.findViewById(2131296627);
    this.h = (ImageView)this.d.findViewById(2131296626);
    this.i = this.d.findViewById(2131297465);
    this.j = (ShapeTextView)this.d.findViewById(2131300679);
    l();
    e();
  }
  
  public void b(Runnable paramRunnable) {
    a(paramRunnable);
  }
  
  public void b(String paramString) {
    this.j.setText(paramString);
  }
  
  public void c(String paramString) {
    String str1 = this.f.getResources().getString(2131756377);
    String str2 = this.f.getResources().getString(2131755379);
    String str3 = this.f.getResources().getString(2131755376);
    CommonAlertDialog.a(this.f, str1, paramString, str2, new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            AdultVerifyFragment.a(CameraPreViewFragment.d(this.a));
          }
        },  str3, new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            String str = BluedHttpUrl.a(3);
            WebViewShowInfoFragment.a(CameraPreViewFragment.e(this.a), str, this.a.getResources().getString(2131756120), 16);
          }
        }null);
  }
  
  public void d() {
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { -this.i.getHeight(), DensityUtils.a(this.f, 315.0F) });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, layoutParams) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            this.a.topMargin = i;
            CameraPreViewFragment.a(this.b).setLayoutParams((ViewGroup.LayoutParams)this.a);
          }
        });
    valueAnimator.addListener(new Animator.AnimatorListener(this) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {
            ((CameraPreViewPresenter)CameraPreViewFragment.c(this.a)).c();
          }
          
          public void onAnimationRepeat(Animator param1Animator) {}
          
          public void onAnimationStart(Animator param1Animator) {
            CameraPreViewFragment.b(this.a).setVisibility(0);
            CameraPreViewFragment.a(this.a).setVisibility(0);
          }
        });
    valueAnimator.setDuration(2000L);
    valueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    valueAnimator.start();
  }
  
  public void e() {
    this.j.setVisibility(8);
    this.i.setVisibility(8);
  }
  
  protected CameraPreViewPresenter k() {
    return new CameraPreViewPresenter();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131492934, paramViewGroup, false);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    return this.d;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    ((CameraPreViewPresenter)this.e).a();
  }
  
  public void y() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\camera\fragment\CameraPreViewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */