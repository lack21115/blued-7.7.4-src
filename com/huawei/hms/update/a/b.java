package com.huawei.hms.update.a;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class b extends OutputStream {
  private RandomAccessFile a;
  
  public b(File paramFile, int paramInt) {
    try {
      this.a = new RandomAccessFile(paramFile, "rwd");
      this.a.setLength(paramInt);
      return;
    } catch (FileNotFoundException fileNotFoundException) {
      HMSLog.e("RandomFileOutputStream", "create  file stream failed");
      return;
    } catch (IOException iOException) {
      IOUtils.closeQuietly(this.a);
      HMSLog.e("RandomFileOutputStream", "create  file stream failed");
      return;
    } 
  }
  
  public void a(long paramLong) throws IOException {
    this.a.seek(paramLong);
  }
  
  public void close() throws IOException {
    this.a.close();
  }
  
  public void write(int paramInt) throws IOException {
    write(new byte[] { (byte)paramInt }, 0, 1);
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    this.a.write(paramArrayOfbyte, paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\update\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */