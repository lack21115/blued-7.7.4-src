package com.blued.android.module.live_china.same.tip.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class BluedAlertDialog extends Dialog {
  private static final int[] c = new int[] { R.drawable.selector_blued_dialog_blue_solid_btn_bg, R.drawable.selector_blued_dialog_blue_hollow_btn_bg, R.drawable.selector_blued_dialog_gary_hollow_btn_bg, 0 };
  
  private static final int[][] d = new int[][] { { -16842919 }, { 16842919 } };
  
  private static final int[][] e;
  
  private CharSequence A;
  
  private CharSequence B;
  
  private CharSequence C;
  
  private int D;
  
  private int E;
  
  private DialogInterface.OnClickListener F;
  
  private DialogInterface.OnClickListener G;
  
  private DialogInterface.OnCancelListener H;
  
  private DialogInterface.OnDismissListener I;
  
  private RecyclerView.Adapter J;
  
  private DialogInterface.OnClickListener K;
  
  private int L;
  
  private int M;
  
  private int N;
  
  private int[] O;
  
  private int P;
  
  private boolean Q = true;
  
  private boolean R = false;
  
  private int a;
  
  private List<String> b;
  
  private Context f;
  
  private LinearLayout g;
  
  private ImageView h;
  
  private ImageView i;
  
  private LinearLayout j;
  
  private TextView k;
  
  private TextView l;
  
  private View m;
  
  private LinearLayout n;
  
  private TextView o;
  
  private View p;
  
  private TextView q;
  
  private LinearLayout r;
  
  private TextView s;
  
  private TextView t;
  
  private RecyclerView u;
  
  private FrameLayout v;
  
  private View w;
  
  private int x;
  
  private boolean y;
  
  private CharSequence z;
  
  static {
    int[] arrayOfInt = { -13264385, -12094209 };
    e = new int[][] { { -1, -1 }, arrayOfInt, { -5921102, -8814195 }, { -5921102, -5921102 } };
  }
  
  private BluedAlertDialog(Context paramContext) {
    super(paramContext);
    this.f = paramContext;
  }
  
  private void a(int paramInt1, int paramInt2) {
    this.g.setPadding(0, paramInt1, 0, paramInt2);
  }
  
  private void c() {
    this.g = (LinearLayout)findViewById(R.id.ll_dialog);
    this.h = (ImageView)findViewById(R.id.iv_pic);
    this.i = (ImageView)findViewById(R.id.iv_close);
    this.j = (LinearLayout)findViewById(R.id.ll_content);
    this.k = (TextView)findViewById(R.id.tv_title);
    this.l = (TextView)findViewById(R.id.tv_content);
    this.m = findViewById(R.id.line_top_view);
    this.n = (LinearLayout)findViewById(R.id.ll_button_ordinary);
    this.o = (TextView)findViewById(R.id.tv_negative_ordinary);
    this.p = findViewById(R.id.line_center_view);
    this.q = (TextView)findViewById(R.id.tv_positive_ordinary);
    this.r = (LinearLayout)findViewById(R.id.ll_button_detailed);
    this.s = (TextView)findViewById(R.id.tv_positive_detailed);
    this.t = (TextView)findViewById(R.id.tv_negative_detailed);
    this.u = (RecyclerView)findViewById(R.id.dialog_list_view);
    this.v = (FrameLayout)findViewById(R.id.ll_custom);
    d();
  }
  
  private void d() {
    setCancelable(this.R);
    e();
    f();
    g();
    h();
    int i = this.a;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i == 3) {
            if (this.w == null)
              return; 
            this.u.setVisibility(8);
            this.g.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.v.setVisibility(0);
            this.v.addView(this.w);
            i();
            k();
            l();
            m();
          } 
        } else {
          this.u.setVisibility(0);
          this.g.setVisibility(8);
          RecyclerView.Adapter adapter = this.J;
          if (adapter != null) {
            this.u.setAdapter(adapter);
          } else {
            this.u.setAdapter(new SimpleAdapter(this.b, this.K));
          } 
        } 
      } else {
        this.u.setVisibility(8);
        this.g.setVisibility(0);
        j();
        n();
        o();
        p();
        q();
        r();
      } 
    } else {
      this.u.setVisibility(8);
      this.g.setVisibility(0);
      i();
      k();
      l();
      m();
    } 
    a(this.L, this.M);
  }
  
  private void e() {
    int i = this.x;
    if (i != 0) {
      this.h.setImageResource(i);
      this.h.setVisibility(0);
      return;
    } 
    this.h.setVisibility(8);
  }
  
  private void f() {
    if (this.y) {
      this.i.setVisibility(0);
      this.i.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              this.a.cancel();
            }
          });
      return;
    } 
    this.i.setVisibility(8);
  }
  
  private void g() {
    if (this.z != null) {
      this.k.setVisibility(0);
      this.k.setText(this.z);
      return;
    } 
    this.k.setVisibility(8);
  }
  
  private void h() {
    if (this.A != null) {
      this.l.setVisibility(0);
      this.l.setText(this.A);
      return;
    } 
    this.l.setVisibility(8);
  }
  
  private void i() {
    this.m.setVisibility(0);
    this.n.setVisibility(0);
    this.r.setVisibility(8);
  }
  
  private void j() {
    this.m.setVisibility(8);
    this.n.setVisibility(8);
    this.r.setVisibility(0);
  }
  
  private void k() {
    if (this.B != null) {
      this.q.setVisibility(0);
      this.q.setText(this.B);
      if (this.D != 0)
        this.q.setTextColor(this.f.getResources().getColor(this.D)); 
      this.q.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (BluedAlertDialog.a(this.a) != null)
                BluedAlertDialog.a(this.a).onClick((DialogInterface)this.a, -1); 
              this.a.dismiss();
            }
          });
      return;
    } 
    this.q.setVisibility(8);
  }
  
  private void l() {
    if (this.C != null) {
      this.o.setVisibility(0);
      this.o.setText(this.C);
      if (this.E != 0)
        this.o.setTextColor(this.f.getResources().getColor(this.E)); 
      this.o.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (BluedAlertDialog.b(this.a) != null)
                BluedAlertDialog.b(this.a).onClick((DialogInterface)this.a, -2); 
              this.a.dismiss();
            }
          });
      return;
    } 
    this.o.setVisibility(8);
  }
  
  private void m() {
    if (this.B == null || this.C == null) {
      this.p.setVisibility(8);
      this.q.setTextColor(BluedSkinUtils.a(this.f, R.color.syc_h));
      this.o.setTextColor(BluedSkinUtils.a(this.f, R.color.syc_h));
    } 
  }
  
  private void n() {
    if (this.B != null) {
      this.s.setVisibility(0);
      this.s.setText(this.B);
      this.s.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (BluedAlertDialog.a(this.a) != null)
                BluedAlertDialog.a(this.a).onClick((DialogInterface)this.a, -1); 
              this.a.dismiss();
            }
          });
      return;
    } 
    this.s.setVisibility(8);
  }
  
  private void o() {
    if (this.C != null) {
      this.t.setVisibility(0);
      this.t.setText(this.C);
      this.t.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (BluedAlertDialog.b(this.a) != null)
                BluedAlertDialog.b(this.a).onClick((DialogInterface)this.a, -2); 
              this.a.dismiss();
            }
          });
      return;
    } 
    this.t.setVisibility(8);
  }
  
  private void p() {
    this.t.setBackgroundResource(this.N);
  }
  
  private void q() {
    ColorStateList colorStateList = new ColorStateList(d, this.O);
    this.t.setTextColor(colorStateList);
  }
  
  private void r() {
    int i = this.P;
    if (i != 0)
      this.t.setHeight(i); 
  }
  
  public void cancel() {
    super.cancel();
    DialogInterface.OnCancelListener onCancelListener = this.H;
    if (onCancelListener != null)
      onCancelListener.onCancel((DialogInterface)this); 
  }
  
  public void dismiss() {
    super.dismiss();
    DialogInterface.OnDismissListener onDismissListener = this.I;
    if (onDismissListener != null)
      onDismissListener.onDismiss((DialogInterface)this); 
  }
  
  public void onCreate(Bundle paramBundle) {
    setContentView(R.layout.dialog_blued_alert);
    c();
    Window window = getWindow();
    if (window != null)
      window.setBackgroundDrawableResource(17170445); 
  }
  
  public static class Builder {
    private final BluedAlertDialog a;
    
    private int b;
    
    private boolean c;
    
    private boolean d;
    
    private boolean e;
    
    private boolean f;
    
    private boolean g;
    
    public Builder(Context param1Context) {
      this.a = new BluedAlertDialog(param1Context);
    }
    
    public Builder a(int param1Int) {
      BluedAlertDialog.a(this.a, param1Int);
      this.e = true;
      return this;
    }
    
    public Builder a(DialogInterface.OnDismissListener param1OnDismissListener) {
      BluedAlertDialog.a(this.a, param1OnDismissListener);
      return this;
    }
    
    public Builder a(View param1View) {
      BluedAlertDialog.a(this.a, param1View);
      return this;
    }
    
    public Builder a(CharSequence param1CharSequence) {
      if (param1CharSequence != null) {
        if (TextUtils.isEmpty(param1CharSequence.toString()))
          return this; 
        BluedAlertDialog.a(this.a, param1CharSequence.toString());
      } 
      return this;
    }
    
    public Builder a(CharSequence param1CharSequence, DialogInterface.OnClickListener param1OnClickListener) {
      if (param1CharSequence == null)
        return this; 
      BluedAlertDialog.c(this.a, param1CharSequence);
      BluedAlertDialog.a(this.a, param1OnClickListener);
      return this;
    }
    
    public Builder a(boolean param1Boolean) {
      BluedAlertDialog.a(this.a, param1Boolean);
      this.d = true;
      return this;
    }
    
    public BluedAlertDialog a() {
      if (!this.e && this.c)
        BluedAlertDialog.a(this.a, 1); 
      if (!this.f)
        this.b = 1; 
      if (!this.d && this.c)
        BluedAlertDialog.a(this.a, true); 
      if (BluedAlertDialog.c(this.a) != 1) {
        BluedAlertDialog.b(this.a, true);
        if (!this.g)
          BluedAlertDialog.c(this.a, true); 
        BluedAlertDialog bluedAlertDialog = this.a;
        BluedAlertDialog.b(bluedAlertDialog, DensityUtils.a(BluedAlertDialog.d(bluedAlertDialog), 10.0F));
      } else {
        BluedAlertDialog.b(this.a, false);
        if (!this.g)
          BluedAlertDialog.c(this.a, false); 
        BluedAlertDialog.c(this.a, BluedAlertDialog.a()[this.b]);
        BluedAlertDialog.a(this.a, BluedAlertDialog.b()[this.b]);
        BluedAlertDialog bluedAlertDialog = this.a;
        BluedAlertDialog.d(bluedAlertDialog, DensityUtils.a(BluedAlertDialog.d(bluedAlertDialog), 20.0F));
        if (this.b == 3) {
          bluedAlertDialog = this.a;
          BluedAlertDialog.e(bluedAlertDialog, DensityUtils.a(BluedAlertDialog.d(bluedAlertDialog), 25.0F));
        } 
      } 
      if (!this.g && BluedAlertDialog.e(this.a)) {
        BluedAlertDialog bluedAlertDialog = this.a;
        BluedAlertDialog.b(bluedAlertDialog, DensityUtils.a(BluedAlertDialog.d(bluedAlertDialog), 0.0F));
      } 
      return this.a;
    }
    
    public Builder b(int param1Int) {
      this.b = param1Int;
      this.f = true;
      return this;
    }
    
    public Builder b(CharSequence param1CharSequence) {
      if (param1CharSequence == null)
        return this; 
      BluedAlertDialog.b(this.a, param1CharSequence);
      return this;
    }
    
    public Builder b(CharSequence param1CharSequence, DialogInterface.OnClickListener param1OnClickListener) {
      if (param1CharSequence == null)
        return this; 
      BluedAlertDialog.d(this.a, param1CharSequence);
      BluedAlertDialog.b(this.a, param1OnClickListener);
      return this;
    }
    
    public Builder b(boolean param1Boolean) {
      this.g = true;
      BluedAlertDialog.c(this.a, param1Boolean);
      return this;
    }
    
    public Builder c(int param1Int) {
      if (param1Int == 0)
        return this; 
      this.c = true;
      BluedAlertDialog.f(this.a, param1Int);
      return this;
    }
  }
  
  public static interface DIALOG_DETAILED_BUTTON_TYPE {}
  
  public static interface DIALOG_TYPE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DialogDetailedButtonTypeDef {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DialogTypeDef {}
  
  public static class SimpleAdapter extends RecyclerView.Adapter<SimpleHolder> {
    private List<String> a;
    
    private DialogInterface.OnClickListener b;
    
    public SimpleAdapter(List<String> param1List, DialogInterface.OnClickListener param1OnClickListener) {
      this.a = param1List;
      this.b = param1OnClickListener;
    }
    
    public BluedAlertDialog.SimpleHolder a(ViewGroup param1ViewGroup, int param1Int) {
      return new BluedAlertDialog.SimpleHolder(LayoutInflater.from(param1ViewGroup.getContext()).inflate(R.layout.item_blued_alert_dialog, null));
    }
    
    public void a(BluedAlertDialog.SimpleHolder param1SimpleHolder, int param1Int) {
      BluedAlertDialog.SimpleHolder.a(param1SimpleHolder).setText(this.a.get(param1Int));
      BluedAlertDialog.SimpleHolder.a(param1SimpleHolder).setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param2View) {
              BluedAlertDialog.SimpleAdapter.a(this.a);
            }
          });
    }
    
    public int getItemCount() {
      List<String> list = this.a;
      return (list == null) ? 0 : list.size();
    }
  }
  
  class null implements View.OnClickListener {
    null(BluedAlertDialog this$0) {}
    
    public void onClick(View param1View) {
      BluedAlertDialog.SimpleAdapter.a(this.a);
    }
  }
  
  public static class SimpleHolder extends RecyclerView.ViewHolder {
    private TextView p;
    
    public SimpleHolder(View param1View) {
      super(param1View);
      this.p = (TextView)param1View.findViewById(R.id.tv_item);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\same\tip\dialog\BluedAlertDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */