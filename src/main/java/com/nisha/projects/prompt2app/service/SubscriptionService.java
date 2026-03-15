package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.subscription.CheckoutRequest;
import com.nisha.projects.prompt2app.dto.subscription.CheckoutResponse;
import com.nisha.projects.prompt2app.dto.subscription.PortalResponse;
import com.nisha.projects.prompt2app.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
  SubscriptionResponse getCurrentSubscription(Long userId);

  CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

  PortalResponse openCustomerResponse(Long userId);
}
