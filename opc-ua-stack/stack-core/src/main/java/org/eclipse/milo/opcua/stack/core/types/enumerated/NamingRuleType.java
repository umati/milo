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

public enum NamingRuleType implements UaEnumeratedType {
  /** The BrowseName must appear in all instances of the type. */
  Mandatory(1),

  /** The BrowseName may appear in an instance of the type. */
  Optional(2),

  /**
   * The modelling rule defines a constraint and the BrowseName is not used in an instance of the
   * type.
   */
  Constraint(3);

  private final int value;

  NamingRuleType(int value) {
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

  public static @Nullable NamingRuleType from(int value) {
    return switch (value) {
      case 1 -> Mandatory;
      case 2 -> Optional;
      case 3 -> Constraint;
      default -> null;
    };
  }

  public static EnumDefinition definition() {
    return new EnumDefinition(
        new EnumField[] {
          new EnumField(
              1L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "The BrowseName must appear in all instances of the type."),
              "Mandatory"),
          new EnumField(
              2L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "The BrowseName may appear in an instance of the type."),
              "Optional"),
          new EnumField(
              3L,
              LocalizedText.NULL_VALUE,
              new LocalizedText(
                  "",
                  "The modelling rule defines a constraint and the BrowseName is not used in an"
                      + " instance of the type."),
              "Constraint")
        });
  }

  public static final class TypeInfo {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("i=120");
  }
}
