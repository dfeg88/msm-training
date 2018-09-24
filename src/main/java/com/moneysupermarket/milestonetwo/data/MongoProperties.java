package com.moneysupermarket.milestonetwo.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Wither;

@Getter
@Setter
@Builder
public class MongoProperties {
private String dataBase;
private String collection;
}
