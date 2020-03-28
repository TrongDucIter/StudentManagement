/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Course;
import java.util.List;

/**
 *
 * @author PC
 */
public interface CourseDao {

    public List<Course> getAll();
    public Course getCourse(String id);

    public void insertCourses(List<Course> courses);

}
