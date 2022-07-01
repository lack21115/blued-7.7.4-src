package com.airbnb.lottie.network;

public enum FileExtension {
  a(".json"),
  b(".zip");
  
  public final String c;
  
  FileExtension(String paramString1) {
    this.c = paramString1;
  }
  
  public String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(".temp");
    stringBuilder.append(this.c);
    return stringBuilder.toString();
  }
  
  public String toString() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\network\FileExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */