package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.InflaterSource;
import okio.Okio;
import okio.Source;

class NameValueBlockReader {
  private int compressedLimit;
  
  private final InflaterSource inflaterSource;
  
  private final BufferedSource source;
  
  public NameValueBlockReader(BufferedSource paramBufferedSource) {
    this.inflaterSource = new InflaterSource((Source)new ForwardingSource((Source)paramBufferedSource) {
          public long read(Buffer param1Buffer, long param1Long) throws IOException {
            if (NameValueBlockReader.this.compressedLimit == 0)
              return -1L; 
            param1Long = super.read(param1Buffer, Math.min(param1Long, NameValueBlockReader.this.compressedLimit));
            if (param1Long == -1L)
              return -1L; 
            NameValueBlockReader.access$022(NameValueBlockReader.this, param1Long);
            return param1Long;
          }
        }new Inflater() {
          public int inflate(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws DataFormatException {
            int j = super.inflate(param1ArrayOfbyte, param1Int1, param1Int2);
            int i = j;
            if (j == 0) {
              i = j;
              if (needsDictionary()) {
                setDictionary(Spdy3.DICTIONARY);
                i = super.inflate(param1ArrayOfbyte, param1Int1, param1Int2);
              } 
            } 
            return i;
          }
        });
    this.source = Okio.buffer((Source)this.inflaterSource);
  }
  
  private void doneReading() throws IOException {
    if (this.compressedLimit > 0) {
      this.inflaterSource.refill();
      if (this.compressedLimit == 0)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("compressedLimit > 0: ");
      stringBuilder.append(this.compressedLimit);
      throw new IOException(stringBuilder.toString());
    } 
  }
  
  private ByteString readByteString() throws IOException {
    int i = this.source.readInt();
    return this.source.readByteString(i);
  }
  
  public void close() throws IOException {
    this.source.close();
  }
  
  public List<Header> readNameValueBlock(int paramInt) throws IOException {
    this.compressedLimit += paramInt;
    int i = this.source.readInt();
    if (i >= 0) {
      if (i <= 1024) {
        ArrayList<Header> arrayList = new ArrayList(i);
        paramInt = 0;
        while (paramInt < i) {
          ByteString byteString1 = readByteString().toAsciiLowercase();
          ByteString byteString2 = readByteString();
          if (byteString1.size() != 0) {
            arrayList.add(new Header(byteString1, byteString2));
            paramInt++;
            continue;
          } 
          throw new IOException("name.size == 0");
        } 
        doneReading();
        return arrayList;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("numberOfPairs > 1024: ");
      stringBuilder1.append(i);
      throw new IOException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("numberOfPairs < 0: ");
    stringBuilder.append(i);
    throw new IOException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\framed\NameValueBlockReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */