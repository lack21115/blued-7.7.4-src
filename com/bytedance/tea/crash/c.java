package com.bytedance.tea.crash;

public enum c {
  a("launch"),
  b("java"),
  c("native"),
  d("anr"),
  e("block"),
  f("ensure"),
  g("dart"),
  h("custom_java"),
  i("all");
  
  private String j;
  
  c(String paramString1) {
    this.j = paramString1;
  }
  
  public String a() {
    return this.j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */