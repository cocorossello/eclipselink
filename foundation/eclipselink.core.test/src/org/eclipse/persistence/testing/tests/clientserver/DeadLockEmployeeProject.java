/*
 * Copyright (c) 1998, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.testing.tests.clientserver;

import org.eclipse.persistence.sessions.*;
import org.eclipse.persistence.descriptors.*;
import org.eclipse.persistence.mappings.*;
import org.eclipse.persistence.mappings.converters.*;
import org.eclipse.persistence.descriptors.RelationalDescriptor;

/**
 * This class was generated by the TopLink project class generator.
 * It stores the meta-data (descriptors) that define the TopLink mappings.
 * ## TopLink - 4.5.0 (Build 415) ##
 * @see org.eclipse.persistence.sessions.factories.ProjectClassGenerator
 */
public class DeadLockEmployeeProject extends org.eclipse.persistence.sessions.Project {
    public DeadLockEmployeeProject() {
        setName("ThreeTierEmployee");
        applyLogin();

        addDescriptor(buildAddressDescriptor());
        addDescriptor(buildEmployeeDescriptor());

    }

    public void applyLogin() {
        DatabaseLogin login = new DatabaseLogin();
        setLogin(login);
    }

    public RelationalDescriptor buildAddressDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.tests.clientserver.DeadLockAddress.class);
        descriptor.addTableName("DEADLOCK_ADDRESS");
        descriptor.addPrimaryKeyFieldName("DEADLOCK_ADDRESS.ADDRESS_ID");

        // RelationalDescriptor properties.
        descriptor.useSoftCacheWeakIdentityMap();
        descriptor.setIdentityMapSize(100);
        descriptor.setSequenceNumberFieldName("DEADLOCK_ADDRESS.ADDRESS_ID");
        descriptor.setSequenceNumberName("DEADLOCK_ADDRESS_SEQ");
        descriptor.setAlias("DeadLockAddress");

        // Query manager.
        descriptor.getQueryManager().checkCacheForDoesExist();

        //Named Queries
        // Event manager.
        // Mappings.
        DirectToFieldMapping cityMapping = new DirectToFieldMapping();
        cityMapping.setAttributeName("city");
        cityMapping.setFieldName("DEADLOCK_ADDRESS.CITY");
        descriptor.addMapping(cityMapping);

        DirectToFieldMapping countryMapping = new DirectToFieldMapping();
        countryMapping.setAttributeName("country");
        countryMapping.setFieldName("DEADLOCK_ADDRESS.COUNTRY");
        descriptor.addMapping(countryMapping);

        DirectToFieldMapping idMapping = new DirectToFieldMapping();
        idMapping.setAttributeName("id");
        idMapping.setFieldName("DEADLOCK_ADDRESS.ADDRESS_ID");
        descriptor.addMapping(idMapping);

        DirectToFieldMapping postalCodeMapping = new DirectToFieldMapping();
        postalCodeMapping.setAttributeName("postalCode");
        postalCodeMapping.setFieldName("DEADLOCK_ADDRESS.P_CODE");
        descriptor.addMapping(postalCodeMapping);

        DirectToFieldMapping provinceMapping = new DirectToFieldMapping();
        provinceMapping.setAttributeName("province");
        provinceMapping.setFieldName("DEADLOCK_ADDRESS.PROVINCE");
        descriptor.addMapping(provinceMapping);

        DirectToFieldMapping streetMapping = new DirectToFieldMapping();
        streetMapping.setAttributeName("street");
        streetMapping.setFieldName("DEADLOCK_ADDRESS.STREET");
        descriptor.addMapping(streetMapping);

        return descriptor;
    }

    public RelationalDescriptor buildEmployeeDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.tests.clientserver.DeadLockEmployee.class);
        descriptor.addTableName("DEADLOCK_EMPLOYEE");
        descriptor.addPrimaryKeyFieldName("DEADLOCK_EMPLOYEE.EMP_ID");

        // RelationalDescriptor properties.
        descriptor.useSoftCacheWeakIdentityMap();
        descriptor.setIdentityMapSize(100);
        descriptor.setSequenceNumberFieldName("DEADLOCK_EMPLOYEE.EMP_ID");
        descriptor.setSequenceNumberName("DEADLOCK_EMP_SEQ");
        VersionLockingPolicy lockingPolicy = new VersionLockingPolicy();
        lockingPolicy.setWriteLockFieldName("DEADLOCK_EMPLOYEE.VERSION");
        descriptor.setOptimisticLockingPolicy(lockingPolicy);
        //    descriptor.setAlias("Employee");
        // Query manager.
        descriptor.getQueryManager().checkCacheForDoesExist();

        //Named Queries
        // Event manager.
        // Mappings.
        DirectToFieldMapping firstNameMapping = new DirectToFieldMapping();
        firstNameMapping.setAttributeName("firstName");
        firstNameMapping.setFieldName("DEADLOCK_EMPLOYEE.F_NAME");
        descriptor.addMapping(firstNameMapping);

        DirectToFieldMapping idMapping = new DirectToFieldMapping();
        idMapping.setAttributeName("id");
        idMapping.setFieldName("DEADLOCK_EMPLOYEE.EMP_ID");
        descriptor.addMapping(idMapping);

        DirectToFieldMapping lastNameMapping = new DirectToFieldMapping();
        lastNameMapping.setAttributeName("lastName");
        lastNameMapping.setFieldName("DEADLOCK_EMPLOYEE.L_NAME");
        descriptor.addMapping(lastNameMapping);

        DirectToFieldMapping genderMapping = new DirectToFieldMapping();
        ObjectTypeConverter genderConverter = new ObjectTypeConverter();
        genderMapping.setAttributeName("gender");
        genderMapping.setFieldName("DEADLOCK_EMPLOYEE.GENDER");
        genderConverter.addConversionValue("F", "Female");
        genderConverter.addConversionValue("M", "Male");
        genderMapping.setConverter(genderConverter);
        descriptor.addMapping(genderMapping);

        OneToOneMapping addressMapping = new OneToOneMapping();
        addressMapping.setAttributeName("address");
        addressMapping.setReferenceClass(DeadLockAddress.class);
        addressMapping.dontUseIndirection();
        addressMapping.privateOwnedRelationship();
        addressMapping.addForeignKeyFieldName("DEADLOCK_EMPLOYEE.ADDR_ID", "DEADLOCK_ADDRESS.ADDRESS_ID");
        descriptor.addMapping(addressMapping);

        return descriptor;
    }
}
