package a.e.j;

import java.io.Writer;

public class a extends Writer {
  public final String b;
  
  public StringBuilder c;
  
  public a(String paramString) {
    new StringBuilder(128);
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a() {
    throw new VerifyError("bad dex opcode");
  }
  
  public void close() {
    throw new VerifyError("bad dex opcode");
  }
  
  public void flush() {
    throw new VerifyError("bad dex opcode");
  }
  
  public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    if (paramInt2 < 0) {
      if (paramArrayOfchar[paramInt1 + 0] == '\n')
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\e\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */