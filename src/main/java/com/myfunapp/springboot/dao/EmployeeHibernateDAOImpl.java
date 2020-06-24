package com.myfunapp.springboot.dao;

import com.myfunapp.springboot.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeHibernateDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeHibernateDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployee() {
        // create the current session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        // execute the query
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee getEmployeeOfId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Employee employee = currentSession.get(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery  = currentSession.createQuery("delete from Employee where id=:employeeId");

        theQuery.setParameter("employeeId", id);

        theQuery.executeUpdate();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.save(employee);

        return employee;
    }
}
