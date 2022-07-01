package com.google.common.net;

import com.google.common.escape.Escaper;

public final class UrlEscapers {
  private static final Escaper a = (Escaper)new PercentEscaper("-_.*", true);
  
  private static final Escaper b = (Escaper)new PercentEscaper("-._~!$'()*,;&=@:+", false);
  
  private static final Escaper c = (Escaper)new PercentEscaper("-._~!$'()*,;&=@:+/?", false);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\net\UrlEscapers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */