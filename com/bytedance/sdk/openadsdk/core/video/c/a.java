package com.bytedance.sdk.openadsdk.core.video.c;

import com.bytedance.sdk.openadsdk.utils.t;

public abstract class a implements c {
  private c.e a;
  
  private c.b b;
  
  private c.a c;
  
  private c.f d;
  
  private c.g e;
  
  private c.c f;
  
  private c.d g;
  
  public void a() {
    this.a = null;
    this.c = null;
    this.b = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
  }
  
  protected final void a(int paramInt) {
    try {
      if (this.c != null)
        return; 
    } finally {
      Exception exception = null;
    } 
  }
  
  protected final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    try {
      if (this.e != null)
        return; 
    } finally {
      Exception exception = null;
    } 
  }
  
  public final void a(c.a parama) {
    this.c = parama;
  }
  
  public final void a(c.b paramb) {
    this.b = paramb;
  }
  
  public final void a(c.c paramc) {
    this.f = paramc;
  }
  
  public final void a(c.d paramd) {
    this.g = paramd;
  }
  
  public final void a(c.e parame) {
    this.a = parame;
  }
  
  public final void a(c.f paramf) {
    this.d = paramf;
  }
  
  public final void a(c.g paramg) {
    this.e = paramg;
  }
  
  protected final boolean a(int paramInt1, int paramInt2) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try {
      return bool1;
    } finally {
      Exception exception = null;
      t.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", exception);
    } 
  }
  
  protected final void b() {
    try {
      if (this.a != null)
        return; 
    } finally {
      Exception exception = null;
    } 
  }
  
  protected final boolean b(int paramInt1, int paramInt2) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try {
      return bool1;
    } finally {
      Exception exception = null;
      t.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", exception);
    } 
  }
  
  protected final void c() {
    try {
      if (this.b != null)
        return; 
    } finally {
      Exception exception = null;
    } 
  }
  
  protected final void d() {
    try {
      if (this.d != null)
        return; 
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */