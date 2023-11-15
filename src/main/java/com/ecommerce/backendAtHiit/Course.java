package com.ecommerce.backendAtHiit;

import java.util.List;

public class Course {

     private String courseTitle;
     private String courseCode;
     List<String> content;

    public Course() {
    }

    public Course(String courseTitle, String courseCode, List<String> content) {
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.content = content;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseTitle='" + courseTitle + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", content=" + content +
                '}';
    }
}
