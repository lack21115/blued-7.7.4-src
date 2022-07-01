package com.amap.api.mapcore2d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.amap.api.maps2d.AMapException;
import com.amap.api.maps2d.model.TileProvider;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

class bw extends bj<ArrayList<bs>, ArrayList<bs>> {
  private an f = null;
  
  private TileProvider g;
  
  public bw(ArrayList<bs> paramArrayList, TileProvider paramTileProvider) {
    super(paramArrayList);
    this.g = paramTileProvider;
    a(cy.a(ar.a));
    a(5000);
    b(50000);
  }
  
  private void a(bs parambs, int paramInt) {
    if (parambs != null) {
      if (paramInt < 0)
        return; 
      an an1 = this.f;
      if (an1 != null) {
        if (an1.p == null)
          return; 
        bn<bs> bn = this.f.p;
        synchronized (this.f) {
          int j = bn.size();
          for (int i = 0;; i++) {
            if (i < j)
              if (i < bn.size()) {
                bs bs1 = bn.get(i);
                if (bs1 != null && bs1.equals(parambs)) {
                  bs1.h = paramInt;
                } else {
                  continue;
                } 
              } else {
                continue;
              }  
            return;
          } 
        } 
      } 
    } 
  }
  
  private byte[] a(Bitmap paramBitmap) {
    try {
      return byteArrayOutputStream.toByteArray();
    } finally {
      paramBitmap = null;
      cm.a((Throwable)paramBitmap, "TileServerHandler", "Bitmap2Bytes");
    } 
  }
  
  public int a(byte[] paramArrayOfbyte, bs parambs) {
    if (parambs != null) {
      if (paramArrayOfbyte == null)
        return -1; 
      an an1 = this.f;
      if (an1 != null) {
        byte b1;
        if (an1.n == null)
          return -1; 
        try {
          b1 = this.f.n.a(null, paramArrayOfbyte, false, null, parambs.c());
          if (b1 < 0)
            return -1; 
        } finally {
          paramArrayOfbyte = null;
        } 
        cm.a((Throwable)paramArrayOfbyte, "TileServerHandler", "saveImgToMemory");
        byte b2 = b1;
      } 
    } 
    return -1;
  }
  
  public String a(String paramString) {
    StringBuffer stringBuffer = new StringBuffer();
    if (!TextUtils.isEmpty(paramString) && !paramString.startsWith(ax.a().c())) {
      stringBuffer.append("&key=");
      stringBuffer.append(cq.f(ar.a));
    } 
    stringBuffer.append("&channel=amapapi");
    return stringBuffer.toString();
  }
  
  public void a(an paraman) {
    this.f = paraman;
  }
  
  protected ArrayList<bs> b(byte[] paramArrayOfbyte) throws AMapException {
    ArrayList<bs> arrayList4 = this.b;
    ArrayList<bs> arrayList2 = null;
    ArrayList<bs> arrayList3 = null;
    ArrayList<bs> arrayList1 = null;
    if (arrayList4 != null) {
      if (paramArrayOfbyte == null)
        return null; 
      try {
        int j = this.b.size();
        int i = 0;
        return arrayList2;
      } finally {
        paramArrayOfbyte = null;
      } 
    } 
    return arrayList2;
  }
  
  protected byte[] b() throws AMapException {
    TileProvider tileProvider = this.g;
    return (tileProvider != null) ? (tileProvider.getTile(((bs)this.b.get(0)).b, ((bs)this.b.get(0)).c, ((bs)this.b.get(0)).d)).data : super.b();
  }
  
  protected ArrayList<bs> e() {
    ArrayList<bs> arrayList = new ArrayList();
    Iterator<bs> iterator = this.b.iterator();
    while (iterator.hasNext())
      arrayList.add(new bs(iterator.next())); 
    return arrayList;
  }
  
  public Map<String, String> f() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("User-Agent", "AMAP_SDK_Android_2DMap_6.0.0");
    hashMap.put("Accept-Encoding", "gzip");
    hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[] { "6.0.0", "2dmap" }));
    hashMap.put("X-INFO", ct.a(ar.a));
    hashMap.put("key", cq.f(ar.a));
    hashMap.put("logversion", "2.1");
    return (Map)hashMap;
  }
  
  public Map<String, String> g() {
    return null;
  }
  
  public String h() {
    int i = ((bs)this.b.get(0)).b;
    int k = ((bs)this.b.get(0)).c;
    int m = ((bs)this.b.get(0)).d;
    if (q.i == 0 && m > 9 && !cl.a(i, k, m))
      return String.format(Locale.US, ax.a().d(), new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(k) }); 
    int n = (int)Math.pow(2.0D, ((bs)this.b.get(0)).d);
    int j = ((bs)this.b.get(0)).b;
    if (j >= n) {
      i = j - n;
    } else {
      i = j;
      if (j < 0)
        i = j + n; 
    } 
    String str2 = this.f.j.a(i, k, m);
    String str1 = str2;
    if (TextUtils.isEmpty(q.h)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append(a(str2));
      str1 = stringBuilder.toString();
    } 
    ((bs)this.b.get(0)).b();
    return str1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */