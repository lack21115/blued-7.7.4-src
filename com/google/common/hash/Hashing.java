package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.util.Arrays;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Hashing {
  static final int a = (int)System.currentTimeMillis();
  
  public static HashFunction a() {
    return Murmur3_128HashFunction.a;
  }
  
  @Immutable
  enum ChecksumType implements ImmutableSupplier<Checksum> {
    a("Hashing.crc32()") {
      public Checksum a() {
        return new CRC32();
      }
    },
    b("Hashing.adler32()") {
      public Checksum a() {
        return new Adler32();
      }
    };
    
    public final HashFunction c;
    
    ChecksumType(String param1String1) {
      this.c = new ChecksumHashFunction(this, 32, param1String1);
    }
  }
  
  enum null {
    public Checksum a() {
      return new CRC32();
    }
  }
  
  enum null {
    public Checksum a() {
      return new Adler32();
    }
  }
  
  static final class ConcatenatedHashFunction extends AbstractCompositeHashFunction {
    HashCode a(Hasher[] param1ArrayOfHasher) {
      byte[] arrayOfByte = new byte[b() / 8];
      int k = param1ArrayOfHasher.length;
      int i = 0;
      int j = 0;
      while (i < k) {
        HashCode hashCode = param1ArrayOfHasher[i].a();
        j += hashCode.a(arrayOfByte, j, hashCode.a() / 8);
        i++;
      } 
      return HashCode.a(arrayOfByte);
    }
    
    public int b() {
      HashFunction[] arrayOfHashFunction = this.a;
      int k = arrayOfHashFunction.length;
      int i = 0;
      int j = 0;
      while (i < k) {
        j += arrayOfHashFunction[i].b();
        i++;
      } 
      return j;
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof ConcatenatedHashFunction) {
        param1Object = param1Object;
        return Arrays.equals((Object[])this.a, (Object[])((ConcatenatedHashFunction)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return Arrays.hashCode((Object[])this.a);
    }
  }
  
  static final class LinearCongruentialGenerator {}
  
  static class Md5Holder {
    static final HashFunction a = new MessageDigestHashFunction("MD5", "Hashing.md5()");
  }
  
  static class Sha1Holder {
    static final HashFunction a = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
  }
  
  static class Sha256Holder {
    static final HashFunction a = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");
  }
  
  static class Sha384Holder {
    static final HashFunction a = new MessageDigestHashFunction("SHA-384", "Hashing.sha384()");
  }
  
  static class Sha512Holder {
    static final HashFunction a = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\Hashing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */