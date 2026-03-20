package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.subscription.CheckoutRequest;
import com.nisha.projects.prompt2app.dto.subscription.CheckoutResponse;
import com.nisha.projects.prompt2app.dto.subscription.PortalResponse;
import com.nisha.projects.prompt2app.dto.subscription.SubscriptionResponse;
import com.nisha.projects.prompt2app.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
  @Override
  public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
    return null;
  }

  @Override
  public SubscriptionResponse getCurrentSubscription(Long userId) {
    return null;
  }

  @Override
  public PortalResponse openCustomerResponse(Long userId) {
    return null;
  }
}
