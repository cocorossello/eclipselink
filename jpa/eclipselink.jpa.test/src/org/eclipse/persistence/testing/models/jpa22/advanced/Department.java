/*
 * Copyright (c) 2012, 2018 Oracle and/or its affiliates. All rights reserved.
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
//     02/08/2012-2.4 Guy Pelletier
//       - 350487: JPA 2.1 Specification defined support for Stored Procedure Calls
package org.eclipse.persistence.testing.models.jpa22.advanced;

import java.io.Serializable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.TABLE;

@Entity
@Table(name = "JPA22_DEPT")
public class Department implements Serializable {
    private Integer id;
    private String name;
    private Employee departmentHead;

    private Collection<Employee> employees;
    private Collection<Employee> managers;
    
    private Map<PhoneNumber,Employee> employeesByPhoneNumber;

    public Department() {
        this("");
    }

    public Department(String name) {
        this.name = name;
        this.managers = new Vector<>();
        employeesByPhoneNumber = new HashMap<>();
    }

    public void addManager(Employee employee) {
        if (employee != null && managers != null && !managers.contains(employee)) {
            this.managers.add(employee);
        }
    }

    @OneToOne(optional=true)
    @JoinColumn(name="DEPT_HEAD", nullable=true)
    public Employee getDepartmentHead() {
        return this.departmentHead;
    }

    @OneToMany(mappedBy = "department")
    public Collection<Employee> getEmployees() {
        return employees;
    }

    @Id
    @GeneratedValue(strategy = TABLE, generator = "DEPARTMENT_TABLE_GENERATOR")
    @TableGenerator(
            name = "DEPARTMENT_TABLE_GENERATOR",
            table = "CMP3_DEPARTMENT_SEQ",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT",
            pkColumnValue = "DEPT_SEQ")
    public Integer getId() {
        return id;
    }

    @OneToMany(cascade = PERSIST)
    public Collection<Employee> getManagers() {
        return managers;
    }

    @OneToMany(mappedBy = "department")
    @MapKeyJoinColumn(name = "PHONE_OWNER_ID", updatable = false, insertable = false, nullable = false, referencedColumnName = "OWNER_ID")
    @MapKeyJoinColumn(name = "PHONE_TYPE", referencedColumnName = "TYPE")
    public Map<PhoneNumber, Employee> getEmployeesByPhoneNumber() {
        return employeesByPhoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setDepartmentHead(Employee employee) {
        this.departmentHead = employee;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setManagers(Collection<Employee> managers) {
        this.managers = managers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeesByPhoneNumber(Map<PhoneNumber, Employee> employeesByPhoneNumber) {
        this.employeesByPhoneNumber = employeesByPhoneNumber;
    }
}
