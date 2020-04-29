package com.example.demo.dao;

import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
//部门dao

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDao {

    //模拟数据库数据

    public static Map<Integer, Employee> employees =null;

    @Autowired
    public DepartmentDao departmentDao;
    static {

        employees =new HashMap<Integer, Employee>();//部门表
        employees.put(1011,new Employee(1011,"aa","ad@qq.com",1,new Department(101,"后勤")));
        employees.put(1012,new Employee(1012,"bb","ad@qq.com",1,new Department(102,"后勤")));
        employees.put(1013,new Employee(1013,"cc","ad@qq.com",1,new Department(103,"后勤")));
        employees.put(1014,new Employee(1014,"dd","ad@qq.com",1,new Department(104,"后勤")));

    }
    public static Integer initId =1014;
    public void save(Employee employee){
        if(employee.getId() ==null)
            employee.setId(++initId);

        employees.put(employee.getId(),employee);
    }
    //获取部门信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    public void delete(Integer id){
        employees.remove(id);
    }

}
