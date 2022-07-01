package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.charset.Charset;

@Immutable
abstract class AbstractCompositeHashFunction extends AbstractHashFunction {
  final HashFunction[] a;
  
  private Hasher b(Hasher[] paramArrayOfHasher) {
    return new Hasher(this, paramArrayOfHasher) {
        public HashCode a() {
          return this.b.a(this.a);
        }
        
        public Hasher a(int param1Int) {
          Hasher[] arrayOfHasher = this.a;
          int j = arrayOfHasher.length;
          for (int i = 0; i < j; i++)
            arrayOfHasher[i].a(param1Int); 
          return this;
        }
        
        public Hasher a(long param1Long) {
          Hasher[] arrayOfHasher = this.a;
          int j = arrayOfHasher.length;
          for (int i = 0; i < j; i++)
            arrayOfHasher[i].a(param1Long); 
          return this;
        }
        
        public Hasher a(CharSequence param1CharSequence) {
          Hasher[] arrayOfHasher = this.a;
          int j = arrayOfHasher.length;
          for (int i = 0; i < j; i++)
            arrayOfHasher[i].a(param1CharSequence); 
          return this;
        }
        
        public Hasher a(CharSequence param1CharSequence, Charset param1Charset) {
          Hasher[] arrayOfHasher = this.a;
          int j = arrayOfHasher.length;
          for (int i = 0; i < j; i++)
            arrayOfHasher[i].a(param1CharSequence, param1Charset); 
          return this;
        }
        
        public <T> Hasher a(T param1T, Funnel<? super T> param1Funnel) {
          Hasher[] arrayOfHasher = this.a;
          int j = arrayOfHasher.length;
          for (int i = 0; i < j; i++)
            arrayOfHasher[i].a(param1T, param1Funnel); 
          return this;
        }
        
        public Hasher b(byte param1Byte) {
          Hasher[] arrayOfHasher = this.a;
          int j = arrayOfHasher.length;
          for (int i = 0; i < j; i++)
            arrayOfHasher[i].b(param1Byte); 
          return this;
        }
        
        public Hasher b(byte[] param1ArrayOfbyte) {
          Hasher[] arrayOfHasher = this.a;
          int j = arrayOfHasher.length;
          for (int i = 0; i < j; i++)
            arrayOfHasher[i].b(param1ArrayOfbyte); 
          return this;
        }
        
        public Hasher b(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
          Hasher[] arrayOfHasher = this.a;
          int j = arrayOfHasher.length;
          int i;
          for (i = 0; i < j; i++)
            arrayOfHasher[i].b(param1ArrayOfbyte, param1Int1, param1Int2); 
          return this;
        }
      };
  }
  
  abstract HashCode a(Hasher[] paramArrayOfHasher);
  
  public Hasher a() {
    Hasher[] arrayOfHasher = new Hasher[this.a.length];
    for (int i = 0; i < arrayOfHasher.length; i++)
      arrayOfHasher[i] = this.a[i].a(); 
    return b(arrayOfHasher);
  }
  
  public Hasher a(int paramInt) {
    boolean bool;
    int i = 0;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    Hasher[] arrayOfHasher = new Hasher[this.a.length];
    while (i < arrayOfHasher.length) {
      arrayOfHasher[i] = this.a[i].a(paramInt);
      i++;
    } 
    return b(arrayOfHasher);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\AbstractCompositeHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */