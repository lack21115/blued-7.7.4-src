package com.soft.blued.ui.msg;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.message.MessageProtos;
import com.blued.das.vip.VipProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.find.view.TwoWaysBar;
import com.soft.blued.ui.msg.manager.MsgBoxManager;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.dialog.CommonDialogFragment;
import java.util.HashSet;

public class MsgBoxSettingDialogFragment extends CommonDialogFragment implements View.OnClickListener {
  private CommonTopTitleNoTrans a;
  
  private View b;
  
  private String c;
  
  private TextView d;
  
  private TextView e;
  
  private TextView f;
  
  private TwoWaysBar g;
  
  private TextView h;
  
  private int i = 0;
  
  private ToggleButton j;
  
  private View k;
  
  private boolean l;
  
  private void h() {
    try {
      this.c = BluedPreferences.cW();
      this.g.d = 4;
      this.g.a(this.c, 101);
      this.h.setText(TwoWaysBar.a(getContext(), this.c, 4));
    } finally {
      Exception exception = null;
      BluedPreferences.aj("");
    } 
  }
  
  private void i() {
    boolean bool;
    this.h = (TextView)this.b.findViewById(2131300715);
    this.g = (TwoWaysBar)this.b.findViewById(2131296500);
    TwoWaysBar twoWaysBar = this.g;
    twoWaysBar.d = 4;
    twoWaysBar.setTwoWaysBarListner(new TwoWaysBar.TwoWaysBarListner(this) {
          public void a(int param1Int1, int param1Int2) {
            if (param1Int1 == 0 && param1Int2 == 0) {
              BluedPreferences.ak("0-0");
            } else {
              int i = 100;
              if (param1Int1 == param1Int2) {
                i = param1Int1;
                if (param1Int1 == 100)
                  i = 99; 
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("-");
                int j = i + 1;
                param1Int1 = j;
                if (j >= 100)
                  param1Int1 = 100; 
                stringBuilder.append(param1Int1);
                BluedPreferences.ak(stringBuilder.toString());
                param1Int1 = i;
              } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(param1Int1);
                stringBuilder.append("-");
                if (param1Int2 < 100)
                  i = param1Int2; 
                stringBuilder.append(i);
                BluedPreferences.ak(stringBuilder.toString());
              } 
            } 
            MsgBoxSettingDialogFragment.a(this.a).setText(TwoWaysBar.a(this.a.getContext(), param1Int1, param1Int2, 4));
          }
          
          public void a(boolean param1Boolean) {}
          
          public void b(boolean param1Boolean) {}
          
          public void c(boolean param1Boolean) {
            if (!param1Boolean && (UserInfo.a().i()).vip_grade == 0)
              MsgBoxSettingDialogFragment.b(this.a); 
          }
        });
    this.d = (TextView)this.b.findViewById(2131301019);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if ((UserInfo.a().i()).vip_grade == 0) {
              MsgBoxSettingDialogFragment.b(this.a);
              return;
            } 
            if (MsgBoxSettingDialogFragment.c(this.a).isSelected()) {
              MsgBoxSettingDialogFragment.c(this.a).setSelected(false);
              return;
            } 
            MsgBoxSettingDialogFragment.c(this.a).setSelected(true);
          }
        });
    this.e = (TextView)this.b.findViewById(2131300755);
    this.e.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if ((UserInfo.a().i()).vip_grade == 0) {
              MsgBoxSettingDialogFragment.b(this.a);
              return;
            } 
            if (MsgBoxSettingDialogFragment.d(this.a).isSelected()) {
              MsgBoxSettingDialogFragment.d(this.a).setSelected(false);
              return;
            } 
            MsgBoxSettingDialogFragment.d(this.a).setSelected(true);
          }
        });
    this.f = (TextView)this.b.findViewById(2131300969);
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if ((UserInfo.a().i()).vip_grade == 0) {
              MsgBoxSettingDialogFragment.b(this.a);
              return;
            } 
            if (MsgBoxSettingDialogFragment.e(this.a).isSelected()) {
              MsgBoxSettingDialogFragment.e(this.a).setSelected(false);
              return;
            } 
            MsgBoxSettingDialogFragment.e(this.a).setSelected(true);
          }
        });
    this.j = (ToggleButton)this.b.findViewById(2131300240);
    this.j.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (!MsgBoxSettingDialogFragment.f(this.a) && (UserInfo.a().i()).vip_grade == 0) {
              MsgBoxSettingDialogFragment.a(this.a, true);
              MsgBoxSettingDialogFragment.b(this.a);
              return true;
            } 
            return false;
          }
        });
    this.k = this.b.findViewById(2131297058);
    this.j.setChecked(BluedPreferences.dL());
    this.j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            boolean bool;
            View view = MsgBoxSettingDialogFragment.g(this.a);
            if (param1Boolean) {
              bool = true;
            } else {
              bool = false;
            } 
            view.setVisibility(bool);
            EventTrackMessage.a(MessageProtos.Event.MSG_NO_DISTURB_FILTER, param1Boolean);
          }
        });
    View view = this.k;
    if (BluedPreferences.dL()) {
      bool = true;
    } else {
      bool = false;
    } 
    view.setVisibility(bool);
    this.k.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return true;
          }
        });
  }
  
  private void j() {
    HashSet<String> hashSet = new HashSet();
    if (this.e.isSelected())
      hashSet.add("2"); 
    if (this.d.isSelected())
      hashSet.add("1"); 
    if (this.f.isSelected())
      hashSet.add("3"); 
    if (!hashSet.isEmpty()) {
      BluedPreferences.aj(AppInfo.f().toJson(hashSet));
    } else {
      BluedPreferences.aj("");
    } 
    BluedPreferences.P(this.j.isChecked());
    if (MsgBoxManager.a().c())
      BluedPreferences.o(System.currentTimeMillis()); 
    LiveEventBus.get("refresh_session_list").post(null);
    if (MsgBoxManager.a().c()) {
      ToastUtils.a(getResources().getString(2131758044));
    } else {
      MsgBoxManager.a().b();
      ToastUtils.a(getResources().getString(2131758028));
    } 
    ChatHttpUtils.a(new BluedUIHttpResponse(this, (IRequestHost)a()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }BluedPreferences.cV(), BluedPreferences.cW(), MsgBoxManager.a().c(), (IRequestHost)a());
  }
  
  private void l() {
    PayUtils.a(getContext(), this.i, "msg_no_disturb", 28, VipProtos.FromType.UNKNOWN_FROM);
  }
  
  public void a(View paramView) {
    this.b = paramView;
    this.a = (CommonTopTitleNoTrans)paramView.findViewById(2131300300);
    this.a.setCenterText(getResources().getString(2131758024));
    this.a.setRightText(2131756206);
    this.a.setLeftClickListener(this);
    this.a.setRightClickListener(this);
    this.a.getTitleBackground().setBackground((Drawable)new ColorDrawable(0));
    ShapeTextView shapeTextView = this.a.getRightTextView();
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)shapeTextView.getLayoutParams();
    layoutParams.rightMargin = DensityUtils.a(getContext(), 10.0F);
    shapeTextView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    shapeTextView.setTextColor(getResources().getColor(2131100716));
    ImageView imageView = this.a.getLeftImg();
    layoutParams = (RelativeLayout.LayoutParams)imageView.getLayoutParams();
    layoutParams.leftMargin = DensityUtils.a(getContext(), 10.0F);
    imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    imageView.setImageResource(2131232745);
    TextView textView2 = (TextView)paramView.findViewById(2131301043);
    TextView textView1 = (TextView)paramView.findViewById(2131301029);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("0");
    stringBuilder2.append(getResources().getString(2131758040));
    textView2.setText(stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("100");
    stringBuilder1.append(getResources().getString(2131758040));
    textView1.setText(stringBuilder1.toString());
    i();
    if (getArguments() != null && getArguments().containsKey("vipFrom"))
      this.i = getArguments().getInt("vipFrom"); 
  }
  
  public int f() {
    return 2131493216;
  }
  
  public int g() {
    return (int)(AppInfo.m / 6.0F * 5.0F);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      if ((UserInfo.a().i()).vip_grade == 0) {
        dismiss();
        return;
      } 
      j();
      dismiss();
      return;
    } 
    dismiss();
  }
  
  public void onResume() {
    super.onResume();
    this.l = false;
    if ((UserInfo.a().i()).vip_grade == 0) {
      this.g.a("0-0", 101);
      this.g.setEnabled(false);
      return;
    } 
    this.g.setEnabled(true);
    h();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MsgBoxSettingDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */