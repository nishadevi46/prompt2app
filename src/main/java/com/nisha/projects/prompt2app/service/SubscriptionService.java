package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.subscription.SubscriptionResponse;
import com.nisha.projects.prompt2app.enums.SubscriptionStatus;
import java.time.Instant;

public interface SubscriptionService {
  SubscriptionResponse getCurrentSubscription();

  void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId);

  void updateSubscription(
      String gatewaySubscriptionId,
      SubscriptionStatus status,
      Instant periodStart,
      Instant periodEnd,
      Boolean cancelAtPeriodEnd,
      Long planId);

  void cancelSubscription(String gatewaySubscriptionId);

  void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd);

  void markSubscriptionPastDue(String subId);
}
