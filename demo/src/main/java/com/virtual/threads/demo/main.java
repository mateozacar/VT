package com.virtual.threads.demo;

import com.virtual.threads.demo.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class main  {

    public static List<User> createUsers() {
        // Create a list to hold User objects
        List<User> userList = new ArrayList<>();

        // Add User objects to the list
        userList.add(new User("Alice Johnson", "alice@example.com"));
        userList.add(new User("Bob Smith", "bob@example.com"));
        userList.add(new User("Charlie Brown", "charlie@example.com"));
        userList.add(new User("David Wilson", "david@example.com"));
        userList.add(new User("Eva Black", "eva@example.com"));
        userList.add(new User("Frankie Blue", "frankie@example.com"));
        userList.add(new User("Grace Hopper", "grace@example.com"));
        userList.add(new User("Hannah White", "hannah@example.com"));
        userList.add(new User("Ivy Green", "ivy@example.com"));
        userList.add(new User("Jack Gray", "jack@example.com"));

        return userList;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<User> users = createUsers();

        List<CompletableFuture<String>> futures = users.stream()
                .map(user -> CompletableFuture.supplyAsync(() -> {
                     if(user.getName().startsWith("A")){
                         return user.getName();
                     }else {
                         return "";
                     }
                })).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> {
                    return futures.stream()
                            .map(CompletableFuture::join)
                            .filter(user -> !user.isEmpty())
                            .toList();
                })
                .get().forEach(System.out::println);

    }
}
