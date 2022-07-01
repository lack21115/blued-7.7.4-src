package com.bun.miitmdid.c.j.b;

import android.database.ContentObserver;
import com.bun.lib.a;

public class c extends ContentObserver {
  private String a;
  
  private int b;
  
  private b c;
  
  public c(b paramb, int paramInt, String paramString) {
    super(null);
    this.c = paramb;
    this.b = paramInt;
    this.a = paramString;
  }
  
  public void onChange(boolean paramBoolean) {
    b b1 = this.c;
    if (b1 != null) {
      b1.a(this.b, this.a);
      return;
    } 
    a.a("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\j\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */