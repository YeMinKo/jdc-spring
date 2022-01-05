package com.example.prepostauthorizationdemo.repository;

import com.example.prepostauthorizationdemo.model.Document;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DocumentRepository{
    private Map<String, Document> documents =
            Map.of(
                    "abc123", new Document("john"),
                    "qwe123", new Document("john"),
                    "asd555", new Document("emma"),
                    "ads555", new Document("natalie")
            );

    public Document findDocument(String code) {
        return documents.get(code);
    }

}
