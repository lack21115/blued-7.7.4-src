package com.google.common.xml;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

public class XmlEscapers {
  private static final Escaper a;
  
  private static final Escaper b;
  
  private static final Escaper c;
  
  static {
    Escapers.Builder builder = Escapers.a();
    char c = Character.MIN_VALUE;
    builder.a(false, '�');
    builder.a("�");
    while (c <= '\037') {
      if (c != '\t' && c != '\n' && c != '\r')
        builder.a(c, "�"); 
      c = (char)(c + 1);
    } 
    builder.a('&', "&amp;");
    builder.a('<', "&lt;");
    builder.a('>', "&gt;");
    b = builder.a();
    builder.a('\'', "&apos;");
    builder.a('"', "&quot;");
    a = builder.a();
    builder.a('\t', "&#x9;");
    builder.a('\n', "&#xA;");
    builder.a('\r', "&#xD;");
    c = builder.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\xml\XmlEscapers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */