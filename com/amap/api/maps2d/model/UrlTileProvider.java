package com.amap.api.maps2d.model;

import com.amap.api.mapcore2d.ck;
import com.amap.api.mapcore2d.cm;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
  private final int a;
  
  private final int b;
  
  public UrlTileProvider(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  private static long a(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    byte[] arrayOfByte = new byte[4096];
    for (long l = 0L;; l += i) {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        return l; 
      paramOutputStream.write(arrayOfByte, 0, i);
    } 
  }
  
  private static byte[] a(InputStream paramInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
  }
  
  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3) {
    URL uRL = getTileUrl(paramInt1, paramInt2, paramInt3);
    if (uRL == null)
      return NO_TILE; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("url: ");
    stringBuilder.append(uRL.toString());
    ck.a("UrlTileProvider", stringBuilder.toString(), 111);
    try {
      return new Tile(this.a, this.b, a(uRL.openStream()));
    } catch (IOException iOException) {
      cm.a(iOException, "UrlTileProvider", "getTile");
      return NO_TILE;
    } 
  }
  
  public int getTileHeight() {
    return this.b;
  }
  
  public abstract URL getTileUrl(int paramInt1, int paramInt2, int paramInt3);
  
  public int getTileWidth() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\UrlTileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */