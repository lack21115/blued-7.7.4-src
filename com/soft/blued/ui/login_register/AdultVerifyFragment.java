package com.soft.blued.ui.login_register;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.constant.CameraContents;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.model.AdultVerifyModel;
import com.soft.blued.ui.photo.camera.fragment.CameraFragment;
import com.soft.blued.user.AVConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.third.BaiduFaceDetectUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AdultVerifyFragment extends MvpFragment {
  @BindView(2131296607)
  ShapeTextView btnSolid;
  
  @BindView(2131296608)
  ShapeTextView btnStroke;
  
  public Context d;
  
  public int e = 0;
  
  private String f = "";
  
  @BindView(2131297100)
  FrameLayout flCover;
  
  private int g = 0;
  
  private int h = 0;
  
  private String i = "";
  
  @BindView(2131297450)
  ImageView imgBtmIcon;
  
  @BindView(2131297463)
  ImageView imgCover;
  
  private String j = "";
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  @BindView(2131300657)
  TextView tvConfirmToSubmit;
  
  @BindView(2131300663)
  TextView tvContent;
  
  @BindView(2131301409)
  TextView tvTitle;
  
  @BindView(2131301460)
  TextView tvUpIdFront;
  
  public static void a(Context paramContext) {
    a(paramContext, AV_START_PAGE.b);
  }
  
  public static void a(Context paramContext, int paramInt, AdultVerifyModel paramAdultVerifyModel, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stage:");
    stringBuilder.append(paramInt);
    stringBuilder.append(",model:");
    stringBuilder.append(AppInfo.f().toJson(paramAdultVerifyModel));
    stringBuilder.append(",filepath:");
    stringBuilder.append(paramString);
    Logger.a("AVF", stringBuilder.toString());
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_STAGE", paramInt);
    bundle.putSerializable("KEY_AV_MODEL", (Serializable)paramAdultVerifyModel);
    bundle.putString("KEY_FILE_PATH", paramString);
    TerminalActivity.d(paramContext, AdultVerifyFragment.class, bundle);
  }
  
  public static void a(Context paramContext, AV_START_PAGE paramAV_START_PAGE) {
    if (paramContext == null)
      return; 
    PermissionHelper.b(new PermissionCallbacks(paramAV_START_PAGE, paramContext) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_STAGE", 0);
            bundle.putSerializable("KEY_START_PAGE", this.a);
            TerminalActivity.d(this.b, AdultVerifyFragment.class, bundle);
          }
        });
  }
  
  public void E() {
    InstantLog.a("av_idcard_start_show");
    LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)this.flCover.getLayoutParams();
    layoutParams1.leftMargin = DensityUtils.a(this.d, 30.0F);
    layoutParams1.rightMargin = DensityUtils.a(this.d, 30.0F);
    layoutParams1.topMargin = DensityUtils.a(this.d, 10.0F);
    this.flCover.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.title.setLeftImg(2131232743);
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            CommonAlertDialog.a((Context)this.a.getActivity(), null, this.a.getResources().getString(2131755377), this.a.getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    UserRelationshipUtils.a("", new int[0]);
                  }
                }null, null, null);
          }
        });
    this.tvUpIdFront.setVisibility(0);
    this.title.setCenterText(2131755398);
    this.imgCover.setImageResource(2131231361);
    this.imgCover.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.btnSolid.callOnClick();
          }
        });
    this.imgBtmIcon.setVisibility(0);
    this.imgBtmIcon.setImageResource(2131232769);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.imgBtmIcon.getLayoutParams();
    layoutParams.gravity = 17;
    this.imgBtmIcon.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.tvTitle.setVisibility(0);
    this.tvTitle.setText(2131755381);
    this.tvTitle.setTextColor(this.d.getResources().getColor(2131100541));
    this.tvTitle.setTextSize(14.0F);
    this.tvContent.setVisibility(8);
    this.tvConfirmToSubmit.setVisibility(8);
    this.btnStroke.setVisibility(8);
    this.btnSolid.setText(2131755387);
    this.btnSolid.setTextColor(this.d.getResources().getColor(2131100528));
    this.btnSolid.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            CameraFragment.a(this.a, 2, 102);
          }
        });
  }
  
  public boolean V_() {
    this.title.getLeftImg().callOnClick();
    return true;
  }
  
  public void a(Bundle paramBundle) {
    BaiduFaceDetectUtils.a(AppInfo.d());
    this.d = (Context)getActivity();
    super.a(paramBundle);
    k();
  }
  
  public void k() {
    Logger.a("AVF", "init");
    if (getArguments() != null) {
      this.e = getArguments().getInt("KEY_STAGE");
      this.f = getArguments().getString("KEY_FILE_PATH");
      if (this.e == 0)
        CameraContents.e = (AV_START_PAGE)getArguments().getSerializable("KEY_START_PAGE"); 
      AdultVerifyModel adultVerifyModel = (AdultVerifyModel)getArguments().getSerializable("KEY_AV_MODEL");
      if (adultVerifyModel != null) {
        this.h = adultVerifyModel.times;
        this.g = adultVerifyModel.is_success;
        this.i = adultVerifyModel.tip;
        this.j = adultVerifyModel.tip_title;
      } 
    } 
    l();
  }
  
  public void l() {
    Logger.a("AVF", "initView");
    ShapeHelper.b((ShapeHelper.ShapeView)this.btnSolid, 2131100527, 2131100527, 2131100615);
    int i = this.e;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          FaceDetectFragment.a(this, 101);
          return;
        } 
        n();
        return;
      } 
      E();
      return;
    } 
    m();
  }
  
  public void m() {
    Logger.a("AVF", "setAvatarResultView");
    InstantLog.a("av_face_result_show");
    EventTrackSettings.a(SettingsProtos.Event.AV_FACE_RESULT_SHOW);
    this.title.setCenterText((AVConfig.a().b()).face_title);
    this.title.setLeftImg(2131232743);
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            CommonAlertDialog.a((Context)this.a.getActivity(), null, this.a.getResources().getString(2131755377), this.a.getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    UserRelationshipUtils.a("", new int[0]);
                  }
                }null, null, null);
          }
        });
    LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)this.flCover.getLayoutParams();
    layoutParams1.leftMargin = DensityUtils.a(this.d, 30.0F);
    layoutParams1.rightMargin = DensityUtils.a(this.d, 30.0F);
    layoutParams1.topMargin = DensityUtils.a(this.d, 10.0F);
    this.flCover.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.imgCover.getLayoutParams();
    layoutParams.height = AppInfo.l - DensityUtils.a(this.d, 60.0F);
    this.imgCover.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ImageLoader.d((IRequestHost)w_(), this.f).a(2131231194).a(this.imgCover);
    this.tvTitle.setVisibility(0);
    this.imgBtmIcon.setVisibility(0);
    int i = this.g;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        UserInfo.a().i().setNeedAdultVerify(1);
        this.imgBtmIcon.setImageResource(2131232387);
        this.tvTitle.setText(this.i);
        this.tvContent.setVisibility(8);
        this.tvConfirmToSubmit.setVisibility(8);
        this.btnStroke.setVisibility(8);
        this.btnSolid.setText(2131755398);
        this.btnSolid.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                AdultVerifyFragment.a(this.a.d, 2, (AdultVerifyModel)null, "");
              }
            });
        return;
      } 
      UserInfo.a().i().setNeedAdultVerify(0);
      UserRelationshipUtils.b();
      if ((AVConfig.a()).a) {
        RegisterV1FinishInfoFragment.a(this.d);
        return;
      } 
      getActivity().setResult(-1);
      Bundle bundle = new Bundle();
      bundle.putString("from_tag_page", "from_tag_register");
      HomeArgumentHelper.a((Context)getActivity(), null, bundle);
      return;
    } 
    UserInfo.a().i().setNeedAdultVerify(1);
    this.imgBtmIcon.setImageResource(2131232387);
    this.tvTitle.setText(this.j);
    this.tvContent.setTextColor(this.d.getResources().getColor(2131100541));
    this.tvContent.setText(this.i);
    this.tvConfirmToSubmit.setVisibility(0);
    this.btnStroke.setVisibility(8);
    if (this.h <= 0) {
      this.btnSolid.setText(this.d.getResources().getString(2131755396));
      this.btnSolid.setEnabled(false);
      return;
    } 
    String str = this.d.getResources().getString(2131755395);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.h);
    stringBuilder.append("");
    str = String.format(str, new Object[] { stringBuilder.toString() });
    this.btnSolid.setText(str);
    this.btnSolid.setEnabled(true);
    this.btnSolid.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FaceDetectFragment.a(this.a, 101);
          }
        });
  }
  
  public void n() {
    InstantLog.a("av_idcard_result_show");
    EventTrackSettings.a(SettingsProtos.Event.AV_IDCARD_RESULT_SHOW);
    this.title.setCenterText(2131755386);
    this.title.setLeftImg(2131232743);
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            CommonAlertDialog.a((Context)this.a.getActivity(), null, this.a.getResources().getString(2131755377), this.a.getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    UserRelationshipUtils.a("", new int[0]);
                  }
                }null, null, null);
          }
        });
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.flCover.getLayoutParams();
    layoutParams.leftMargin = DensityUtils.a(this.d, 30.0F);
    layoutParams.rightMargin = DensityUtils.a(this.d, 30.0F);
    layoutParams.topMargin = DensityUtils.a(this.d, 10.0F);
    this.flCover.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    FrameLayout.LayoutParams layoutParams1 = (FrameLayout.LayoutParams)this.imgCover.getLayoutParams();
    layoutParams1.height = AppInfo.l - DensityUtils.a(this.d, 60.0F);
    this.imgCover.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    ImageLoader.d((IRequestHost)w_(), this.f).a(2131231361).a(this.imgCover);
    this.tvTitle.setVisibility(0);
    this.imgBtmIcon.setVisibility(0);
    int i = this.g;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        UserInfo.a().i().setNeedAdultVerify(1);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams)this.flCover.getLayoutParams();
        layoutParams3.leftMargin = DensityUtils.a(this.d, 0.0F);
        layoutParams3.rightMargin = DensityUtils.a(this.d, 0.0F);
        layoutParams3.topMargin = DensityUtils.a(this.d, 0.0F);
        this.flCover.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.imgCover.setImageResource(2131231362);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams)this.imgCover.getLayoutParams();
        layoutParams2.height = -2;
        this.imgCover.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
        this.imgBtmIcon.setImageResource(2131232387);
        this.tvTitle.setText(this.i);
        this.tvContent.setVisibility(8);
        this.tvConfirmToSubmit.setVisibility(8);
        this.btnSolid.setVisibility(8);
        this.btnStroke.setVisibility(8);
        return;
      } 
      UserInfo.a().i().setNeedAdultVerify(0);
      UserRelationshipUtils.b();
      this.title.c();
      this.imgBtmIcon.setImageResource(2131232388);
      this.tvTitle.setText(2131755388);
      this.tvContent.setTextColor(this.d.getResources().getColor(2131100541));
      this.tvContent.setText(this.i);
      this.tvConfirmToSubmit.setVisibility(8);
      this.btnSolid.setText(2131756100);
      this.btnStroke.setVisibility(8);
      this.btnSolid.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if ((AVConfig.a()).a) {
                RegisterV1FinishInfoFragment.a(this.a.d);
                return;
              } 
              this.a.getActivity().setResult(-1);
              Bundle bundle = new Bundle();
              bundle.putString("from_tag_page", "from_tag_register");
              HomeArgumentHelper.a((Context)this.a.getActivity(), null, bundle);
            }
          });
      return;
    } 
    UserInfo.a().i().setNeedAdultVerify(1);
    this.imgBtmIcon.setImageResource(2131232387);
    this.tvTitle.setText(2131755393);
    this.tvContent.setText(this.i);
    this.tvContent.setTextColor(this.d.getResources().getColor(2131100541));
    this.tvConfirmToSubmit.setVisibility(0);
    this.btnStroke.setVisibility(8);
    if (this.h <= 0) {
      this.btnSolid.setText(this.d.getResources().getString(2131755396));
      this.btnSolid.setEnabled(false);
      return;
    } 
    String str = this.d.getResources().getString(2131755395);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.h);
    stringBuilder.append("");
    str = String.format(str, new Object[] { stringBuilder.toString() });
    this.btnSolid.setText(str);
    this.btnSolid.setEnabled(true);
    this.btnSolid.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            CameraFragment.a(this.a, 2, 102);
          }
        });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1 && paramIntent != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("requestCode:");
      stringBuilder.append(paramInt1);
      Logger.a("AVF", stringBuilder.toString());
      AdultVerifyModel adultVerifyModel = (AdultVerifyModel)paramIntent.getSerializableExtra("KEY_AV_MODEL");
      String str = paramIntent.getStringExtra("KEY_FILE_PATH");
      if (paramInt1 != 101) {
        if (paramInt1 != 102)
          return; 
        a(this.d, 3, adultVerifyModel, str);
        return;
      } 
      Logger.a("AVF", "AVATAR_VERIFY_RESULT show");
      a(this.d, 1, adultVerifyModel, str);
      return;
    } 
    if (paramInt2 == 0)
      Logger.a("AVF", "resultCode == Activity.RESULT_CANCELED"); 
  }
  
  public int p() {
    return 2131492919;
  }
  
  public enum AV_START_PAGE {
    a, b;
  }
  
  public static interface VERIFY_RESULT {}
  
  public static interface VERIFY_STAGE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VerifyStage {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\AdultVerifyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */