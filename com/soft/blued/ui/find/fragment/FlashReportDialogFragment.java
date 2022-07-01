package com.soft.blued.ui.find.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.ChatHttpUtils;

public class FlashReportDialogFragment extends DialogFragment {
  private Context a;
  
  private View b;
  
  private LinearLayout c;
  
  private LinearLayout d;
  
  private LinearLayout e;
  
  private LinearLayout f;
  
  private LinearLayout g;
  
  private TextView h;
  
  private TextView i;
  
  private TextView j;
  
  private TextView k;
  
  private TextView l;
  
  private ImageView m;
  
  private ImageView n;
  
  private ImageView o;
  
  private ImageView p;
  
  private ImageView q;
  
  private TextView r;
  
  private String s;
  
  private String t;
  
  private String u;
  
  private int v = -1;
  
  private DialogStateListener w;
  
  private void a() {
    this.m = (ImageView)this.b.findViewById(2131298042).findViewById(2131297418);
    this.n = (ImageView)this.b.findViewById(2131298087).findViewById(2131297418);
    this.o = (ImageView)this.b.findViewById(2131298093).findViewById(2131297418);
    this.p = (ImageView)this.b.findViewById(2131298056).findViewById(2131297418);
    this.q = (ImageView)this.b.findViewById(2131298084).findViewById(2131297418);
    this.c = (LinearLayout)this.b.findViewById(2131298042).findViewById(2131298686);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FlashReportDialogFragment.a(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.b(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.c(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.d(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.e(this.a).setImageResource(2131233559);
            FlashReportDialogFragment flashReportDialogFragment = this.a;
            FlashReportDialogFragment.a(flashReportDialogFragment, FlashReportDialogFragment.a(flashReportDialogFragment));
            FlashReportDialogFragment.a(this.a, 1);
            FlashReportDialogFragment.f(this.a);
          }
        });
    this.d = (LinearLayout)this.b.findViewById(2131298087).findViewById(2131298686);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FlashReportDialogFragment.a(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.b(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.c(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.d(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.e(this.a).setImageResource(2131233559);
            FlashReportDialogFragment flashReportDialogFragment = this.a;
            FlashReportDialogFragment.a(flashReportDialogFragment, FlashReportDialogFragment.b(flashReportDialogFragment));
            FlashReportDialogFragment.a(this.a, 4);
            FlashReportDialogFragment.f(this.a);
          }
        });
    this.e = (LinearLayout)this.b.findViewById(2131298093).findViewById(2131298686);
    this.e.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FlashReportDialogFragment.a(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.b(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.c(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.d(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.e(this.a).setImageResource(2131233559);
            FlashReportDialogFragment flashReportDialogFragment = this.a;
            FlashReportDialogFragment.a(flashReportDialogFragment, FlashReportDialogFragment.c(flashReportDialogFragment));
            FlashReportDialogFragment.a(this.a, 2);
            FlashReportDialogFragment.f(this.a);
          }
        });
    this.f = (LinearLayout)this.b.findViewById(2131298056).findViewById(2131298686);
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FlashReportDialogFragment.a(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.b(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.c(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.d(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.e(this.a).setImageResource(2131233559);
            FlashReportDialogFragment flashReportDialogFragment = this.a;
            FlashReportDialogFragment.a(flashReportDialogFragment, FlashReportDialogFragment.d(flashReportDialogFragment));
            FlashReportDialogFragment.a(this.a, 5);
            FlashReportDialogFragment.f(this.a);
          }
        });
    this.g = (LinearLayout)this.b.findViewById(2131298084).findViewById(2131298686);
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FlashReportDialogFragment.a(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.b(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.c(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.d(this.a).setImageResource(2131233559);
            FlashReportDialogFragment.e(this.a).setImageResource(2131233559);
            FlashReportDialogFragment flashReportDialogFragment = this.a;
            FlashReportDialogFragment.a(flashReportDialogFragment, FlashReportDialogFragment.e(flashReportDialogFragment));
            FlashReportDialogFragment.a(this.a, 0);
            FlashReportDialogFragment.f(this.a);
          }
        });
    this.h = (TextView)this.b.findViewById(2131298042).findViewById(2131300463);
    this.h.setText(getResources().getString(2131755235));
    this.i = (TextView)this.b.findViewById(2131298087).findViewById(2131300463);
    this.i.setText(getResources().getString(2131758403));
    this.j = (TextView)this.b.findViewById(2131298093).findViewById(2131300463);
    this.j.setText(getResources().getString(2131758404));
    this.k = (TextView)this.b.findViewById(2131298056).findViewById(2131300463);
    this.k.setText(getResources().getString(2131756219));
    this.l = (TextView)this.b.findViewById(2131298084).findViewById(2131300463);
    this.l.setText(getResources().getString(2131758335));
    this.r = (TextView)this.b.findViewById(2131301363);
    this.r.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (FlashReportDialogFragment.g(this.a) != -1) {
              FlashReportDialogFragment.h(this.a);
              this.a.dismiss();
            } 
          }
        });
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.dismiss();
          }
        });
    DialogStateListener dialogStateListener = this.w;
    if (dialogStateListener != null)
      dialogStateListener.a(); 
  }
  
  private void a(int paramInt) {
    AppMethods.a(this.a.getResources().getString(paramInt));
  }
  
  private void a(ImageView paramImageView) {
    ScaleAnimation scaleAnimation1 = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
    scaleAnimation1.setDuration(200L);
    ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5F, 1.1F, 0.5F, 1.1F, 1, 0.5F, 1, 0.5F);
    scaleAnimation2.setDuration(100L);
    ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.1F, 1.0F, 1.1F, 1.0F, 1, 0.5F, 1, 0.5F);
    scaleAnimation3.setDuration(50L);
    scaleAnimation1.setAnimationListener(new Animation.AnimationListener(this, paramImageView, scaleAnimation2) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.setImageResource(2131233514);
            this.a.startAnimation((Animation)this.b);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    scaleAnimation2.setAnimationListener(new Animation.AnimationListener(this, paramImageView, scaleAnimation3) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.startAnimation((Animation)this.b);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    paramImageView.startAnimation((Animation)scaleAnimation1);
  }
  
  private void b() {
    if (this.v != -1) {
      this.r.setBackground(getResources().getDrawable(2131233793));
      return;
    } 
    this.r.setBackground(getResources().getDrawable(2131233788));
  }
  
  private void c() {
    ChatHttpUtils.a(this.a, new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            FlashReportDialogFragment.b(this.a, 2131755510);
          }
        }this.s, this.v, this.t, this.u, null);
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {
    super.onCancel(paramDialogInterface);
  }
  
  public void onCreate(Bundle paramBundle) {
    this.a = (Context)getActivity();
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.s = bundle.getString("uid");
      this.t = bundle.getString("roomId");
      this.u = bundle.getString("streamId");
    } 
    setStyle(0, 2131821110);
    if (AppInfo.p())
      StatusBarHelper.a((Activity)getActivity(), false); 
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getArguments();
    View view = this.b;
    if (view == null) {
      this.b = paramLayoutInflater.inflate(2131493054, paramViewGroup, false);
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.b.getParent()).removeView(this.b);
    } 
    return this.b;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    DialogStateListener dialogStateListener = this.w;
    if (dialogStateListener != null) {
      dialogStateListener.b();
      this.w = null;
    } 
    super.onDismiss(paramDialogInterface);
  }
  
  public static interface DialogStateListener {
    void a();
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\FlashReportDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */