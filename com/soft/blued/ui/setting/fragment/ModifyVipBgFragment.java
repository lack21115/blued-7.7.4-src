package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.third.QiniuUploadUtils;
import com.soft.blued.view.tip.CommonAlertDialog;

public class ModifyVipBgFragment extends BaseFragment implements View.OnClickListener {
  private View d;
  
  private Context e;
  
  private View f;
  
  private View g;
  
  private View h;
  
  private View i;
  
  private ImageView j;
  
  private TextView k;
  
  private View l;
  
  private String m;
  
  private int n;
  
  private Dialog o;
  
  private Bitmap a(View paramView) {
    Bitmap bitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(bitmap));
    return bitmap;
  }
  
  private void a() {
    Intent intent = new Intent();
    intent.putExtra("background_photo", this.m);
    intent.putExtra("background_photo_auditing", this.n);
    getActivity().setResult(-1, intent);
    getActivity().finish();
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, String paramString, int paramInt2) {
    Bundle bundle = new Bundle();
    bundle.putString("background_photo", paramString);
    bundle.putInt("background_photo_auditing", paramInt1);
    TerminalActivity.a((Fragment)paramBaseFragment, ModifyVipBgFragment.class, bundle, paramInt2);
  }
  
  private void a(String paramString) {
    LoginRegisterHttpUtils.a(this.e, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, (IRequestHost)w_(), paramString) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              BluedAlbum bluedAlbum = param1BluedEntityA.data.get(0);
              ModifyVipBgFragment.a(this.b, this.a, bluedAlbum);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ModifyVipBgFragment.a(this.b));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ModifyVipBgFragment.a(this.b));
          }
        }(IRequestHost)w_());
  }
  
  private void a(String paramString, BluedAlbum paramBluedAlbum) {
    QiniuUploadUtils.a(paramString, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this) {
          public void a(String param1String) {
            if (CommonTools.a((Fragment)this.a))
              DialogUtils.b(ModifyVipBgFragment.a(this.a)); 
          }
          
          public void a(String param1String, double param1Double) {}
          
          public void a(String param1String1, String param1String2) {
            ModifyVipBgFragment.b(this.a, param1String1);
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void b(String paramString) {
    MineHttpUtils.d(this.e, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, (IRequestHost)w_(), paramString) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            ModifyVipBgFragment.d(this.b).setVisibility(0);
            ModifyVipBgFragment.e(this.b).setVisibility(0);
            ModifyVipBgFragment.a(this.b, 1);
            ModifyVipBgFragment.a(this.b, this.a);
            ImageLoader.a((IRequestHost)this.b.w_(), AvatarUtils.a(3, ModifyVipBgFragment.c(this.b))).a(2131231100).c(2131231100).a(ModifyVipBgFragment.b(this.b));
            ModifyVipBgFragment.f(this.b).setVisibility(0);
            ModifyVipBgFragment.g(this.b).setVisibility(0);
            AppMethods.d(2131758470);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ModifyVipBgFragment.a(this.b));
          }
        }paramString, (IRequestHost)w_());
  }
  
  private void k() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.m = bundle.getString("background_photo");
      this.n = bundle.getInt("background_photo_auditing");
    } 
  }
  
  private void l() {
    this.o = DialogUtils.a(this.e);
    this.f = this.d.findViewById(2131296611);
    this.g = this.d.findViewById(2131296613);
    this.h = this.d.findViewById(2131296612);
    this.i = this.d.findViewById(2131296610);
    this.j = (ImageView)this.d.findViewById(2131297965);
    this.k = (TextView)this.d.findViewById(2131301496);
    this.l = this.d.findViewById(2131297966);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.j.getLayoutParams();
    layoutParams.height = AppInfo.l;
    this.j.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    if (!TextUtils.isEmpty(this.m)) {
      if (this.n == 1) {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
      } else {
        this.k.setVisibility(8);
        this.l.setVisibility(8);
      } 
      ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(3, this.m)).a(2131231100).c(2131231100).a(this.j);
    } 
  }
  
  private void m() {
    PermissionHelper.e(new PermissionCallbacks(this) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            PhotoSelectFragment.a(this.a, 14, 178);
          }
        });
  }
  
  private void n() {
    ImageUtils.a(a((View)this.j));
  }
  
  private void o() {
    UserHttpUtils.c(new BluedUIHttpResponse<BluedEntityA>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA param1BluedEntityA) {
            AppMethods.d(2131756175);
            ModifyVipBgFragment.a(this.a, "");
            ModifyVipBgFragment.a(this.a, 0);
            ImageLoader.a((IRequestHost)this.a.w_(), ModifyVipBgFragment.c(this.a)).a(2131231100).c(2131231100).a(ModifyVipBgFragment.b(this.a));
            ModifyVipBgFragment.d(this.a).setVisibility(8);
            ModifyVipBgFragment.e(this.a).setVisibility(8);
            ModifyVipBgFragment.f(this.a).setVisibility(8);
            ModifyVipBgFragment.g(this.a).setVisibility(8);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ModifyVipBgFragment.a(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ModifyVipBgFragment.a(this.a));
          }
        }(IRequestHost)w_());
  }
  
  public boolean V_() {
    a();
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1 && paramInt1 == 178 && paramIntent != null) {
      String str = paramIntent.getStringExtra("photo_path");
      if (!StringUtils.e(str))
        a(str); 
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    Context context;
    switch (paramView.getId()) {
      default:
        return;
      case 2131296613:
        n();
        return;
      case 2131296612:
        m();
        return;
      case 2131296611:
        context = this.e;
        CommonAlertDialog.a(context, context.getResources().getString(2131758460), new -$$Lambda$ModifyVipBgFragment$oBVM005qt1C3IjV4o5cWf3OYJtg(this));
        return;
      case 2131296610:
        break;
    } 
    a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493230, paramViewGroup, false);
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\ModifyVipBgFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */