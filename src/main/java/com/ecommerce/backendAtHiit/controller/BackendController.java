package com.ecommerce.backendAtHiit.controller;

import com.ecommerce.backendAtHiit.Course;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BackendController {

    List<String> usernames = new ArrayList<>(Arrays.asList("Azeem Shila","John Terry", "Frank Lampard","Kate Henshaw", "Roger Miller", "Seun Akinlade"));
    List<Course> availableCourses = new ArrayList<>(List.of(new Course("Web Development","Web101",List.of("HTML","CSS","Javascript") ),new Course("Networking","Net101",List.of("IP Management","Routing","Caching") )) );
    @RequestMapping("/")
    public String homepage(){
      return "Welcome to Spring";
    }
    @RequestMapping("/users/count")
    public int noOfUsers(){
        return usernames.size();
    }
    @RequestMapping("/usernames")
    public List<String> users(){
        return usernames;
    }
    @RequestMapping("/usernames/{id}")
    public String getSpecificUser(@PathVariable(name = "id") Integer userId){
        if (userId < 0 || userId > usernames.size()) {
            return "Invalid";
        }
    int i= userId -1;
    return usernames.get(i);

   }
   @GetMapping("/courses")
    public List<Course> getCourses(){
        return availableCourses;
   }
    @GetMapping("/courses/{id}")
    public Course getCourses(@PathVariable(name = "id") Integer courseId){
        int i = courseId -1;
        return availableCourses.get(i);
    }
    @GetMapping("/coursecode/{id}")
    public String getCourseCode(@PathVariable(name = "id") Integer courseId){
        int i = courseId -1;
        return availableCourses.get(i).getCourseCode();
    }
    @GetMapping("/courses/{id}/content")
    public List<String> getCourseContent(@PathVariable(name = "id") Integer courseId){
        int i = courseId-1;
        return availableCourses.get(i).getContent();
    }
    @GetMapping("/course/search")
    public ResponseEntity<?> getCourseByParam(@RequestParam(name = "title") String title){
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(HttpStatus.PROCESSING);
        Course data = null;
        for (Course course: availableCourses) {
            if (course.getCourseTitle().equalsIgnoreCase(title)) {
                data = course;
                break;
            }
        }
            if (data == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            responseEntity = new ResponseEntity<>(data,HttpStatus.OK);

        return responseEntity;
    }
    @GetMapping("/course")
    public ResponseEntity<?> getCourseByParams(@RequestParam(name = "title") String title, @RequestParam(name = "code") String code){
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(HttpStatus.PROCESSING);
        Course data = null;
        for (Course course: availableCourses) {
            if (course.getCourseTitle().equalsIgnoreCase(title) || course.getCourseCode().equalsIgnoreCase(code) ){
                data = course;
                break;
            }
        }
        if (data == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        responseEntity = new ResponseEntity<>(data,HttpStatus.OK);

        return responseEntity;
    }
    @GetMapping("/courses/{id}/content/{contentId}")
    public String getCourseContentById(@PathVariable(name = "id") Integer courseId, @PathVariable Integer contentId){
        int i = courseId-1;
        int j = contentId-1;
        return availableCourses.get(i).getContent().get(j);
    }
    @PostMapping("/course/create")
    public ResponseEntity<?> createCourse(@Valid @RequestBody Course course){
        availableCourses.add(course);
        return null;
    }
}