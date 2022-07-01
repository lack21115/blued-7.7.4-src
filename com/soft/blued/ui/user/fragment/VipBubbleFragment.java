package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.das.message.MessageProtos;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.user.manager.VipBubbleManager;
import com.soft.blued.ui.user.model.VIPCustomSettingBase;
import com.soft.blued.ui.user.model.VipBubbleModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.TimeAndDateUtils;

public class VipBubbleFragment extends CustomSettingBaseFragment {
  private TextView n;
  
  private ImageView o;
  
  private View p;
  
  private TextView q;
  
  private TextView r;
  
  private TextView s;
  
  private TextView t;
  
  private TextView u;
  
  public static void a(Context paramContext, int paramInt, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_VIP_GRADE", paramInt);
    bundle.putString("KEY_VIP_DETAIL", paramString);
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    TerminalActivity.d(paramContext, VipBubbleFragment.class, bundle);
  }
  
  private void c(VIPCustomSettingBase paramVIPCustomSettingBase) {
    VipBubbleModel vipBubbleModel = VipBubbleManager.a().b(paramVIPCustomSettingBase.id);
    if (vipBubbleModel != null) {
      try {
        this.s.setTextColor(Color.parseColor(vipBubbleModel.text_color));
      } finally {}
      VipBubbleManager.a().b(vipBubbleModel, 1, new View[] { this.p });
      return;
    } 
    VipBubbleManager.a().a(new VipBubbleManager.RefreshListener(this, vipBubbleModel, paramVIPCustomSettingBase) {
          public void a() {
            try {
              VipBubbleFragment.a(this.c).setTextColor(Color.parseColor(this.a.text_color));
            } finally {
              Exception exception;
            } 
            VipBubbleManager.a().b(VipBubbleManager.a().b(this.b.id), 1, new View[] { VipBubbleFragment.b(this.c) });
          }
        }null);
  }
  
  public int a() {
    return 2;
  }
  
  public void a(int paramInt) {
    EventTrackMessage.a(MessageProtos.Event.MSG_BUBBLE_SAVE_CLICK, paramInt);
  }
  
  public void a(VIPCustomSettingBase paramVIPCustomSettingBase) {
    if (paramVIPCustomSettingBase == null)
      return; 
    if (paramVIPCustomSettingBase.lastSelected) {
      this.r.setVisibility(8);
      this.q.setVisibility(8);
      if (paramVIPCustomSettingBase.is_termination == 1) {
        this.t.setVisibility(0);
        this.u.setVisibility(0);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramVIPCustomSettingBase.stop_time);
        stringBuilder1.append("");
        String str = TimeAndDateUtils.a(stringBuilder1.toString());
        TextView textView = this.u;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.d.getResources().getString(2131759193));
        stringBuilder2.append(str);
        textView.setText(stringBuilder2.toString());
      } else {
        this.t.setVisibility(8);
        this.u.setVisibility(8);
      } 
    } else {
      this.t.setVisibility(8);
      this.u.setVisibility(8);
      if (paramVIPCustomSettingBase.isDefault) {
        if (p())
          this.q.setText(2131758625); 
        this.q.setVisibility(0);
        this.r.setVisibility(8);
      } else {
        if (paramVIPCustomSettingBase.is_termination == 1) {
          this.t.setVisibility(0);
          this.r.setVisibility(0);
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramVIPCustomSettingBase.stop_time);
          stringBuilder1.append("");
          String str = TimeAndDateUtils.a(stringBuilder1.toString());
          TextView textView = this.r;
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(this.d.getResources().getString(2131759193));
          stringBuilder2.append(str);
          textView.setText(stringBuilder2.toString());
        } else {
          this.r.setVisibility(8);
        } 
        if (p())
          this.q.setText(2131756153); 
        this.q.setVisibility(0);
      } 
    } 
    this.n.setText(paramVIPCustomSettingBase.name);
    if (paramVIPCustomSettingBase.isDefault) {
      this.s.setTextColor(BluedSkinUtils.a(this.d, 2131100728));
      VipBubbleManager.a().a(0, 1, new View[] { this.p });
      return;
    } 
    c(paramVIPCustomSettingBase);
  }
  
  public void b(int paramInt) {
    AppMethods.d(2131755683);
    VipBubbleManager.a().a(paramInt);
    this.r.setVisibility(8);
    this.q.setVisibility(8);
  }
  
  public void b(VIPCustomSettingBase paramVIPCustomSettingBase) {
    this.n.setText(paramVIPCustomSettingBase.name);
    if (paramVIPCustomSettingBase.isDefault) {
      this.t.setVisibility(8);
      this.u.setVisibility(8);
      if (!p())
        this.q.setVisibility(8); 
      VipBubbleManager.a().a(0, 1, new View[] { this.p });
      return;
    } 
    c(paramVIPCustomSettingBase);
    if (paramVIPCustomSettingBase.is_termination == 1) {
      this.t.setVisibility(0);
      this.u.setVisibility(0);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramVIPCustomSettingBase.stop_time);
      stringBuilder1.append("");
      String str = TimeAndDateUtils.a(stringBuilder1.toString());
      TextView textView = this.u;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.d.getResources().getString(2131759193));
      stringBuilder2.append(str);
      textView.setText(stringBuilder2.toString());
      return;
    } 
    this.t.setVisibility(8);
    this.u.setVisibility(8);
  }
  
  public String k() {
    return "message";
  }
  
  public String l() {
    return this.d.getResources().getString(2131759251);
  }
  
  public int m() {
    return 30;
  }
  
  public Drawable n() {
    return this.d.getResources().getDrawable(2131231180);
  }
  
  public int o() {
    return 2131493361;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.n = (TextView)this.e.findViewById(2131300262);
    this.o = (ImageView)this.e.findViewById(2131297362);
    this.p = this.e.findViewById(2131299242);
    this.q = (TextView)this.e.findViewById(2131300588);
    this.r = (TextView)this.e.findViewById(2131301583);
    this.s = (TextView)this.e.findViewById(2131301038);
    this.t = (TextView)this.e.findViewById(2131301389);
    this.u = (TextView)this.e.findViewById(2131300304);
    String str = AvatarUtils.a(1, UserInfo.a().i().getAvatar());
    ImageLoader.a((IRequestHost)w_(), str).a(2131234356).c(2131234356).c().a(this.o);
    if (p()) {
      this.r.setVisibility(8);
      this.q.setVisibility(8);
    } else {
      this.r.setVisibility(8);
      this.q.setText(2131755691);
    } 
    this.q.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.p()) {
              this.a.r();
              return;
            } 
            EventTrackMessage.a(MessageProtos.Event.MSG_BUBBLE_VIP_CLICK);
            this.a.q();
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\VipBubbleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */