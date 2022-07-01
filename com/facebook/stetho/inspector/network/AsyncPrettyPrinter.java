package com.facebook.stetho.inspector.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public interface AsyncPrettyPrinter {
  PrettyPrinterDisplayType getPrettifiedType();
  
  void printTo(PrintWriter paramPrintWriter, InputStream paramInputStream) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\AsyncPrettyPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */