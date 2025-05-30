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
 *     href="https://reference.opcfoundation.org/v105/Core/docs/Part4/7.7.3">https://reference.opcfoundation.org/v105/Core/docs/Part4/7.7.3</a>
 */
public enum FilterOperator implements UaEnumeratedType {
  Equals(0),

  IsNull(1),

  GreaterThan(2),

  LessThan(3),

  GreaterThanOrEqual(4),

  LessThanOrEqual(5),

  Like(6),

  Not(7),

  Between(8),

  InList(9),

  And(10),

  Or(11),

  Cast(12),

  InView(13),

  OfType(14),

  RelatedTo(15),

  BitwiseAnd(16),

  BitwiseOr(17);

  private final int value;

  FilterOperator(int value) {
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

  public static @Nullable FilterOperator from(int value) {
    return switch (value) {
      case 0 -> Equals;
      case 1 -> IsNull;
      case 2 -> GreaterThan;
      case 3 -> LessThan;
      case 4 -> GreaterThanOrEqual;
      case 5 -> LessThanOrEqual;
      case 6 -> Like;
      case 7 -> Not;
      case 8 -> Between;
      case 9 -> InList;
      case 10 -> And;
      case 11 -> Or;
      case 12 -> Cast;
      case 13 -> InView;
      case 14 -> OfType;
      case 15 -> RelatedTo;
      case 16 -> BitwiseAnd;
      case 17 -> BitwiseOr;
      default -> null;
    };
  }

  public static EnumDefinition definition() {
    return new EnumDefinition(
        new EnumField[] {
          new EnumField(0L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "Equals"),
          new EnumField(1L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "IsNull"),
          new EnumField(2L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "GreaterThan"),
          new EnumField(3L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "LessThan"),
          new EnumField(
              4L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "GreaterThanOrEqual"),
          new EnumField(5L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "LessThanOrEqual"),
          new EnumField(6L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "Like"),
          new EnumField(7L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "Not"),
          new EnumField(8L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "Between"),
          new EnumField(9L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "InList"),
          new EnumField(10L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "And"),
          new EnumField(11L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "Or"),
          new EnumField(12L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "Cast"),
          new EnumField(13L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "InView"),
          new EnumField(14L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "OfType"),
          new EnumField(15L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "RelatedTo"),
          new EnumField(16L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "BitwiseAnd"),
          new EnumField(17L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "BitwiseOr")
        });
  }

  public static final class TypeInfo {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("i=576");
  }
}
