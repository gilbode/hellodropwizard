package com.wercker.example.hellodropwizard.resources;

import com.wercker.example.hellodropwizard.api.AppVersion;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/version")
@Produces(MediaType.APPLICATION_JSON)
public class AppVersionResource {

    @GET
    public AppVersion getVersion() {
        return new AppVersion();
    }
}
