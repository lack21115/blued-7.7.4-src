package com.qiniu.pili.droid.shortvideo.f;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class i {
  private ArrayList<Boolean> a = new ArrayList<Boolean>();
  
  private ArrayList<ByteBuffer> b = new ArrayList<ByteBuffer>();
  
  public ByteBuffer a(int paramInt) {
    return (paramInt >= 0 && paramInt < this.a.size()) ? this.b.get(paramInt) : null;
  }
  
  public void a() {
    this.a.clear();
    this.b.clear();
  }
  
  public void a(int paramInt1, int paramInt2) {
    for (int j = 0; j < paramInt2; j++) {
      this.a.add(Boolean.valueOf(false));
      this.b.add(ByteBuffer.allocate(paramInt1));
    } 
  }
  
  public int b() {
    for (int j = 0; j < this.a.size(); j++) {
      if (!((Boolean)this.a.get(j)).booleanValue()) {
        this.a.set(j, Boolean.valueOf(true));
        return j;
      } 
    } 
    return -1;
  }
  
  public void b(int paramInt) {
    if (paramInt >= 0 && paramInt < this.a.size()) {
      this.a.set(paramInt, Boolean.valueOf(false));
      ((ByteBuffer)this.b.get(paramInt)).clear();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\f\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */