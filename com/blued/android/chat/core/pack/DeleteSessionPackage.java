package com.blued.android.chat.core.pack;

import android.util.Pair;
import com.blued.android.chat.utils.BytesUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeleteSessionPackage extends DeleteBasePackage {
  private final DeleteHeader deleteHeader;
  
  private final List<Pair<Short, Long>> sessionPairList;
  
  public DeleteSessionPackage(List<Pair<Short, Long>> paramList, long paramLong, boolean paramBoolean) {
    super(paramLong);
    this.deleteHeader = new DeleteHeader((short)2, paramBoolean);
    this.sessionPairList = paramList;
  }
  
  public DeleteSessionPackage(short paramShort, long paramLong1, long paramLong2, boolean paramBoolean) {
    super(paramLong2);
    this.deleteHeader = new DeleteHeader((short)2, paramBoolean);
    this.sessionPairList = new ArrayList<Pair<Short, Long>>();
    this.sessionPairList.add(new Pair(Short.valueOf(paramShort), Long.valueOf(paramLong1)));
  }
  
  protected BytesData msgDataToByte() {
    int j = this.sessionPairList.size();
    int i = 5;
    BytesData bytesData = new BytesData((short)(j * 5 + 5));
    bytesData.data[0] = this.deleteHeader.toByte();
    BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
    for (Pair<Short, Long> pair : this.sessionPairList) {
      BytesUtils.numberTo1Byte(bytesData.data, i, ((Short)pair.first).shortValue());
      BytesUtils.numberTo4Bytes(bytesData.data, ++i, ((Long)pair.second).longValue());
      i += 4;
    } 
    return bytesData;
  }
  
  public String toString() {
    Iterator<Pair<Short, Long>> iterator = this.sessionPairList.iterator();
    String str;
    for (str = ""; iterator.hasNext(); str = stringBuilder1.toString()) {
      Pair pair = iterator.next();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append(" <sessionType:");
      stringBuilder1.append(pair.first);
      stringBuilder1.append(", sessionId:");
      stringBuilder1.append(pair.second);
      stringBuilder1.append("> ");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[DeleteSession, ");
    stringBuilder.append(str);
    stringBuilder.append(", deleteHeader:");
    stringBuilder.append(this.deleteHeader);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\DeleteSessionPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */