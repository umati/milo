/*
 * Copyright (c) 2025 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.sdk.client.model.objects;

import java.util.concurrent.CompletableFuture;
import org.eclipse.milo.opcua.sdk.client.model.variables.PropertyType;
import org.eclipse.milo.opcua.sdk.core.QualifiedProperty;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;

/**
 * @see <a
 *     href="https://reference.opcfoundation.org/v105/Core/docs/Part9/5.10.5">https://reference.opcfoundation.org/v105/Core/docs/Part9/5.10.5</a>
 */
public interface AuditConditionRespondEventType extends AuditConditionEventType {
  QualifiedProperty<UInteger> SELECTED_RESPONSE =
      new QualifiedProperty<>(
          "http://opcfoundation.org/UA/",
          "SelectedResponse",
          ExpandedNodeId.parse("nsu=http://opcfoundation.org/UA/;i=7"),
          -1,
          UInteger.class);

  /**
   * Get the local value of the SelectedResponse Node.
   *
   * <p>The returned value is the last seen; it is not read live from the server.
   *
   * @return the local value of the SelectedResponse Node.
   * @throws UaException if an error occurs creating or getting the SelectedResponse Node.
   */
  UInteger getSelectedResponse() throws UaException;

  /**
   * Set the local value of the SelectedResponse Node.
   *
   * <p>The value is only updated locally; it is not written to the server.
   *
   * @param value the local value to set for the SelectedResponse Node.
   * @throws UaException if an error occurs creating or getting the SelectedResponse Node.
   */
  void setSelectedResponse(UInteger value) throws UaException;

  /**
   * Read the value of the SelectedResponse Node from the server and update the local value if the
   * operation succeeds.
   *
   * @return the {@link UInteger} value read from the server.
   * @throws UaException if a service- or operation-level error occurs.
   */
  UInteger readSelectedResponse() throws UaException;

  /**
   * Write a new value for the SelectedResponse Node to the server and update the local value if the
   * operation succeeds.
   *
   * @param value the {@link UInteger} value to write to the server.
   * @throws UaException if a service- or operation-level error occurs.
   */
  void writeSelectedResponse(UInteger value) throws UaException;

  /**
   * An asynchronous implementation of {@link #readSelectedResponse}.
   *
   * @return a CompletableFuture that completes successfully with the value or completes
   *     exceptionally if an operation- or service-level error occurs.
   */
  CompletableFuture<? extends UInteger> readSelectedResponseAsync();

  /**
   * An asynchronous implementation of {@link #writeSelectedResponse}.
   *
   * @return a CompletableFuture that completes successfully with the operation result or completes
   *     exceptionally if a service-level error occurs.
   */
  CompletableFuture<StatusCode> writeSelectedResponseAsync(UInteger value);

  /**
   * Get the SelectedResponse {@link PropertyType} Node, or {@code null} if it does not exist.
   *
   * <p>The Node is created when first accessed and cached for subsequent calls.
   *
   * @return the SelectedResponse {@link PropertyType} Node, or {@code null} if it does not exist.
   * @throws UaException if an error occurs creating or getting the Node.
   */
  PropertyType getSelectedResponseNode() throws UaException;

  /**
   * Asynchronous implementation of {@link #getSelectedResponseNode()}.
   *
   * @return a CompletableFuture that completes successfully with the PropertyType Node or completes
   *     exceptionally if an error occurs creating or getting the Node.
   */
  CompletableFuture<? extends PropertyType> getSelectedResponseNodeAsync();
}
