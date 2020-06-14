package org.academy.api.requests;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.academy.api.Resources;

@Slf4j
public class ProjectRequests extends AbstractRequests {

    public void createProject(String token, int responseCode) {
        Response response = getRequests.withTokenAndBody(token, responseCode, Resources.getProjectRequests());
        log.info(response.asString());
    }

    public void deleteProject(String token, int responseCode) {
        Response response = getRequests.withToken(token, responseCode, Resources.getIdProjectRequests());
        log.info(response.asString());
    }
}
