package ar.com.hjg.pngj;

import java.io.IOException;
import java.io.InputStream;

public class BufferedStreamFeeder {
  private InputStream a;
  
  private byte[] b;
  
  private int c;
  
  private int d;
  
  private boolean e = false;
  
  private boolean f = true;
  
  private boolean g = false;
  
  public BufferedStreamFeeder(InputStream paramInputStream) {
    this(paramInputStream, 8192);
  }
  
  public BufferedStreamFeeder(InputStream paramInputStream, int paramInt) {
    this.a = paramInputStream;
    int i = paramInt;
    if (paramInt < 1)
      i = 8192; 
    this.b = new byte[i];
  }
  
  public int a(IBytesConsumer paramIBytesConsumer) {
    return a(paramIBytesConsumer, 2147483647);
  }
  
  public int a(IBytesConsumer paramIBytesConsumer, int paramInt) {
    if (this.c == 0)
      a(); 
    if (paramInt < 0 || paramInt >= this.c)
      paramInt = this.c; 
    int i = 0;
    if (paramInt > 0) {
      paramInt = paramIBytesConsumer.a(this.b, this.d, paramInt);
      i = paramInt;
      if (paramInt > 0) {
        this.d += paramInt;
        this.c -= paramInt;
        i = paramInt;
      } 
    } 
    if (i < 1) {
      if (!this.g)
        return i; 
      throw new PngjInputException("Failed to feed bytes (premature ending?)");
    } 
    return i;
  }
  
  protected void a() {
    if (this.c <= 0) {
      if (this.e)
        return; 
      try {
        this.d = 0;
        this.c = this.a.read(this.b);
        if (this.c < 0)
          b(); 
        return;
      } catch (IOException iOException) {
        throw new PngjInputException(iOException);
      } 
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void b() {
    this.e = true;
    this.b = null;
    this.c = 0;
    this.d = 0;
    InputStream inputStream = this.a;
    if (inputStream != null && this.f)
      try {
        inputStream.close();
      } catch (Exception exception) {} 
    this.a = null;
  }
  
  public void b(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public boolean b(IBytesConsumer paramIBytesConsumer, int paramInt) {
    while (paramInt > 0) {
      int i = a(paramIBytesConsumer, paramInt);
      if (i < 1)
        return false; 
      paramInt -= i;
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\BufferedStreamFeeder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */