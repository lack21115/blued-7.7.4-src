package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser implements ImageHeaderParser {
  static final byte[] a = "Exif\000\000".getBytes(Charset.forName("UTF-8"));
  
  private static final int[] b = new int[] { 
      0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 
      8, 4, 8 };
  
  private static int a(int paramInt1, int paramInt2) {
    return paramInt1 + 2 + paramInt2 * 12;
  }
  
  private static int a(RandomAccessReader paramRandomAccessReader) {
    ByteOrder byteOrder;
    short s1 = paramRandomAccessReader.b(6);
    if (s1 != 18761) {
      if (s1 != 19789) {
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown endianness = ");
          stringBuilder.append(s1);
          Log.d("DfltImageHeaderParser", stringBuilder.toString());
        } 
        byteOrder = ByteOrder.BIG_ENDIAN;
      } else {
        byteOrder = ByteOrder.BIG_ENDIAN;
      } 
    } else {
      byteOrder = ByteOrder.LITTLE_ENDIAN;
    } 
    paramRandomAccessReader.a(byteOrder);
    int i = paramRandomAccessReader.a(10) + 6;
    short s2 = paramRandomAccessReader.b(i);
    s1 = 0;
    while (s1 < s2) {
      int k = a(i, s1);
      short s = paramRandomAccessReader.b(k);
      if (s == 274) {
        short s3 = paramRandomAccessReader.b(k + 2);
        if (s3 < 1 || s3 > 12) {
          if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Got invalid format code = ");
            stringBuilder.append(s3);
            Log.d("DfltImageHeaderParser", stringBuilder.toString());
          } 
        } else {
          int m = paramRandomAccessReader.a(k + 4);
          if (m < 0) {
            if (Log.isLoggable("DfltImageHeaderParser", 3))
              Log.d("DfltImageHeaderParser", "Negative tiff component count"); 
          } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Got tagIndex=");
              stringBuilder.append(s1);
              stringBuilder.append(" tagType=");
              stringBuilder.append(s);
              stringBuilder.append(" formatCode=");
              stringBuilder.append(s3);
              stringBuilder.append(" componentCount=");
              stringBuilder.append(m);
              Log.d("DfltImageHeaderParser", stringBuilder.toString());
            } 
            m += b[s3];
            if (m > 4) {
              if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Got byte count > 4, not orientation, continuing, formatCode=");
                stringBuilder.append(s3);
                Log.d("DfltImageHeaderParser", stringBuilder.toString());
              } 
            } else {
              k += 8;
              if (k < 0 || k > paramRandomAccessReader.a()) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("Illegal tagValueOffset=");
                  stringBuilder.append(k);
                  stringBuilder.append(" tagType=");
                  stringBuilder.append(s);
                  Log.d("DfltImageHeaderParser", stringBuilder.toString());
                } 
              } else if (m < 0 || m + k > paramRandomAccessReader.a()) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("Illegal number of bytes for TI tag data tagType=");
                  stringBuilder.append(s);
                  Log.d("DfltImageHeaderParser", stringBuilder.toString());
                } 
              } else {
                return paramRandomAccessReader.b(k);
              } 
            } 
          } 
        } 
      } 
      int j = s1 + 1;
    } 
    return -1;
  }
  
  private int a(Reader paramReader, ArrayPool paramArrayPool) throws IOException {
    try {
      StringBuilder stringBuilder;
      int i = paramReader.b();
      boolean bool = a(i);
      if (!bool) {
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Parser doesn't handle magic number: ");
          stringBuilder.append(i);
          Log.d("DfltImageHeaderParser", stringBuilder.toString());
          return -1;
        } 
      } else {
        i = b((Reader)stringBuilder);
        if (i == -1) {
          if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            return -1;
          } 
        } else {
          byte[] arrayOfByte = (byte[])paramArrayPool.a(i, byte[].class);
          try {
            i = a((Reader)stringBuilder, arrayOfByte, i);
            return i;
          } finally {
            paramArrayPool.a(arrayOfByte);
          } 
        } 
        return -1;
      } 
    } catch (EndOfFileException endOfFileException) {
      return -1;
    } 
    return -1;
  }
  
  private int a(Reader paramReader, byte[] paramArrayOfbyte, int paramInt) throws IOException {
    int i = paramReader.a(paramArrayOfbyte, paramInt);
    if (i != paramInt) {
      if (Log.isLoggable("DfltImageHeaderParser", 3)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to read exif segment data, length: ");
        stringBuilder.append(paramInt);
        stringBuilder.append(", actually read: ");
        stringBuilder.append(i);
        Log.d("DfltImageHeaderParser", stringBuilder.toString());
      } 
      return -1;
    } 
    if (a(paramArrayOfbyte, paramInt))
      return a(new RandomAccessReader(paramArrayOfbyte, paramInt)); 
    if (Log.isLoggable("DfltImageHeaderParser", 3))
      Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble"); 
    return -1;
  }
  
  private ImageHeaderParser.ImageType a(Reader paramReader) throws IOException {
    try {
      int i = paramReader.b();
      if (i == 65496)
        return ImageHeaderParser.ImageType.JPEG; 
      i = i << 8 | paramReader.a();
      if (i == 4671814)
        return ImageHeaderParser.ImageType.GIF; 
      i = i << 8 | paramReader.a();
      if (i == -1991225785) {
        paramReader.a(21L);
        try {
          return (paramReader.a() >= 3) ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        } catch (EndOfFileException endOfFileException) {
          return ImageHeaderParser.ImageType.PNG;
        } 
      } 
      if (i != 1380533830)
        return ImageHeaderParser.ImageType.UNKNOWN; 
      endOfFileException.a(4L);
      if ((endOfFileException.b() << 16 | endOfFileException.b()) != 1464156752)
        return ImageHeaderParser.ImageType.UNKNOWN; 
      i = endOfFileException.b() << 16 | endOfFileException.b();
      if ((i & 0xFFFFFF00) != 1448097792)
        return ImageHeaderParser.ImageType.UNKNOWN; 
      i &= 0xFF;
      if (i == 88) {
        endOfFileException.a(4L);
        return ((endOfFileException.a() & 0x10) != 0) ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
      } 
      if (i == 76) {
        endOfFileException.a(4L);
        return ((endOfFileException.a() & 0x8) != 0) ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
      } 
      return ImageHeaderParser.ImageType.WEBP;
    } catch (EndOfFileException endOfFileException) {
      return ImageHeaderParser.ImageType.UNKNOWN;
    } 
  }
  
  private static boolean a(int paramInt) {
    return ((paramInt & 0xFFD8) == 65496 || paramInt == 19789 || paramInt == 18761);
  }
  
  private boolean a(byte[] paramArrayOfbyte, int paramInt) {
    boolean bool;
    if (paramArrayOfbyte != null && paramInt > a.length) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      paramInt = 0;
      while (true) {
        byte[] arrayOfByte = a;
        if (paramInt < arrayOfByte.length) {
          if (paramArrayOfbyte[paramInt] != arrayOfByte[paramInt])
            return false; 
          paramInt++;
          continue;
        } 
        break;
      } 
    } 
    return bool;
  }
  
  private int b(Reader paramReader) throws IOException {
    while (true) {
      StringBuilder stringBuilder;
      short s = paramReader.a();
      if (s != 255) {
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown segmentId=");
          stringBuilder.append(s);
          Log.d("DfltImageHeaderParser", stringBuilder.toString());
        } 
        return -1;
      } 
      s = stringBuilder.a();
      if (s == 218)
        return -1; 
      if (s == 217) {
        if (Log.isLoggable("DfltImageHeaderParser", 3))
          Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment"); 
        return -1;
      } 
      int i = stringBuilder.b() - 2;
      if (s != 225) {
        long l1 = i;
        long l2 = stringBuilder.a(l1);
        if (l2 != l1) {
          if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to skip enough data, type: ");
            stringBuilder.append(s);
            stringBuilder.append(", wanted to skip: ");
            stringBuilder.append(i);
            stringBuilder.append(", but actually skipped: ");
            stringBuilder.append(l2);
            Log.d("DfltImageHeaderParser", stringBuilder.toString());
          } 
          return -1;
        } 
        continue;
      } 
      return i;
    } 
  }
  
  public int a(InputStream paramInputStream, ArrayPool paramArrayPool) throws IOException {
    return a(new StreamReader((InputStream)Preconditions.a(paramInputStream)), (ArrayPool)Preconditions.a(paramArrayPool));
  }
  
  public ImageHeaderParser.ImageType a(InputStream paramInputStream) throws IOException {
    return a(new StreamReader((InputStream)Preconditions.a(paramInputStream)));
  }
  
  public ImageHeaderParser.ImageType a(ByteBuffer paramByteBuffer) throws IOException {
    return a(new ByteBufferReader((ByteBuffer)Preconditions.a(paramByteBuffer)));
  }
  
  static final class ByteBufferReader implements Reader {
    private final ByteBuffer a;
    
    ByteBufferReader(ByteBuffer param1ByteBuffer) {
      this.a = param1ByteBuffer;
      param1ByteBuffer.order(ByteOrder.BIG_ENDIAN);
    }
    
    public int a(byte[] param1ArrayOfbyte, int param1Int) {
      param1Int = Math.min(param1Int, this.a.remaining());
      if (param1Int == 0)
        return -1; 
      this.a.get(param1ArrayOfbyte, 0, param1Int);
      return param1Int;
    }
    
    public long a(long param1Long) {
      int i = (int)Math.min(this.a.remaining(), param1Long);
      ByteBuffer byteBuffer = this.a;
      byteBuffer.position(byteBuffer.position() + i);
      return i;
    }
    
    public short a() throws DefaultImageHeaderParser.Reader.EndOfFileException {
      if (this.a.remaining() >= 1)
        return (short)(this.a.get() & 0xFF); 
      throw new DefaultImageHeaderParser.Reader.EndOfFileException();
    }
    
    public int b() throws DefaultImageHeaderParser.Reader.EndOfFileException {
      return a() << 8 | a();
    }
  }
  
  static final class RandomAccessReader {
    private final ByteBuffer a;
    
    RandomAccessReader(byte[] param1ArrayOfbyte, int param1Int) {
      this.a = (ByteBuffer)ByteBuffer.wrap(param1ArrayOfbyte).order(ByteOrder.BIG_ENDIAN).limit(param1Int);
    }
    
    private boolean a(int param1Int1, int param1Int2) {
      return (this.a.remaining() - param1Int1 >= param1Int2);
    }
    
    int a() {
      return this.a.remaining();
    }
    
    int a(int param1Int) {
      return a(param1Int, 4) ? this.a.getInt(param1Int) : -1;
    }
    
    void a(ByteOrder param1ByteOrder) {
      this.a.order(param1ByteOrder);
    }
    
    short b(int param1Int) {
      return a(param1Int, 2) ? this.a.getShort(param1Int) : -1;
    }
  }
  
  static interface Reader {
    int a(byte[] param1ArrayOfbyte, int param1Int) throws IOException;
    
    long a(long param1Long) throws IOException;
    
    short a() throws IOException;
    
    int b() throws IOException;
    
    public static final class EndOfFileException extends IOException {
      EndOfFileException() {
        super("Unexpectedly reached end of a file");
      }
    }
  }
  
  public static final class EndOfFileException extends IOException {
    EndOfFileException() {
      super("Unexpectedly reached end of a file");
    }
  }
  
  static final class StreamReader implements Reader {
    private final InputStream a;
    
    StreamReader(InputStream param1InputStream) {
      this.a = param1InputStream;
    }
    
    public int a(byte[] param1ArrayOfbyte, int param1Int) throws IOException {
      int k;
      int j = 0;
      int i = 0;
      while (true) {
        k = i;
        if (j < param1Int) {
          i = this.a.read(param1ArrayOfbyte, j, param1Int - j);
          k = i;
          if (i != -1) {
            j += i;
            continue;
          } 
        } 
        break;
      } 
      if (j == 0) {
        if (k != -1)
          return j; 
        throw new DefaultImageHeaderParser.Reader.EndOfFileException();
      } 
      return j;
    }
    
    public long a(long param1Long) throws IOException {
      if (param1Long < 0L)
        return 0L; 
      long l;
      for (l = param1Long; l > 0L; l -= l1) {
        long l1 = this.a.skip(l);
        if (l1 <= 0L) {
          if (this.a.read() == -1)
            break; 
          l1 = 1L;
        } 
      } 
      return param1Long - l;
    }
    
    public short a() throws IOException {
      int i = this.a.read();
      if (i != -1)
        return (short)i; 
      throw new DefaultImageHeaderParser.Reader.EndOfFileException();
    }
    
    public int b() throws IOException {
      return a() << 8 | a();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\DefaultImageHeaderParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */