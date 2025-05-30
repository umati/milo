/*
 * Copyright (c) 2025 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.sdk.test;

import org.eclipse.milo.opcua.sdk.core.ValueRanks;
import org.eclipse.milo.opcua.sdk.server.methods.AbstractMethodInvocationHandler;
import org.eclipse.milo.opcua.sdk.server.nodes.UaMethodNode;
import org.eclipse.milo.opcua.stack.core.NodeIds;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.structured.Argument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqrtMethod extends AbstractMethodInvocationHandler {

  public static final Argument X =
      new Argument("x", NodeIds.Double, ValueRanks.Scalar, null, new LocalizedText("A value."));

  public static final Argument X_SQRT =
      new Argument(
          "x_sqrt", NodeIds.Double, ValueRanks.Scalar, null, new LocalizedText("A value."));

  private final Logger logger = LoggerFactory.getLogger(getClass());

  public SqrtMethod(UaMethodNode node) {
    super(node);
  }

  @Override
  public Argument[] getInputArguments() {
    return new Argument[] {X};
  }

  @Override
  public Argument[] getOutputArguments() {
    return new Argument[] {X_SQRT};
  }

  @Override
  protected Variant[] invoke(InvocationContext invocationContext, Variant[] inputValues) {
    logger.debug("Invoking sqrt() method of objectId={}", invocationContext.getObjectId());

    double x = (double) inputValues[0].value();
    double xSqrt = Math.sqrt(x);

    return new Variant[] {new Variant(xSqrt)};
  }
}
