package com.facebook.stetho.inspector.helper;

import android.view.ViewDebug;

public class IntegerFormatter {
  private static IntegerFormatter cachedFormatter;
  
  private IntegerFormatter() {}
  
  public static IntegerFormatter getInstance() {
    // Byte code:
    //   0: getstatic com/facebook/stetho/inspector/helper/IntegerFormatter.cachedFormatter : Lcom/facebook/stetho/inspector/helper/IntegerFormatter;
    //   3: ifnonnull -> 59
    //   6: ldc com/facebook/stetho/inspector/helper/IntegerFormatter
    //   8: monitorenter
    //   9: getstatic com/facebook/stetho/inspector/helper/IntegerFormatter.cachedFormatter : Lcom/facebook/stetho/inspector/helper/IntegerFormatter;
    //   12: ifnonnull -> 47
    //   15: getstatic android/os/Build$VERSION.SDK_INT : I
    //   18: bipush #21
    //   20: if_icmplt -> 37
    //   23: new com/facebook/stetho/inspector/helper/IntegerFormatter$IntegerFormatterWithHex
    //   26: dup
    //   27: aconst_null
    //   28: invokespecial <init> : (Lcom/facebook/stetho/inspector/helper/IntegerFormatter$1;)V
    //   31: putstatic com/facebook/stetho/inspector/helper/IntegerFormatter.cachedFormatter : Lcom/facebook/stetho/inspector/helper/IntegerFormatter;
    //   34: goto -> 47
    //   37: new com/facebook/stetho/inspector/helper/IntegerFormatter
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: putstatic com/facebook/stetho/inspector/helper/IntegerFormatter.cachedFormatter : Lcom/facebook/stetho/inspector/helper/IntegerFormatter;
    //   47: ldc com/facebook/stetho/inspector/helper/IntegerFormatter
    //   49: monitorexit
    //   50: goto -> 59
    //   53: astore_0
    //   54: ldc com/facebook/stetho/inspector/helper/IntegerFormatter
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    //   59: getstatic com/facebook/stetho/inspector/helper/IntegerFormatter.cachedFormatter : Lcom/facebook/stetho/inspector/helper/IntegerFormatter;
    //   62: areturn
    // Exception table:
    //   from	to	target	type
    //   9	34	53	finally
    //   37	47	53	finally
    //   47	50	53	finally
    //   54	57	53	finally
  }
  
  public String format(Integer paramInteger, ViewDebug.ExportedProperty paramExportedProperty) {
    return String.valueOf(paramInteger);
  }
  
  static class IntegerFormatterWithHex extends IntegerFormatter {
    private IntegerFormatterWithHex() {}
    
    public String format(Integer param1Integer, ViewDebug.ExportedProperty param1ExportedProperty) {
      StringBuilder stringBuilder;
      if (param1ExportedProperty != null && param1ExportedProperty.formatToHexString()) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("0x");
        stringBuilder.append(Integer.toHexString(param1Integer.intValue()));
        return stringBuilder.toString();
      } 
      return super.format(param1Integer, (ViewDebug.ExportedProperty)stringBuilder);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\helper\IntegerFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */