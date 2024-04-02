package com.rahul.publicApi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry {

        @JsonProperty("API")
        private String api;

        @JsonProperty("Description")
        private String description;

        @JsonProperty("Auth")
        private String auth;

        @JsonProperty("HTTPS")
        private Boolean https;

        @JsonProperty("Cors")
        private String cors;

        @JsonProperty("Link")
        private String link;

        @JsonProperty("Category")
        private String category;

}
