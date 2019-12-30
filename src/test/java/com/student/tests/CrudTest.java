package com.student.tests;

import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;
import com.student.tags.*;
import io.qameta.allure.*;
import io.qameta.allure.junit4.*;
import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;

@Story("This test is for performing the CURD operation on the Student App")
public class CrudTest extends TestBase{

    RequestFactory request = new RequestFactory();
    @Story("This test is for performing the CURD operation on the Student App")
    @DisplayName("This test is to get all the student information from database")
    @Feature("This feature is to get all the student information from database")
    @Test
    public void getAllStudents(){

    request.getAllStudents()
                .then()
                .spec(SpecificationFactory.getGenericResponseSpec())
                .statusCode(200);
    }

    @Category(Regression.class)
    @Story("This test is for performing the CURD operation on the Student App")
    @DisplayName("This test is to create a new student entry into database")
    @Feature("This test is to create a new student entry into database")
    @Tag("Regression")
    @Test
    public void createNewStudent(){
        Faker fakeData = new Faker();
       String firstName = fakeData.name().firstName();
       String lastName = fakeData.name().lastName();
       String email = fakeData.internet().emailAddress();
       String programme = "Computer Science";
       List<String> courses = new ArrayList<String>();
            courses.add("C++");
            courses.add("Java");
        request.createNewStudent("",firstName,lastName,email,programme,courses)
        .then().spec(SpecificationFactory.getGenericResponseSpec())
        .statusCode(201);
    }
}
