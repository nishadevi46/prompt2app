package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.subscription.PlanLimitsResponse;
import com.nisha.projects.prompt2app.dto.subscription.UsageTodayResponse;
import com.nisha.projects.prompt2app.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
  @Override
  public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
    return null;
  }

  @Override
  public UsageTodayResponse getTodayUsageOfUser(Long userId) {
    return null;
  }
}
