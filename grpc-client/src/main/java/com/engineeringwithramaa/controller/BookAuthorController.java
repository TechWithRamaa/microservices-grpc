package com.engineeringwithramaa.controller;

import com.engineeringwithramaa.service.BookAuthorClientService;
import com.google.protobuf.Descriptors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.security.krb5.internal.crypto.Des;

import java.util.List;
import java.util.Map;

@RestController
public class BookAuthorController {
    BookAuthorClientService bookAuthorClientService;

    public BookAuthorController(BookAuthorClientService bookAuthorClientService) {
        this.bookAuthorClientService = bookAuthorClientService;
    }

    @GetMapping("/author/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable String id) {
        return bookAuthorClientService.getAuthor(Integer.parseInt(id));
    }

    @GetMapping("book/{id}")
    public List<Map<Descriptors.FieldDescriptor, Object>> getBooksByAuthor(@PathVariable String id) throws InterruptedException {
        return bookAuthorClientService.getBooksByAuthor(Integer.parseInt(id));
    }

    @GetMapping("/book")
    public Map<String, Map<Descriptors.FieldDescriptor, Object>> getExpensiveBook() throws InterruptedException {
        return bookAuthorClientService.getExpensiveBook();
    }

    @GetMapping("book/author/{gender}")
    public List<Map<Descriptors.FieldDescriptor, Object>> getBooksByAuthorGender(@PathVariable String gender) throws InterruptedException {
        return bookAuthorClientService.getBooksByAuthorGender(gender);
    }
}
