package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;

public class LivePopUpDialog {
  private static String B = "";
  
  private int A;
  
  private TextWatcher C = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      public void afterTextChanged(Editable param1Editable) {
        try {
          LivePopUpDialog.b(this.a).removeTextChangedListener(LivePopUpDialog.a(this.a));
          this.b = LivePopUpDialog.b(this.a).getSelectionStart();
          this.c = LivePopUpDialog.b(this.a).getSelectionEnd();
          while (param1Editable.length() > LivePopUpDialog.c(this.a)) {
            param1Editable.delete(this.b - 1, this.c);
            this.b--;
            this.c--;
          } 
          int i = param1Editable.length();
          TextView textView = LivePopUpDialog.d(this.a);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(i);
          stringBuilder.append("/");
          stringBuilder.append(LivePopUpDialog.c(this.a));
          textView.setText(stringBuilder.toString());
          LivePopUpDialog.b(this.a).setSelection(this.b);
          LivePopUpDialog.b(this.a).addTextChangedListener(LivePopUpDialog.a(this.a));
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
          return;
        } 
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  private View a;
  
  private View b;
  
  private Context c;
  
  private MyPopupWindow d;
  
  private LayoutInflater e;
  
  private FrameLayout f;
  
  private String g = " / ";
  
  private String h = "";
  
  private String i = "";
  
  private String j = "";
  
  private String k = "";
  
  private View.OnClickListener l;
  
  private TextView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private TextView q;
  
  private TextView r;
  
  private TextView s;
  
  private TextView t;
  
  private EditText u;
  
  private EditText v;
  
  private LinearLayout w;
  
  private LinearLayout x;
  
  private LinearLayout y;
  
  private LinearLayout z;
  
  public LivePopUpDialog(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, View.OnClickListener paramOnClickListener, View paramView) {
    this.c = paramContext;
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
    this.k = paramString4;
    this.l = paramOnClickListener;
    this.b = paramView;
    c();
  }
  
  private void a(int paramInt) {
    this.n.setVisibility(paramInt);
    this.m.setVisibility(paramInt);
  }
  
  public static void a(Context paramContext, String paramString) {
    if (paramContext == null)
      return; 
    LivePopUpDialog livePopUpDialog = new LivePopUpDialog(paramContext, "", paramString, paramContext.getResources().getString(R.string.Live_applyHost_IKnow), "", null, null);
    livePopUpDialog.a(8);
    livePopUpDialog.b(0);
    livePopUpDialog.o.setTextColor(paramContext.getResources().getColor(R.color.white));
    livePopUpDialog.y.setBackground(paramContext.getResources().getDrawable(R.drawable.shape_live_warning));
    livePopUpDialog.c(8);
    livePopUpDialog.d(0);
    livePopUpDialog.e(8);
    livePopUpDialog.a(false);
    LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)livePopUpDialog.s.getLayoutParams();
    layoutParams1.setMargins(DensityUtils.a(paramContext, 14.0F), 0, DensityUtils.a(paramContext, 14.0F), 0);
    livePopUpDialog.s.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    livePopUpDialog.s.setBackgroundColor(paramContext.getResources().getColor(R.color.white));
    livePopUpDialog.q.setTextColor(paramContext.getResources().getColor(R.color.white));
    livePopUpDialog.a.setBackgroundColor(paramContext.getResources().getColor(R.color.transparent));
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)livePopUpDialog.y.getLayoutParams();
    layoutParams.width = DensityUtils.a(paramContext, 333.0F);
    livePopUpDialog.y.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    livePopUpDialog.o.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    livePopUpDialog.a.setBackgroundColor(paramContext.getResources().getColor(R.color.sub_transparent));
    livePopUpDialog.a();
  }
  
  private void a(boolean paramBoolean) {
    this.d.setOutsideTouchable(paramBoolean);
    this.a.setOnClickListener(null);
  }
  
  private void b(int paramInt) {
    this.o.setVisibility(paramInt);
  }
  
  private void c() {
    this.e = LayoutInflater.from(this.c);
    View view = this.e.inflate(R.layout.item_pop_dialog, null);
    this.f = (FrameLayout)view.findViewById(R.id.ll_main);
    this.a = view.findViewById(R.id.tv_bg);
    this.u = (EditText)view.findViewById(R.id.et_message);
    this.u.addTextChangedListener(this.C);
    this.v = (EditText)view.findViewById(R.id.et_pw);
    this.w = (LinearLayout)view.findViewById(R.id.ll_edit);
    this.y = (LinearLayout)view.findViewById(R.id.ll_content);
    this.z = (LinearLayout)view.findViewById(R.id.ll_message);
    this.r = (TextView)view.findViewById(R.id.tv_input_count);
    this.s = (TextView)view.findViewById(R.id.tv_buttons_top_line);
    this.x = (LinearLayout)view.findViewById(R.id.ll_bottom_buttons);
    this.t = (TextView)view.findViewById(R.id.tv_button_cut);
    this.a.setBackgroundColor(-16777216);
    this.a.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.b();
          }
        });
    if (this.b != null) {
      view.findViewById(R.id.ll_content).setVisibility(8);
      ((LinearLayout.LayoutParams)this.b.getLayoutParams()).gravity = 17;
      this.f.addView(this.b);
    } else {
      this.b = view.findViewById(R.id.ll_content);
      this.m = (TextView)view.findViewById(R.id.tv_title);
      this.n = (TextView)view.findViewById(R.id.tv_title_cutline);
      if (TextUtils.isEmpty(this.h)) {
        this.m.setVisibility(8);
        this.n.setVisibility(8);
      } else {
        this.m.setVisibility(0);
        this.m.setText(this.h);
        this.n.setVisibility(0);
      } 
      this.o = (TextView)view.findViewById(R.id.tv_message);
      this.o.setText(this.i);
      this.p = (TextView)view.findViewById(R.id.tv_cancel);
      if (!TextUtils.isEmpty(this.k))
        this.p.setText(this.k); 
      this.q = (TextView)view.findViewById(R.id.tv_ok);
      if (!TextUtils.isEmpty(this.j))
        this.q.setText(this.j); 
      this.q.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (LivePopUpDialog.e(this.a) != null)
                LivePopUpDialog.e(this.a).onClick(param1View); 
              this.a.b();
            }
          });
      this.p.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              this.a.b();
            }
          });
    } 
    this.b.setBackgroundColor(this.c.getResources().getColor(R.color.window_bg_color));
    this.b.setVisibility(8);
    this.d = new MyPopupWindow(this, view, -1, -1, true);
    this.d.setBackgroundDrawable(this.c.getResources().getDrawable(17170445));
    this.d.setTouchable(true);
    this.d.setOutsideTouchable(true);
    this.d.setFocusable(true);
    this.d.update();
  }
  
  private void c(int paramInt) {
    this.w.setVisibility(paramInt);
  }
  
  private void d(int paramInt) {
    this.s.setVisibility(paramInt);
    this.x.setVisibility(paramInt);
  }
  
  private void e(int paramInt) {
    this.p.setVisibility(paramInt);
    this.t.setVisibility(paramInt);
  }
  
  public void a() {
    this.a.clearAnimation();
    this.b.clearAnimation();
    if (this.d.isShowing())
      this.d.a(); 
    this.d.showAtLocation(this.b, 81, 0, 0);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(400L);
    alphaAnimation.setFillAfter(true);
    this.a.startAnimation((Animation)alphaAnimation);
    this.b.setVisibility(0);
    this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_center_in));
  }
  
  public void b() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(200L);
    alphaAnimation.setFillAfter(true);
    this.a.startAnimation((Animation)alphaAnimation);
    this.b.setVisibility(8);
    this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_center_out));
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            LivePopUpDialog.f(this.a).a();
          }
        },  320L);
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(LivePopUpDialog this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.b();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LivePopUpDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */