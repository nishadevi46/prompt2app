package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
  SubscriptionResponse getCurrentSubscription(Long userId);
}
