package com.alibaba.fastjson.parser;

@Deprecated
public class DefaultExtJSONParser extends DefaultJSONParser {
  public DefaultExtJSONParser(String paramString) {
    this(paramString, ParserConfig.getGlobalInstance());
  }
  
  public DefaultExtJSONParser(String paramString, ParserConfig paramParserConfig) {
    super(paramString, paramParserConfig);
  }
  
  public DefaultExtJSONParser(String paramString, ParserConfig paramParserConfig, int paramInt) {
    super(paramString, paramParserConfig, paramInt);
  }
  
  public DefaultExtJSONParser(char[] paramArrayOfchar, int paramInt1, ParserConfig paramParserConfig, int paramInt2) {
    super(paramArrayOfchar, paramInt1, paramParserConfig, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\DefaultExtJSONParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */