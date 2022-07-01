package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.share_custom.Model.ShareEntity;
import com.soft.blued.ui.user.model.VerifyStatus;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.io.File;

public class ShowVerifyFragment extends BaseFragment implements View.OnClickListener {
  private Context d;
  
  private View e;
  
  private String f = "";
  
  private String g = "";
  
  private String h = "";
  
  private boolean i = false;
  
  private String j = "";
  
  private boolean k;
  
  private TextView l;
  
  private TextView m;
  
  private TextView n;
  
  private TextView o;
  
  private ImageView p;
  
  private LinearLayout q;
  
  private LinearLayout r;
  
  private ScrollView s;
  
  private Dialog t;
  
  private RelativeLayout u;
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("USER_NAME", paramString1);
    bundle.putSerializable("user_avatar", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString3);
    stringBuilder.append("");
    bundle.putSerializable("user_verify_date", stringBuilder.toString());
    bundle.putSerializable("UID", paramString4);
    bundle.putBoolean("request_other_flag", paramBoolean);
    TerminalActivity.d(paramContext, ShowVerifyFragment.class, bundle);
  }
  
  private void k() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131758372));
    commonTopTitleNoTrans.setRightImgDrawable(BluedSkinUtils.b(this.d, 2131232753));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setRightClickListener(this);
    commonTopTitleNoTrans.setCenterTextColor(2131100838);
  }
  
  private void l() {
    if (StringUtils.e(this.h) && !StringUtils.e(this.j))
      a(); 
    if (this.k)
      o(); 
  }
  
  private void m() {
    this.t = DialogUtils.a((Context)getActivity());
    this.l = (TextView)this.e.findViewById(2131301088);
    this.l.setText(this.f);
    this.m = (TextView)this.e.findViewById(2131301484);
    n();
    this.u = (RelativeLayout)this.e.findViewById(2131297110);
    this.p = (ImageView)this.e.findViewById(2131297362);
    ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(0, this.g)).a(2131234356).c().a(this.p);
    this.q = (LinearLayout)this.e.findViewById(2131298878);
    this.s = (ScrollView)this.e.findViewById(2131299836);
    this.n = (TextView)this.e.findViewById(2131301354);
    this.n.setOnClickListener(this);
    this.r = (LinearLayout)this.e.findViewById(2131298728);
    this.o = (TextView)this.e.findViewById(2131301485);
    String str = this.d.getResources().getString(2131758456);
    this.o.setText(str);
  }
  
  private void n() {
    if (StringUtils.e(this.h)) {
      this.m.setVisibility(8);
      return;
    } 
    this.m.setVisibility(0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getResources().getString(2131759200));
    stringBuilder.append(this.h);
    stringBuilder.append(getResources().getString(2131759201));
    String str = stringBuilder.toString();
    this.m.setText(str);
  }
  
  private void o() {
    GroupHttpUtils.k((Context)getActivity(), new BluedUIHttpResponse<BluedEntityA<VerifyStatus>>(this) {
          protected BluedEntityA<VerifyStatus> a(String param1String) {
            return (BluedEntityA<VerifyStatus>)super.parseData(param1String);
          }
          
          public void a(BluedEntityA<VerifyStatus> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.hasData()) {
                  ShowVerifyFragment.a(this.a, "1".equals(((VerifyStatus)param1BluedEntityA.data.get(0)).has_audited));
                  if (ShowVerifyFragment.e(this.a)) {
                    ShowVerifyFragment.f(this.a).setVisibility(8);
                    ShowVerifyFragment.g(this.a).setVisibility(8);
                    return;
                  } 
                  ShowVerifyFragment.f(this.a).setVisibility(0);
                  ShowVerifyFragment.g(this.a).setVisibility(0);
                  return;
                } 
                ShowVerifyFragment.f(this.a).setVisibility(0);
                ShowVerifyFragment.g(this.a).setVisibility(0);
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              }  
            ShowVerifyFragment.f(this.a).setVisibility(0);
            ShowVerifyFragment.g(this.a).setVisibility(0);
          }
        }UserInfo.a().i().getUid(), (IRequestHost)w_());
  }
  
  public void a() {
    if (!StringUtils.e(this.j))
      GroupHttpUtils.k((Context)getActivity(), new BluedUIHttpResponse<BluedEntityA<VerifyStatus>>(this) {
            protected BluedEntityA<VerifyStatus> a(String param1String) {
              return (BluedEntityA<VerifyStatus>)super.parseData(param1String);
            }
            
            public void a(BluedEntityA<VerifyStatus> param1BluedEntityA) {
              if (param1BluedEntityA != null)
                try {
                  if (param1BluedEntityA.hasData()) {
                    ShowVerifyFragment.a(this.a, TimeAndDateUtils.a(TimeAndDateUtils.b(((VerifyStatus)param1BluedEntityA.data.get(0)).verified_time)));
                    ShowVerifyFragment.d(this.a);
                    return;
                  } 
                  AppMethods.d(2131756082);
                  return;
                } catch (Exception exception) {
                  exception.printStackTrace();
                  AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                  return;
                }  
              AppMethods.d(2131756082);
            }
            
            public void onUIFinish() {
              DialogUtils.b(ShowVerifyFragment.c(this.a));
            }
            
            public void onUIStart() {
              DialogUtils.a(ShowVerifyFragment.c(this.a));
            }
          }this.j, (IRequestHost)w_()); 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867) {
        if (i != 2131301354)
          return; 
        if (StringUtils.e(UserInfo.a().i().getAvatar())) {
          CommonAlertDialog.a((Context)getActivity(), null, getResources().getString(2131758199), getResources().getString(2131759123), new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                  ModifyUserInfoFragment.a(ShowVerifyFragment.a(this.a), true);
                }
              }null, null, null);
          return;
        } 
        PersonalVerifyFragment.a((Context)getActivity());
        return;
      } 
      BluedLoginResult bluedLoginResult = UserInfo.a().i();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(bluedLoginResult.getAge());
      stringBuilder1.append(getResources().getString(2131755267));
      stringBuilder1.append("/");
      stringBuilder1.append(StringUtils.a(bluedLoginResult.getHeight(), BlueAppLocal.c(), false));
      stringBuilder1.append("/");
      stringBuilder1.append(StringUtils.b(bluedLoginResult.getWeight(), BlueAppLocal.c(), false));
      stringBuilder1.append("/");
      stringBuilder1.append(UserRelationshipUtils.c(this.d, bluedLoginResult.getRole()));
      String str2 = stringBuilder1.toString();
      String str1 = BluedHttpUrl.a(this.j);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(getResources().getString(2131758759));
      stringBuilder2.append(this.f);
      stringBuilder2.append(getResources().getString(2131758760));
      String str3 = stringBuilder2.toString();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(AreaUtils.a(UserInfo.a().i().getCity_settled(), BlueAppLocal.c()));
      stringBuilder3.append("\n");
      stringBuilder3.append(str2);
      str2 = stringBuilder3.toString();
      ImageFileLoader.a((IRequestHost)w_()).b(UserInfo.a().i().getAvatar()).a(new ImageFileLoader.OnLoadFileListener(this, bluedLoginResult, str1, str3, str2, str2) {
            public void onUIFinish(File param1File, Exception param1Exception) {
              if (param1File != null && param1File.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(param1File.getPath());
              } else {
                param1File = null;
              } 
              UserBasicModel userBasicModel = new UserBasicModel();
              userBasicModel.uid = this.a.getUid();
              userBasicModel.name = this.a.getName();
              userBasicModel.description = this.a.getDescription();
              ShareEntity shareEntity = ShareUtils.a().a(ShowVerifyFragment.a(this.f), ShowVerifyFragment.b(this.f), null, (Bitmap)param1File, this.b, this.c, this.d, this.e, userBasicModel);
              ShareUtils.a().a(ShowVerifyFragment.a(this.f), shareEntity);
            }
          }).a();
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493322, paramViewGroup, false);
      if (getArguments() != null) {
        this.f = getArguments().getString("USER_NAME");
        this.g = getArguments().getString("user_avatar");
        this.h = getArguments().getString("user_verify_date");
        this.j = getArguments().getString("UID");
        this.k = getArguments().getBoolean("request_other_flag");
        if (!StringUtils.e(this.h))
          this.h = TimeAndDateUtils.a(TimeAndDateUtils.b(this.h)); 
      } 
      m();
      l();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\ShowVerifyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */