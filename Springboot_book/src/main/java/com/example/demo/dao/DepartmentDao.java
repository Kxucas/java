package com.example.demo.dao;

import com.example.demo.pojo.Department;
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
public class DepartmentDao {
    //模拟数据库数据
    public static Map<Integer, Department> departments =null;

    public DepartmentDao departmentDao;
    static {
        departments =new HashMap<Integer, Department>();//部门表
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"科研部"));
        departments.put(103,new Department(103,"市场部"));
        departments.put(104,new Department(104,"运营部"));
    }
    //获取部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    //通过id获取部门
    public Department getDepartment(Integer id){
        return departments.get(id);
    }

}
