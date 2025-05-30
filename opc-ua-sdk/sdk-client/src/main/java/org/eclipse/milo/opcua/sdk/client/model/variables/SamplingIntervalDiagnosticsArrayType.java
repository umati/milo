/*
 * Copyright (c) 2025 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.sdk.client.model.variables;

import java.util.concurrent.CompletableFuture;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.structured.SamplingIntervalDiagnosticsDataType;

/**
 * @see <a
 *     href="https://reference.opcfoundation.org/v105/Core/docs/Part5/7.9">https://reference.opcfoundation.org/v105/Core/docs/Part5/7.9</a>
 */
public interface SamplingIntervalDiagnosticsArrayType extends BaseDataVariableType {
  /**
   * Get the local value of the SamplingIntervalDiagnostics Node.
   *
   * <p>The returned value is the last seen; it is not read live from the server.
   *
   * @return the local value of the SamplingIntervalDiagnostics Node.
   * @throws UaException if an error occurs creating or getting the SamplingIntervalDiagnostics
   *     Node.
   */
  SamplingIntervalDiagnosticsDataType getSamplingIntervalDiagnostics() throws UaException;

  /**
   * Set the local value of the SamplingIntervalDiagnostics Node.
   *
   * <p>The value is only updated locally; it is not written to the server.
   *
   * @param value the local value to set for the SamplingIntervalDiagnostics Node.
   * @throws UaException if an error occurs creating or getting the SamplingIntervalDiagnostics
   *     Node.
   */
  void setSamplingIntervalDiagnostics(SamplingIntervalDiagnosticsDataType value) throws UaException;

  /**
   * Read the value of the SamplingIntervalDiagnostics Node from the server and update the local
   * value if the operation succeeds.
   *
   * @return the {@link SamplingIntervalDiagnosticsDataType} value read from the server.
   * @throws UaException if a service- or operation-level error occurs.
   */
  SamplingIntervalDiagnosticsDataType readSamplingIntervalDiagnostics() throws UaException;

  /**
   * Write a new value for the SamplingIntervalDiagnostics Node to the server and update the local
   * value if the operation succeeds.
   *
   * @param value the {@link SamplingIntervalDiagnosticsDataType} value to write to the server.
   * @throws UaException if a service- or operation-level error occurs.
   */
  void writeSamplingIntervalDiagnostics(SamplingIntervalDiagnosticsDataType value)
      throws UaException;

  /**
   * An asynchronous implementation of {@link #readSamplingIntervalDiagnostics}.
   *
   * @return a CompletableFuture that completes successfully with the value or completes
   *     exceptionally if an operation- or service-level error occurs.
   */
  CompletableFuture<? extends SamplingIntervalDiagnosticsDataType>
      readSamplingIntervalDiagnosticsAsync();

  /**
   * An asynchronous implementation of {@link #writeSamplingIntervalDiagnostics}.
   *
   * @return a CompletableFuture that completes successfully with the operation result or completes
   *     exceptionally if a service-level error occurs.
   */
  CompletableFuture<StatusCode> writeSamplingIntervalDiagnosticsAsync(
      SamplingIntervalDiagnosticsDataType value);

  /**
   * Get the SamplingIntervalDiagnostics {@link SamplingIntervalDiagnosticsType} Node, or {@code
   * null} if it does not exist.
   *
   * <p>The Node is created when first accessed and cached for subsequent calls.
   *
   * @return the SamplingIntervalDiagnostics {@link SamplingIntervalDiagnosticsType} Node, or {@code
   *     null} if it does not exist.
   * @throws UaException if an error occurs creating or getting the Node.
   */
  SamplingIntervalDiagnosticsType getSamplingIntervalDiagnosticsNode() throws UaException;

  /**
   * Asynchronous implementation of {@link #getSamplingIntervalDiagnosticsNode()}.
   *
   * @return a CompletableFuture that completes successfully with the
   *     SamplingIntervalDiagnosticsType Node or completes exceptionally if an error occurs creating
   *     or getting the Node.
   */
  CompletableFuture<? extends SamplingIntervalDiagnosticsType>
      getSamplingIntervalDiagnosticsNodeAsync();
}
