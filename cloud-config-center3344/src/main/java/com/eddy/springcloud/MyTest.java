//package com.eddy.springcloud;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyTest {
//    public static void main(String[] args) {
//        List<Department> allDepartment = new ArrayList<>();
//        Department dep1 = new Department(1, 0, "北京总部");
//        Department dep3 = new Department(3, 1, "研发中心");
//        Department dep4 = new Department(4, 3, "后端研发组");
//        Department dep6 = new Department(6, 4, "后端实习生组");
//        Department dep7 = new Department(7, 3, "前端研发组");
//        Department dep8 = new Department(8, 1, "产品部");
//        allDepartment.add(dep1);
//        allDepartment.add(dep3);
//        allDepartment.add(dep4);
//        allDepartment.add(dep6);
//        allDepartment.add(dep7);
//        allDepartment.add(dep8);
//
//        List<Department> subDepartments = MyTest.getSub(3, allDepartment);
//        for (Department subDepartment : subDepartments) {
//            System.out.println(subDepartment);
//        }
//    }
//    /**
//     * 根据id，获取所有子部门列表(包括隔代子部门)
//     * @param id
//     * @return
//     */
//    public static List<Department> getSub(int id, List<Department> allDepartment) {
//        for()
//        return null;
//    }
//
//
//}
