package com.tencent.bugly.yaq.crashreport.crash.anr;

import com.tencent.bugly.yaq.proguard.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

public class TraceFileHelper {
  public TraceFileHelper() {
    throw new VerifyError("bad dex opcode");
  }
  
  private static String a(BufferedReader paramBufferedReader) throws IOException {
    new StringBuffer();
    if (3 < 0)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  private static Object[] a(BufferedReader paramBufferedReader, Pattern... paramVarArgs) throws IOException {
    if (paramBufferedReader == null || paramVarArgs == null)
      return null; 
    throw new VerifyError("bad dex opcode");
  }
  
  private static String b(BufferedReader paramBufferedReader) throws IOException {
    new StringBuffer();
    throw new VerifyError("bad dex opcode");
  }
  
  public static a readFirstDumpInfo(String paramString, boolean paramBoolean) {
    if (paramString == null) {
      x.e("path:%s", new Object[] { paramString });
      return null;
    } 
    readTraceFile(paramString, new b(new a(), paramBoolean) {
          public final boolean a(long param1Long) {
            x.c("process end %d", new Object[] { Long.valueOf(param1Long) });
            return false;
          }
          
          public final boolean a(long param1Long1, long param1Long2, String param1String) {
            x.c("new process %s", new Object[] { param1String });
            throw new VerifyError("bad dex opcode");
          }
          
          public final boolean a(String param1String1, int param1Int, String param1String2, String param1String3) {
            x.c("new thread %s", new Object[] { param1String1 });
            throw new VerifyError("bad dex opcode");
          }
        });
    throw new VerifyError("bad dex opcode");
  }
  
  public static a readTargetDumpInfo(String paramString1, String paramString2, boolean paramBoolean) {
    if (paramString1 == null || paramString2 == null)
      return null; 
    readTraceFile(paramString2, new b(new a(), paramString1, paramBoolean) {
          public final boolean a(long param1Long) {
            x.c("process end %d", new Object[] { Long.valueOf(param1Long) });
            throw new VerifyError("bad dex opcode");
          }
          
          public final boolean a(long param1Long1, long param1Long2, String param1String) {
            x.c("new process %s", new Object[] { param1String });
            throw new VerifyError("bad dex opcode");
          }
          
          public final boolean a(String param1String1, int param1Int, String param1String2, String param1String3) {
            x.c("new thread %s", new Object[] { param1String1 });
            throw new VerifyError("bad dex opcode");
          }
        });
    throw new VerifyError("bad dex opcode");
  }
  
  public static void readTraceFile(String paramString, b paramb) {
    if (paramString == null || paramb == null)
      throw new VerifyError("bad dex opcode"); 
    new File(paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  public static final class a {
    public long a;
    
    public String b;
    
    public long c;
    
    public Map<String, String[]> d;
    
    public a() {
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public static interface b {
    boolean a(long param1Long);
    
    boolean a(long param1Long1, long param1Long2, String param1String);
    
    boolean a(String param1String1, int param1Int, String param1String2, String param1String3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\crash\anr\TraceFileHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */