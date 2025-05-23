/*
 * Copyright (c) 2025 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.types.enumerated;

import org.eclipse.milo.opcua.stack.core.types.UaEnumeratedType;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.structured.EnumDefinition;
import org.eclipse.milo.opcua.stack.core.types.structured.EnumField;
import org.jspecify.annotations.Nullable;

/**
 * @see <a
 *     href="https://reference.opcfoundation.org/v105/Core/docs/Part22/5.3.1/#5.3.1.6">https://reference.opcfoundation.org/v105/Core/docs/Part22/5.3.1/#5.3.1.6</a>
 */
public enum TsnStreamState implements UaEnumeratedType {
  /** The related TSN Stream is currently disabled. */
  Disabled(0),

  /**
   * The related TSN Stream is in the process of receiving configuration parameters from the TSN
   * Control Layer.
   */
  Configuring(1),

  /**
   * The related TSN Stream has successfully received and applied the configuration from the TSN
   * Control Layer. The related TSN Stream is not fully operational as long as local preconditions
   * (e.g. synchronization state) are not valid.
   */
  Ready(2),

  /**
   * The related TSN Stream object is configured and all other required preconditions (e.g.
   * synchronization state) for sending / receiving data are valid.
   */
  Operational(3),

  /** The related TSN Stream object is in an error state. */
  Error(4);

  private final int value;

  TsnStreamState(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public ExpandedNodeId getTypeId() {
    return TypeInfo.TYPE_ID;
  }

  public static @Nullable TsnStreamState from(int value) {
    return switch (value) {
      case 0 -> Disabled;
      case 1 -> Configuring;
      case 2 -> Ready;
      case 3 -> Operational;
      case 4 -> Error;
      default -> null;
    };
  }

  public static EnumDefinition definition() {
    return new EnumDefinition(
        new EnumField[] {
          new EnumField(
              0L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "The related TSN Stream is currently disabled."),
              "Disabled"),
          new EnumField(
              1L,
              LocalizedText.NULL_VALUE,
              new LocalizedText(
                  "",
                  "The related TSN Stream is in the process of receiving configuration parameters"
                      + " from the TSN Control Layer."),
              "Configuring"),
          new EnumField(
              2L,
              LocalizedText.NULL_VALUE,
              new LocalizedText(
                  "",
                  "The related TSN Stream has successfully received and applied the configuration"
                      + " from the TSN Control Layer. The related TSN Stream is not fully"
                      + " operational as long as local preconditions (e.g. synchronization state)"
                      + " are not valid."),
              "Ready"),
          new EnumField(
              3L,
              LocalizedText.NULL_VALUE,
              new LocalizedText(
                  "",
                  "The related TSN Stream object is configured and all other required preconditions"
                      + " (e.g. synchronization state) for sending / receiving data are valid."),
              "Operational"),
          new EnumField(
              4L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "The related TSN Stream object is in an error state."),
              "Error")
        });
  }

  public static final class TypeInfo {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("i=24220");
  }
}
