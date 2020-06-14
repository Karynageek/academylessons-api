package org.academy.api.tests;

import org.academy.TestConfigurations;
import org.academy.api.requests.ProjectRequests;
import org.testng.annotations.Test;

public class CreateAndDeleteProjectTests {
    private ProjectRequests projectRequests = new ProjectRequests();

    @Test
    public void createProject() {
        projectRequests.createProject(TestConfigurations.getApiToken(), 201);
    }

    @Test
    public void deleteProject() {
        projectRequests.deleteProject(TestConfigurations.getApiToken(), 204);
    }
}