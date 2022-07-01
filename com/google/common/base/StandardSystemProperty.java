package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public enum StandardSystemProperty {
  A,
  B,
  a("java.version"),
  b("java.vendor"),
  c("java.vendor.url"),
  d("java.home"),
  e("java.vm.specification.version"),
  f("java.vm.specification.vendor"),
  g("java.vm.specification.name"),
  h("java.vm.version"),
  i("java.vm.vendor"),
  j("java.vm.name"),
  k("java.specification.version"),
  l("java.specification.vendor"),
  m("java.specification.name"),
  n("java.class.version"),
  o("java.class.path"),
  p("java.library.path"),
  q("java.io.tmpdir"),
  r("java.compiler"),
  s("java.ext.dirs"),
  t("os.name"),
  u("os.arch"),
  v("os.version"),
  w("file.separator"),
  x("path.separator"),
  y("line.separator"),
  z("user.name");
  
  private final String C;
  
  static {
    A = new StandardSystemProperty("USER_HOME", 26, "user.home");
    B = new StandardSystemProperty("USER_DIR", 27, "user.dir");
    D = new StandardSystemProperty[] { 
        a, b, c, d, e, f, g, h, i, j, 
        k, l, m, n, o, p, q, r, s, t, 
        u, v, w, x, y, z, A, B };
  }
  
  StandardSystemProperty(String paramString1) {
    this.C = paramString1;
  }
  
  public String a() {
    return this.C;
  }
  
  @NullableDecl
  public String b() {
    return System.getProperty(this.C);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a());
    stringBuilder.append("=");
    stringBuilder.append(b());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\StandardSystemProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */