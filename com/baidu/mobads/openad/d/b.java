package com.baidu.mobads.openad.d;

import android.net.Uri;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class b {
  public String a;
  
  public String b;
  
  public long c = 0L;
  
  public String d = "text/plain";
  
  public int e = 1;
  
  private Uri.Builder f;
  
  public b(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a() {
    return XAdSDKFoundationFacade.getInstance().getURIUitls().getFixedString(this.a);
  }
  
  public void a(int paramInt) {
    this.e = paramInt;
  }
  
  public void a(Uri.Builder paramBuilder) {
    this.f = paramBuilder;
  }
  
  public Uri.Builder b() {
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */