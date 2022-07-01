package com.google.common.base;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Strings {
  private static String a(@NullableDecl Object paramObject) {
    if (paramObject == null)
      return "null"; 
    try {
      return paramObject.toString();
    } catch (Exception exception) {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramObject.getClass().getName());
      stringBuilder2.append('@');
      stringBuilder2.append(Integer.toHexString(System.identityHashCode(paramObject)));
      paramObject = stringBuilder2.toString();
      Logger logger = Logger.getLogger("com.google.common.base.Strings");
      Level level = Level.WARNING;
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("Exception during lenientFormat for ");
      stringBuilder3.append((String)paramObject);
      logger.log(level, stringBuilder3.toString(), exception);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("<");
      stringBuilder1.append((String)paramObject);
      stringBuilder1.append(" threw ");
      stringBuilder1.append(exception.getClass().getName());
      stringBuilder1.append(">");
      return stringBuilder1.toString();
    } 
  }
  
  @NullableDecl
  public static String a(@NullableDecl String paramString) {
    return Platform.b(paramString);
  }
  
  public static String a(@NullableDecl String paramString, @NullableDecl Object... paramVarArgs) {
    Object[] arrayOfObject;
    String str = String.valueOf(paramString);
    int k = 0;
    if (paramVarArgs == null) {
      arrayOfObject = new Object[1];
      arrayOfObject[0] = "(Object[])null";
    } else {
      int m = 0;
      while (true) {
        arrayOfObject = paramVarArgs;
        if (m < paramVarArgs.length) {
          paramVarArgs[m] = a(paramVarArgs[m]);
          m++;
          continue;
        } 
        break;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder(str.length() + arrayOfObject.length * 16);
    int j = 0;
    int i;
    for (i = k; i < arrayOfObject.length; i++) {
      k = str.indexOf("%s", j);
      if (k == -1)
        break; 
      stringBuilder.append(str, j, k);
      stringBuilder.append(arrayOfObject[i]);
      j = k + 2;
    } 
    stringBuilder.append(str, j, str.length());
    if (i < arrayOfObject.length) {
      stringBuilder.append(" [");
      j = i + 1;
      stringBuilder.append(arrayOfObject[i]);
      for (i = j; i < arrayOfObject.length; i++) {
        stringBuilder.append(", ");
        stringBuilder.append(arrayOfObject[i]);
      } 
      stringBuilder.append(']');
    } 
    return stringBuilder.toString();
  }
  
  public static boolean b(@NullableDecl String paramString) {
    return Platform.a(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Strings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */