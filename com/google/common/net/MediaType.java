package com.google.common.net;

import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.errorprone.annotations.Immutable;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
public final class MediaType {
  public static final MediaType A;
  
  public static final MediaType B;
  
  public static final MediaType C;
  
  public static final MediaType D;
  
  public static final MediaType E;
  
  public static final MediaType F;
  
  public static final MediaType G;
  
  public static final MediaType H;
  
  public static final MediaType I;
  
  public static final MediaType J;
  
  public static final MediaType K;
  
  public static final MediaType L;
  
  public static final MediaType M;
  
  public static final MediaType N;
  
  public static final MediaType O;
  
  public static final MediaType P;
  
  public static final MediaType Q;
  
  public static final MediaType R;
  
  public static final MediaType S;
  
  public static final MediaType T;
  
  public static final MediaType U;
  
  public static final MediaType V;
  
  public static final MediaType W;
  
  public static final MediaType X;
  
  public static final MediaType Y;
  
  public static final MediaType Z;
  
  public static final MediaType a;
  
  public static final MediaType aA;
  
  public static final MediaType aB;
  
  public static final MediaType aC;
  
  public static final MediaType aD;
  
  public static final MediaType aE;
  
  public static final MediaType aF;
  
  public static final MediaType aG;
  
  public static final MediaType aH;
  
  public static final MediaType aI;
  
  public static final MediaType aJ;
  
  public static final MediaType aK;
  
  public static final MediaType aL;
  
  public static final MediaType aM;
  
  public static final MediaType aN;
  
  public static final MediaType aO;
  
  public static final MediaType aP;
  
  public static final MediaType aQ;
  
  public static final MediaType aR;
  
  public static final MediaType aS;
  
  public static final MediaType aT;
  
  public static final MediaType aU;
  
  public static final MediaType aV;
  
  public static final MediaType aW;
  
  public static final MediaType aX;
  
  public static final MediaType aY;
  
  public static final MediaType aZ;
  
  public static final MediaType aa;
  
  public static final MediaType ab;
  
  public static final MediaType ac;
  
  public static final MediaType ad;
  
  public static final MediaType ae;
  
  public static final MediaType af;
  
  public static final MediaType ag;
  
  public static final MediaType ah;
  
  public static final MediaType ai;
  
  public static final MediaType aj;
  
  public static final MediaType ak;
  
  public static final MediaType al;
  
  public static final MediaType am;
  
  public static final MediaType an;
  
  public static final MediaType ao;
  
  public static final MediaType ap;
  
  public static final MediaType aq;
  
  public static final MediaType ar;
  
  public static final MediaType as;
  
  public static final MediaType at;
  
  public static final MediaType au;
  
  public static final MediaType av;
  
  public static final MediaType aw;
  
  public static final MediaType ax;
  
  public static final MediaType ay;
  
  public static final MediaType az;
  
  public static final MediaType b;
  
  public static final MediaType ba;
  
  public static final MediaType bb;
  
  public static final MediaType bc;
  
  private static final ImmutableListMultimap<String, String> bd = ImmutableListMultimap.d("charset", Ascii.a(Charsets.c.name()));
  
  private static final CharMatcher be = CharMatcher.d().a(CharMatcher.e().f()).a(CharMatcher.b(' ')).a(CharMatcher.b("()<>@,;:\\\"/[]?="));
  
  private static final CharMatcher bf = CharMatcher.d().a(CharMatcher.b("\"\\\r"));
  
  private static final CharMatcher bg = CharMatcher.a(" \t\r\n");
  
  private static final Map<MediaType, MediaType> bh = Maps.c();
  
  private static final Joiner.MapJoiner bo;
  
  public static final MediaType c;
  
  public static final MediaType d;
  
  public static final MediaType e;
  
  public static final MediaType f;
  
  public static final MediaType g;
  
  public static final MediaType h;
  
  public static final MediaType i;
  
  public static final MediaType j;
  
  public static final MediaType k;
  
  public static final MediaType l;
  
  public static final MediaType m;
  
  public static final MediaType n;
  
  public static final MediaType o;
  
  public static final MediaType p;
  
  public static final MediaType q;
  
  public static final MediaType r;
  
  public static final MediaType s;
  
  public static final MediaType t;
  
  public static final MediaType u;
  
  public static final MediaType v;
  
  public static final MediaType w;
  
  public static final MediaType x;
  
  public static final MediaType y;
  
  public static final MediaType z;
  
  private final String bi;
  
  private final String bj;
  
  private final ImmutableListMultimap<String, String> bk;
  
  @LazyInit
  private String bl;
  
  @LazyInit
  private int bm;
  
  @LazyInit
  private Optional<Charset> bn;
  
  static {
    a = a("*", "*");
    b = a("text", "*");
    c = a("image", "*");
    d = a("audio", "*");
    e = a("video", "*");
    f = a("application", "*");
    g = b("text", "cache-manifest");
    h = b("text", "css");
    i = b("text", "csv");
    j = b("text", "html");
    k = b("text", "calendar");
    l = b("text", "plain");
    m = b("text", "javascript");
    n = b("text", "tab-separated-values");
    o = b("text", "vcard");
    p = b("text", "vnd.wap.wml");
    q = b("text", "xml");
    r = b("text", "vtt");
    s = a("image", "bmp");
    t = a("image", "x-canon-crw");
    u = a("image", "gif");
    v = a("image", "vnd.microsoft.icon");
    w = a("image", "jpeg");
    x = a("image", "png");
    y = a("image", "vnd.adobe.photoshop");
    z = b("image", "svg+xml");
    A = a("image", "tiff");
    B = a("image", "webp");
    C = a("image", "heif");
    D = a("image", "jp2");
    E = a("audio", "mp4");
    F = a("audio", "mpeg");
    G = a("audio", "ogg");
    H = a("audio", "webm");
    I = a("audio", "l16");
    J = a("audio", "l24");
    K = a("audio", "basic");
    L = a("audio", "aac");
    M = a("audio", "vorbis");
    N = a("audio", "x-ms-wma");
    O = a("audio", "x-ms-wax");
    P = a("audio", "vnd.rn-realaudio");
    Q = a("audio", "vnd.wave");
    R = a("video", "mp4");
    S = a("video", "mpeg");
    T = a("video", "ogg");
    U = a("video", "quicktime");
    V = a("video", "webm");
    W = a("video", "x-ms-wmv");
    X = a("video", "x-flv");
    Y = a("video", "3gpp");
    Z = a("video", "3gpp2");
    aa = b("application", "xml");
    ab = b("application", "atom+xml");
    ac = a("application", "x-bzip2");
    ad = b("application", "dart");
    ae = a("application", "vnd.apple.pkpass");
    af = a("application", "vnd.ms-fontobject");
    ag = a("application", "epub+zip");
    ah = a("application", "x-www-form-urlencoded");
    ai = a("application", "pkcs12");
    aj = a("application", "binary");
    ak = a("application", "geo+json");
    al = a("application", "x-gzip");
    am = a("application", "hal+json");
    an = b("application", "javascript");
    ao = a("application", "jose");
    ap = a("application", "jose+json");
    aq = b("application", "json");
    ar = b("application", "manifest+json");
    as = a("application", "vnd.google-earth.kml+xml");
    at = a("application", "vnd.google-earth.kmz");
    au = a("application", "mbox");
    av = a("application", "x-apple-aspen-config");
    aw = a("application", "vnd.ms-excel");
    ax = a("application", "vnd.ms-outlook");
    ay = a("application", "vnd.ms-powerpoint");
    az = a("application", "msword");
    aA = a("application", "dash+xml");
    aB = a("application", "wasm");
    aC = a("application", "x-nacl");
    aD = a("application", "x-pnacl");
    aE = a("application", "octet-stream");
    aF = a("application", "ogg");
    aG = a("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
    aH = a("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
    aI = a("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    aJ = a("application", "vnd.oasis.opendocument.graphics");
    aK = a("application", "vnd.oasis.opendocument.presentation");
    aL = a("application", "vnd.oasis.opendocument.spreadsheet");
    aM = a("application", "vnd.oasis.opendocument.text");
    aN = b("application", "opensearchdescription+xml");
    aO = a("application", "pdf");
    aP = a("application", "postscript");
    aQ = a("application", "protobuf");
    aR = b("application", "rdf+xml");
    aS = b("application", "rtf");
    aT = a("application", "font-sfnt");
    aU = a("application", "x-shockwave-flash");
    aV = a("application", "vnd.sketchup.skp");
    aW = b("application", "soap+xml");
    aX = a("application", "x-tar");
    aY = a("application", "font-woff");
    aZ = a("application", "font-woff2");
    ba = b("application", "xhtml+xml");
    bb = b("application", "xrd+xml");
    bc = a("application", "zip");
    bo = Joiner.a("; ").c("=");
  }
  
  private MediaType(String paramString1, String paramString2, ImmutableListMultimap<String, String> paramImmutableListMultimap) {
    this.bi = paramString1;
    this.bj = paramString2;
    this.bk = paramImmutableListMultimap;
  }
  
  private static MediaType a(MediaType paramMediaType) {
    bh.put(paramMediaType, paramMediaType);
    return paramMediaType;
  }
  
  private static MediaType a(String paramString1, String paramString2) {
    MediaType mediaType = a(new MediaType(paramString1, paramString2, ImmutableListMultimap.a()));
    mediaType.bn = Optional.e();
    return mediaType;
  }
  
  private static MediaType b(String paramString1, String paramString2) {
    MediaType mediaType = a(new MediaType(paramString1, paramString2, bd));
    mediaType.bn = Optional.b(Charsets.c);
    return mediaType;
  }
  
  private static String b(String paramString) {
    StringBuilder stringBuilder = new StringBuilder(paramString.length() + 16);
    stringBuilder.append('"');
    for (int i = 0; i < paramString.length(); i++) {
      char c = paramString.charAt(i);
      if (c == '\r' || c == '\\' || c == '"')
        stringBuilder.append('\\'); 
      stringBuilder.append(c);
    } 
    stringBuilder.append('"');
    return stringBuilder.toString();
  }
  
  private Map<String, ImmutableMultiset<String>> b() {
    return Maps.a((Map)this.bk.i(), new Function<Collection<String>, ImmutableMultiset<String>>(this) {
          public ImmutableMultiset<String> a(Collection<String> param1Collection) {
            return ImmutableMultiset.a(param1Collection);
          }
        });
  }
  
  private String c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bi);
    stringBuilder.append('/');
    stringBuilder.append(this.bj);
    if (!this.bk.r()) {
      stringBuilder.append("; ");
      ListMultimap listMultimap = Multimaps.a((ListMultimap)this.bk, new Function<String, String>(this) {
            public String a(String param1String) {
              return (MediaType.a().c(param1String) && !param1String.isEmpty()) ? param1String : MediaType.a(param1String);
            }
          });
      bo.a(stringBuilder, listMultimap.m());
    } 
    return stringBuilder.toString();
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof MediaType) {
      paramObject = paramObject;
      return (this.bi.equals(((MediaType)paramObject).bi) && this.bj.equals(((MediaType)paramObject).bj) && b().equals(paramObject.b()));
    } 
    return false;
  }
  
  public int hashCode() {
    int j = this.bm;
    int i = j;
    if (j == 0) {
      i = Objects.a(new Object[] { this.bi, this.bj, b() });
      this.bm = i;
    } 
    return i;
  }
  
  public String toString() {
    String str2 = this.bl;
    String str1 = str2;
    if (str2 == null) {
      str1 = c();
      this.bl = str1;
    } 
    return str1;
  }
  
  static final class Tokenizer {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\net\MediaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */