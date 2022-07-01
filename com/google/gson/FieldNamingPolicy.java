package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

public enum FieldNamingPolicy implements FieldNamingStrategy {
  IDENTITY {
    public String translateName(Field param1Field) {
      return param1Field.getName();
    }
  },
  LOWER_CASE_WITH_DASHES,
  LOWER_CASE_WITH_DOTS,
  LOWER_CASE_WITH_UNDERSCORES,
  UPPER_CAMEL_CASE {
    public String translateName(Field param1Field) {
      return null.upperCaseFirstLetter(param1Field.getName());
    }
  },
  UPPER_CAMEL_CASE_WITH_SPACES {
    public String translateName(Field param1Field) {
      return null.upperCaseFirstLetter(null.separateCamelCase(param1Field.getName(), " "));
    }
  };
  
  static {
    LOWER_CASE_WITH_UNDERSCORES = new null("LOWER_CASE_WITH_UNDERSCORES", 3);
    LOWER_CASE_WITH_DASHES = new null("LOWER_CASE_WITH_DASHES", 4);
    LOWER_CASE_WITH_DOTS = new null("LOWER_CASE_WITH_DOTS", 5);
    $VALUES = new FieldNamingPolicy[] { IDENTITY, UPPER_CAMEL_CASE, UPPER_CAMEL_CASE_WITH_SPACES, LOWER_CASE_WITH_UNDERSCORES, LOWER_CASE_WITH_DASHES, LOWER_CASE_WITH_DOTS };
  }
  
  static String separateCamelCase(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramString1.length();
    for (int i = 0; i < j; i++) {
      char c = paramString1.charAt(i);
      if (Character.isUpperCase(c) && stringBuilder.length() != 0)
        stringBuilder.append(paramString2); 
      stringBuilder.append(c);
    } 
    return stringBuilder.toString();
  }
  
  static String upperCaseFirstLetter(String paramString) {
    int j = paramString.length();
    int i;
    for (i = 0; !Character.isLetter(paramString.charAt(i)) && i < j - 1; i++);
    char c = paramString.charAt(i);
    if (Character.isUpperCase(c))
      return paramString; 
    c = Character.toUpperCase(c);
    if (i == 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(c);
      stringBuilder1.append(paramString.substring(1));
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString.substring(0, i));
    stringBuilder.append(c);
    stringBuilder.append(paramString.substring(i + 1));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\FieldNamingPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */