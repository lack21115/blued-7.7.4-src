package com.bytedance.sdk.a.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class h {
  public static final h A;
  
  public static final h B;
  
  public static final h C;
  
  public static final h D;
  
  public static final h E;
  
  public static final h F;
  
  public static final h G;
  
  public static final h H;
  
  public static final h I;
  
  public static final h J;
  
  public static final h K;
  
  public static final h L;
  
  public static final h M;
  
  public static final h N;
  
  public static final h O;
  
  public static final h P;
  
  public static final h Q;
  
  public static final h R;
  
  public static final h S;
  
  public static final h T;
  
  public static final h U;
  
  public static final h V;
  
  public static final h W;
  
  public static final h X;
  
  public static final h Y;
  
  public static final h Z;
  
  static final Comparator<String> a = new Comparator<String>() {
      public int a(String param1String1, String param1String2) {
        int j = Math.min(param1String1.length(), param1String2.length());
        int i;
        for (i = 4; i < j; i++) {
          char c1 = param1String1.charAt(i);
          char c2 = param1String2.charAt(i);
          if (c1 != c2)
            return (c1 < c2) ? -1 : 1; 
        } 
        i = param1String1.length();
        j = param1String2.length();
        return (i != j) ? ((i < j) ? -1 : 1) : 0;
      }
    };
  
  public static final h aA;
  
  public static final h aB;
  
  public static final h aC;
  
  public static final h aD;
  
  public static final h aE;
  
  public static final h aF;
  
  public static final h aG;
  
  public static final h aH;
  
  public static final h aI;
  
  public static final h aJ;
  
  public static final h aK;
  
  public static final h aL;
  
  public static final h aM;
  
  public static final h aN;
  
  public static final h aO;
  
  public static final h aP;
  
  public static final h aQ;
  
  public static final h aR;
  
  public static final h aS;
  
  public static final h aT;
  
  public static final h aU;
  
  public static final h aV;
  
  public static final h aW;
  
  public static final h aX;
  
  public static final h aY;
  
  public static final h aZ;
  
  public static final h aa;
  
  public static final h ab;
  
  public static final h ac;
  
  public static final h ad;
  
  public static final h ae;
  
  public static final h af;
  
  public static final h ag;
  
  public static final h ah;
  
  public static final h ai;
  
  public static final h aj;
  
  public static final h ak;
  
  public static final h al;
  
  public static final h am;
  
  public static final h an;
  
  public static final h ao;
  
  public static final h ap;
  
  public static final h aq;
  
  public static final h ar;
  
  public static final h as;
  
  public static final h at;
  
  public static final h au;
  
  public static final h av;
  
  public static final h aw;
  
  public static final h ax;
  
  public static final h ay;
  
  public static final h az;
  
  public static final h b;
  
  public static final h ba;
  
  public static final h bb;
  
  public static final h bc;
  
  public static final h bd;
  
  public static final h be;
  
  public static final h bf;
  
  public static final h bg;
  
  public static final h bh;
  
  public static final h bi;
  
  private static final Map<String, h> bk = new TreeMap<String, h>(a);
  
  public static final h c;
  
  public static final h d;
  
  public static final h e;
  
  public static final h f;
  
  public static final h g;
  
  public static final h h;
  
  public static final h i;
  
  public static final h j;
  
  public static final h k;
  
  public static final h l;
  
  public static final h m;
  
  public static final h n;
  
  public static final h o;
  
  public static final h p;
  
  public static final h q;
  
  public static final h r;
  
  public static final h s;
  
  public static final h t;
  
  public static final h u;
  
  public static final h v;
  
  public static final h w;
  
  public static final h x;
  
  public static final h y;
  
  public static final h z;
  
  final String bj;
  
  static {
    b = a("SSL_RSA_WITH_NULL_MD5", 1);
    c = a("SSL_RSA_WITH_NULL_SHA", 2);
    d = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    e = a("SSL_RSA_WITH_RC4_128_MD5", 4);
    f = a("SSL_RSA_WITH_RC4_128_SHA", 5);
    g = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    h = a("SSL_RSA_WITH_DES_CBC_SHA", 9);
    i = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    j = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    k = a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    l = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    m = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    n = a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    o = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    p = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    q = a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    r = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    s = a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    t = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    u = a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    v = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    w = a("TLS_KRB5_WITH_RC4_128_SHA", 32);
    x = a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    y = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    z = a("TLS_KRB5_WITH_RC4_128_MD5", 36);
    A = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    B = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    C = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    D = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    E = a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    F = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    G = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    H = a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    I = a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    J = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    K = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    L = a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    M = a("TLS_RSA_WITH_NULL_SHA256", 59);
    N = a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    O = a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    P = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    Q = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    R = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    S = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    T = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    U = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    V = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    W = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    X = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    Y = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    Z = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    aa = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    ab = a("TLS_PSK_WITH_RC4_128_SHA", 138);
    ac = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    ad = a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    ae = a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    af = a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    ag = a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    ah = a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    ai = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    aj = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    ak = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    al = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    am = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    an = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    ao = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    ap = a("TLS_FALLBACK_SCSV", 22016);
    aq = a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    ar = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    as = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    at = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    au = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    av = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    aw = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    ax = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    ay = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    az = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    aA = a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    aB = a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    aC = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    aD = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    aE = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    aF = a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    aG = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    aH = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    aI = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    aJ = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    aK = a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    aL = a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    aM = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    aN = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    aO = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    aP = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    aQ = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    aR = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    aS = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    aT = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    aU = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    aV = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    aW = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    aX = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    aY = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    aZ = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    ba = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    bb = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    bc = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    bd = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    be = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    bf = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    bg = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    bh = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    bi = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
  }
  
  private h(String paramString) {
    if (paramString != null) {
      this.bj = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  public static h a(String paramString) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/a/b/h
    //   2: monitorenter
    //   3: getstatic com/bytedance/sdk/a/b/h.bk : Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast com/bytedance/sdk/a/b/h
    //   15: astore_2
    //   16: aload_2
    //   17: astore_1
    //   18: aload_2
    //   19: ifnonnull -> 42
    //   22: new com/bytedance/sdk/a/b/h
    //   25: dup
    //   26: aload_0
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: astore_1
    //   31: getstatic com/bytedance/sdk/a/b/h.bk : Ljava/util/Map;
    //   34: aload_0
    //   35: aload_1
    //   36: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: ldc com/bytedance/sdk/a/b/h
    //   44: monitorexit
    //   45: aload_1
    //   46: areturn
    //   47: astore_0
    //   48: ldc com/bytedance/sdk/a/b/h
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	47	finally
    //   22	42	47	finally
  }
  
  private static h a(String paramString, int paramInt) {
    return a(paramString);
  }
  
  static List<h> a(String... paramVarArgs) {
    ArrayList<h> arrayList = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++)
      arrayList.add(a(paramVarArgs[i])); 
    return Collections.unmodifiableList(arrayList);
  }
  
  public String toString() {
    return this.bj;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */