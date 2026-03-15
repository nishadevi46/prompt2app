package com.nisha.projects.prompt2app.controller;

import com.nisha.projects.prompt2app.dto.subscription.*;
import com.nisha.projects.prompt2app.service.PlanService;
import com.nisha.projects.prompt2app.service.SubscriptionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BillingController {
  private final PlanService planService;
  private final SubscriptionService subscriptionService;

  @GetMapping("/api/plans")
  public ResponseEntity<List<PlanResponse>> getAllPlans() {
    return ResponseEntity.ok(planService.getAllActivePlans());
  }

  @GetMapping("/api/me/subscription")
  public ResponseEntity<SubscriptionResponse> getMySubscription() {
    Long userId = 1L;
    return ResponseEntity.ok(subscriptionService.getCurrentSubscription(userId));
  }

  @PostMapping("/api/stripe/checkout")
  public ResponseEntity<CheckoutResponse> createCheckoutResponse(
      @RequestBody CheckoutRequest request) {
    Long userId = 1L;
    return ResponseEntity.ok(subscriptionService.createCheckoutSessionUrl(request, userId));
  }

  @PostMapping("/api/stripe/portal")
  public ResponseEntity<PortalResponse> openCustomerResponse() {
    Long userId = 1L;
    return ResponseEntity.ok(subscriptionService.openCustomerResponse(userId));
  }
}
