package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.core.widget.b;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.g;
import com.ss.android.a.a.a.j;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.c.c;
import java.lang.ref.WeakReference;

public class f implements j {
  private final WeakReference<Context> a;
  
  private String b;
  
  public f(Context paramContext) {
    this.a = new WeakReference<Context>(paramContext);
    this.b = "已开始下载，可在\"我的\"里查看管理";
  }
  
  private AlertDialog a(Activity paramActivity, c paramc) {
    AlertDialog alertDialog2;
    String str;
    if (paramc.j == 1) {
      alertDialog2 = b(paramActivity, paramc);
      alertDialog2.show();
      return alertDialog2;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      str = "Theme.Dialog.TTDownload";
    } else {
      str = "Theme.Dialog.TTDownloadOld";
    } 
    AlertDialog.Builder builder = (new AlertDialog.Builder((Context)alertDialog2, ab.g((Context)alertDialog2, str))).setTitle(paramc.b).setMessage(paramc.c).setPositiveButton(paramc.d, new DialogInterface.OnClickListener(this, paramc) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (this.a.h != null)
              this.a.h.a(param1DialogInterface); 
          }
        }).setNegativeButton(paramc.e, new DialogInterface.OnClickListener(this, paramc) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (this.a.h != null)
              this.a.h.b(param1DialogInterface); 
          }
        }).setOnCancelListener(new DialogInterface.OnCancelListener(this, paramc) {
          public void onCancel(DialogInterface param1DialogInterface) {
            if (this.a.h != null)
              this.a.h.c(param1DialogInterface); 
          }
        });
    if (paramc.g != null)
      builder.setIcon(paramc.g); 
    AlertDialog alertDialog1 = builder.create();
    alertDialog1.show();
    return alertDialog1;
  }
  
  private AlertDialog b(Activity paramActivity, c paramc) {
    return (AlertDialog)(new b((Context)paramActivity)).a(paramc.b).b(paramc.c).c(paramc.d).d(paramc.e).a(paramc.g).a(new b.a(this, paramc) {
          public void a(Dialog param1Dialog) {
            if (this.a.h != null)
              this.a.h.a((DialogInterface)param1Dialog); 
          }
          
          public void b(Dialog param1Dialog) {
            if (this.a.h != null)
              this.a.h.b((DialogInterface)param1Dialog); 
          }
        }).a(new DialogInterface.OnCancelListener(this, paramc) {
          public void onCancel(DialogInterface param1DialogInterface) {
            if (this.a.h != null)
              this.a.h.c(param1DialogInterface); 
          }
        });
  }
  
  private void c(c paramc) {
    g.a a = new g.a(this, paramc) {
        public void a() {
          if (this.a.h != null)
            this.a.h.a(new f.a(this.b)); 
        }
        
        public void b() {
          if (this.a.h != null)
            this.a.h.b(new f.a(this.b)); 
        }
        
        public void c() {
          if (this.a.h != null)
            this.a.h.c(new f.a(this.b)); 
        }
      };
    if (paramc.j == 1) {
      g.a(String.valueOf(paramc.hashCode()), paramc.b, paramc.c, paramc.d, paramc.e, a);
      return;
    } 
    g.a(String.valueOf(paramc.hashCode()), paramc.b, paramc.c, a);
  }
  
  public AlertDialog a(c paramc) {
    if (paramc == null)
      return null; 
    if (paramc.a != null && paramc.a instanceof Activity)
      return a((Activity)paramc.a, paramc); 
    c(paramc);
    return null;
  }
  
  public void a(int paramInt1, Context paramContext, c paramc, String paramString, Drawable paramDrawable, int paramInt2) {
    String str = paramString;
    if (!TextUtils.isEmpty(this.b)) {
      str = paramString;
      if (this.b.equals(paramString))
        str = "已开始下载"; 
    } 
    Toast.makeText(paramContext, str, 0).show();
  }
  
  class a implements DialogInterface {
    a(f this$0) {}
    
    public void cancel() {}
    
    public void dismiss() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\downloadnew\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */