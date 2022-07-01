package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
  public static final Charset UTF8 = Charset.forName("UTF-8");
  
  private Charset charset = UTF8;
  
  protected String dateFormat;
  
  private SerializerFeature[] features = new SerializerFeature[0];
  
  protected SerializeFilter[] serialzeFilters = new SerializeFilter[0];
  
  public FastJsonHttpMessageConverter() {
    super(new MediaType[] { new MediaType("application", "json", UTF8), new MediaType("application", "*+json", UTF8) });
  }
  
  public void addSerializeFilter(SerializeFilter paramSerializeFilter) {
    if (paramSerializeFilter == null)
      return; 
    SerializeFilter[] arrayOfSerializeFilter1 = this.serialzeFilters;
    SerializeFilter[] arrayOfSerializeFilter2 = new SerializeFilter[arrayOfSerializeFilter1.length + 1];
    System.arraycopy(arrayOfSerializeFilter1, 0, paramSerializeFilter, 0, arrayOfSerializeFilter1.length);
    arrayOfSerializeFilter2[arrayOfSerializeFilter2.length - 1] = paramSerializeFilter;
    this.serialzeFilters = arrayOfSerializeFilter2;
  }
  
  public Charset getCharset() {
    return this.charset;
  }
  
  public String getDateFormat() {
    return this.dateFormat;
  }
  
  public SerializerFeature[] getFeatures() {
    return this.features;
  }
  
  protected Object readInternal(Class<? extends Object> paramClass, HttpInputMessage paramHttpInputMessage) throws IOException, HttpMessageNotReadableException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    InputStream inputStream = paramHttpInputMessage.getBody();
    byte[] arrayOfByte = new byte[1024];
    while (true) {
      int i = inputStream.read(arrayOfByte);
      if (i == -1) {
        byte[] arrayOfByte1 = byteArrayOutputStream.toByteArray();
        return JSON.parseObject(arrayOfByte1, 0, arrayOfByte1.length, this.charset.newDecoder(), paramClass, new com.alibaba.fastjson.parser.Feature[0]);
      } 
      if (i > 0)
        byteArrayOutputStream.write(arrayOfByte, 0, i); 
    } 
  }
  
  public void setCharset(Charset paramCharset) {
    this.charset = paramCharset;
  }
  
  public void setDateFormat(String paramString) {
    this.dateFormat = paramString;
  }
  
  public void setFeatures(SerializerFeature... paramVarArgs) {
    this.features = paramVarArgs;
  }
  
  protected boolean supports(Class<?> paramClass) {
    return true;
  }
  
  protected void writeInternal(Object paramObject, HttpOutputMessage paramHttpOutputMessage) throws IOException, HttpMessageNotWritableException {
    HttpHeaders httpHeaders = paramHttpOutputMessage.getHeaders();
    paramObject = JSON.toJSONString(paramObject, SerializeConfig.globalInstance, this.serialzeFilters, this.dateFormat, JSON.DEFAULT_GENERATE_FEATURE, this.features).getBytes(this.charset);
    httpHeaders.setContentLength(paramObject.length);
    paramHttpOutputMessage.getBody().write((byte[])paramObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\support\spring\FastJsonHttpMessageConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */