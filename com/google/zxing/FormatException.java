package com.google.zxing;

public final class FormatException extends ReaderException {
  private static final FormatException c;
  
  static {
    FormatException formatException = new FormatException();
    c = formatException;
    formatException.setStackTrace(b);
  }
  
  private FormatException() {}
  
  private FormatException(Throwable paramThrowable) {
    super(paramThrowable);
  }
  
  public static FormatException a() {
    return a ? new FormatException() : c;
  }
  
  public static FormatException a(Throwable paramThrowable) {
    return a ? new FormatException(paramThrowable) : c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\FormatException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */