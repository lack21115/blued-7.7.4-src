package com.huawei.hms.update.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.a.a.a;
import com.huawei.hms.update.a.a.b;
import com.huawei.hms.update.a.a.c;
import com.huawei.hms.update.b.a;
import com.huawei.hms.update.b.b;
import com.huawei.hms.update.provider.UpdateProvider;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.FileUtil;
import com.huawei.hms.utils.IOUtils;
import java.io.File;
import java.io.IOException;

public class d implements a {
  private final Context a;
  
  private final com.huawei.hms.update.b.d b = (com.huawei.hms.update.b.d)new b();
  
  private final a c = new a();
  
  private b d;
  
  private File e;
  
  public d(Context paramContext) {
    this.a = paramContext.getApplicationContext();
  }
  
  private b a(File paramFile, int paramInt, String paramString) throws IOException {
    return new b(this, paramFile, paramInt, paramInt, paramString) {
        private long d = 0L;
        
        private int e = d.a(this.c).b();
        
        private void a(int param1Int) {
          d.a(this.c).a(this.c.b(), param1Int, this.b);
          d.a(this.c, 2100, param1Int, this.a);
        }
        
        public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
          super.write(param1ArrayOfbyte, param1Int1, param1Int2);
          this.e += param1Int2;
          if (this.e > 209715200)
            return; 
          long l = System.currentTimeMillis();
          if (Math.abs(l - this.d) > 1000L) {
            this.d = l;
            a(this.e);
          } 
          param1Int1 = this.e;
          if (param1Int1 == this.a)
            a(param1Int1); 
        }
      };
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Lcom/huawei/hms/update/a/a/b;
    //   6: ifnull -> 25
    //   9: aload_0
    //   10: getfield d : Lcom/huawei/hms/update/a/a/b;
    //   13: iload_1
    //   14: iload_2
    //   15: iload_3
    //   16: aload_0
    //   17: getfield e : Ljava/io/File;
    //   20: invokeinterface a : (IIILjava/io/File;)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: astore #4
    //   30: aload_0
    //   31: monitorexit
    //   32: aload #4
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	28	finally
  }
  
  private void a(b paramb) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield d : Lcom/huawei/hms/update/a/a/b;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void a() {
    HMSLog.i("UpdateDownload", "Enter cancel.");
    a((b)null);
    this.b.b();
  }
  
  public void a(b paramb, c paramc) {
    Checker.checkNonNull(paramb, "callback must not be null.");
    HMSLog.i("UpdateDownload", "Enter downloadPackage.");
    a(paramb);
    if (paramc == null || !paramc.a()) {
      HMSLog.e("UpdateDownload", "In downloadPackage, Invalid update info.");
      a(2201, 0, 0);
      return;
    } 
    if (!"mounted".equals(Environment.getExternalStorageState())) {
      HMSLog.e("UpdateDownload", "In downloadPackage, Invalid external storage for downloading file.");
      a(2204, 0, 0);
      return;
    } 
    String str = paramc.b;
    if (TextUtils.isEmpty(str)) {
      HMSLog.e("UpdateDownload", "In DownloadHelper.downloadPackage, Download the package,  packageName is null: ");
      a(2201, 0, 0);
      return;
    } 
    Context context = this.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(".apk");
    this.e = UpdateProvider.getLocalFile(context, stringBuilder.toString());
    File file = this.e;
    if (file == null) {
      HMSLog.e("UpdateDownload", "In downloadPackage, Failed to get local file for downloading.");
      a(2204, 0, 0);
      return;
    } 
    file = file.getParentFile();
    if (file == null || (!file.mkdirs() && !file.isDirectory())) {
      HMSLog.e("UpdateDownload", "In downloadPackage, Failed to create directory for downloading file.");
      a(2201, 0, 0);
      return;
    } 
    if (file.getUsableSpace() < (paramc.d * 3)) {
      HMSLog.e("UpdateDownload", "In downloadPackage, No space for downloading file.");
      a(2203, 0, 0);
      return;
    } 
    try {
      a(paramc);
      return;
    } catch (a a1) {
      HMSLog.w("UpdateDownload", "In downloadPackage, Canceled to download the update file.");
      a(2101, 0, 0);
      return;
    } 
  }
  
  void a(c paramc) throws a {
    HMSLog.i("UpdateDownload", "Enter downloadPackage.");
    b b4 = null;
    b b5 = null;
    b b1 = null;
    b b3 = b4;
    b b2 = b5;
    try {
      String str = paramc.b;
      b3 = b4;
      b2 = b5;
      if (TextUtils.isEmpty(str)) {
        b3 = b4;
        b2 = b5;
        HMSLog.e("UpdateDownload", "In DownloadHelper.downloadPackage, Download the package,  packageName is null: ");
        b3 = b4;
        b2 = b5;
        a(2201, 0, 0);
      } else {
        b3 = b4;
        b2 = b5;
        this.c.a(b(), str);
        b3 = b4;
        b2 = b5;
        if (this.c.b(paramc.c, paramc.d, paramc.e)) {
          b3 = b4;
          b2 = b5;
          if (this.c.b() == this.c.a()) {
            b3 = b4;
            b2 = b5;
            if (FileUtil.verifyHash(paramc.e, this.e)) {
              b3 = b4;
              b2 = b5;
              a(2000, 0, 0);
            } else {
              b3 = b4;
              b2 = b5;
              this.c.a(paramc.c, paramc.d, paramc.e);
              b3 = b4;
              b2 = b5;
              b1 = a(this.e, paramc.d, str);
              b3 = b1;
              b2 = b1;
            } 
          } else {
            b3 = b4;
            b2 = b5;
            b1 = a(this.e, paramc.d, str);
            b3 = b1;
            b2 = b1;
            b1.a(this.c.b());
            b3 = b1;
            b2 = b1;
          } 
        } else {
          b3 = b4;
          b2 = b5;
          this.c.a(paramc.c, paramc.d, paramc.e);
          b3 = b4;
          b2 = b5;
          b1 = a(this.e, paramc.d, str);
          b3 = b1;
          b2 = b1;
        } 
      } 
      this.b.a();
      IOUtils.closeQuietly(b1);
      return;
    } catch (IOException iOException) {
      b3 = b2;
      StringBuilder stringBuilder = new StringBuilder();
      b3 = b2;
      stringBuilder.append("In DownloadHelper.downloadPackage, Failed to download.");
      b3 = b2;
      stringBuilder.append(iOException.getMessage());
      b3 = b2;
      HMSLog.e("UpdateDownload", stringBuilder.toString());
      b3 = b2;
      a(2201, 0, 0);
      b1 = b2;
    } finally {}
    this.b.a();
    IOUtils.closeQuietly(b1);
  }
  
  public Context b() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\update\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */