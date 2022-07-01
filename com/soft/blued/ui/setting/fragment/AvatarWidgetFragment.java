package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
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
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

public class AvatarWidgetFragment extends BaseFragment implements View.OnClickListener {
  private View d;
  
  private Context e;
  
  private View f;
  
  private View g;
  
  private View h;
  
  private View i;
  
  private ImageView j;
  
  private Dialog k;
  
  private String l;
  
  private String m;
  
  private String n;
  
  private TextView o;
  
  private int p;
  
  private ImageView q;
  
  private Bitmap a(View paramView) {
    Bitmap bitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(bitmap));
    return bitmap;
  }
  
  private void a() {
    Intent intent = new Intent();
    getActivity().setResult(-1, intent);
    getActivity().finish();
  }
  
  private void k() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.l = bundle.getString("user_avatar");
      this.m = bundle.getString("UID");
      this.n = bundle.getString("avatar_widget");
      this.p = bundle.getInt("KEY_VIP_GRADE");
    } 
  }
  
  private void l() {
    this.k = DialogUtils.a(this.e);
    this.f = this.d.findViewById(2131296580);
    this.g = this.d.findViewById(2131296582);
    this.h = this.d.findViewById(2131296581);
    this.i = this.d.findViewById(2131296579);
    this.j = (ImageView)this.d.findViewById(2131297695);
    this.o = (TextView)this.d.findViewById(2131300544);
    this.q = (ImageView)this.d.findViewById(2131296491);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.j.getLayoutParams();
    layoutParams.height = AppInfo.l;
    this.j.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    if (TextUtils.equals((UserInfo.a().i()).uid, this.m)) {
      this.o.setText(2131756150);
      if (!BluedPreferences.dn())
        this.q.setVisibility(0); 
    } else if (!TextUtils.isEmpty(this.n)) {
      this.o.setText(2131759217);
    } else {
      this.o.setVisibility(8);
    } 
    ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(3, this.l)).a(2131231368).c(2131231368).a(this.j);
  }
  
  private void m() {
    ImageUtils.a(a((View)this.j));
  }
  
  public boolean V_() {
    a();
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1 && paramInt1 == 178 && paramIntent != null)
      StringUtils.e(paramIntent.getStringExtra("photo_path")); 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    int i;
    switch (paramView.getId()) {
      default:
        return;
      case 2131296582:
        m();
        return;
      case 2131296581:
        i = this.p;
        BluedPreferences.do();
        this.q.setVisibility(8);
        return;
      case 2131296579:
        break;
    } 
    a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493074, paramViewGroup, false);
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\AvatarWidgetFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */