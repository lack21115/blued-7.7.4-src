package com.qiniu.pili.droid.crash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class j {
  private static final Pattern a = Pattern.compile("^(.*):\\s'(.*?)'$");
  
  private static final Pattern b = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");
  
  private static final Pattern c = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");
  
  private static final Set<String> d = new HashSet<String>(Arrays.asList(new String[] { "Crash type" }));
  
  private static final Set<String> e = new HashSet<String>(Arrays.asList(new String[] { "backtrace", "build id", "stack", "java stacktrace" }));
  
  enum a {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\crash\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */