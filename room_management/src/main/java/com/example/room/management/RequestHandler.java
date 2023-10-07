package com.example.room.management;

public interface RequestHandler<T> {
    void handleRequest(T request);
}
