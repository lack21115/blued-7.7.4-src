package com.qq.e.comm.plugin.ac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.plugin.aa.a.a;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.j.a;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;

public class f extends ImageView {
  private Movie a;
  
  private long b;
  
  private int c;
  
  private int d;
  
  public f(Context paramContext, String paramString) {
    super(paramContext);
    if (!TextUtils.isEmpty(paramString)) {
      File file = a(paramString);
      if (file != null) {
        this.a = Movie.decodeFile(file.getAbsolutePath());
        Movie movie = this.a;
        if (movie != null) {
          this.c = movie.width();
          this.d = this.a.height();
          return;
        } 
      } else {
        b b = (new b.a()).b(paramString).a(aj.a(paramString)).a(aj.f()).a();
        a.a().a(b, paramString, new a(this) {
              public void a() {
                GDTLogger.d("onStarted");
              }
              
              public void a(long param1Long1, long param1Long2, int param1Int) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("downloading file ---> Progress: ");
                stringBuilder.append(param1Int);
                stringBuilder.append("%");
                GDTLogger.d(stringBuilder.toString());
              }
              
              public void a(long param1Long, boolean param1Boolean) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onConnected isRangeSupport: ");
                stringBuilder.append(param1Boolean);
                stringBuilder.append(", total: ");
                stringBuilder.append(param1Long);
                GDTLogger.d(stringBuilder.toString());
              }
              
              public void a(c param1c) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("file download Failed, code: ");
                stringBuilder.append(param1c.a());
                stringBuilder.append(", msg: ");
                stringBuilder.append(param1c.b());
                GDTLogger.w(stringBuilder.toString(), null);
              }
              
              public void a(File param1File, long param1Long) {
                GDTLogger.d("onCompleted");
                if (param1File != null) {
                  f.a(this.a, Movie.decodeFile(param1File.getAbsolutePath()));
                  if (f.a(this.a) != null) {
                    f f1 = this.a;
                    f.a(f1, f.a(f1).width());
                    f1 = this.a;
                    f.b(f1, f.a(f1).height());
                  } 
                } 
              }
              
              public void b() {}
              
              public void c() {}
            });
      } 
    } 
  }
  
  private File a(String paramString) {
    File file = aj.d(paramString);
    if (file != null) {
      File file1 = file;
      return !file.exists() ? null : file1;
    } 
    return null;
  }
  
  private boolean a(Canvas paramCanvas) {
    long l = SystemClock.uptimeMillis();
    if (this.b == 0L)
      this.b = l; 
    int j = this.a.duration();
    int i = j;
    if (j == 0)
      i = 1000; 
    i = (int)((l - this.b) % i);
    this.a.setTime(i);
    this.a.draw(paramCanvas, 0.0F, 0.0F);
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.a == null) {
      super.onDraw(paramCanvas);
      return;
    } 
    if (!a(paramCanvas))
      invalidate(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (this.a != null)
      setMeasuredDimension(this.c, this.d); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ac\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */