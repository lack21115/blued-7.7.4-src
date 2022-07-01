package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class JSONWriter implements Closeable, Flushable {
  private JSONStreamContext context;
  
  private JSONSerializer serializer;
  
  private SerializeWriter writer;
  
  public JSONWriter(Writer paramWriter) {
    this.writer = new SerializeWriter(paramWriter);
    this.serializer = new JSONSerializer(this.writer);
  }
  
  private void afterWriter() {
    short s;
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
      case 1005:
        s = -1;
        break;
    } 
    if (s != -1)
      this.context.state = s; 
  }
  
  private void beforeWrite() {
    JSONStreamContext jSONStreamContext = this.context;
    if (jSONStreamContext == null)
      return; 
    switch (jSONStreamContext.state) {
      default:
        return;
      case 1005:
        this.writer.write(44);
        return;
      case 1003:
        this.writer.write(44);
        return;
      case 1002:
        this.writer.write(58);
        break;
      case 1001:
      case 1004:
        break;
    } 
  }
  
  private void beginStructure() {
    StringBuilder stringBuilder;
    int i = this.context.state;
    switch (this.context.state) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("illegal state : ");
        stringBuilder.append(i);
        throw new JSONException(stringBuilder.toString());
      case 1005:
        this.writer.write(44);
        return;
      case 1002:
        this.writer.write(58);
        break;
      case 1001:
      case 1004:
        break;
    } 
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
        s = 1002;
        break;
      case 1005:
        s = -1;
        break;
    } 
    if (s != -1)
      this.context.state = s; 
  }
  
  public void close() throws IOException {
    this.writer.close();
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean) {
    this.writer.config(paramSerializerFeature, paramBoolean);
  }
  
  public void endArray() {
    this.writer.write(93);
    endStructure();
  }
  
  public void endObject() {
    this.writer.write(125);
    endStructure();
  }
  
  public void flush() throws IOException {
    this.writer.flush();
  }
  
  public void startArray() {
    if (this.context != null)
      beginStructure(); 
    this.context = new JSONStreamContext(this.context, 1004);
    this.writer.write(91);
  }
  
  public void startObject() {
    if (this.context != null)
      beginStructure(); 
    this.context = new JSONStreamContext(this.context, 1001);
    this.writer.write(123);
  }
  
  @Deprecated
  public void writeEndArray() {
    endArray();
  }
  
  @Deprecated
  public void writeEndObject() {
    endObject();
  }
  
  public void writeKey(String paramString) {
    writeObject(paramString);
  }
  
  public void writeObject(Object paramObject) {
    beforeWrite();
    this.serializer.write(paramObject);
    afterWriter();
  }
  
  public void writeObject(String paramString) {
    beforeWrite();
    this.serializer.write(paramString);
    afterWriter();
  }
  
  @Deprecated
  public void writeStartArray() {
    startArray();
  }
  
  @Deprecated
  public void writeStartObject() {
    startObject();
  }
  
  public void writeValue(Object paramObject) {
    writeObject(paramObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\JSONWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */