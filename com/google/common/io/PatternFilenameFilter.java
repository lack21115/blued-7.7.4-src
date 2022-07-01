package com.google.common.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class PatternFilenameFilter implements FilenameFilter {
  private final Pattern a;
  
  public boolean accept(@NullableDecl File paramFile, String paramString) {
    return this.a.matcher(paramString).matches();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\PatternFilenameFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */