package com.soft.blued.view.tip.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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
import com.soft.blued.utils.StringUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class BluedAlertDialog extends Dialog {
  private static final int[] c = new int[] { 2131233653, 2131233652, 2131233654, 0 };
  
  private static final int[][] d;
  
  private static final int[][] e = new int[][] { { -1, -1 }, { -13264385, -12094209 }, { -5921102, -8814195 }, { -5921102, -5921102 } };
  
  private CharSequence A;
  
  private CharSequence B;
  
  private CharSequence C;
  
  private DialogInterface.OnClickListener D;
  
  private DialogInterface.OnClickListener E;
  
  private DialogInterface.OnCancelListener F;
  
  private DialogInterface.OnDismissListener G;
  
  private RecyclerView.Adapter H;
  
  private DialogInterface.OnClickListener I;
  
  private int J;
  
  private int K;
  
  private int L;
  
  private int[] M;
  
  private int N;
  
  private boolean O = true;
  
  private boolean P = false;
  
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
  
  private BluedAlertDialog(Context paramContext) {
    super(paramContext);
    this.f = paramContext;
  }
  
  private void a(int paramInt1, int paramInt2) {
    this.g.setPadding(0, paramInt1, 0, paramInt2);
  }
  
  private void h() {
    this.g = (LinearLayout)findViewById(2131298775);
    this.h = (ImageView)findViewById(2131297892);
    this.i = (ImageView)findViewById(2131297729);
    this.j = (LinearLayout)findViewById(2131298758);
    this.k = (TextView)findViewById(2131301409);
    this.l = (TextView)findViewById(2131300663);
    this.k.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.l.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.m = findViewById(2131298124);
    this.n = (LinearLayout)findViewById(2131298735);
    this.o = (TextView)findViewById(2131301100);
    this.p = findViewById(2131298121);
    this.q = (TextView)findViewById(2131301185);
    this.r = (LinearLayout)findViewById(2131298734);
    this.s = (TextView)findViewById(2131301184);
    this.t = (TextView)findViewById(2131301099);
    this.u = (RecyclerView)findViewById(2131296931);
    this.v = (FrameLayout)findViewById(2131298766);
    i();
  }
  
  private void i() {
    setCancelable(this.P);
    j();
    k();
    l();
    m();
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
            n();
            p();
            q();
            r();
          } 
        } else {
          this.u.setVisibility(0);
          this.g.setVisibility(8);
          RecyclerView.Adapter adapter = this.H;
          if (adapter != null) {
            this.u.setAdapter(adapter);
          } else {
            this.u.setAdapter(new SimpleAdapter(this.b, this.I));
          } 
        } 
      } else {
        this.u.setVisibility(8);
        this.g.setVisibility(0);
        o();
        s();
        t();
        u();
        v();
        w();
      } 
    } else {
      this.u.setVisibility(8);
      this.g.setVisibility(0);
      n();
      p();
      q();
      r();
    } 
    a(this.J, this.K);
  }
  
  private void j() {
    ImageView imageView = this.h;
    if (imageView == null)
      return; 
    int i = this.x;
    if (i != 0) {
      imageView.setImageResource(i);
      this.h.setVisibility(0);
      return;
    } 
    imageView.setVisibility(8);
  }
  
  private void k() {
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
  
  private void l() {
    if (this.z != null) {
      this.k.setVisibility(0);
      this.k.setText(this.z);
      return;
    } 
    this.k.setVisibility(8);
  }
  
  private void m() {
    if (this.A != null) {
      this.l.setVisibility(0);
      this.l.setText(this.A);
      return;
    } 
    this.l.setVisibility(8);
  }
  
  private void n() {
    this.m.setVisibility(0);
    this.n.setVisibility(0);
    this.r.setVisibility(8);
  }
  
  private void o() {
    this.m.setVisibility(8);
    this.n.setVisibility(8);
    this.r.setVisibility(0);
  }
  
  private void p() {
    if (this.B != null) {
      this.q.setVisibility(0);
      this.q.setText(this.B);
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
  
  private void q() {
    if (this.C != null) {
      this.o.setVisibility(0);
      this.o.setText(this.C);
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
  
  private void r() {
    if (this.B == null || this.C == null) {
      this.p.setVisibility(8);
      this.q.setTextColor(BluedSkinUtils.a(this.f, 2131100838));
      this.o.setTextColor(BluedSkinUtils.a(this.f, 2131100838));
    } 
  }
  
  private void s() {
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
  
  private void t() {
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
  
  private void u() {
    this.t.setBackgroundResource(this.L);
  }
  
  private void v() {
    ColorStateList colorStateList = new ColorStateList(d, this.M);
    this.t.setTextColor(colorStateList);
  }
  
  private void w() {
    int i = this.N;
    if (i != 0)
      this.t.setHeight(i); 
  }
  
  public ViewGroup a() {
    return (ViewGroup)this.v;
  }
  
  public void a(float paramFloat) {
    if (this.x != 0) {
      ImageView imageView = this.h;
      if (imageView != null) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = DensityUtils.a(this.f, paramFloat);
        this.h.setLayoutParams(layoutParams);
      } 
    } 
  }
  
  public void a(int paramInt) {
    if (this.y) {
      ImageView imageView = this.i;
      if (imageView != null)
        imageView.setImageResource(paramInt); 
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.y = paramBoolean;
    k();
  }
  
  public TextView b() {
    return this.k;
  }
  
  public TextView c() {
    return this.l;
  }
  
  public void cancel() {
    super.cancel();
    DialogInterface.OnCancelListener onCancelListener = this.F;
    if (onCancelListener != null)
      onCancelListener.onCancel((DialogInterface)this); 
  }
  
  public View d() {
    return (View)this.i;
  }
  
  public void dismiss() {
    super.dismiss();
    DialogInterface.OnDismissListener onDismissListener = this.G;
    if (onDismissListener != null)
      onDismissListener.onDismiss((DialogInterface)this); 
  }
  
  public TextView e() {
    return this.l;
  }
  
  public void onCreate(Bundle paramBundle) {
    setContentView(2131492979);
    h();
    Window window = getWindow();
    if (window != null)
      window.setBackgroundDrawableResource(17170445); 
  }
  
  static {
    int[] arrayOfInt = { 16842919 };
    d = new int[][] { { -16842919 }, arrayOfInt };
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
        if (StringUtils.e(param1CharSequence.toString()))
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
        BluedAlertDialog.c(this.a, BluedAlertDialog.f()[this.b]);
        BluedAlertDialog.a(this.a, BluedAlertDialog.g()[this.b]);
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
      return new BluedAlertDialog.SimpleHolder(LayoutInflater.from(param1ViewGroup.getContext()).inflate(2131493426, null));
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
      this.p = (TextView)param1View.findViewById(2131300926);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\view\tip\dialog\BluedAlertDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */