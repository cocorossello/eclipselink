/*******************************************************************************
 * Copyright (c) 2015, 2016 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Dmitry Kornilov - initial implementation
 ******************************************************************************/
package org.eclipse.persistence.jaxb;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.metadata.ConstraintDescriptor;

/**
 * Wrapper over {@link ConstraintViolation} class. Required due to optional nature of javax.validation bundle.
 *
 * @author Dmitry Kornilov
 * @since 2.7.0
 */
public class ConstraintViolationWrapper<T> {
    private ConstraintViolation<T> constraintViolation;

    /**
     * Creates a new wrapper.
     * @param constraintViolation original object
     */
    public ConstraintViolationWrapper(ConstraintViolation<T> constraintViolation) {
        this.constraintViolation = constraintViolation;
    }

    public String getMessage() {
        return constraintViolation.getMessage();
    }


    public String getMessageTemplate() {
        return constraintViolation.getMessageTemplate();
    }

    public T getRootBean() {
        return constraintViolation.getRootBean();
    }

    public Class<T> getRootBeanClass() {
        return constraintViolation.getRootBeanClass();
    }


    public Object getLeafBean() {
        return constraintViolation.getLeafBean();
    }


    public Object[] getExecutableParameters() {
        return constraintViolation.getExecutableParameters();
    }


    public Object getExecutableReturnValue() {
        return constraintViolation.getExecutableReturnValue();
    }


    public Path getPropertyPath() {
        return constraintViolation.getPropertyPath();
    }

    public Object getInvalidValue() {
        return constraintViolation.getInvalidValue();
    }

    public ConstraintDescriptor<?> getConstraintDescriptor() {
        return constraintViolation.getConstraintDescriptor();
    }

    /**
     * Unwraps original object and returns it.
     */
    public ConstraintViolation<T> unwrap() {
        return constraintViolation;
    }
}
