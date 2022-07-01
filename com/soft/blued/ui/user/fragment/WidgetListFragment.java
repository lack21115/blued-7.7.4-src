package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.das.vip.VipProtos;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.user.manager.AvatarWidgetManager;
import com.soft.blued.ui.user.model.VIPCustomSettingBase;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.TimeAndDateUtils;
import java.io.Serializable;

public class WidgetListFragment extends CustomSettingBaseFragment {
  public TextView n;
  
  public TextView o;
  
  private ImageView p;
  
  private TextView q;
  
  private ImageView r;
  
  private TextView s;
  
  private TextView t;
  
  public static void a(Context paramContext, int paramInt, String paramString, VipProtos.FromType paramFromType) {
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_VIP_GRADE", paramInt);
    bundle.putString("KEY_VIP_DETAIL", paramString);
    bundle.putSerializable("KEY_VIP_FROM_TYPE", (Serializable)paramFromType);
    TerminalActivity.d(paramContext, WidgetListFragment.class, bundle);
  }
  
  public int a() {
    return 1;
  }
  
  public void a(int paramInt) {
    VipProtos.Event event = VipProtos.Event.PHOTO_PENDANT_PAGE_SAVE_CLICK;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    EventTrackVIP.a(event, stringBuilder.toString());
  }
  
  public void a(VIPCustomSettingBase paramVIPCustomSettingBase) {
    if (paramVIPCustomSettingBase == null)
      return; 
    if (paramVIPCustomSettingBase.lastSelected) {
      this.o.setVisibility(8);
      this.n.setVisibility(8);
      if (paramVIPCustomSettingBase.is_termination == 1) {
        this.s.setVisibility(0);
        this.t.setVisibility(0);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramVIPCustomSettingBase.stop_time);
        stringBuilder1.append("");
        String str = TimeAndDateUtils.a(stringBuilder1.toString());
        TextView textView = this.t;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.d.getResources().getString(2131759193));
        stringBuilder2.append(str);
        textView.setText(stringBuilder2.toString());
      } else {
        this.s.setVisibility(8);
        this.t.setVisibility(8);
      } 
    } else {
      this.s.setVisibility(8);
      this.t.setVisibility(8);
      if (paramVIPCustomSettingBase.isDefault) {
        if (p())
          this.n.setText(2131758625); 
        this.n.setVisibility(0);
        this.o.setVisibility(8);
      } else {
        if (paramVIPCustomSettingBase.is_termination == 1) {
          this.s.setVisibility(0);
          this.o.setVisibility(0);
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramVIPCustomSettingBase.stop_time);
          stringBuilder1.append("");
          String str = TimeAndDateUtils.a(stringBuilder1.toString());
          TextView textView = this.o;
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(this.d.getResources().getString(2131759193));
          stringBuilder2.append(str);
          textView.setText(stringBuilder2.toString());
        } else {
          this.o.setVisibility(8);
        } 
        if (p())
          this.n.setText(2131756153); 
        this.n.setVisibility(0);
      } 
    } 
    this.q.setText(paramVIPCustomSettingBase.name);
    ImageLoader.a((IRequestHost)w_(), AvatarWidgetManager.a().a(paramVIPCustomSettingBase.id)).a(this.p);
  }
  
  public void b(int paramInt) {
    AppMethods.d(2131756225);
    AvatarWidgetManager.a().b(paramInt);
    this.o.setVisibility(8);
    this.n.setVisibility(8);
  }
  
  public void b(VIPCustomSettingBase paramVIPCustomSettingBase) {
    this.q.setText(paramVIPCustomSettingBase.name);
    ImageLoader.a((IRequestHost)w_(), AvatarWidgetManager.a().a(paramVIPCustomSettingBase.id)).a(this.p);
    if (paramVIPCustomSettingBase.isDefault) {
      this.s.setVisibility(8);
      this.t.setVisibility(8);
      if (!p()) {
        this.n.setVisibility(8);
        return;
      } 
    } else {
      if (paramVIPCustomSettingBase.is_termination == 1) {
        this.s.setVisibility(0);
        this.t.setVisibility(0);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramVIPCustomSettingBase.stop_time);
        stringBuilder1.append("");
        String str = TimeAndDateUtils.a(stringBuilder1.toString());
        TextView textView = this.t;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.d.getResources().getString(2131759193));
        stringBuilder2.append(str);
        textView.setText(stringBuilder2.toString());
        return;
      } 
      this.s.setVisibility(8);
      this.t.setVisibility(8);
    } 
  }
  
  public String k() {
    return "pendant";
  }
  
  public String l() {
    return this.d.getResources().getString(2131756150);
  }
  
  public int m() {
    return 32;
  }
  
  public Drawable n() {
    return null;
  }
  
  public int o() {
    return 2131493354;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.n = (TextView)this.e.findViewById(2131300588);
    this.q = (TextView)this.e.findViewById(2131300262);
    this.p = (ImageView)this.e.findViewById(2131301759);
    this.r = (ImageView)this.e.findViewById(2131297362);
    this.o = (TextView)this.e.findViewById(2131301583);
    this.s = (TextView)this.e.findViewById(2131301389);
    this.t = (TextView)this.e.findViewById(2131300304);
    String str = AvatarUtils.a(1, UserInfo.a().i().getAvatar());
    ImageLoader.a((IRequestHost)w_(), str).a(2131234356).c(2131234356).c().a(this.r);
    if (p()) {
      this.o.setVisibility(8);
      this.n.setVisibility(8);
    } else {
      this.o.setVisibility(8);
      this.n.setText(2131755691);
    } 
    this.n.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.p()) {
              this.a.r();
              return;
            } 
            EventTrackVIP.a(VipProtos.Event.PHOTO_PENDANT_PAGE_VIP_CLICK);
            this.a.q();
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\WidgetListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */