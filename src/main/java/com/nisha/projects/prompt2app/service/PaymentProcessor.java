package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.subscription.CheckoutRequest;
import com.nisha.projects.prompt2app.dto.subscription.CheckoutResponse;
import com.nisha.projects.prompt2app.dto.subscription.PortalResponse;
import com.stripe.model.StripeObject;
import java.util.Map;

public interface PaymentProcessor {
  CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

  PortalResponse openCustomerResponse(Long userId);

  void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);
}
