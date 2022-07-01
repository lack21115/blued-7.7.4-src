package com.google.zxing;

public final class NotFoundException extends ReaderException {
  private static final NotFoundException c;
  
  static {
    NotFoundException notFoundException = new NotFoundException();
    c = notFoundException;
    notFoundException.setStackTrace(b);
  }
  
  public static NotFoundException a() {
    return c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\NotFoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */