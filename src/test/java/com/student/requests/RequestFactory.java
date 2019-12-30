package com.student.requests;

import com.student.pojo.StudentClass;
import com.student.tests.TestBase;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class RequestFactory extends TestBase {

    RestClient restClient = new RestClient();

    @Step("This method is to get all the data present in the database")
    public Response getAllStudents(){

        Response response = restClient.doGetRequest("/list");
        return response;
    }

    /*
    * @param:url, firstName,lastName,email,programme,courses
    * */
    @Step("This method is used to create a new Student entry into the DB with the following details: FirstName: {1} ,LastName: {2} ,Email: {3} ,Programme: {4} ,Courses: {5}")
    public Response createNewStudent(String url,String firstName,String lastName,String email,String programme,
                                     List<String> courses){
        StudentClass body = new StudentClass();
        body.setFirstName(firstName);
        body.setLastName(lastName);
        body.setEmail(email);
        body.setProgramme(programme);
        body.setCourses(courses);
        return restClient.doPostRequest(url,body);
    }
    @Step("Updating student information with studentId: {0}, firstName: {1}, lastName: {2}, email: {3}, programme: {4}, courses: {5}")
    public   Response updateStudent(int studentid, String firstName,
                                    String lastName, String email, String programme,
                                    List<String> courses) {

        StudentClass student = new StudentClass();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);

        return restClient.doPutRequest("/" + studentid, student);

    }

    @Step("Deleting student info with Id: {0}")
    public  Response deleteStudent(int studentId) {

        return restClient.doDeleteRequest("/" + studentId);

    }

    public  Response getStudentById(int studentId){

        return restClient.doGetRequest("/" + studentId);


    }
}
