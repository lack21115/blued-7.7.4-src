package com.google.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Splitter {
  private final CharMatcher a;
  
  private final boolean b;
  
  private final Strategy c;
  
  private final int d;
  
  private Splitter(Strategy paramStrategy) {
    this(paramStrategy, false, CharMatcher.b(), 2147483647);
  }
  
  private Splitter(Strategy paramStrategy, boolean paramBoolean, CharMatcher paramCharMatcher, int paramInt) {
    this.c = paramStrategy;
    this.b = paramBoolean;
    this.a = paramCharMatcher;
    this.d = paramInt;
  }
  
  public static Splitter a(char paramChar) {
    return a(CharMatcher.a(paramChar));
  }
  
  public static Splitter a(CharMatcher paramCharMatcher) {
    Preconditions.a(paramCharMatcher);
    return new Splitter(new Strategy(paramCharMatcher) {
          public Splitter.SplittingIterator a(Splitter param1Splitter, CharSequence param1CharSequence) {
            return new Splitter.SplittingIterator(this, param1Splitter, param1CharSequence) {
                int a(int param2Int) {
                  return this.a.a.a(this.c, param2Int);
                }
                
                int b(int param2Int) {
                  return param2Int + 1;
                }
              };
          }
        });
  }
  
  private static Splitter a(CommonPattern paramCommonPattern) {
    Preconditions.a(paramCommonPattern.a("").a() ^ true, "The pattern may not match the empty string: %s", paramCommonPattern);
    return new Splitter(new Strategy(paramCommonPattern) {
          public Splitter.SplittingIterator a(Splitter param1Splitter, CharSequence param1CharSequence) {
            return new Splitter.SplittingIterator(this, param1Splitter, param1CharSequence, this.a.a(param1CharSequence)) {
                public int a(int param2Int) {
                  return this.a.a(param2Int) ? this.a.d() : -1;
                }
                
                public int b(int param2Int) {
                  return this.a.c();
                }
              };
          }
        });
  }
  
  public static Splitter a(String paramString) {
    boolean bool;
    if (paramString.length() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "The separator may not be the empty string.");
    return (paramString.length() == 1) ? a(paramString.charAt(0)) : new Splitter(new Strategy(paramString) {
          public Splitter.SplittingIterator a(Splitter param1Splitter, CharSequence param1CharSequence) {
            return new Splitter.SplittingIterator(this, param1Splitter, param1CharSequence) {
                public int a(int param2Int) {
                  int i = this.a.a.length();
                  int j = this.c.length();
                  label14: while (param2Int <= j - i) {
                    for (int k = 0; k < i; k++) {
                      if (this.c.charAt(k + param2Int) != this.a.a.charAt(k)) {
                        param2Int++;
                        continue label14;
                      } 
                    } 
                    return param2Int;
                  } 
                  return -1;
                }
                
                public int b(int param2Int) {
                  return param2Int + this.a.a.length();
                }
              };
          }
        });
  }
  
  public static Splitter b(String paramString) {
    return a(Platform.c(paramString));
  }
  
  private Iterator<String> c(CharSequence paramCharSequence) {
    return this.c.b(this, paramCharSequence);
  }
  
  public Splitter a() {
    return new Splitter(this.c, true, this.a, this.d);
  }
  
  public Splitter a(int paramInt) {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "must be greater than zero: %s", paramInt);
    return new Splitter(this.c, this.b, this.a, paramInt);
  }
  
  public Iterable<String> a(CharSequence paramCharSequence) {
    Preconditions.a(paramCharSequence);
    return new Iterable<String>(this, paramCharSequence) {
        public Iterator<String> iterator() {
          return Splitter.a(this.b, this.a);
        }
        
        public String toString() {
          Joiner joiner = Joiner.a(", ");
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append('[');
          StringBuilder stringBuilder1 = joiner.a(stringBuilder2, this);
          stringBuilder1.append(']');
          return stringBuilder1.toString();
        }
      };
  }
  
  public Splitter b() {
    return b(CharMatcher.c());
  }
  
  public Splitter b(CharMatcher paramCharMatcher) {
    Preconditions.a(paramCharMatcher);
    return new Splitter(this.c, this.b, paramCharMatcher, this.d);
  }
  
  public List<String> b(CharSequence paramCharSequence) {
    Preconditions.a(paramCharSequence);
    Iterator<String> iterator = c(paramCharSequence);
    ArrayList<? extends String> arrayList = new ArrayList();
    while (iterator.hasNext())
      arrayList.add(iterator.next()); 
    return Collections.unmodifiableList(arrayList);
  }
  
  public static final class MapSplitter {}
  
  static abstract class SplittingIterator extends AbstractIterator<String> {
    final CharSequence c;
    
    final CharMatcher d;
    
    final boolean e;
    
    int f = 0;
    
    int g;
    
    protected SplittingIterator(Splitter param1Splitter, CharSequence param1CharSequence) {
      this.d = Splitter.a(param1Splitter);
      this.e = Splitter.b(param1Splitter);
      this.g = Splitter.c(param1Splitter);
      this.c = param1CharSequence;
    }
    
    abstract int a(int param1Int);
    
    abstract int b(int param1Int);
    
    protected String c() {
      int i = this.f;
      while (true) {
        int j = this.f;
        if (j != -1) {
          j = a(j);
          if (j == -1) {
            j = this.c.length();
            this.f = -1;
          } else {
            this.f = b(j);
          } 
          int m = this.f;
          int k = i;
          if (m == i) {
            this.f = m + 1;
            if (this.f > this.c.length())
              this.f = -1; 
            continue;
          } 
          while (true) {
            i = j;
            if (k < j) {
              i = j;
              if (this.d.c(this.c.charAt(k))) {
                k++;
                continue;
              } 
            } 
            break;
          } 
          while (i > k && this.d.c(this.c.charAt(i - 1)))
            i--; 
          if (this.e) {
            if (k == i) {
              i = this.f;
              continue;
            } 
            j = this.g;
            if (j == 1) {
              i = this.c.length();
              this.f = -1;
              while (true) {
                j = i;
                if (i > k) {
                  j = i;
                  if (this.d.c(this.c.charAt(i - 1))) {
                    i--;
                    continue;
                  } 
                } 
                break;
              } 
            } else {
              this.g = j - 1;
              j = i;
            } 
            return this.c.subSequence(k, j).toString();
          } 
          continue;
        } 
        return b();
      } 
    }
  }
  
  static interface Strategy {
    Iterator<String> b(Splitter param1Splitter, CharSequence param1CharSequence);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Splitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */