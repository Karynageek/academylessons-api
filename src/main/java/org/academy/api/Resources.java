package org.academy.api;

import org.academy.PropertyReader;

public class Resources {
    private static String read(String value) {
        return PropertyReader.get().readValue(value);
    }

    public static String getPullRequests() {
        return read("pull_requests");
    }

    public static String getProjectRequests() {
        return read("project_requests");
    }

    public static String getIdProjectRequests() {
        return read("id_requests");
    }
}
