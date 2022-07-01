package c.t.maploc.lite.tsa;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;

public final class v extends u implements Runnable {
  private j a = null;
  
  private final File b;
  
  private boolean c;
  
  private Handler d;
  
  private HandlerThread e;
  
  private long f = 0L;
  
  private long g = 0L;
  
  private byte[] i = new byte[0];
  
  private volatile List j;
  
  private volatile s k;
  
  private volatile n l;
  
  public v(j paramj) {
    this.a = paramj;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a.a.getExternalFilesDir("data").getAbsolutePath());
    stringBuilder.append("/f_c");
    this.b = new File(stringBuilder.toString());
  }
  
  private void a(int paramInt) {
    Handler handler = this.d;
    if (handler != null)
      handler.obtainMessage(paramInt).sendToTarget(); 
  }
  
  static byte[] a(File paramFile) throws IOException {
    Exception exception1;
    Exception exception2;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte2 = new byte[4096];
    byte[] arrayOfByte1 = null;
    Exception exception3 = null;
    try {
    
    } catch (IOException null) {
    
    } finally {
      exception3 = null;
      paramFile = null;
      exception1 = exception2;
    } 
    try {
      throw exception2;
    } finally {}
    b((Closeable)exception1);
    b((Closeable)paramFile);
    b(byteArrayOutputStream);
    throw exception2;
  }
  
  private static void b(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        return;
      } finally {
        paramCloseable = null;
      }  
  }
  
  private void b(File paramFile) {
    StringBuilder stringBuilder = new StringBuilder("start upload:");
    stringBuilder.append(paramFile.getName());
    stringBuilder.append(",len=");
    stringBuilder.append(paramFile.length());
    (new Thread(new w(this, paramFile))).start();
  }
  
  private boolean d() {
    return (this.c && this.d != null);
  }
  
  public final void a() {
    if (d()) {
      this.d.removeCallbacks(this);
      this.d.postDelayed(this, 300L);
      if (d())
        a(3); 
      a(5);
      a(4);
      c();
    } 
  }
  
  public final void a(Handler paramHandler) {
    synchronized (this.i) {
      boolean bool;
      this.j = null;
      this.k = null;
      this.l = null;
      this.g = 0L;
      this.f = 0L;
      if (this.b.exists() || this.b.mkdirs()) {
        bool = true;
      } else {
        bool = false;
      } 
      this.c = bool;
      if (this.c) {
        this.e = new HandlerThread("fc_thread");
        this.e.start();
        this.d = new x(this, this.e.getLooper());
        this.f = System.currentTimeMillis() - 50000L;
      } 
      return;
    } 
  }
  
  public final void a(n paramn, s params, List paramList) {
    if (this.h && paramn != null) {
      if (System.currentTimeMillis() - paramn.c > 10000L)
        return; 
      synchronized (this.i) {
        this.l = paramn;
        this.k = params;
        this.j = paramList;
        if (d()) {
          boolean bool;
          if (params == null) {
            bool = true;
          } else {
            bool = true;
          } 
          a(bool);
          if (System.currentTimeMillis() - this.g > 10800000L) {
            c();
            return;
          } 
        } 
      } 
    } 
  }
  
  public final String b() {
    return "DcPro";
  }
  
  public final void c() {
    long l = System.currentTimeMillis();
    if (l - this.f < 60000L)
      return; 
    this.g = l;
    a(5);
    try {
      NetworkInfo networkInfo;
      ConnectivityManager connectivityManager = (ConnectivityManager)this.a.a.getSystemService("connectivity");
      if (connectivityManager == null) {
        networkInfo = null;
      } else {
        networkInfo = connectivityManager.getActiveNetworkInfo();
      } 
    } finally {
      Exception exception = null;
    } 
  }
  
  public final void run() {
    if (d()) {
      this.c = false;
      this.d.removeCallbacksAndMessages(null);
      this.d = null;
      HandlerThread handlerThread = this.e;
      if (handlerThread != null) {
        handlerThread.quit();
        this.e = null;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */