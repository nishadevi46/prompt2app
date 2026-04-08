package com.nisha.projects.prompt2app.entity;

import com.nisha.projects.prompt2app.enums.SubscriptionStatus;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription {
  Long id;
  User user;
  Plan plan;
  SubscriptionStatus status;
  String stripeSubscriptionId;
  Instant currentPeriodStart;
  Instant currentPeriodEnd;
  Boolean cancelAtPeriodEnd = false;
  Instant createdAt;
  Instant updatedAt;
}
