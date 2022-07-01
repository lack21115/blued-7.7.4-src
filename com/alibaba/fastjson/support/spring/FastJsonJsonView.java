package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FastJsonJsonView extends AbstractView {
  public static final String DEFAULT_CONTENT_TYPE = "application/json";
  
  public static final Charset UTF8 = Charset.forName("UTF-8");
  
  private Charset charset = UTF8;
  
  private boolean disableCaching = true;
  
  private boolean extractValueFromSingleKeyModel = false;
  
  private Set<String> renderedAttributes;
  
  private SerializerFeature[] serializerFeatures = new SerializerFeature[0];
  
  private boolean updateContentLength = false;
  
  public FastJsonJsonView() {
    setContentType("application/json");
    setExposePathVariables(false);
  }
  
  protected Object filterModel(Map<String, Object> paramMap) {
    Set<String> set;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(paramMap.size());
    if (!CollectionUtils.isEmpty(this.renderedAttributes)) {
      set = this.renderedAttributes;
    } else {
      set = paramMap.keySet();
    } 
    for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
      if (!(entry.getValue() instanceof org.springframework.validation.BindingResult) && set.contains(entry.getKey()))
        hashMap.put(entry.getKey(), entry.getValue()); 
    } 
    if (this.extractValueFromSingleKeyModel && hashMap.size() == 1) {
      Iterator<Map.Entry> iterator = hashMap.entrySet().iterator();
      if (iterator.hasNext())
        return ((Map.Entry)iterator.next()).getValue(); 
    } 
    return hashMap;
  }
  
  public Charset getCharset() {
    return this.charset;
  }
  
  public SerializerFeature[] getFeatures() {
    return this.serializerFeatures;
  }
  
  public boolean isExtractValueFromSingleKeyModel() {
    return this.extractValueFromSingleKeyModel;
  }
  
  protected void prepareResponse(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) {
    setResponseContentType(paramHttpServletRequest, paramHttpServletResponse);
    paramHttpServletResponse.setCharacterEncoding(UTF8.name());
    if (this.disableCaching) {
      paramHttpServletResponse.addHeader("Pragma", "no-cache");
      paramHttpServletResponse.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
      paramHttpServletResponse.addDateHeader("Expires", 1L);
    } 
  }
  
  protected void renderMergedOutputModel(Map<String, Object> paramMap, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws Exception {
    ServletOutputStream servletOutputStream;
    byte[] arrayOfByte = JSON.toJSONString(filterModel(paramMap), this.serializerFeatures).getBytes(this.charset);
    if (this.updateContentLength) {
      ByteArrayOutputStream byteArrayOutputStream = createTemporaryOutputStream();
    } else {
      servletOutputStream = paramHttpServletResponse.getOutputStream();
    } 
    servletOutputStream.write(arrayOfByte);
    if (this.updateContentLength)
      writeToResponse(paramHttpServletResponse, (ByteArrayOutputStream)servletOutputStream); 
  }
  
  public void setCharset(Charset paramCharset) {
    this.charset = paramCharset;
  }
  
  public void setDisableCaching(boolean paramBoolean) {
    this.disableCaching = paramBoolean;
  }
  
  public void setExtractValueFromSingleKeyModel(boolean paramBoolean) {
    this.extractValueFromSingleKeyModel = paramBoolean;
  }
  
  public void setFeatures(SerializerFeature... paramVarArgs) {
    this.serializerFeatures = paramVarArgs;
  }
  
  public void setRenderedAttributes(Set<String> paramSet) {
    this.renderedAttributes = paramSet;
  }
  
  @Deprecated
  public void setSerializerFeature(SerializerFeature... paramVarArgs) {
    setFeatures(paramVarArgs);
  }
  
  public void setUpdateContentLength(boolean paramBoolean) {
    this.updateContentLength = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\support\spring\FastJsonJsonView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */