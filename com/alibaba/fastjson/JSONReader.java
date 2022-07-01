package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONReaderScanner;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

public class JSONReader implements Closeable {
  private JSONStreamContext context;
  
  private final DefaultJSONParser parser;
  
  public JSONReader(DefaultJSONParser paramDefaultJSONParser) {
    this.parser = paramDefaultJSONParser;
  }
  
  public JSONReader(JSONLexer paramJSONLexer) {
    this(new DefaultJSONParser(paramJSONLexer));
  }
  
  public JSONReader(Reader paramReader) {
    this((JSONLexer)new JSONReaderScanner(paramReader));
  }
  
  private void endStructure() {
    short s;
    this.context = this.context.parent;
    JSONStreamContext jSONStreamContext = this.context;
    if (jSONStreamContext == null)
      return; 
    switch (jSONStreamContext.state) {
      default:
        s = -1;
        break;
      case 1004:
        s = 1005;
        break;
      case 1002:
        s = 1003;
        break;
      case 1001:
      case 1003:
        s = 1002;
        break;
    } 
    if (s != -1)
      this.context.state = s; 
  }
  
  private void readAfter() {
    StringBuilder stringBuilder;
    int i = this.context.state;
    short s = 1002;
    switch (i) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("illegal state : ");
        stringBuilder.append(i);
        throw new JSONException(stringBuilder.toString());
      case 1005:
        s = -1;
        break;
      case 1004:
        s = 1005;
        break;
      case 1002:
        s = 1003;
        break;
      case 1001:
      case 1003:
        break;
    } 
    if (s != -1)
      this.context.state = s; 
  }
  
  private void readBefore() {
    StringBuilder stringBuilder;
    int i = this.context.state;
    switch (i) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("illegal state : ");
        stringBuilder.append(i);
        throw new JSONException(stringBuilder.toString());
      case 1005:
        this.parser.accept(16);
        return;
      case 1003:
        this.parser.accept(16, 18);
        return;
      case 1002:
        this.parser.accept(17);
        break;
      case 1001:
      case 1004:
        break;
    } 
  }
  
  private void startStructure() {
    StringBuilder stringBuilder;
    switch (this.context.state) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("illegal state : ");
        stringBuilder.append(this.context.state);
        throw new JSONException(stringBuilder.toString());
      case 1003:
      case 1005:
        this.parser.accept(16);
        return;
      case 1002:
        this.parser.accept(17);
        break;
      case 1001:
      case 1004:
        break;
    } 
  }
  
  public void close() {
    IOUtils.close((Closeable)this.parser);
  }
  
  public void config(Feature paramFeature, boolean paramBoolean) {
    this.parser.config(paramFeature, paramBoolean);
  }
  
  public void endArray() {
    this.parser.accept(15);
    endStructure();
  }
  
  public void endObject() {
    this.parser.accept(13);
    endStructure();
  }
  
  public boolean hasNext() {
    if (this.context != null) {
      StringBuilder stringBuilder;
      int i = this.parser.lexer.token();
      int j = this.context.state;
      switch (j) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("illegal state : ");
          stringBuilder.append(j);
          throw new JSONException(stringBuilder.toString());
        case 1004:
        case 1005:
          return (i != 15);
        case 1001:
        case 1003:
          break;
      } 
      return (i != 13);
    } 
    throw new JSONException("context is null");
  }
  
  public int peek() {
    if (this.context != null)
      return this.parser.lexer.token(); 
    throw new JSONException("context is null");
  }
  
  public Integer readInteger() {
    Object object;
    if (this.context == null) {
      object = this.parser.parse();
    } else {
      readBefore();
      object = this.parser.parse();
      readAfter();
    } 
    return TypeUtils.castToInt(object);
  }
  
  public Long readLong() {
    Object object;
    if (this.context == null) {
      object = this.parser.parse();
    } else {
      readBefore();
      object = this.parser.parse();
      readAfter();
    } 
    return TypeUtils.castToLong(object);
  }
  
  public Object readObject() {
    Object object;
    if (this.context == null)
      return this.parser.parse(); 
    readBefore();
    int i = this.context.state;
    if (i != 1001 && i != 1003) {
      object = this.parser.parse();
    } else {
      object = this.parser.parseKey();
    } 
    readAfter();
    return object;
  }
  
  public <T> T readObject(TypeReference<T> paramTypeReference) {
    return readObject(paramTypeReference.getType());
  }
  
  public <T> T readObject(Class<T> paramClass) {
    if (this.context == null)
      return (T)this.parser.parseObject(paramClass); 
    readBefore();
    Object object = this.parser.parseObject(paramClass);
    readAfter();
    return (T)object;
  }
  
  public <T> T readObject(Type paramType) {
    if (this.context == null)
      return (T)this.parser.parseObject(paramType); 
    readBefore();
    Object object = this.parser.parseObject(paramType);
    readAfter();
    return (T)object;
  }
  
  public Object readObject(Map paramMap) {
    if (this.context == null)
      return this.parser.parseObject(paramMap); 
    readBefore();
    Object object = this.parser.parseObject(paramMap);
    readAfter();
    return object;
  }
  
  public void readObject(Object paramObject) {
    if (this.context == null) {
      this.parser.parseObject(paramObject);
      return;
    } 
    readBefore();
    this.parser.parseObject(paramObject);
    readAfter();
  }
  
  public String readString() {
    Object object;
    if (this.context == null) {
      object = this.parser.parse();
    } else {
      readBefore();
      object = this.parser.parse();
      readAfter();
    } 
    return TypeUtils.castToString(object);
  }
  
  public void startArray() {
    if (this.context == null) {
      this.context = new JSONStreamContext(null, 1004);
    } else {
      startStructure();
      this.context = new JSONStreamContext(this.context, 1004);
    } 
    this.parser.accept(14);
  }
  
  public void startObject() {
    if (this.context == null) {
      this.context = new JSONStreamContext(null, 1001);
    } else {
      startStructure();
      this.context = new JSONStreamContext(this.context, 1001);
    } 
    this.parser.accept(12, 18);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\JSONReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */