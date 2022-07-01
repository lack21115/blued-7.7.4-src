package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MergePathsContent implements GreedyContent, PathContent {
  private final Path a = new Path();
  
  private final Path b = new Path();
  
  private final Path c = new Path();
  
  private final String d;
  
  private final List<PathContent> e = new ArrayList<PathContent>();
  
  private final MergePaths f;
  
  public MergePathsContent(MergePaths paramMergePaths) {
    if (Build.VERSION.SDK_INT >= 19) {
      this.d = paramMergePaths.a();
      this.f = paramMergePaths;
      return;
    } 
    throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
  }
  
  private void a() {
    for (int i = 0; i < this.e.size(); i++)
      this.c.addPath(((PathContent)this.e.get(i)).e()); 
  }
  
  private void a(Path.Op paramOp) {
    this.b.reset();
    this.a.reset();
    int i;
    for (i = this.e.size() - 1; i >= 1; i--) {
      PathContent pathContent1 = this.e.get(i);
      if (pathContent1 instanceof ContentGroup) {
        pathContent1 = pathContent1;
        List<PathContent> list1 = pathContent1.c();
        for (int j = list1.size() - 1; j >= 0; j--) {
          Path path = ((PathContent)list1.get(j)).e();
          path.transform(pathContent1.d());
          this.b.addPath(path);
        } 
      } else {
        this.b.addPath(pathContent1.e());
      } 
    } 
    List<PathContent> list = this.e;
    i = 0;
    PathContent pathContent = list.get(0);
    if (pathContent instanceof ContentGroup) {
      pathContent = pathContent;
      List<PathContent> list1 = pathContent.c();
      while (i < list1.size()) {
        Path path = ((PathContent)list1.get(i)).e();
        path.transform(pathContent.d());
        this.a.addPath(path);
        i++;
      } 
    } else {
      this.a.set(pathContent.e());
    } 
    this.c.op(this.a, this.b, paramOp);
  }
  
  public void a(List<Content> paramList1, List<Content> paramList2) {
    for (int i = 0; i < this.e.size(); i++)
      ((PathContent)this.e.get(i)).a(paramList1, paramList2); 
  }
  
  public void a(ListIterator<Content> paramListIterator) {
    while (paramListIterator.hasPrevious() && paramListIterator.previous() != this);
    while (paramListIterator.hasPrevious()) {
      Content content = paramListIterator.previous();
      if (content instanceof PathContent) {
        this.e.add((PathContent)content);
        paramListIterator.remove();
      } 
    } 
  }
  
  public String b() {
    return this.d;
  }
  
  public Path e() {
    this.c.reset();
    if (this.f.c())
      return this.c; 
    int i = null.a[this.f.b().ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i == 5)
              a(Path.Op.XOR); 
          } else {
            a(Path.Op.INTERSECT);
          } 
        } else {
          a(Path.Op.REVERSE_DIFFERENCE);
        } 
      } else {
        a(Path.Op.UNION);
      } 
    } else {
      a();
    } 
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\MergePathsContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */