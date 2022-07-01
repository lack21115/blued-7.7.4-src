package com.soft.blued.ui.find.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.customview.PileLayout;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.TimeAndDateUtils;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class HelloStateDialogFragment extends BaseDialogFragment {
  public View a;
  
  private Context b;
  
  private TextView c;
  
  private ImageView d;
  
  private View e;
  
  private View f;
  
  private LinearLayout g;
  
  private LinearLayout h;
  
  private TextView i;
  
  private TextView j;
  
  private PileLayout k;
  
  private TextView l;
  
  private TextView m;
  
  private LinearLayout n;
  
  private ImageView o;
  
  private TextView p;
  
  private LoadOptions q;
  
  private CallMeStatusData r;
  
  private Timer s;
  
  private int t;
  
  public static void a(Context paramContext, CallMeStatusData paramCallMeStatusData) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("data", (Serializable)paramCallMeStatusData);
    TransparentActivity.a(bundle);
    TransparentActivity.b(paramContext, HelloStateDialogFragment.class, bundle);
  }
  
  private void f() {
    this.c = (TextView)this.a.findViewById(2131301409);
    this.d = (ImageView)this.a.findViewById(2131297721);
    this.e = this.a.findViewById(2131297095);
    this.f = this.a.findViewById(2131297681);
    this.g = (LinearLayout)this.a.findViewById(2131299098);
    this.h = (LinearLayout)this.a.findViewById(2131298739);
    this.i = (TextView)this.a.findViewById(2131301181);
    this.j = (TextView)this.a.findViewById(2131301509);
    this.k = (PileLayout)this.a.findViewById(2131299475);
    this.l = (TextView)this.a.findViewById(2131300662);
    this.m = (TextView)this.a.findViewById(2131301199);
    this.n = (LinearLayout)this.a.findViewById(2131299128);
    this.o = (ImageView)this.a.findViewById(2131297729);
    this.p = (TextView)this.a.findViewById(2131300590);
    if (this.r.call_status == 5) {
      this.p.setText(getResources().getString(2131755695));
    } else {
      this.p.setText(getResources().getString(2131755701));
    } 
    this.q = new LoadOptions();
    LoadOptions loadOptions = this.q;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
    g();
    m();
  }
  
  private void g() {
    this.o.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.p.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if ((HelloStateDialogFragment.a(this.a)).call_status == 5) {
              if (BluedConfig.b().I()) {
                HelloOpenDialogFragment.a(this.a.getContext(), 0);
                return;
              } 
              CallHelloManager.a().a(this.a.getContext(), new CallHelloManager.ToOpenListener(this) {
                    public void a(boolean param2Boolean) {
                      if (param2Boolean)
                        CallHelloManager.a().a(this.a.a.getContext(), (IRequestHost)this.a.a.a(), false, 4); 
                    }
                  });
              return;
            } 
            this.a.getActivity().finish();
          }
        });
  }
  
  private void h() {
    this.o.setVisibility(8);
    this.n.setVisibility(8);
    this.h.setVisibility(8);
    if ((CallHelloManager.a().b()).is_quietly == 1) {
      this.c.setText(2131755714);
      this.m.setText(2131755715);
    } else {
      this.c.setText(2131755708);
      this.m.setText(2131756898);
    } 
    this.m.setVisibility(0);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
    this.g.setVisibility(0);
    this.l.setVisibility(0);
    Animation animation = AnimationUtils.loadAnimation(this.b, 2130771997);
    animation.setInterpolator((Interpolator)new LinearInterpolator());
    this.f.startAnimation(animation);
    n();
  }
  
  private void i() {
    this.l.setVisibility(8);
    this.o.setVisibility(8);
    this.m.setVisibility(8);
    this.n.setVisibility(0);
    this.h.setVisibility(8);
    this.c.setText(getResources().getString(2131755719));
    this.d.setVisibility(0);
    this.d.setImageResource(2131232404);
    this.e.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  private void j() {
    this.l.setVisibility(0);
    this.o.setVisibility(8);
    this.n.setVisibility(8);
    this.h.setVisibility(0);
    if ((CallHelloManager.a().b()).is_quietly == 1) {
      this.c.setText(getResources().getString(2131755715));
    } else {
      this.c.setText(getResources().getString(2131756898));
    } 
    this.m.setText(2131755717);
    this.m.setVisibility(0);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
    this.g.setVisibility(0);
    TextView textView = this.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.r.promote_person_num);
    textView.setText(stringBuilder.toString());
    textView = this.j;
    stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.r.visits);
    textView.setText(stringBuilder.toString());
    l();
    Animation animation = AnimationUtils.loadAnimation(this.b, 2130771997);
    animation.setInterpolator((Interpolator)new LinearInterpolator());
    this.f.startAnimation(animation);
    n();
  }
  
  private void k() {
    this.l.setVisibility(8);
    this.o.setVisibility(0);
    this.n.setVisibility(8);
    this.h.setVisibility(0);
    if ((CallHelloManager.a().b()).is_quietly == 1) {
      this.c.setText(getResources().getString(2131755713));
    } else {
      this.c.setText(getResources().getString(2131755697));
    } 
    this.m.setText(2131755716);
    this.m.setVisibility(0);
    this.d.setVisibility(0);
    this.d.setImageResource(2131232397);
    this.e.setVisibility(8);
    this.g.setVisibility(8);
    TextView textView = this.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.r.promote_person_num);
    textView.setText(stringBuilder.toString());
    textView = this.j;
    stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.r.visits);
    textView.setText(stringBuilder.toString());
    l();
  }
  
  private void l() {
    if (this.r.visitors != null && !this.r.visitors.isEmpty()) {
      this.k.removeAllViews();
      for (CallMeStatusData.Visitor visitor : this.r.visitors) {
        ImageView imageView = new ImageView(getContext());
        ImageLoader.a((IRequestHost)a(), visitor.avatar).a(2131234356).a(2.0F, -1).a(imageView);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(DensityUtils.a(getContext(), 32.0F), DensityUtils.a(getContext(), 32.0F));
        this.k.addView((View)imageView, (ViewGroup.LayoutParams)marginLayoutParams);
      } 
    } 
  }
  
  private void m() {
    int i = this.r.call_status;
    if (i != 1) {
      if (i != 2) {
        if (i != 4) {
          if (i != 5)
            return; 
          k();
          return;
        } 
        h();
        return;
      } 
      i();
      return;
    } 
    j();
  }
  
  private void n() {
    Timer timer = this.s;
    if (timer != null) {
      timer.cancel();
      this.s = null;
    } 
    this.t = this.r.countdown;
    this.s = new Timer();
    this.s.schedule(new TimerTask(this) {
          public void run() {
            HelloStateDialogFragment.b(this.a);
            if (HelloStateDialogFragment.c(this.a) <= 0) {
              if (HelloStateDialogFragment.d(this.a) != null) {
                HelloStateDialogFragment.d(this.a).cancel();
                HelloStateDialogFragment.a(this.a, (Timer)null);
                this.a.getActivity().finish();
              } 
              return;
            } 
            AppInfo.n().post(new Runnable(this) {
                  public void run() {
                    HelloStateDialogFragment.e(this.a.a).setText(TimeAndDateUtils.a(HelloStateDialogFragment.c(this.a.a), false));
                  }
                });
          }
        }0L, 1000L);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (getArguments() != null)
      this.r = (CallMeStatusData)getArguments().getSerializable("data"); 
    if (this.r == null)
      getActivity().finish(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.b = (Context)getActivity();
    if (this.a == null) {
      this.a = paramLayoutInflater.inflate(2131492998, paramViewGroup, false);
      f();
      StatusBarHelper.a((Activity)getActivity(), false);
    } 
    return this.a;
  }
  
  public void onDestroy() {
    super.onDestroy();
    Timer timer = this.s;
    if (timer != null) {
      timer.cancel();
      this.s = null;
    } 
  }
  
  public void onPause() {
    super.onPause();
    View view = this.f;
    if (view != null)
      view.clearAnimation(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\HelloStateDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */