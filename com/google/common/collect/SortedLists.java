package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class SortedLists {
  public static <E, K extends Comparable> int a(List<E> paramList, Function<? super E, K> paramFunction, @NullableDecl K paramK, KeyPresentBehavior paramKeyPresentBehavior, KeyAbsentBehavior paramKeyAbsentBehavior) {
    return a(paramList, paramFunction, paramK, Ordering.d(), paramKeyPresentBehavior, paramKeyAbsentBehavior);
  }
  
  public static <E, K> int a(List<E> paramList, Function<? super E, K> paramFunction, @NullableDecl K paramK, Comparator<? super K> paramComparator, KeyPresentBehavior paramKeyPresentBehavior, KeyAbsentBehavior paramKeyAbsentBehavior) {
    return a(Lists.a(paramList, paramFunction), paramK, paramComparator, paramKeyPresentBehavior, paramKeyAbsentBehavior);
  }
  
  public static <E> int a(List<? extends E> paramList, @NullableDecl E paramE, Comparator<? super E> paramComparator, KeyPresentBehavior paramKeyPresentBehavior, KeyAbsentBehavior paramKeyAbsentBehavior) {
    Preconditions.a(paramComparator);
    Preconditions.a(paramList);
    Preconditions.a(paramKeyPresentBehavior);
    Preconditions.a(paramKeyAbsentBehavior);
    List<? extends E> list = paramList;
    if (!(paramList instanceof java.util.RandomAccess))
      list = Lists.a(paramList); 
    int j = 0;
    int i = list.size() - 1;
    while (j <= i) {
      int k = j + i >>> 1;
      int m = paramComparator.compare(paramE, list.get(k));
      if (m < 0) {
        i = k - 1;
        continue;
      } 
      if (m > 0) {
        j = k + 1;
        continue;
      } 
      return j + paramKeyPresentBehavior.<E>a(paramComparator, paramE, list.subList(j, i + 1), k - j);
    } 
    return paramKeyAbsentBehavior.a(j);
  }
  
  enum KeyAbsentBehavior {
    a {
      int a(int param2Int) {
        return param2Int - 1;
      }
    },
    b {
      public int a(int param2Int) {
        return param2Int;
      }
    },
    c {
      public int a(int param2Int) {
        return param2Int;
      }
    };
    
    abstract int a(int param1Int);
  }
  
  enum null {
    int a(int param1Int) {
      return param1Int - 1;
    }
  }
  
  enum null {
    public int a(int param1Int) {
      return param1Int;
    }
  }
  
  enum null {
    public int a(int param1Int) {
      return param1Int;
    }
  }
  
  enum KeyPresentBehavior {
    a {
      <E> int a(Comparator<? super E> param2Comparator, E param2E, List<? extends E> param2List, int param2Int) {
        return param2Int;
      }
    },
    b {
      <E> int a(Comparator<? super E> param2Comparator, E param2E, List<? extends E> param2List, int param2Int) {
        int i = param2List.size() - 1;
        while (param2Int < i) {
          int j = param2Int + i + 1 >>> 1;
          if (param2Comparator.compare(param2List.get(j), param2E) > 0) {
            i = j - 1;
            continue;
          } 
          param2Int = j;
        } 
        return param2Int;
      }
    },
    c {
      <E> int a(Comparator<? super E> param2Comparator, E param2E, List<? extends E> param2List, int param2Int) {
        int i = 0;
        while (i < param2Int) {
          int j = i + param2Int >>> 1;
          if (param2Comparator.compare(param2List.get(j), param2E) < 0) {
            i = j + 1;
            continue;
          } 
          param2Int = j;
        } 
        return i;
      }
    },
    d {
      public <E> int a(Comparator<? super E> param2Comparator, E param2E, List<? extends E> param2List, int param2Int) {
        return b.<E>a(param2Comparator, param2E, param2List, param2Int) + 1;
      }
    },
    e {
      public <E> int a(Comparator<? super E> param2Comparator, E param2E, List<? extends E> param2List, int param2Int) {
        return c.<E>a(param2Comparator, param2E, param2List, param2Int) - 1;
      }
    };
    
    abstract <E> int a(Comparator<? super E> param1Comparator, E param1E, List<? extends E> param1List, int param1Int);
  }
  
  enum null {
    <E> int a(Comparator<? super E> param1Comparator, E param1E, List<? extends E> param1List, int param1Int) {
      return param1Int;
    }
  }
  
  enum null {
    <E> int a(Comparator<? super E> param1Comparator, E param1E, List<? extends E> param1List, int param1Int) {
      int i = param1List.size() - 1;
      while (param1Int < i) {
        int j = param1Int + i + 1 >>> 1;
        if (param1Comparator.compare(param1List.get(j), param1E) > 0) {
          i = j - 1;
          continue;
        } 
        param1Int = j;
      } 
      return param1Int;
    }
  }
  
  enum null {
    <E> int a(Comparator<? super E> param1Comparator, E param1E, List<? extends E> param1List, int param1Int) {
      int i = 0;
      while (i < param1Int) {
        int j = i + param1Int >>> 1;
        if (param1Comparator.compare(param1List.get(j), param1E) < 0) {
          i = j + 1;
          continue;
        } 
        param1Int = j;
      } 
      return i;
    }
  }
  
  enum null {
    public <E> int a(Comparator<? super E> param1Comparator, E param1E, List<? extends E> param1List, int param1Int) {
      return b.<E>a(param1Comparator, param1E, param1List, param1Int) + 1;
    }
  }
  
  enum null {
    public <E> int a(Comparator<? super E> param1Comparator, E param1E, List<? extends E> param1List, int param1Int) {
      return c.<E>a(param1Comparator, param1E, param1List, param1Int) - 1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\SortedLists.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */