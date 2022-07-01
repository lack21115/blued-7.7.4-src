package com.google.zxing.common;

import com.google.zxing.FormatException;
import java.util.HashMap;
import java.util.Map;

public enum CharacterSetECI {
  A,
  a(new int[] { 0, 2 }, new String[0]),
  b(new int[] { 1, 3 }, new String[] { "ISO-8859-1" }),
  c(4, new String[] { "ISO-8859-2" }),
  d(5, new String[] { "ISO-8859-3" }),
  e(6, new String[] { "ISO-8859-4" }),
  f(7, new String[] { "ISO-8859-5" }),
  g(8, new String[] { "ISO-8859-6" }),
  h(9, new String[] { "ISO-8859-7" }),
  i(10, new String[] { "ISO-8859-8" }),
  j(11, new String[] { "ISO-8859-9" }),
  k(12, new String[] { "ISO-8859-10" }),
  l(13, new String[] { "ISO-8859-11" }),
  m(15, new String[] { "ISO-8859-13" }),
  n(16, new String[] { "ISO-8859-14" }),
  o(17, new String[] { "ISO-8859-15" }),
  p(18, new String[] { "ISO-8859-16" }),
  q(20, new String[] { "Shift_JIS" }),
  r(21, new String[] { "windows-1250" }),
  s(22, new String[] { "windows-1251" }),
  t(23, new String[] { "windows-1252" }),
  u(24, new String[] { "windows-1256" }),
  v(25, new String[] { "UTF-16BE", "UnicodeBig" }),
  w(26, new String[] { "UTF-8" }),
  x(new int[] { 27, 170 }, new String[] { "US-ASCII" }),
  y(28),
  z(29, new String[] { "GB2312", "EUC_CN", "GBK" });
  
  private static final Map<Integer, CharacterSetECI> B;
  
  private static final Map<String, CharacterSetECI> C;
  
  private final int[] D;
  
  private final String[] E;
  
  static {
    A = new CharacterSetECI("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    F = new CharacterSetECI[] { 
        a, b, c, d, e, f, g, h, i, j, 
        k, l, m, n, o, p, q, r, s, t, 
        u, v, w, x, y, z, A };
    B = new HashMap<Integer, CharacterSetECI>();
    C = new HashMap<String, CharacterSetECI>();
    for (CharacterSetECI characterSetECI : values()) {
      for (int i : characterSetECI.D)
        B.put(Integer.valueOf(i), characterSetECI); 
      C.put(characterSetECI.name(), characterSetECI);
      for (String str : characterSetECI.E)
        C.put(str, characterSetECI); 
    } 
  }
  
  CharacterSetECI(int paramInt1, String... paramVarArgs) {
    this.D = new int[] { paramInt1 };
    this.E = paramVarArgs;
  }
  
  CharacterSetECI(int[] paramArrayOfint, String... paramVarArgs) {
    this.D = paramArrayOfint;
    this.E = paramVarArgs;
  }
  
  public static CharacterSetECI a(int paramInt) throws FormatException {
    if (paramInt >= 0 && paramInt < 900)
      return B.get(Integer.valueOf(paramInt)); 
    throw FormatException.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\CharacterSetECI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */