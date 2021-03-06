package com.moneysupermarket.milestonetwo.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MongoProperties {
    private String database;
    private String collection;
}
