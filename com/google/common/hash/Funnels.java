package com.google.common.hash;

import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Funnels {
  enum ByteArrayFunnel implements Funnel<byte[]> {
    a;
    
    public void a(byte[] param1ArrayOfbyte, PrimitiveSink param1PrimitiveSink) {
      param1PrimitiveSink.c(param1ArrayOfbyte);
    }
    
    public String toString() {
      return "Funnels.byteArrayFunnel()";
    }
  }
  
  enum IntegerFunnel implements Funnel<Integer> {
    a;
    
    public void a(Integer param1Integer, PrimitiveSink param1PrimitiveSink) {
      param1PrimitiveSink.b(param1Integer.intValue());
    }
    
    public String toString() {
      return "Funnels.integerFunnel()";
    }
  }
  
  enum LongFunnel implements Funnel<Long> {
    a;
    
    public void a(Long param1Long, PrimitiveSink param1PrimitiveSink) {
      param1PrimitiveSink.b(param1Long.longValue());
    }
    
    public String toString() {
      return "Funnels.longFunnel()";
    }
  }
  
  static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
    private final Funnel<E> a;
    
    public void a(Iterable<? extends E> param1Iterable, PrimitiveSink param1PrimitiveSink) {
      // Byte code:
      //   0: aload_1
      //   1: invokeinterface iterator : ()Ljava/util/Iterator;
      //   6: astore_1
      //   7: aload_1
      //   8: invokeinterface hasNext : ()Z
      //   13: ifeq -> 37
      //   16: aload_1
      //   17: invokeinterface next : ()Ljava/lang/Object;
      //   22: astore_3
      //   23: aload_0
      //   24: getfield a : Lcom/google/common/hash/Funnel;
      //   27: aload_3
      //   28: aload_2
      //   29: invokeinterface a : (Ljava/lang/Object;Lcom/google/common/hash/PrimitiveSink;)V
      //   34: goto -> 7
      //   37: return
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof SequentialFunnel) {
        param1Object = param1Object;
        return this.a.equals(((SequentialFunnel)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return SequentialFunnel.class.hashCode() ^ this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Funnels.sequentialFunnel(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class SinkAsStream extends OutputStream {
    final PrimitiveSink a;
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Funnels.asOutputStream(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
    
    public void write(int param1Int) {
      this.a.c((byte)param1Int);
    }
    
    public void write(byte[] param1ArrayOfbyte) {
      this.a.c(param1ArrayOfbyte);
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      this.a.c(param1ArrayOfbyte, param1Int1, param1Int2);
    }
  }
  
  static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
    private final Charset a;
    
    public void a(CharSequence param1CharSequence, PrimitiveSink param1PrimitiveSink) {
      param1PrimitiveSink.b(param1CharSequence, this.a);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof StringCharsetFunnel) {
        param1Object = param1Object;
        return this.a.equals(((StringCharsetFunnel)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return StringCharsetFunnel.class.hashCode() ^ this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Funnels.stringFunnel(");
      stringBuilder.append(this.a.name());
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
    
    static class SerializedForm implements Serializable {}
  }
  
  static class SerializedForm implements Serializable {}
  
  enum UnencodedCharsFunnel implements Funnel<CharSequence> {
    a;
    
    public void a(CharSequence param1CharSequence, PrimitiveSink param1PrimitiveSink) {
      param1PrimitiveSink.b(param1CharSequence);
    }
    
    public String toString() {
      return "Funnels.unencodedCharsFunnel()";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\Funnels.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */