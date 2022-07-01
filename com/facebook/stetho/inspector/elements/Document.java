package com.facebook.stetho.inspector.elements;

import android.os.SystemClock;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ArrayListAccumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;
import com.facebook.stetho.inspector.helper.ThreadBoundProxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class Document extends ThreadBoundProxy {
  private AttributeListAccumulator mCachedAttributeAccumulator;
  
  private ChildEventingList mCachedChildEventingList;
  
  private ArrayListAccumulator<Object> mCachedChildrenAccumulator;
  
  private final Queue<Object> mCachedUpdateQueue;
  
  private DocumentProvider mDocumentProvider;
  
  private final DocumentProviderFactory mFactory;
  
  private final ObjectIdMapper mObjectIdMapper;
  
  private int mReferenceCounter;
  
  private ShadowDocument mShadowDocument;
  
  private UpdateListenerCollection mUpdateListeners;
  
  public Document(DocumentProviderFactory paramDocumentProviderFactory) {
    super(paramDocumentProviderFactory);
    this.mFactory = paramDocumentProviderFactory;
    this.mObjectIdMapper = new DocumentObjectIdMapper();
    this.mReferenceCounter = 0;
    this.mUpdateListeners = new UpdateListenerCollection();
    this.mCachedUpdateQueue = new ArrayDeque();
  }
  
  private AttributeListAccumulator acquireCachedAttributeAccumulator() {
    AttributeListAccumulator attributeListAccumulator2 = this.mCachedAttributeAccumulator;
    AttributeListAccumulator attributeListAccumulator1 = attributeListAccumulator2;
    if (attributeListAccumulator2 == null)
      attributeListAccumulator1 = new AttributeListAccumulator(); 
    this.mCachedChildrenAccumulator = null;
    return attributeListAccumulator1;
  }
  
  private ChildEventingList acquireChildEventingList(Object paramObject, DocumentView paramDocumentView) {
    ChildEventingList childEventingList2 = this.mCachedChildEventingList;
    ChildEventingList childEventingList1 = childEventingList2;
    if (childEventingList2 == null)
      childEventingList1 = new ChildEventingList(); 
    this.mCachedChildEventingList = null;
    childEventingList1.acquire(paramObject, paramDocumentView);
    return childEventingList1;
  }
  
  private ArrayListAccumulator<Object> acquireChildrenAccumulator() {
    ArrayListAccumulator<Object> arrayListAccumulator2 = this.mCachedChildrenAccumulator;
    ArrayListAccumulator<Object> arrayListAccumulator1 = arrayListAccumulator2;
    if (arrayListAccumulator2 == null)
      arrayListAccumulator1 = new ArrayListAccumulator(); 
    this.mCachedChildrenAccumulator = null;
    return arrayListAccumulator1;
  }
  
  private void applyDocumentUpdate(final ShadowDocument.Update docUpdate) {
    final ArrayList<Comparable> garbageElementIds = new ArrayList();
    docUpdate.getGarbageElements(new Accumulator<Object>() {
          public void store(Object param1Object) {
            Integer integer = (Integer)Util.throwIfNull(Document.this.mObjectIdMapper.getIdForObject(param1Object));
            if ((docUpdate.getElementInfo(param1Object)).parentElement == null) {
              param1Object = Document.this.mShadowDocument.getElementInfo(param1Object);
              int i = Document.this.mObjectIdMapper.getIdForObject(((ElementInfo)param1Object).parentElement).intValue();
              Document.this.mUpdateListeners.onChildNodeRemoved(i, integer.intValue());
            } 
            garbageElementIds.add(integer);
          }
        });
    Collections.sort(arrayList);
    docUpdate.getChangedElements(new Accumulator<Object>() {
          public void store(Object param1Object) {
            Integer integer = (Integer)Util.throwIfNull(Document.this.mObjectIdMapper.getIdForObject(param1Object));
            if (Collections.binarySearch(garbageElementIds, integer) >= 0)
              return; 
            ElementInfo elementInfo = Document.this.mShadowDocument.getElementInfo(param1Object);
            if (elementInfo == null)
              return; 
            if ((docUpdate.getElementInfo(param1Object)).parentElement != elementInfo.parentElement) {
              int i = Document.this.mObjectIdMapper.getIdForObject(elementInfo.parentElement).intValue();
              Document.this.mUpdateListeners.onChildNodeRemoved(i, integer.intValue());
            } 
          }
        });
    int j = arrayList.size();
    for (int i = 0; i < j; i++)
      this.mObjectIdMapper.removeObjectById(((Integer)arrayList.get(i)).intValue()); 
    docUpdate.getChangedElements(new Accumulator<Object>() {
          private Accumulator<Object> insertedElements = new Accumulator<Object>() {
              public void store(Object param2Object) {
                if (docUpdate.isElementChanged(param2Object))
                  Document.null.this.listenerInsertedElements.add(param2Object); 
              }
            };
          
          private final HashSet<Object> listenerInsertedElements = new HashSet();
          
          public void store(Object param1Object) {
            List<?> list;
            if (!Document.this.mObjectIdMapper.containsObject(param1Object))
              return; 
            if (this.listenerInsertedElements.contains(param1Object))
              return; 
            ElementInfo elementInfo1 = Document.this.mShadowDocument.getElementInfo(param1Object);
            ElementInfo elementInfo2 = docUpdate.getElementInfo(param1Object);
            if (elementInfo1 != null) {
              list = elementInfo1.children;
            } else {
              list = Collections.emptyList();
            } 
            List<Object> list1 = elementInfo2.children;
            Document.ChildEventingList childEventingList = Document.this.acquireChildEventingList(param1Object, docUpdate);
            int i = 0;
            int j = list.size();
            while (i < j) {
              Object object = list.get(i);
              if (Document.this.mObjectIdMapper.containsObject(object)) {
                ElementInfo elementInfo = docUpdate.getElementInfo(object);
                if (elementInfo == null || elementInfo.parentElement == param1Object)
                  childEventingList.add(object); 
              } 
              i++;
            } 
            Document.updateListenerChildren(childEventingList, list1, this.insertedElements);
            Document.this.releaseChildEventingList(childEventingList);
          }
        });
    docUpdate.commit();
  }
  
  private void cleanUp() {
    this.mDocumentProvider.postAndWait(new Runnable() {
          public void run() {
            Document.this.mDocumentProvider.setListener((DocumentProviderListener)null);
            Document.access$102(Document.this, null);
            Document.this.mObjectIdMapper.clear();
            Document.this.mDocumentProvider.dispose();
            Document.access$202(Document.this, null);
          }
        });
    this.mUpdateListeners.clear();
  }
  
  private ShadowDocument.Update createShadowDocumentUpdate() {
    verifyThreadAccess();
    if (this.mDocumentProvider.getRootElement() == this.mShadowDocument.getRootElement()) {
      ArrayListAccumulator<Object> arrayListAccumulator = acquireChildrenAccumulator();
      ShadowDocument.UpdateBuilder updateBuilder = this.mShadowDocument.beginUpdate();
      this.mCachedUpdateQueue.add(this.mDocumentProvider.getRootElement());
      while (!this.mCachedUpdateQueue.isEmpty()) {
        Object object = this.mCachedUpdateQueue.remove();
        NodeDescriptor<Object> nodeDescriptor = this.mDocumentProvider.getNodeDescriptor(object);
        this.mObjectIdMapper.putObject(object);
        nodeDescriptor.getChildren(object, (Accumulator)arrayListAccumulator);
        int j = arrayListAccumulator.size();
        for (int i = 0; i < j; i++) {
          Object object1 = arrayListAccumulator.get(i);
          if (object1 != null) {
            this.mCachedUpdateQueue.add(object1);
          } else {
            LogUtil.e("%s.getChildren() emitted a null child at position %s for element %s", new Object[] { nodeDescriptor.getClass().getName(), Integer.toString(i), object });
            arrayListAccumulator.remove(i);
            i--;
            j--;
          } 
        } 
        updateBuilder.setElementChildren(object, (List<Object>)arrayListAccumulator);
        arrayListAccumulator.clear();
      } 
      releaseChildrenAccumulator(arrayListAccumulator);
      return updateBuilder.build();
    } 
    throw new IllegalStateException();
  }
  
  private boolean doesElementMatch(Object paramObject, Pattern paramPattern) {
    AttributeListAccumulator attributeListAccumulator = acquireCachedAttributeAccumulator();
    NodeDescriptor<Object> nodeDescriptor = this.mDocumentProvider.getNodeDescriptor(paramObject);
    nodeDescriptor.getAttributes(paramObject, attributeListAccumulator);
    int j = attributeListAccumulator.size();
    for (int i = 0; i < j; i++) {
      if (paramPattern.matcher(attributeListAccumulator.get(i)).find()) {
        releaseCachedAttributeAccumulator(attributeListAccumulator);
        return true;
      } 
    } 
    releaseCachedAttributeAccumulator(attributeListAccumulator);
    return paramPattern.matcher(nodeDescriptor.getNodeName(paramObject)).find();
  }
  
  private void findMatches(Object paramObject, Pattern paramPattern, Accumulator<Integer> paramAccumulator) {
    paramObject = this.mShadowDocument.getElementInfo(paramObject);
    int j = ((ElementInfo)paramObject).children.size();
    int i;
    for (i = 0; i < j; i++) {
      Object object = ((ElementInfo)paramObject).children.get(i);
      if (doesElementMatch(object, paramPattern))
        paramAccumulator.store(this.mObjectIdMapper.getIdForObject(object)); 
      findMatches(object, paramPattern, paramAccumulator);
    } 
  }
  
  private void init() {
    this.mDocumentProvider = this.mFactory.create();
    this.mDocumentProvider.postAndWait(new Runnable() {
          public void run() {
            Document document = Document.this;
            Document.access$102(document, new ShadowDocument(document.mDocumentProvider.getRootElement()));
            Document.this.createShadowDocumentUpdate().commit();
            Document.this.mDocumentProvider.setListener(new Document.ProviderListener());
          }
        });
  }
  
  private void releaseCachedAttributeAccumulator(AttributeListAccumulator paramAttributeListAccumulator) {
    paramAttributeListAccumulator.clear();
    if (this.mCachedAttributeAccumulator == null)
      this.mCachedAttributeAccumulator = paramAttributeListAccumulator; 
  }
  
  private void releaseChildEventingList(ChildEventingList paramChildEventingList) {
    paramChildEventingList.release();
    if (this.mCachedChildEventingList == null)
      this.mCachedChildEventingList = paramChildEventingList; 
  }
  
  private void releaseChildrenAccumulator(ArrayListAccumulator<Object> paramArrayListAccumulator) {
    paramArrayListAccumulator.clear();
    if (this.mCachedChildrenAccumulator == null)
      this.mCachedChildrenAccumulator = paramArrayListAccumulator; 
  }
  
  private static void updateListenerChildren(ChildEventingList paramChildEventingList, List<Object> paramList, Accumulator<Object> paramAccumulator) {
    for (int i = 0; i <= paramChildEventingList.size(); i++) {
      if (i == paramChildEventingList.size()) {
        if (i == paramList.size())
          return; 
        paramChildEventingList.addWithEvent(i, paramList.get(i), paramAccumulator);
      } else {
        if (i == paramList.size()) {
          paramChildEventingList.removeWithEvent(i);
          continue;
        } 
        Object object1 = paramChildEventingList.get(i);
        Object object2 = paramList.get(i);
        if (object1 != object2) {
          int j = paramChildEventingList.indexOf(object2);
          if (j == -1) {
            paramChildEventingList.addWithEvent(i, object2, paramAccumulator);
          } else {
            paramChildEventingList.removeWithEvent(j);
            paramChildEventingList.addWithEvent(i, object2, paramAccumulator);
          } 
        } 
      } 
    } 
  }
  
  private void updateTree() {
    String str1;
    long l = SystemClock.elapsedRealtime();
    ShadowDocument.Update update = createShadowDocumentUpdate();
    boolean bool = update.isEmpty();
    if (bool) {
      update.abandon();
    } else {
      applyDocumentUpdate(update);
    } 
    String str2 = Long.toString(SystemClock.elapsedRealtime() - l);
    if (bool) {
      str1 = " (no changes)";
    } else {
      str1 = "";
    } 
    LogUtil.d("Document.updateTree() completed in %s ms%s", new Object[] { str2, str1 });
  }
  
  public void addRef() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mReferenceCounter : I
    //   6: istore_1
    //   7: aload_0
    //   8: iload_1
    //   9: iconst_1
    //   10: iadd
    //   11: putfield mReferenceCounter : I
    //   14: iload_1
    //   15: ifne -> 22
    //   18: aload_0
    //   19: invokespecial init : ()V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	25	finally
    //   18	22	25	finally
  }
  
  public void addUpdateListener(UpdateListener paramUpdateListener) {
    this.mUpdateListeners.add(paramUpdateListener);
  }
  
  public void findMatchingElements(String paramString, Accumulator<Integer> paramAccumulator) {
    verifyThreadAccess();
    Pattern pattern = Pattern.compile(Pattern.quote(paramString), 2);
    findMatches(this.mDocumentProvider.getRootElement(), pattern, paramAccumulator);
  }
  
  public DocumentView getDocumentView() {
    verifyThreadAccess();
    return this.mShadowDocument;
  }
  
  public void getElementComputedStyles(Object paramObject, ComputedStyleAccumulator paramComputedStyleAccumulator) {
    getNodeDescriptor(paramObject).getComputedStyles(paramObject, paramComputedStyleAccumulator);
  }
  
  @Nullable
  public Object getElementForNodeId(int paramInt) {
    return this.mObjectIdMapper.getObjectForId(paramInt);
  }
  
  public void getElementStyleRuleNames(Object paramObject, StyleRuleNameAccumulator paramStyleRuleNameAccumulator) {
    getNodeDescriptor(paramObject).getStyleRuleNames(paramObject, paramStyleRuleNameAccumulator);
  }
  
  public void getElementStyles(Object paramObject, String paramString, StyleAccumulator paramStyleAccumulator) {
    getNodeDescriptor(paramObject).getStyles(paramObject, paramString, paramStyleAccumulator);
  }
  
  @Nullable
  public NodeDescriptor getNodeDescriptor(Object paramObject) {
    verifyThreadAccess();
    return this.mDocumentProvider.getNodeDescriptor(paramObject);
  }
  
  @Nullable
  public Integer getNodeIdForElement(Object paramObject) {
    return this.mObjectIdMapper.getIdForObject(paramObject);
  }
  
  public Object getRootElement() {
    verifyThreadAccess();
    Object object = this.mDocumentProvider.getRootElement();
    if (object != null) {
      if (object == this.mShadowDocument.getRootElement())
        return object; 
      throw new IllegalStateException();
    } 
    throw new IllegalStateException();
  }
  
  public void hideHighlight() {
    verifyThreadAccess();
    this.mDocumentProvider.hideHighlight();
  }
  
  public void highlightElement(Object paramObject, int paramInt) {
    verifyThreadAccess();
    this.mDocumentProvider.highlightElement(paramObject, paramInt);
  }
  
  public void release() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mReferenceCounter : I
    //   6: ifle -> 29
    //   9: aload_0
    //   10: getfield mReferenceCounter : I
    //   13: iconst_1
    //   14: isub
    //   15: istore_1
    //   16: aload_0
    //   17: iload_1
    //   18: putfield mReferenceCounter : I
    //   21: iload_1
    //   22: ifne -> 29
    //   25: aload_0
    //   26: invokespecial cleanUp : ()V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	32	finally
    //   25	29	32	finally
  }
  
  public void removeUpdateListener(UpdateListener paramUpdateListener) {
    this.mUpdateListeners.remove(paramUpdateListener);
  }
  
  public void setAttributesAsText(Object paramObject, String paramString) {
    verifyThreadAccess();
    this.mDocumentProvider.setAttributesAsText(paramObject, paramString);
  }
  
  public void setElementStyle(Object paramObject, String paramString1, String paramString2, String paramString3) {
    getNodeDescriptor(paramObject).setStyle(paramObject, paramString1, paramString2, paramString3);
  }
  
  public void setInspectModeEnabled(boolean paramBoolean) {
    verifyThreadAccess();
    this.mDocumentProvider.setInspectModeEnabled(paramBoolean);
  }
  
  public static final class AttributeListAccumulator extends ArrayList<String> implements AttributeAccumulator {
    public void store(String param1String1, String param1String2) {
      add(param1String1);
      add(param1String2);
    }
  }
  
  final class ChildEventingList extends ArrayList<Object> {
    private DocumentView mDocumentView;
    
    private Object mParentElement = null;
    
    private int mParentNodeId = -1;
    
    private ChildEventingList() {}
    
    public void acquire(Object param1Object, DocumentView param1DocumentView) {
      int i;
      this.mParentElement = param1Object;
      if (this.mParentElement == null) {
        i = -1;
      } else {
        i = Document.this.mObjectIdMapper.getIdForObject(this.mParentElement).intValue();
      } 
      this.mParentNodeId = i;
      this.mDocumentView = param1DocumentView;
    }
    
    public void addWithEvent(int param1Int, Object param1Object, Accumulator<Object> param1Accumulator) {
      int i;
      Object object;
      if (param1Int == 0) {
        object = null;
      } else {
        object = get(param1Int - 1);
      } 
      if (object == null) {
        i = -1;
      } else {
        i = Document.this.mObjectIdMapper.getIdForObject(object).intValue();
      } 
      add(param1Int, param1Object);
      Document.this.mUpdateListeners.onChildNodeInserted(this.mDocumentView, param1Object, this.mParentNodeId, i, param1Accumulator);
    }
    
    public void release() {
      clear();
      this.mParentElement = null;
      this.mParentNodeId = -1;
      this.mDocumentView = null;
    }
    
    public void removeWithEvent(int param1Int) {
      Object object = remove(param1Int);
      param1Int = Document.this.mObjectIdMapper.getIdForObject(object).intValue();
      Document.this.mUpdateListeners.onChildNodeRemoved(this.mParentNodeId, param1Int);
    }
  }
  
  final class DocumentObjectIdMapper extends ObjectIdMapper {
    private DocumentObjectIdMapper() {}
    
    public void onMapped(Object param1Object, int param1Int) {
      Document.this.verifyThreadAccess();
      Document.this.mDocumentProvider.getNodeDescriptor(param1Object).hook(param1Object);
    }
    
    public void onUnmapped(Object param1Object, int param1Int) {
      Document.this.verifyThreadAccess();
      Document.this.mDocumentProvider.getNodeDescriptor(param1Object).unhook(param1Object);
    }
  }
  
  final class ProviderListener implements DocumentProviderListener {
    private ProviderListener() {}
    
    public void onAttributeModified(Object param1Object, String param1String1, String param1String2) {
      Document.this.verifyThreadAccess();
      Document.this.mUpdateListeners.onAttributeModified(param1Object, param1String1, param1String2);
    }
    
    public void onAttributeRemoved(Object param1Object, String param1String) {
      Document.this.verifyThreadAccess();
      Document.this.mUpdateListeners.onAttributeRemoved(param1Object, param1String);
    }
    
    public void onInspectRequested(Object param1Object) {
      Document.this.verifyThreadAccess();
      Document.this.mUpdateListeners.onInspectRequested(param1Object);
    }
    
    public void onPossiblyChanged() {
      Document.this.updateTree();
    }
  }
  
  public static interface UpdateListener {
    void onAttributeModified(Object param1Object, String param1String1, String param1String2);
    
    void onAttributeRemoved(Object param1Object, String param1String);
    
    void onChildNodeInserted(DocumentView param1DocumentView, Object param1Object, int param1Int1, int param1Int2, Accumulator<Object> param1Accumulator);
    
    void onChildNodeRemoved(int param1Int1, int param1Int2);
    
    void onInspectRequested(Object param1Object);
  }
  
  class UpdateListenerCollection implements UpdateListener {
    private final List<Document.UpdateListener> mListeners = new ArrayList<Document.UpdateListener>();
    
    private volatile Document.UpdateListener[] mListenersSnapshot;
    
    private Document.UpdateListener[] getListenersSnapshot() {
      // Byte code:
      //   0: aload_0
      //   1: getfield mListenersSnapshot : [Lcom/facebook/stetho/inspector/elements/Document$UpdateListener;
      //   4: astore_1
      //   5: aload_1
      //   6: ifnull -> 11
      //   9: aload_1
      //   10: areturn
      //   11: aload_0
      //   12: monitorenter
      //   13: aload_0
      //   14: getfield mListenersSnapshot : [Lcom/facebook/stetho/inspector/elements/Document$UpdateListener;
      //   17: ifnonnull -> 57
      //   20: aload_0
      //   21: aload_0
      //   22: getfield mListeners : Ljava/util/List;
      //   25: aload_0
      //   26: getfield mListeners : Ljava/util/List;
      //   29: invokeinterface size : ()I
      //   34: anewarray com/facebook/stetho/inspector/elements/Document$UpdateListener
      //   37: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
      //   42: checkcast [Lcom/facebook/stetho/inspector/elements/Document$UpdateListener;
      //   45: putfield mListenersSnapshot : [Lcom/facebook/stetho/inspector/elements/Document$UpdateListener;
      //   48: aload_0
      //   49: getfield mListenersSnapshot : [Lcom/facebook/stetho/inspector/elements/Document$UpdateListener;
      //   52: astore_1
      //   53: aload_0
      //   54: monitorexit
      //   55: aload_1
      //   56: areturn
      //   57: aload_0
      //   58: monitorexit
      //   59: goto -> 0
      //   62: astore_1
      //   63: aload_0
      //   64: monitorexit
      //   65: aload_1
      //   66: athrow
      // Exception table:
      //   from	to	target	type
      //   13	55	62	finally
      //   57	59	62	finally
      //   63	65	62	finally
    }
    
    public void add(Document.UpdateListener param1UpdateListener) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield mListeners : Ljava/util/List;
      //   6: aload_1
      //   7: invokeinterface add : (Ljava/lang/Object;)Z
      //   12: pop
      //   13: aload_0
      //   14: aconst_null
      //   15: putfield mListenersSnapshot : [Lcom/facebook/stetho/inspector/elements/Document$UpdateListener;
      //   18: aload_0
      //   19: monitorexit
      //   20: return
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	21	finally
    }
    
    public void clear() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield mListeners : Ljava/util/List;
      //   6: invokeinterface clear : ()V
      //   11: aload_0
      //   12: aconst_null
      //   13: putfield mListenersSnapshot : [Lcom/facebook/stetho/inspector/elements/Document$UpdateListener;
      //   16: aload_0
      //   17: monitorexit
      //   18: return
      //   19: astore_1
      //   20: aload_0
      //   21: monitorexit
      //   22: aload_1
      //   23: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	19	finally
    }
    
    public void onAttributeModified(Object param1Object, String param1String1, String param1String2) {
      Document.UpdateListener[] arrayOfUpdateListener = getListenersSnapshot();
      int j = arrayOfUpdateListener.length;
      int i;
      for (i = 0; i < j; i++)
        arrayOfUpdateListener[i].onAttributeModified(param1Object, param1String1, param1String2); 
    }
    
    public void onAttributeRemoved(Object param1Object, String param1String) {
      Document.UpdateListener[] arrayOfUpdateListener = getListenersSnapshot();
      int j = arrayOfUpdateListener.length;
      for (int i = 0; i < j; i++)
        arrayOfUpdateListener[i].onAttributeRemoved(param1Object, param1String); 
    }
    
    public void onChildNodeInserted(DocumentView param1DocumentView, Object param1Object, int param1Int1, int param1Int2, Accumulator<Object> param1Accumulator) {
      Document.UpdateListener[] arrayOfUpdateListener = getListenersSnapshot();
      int j = arrayOfUpdateListener.length;
      int i;
      for (i = 0; i < j; i++)
        arrayOfUpdateListener[i].onChildNodeInserted(param1DocumentView, param1Object, param1Int1, param1Int2, param1Accumulator); 
    }
    
    public void onChildNodeRemoved(int param1Int1, int param1Int2) {
      Document.UpdateListener[] arrayOfUpdateListener = getListenersSnapshot();
      int j = arrayOfUpdateListener.length;
      for (int i = 0; i < j; i++)
        arrayOfUpdateListener[i].onChildNodeRemoved(param1Int1, param1Int2); 
    }
    
    public void onInspectRequested(Object param1Object) {
      Document.UpdateListener[] arrayOfUpdateListener = getListenersSnapshot();
      int j = arrayOfUpdateListener.length;
      for (int i = 0; i < j; i++)
        arrayOfUpdateListener[i].onInspectRequested(param1Object); 
    }
    
    public void remove(Document.UpdateListener param1UpdateListener) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield mListeners : Ljava/util/List;
      //   6: aload_1
      //   7: invokeinterface remove : (Ljava/lang/Object;)Z
      //   12: pop
      //   13: aload_0
      //   14: aconst_null
      //   15: putfield mListenersSnapshot : [Lcom/facebook/stetho/inspector/elements/Document$UpdateListener;
      //   18: aload_0
      //   19: monitorexit
      //   20: return
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	21	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\Document.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */