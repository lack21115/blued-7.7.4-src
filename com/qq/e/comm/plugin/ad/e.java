package com.qq.e.comm.plugin.ad;

public enum e {
  a(1, 1),
  b(2, 3),
  c(3, 8),
  d(4, 1),
  e(5, 1),
  f(7, 1),
  g(8, 1),
  h(6, 9),
  i(9, 1),
  j(10, 1),
  k(11, 1),
  l(12, 1),
  m(13, 1),
  n(14, 1),
  o(15, 1),
  p(16, 1),
  q(17, 1),
  r(18, 1),
  s(19, 1),
  t(20, 1),
  u(21, 1),
  v(22, 1),
  w(23, 1),
  x(24, 1);
  
  private int y;
  
  private int z;
  
  static {
    A = new e[] { 
        a, b, c, d, e, f, g, h, i, j, 
        k, l, m, n, o, p, q, r, s, t, 
        u, v, w, x };
  }
  
  e(int paramInt1, int paramInt2) {
    this.y = paramInt1;
    this.z = paramInt2;
    ordinal();
  }
  
  public static e a(String paramString) {
    return "banner".equals(paramString) ? a : ("appwall".equals(paramString) ? c : ("inter".equals(paramString) ? b : ("splash".equals(paramString) ? d : ("feeds".equals(paramString) ? e : ("nativemediaad".equals(paramString) ? f : ("gdtnativead".equals(paramString) ? g : ("grid".equals(paramString) ? h : ("nativeexpressad".equals(paramString) ? i : ("contentad".equals(paramString) ? j : ("rewardvideoad".equals(paramString) ? k : ("nativeunifiedad".equals(paramString) ? l : ("banner2".equals(paramString) ? m : ("inter2".equals(paramString) ? n : ("rose".equals(paramString) ? o : ("premovie".equals(paramString) ? p : ("pause".equals(paramString) ? q : ("postmovie".equals(paramString) ? r : ("ending".equals(paramString) ? s : ("highlight".equals(paramString) ? t : ("idle".equals(paramString) ? u : ("inter2fs".equals(paramString) ? v : ("EXPRESS2".equals(paramString) ? w : ("rewardvideoad2".equals(paramString) ? x : null)))))))))))))))))))))));
  }
  
  public static e[] a() {
    return (e[])A.clone();
  }
  
  public int b() {
    return this.y;
  }
  
  public int c() {
    return this.z;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ad\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */