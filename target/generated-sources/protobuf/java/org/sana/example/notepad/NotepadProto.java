// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: notepad.proto

package org.sana.example.notepad;

public final class NotepadProto {
  private NotepadProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_notepad_Task_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_notepad_Task_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_notepad_Recommendations_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_notepad_Recommendations_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rnotepad.proto\022\007notepad\032\033google/protobu" +
      "f/empty.proto\"8\n\004Task\022\r\n\005title\030\001 \001(\t\022\021\n\t" +
      "important\030\002 \001(\010\022\016\n\006urgent\030\003 \001(\010\"/\n\017Recom" +
      "mendations\022\034\n\005tasks\030\001 \003(\0132\r.notepad.Task" +
      "2T\n\007Notepad\022I\n\023RecommendPriorities\022\026.goo" +
      "gle.protobuf.Empty\032\030.notepad.Recommendat" +
      "ions\"\000B*\n\030org.sana.example.notepadB\014Note" +
      "padProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        }, assigner);
    internal_static_notepad_Task_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_notepad_Task_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_notepad_Task_descriptor,
        new java.lang.String[] { "Title", "Important", "Urgent", });
    internal_static_notepad_Recommendations_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_notepad_Recommendations_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_notepad_Recommendations_descriptor,
        new java.lang.String[] { "Tasks", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
