package com.geetest.onelogin.i;

import android.os.AsyncTask;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.f.b;
import com.geetest.onelogin.listener.d;

public class a extends AsyncTask<String, Void, Boolean> {
  private d a;
  
  private d b;
  
  private long c;
  
  private long d;
  
  private volatile boolean e = false;
  
  public a(d paramd, long paramLong, d paramd1) {
    this.a = paramd;
    this.b = paramd1;
    this.d = paramLong;
  }
  
  private boolean a() {
    return (System.currentTimeMillis() - this.c >= this.d);
  }
  
  protected Boolean a(String... paramVarArgs) {
    if (isCancelled())
      return Boolean.valueOf(false); 
    this.c = System.currentTimeMillis();
    this.e = false;
    while (true) {
      if (!b.w().m().b() && !a()) {
        try {
          if (!isCancelled())
            Thread.sleep(50L); 
        } catch (Exception exception) {}
        continue;
      } 
      return Boolean.valueOf(b.w().m().b());
    } 
  }
  
  protected void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue()) {
      d d1 = this.b;
      if (d1 != null)
        d1.a(this.a); 
    } 
    this.e = true;
  }
  
  protected void onCancelled() {
    super.onCancelled();
    this.e = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */