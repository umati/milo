/*
 * Copyright (c) 2024 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.sdk.client;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.eclipse.milo.opcua.sdk.client.nodes.UaVariableNode;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UByte;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.NodeClass;
import org.eclipse.milo.opcua.stack.core.types.structured.AccessLevelExType;
import org.eclipse.milo.opcua.stack.core.types.structured.AccessRestrictionType;
import org.eclipse.milo.opcua.stack.core.types.structured.RolePermissionType;

public class VariableTypeManager {

  private final ConcurrentMap<NodeId, VariableTypeDefinition> typeDefinitions =
      new ConcurrentHashMap<>();

  public void registerVariableType(
      NodeId typeDefinition,
      Class<? extends UaVariableNode> nodeClass,
      VariableNodeConstructor variableNodeConstructor) {

    typeDefinitions.put(
        typeDefinition, new VariableTypeDefinition(nodeClass, variableNodeConstructor));
  }

  public void registerVariableType(
      NodeId typeDefinition,
      Class<? extends UaVariableNode> nodeClass,
      LegacyVariableNodeConstructor variableNodeConstructor) {

    VariableNodeConstructor adapted =
        new VariableNodeConstructor() {
          @Override
          public UaVariableNode apply(
              OpcUaClient client,
              NodeId nodeId,
              NodeClass nodeClass,
              QualifiedName browseName,
              LocalizedText displayName,
              LocalizedText description,
              UInteger writeMask,
              UInteger userWriteMask,
              RolePermissionType[] rolePermissions,
              RolePermissionType[] userRolePermissions,
              AccessRestrictionType accessRestrictions,
              DataValue value,
              NodeId dataType,
              Integer valueRank,
              UInteger[] arrayDimensions,
              UByte accessLevel,
              UByte userAccessLevel,
              Double minimumSamplingInterval,
              Boolean historizing,
              AccessLevelExType accessLevelEx) {

            return variableNodeConstructor.apply(
                client,
                nodeId,
                nodeClass,
                browseName,
                displayName,
                description,
                writeMask,
                userWriteMask,
                value,
                dataType,
                valueRank,
                arrayDimensions,
                accessLevel,
                userAccessLevel,
                minimumSamplingInterval,
                historizing);
          }
        };

    typeDefinitions.put(typeDefinition, new VariableTypeDefinition(nodeClass, adapted));
  }

  public Optional<VariableNodeConstructor> getNodeConstructor(NodeId typeDefinition) {
    VariableTypeDefinition def = typeDefinitions.get(typeDefinition);

    return Optional.ofNullable(def).map(d -> d.nodeConstructor);
  }

  private static class VariableTypeDefinition {
    final Class<? extends UaVariableNode> nodeClass;
    final VariableNodeConstructor nodeConstructor;

    private VariableTypeDefinition(
        Class<? extends UaVariableNode> nodeClass, VariableNodeConstructor nodeConstructor) {

      this.nodeClass = nodeClass;
      this.nodeConstructor = nodeConstructor;
    }
  }

  @FunctionalInterface
  public interface VariableNodeConstructor {

    UaVariableNode apply(
        OpcUaClient client,
        NodeId nodeId,
        NodeClass nodeClass,
        QualifiedName browseName,
        LocalizedText displayName,
        LocalizedText description,
        UInteger writeMask,
        UInteger userWriteMask,
        RolePermissionType[] rolePermissions,
        RolePermissionType[] userRolePermissions,
        AccessRestrictionType accessRestrictions,
        DataValue value,
        NodeId dataType,
        Integer valueRank,
        UInteger[] arrayDimensions,
        UByte accessLevel,
        UByte userAccessLevel,
        Double minimumSamplingInterval,
        Boolean historizing,
        AccessLevelExType accessLevelEx);
  }

  @FunctionalInterface
  public interface LegacyVariableNodeConstructor {

    UaVariableNode apply(
        OpcUaClient client,
        NodeId nodeId,
        NodeClass nodeClass,
        QualifiedName browseName,
        LocalizedText displayName,
        LocalizedText description,
        UInteger writeMask,
        UInteger userWriteMask,
        DataValue value,
        NodeId dataType,
        Integer valueRank,
        UInteger[] arrayDimensions,
        UByte accessLevel,
        UByte userAccessLevel,
        Double minimumSamplingInterval,
        Boolean historizing);
  }
}
