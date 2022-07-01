package ar.com.hjg.pngj;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class DeflatedChunksSet {
  protected byte[] a;
  
  State b = State.a;
  
  int c = -1;
  
  int d = -1;
  
  public final String e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private Inflater i;
  
  private final boolean j;
  
  private DeflatedChunkReader k;
  
  private boolean l = true;
  
  private long m = 0L;
  
  private long n = 0L;
  
  public DeflatedChunksSet(String paramString, int paramInt1, int paramInt2) {
    this(paramString, paramInt1, paramInt2, null, null);
  }
  
  public DeflatedChunksSet(String paramString, int paramInt1, int paramInt2, Inflater paramInflater, byte[] paramArrayOfbyte) {
    this.e = paramString;
    this.g = paramInt1;
    if (paramInt1 >= 1 && paramInt2 >= paramInt1) {
      if (paramInflater != null) {
        this.i = paramInflater;
        this.j = false;
      } else {
        this.i = new Inflater();
        this.j = true;
      } 
      if (paramArrayOfbyte == null || paramArrayOfbyte.length < paramInt1)
        paramArrayOfbyte = new byte[paramInt2]; 
      this.a = paramArrayOfbyte;
      this.h = -1;
      this.b = State.a;
      try {
        a(paramInt1);
        return;
      } catch (RuntimeException runtimeException) {
        g();
        throw runtimeException;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bad inital row len ");
    stringBuilder.append(paramInt1);
    throw new PngjException(stringBuilder.toString());
  }
  
  private boolean k() {
    try {
      if (this.b != State.b) {
        State state;
        if (this.b.a())
          return false; 
        if (this.a == null || this.a.length < this.g)
          this.a = new byte[this.g]; 
        if (this.f < this.g) {
          boolean bool = this.i.finished();
          if (!bool)
            try {
              int i = this.i.inflate(this.a, this.f, this.g - this.f);
              this.f += i;
              this.n += i;
            } catch (DataFormatException dataFormatException) {
              throw new PngjInputException("error decompressing zlib stream ", dataFormatException);
            }  
        } 
        if (this.f == this.g) {
          state = State.b;
        } else if (!this.i.finished()) {
          state = State.a;
        } else if (this.f > 0) {
          state = State.b;
        } else {
          state = State.c;
        } 
        this.b = state;
        if (this.b == State.b) {
          a();
          return true;
        } 
      } else {
        throw new PngjException("invalid state");
      } 
    } catch (RuntimeException runtimeException) {
      g();
      throw runtimeException;
    } 
    return false;
  }
  
  protected void a() {}
  
  public void a(int paramInt) {
    this.f = 0;
    this.h++;
    if (paramInt < 1) {
      this.g = 0;
      h();
      return;
    } 
    if (this.i.finished()) {
      this.g = 0;
      h();
      return;
    } 
    this.b = State.a;
    this.g = paramInt;
    if (!this.l)
      k(); 
  }
  
  protected void a(DeflatedChunkReader paramDeflatedChunkReader) {
    if (this.e.equals((paramDeflatedChunkReader.a()).c)) {
      this.k = paramDeflatedChunkReader;
      this.c++;
      int i = this.d;
      if (i >= 0)
        paramDeflatedChunkReader.a(this.c + i); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Bad chunk inside IdatSet, id:");
    stringBuilder.append((paramDeflatedChunkReader.a()).c);
    stringBuilder.append(", expected:");
    stringBuilder.append(this.e);
    throw new PngjInputException(stringBuilder.toString());
  }
  
  public void a(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  protected void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.m += paramInt2;
    if (paramInt2 >= 1) {
      if (this.b.a())
        return; 
      if (this.b != State.b) {
        if (!this.i.needsDictionary() && this.i.needsInput()) {
          this.i.setInput(paramArrayOfbyte, paramInt1, paramInt2);
          if (j()) {
            while (k()) {
              a(b());
              if (d())
                c(); 
            } 
          } else {
            k();
          } 
          return;
        } 
        throw new RuntimeException("should not happen");
      } 
      throw new PngjInputException("this should only be called if waitingForMoreInput");
    } 
  }
  
  public boolean a(String paramString) {
    if (this.b.b())
      return false; 
    if (paramString.equals(this.e))
      return true; 
    if (!b(paramString)) {
      if (this.b.a()) {
        if (!e())
          f(); 
        return false;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected chunk ");
      stringBuilder.append(paramString);
      stringBuilder.append(" while ");
      stringBuilder.append(this.e);
      stringBuilder.append(" set is not done");
      throw new PngjInputException(stringBuilder.toString());
    } 
    return true;
  }
  
  protected int b() {
    throw new PngjInputException("not implemented");
  }
  
  public boolean b(String paramString) {
    return false;
  }
  
  protected void c() {}
  
  public boolean d() {
    return this.b.a();
  }
  
  public boolean e() {
    return this.b.b();
  }
  
  protected void f() {
    g();
  }
  
  public void g() {
    try {
      if (!this.b.b())
        this.b = State.d; 
      if (this.j && this.i != null) {
        this.i.end();
        this.i = null;
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void h() {
    if (!d())
      this.b = State.c; 
  }
  
  public int i() {
    return this.h;
  }
  
  public boolean j() {
    return this.l;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("idatSet : ");
    stringBuilder.append((this.k.a()).c);
    stringBuilder.append(" state=");
    stringBuilder.append(this.b);
    stringBuilder.append(" rows=");
    stringBuilder.append(this.h);
    stringBuilder.append(" bytes=");
    stringBuilder.append(this.m);
    stringBuilder.append("/");
    stringBuilder.append(this.n);
    return (new StringBuilder(stringBuilder.toString())).toString();
  }
  
  enum State {
    a, b, c, d;
    
    public boolean a() {
      return (this == c || this == d);
    }
    
    public boolean b() {
      return (this == d);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\DeflatedChunksSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */