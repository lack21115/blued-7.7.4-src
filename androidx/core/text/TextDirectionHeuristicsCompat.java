package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;

public final class TextDirectionHeuristicsCompat {
  public static final TextDirectionHeuristicCompat ANYRTL_LTR;
  
  public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
  
  public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
  
  public static final TextDirectionHeuristicCompat LOCALE;
  
  public static final TextDirectionHeuristicCompat LTR = new TextDirectionHeuristicInternal(null, false);
  
  public static final TextDirectionHeuristicCompat RTL = new TextDirectionHeuristicInternal(null, true);
  
  static {
    FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(FirstStrong.a, false);
    FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(FirstStrong.a, true);
    ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.a, false);
    LOCALE = TextDirectionHeuristicLocale.a;
  }
  
  static int a(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1 && paramInt != 2) ? 2 : 0) : 1;
  }
  
  static int b(int paramInt) {
    if (paramInt != 0)
      if (paramInt != 1 && paramInt != 2) {
        switch (paramInt) {
          default:
            return 2;
          case 16:
          case 17:
            return 0;
          case 14:
          case 15:
            break;
        } 
        return 1;
      }  
    return 1;
  }
  
  static class AnyStrong implements TextDirectionAlgorithm {
    static final AnyStrong a = new AnyStrong(true);
    
    private final boolean b;
    
    private AnyStrong(boolean param1Boolean) {
      this.b = param1Boolean;
    }
    
    public int checkRtl(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static class FirstStrong implements TextDirectionAlgorithm {
    static final FirstStrong a = new FirstStrong();
    
    public int checkRtl(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      int j = 2;
      int i;
      for (i = param1Int1; i < param1Int2 + param1Int1 && j == 2; i++)
        j = TextDirectionHeuristicsCompat.b(Character.getDirectionality(param1CharSequence.charAt(i))); 
      return j;
    }
  }
  
  static interface TextDirectionAlgorithm {
    int checkRtl(CharSequence param1CharSequence, int param1Int1, int param1Int2);
  }
  
  static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
    private final TextDirectionHeuristicsCompat.TextDirectionAlgorithm a;
    
    TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat.TextDirectionAlgorithm param1TextDirectionAlgorithm) {
      this.a = param1TextDirectionAlgorithm;
    }
    
    private boolean a(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      param1Int1 = this.a.checkRtl(param1CharSequence, param1Int1, param1Int2);
      return (param1Int1 != 0) ? ((param1Int1 != 1) ? a() : false) : true;
    }
    
    protected abstract boolean a();
    
    public boolean isRtl(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      if (param1CharSequence != null && param1Int1 >= 0 && param1Int2 >= 0 && param1CharSequence.length() - param1Int2 >= param1Int1)
        return (this.a == null) ? a() : a(param1CharSequence, param1Int1, param1Int2); 
      throw new IllegalArgumentException();
    }
    
    public boolean isRtl(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
      return isRtl(CharBuffer.wrap(param1ArrayOfchar), param1Int1, param1Int2);
    }
  }
  
  static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
    private final boolean a;
    
    TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.TextDirectionAlgorithm param1TextDirectionAlgorithm, boolean param1Boolean) {
      super(param1TextDirectionAlgorithm);
      this.a = param1Boolean;
    }
    
    protected boolean a() {
      return this.a;
    }
  }
  
  static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
    static final TextDirectionHeuristicLocale a = new TextDirectionHeuristicLocale();
    
    TextDirectionHeuristicLocale() {
      super(null);
    }
    
    protected boolean a() {
      return (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\text\TextDirectionHeuristicsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */