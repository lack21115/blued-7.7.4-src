package com.blued.android.framework.ui.markdown.atuser;

import org.commonmark.node.CustomNode;
import org.commonmark.node.Delimited;

public class AtUserNode extends CustomNode implements Delimited {
  private final String a;
  
  private final String b;
  
  public AtUserNode(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a() {
    return this.a;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AtUserNode {userName='");
    stringBuilder.append(this.a);
    stringBuilder.append('\'');
    stringBuilder.append(", userId='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public String u_() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\markdown\atuser\AtUserNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */