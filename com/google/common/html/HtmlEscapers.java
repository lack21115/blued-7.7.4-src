package com.google.common.html;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

public final class HtmlEscapers {
  private static final Escaper a = Escapers.a().a('"', "&quot;").a('\'', "&#39;").a('&', "&amp;").a('<', "&lt;").a('>', "&gt;").a();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\html\HtmlEscapers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */