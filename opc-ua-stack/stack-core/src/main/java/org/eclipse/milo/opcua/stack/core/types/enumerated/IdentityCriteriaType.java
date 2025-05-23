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
 *     href="https://reference.opcfoundation.org/v105/Core/docs/Part18/4.4.4">https://reference.opcfoundation.org/v105/Core/docs/Part18/4.4.4</a>
 */
public enum IdentityCriteriaType implements UaEnumeratedType {
  /** The rule specifies a UserName from a UserNameIdentityToken. */
  UserName(1),

  /** The rule specifies the Thumbprint of a user or CA Certificate. */
  Thumbprint(2),

  /** The rule is a Role specified in an Access Token. */
  Role(3),

  /** The rule is a user group specified in the Access Token. */
  GroupId(4),

  /** The rule specifies Anonymous UserIdentityToken. */
  Anonymous(5),

  /** The rule specifies any non Anonymous UserIdentityToken. */
  AuthenticatedUser(6),

  /**
   * The rule specifies the combination of an application identity and an Anonymous
   * UserIdentityToken.
   */
  Application(7),

  /** The rule specifies the X509 subject name of a user or CA Certificate. */
  X509Subject(8),

  /**
   * The rule specifies any trusted application that has been authenticated with a trusted
   * ApplicationInstance Certificate.
   */
  TrustedApplication(9);

  private final int value;

  IdentityCriteriaType(int value) {
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

  public static @Nullable IdentityCriteriaType from(int value) {
    return switch (value) {
      case 1 -> UserName;
      case 2 -> Thumbprint;
      case 3 -> Role;
      case 4 -> GroupId;
      case 5 -> Anonymous;
      case 6 -> AuthenticatedUser;
      case 7 -> Application;
      case 8 -> X509Subject;
      case 9 -> TrustedApplication;
      default -> null;
    };
  }

  public static EnumDefinition definition() {
    return new EnumDefinition(
        new EnumField[] {
          new EnumField(
              1L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "The rule specifies a UserName from a UserNameIdentityToken."),
              "UserName"),
          new EnumField(
              2L,
              LocalizedText.NULL_VALUE,
              new LocalizedText(
                  "", "The rule specifies the Thumbprint of a user or CA Certificate."),
              "Thumbprint"),
          new EnumField(
              3L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "The rule is a Role specified in an Access Token."),
              "Role"),
          new EnumField(
              4L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "The rule is a user group specified in the Access Token."),
              "GroupId"),
          new EnumField(
              5L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "The rule specifies Anonymous UserIdentityToken."),
              "Anonymous"),
          new EnumField(
              6L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "The rule specifies any non Anonymous UserIdentityToken."),
              "AuthenticatedUser"),
          new EnumField(
              7L,
              LocalizedText.NULL_VALUE,
              new LocalizedText(
                  "",
                  "The rule specifies the combination of an application identity and an Anonymous"
                      + " UserIdentityToken."),
              "Application"),
          new EnumField(
              8L,
              LocalizedText.NULL_VALUE,
              new LocalizedText(
                  "", "The rule specifies the X509 subject name of a user or CA Certificate."),
              "X509Subject"),
          new EnumField(
              9L,
              LocalizedText.NULL_VALUE,
              new LocalizedText(
                  "",
                  "The rule specifies any trusted application that has been authenticated with a"
                      + " trusted ApplicationInstance Certificate."),
              "TrustedApplication")
        });
  }

  public static final class TypeInfo {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("i=15632");
  }
}
