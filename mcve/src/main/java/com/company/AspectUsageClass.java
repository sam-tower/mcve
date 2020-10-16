package com.company;

import rx.Single;

import java.util.concurrent.TimeUnit;

public class AspectUsageClass {

    @MyLogger(name = "name")
    public Single<Response> addEvent(Request request) {

        return Single.just(request)
                .delay(1, TimeUnit.SECONDS)
                .flatMap(req -> Single.just(new Response(req.someRequest)));
    }
}

class Response {

    String someResponse;

    public Response(String someResponse) {
        this.someResponse = someResponse;
    }

    @Override
    public String toString() {
        return "Response{" +
                "someResponse='" + someResponse + '\'' +
                '}';
    }
}

class Request {

    String someRequest;

    public Request(String someRequest) {
        this.someRequest = someRequest;
    }
}