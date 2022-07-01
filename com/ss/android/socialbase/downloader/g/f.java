package com.ss.android.socialbase.downloader.g;

import com.ss.android.socialbase.downloader.e.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class f {
  private BufferedOutputStream a;
  
  private FileDescriptor b;
  
  private RandomAccessFile c;
  
  public f(File paramFile, int paramInt) throws a {
    try {
      this.c = new RandomAccessFile(paramFile, "rw");
      this.b = this.c.getFD();
      if (paramInt > 0) {
        int i = 131072;
        if (paramInt < 8192) {
          paramInt = 8192;
        } else if (paramInt > 131072) {
          paramInt = i;
        } 
        this.a = new BufferedOutputStream(new FileOutputStream(this.c.getFD()), paramInt);
        return;
      } 
      this.a = new BufferedOutputStream(new FileOutputStream(this.c.getFD()));
      return;
    } catch (IOException iOException) {
      throw new a(1039, iOException);
    } 
  }
  
  public void a() throws IOException {
    BufferedOutputStream bufferedOutputStream = this.a;
    if (bufferedOutputStream != null)
      bufferedOutputStream.flush(); 
    FileDescriptor fileDescriptor = this.b;
    if (fileDescriptor != null)
      fileDescriptor.sync(); 
  }
  
  public void a(long paramLong) throws IOException {
    this.c.seek(paramLong);
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    this.a.write(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public void b() throws IOException {
    RandomAccessFile randomAccessFile = this.c;
    if (randomAccessFile != null)
      randomAccessFile.close(); 
    this.a.close();
  }
  
  public void b(long paramLong) throws IOException {
    this.c.setLength(paramLong);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\g\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */