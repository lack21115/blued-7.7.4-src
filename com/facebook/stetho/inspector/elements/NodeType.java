package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.json.annotation.JsonValue;

public enum NodeType {
  COMMENT_NODE,
  DOCUMENT_FRAGMENT_NODE,
  DOCUMENT_NODE,
  DOCUMENT_TYPE_NODE,
  ELEMENT_NODE(1),
  PROCESSING_INSTRUCTION_NODE(1),
  TEXT_NODE(3);
  
  private final int mValue;
  
  static {
    PROCESSING_INSTRUCTION_NODE = new NodeType("PROCESSING_INSTRUCTION_NODE", 2, 7);
    COMMENT_NODE = new NodeType("COMMENT_NODE", 3, 8);
    DOCUMENT_NODE = new NodeType("DOCUMENT_NODE", 4, 9);
    DOCUMENT_TYPE_NODE = new NodeType("DOCUMENT_TYPE_NODE", 5, 10);
    DOCUMENT_FRAGMENT_NODE = new NodeType("DOCUMENT_FRAGMENT_NODE", 6, 11);
    $VALUES = new NodeType[] { ELEMENT_NODE, TEXT_NODE, PROCESSING_INSTRUCTION_NODE, COMMENT_NODE, DOCUMENT_NODE, DOCUMENT_TYPE_NODE, DOCUMENT_FRAGMENT_NODE };
  }
  
  NodeType(int paramInt1) {
    this.mValue = paramInt1;
  }
  
  @JsonValue
  public int getProtocolValue() {
    return this.mValue;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\NodeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */