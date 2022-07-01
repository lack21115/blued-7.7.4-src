package com.ishumei.l111l11111I1l;

public abstract class l111l11111lIl<T> implements Runnable {
  public T l1111l111111Il = null;
  
  private boolean l111l11111I1l = false;
  
  private boolean l111l11111Il = false;
  
  private int l111l11111lIl = -1;
  
  private long l111l1111l1Il = 0L;
  
  private boolean l111l1111llIl = false;
  
  public l111l11111lIl(boolean paramBoolean, int paramInt) {
    this.l111l11111I1l = paramBoolean;
    this.l111l11111lIl = paramInt;
    this.l111l11111Il = false;
    this.l111l1111l1Il = 0L;
    this.l111l1111llIl = false;
  }
  
  public l111l11111lIl(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
    this.l111l11111I1l = paramBoolean1;
    this.l111l11111lIl = paramInt;
    this.l111l11111Il = paramBoolean2;
    this.l111l1111l1Il = 0L;
    this.l111l1111llIl = false;
  }
  
  public l111l11111lIl(boolean paramBoolean1, int paramInt, boolean paramBoolean2, long paramLong, boolean paramBoolean3) {
    this.l111l11111I1l = paramBoolean1;
    this.l111l11111lIl = paramInt;
    this.l111l11111Il = paramBoolean2;
    this.l111l1111l1Il = paramLong;
    this.l111l1111llIl = paramBoolean3;
  }
  
  public final void l1111l111111Il() {
    if (!this.l111l11111I1l) {
      run();
      return;
    } 
    l1111l111111Il.l111l11111lIl().l1111l111111Il(this, this.l111l11111lIl, this.l111l11111Il, this.l111l1111l1Il, this.l111l1111llIl);
  }
  
  public final void l1111l111111Il(T paramT) {
    this.l1111l111111Il = paramT;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111I1l\l111l11111lIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */