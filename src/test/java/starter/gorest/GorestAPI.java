package starter.gorest;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class GorestAPI {

    public static String CREATE_NEW_USER = Constants.BASE_URL + "/public/v2/users";
    public static String GET_USER_DETAILS_WITH_ID = Constants.BASE_URL + "/public/v2/users/{id}";
    public static String GET_USER_DETAILS_NAME_GENDER = Constants.BASE_URL + "/public/v2/users?name={name}&gender={gender}";
    public static String GET_USER_DETAILS_INVALID_PARAM = Constants.BASE_URL + "/public/v2/users?invalid_param={invalid_param}";
    public static String GET_USER_DETAILS_WITH_EMAIL = Constants.BASE_URL + "/public/v2/users?email={email}";
    public static String UPDATE_USER_WITHOUT_ID = Constants.BASE_URL + "/public/v2/users";
    public static String UPDATE_USER_WITH_ID = Constants.BASE_URL + "/public/v2/users/{id}";
    public static String UPDATE_USER_INVALID_PATH_WITH_ID = Constants.BASE_URL + "/publiccc/v2/users/{id}";
    public static String DELETE_USER_INVALID_PATH = Constants.BASE_URL + "/publiccc/v2/users/{id}";
    public static String DELETE_USER_WITH_ID = Constants.BASE_URL + "/public/v2/users/{id}";

    @Step ("Create new user")
    public void createNewUser (File json) {
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Get user details with id")
    public void getUserDetailsWithId (int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get user details with invalid id")
    public void getUserDetailsWithInvalidId (String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get user details with valid name and gender param")
    public void getUserDetailsNameGender (String name, String gender) {
        SerenityRest.given()
                .pathParam("name", name)
                .pathParam("gender", gender);
    }

    @Step("Get user details with invalid param")
    public void getUserDetailsWithInvalidParam (String invalid_param) {
        SerenityRest.given()
                .pathParam("invalid_param", invalid_param);
    }

    @Step("Get user details with valid id")
    public void getUserDetailsWithEmailParam (int id) {
        SerenityRest.given()
                .pathParam("id", id );
    }

    @Step ("Update user without id")
    public void updateUserWithoutId (File json) {
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN)
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Update user")
    public void updateUser (int id, File json){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Update user invalid path")
    public void updateUserInvalidPath (int id){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN)
                .pathParam("id", id);
    }

    @Step("Delete user with id")
    public void deleteUserWithId (int id) {
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN)
                .pathParam("id", id);
    }

    @Step("Delete user with invalid path")
    public void deleteUserInvalidPath (int id) {
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN)
                .pathParam("id", id);
    }

}
