package com.huawei.updatesdk.b.g;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.huawei.updatesdk.service.otaupdate.g;

public class a {
  private b a;
  
  private Context b;
  
  private String c;
  
  private CharSequence d;
  
  private AlertDialog e;
  
  private AlertDialog.Builder f;
  
  private DialogInterface.OnShowListener g;
  
  private DialogInterface.OnDismissListener h;
  
  protected a(Context paramContext, String paramString, CharSequence paramCharSequence) {
    AlertDialog.Builder builder;
    this.b = paramContext;
    this.c = paramString;
    this.d = paramCharSequence;
    if (com.huawei.updatesdk.a.a.c.h.b.g()) {
      builder = new AlertDialog.Builder(paramContext);
    } else if (((paramContext.getResources().getConfiguration()).uiMode & 0x30) == 32 && Build.VERSION.SDK_INT >= 29) {
      builder = new AlertDialog.Builder(paramContext, 16974545);
    } else {
      builder = new AlertDialog.Builder(paramContext, 16974546);
    } 
    this.f = builder;
    this.f.setTitle(this.c);
    this.f.setPositiveButton(g.e(paramContext, "upsdk_third_app_dl_sure_cancel_download"), null);
    this.f.setNegativeButton(g.e(paramContext, "upsdk_cancel"), null);
    this.f.setMessage(this.d);
  }
  
  public static a a(Context paramContext, String paramString, CharSequence paramCharSequence) {
    return (paramContext instanceof Activity && ((Activity)paramContext).isFinishing()) ? new c(paramContext, paramString, paramCharSequence) : new a(paramContext, paramString, paramCharSequence);
  }
  
  public void a() {
    try {
      if (this.e != null) {
        this.e.dismiss();
        this.e = null;
        return;
      } 
    } catch (IllegalArgumentException illegalArgumentException) {
      com.huawei.updatesdk.a.a.b.a.a.a.a("BaseAlertDialog", "dialog dismiss IllegalArgumentException");
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    if (com.huawei.updatesdk.b.f.a.d().a() >= 11) {
      Button button = null;
      AlertDialog alertDialog = this.e;
      if (alertDialog != null)
        button = alertDialog.getButton(-1); 
      if (button != null) {
        button.setBackgroundResource(paramInt1);
        button.setTextColor(this.b.getResources().getColor(paramInt2));
      } 
    } 
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener) {
    this.h = paramOnDismissListener;
  }
  
  public void a(DialogInterface.OnKeyListener paramOnKeyListener) {
    AlertDialog alertDialog = this.e;
    if (alertDialog != null)
      alertDialog.setOnKeyListener(paramOnKeyListener); 
  }
  
  public void a(DialogInterface.OnShowListener paramOnShowListener) {
    this.g = paramOnShowListener;
  }
  
  public void a(View paramView) {
    if (this.f != null) {
      if (com.huawei.updatesdk.b.f.a.d().a() >= 17) {
        ImageView imageView = (ImageView)paramView.findViewById(g.c(paramView.getContext(), "divider"));
        if (imageView != null)
          imageView.setVisibility(8); 
      } 
      this.f.setMessage(null);
      this.f.setView(paramView);
    } 
  }
  
  public void a(c paramc, String paramString) {
    byte b1;
    AlertDialog alertDialog = this.e;
    if (alertDialog == null)
      return; 
    if (paramc == c.a) {
      b1 = -1;
    } else if (paramc == c.b) {
      b1 = -2;
    } else {
      paramc = null;
      if (paramc == null)
        return; 
    } 
    Button button = alertDialog.getButton(b1);
    if (button == null)
      return; 
  }
  
  public void a(d paramd) {
    String str;
    Boolean bool;
    Context context2 = this.b;
    if (context2 == null || ((Activity)context2).isFinishing()) {
      if (paramd != null)
        paramd.a(); 
      return;
    } 
    if (!b())
      try {
        this.e = this.f.create();
        this.e.setCanceledOnTouchOutside(false);
        this.e.setOnShowListener(new a(this));
        this.e.setOnDismissListener(new b(this));
        this.e.show();
        this.e.getButton(-1).requestFocus();
        return;
      } catch (Exception exception) {
        if (paramd != null)
          paramd.a(); 
        com.huawei.updatesdk.a.a.b.a.a.a.a("BaseAlertDialog", "show dlg error, e: ", exception);
        return;
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("show dlg error, mContext = ");
    stringBuilder.append(this.b);
    stringBuilder.append(", mContext.isFinishing is ");
    Context context1 = this.b;
    if (context1 == null) {
      str = "mContext == null";
    } else {
      bool = Boolean.valueOf(((Activity)str).isFinishing());
    } 
    stringBuilder.append(bool);
    com.huawei.updatesdk.a.a.b.a.a.a.b("BaseAlertDialog", stringBuilder.toString());
  }
  
  public void a(b paramb) {
    this.a = paramb;
  }
  
  public void a(boolean paramBoolean) {
    AlertDialog alertDialog = this.e;
    if (alertDialog != null)
      alertDialog.setCancelable(paramBoolean); 
  }
  
  public boolean b() {
    AlertDialog alertDialog = this.e;
    return (alertDialog != null && alertDialog.isShowing());
  }
  
  public void c() {
    AlertDialog.Builder builder = this.f;
    if (builder == null)
      return; 
    builder.setNegativeButton(null, null);
  }
  
  class a implements DialogInterface.OnShowListener {
    a(a this$0) {}
    
    public void onShow(DialogInterface param1DialogInterface) {
      AlertDialog alertDialog = (AlertDialog)param1DialogInterface;
      alertDialog.getButton(-1).setOnClickListener(new a(this));
      Button button = alertDialog.getButton(-2);
      if (button != null)
        button.setOnClickListener(new b(this)); 
      if (a.b(this.a) != null)
        a.b(this.a).onShow(param1DialogInterface); 
    }
    
    class a implements View.OnClickListener {
      a(a.a this$0) {}
      
      public void onClick(View param2View) {
        if (a.a(this.a.a) != null)
          a.a(this.a.a).a(); 
      }
    }
    
    class b implements View.OnClickListener {
      b(a.a this$0) {}
      
      public void onClick(View param2View) {
        if (a.a(this.a.a) != null)
          a.a(this.a.a).b(); 
      }
    }
  }
  
  class a implements View.OnClickListener {
    a(a this$0) {}
    
    public void onClick(View param1View) {
      if (a.a(this.a.a) != null)
        a.a(this.a.a).a(); 
    }
  }
  
  class b implements View.OnClickListener {
    b(a this$0) {}
    
    public void onClick(View param1View) {
      if (a.a(this.a.a) != null)
        a.a(this.a.a).b(); 
    }
  }
  
  class b implements DialogInterface.OnDismissListener {
    b(a this$0) {}
    
    public void onDismiss(DialogInterface param1DialogInterface) {
      if (a.c(this.a) != null)
        a.c(this.a).onDismiss(param1DialogInterface); 
    }
  }
  
  public enum c {
    a, b;
  }
  
  public static interface d {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */