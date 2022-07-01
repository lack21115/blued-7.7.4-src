package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;
import com.qiniu.pili.droid.shortvideo.PLGifWatermarkSetting;
import com.qiniu.pili.droid.shortvideo.b.a;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class b extends k {
  private int c;
  
  private int d;
  
  private int e;
  
  private int f = -1;
  
  private long o;
  
  private PLGifWatermarkSetting p;
  
  private List<Integer> q;
  
  private d r;
  
  private a s;
  
  public b(PLGifWatermarkSetting paramPLGifWatermarkSetting) {
    this.p = paramPLGifWatermarkSetting;
  }
  
  private void h() {
    List<Integer> list = this.q;
    if (list != null) {
      if (list.isEmpty())
        return; 
      int[] arrayOfInt = new int[1];
      for (int i = 0; i < this.q.size(); i++) {
        arrayOfInt[0] = ((Integer)this.q.get(i)).intValue();
        GLES20.glDeleteTextures(1, arrayOfInt, 0);
      } 
    } 
  }
  
  public int a(int paramInt, long paramLong) {
    long l = this.o;
    if (l == 0L || paramLong - l >= this.s.b()) {
      if (this.q.size() < this.e) {
        int j = d.a(this.s.e());
        this.q.add(Integer.valueOf(j));
        this.s.a();
      } 
      int i = this.f;
      if (i == this.e - 1) {
        i = 0;
      } else {
        i++;
      } 
      this.f = i;
      this.o = paramLong;
    } 
    return this.r.a(paramInt, ((Integer)this.q.get(this.f)).intValue(), false);
  }
  
  public boolean a(int paramInt1, int paramInt2) {
    this.c = paramInt1;
    this.d = paramInt2;
    return super.a(paramInt1, paramInt2);
  }
  
  public boolean b() {
    e.j.c("GifProcessor", "setup +");
    this.q = new ArrayList<Integer>(0);
    this.s = new a();
    File file = new File(this.p.getFilePath());
    if (!file.exists())
      return false; 
    try {
      FileInputStream fileInputStream = new FileInputStream(file);
      if (this.s.a(fileInputStream, 0) != 0)
        return false; 
      this.e = this.s.c();
      this.s.a();
      this.r = new d(this.s.e().getWidth(), this.s.e().getHeight());
      this.r.b(this.p.getRotation());
      this.r.a(this.p.getAlpha() / 255.0F);
      this.r.b(this.p.getX(), this.p.getY());
      if (this.p.getWidth() > 0.0F && this.p.getHeight() > 0.0F)
        this.r.a(this.p.getWidth(), this.p.getHeight()); 
      this.r.a(this.c, this.d);
      this.r.b();
      e.j.c("GifProcessor", "setup -");
      return true;
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
      return false;
    } 
  }
  
  public void f() {
    e.j.c("GifProcessor", "release +");
    this.r.f();
    this.s = null;
    h();
    this.q = null;
    this.f = -1;
    this.o = 0L;
    super.f();
    e.j.c("GifProcessor", "release -");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */