package com.facebook.stetho.dumpapp;

import java.util.ArrayList;
import java.util.Iterator;

public class ArgsHelper {
  public static String[] drainToArray(Iterator<String> paramIterator) {
    ArrayList arrayList = new ArrayList();
    while (paramIterator.hasNext())
      arrayList.add(paramIterator.next()); 
    return (String[])arrayList.toArray((Object[])new String[arrayList.size()]);
  }
  
  public static String nextArg(Iterator<String> paramIterator, String paramString) throws DumpUsageException {
    if (paramIterator.hasNext())
      return paramIterator.next(); 
    throw new DumpUsageException(paramString);
  }
  
  public static String nextOptionalArg(Iterator<String> paramIterator, String paramString) {
    if (paramIterator.hasNext())
      paramString = paramIterator.next(); 
    return paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\dumpapp\ArgsHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */