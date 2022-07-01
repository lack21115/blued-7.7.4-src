package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class Hpack {
  private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
  
  private static final int PREFIX_4_BITS = 15;
  
  private static final int PREFIX_5_BITS = 31;
  
  private static final int PREFIX_6_BITS = 63;
  
  private static final int PREFIX_7_BITS = 127;
  
  private static final Header[] STATIC_HEADER_TABLE = new Header[] { 
      new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), 
      new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), 
      new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), 
      new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), 
      new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), 
      new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), 
      new Header("www-authenticate", "") };
  
  static {
    NAME_TO_FIRST_INDEX = nameToFirstIndex();
  }
  
  private static ByteString checkLowercase(ByteString paramByteString) throws IOException {
    int j = paramByteString.size();
    int i = 0;
    while (i < j) {
      byte b = paramByteString.getByte(i);
      if (b < 65 || b > 90) {
        i++;
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("PROTOCOL_ERROR response malformed: mixed case name: ");
      stringBuilder.append(paramByteString.utf8());
      throw new IOException(stringBuilder.toString());
    } 
    return paramByteString;
  }
  
  private static Map<ByteString, Integer> nameToFirstIndex() {
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(STATIC_HEADER_TABLE.length);
    int i = 0;
    while (true) {
      Header[] arrayOfHeader = STATIC_HEADER_TABLE;
      if (i < arrayOfHeader.length) {
        if (!linkedHashMap.containsKey((arrayOfHeader[i]).name))
          linkedHashMap.put((STATIC_HEADER_TABLE[i]).name, Integer.valueOf(i)); 
        i++;
        continue;
      } 
      return (Map)Collections.unmodifiableMap(linkedHashMap);
    } 
  }
  
  static final class Reader {
    Header[] dynamicTable = new Header[8];
    
    int dynamicTableByteCount = 0;
    
    int headerCount = 0;
    
    private final List<Header> headerList = new ArrayList<Header>();
    
    private int headerTableSizeSetting;
    
    private int maxDynamicTableByteCount;
    
    int nextHeaderIndex = this.dynamicTable.length - 1;
    
    private final BufferedSource source;
    
    Reader(int param1Int, Source param1Source) {
      this.headerTableSizeSetting = param1Int;
      this.maxDynamicTableByteCount = param1Int;
      this.source = Okio.buffer(param1Source);
    }
    
    private void adjustDynamicTableByteCount() {
      int i = this.maxDynamicTableByteCount;
      int j = this.dynamicTableByteCount;
      if (i < j) {
        if (i == 0) {
          clearDynamicTable();
          return;
        } 
        evictToRecoverBytes(j - i);
      } 
    }
    
    private void clearDynamicTable() {
      this.headerList.clear();
      Arrays.fill((Object[])this.dynamicTable, (Object)null);
      this.nextHeaderIndex = this.dynamicTable.length - 1;
      this.headerCount = 0;
      this.dynamicTableByteCount = 0;
    }
    
    private int dynamicTableIndex(int param1Int) {
      return this.nextHeaderIndex + 1 + param1Int;
    }
    
    private int evictToRecoverBytes(int param1Int) {
      int i = 0;
      boolean bool = false;
      if (param1Int > 0) {
        i = this.dynamicTable.length - 1;
        int j = param1Int;
        param1Int = bool;
        while (i >= this.nextHeaderIndex && j > 0) {
          j -= (this.dynamicTable[i]).hpackSize;
          this.dynamicTableByteCount -= (this.dynamicTable[i]).hpackSize;
          this.headerCount--;
          param1Int++;
          i--;
        } 
        Header[] arrayOfHeader = this.dynamicTable;
        i = this.nextHeaderIndex;
        System.arraycopy(arrayOfHeader, i + 1, arrayOfHeader, i + 1 + param1Int, this.headerCount);
        this.nextHeaderIndex += param1Int;
        i = param1Int;
      } 
      return i;
    }
    
    private ByteString getName(int param1Int) {
      return isStaticHeader(param1Int) ? (Hpack.STATIC_HEADER_TABLE[param1Int]).name : (this.dynamicTable[dynamicTableIndex(param1Int - Hpack.STATIC_HEADER_TABLE.length)]).name;
    }
    
    private void insertIntoDynamicTable(int param1Int, Header param1Header) {
      this.headerList.add(param1Header);
      int j = param1Header.hpackSize;
      int i = j;
      if (param1Int != -1)
        i = j - (this.dynamicTable[dynamicTableIndex(param1Int)]).hpackSize; 
      j = this.maxDynamicTableByteCount;
      if (i > j) {
        clearDynamicTable();
        return;
      } 
      j = evictToRecoverBytes(this.dynamicTableByteCount + i - j);
      if (param1Int == -1) {
        param1Int = this.headerCount;
        Header[] arrayOfHeader = this.dynamicTable;
        if (param1Int + 1 > arrayOfHeader.length) {
          Header[] arrayOfHeader1 = new Header[arrayOfHeader.length * 2];
          System.arraycopy(arrayOfHeader, 0, arrayOfHeader1, arrayOfHeader.length, arrayOfHeader.length);
          this.nextHeaderIndex = this.dynamicTable.length - 1;
          this.dynamicTable = arrayOfHeader1;
        } 
        param1Int = this.nextHeaderIndex;
        this.nextHeaderIndex = param1Int - 1;
        this.dynamicTable[param1Int] = param1Header;
        this.headerCount++;
      } else {
        int k = dynamicTableIndex(param1Int);
        this.dynamicTable[param1Int + k + j] = param1Header;
      } 
      this.dynamicTableByteCount += i;
    }
    
    private boolean isStaticHeader(int param1Int) {
      return (param1Int >= 0 && param1Int <= Hpack.STATIC_HEADER_TABLE.length - 1);
    }
    
    private int readByte() throws IOException {
      return this.source.readByte() & 0xFF;
    }
    
    private void readIndexedHeader(int param1Int) throws IOException {
      if (isStaticHeader(param1Int)) {
        Header header = Hpack.STATIC_HEADER_TABLE[param1Int];
        this.headerList.add(header);
        return;
      } 
      int i = dynamicTableIndex(param1Int - Hpack.STATIC_HEADER_TABLE.length);
      if (i >= 0) {
        Header[] arrayOfHeader = this.dynamicTable;
        if (i <= arrayOfHeader.length - 1) {
          this.headerList.add(arrayOfHeader[i]);
          return;
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Header index too large ");
      stringBuilder.append(param1Int + 1);
      throw new IOException(stringBuilder.toString());
    }
    
    private void readLiteralHeaderWithIncrementalIndexingIndexedName(int param1Int) throws IOException {
      insertIntoDynamicTable(-1, new Header(getName(param1Int), readByteString()));
    }
    
    private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
      insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
    }
    
    private void readLiteralHeaderWithoutIndexingIndexedName(int param1Int) throws IOException {
      ByteString byteString1 = getName(param1Int);
      ByteString byteString2 = readByteString();
      this.headerList.add(new Header(byteString1, byteString2));
    }
    
    private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
      ByteString byteString1 = Hpack.checkLowercase(readByteString());
      ByteString byteString2 = readByteString();
      this.headerList.add(new Header(byteString1, byteString2));
    }
    
    public List<Header> getAndResetHeaderList() {
      ArrayList<Header> arrayList = new ArrayList<Header>(this.headerList);
      this.headerList.clear();
      return arrayList;
    }
    
    void headerTableSizeSetting(int param1Int) {
      this.headerTableSizeSetting = param1Int;
      this.maxDynamicTableByteCount = param1Int;
      adjustDynamicTableByteCount();
    }
    
    int maxDynamicTableByteCount() {
      return this.maxDynamicTableByteCount;
    }
    
    ByteString readByteString() throws IOException {
      boolean bool;
      int i = readByte();
      if ((i & 0x80) == 128) {
        bool = true;
      } else {
        bool = false;
      } 
      i = readInt(i, 127);
      return bool ? ByteString.of(Huffman.get().decode(this.source.readByteArray(i))) : this.source.readByteString(i);
    }
    
    void readHeaders() throws IOException {
      while (!this.source.exhausted()) {
        int i = this.source.readByte() & 0xFF;
        if (i != 128) {
          if ((i & 0x80) == 128) {
            readIndexedHeader(readInt(i, 127) - 1);
            continue;
          } 
          if (i == 64) {
            readLiteralHeaderWithIncrementalIndexingNewName();
            continue;
          } 
          if ((i & 0x40) == 64) {
            readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i, 63) - 1);
            continue;
          } 
          if ((i & 0x20) == 32) {
            this.maxDynamicTableByteCount = readInt(i, 31);
            i = this.maxDynamicTableByteCount;
            if (i >= 0 && i <= this.headerTableSizeSetting) {
              adjustDynamicTableByteCount();
              continue;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid dynamic table size update ");
            stringBuilder.append(this.maxDynamicTableByteCount);
            throw new IOException(stringBuilder.toString());
          } 
          if (i == 16 || i == 0) {
            readLiteralHeaderWithoutIndexingNewName();
            continue;
          } 
          readLiteralHeaderWithoutIndexingIndexedName(readInt(i, 15) - 1);
          continue;
        } 
        throw new IOException("index == 0");
      } 
    }
    
    int readInt(int param1Int1, int param1Int2) throws IOException {
      param1Int1 &= param1Int2;
      if (param1Int1 < param1Int2)
        return param1Int1; 
      param1Int1 = 0;
      while (true) {
        int i = readByte();
        if ((i & 0x80) != 0) {
          param1Int2 += (i & 0x7F) << param1Int1;
          param1Int1 += 7;
          continue;
        } 
        return param1Int2 + (i << param1Int1);
      } 
    }
  }
  
  static final class Writer {
    private final Buffer out;
    
    Writer(Buffer param1Buffer) {
      this.out = param1Buffer;
    }
    
    void writeByteString(ByteString param1ByteString) throws IOException {
      writeInt(param1ByteString.size(), 127, 0);
      this.out.write(param1ByteString);
    }
    
    void writeHeaders(List<Header> param1List) throws IOException {
      int j = param1List.size();
      for (int i = 0; i < j; i++) {
        ByteString byteString = ((Header)param1List.get(i)).name.toAsciiLowercase();
        Integer integer = (Integer)Hpack.NAME_TO_FIRST_INDEX.get(byteString);
        if (integer != null) {
          writeInt(integer.intValue() + 1, 15, 0);
          writeByteString(((Header)param1List.get(i)).value);
        } else {
          this.out.writeByte(0);
          writeByteString(byteString);
          writeByteString(((Header)param1List.get(i)).value);
        } 
      } 
    }
    
    void writeInt(int param1Int1, int param1Int2, int param1Int3) throws IOException {
      if (param1Int1 < param1Int2) {
        this.out.writeByte(param1Int1 | param1Int3);
        return;
      } 
      this.out.writeByte(param1Int3 | param1Int2);
      for (param1Int1 -= param1Int2; param1Int1 >= 128; param1Int1 >>>= 7)
        this.out.writeByte(0x80 | param1Int1 & 0x7F); 
      this.out.writeByte(param1Int1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\framed\Hpack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */