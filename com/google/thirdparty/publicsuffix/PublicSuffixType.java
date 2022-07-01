package com.google.thirdparty.publicsuffix;

public enum PublicSuffixType {
  a(':', ','),
  b('!', '?');
  
  private final char c;
  
  private final char d;
  
  PublicSuffixType(char paramChar1, char paramChar2) {
    this.c = paramChar1;
    this.d = paramChar2;
  }
  
  static PublicSuffixType a(char paramChar) {
    PublicSuffixType[] arrayOfPublicSuffixType = values();
    int j = arrayOfPublicSuffixType.length;
    int i = 0;
    while (i < j) {
      PublicSuffixType publicSuffixType = arrayOfPublicSuffixType[i];
      if (publicSuffixType.b() != paramChar) {
        if (publicSuffixType.a() == paramChar)
          return publicSuffixType; 
        i++;
        continue;
      } 
      return publicSuffixType;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No enum corresponding to given code: ");
    stringBuilder.append(paramChar);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  char a() {
    return this.d;
  }
  
  char b() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\thirdparty\publicsuffix\PublicSuffixType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */