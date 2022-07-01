package com.facebook.stetho.inspector.protocol.module;

import android.graphics.Color;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ArrayListAccumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.Document;
import com.facebook.stetho.inspector.elements.DocumentView;
import com.facebook.stetho.inspector.elements.ElementInfo;
import com.facebook.stetho.inspector.elements.NodeDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeerRegistrationListener;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import org.json.JSONObject;

public class DOM implements ChromeDevtoolsDomain {
  private ChildNodeInsertedEvent mCachedChildNodeInsertedEvent;
  
  private ChildNodeRemovedEvent mCachedChildNodeRemovedEvent;
  
  private final Document mDocument;
  
  private final DocumentUpdateListener mListener;
  
  private final ObjectMapper mObjectMapper = new ObjectMapper();
  
  private final ChromePeerManager mPeerManager;
  
  private final AtomicInteger mResultCounter;
  
  private final Map<String, List<Integer>> mSearchResults;
  
  public DOM(Document paramDocument) {
    this.mDocument = (Document)Util.throwIfNull(paramDocument);
    this.mSearchResults = Collections.synchronizedMap(new HashMap<String, List<Integer>>());
    this.mResultCounter = new AtomicInteger(0);
    this.mPeerManager = new ChromePeerManager();
    this.mPeerManager.setListener((PeerRegistrationListener)new PeerManagerListener());
    this.mListener = new DocumentUpdateListener();
  }
  
  private ChildNodeInsertedEvent acquireChildNodeInsertedEvent() {
    ChildNodeInsertedEvent childNodeInsertedEvent2 = this.mCachedChildNodeInsertedEvent;
    ChildNodeInsertedEvent childNodeInsertedEvent1 = childNodeInsertedEvent2;
    if (childNodeInsertedEvent2 == null)
      childNodeInsertedEvent1 = new ChildNodeInsertedEvent(); 
    this.mCachedChildNodeInsertedEvent = null;
    return childNodeInsertedEvent1;
  }
  
  private ChildNodeRemovedEvent acquireChildNodeRemovedEvent() {
    ChildNodeRemovedEvent childNodeRemovedEvent2 = this.mCachedChildNodeRemovedEvent;
    ChildNodeRemovedEvent childNodeRemovedEvent1 = childNodeRemovedEvent2;
    if (childNodeRemovedEvent2 == null)
      childNodeRemovedEvent1 = new ChildNodeRemovedEvent(); 
    this.mCachedChildNodeRemovedEvent = null;
    return childNodeRemovedEvent1;
  }
  
  private Node createNodeForElement(Object<?> paramObject, DocumentView paramDocumentView, @Nullable Accumulator<Object> paramAccumulator) {
    if (paramAccumulator != null)
      paramAccumulator.store(paramObject); 
    NodeDescriptor nodeDescriptor = this.mDocument.getNodeDescriptor(paramObject);
    Node node = new Node();
    node.nodeId = this.mDocument.getNodeIdForElement(paramObject).intValue();
    node.nodeType = nodeDescriptor.getNodeType(paramObject);
    node.nodeName = nodeDescriptor.getNodeName(paramObject);
    node.localName = nodeDescriptor.getLocalName(paramObject);
    node.nodeValue = nodeDescriptor.getNodeValue(paramObject);
    Document.AttributeListAccumulator attributeListAccumulator = new Document.AttributeListAccumulator();
    nodeDescriptor.getAttributes(paramObject, (AttributeAccumulator)attributeListAccumulator);
    node.attributes = (List<String>)attributeListAccumulator;
    ElementInfo elementInfo = paramDocumentView.getElementInfo(paramObject);
    if (elementInfo.children.size() == 0) {
      paramObject = Collections.emptyList();
    } else {
      paramObject = (Object<?>)new ArrayList(elementInfo.children.size());
    } 
    int i = 0;
    int j = elementInfo.children.size();
    while (i < j) {
      paramObject.add(createNodeForElement(elementInfo.children.get(i), paramDocumentView, paramAccumulator));
      i++;
    } 
    node.children = (List)paramObject;
    node.childNodeCount = Integer.valueOf(paramObject.size());
    return node;
  }
  
  private void releaseChildNodeInsertedEvent(ChildNodeInsertedEvent paramChildNodeInsertedEvent) {
    paramChildNodeInsertedEvent.parentNodeId = -1;
    paramChildNodeInsertedEvent.previousNodeId = -1;
    paramChildNodeInsertedEvent.node = null;
    if (this.mCachedChildNodeInsertedEvent == null)
      this.mCachedChildNodeInsertedEvent = paramChildNodeInsertedEvent; 
  }
  
  private void releaseChildNodeRemovedEvent(ChildNodeRemovedEvent paramChildNodeRemovedEvent) {
    paramChildNodeRemovedEvent.parentNodeId = -1;
    paramChildNodeRemovedEvent.nodeId = -1;
    if (this.mCachedChildNodeRemovedEvent == null)
      this.mCachedChildNodeRemovedEvent = paramChildNodeRemovedEvent; 
  }
  
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    this.mPeerManager.removePeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public void discardSearchResults(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    DiscardSearchResultsRequest discardSearchResultsRequest = (DiscardSearchResultsRequest)this.mObjectMapper.convertValue(paramJSONObject, DiscardSearchResultsRequest.class);
    if (discardSearchResultsRequest.searchId != null)
      this.mSearchResults.remove(discardSearchResultsRequest.searchId); 
  }
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    this.mPeerManager.addPeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getDocument(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    GetDocumentResponse getDocumentResponse = new GetDocumentResponse();
    getDocumentResponse.root = (Node)this.mDocument.postAndWait(new UncheckedCallable<Node>() {
          public DOM.Node call() {
            Object object = DOM.this.mDocument.getRootElement();
            DOM dOM = DOM.this;
            return dOM.createNodeForElement(object, dOM.mDocument.getDocumentView(), null);
          }
        });
    return getDocumentResponse;
  }
  
  @ChromeDevtoolsMethod
  public GetSearchResultsResponse getSearchResults(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    StringBuilder stringBuilder;
    GetSearchResultsRequest getSearchResultsRequest = (GetSearchResultsRequest)this.mObjectMapper.convertValue(paramJSONObject, GetSearchResultsRequest.class);
    if (getSearchResultsRequest.searchId == null) {
      LogUtil.w("searchId may not be null");
      return null;
    } 
    List list1 = this.mSearchResults.get(getSearchResultsRequest.searchId);
    if (list1 == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("\"");
      stringBuilder.append(getSearchResultsRequest.searchId);
      stringBuilder.append("\" is not a valid reference to a search result");
      LogUtil.w(stringBuilder.toString());
      return null;
    } 
    List<Integer> list = stringBuilder.subList(getSearchResultsRequest.fromIndex, getSearchResultsRequest.toIndex);
    GetSearchResultsResponse getSearchResultsResponse = new GetSearchResultsResponse();
    getSearchResultsResponse.nodeIds = list;
    return getSearchResultsResponse;
  }
  
  @ChromeDevtoolsMethod
  public void hideHighlight(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    this.mDocument.postAndWait(new Runnable() {
          public void run() {
            DOM.this.mDocument.hideHighlight();
          }
        });
  }
  
  @ChromeDevtoolsMethod
  public void highlightNode(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    final HighlightNodeRequest request = (HighlightNodeRequest)this.mObjectMapper.convertValue(paramJSONObject, HighlightNodeRequest.class);
    if (highlightNodeRequest.nodeId == null) {
      LogUtil.w("DOM.highlightNode was not given a nodeId; JS objectId is not supported");
      return;
    } 
    final RGBAColor contentColor = highlightNodeRequest.highlightConfig.contentColor;
    if (rGBAColor == null) {
      LogUtil.w("DOM.highlightNode was not given a color to highlight with");
      return;
    } 
    this.mDocument.postAndWait(new Runnable() {
          public void run() {
            Object object = DOM.this.mDocument.getElementForNodeId(request.nodeId.intValue());
            if (object != null)
              DOM.this.mDocument.highlightElement(object, contentColor.getColor()); 
          }
        });
  }
  
  @ChromeDevtoolsMethod
  public PerformSearchResponse performSearch(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    final PerformSearchRequest request = (PerformSearchRequest)this.mObjectMapper.convertValue(paramJSONObject, PerformSearchRequest.class);
    final ArrayListAccumulator resultNodeIds = new ArrayListAccumulator();
    this.mDocument.postAndWait(new Runnable() {
          public void run() {
            DOM.this.mDocument.findMatchingElements(request.query, (Accumulator)resultNodeIds);
          }
        });
    String str = String.valueOf(this.mResultCounter.getAndIncrement());
    this.mSearchResults.put(str, arrayListAccumulator);
    PerformSearchResponse performSearchResponse = new PerformSearchResponse();
    performSearchResponse.searchId = str;
    performSearchResponse.resultCount = arrayListAccumulator.size();
    return performSearchResponse;
  }
  
  @ChromeDevtoolsMethod
  public ResolveNodeResponse resolveNode(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) throws JsonRpcException {
    ResolveNodeResponse resolveNodeResponse;
    final ResolveNodeRequest request = (ResolveNodeRequest)this.mObjectMapper.convertValue(paramJSONObject, ResolveNodeRequest.class);
    Object object = this.mDocument.postAndWait(new UncheckedCallable<Object>() {
          public Object call() {
            return DOM.this.mDocument.getElementForNodeId(request.nodeId);
          }
        });
    if (object != null) {
      int i = Runtime.mapObject(paramJsonRpcPeer, object);
      Runtime.RemoteObject remoteObject = new Runtime.RemoteObject();
      remoteObject.type = Runtime.ObjectType.OBJECT;
      remoteObject.subtype = Runtime.ObjectSubType.NODE;
      remoteObject.className = object.getClass().getName();
      remoteObject.value = null;
      remoteObject.description = null;
      remoteObject.objectId = String.valueOf(i);
      resolveNodeResponse = new ResolveNodeResponse();
      resolveNodeResponse.object = remoteObject;
      return resolveNodeResponse;
    } 
    JsonRpcError.ErrorCode errorCode = JsonRpcError.ErrorCode.INVALID_PARAMS;
    object = new StringBuilder();
    object.append("No known nodeId=");
    object.append(((ResolveNodeRequest)resolveNodeResponse).nodeId);
    throw new JsonRpcException(new JsonRpcError(errorCode, object.toString(), null));
  }
  
  @ChromeDevtoolsMethod
  public void setAttributesAsText(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    final SetAttributesAsTextRequest request = (SetAttributesAsTextRequest)this.mObjectMapper.convertValue(paramJSONObject, SetAttributesAsTextRequest.class);
    this.mDocument.postAndWait(new Runnable() {
          public void run() {
            Object object = DOM.this.mDocument.getElementForNodeId(request.nodeId);
            if (object != null)
              DOM.this.mDocument.setAttributesAsText(object, request.text); 
          }
        });
  }
  
  @ChromeDevtoolsMethod
  public void setInspectModeEnabled(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    final SetInspectModeEnabledRequest request = (SetInspectModeEnabledRequest)this.mObjectMapper.convertValue(paramJSONObject, SetInspectModeEnabledRequest.class);
    this.mDocument.postAndWait(new Runnable() {
          public void run() {
            DOM.this.mDocument.setInspectModeEnabled(request.enabled);
          }
        });
  }
  
  static class AttributeModifiedEvent {
    @JsonProperty(required = true)
    public String name;
    
    @JsonProperty(required = true)
    public int nodeId;
    
    @JsonProperty(required = true)
    public String value;
    
    private AttributeModifiedEvent() {}
  }
  
  static class AttributeRemovedEvent {
    @JsonProperty(required = true)
    public String name;
    
    @JsonProperty(required = true)
    public int nodeId;
    
    private AttributeRemovedEvent() {}
  }
  
  static class ChildNodeInsertedEvent {
    @JsonProperty(required = true)
    public DOM.Node node;
    
    @JsonProperty(required = true)
    public int parentNodeId;
    
    @JsonProperty(required = true)
    public int previousNodeId;
    
    private ChildNodeInsertedEvent() {}
  }
  
  static class ChildNodeRemovedEvent {
    @JsonProperty(required = true)
    public int nodeId;
    
    @JsonProperty(required = true)
    public int parentNodeId;
    
    private ChildNodeRemovedEvent() {}
  }
  
  static class DiscardSearchResultsRequest {
    @JsonProperty(required = true)
    public String searchId;
  }
  
  final class DocumentUpdateListener implements Document.UpdateListener {
    private DocumentUpdateListener() {}
    
    public void onAttributeModified(Object param1Object, String param1String1, String param1String2) {
      DOM.AttributeModifiedEvent attributeModifiedEvent = new DOM.AttributeModifiedEvent();
      attributeModifiedEvent.nodeId = DOM.this.mDocument.getNodeIdForElement(param1Object).intValue();
      attributeModifiedEvent.name = param1String1;
      attributeModifiedEvent.value = param1String2;
      DOM.this.mPeerManager.sendNotificationToPeers("DOM.attributeModified", attributeModifiedEvent);
    }
    
    public void onAttributeRemoved(Object param1Object, String param1String) {
      DOM.AttributeRemovedEvent attributeRemovedEvent = new DOM.AttributeRemovedEvent();
      attributeRemovedEvent.nodeId = DOM.this.mDocument.getNodeIdForElement(param1Object).intValue();
      attributeRemovedEvent.name = param1String;
      DOM.this.mPeerManager.sendNotificationToPeers("DOM.attributeRemoved", attributeRemovedEvent);
    }
    
    public void onChildNodeInserted(DocumentView param1DocumentView, Object param1Object, int param1Int1, int param1Int2, Accumulator<Object> param1Accumulator) {
      DOM.ChildNodeInsertedEvent childNodeInsertedEvent = DOM.this.acquireChildNodeInsertedEvent();
      childNodeInsertedEvent.parentNodeId = param1Int1;
      childNodeInsertedEvent.previousNodeId = param1Int2;
      childNodeInsertedEvent.node = DOM.this.createNodeForElement(param1Object, param1DocumentView, param1Accumulator);
      DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeInserted", childNodeInsertedEvent);
      DOM.this.releaseChildNodeInsertedEvent(childNodeInsertedEvent);
    }
    
    public void onChildNodeRemoved(int param1Int1, int param1Int2) {
      DOM.ChildNodeRemovedEvent childNodeRemovedEvent = DOM.this.acquireChildNodeRemovedEvent();
      childNodeRemovedEvent.parentNodeId = param1Int1;
      childNodeRemovedEvent.nodeId = param1Int2;
      DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeRemoved", childNodeRemovedEvent);
      DOM.this.releaseChildNodeRemovedEvent(childNodeRemovedEvent);
    }
    
    public void onInspectRequested(Object param1Object) {
      Integer integer = DOM.this.mDocument.getNodeIdForElement(param1Object);
      if (integer == null) {
        LogUtil.d("DocumentProvider.Listener.onInspectRequested() called for a non-mapped node: element=%s", new Object[] { param1Object });
        return;
      } 
      param1Object = new DOM.InspectNodeRequestedEvent();
      ((DOM.InspectNodeRequestedEvent)param1Object).nodeId = integer.intValue();
      DOM.this.mPeerManager.sendNotificationToPeers("DOM.inspectNodeRequested", param1Object);
    }
  }
  
  static class GetDocumentResponse implements JsonRpcResult {
    @JsonProperty(required = true)
    public DOM.Node root;
    
    private GetDocumentResponse() {}
  }
  
  static class GetSearchResultsRequest {
    @JsonProperty(required = true)
    public int fromIndex;
    
    @JsonProperty(required = true)
    public String searchId;
    
    @JsonProperty(required = true)
    public int toIndex;
  }
  
  static class GetSearchResultsResponse implements JsonRpcResult {
    @JsonProperty(required = true)
    public List<Integer> nodeIds;
    
    private GetSearchResultsResponse() {}
  }
  
  static class HighlightConfig {
    @JsonProperty
    public DOM.RGBAColor contentColor;
  }
  
  static class HighlightNodeRequest {
    @JsonProperty(required = true)
    public DOM.HighlightConfig highlightConfig;
    
    @JsonProperty
    public Integer nodeId;
    
    @JsonProperty
    public String objectId;
  }
  
  static class InspectNodeRequestedEvent {
    @JsonProperty
    public int nodeId;
    
    private InspectNodeRequestedEvent() {}
  }
  
  static class Node implements JsonRpcResult {
    @JsonProperty
    public List<String> attributes;
    
    @JsonProperty
    public Integer childNodeCount;
    
    @JsonProperty
    public List<Node> children;
    
    @JsonProperty(required = true)
    public String localName;
    
    @JsonProperty(required = true)
    public int nodeId;
    
    @JsonProperty(required = true)
    public String nodeName;
    
    @JsonProperty(required = true)
    public NodeType nodeType;
    
    @JsonProperty(required = true)
    public String nodeValue;
    
    private Node() {}
  }
  
  final class PeerManagerListener extends PeersRegisteredListener {
    private PeerManagerListener() {}
    
    public void onFirstPeerRegistered() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield this$0 : Lcom/facebook/stetho/inspector/protocol/module/DOM;
      //   6: invokestatic access$300 : (Lcom/facebook/stetho/inspector/protocol/module/DOM;)Lcom/facebook/stetho/inspector/elements/Document;
      //   9: invokevirtual addRef : ()V
      //   12: aload_0
      //   13: getfield this$0 : Lcom/facebook/stetho/inspector/protocol/module/DOM;
      //   16: invokestatic access$300 : (Lcom/facebook/stetho/inspector/protocol/module/DOM;)Lcom/facebook/stetho/inspector/elements/Document;
      //   19: aload_0
      //   20: getfield this$0 : Lcom/facebook/stetho/inspector/protocol/module/DOM;
      //   23: invokestatic access$1900 : (Lcom/facebook/stetho/inspector/protocol/module/DOM;)Lcom/facebook/stetho/inspector/protocol/module/DOM$DocumentUpdateListener;
      //   26: invokevirtual addUpdateListener : (Lcom/facebook/stetho/inspector/elements/Document$UpdateListener;)V
      //   29: aload_0
      //   30: monitorexit
      //   31: return
      //   32: astore_1
      //   33: aload_0
      //   34: monitorexit
      //   35: aload_1
      //   36: athrow
      // Exception table:
      //   from	to	target	type
      //   2	29	32	finally
    }
    
    public void onLastPeerUnregistered() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield this$0 : Lcom/facebook/stetho/inspector/protocol/module/DOM;
      //   6: invokestatic access$2000 : (Lcom/facebook/stetho/inspector/protocol/module/DOM;)Ljava/util/Map;
      //   9: invokeinterface clear : ()V
      //   14: aload_0
      //   15: getfield this$0 : Lcom/facebook/stetho/inspector/protocol/module/DOM;
      //   18: invokestatic access$300 : (Lcom/facebook/stetho/inspector/protocol/module/DOM;)Lcom/facebook/stetho/inspector/elements/Document;
      //   21: aload_0
      //   22: getfield this$0 : Lcom/facebook/stetho/inspector/protocol/module/DOM;
      //   25: invokestatic access$1900 : (Lcom/facebook/stetho/inspector/protocol/module/DOM;)Lcom/facebook/stetho/inspector/protocol/module/DOM$DocumentUpdateListener;
      //   28: invokevirtual removeUpdateListener : (Lcom/facebook/stetho/inspector/elements/Document$UpdateListener;)V
      //   31: aload_0
      //   32: getfield this$0 : Lcom/facebook/stetho/inspector/protocol/module/DOM;
      //   35: invokestatic access$300 : (Lcom/facebook/stetho/inspector/protocol/module/DOM;)Lcom/facebook/stetho/inspector/elements/Document;
      //   38: invokevirtual release : ()V
      //   41: aload_0
      //   42: monitorexit
      //   43: return
      //   44: astore_1
      //   45: aload_0
      //   46: monitorexit
      //   47: aload_1
      //   48: athrow
      // Exception table:
      //   from	to	target	type
      //   2	41	44	finally
    }
  }
  
  static class PerformSearchRequest {
    @JsonProperty
    public Boolean includeUserAgentShadowDOM;
    
    @JsonProperty(required = true)
    public String query;
  }
  
  static class PerformSearchResponse implements JsonRpcResult {
    @JsonProperty(required = true)
    public int resultCount;
    
    @JsonProperty(required = true)
    public String searchId;
    
    private PerformSearchResponse() {}
  }
  
  static class RGBAColor {
    @JsonProperty
    public Double a;
    
    @JsonProperty(required = true)
    public int b;
    
    @JsonProperty(required = true)
    public int g;
    
    @JsonProperty(required = true)
    public int r;
    
    public int getColor() {
      Double double_ = this.a;
      byte b = -1;
      if (double_ != null) {
        long l = Math.round(double_.doubleValue() * 255.0D);
        if (l < 0L) {
          b = 0;
        } else if (l < 255L) {
          b = (byte)(int)l;
        } 
      } 
      return Color.argb(b, this.r, this.g, this.b);
    }
  }
  
  static class ResolveNodeRequest {
    @JsonProperty(required = true)
    public int nodeId;
    
    @JsonProperty
    public String objectGroup;
  }
  
  static class ResolveNodeResponse implements JsonRpcResult {
    @JsonProperty(required = true)
    public Runtime.RemoteObject object;
    
    private ResolveNodeResponse() {}
  }
  
  static class SetAttributesAsTextRequest {
    @JsonProperty(required = true)
    public int nodeId;
    
    @JsonProperty(required = true)
    public String text;
  }
  
  static class SetInspectModeEnabledRequest {
    @JsonProperty(required = true)
    public boolean enabled;
    
    @JsonProperty
    public DOM.HighlightConfig highlightConfig;
    
    @JsonProperty
    public Boolean inspectShadowDOM;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\DOM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */