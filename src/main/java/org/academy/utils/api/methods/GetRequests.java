package org.academy.utils.api.methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import lombok.extern.slf4j.Slf4j;
import org.academy.TestConfigurations;
import org.academy.utils.api.waiters.ApiWaiter;
import org.academy.utils.api.waiters.ValidateResponseWaiter;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class GetRequests {
    private ApiWaiter apiWaiter = new ApiWaiter();
    private String id;

    public Response withTokenAndBody(String token, int responseCode, String resources) {
        File file = new File("src/main/resources/createProject.json");
        ValidateResponseWaiter responseWaiter = () -> {
            RestAssured.baseURI = TestConfigurations.getApiUri();
            return given()
                    .relaxedHTTPSValidation()
                    .auth().oauth2(token)
                    .contentType(ContentType.JSON)
                    .header("Accept", "application/vnd.github.inertia-preview+json")
                    .body(file)
                    .when()
                    .post(resources)
                    .then();
        };
        ValidatableResponse validatableResponse = apiWaiter.waitForResponse(responseWaiter, responseCode);
        Response resp = validatableResponse.contentType(ContentType.JSON).extract().response();
        log.info("Response returned - {}", resp.asString());
        assertThat(resp.getStatusCode()).as("Response error occurred - {}", resp.getStatusLine())
                .isEqualTo(responseCode);
        log.info("{} return successfully ", resp.getStatusCode());

        JsonPath jsonPath = resp.jsonPath();
        id = jsonPath.getString("id");
        log.info("Project id: {}", id);

        return resp;
    }

    public Response withToken(String token, int responseCode, String resources) {
            RestAssured.baseURI = TestConfigurations.getApiUriMain();
            Response response = RestAssured.given()
                    .relaxedHTTPSValidation()
                    .auth().oauth2(token)
                    .contentType(ContentType.JSON)
                    .header("Accept", "application/vnd.github.inertia-preview+json")
                    .when()
                    .delete(resources + id);

        log.info("Response returned - {}", response.asString());
        assertThat(response.getStatusCode()).as("Response error occurred - {}", response.getStatusLine())
                .isEqualTo(responseCode);
        log.info("{} return successfully ", response.getStatusCode());
        return response;
    }
}
