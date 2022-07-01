package com.ss.android.downloadlib.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.e.f;
import com.ss.android.socialbase.appdownloader.c.a;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.k;

public class c extends a {
  private static String a = c.class.getSimpleName();
  
  public k a(Context paramContext) {
    return new k(this, paramContext) {
        private com.ss.android.a.a.c.c.a c = new com.ss.android.a.a.c.c.a(this.a);
        
        private DialogInterface.OnClickListener d;
        
        private DialogInterface.OnClickListener e;
        
        private DialogInterface.OnCancelListener f;
        
        public j a() {
          this.c.a(new com.ss.android.a.a.c.c.b(this) {
                public void a(DialogInterface param2DialogInterface) {
                  if (c.null.a(this.a) != null)
                    c.null.a(this.a).onClick(param2DialogInterface, -1); 
                }
                
                public void b(DialogInterface param2DialogInterface) {
                  if (c.null.b(this.a) != null)
                    c.null.b(this.a).onClick(param2DialogInterface, -2); 
                }
                
                public void c(DialogInterface param2DialogInterface) {
                  if (c.null.c(this.a) != null && param2DialogInterface != null)
                    c.null.c(this.a).onCancel(param2DialogInterface); 
                }
              });
          f.a(c.b(), "getThemedAlertDlgBuilder", null);
          this.c.a(3);
          return new c.a(j.d().b(this.c.a()));
        }
        
        public k a(int param1Int) {
          this.c.a(this.a.getResources().getString(param1Int));
          return this;
        }
        
        public k a(int param1Int, DialogInterface.OnClickListener param1OnClickListener) {
          this.c.c(this.a.getResources().getString(param1Int));
          this.d = param1OnClickListener;
          return this;
        }
        
        public k a(DialogInterface.OnCancelListener param1OnCancelListener) {
          this.f = param1OnCancelListener;
          return this;
        }
        
        public k a(String param1String) {
          this.c.b(param1String);
          return this;
        }
        
        public k a(boolean param1Boolean) {
          this.c.a(param1Boolean);
          return this;
        }
        
        public k b(int param1Int, DialogInterface.OnClickListener param1OnClickListener) {
          this.c.d(this.a.getResources().getString(param1Int));
          this.e = param1OnClickListener;
          return this;
        }
      };
  }
  
  public boolean a() {
    return true;
  }
  
  static class a implements j {
    private Dialog a;
    
    public a(Dialog param1Dialog) {
      if (param1Dialog != null) {
        this.a = param1Dialog;
        a();
      } 
    }
    
    public void a() {
      Dialog dialog = this.a;
      if (dialog != null)
        dialog.show(); 
    }
    
    public boolean b() {
      Dialog dialog = this.a;
      return (dialog != null) ? dialog.isShowing() : false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */