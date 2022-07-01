package com.google.zxing;

public final class ChecksumException extends ReaderException {
  private static final ChecksumException c;
  
  static {
    ChecksumException checksumException = new ChecksumException();
    c = checksumException;
    checksumException.setStackTrace(b);
  }
  
  public static ChecksumException a() {
    return a ? new ChecksumException() : c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\ChecksumException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */