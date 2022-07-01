package com.ss.android.a.a.c;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.c;
import java.util.Arrays;

public class e {
  public long a = -1L;
  
  public int b = -1;
  
  public long c = -1L;
  
  public long d = -1L;
  
  public String e;
  
  public int f = 0;
  
  public boolean g;
  
  public void a(c paramc) {
    if (paramc == null)
      return; 
    this.a = paramc.g();
    this.b = paramc.q();
    this.d = paramc.Z();
    this.c = paramc.ab();
    this.e = paramc.n();
    a a = paramc.aW();
    if (a != null) {
      this.f = a.a();
    } else {
      this.f = 0;
    } 
    this.g = paramc.x();
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof e && paramObject != null) {
      boolean bool1;
      boolean bool2;
      boolean bool3;
      boolean bool4;
      paramObject = paramObject;
      if (this.a == ((e)paramObject).a) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (this.b == ((e)paramObject).b) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (this.c == ((e)paramObject).c) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      if ((TextUtils.isEmpty(this.e) && TextUtils.isEmpty(((e)paramObject).e)) || (!TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(((e)paramObject).e) && this.e.equals(((e)paramObject).e))) {
        bool4 = true;
      } else {
        bool4 = false;
      } 
      return (bool1 && bool2 && bool3 && bool4);
    } 
    return super.equals(paramObject);
  }
  
  public int hashCode() {
    return Arrays.hashCode(new Object[] { Long.valueOf(this.a), Integer.valueOf(this.b), Long.valueOf(this.c), this.e });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\a\a\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */