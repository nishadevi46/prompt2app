package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.subscription.PlanResponse;
import com.nisha.projects.prompt2app.service.PlanService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {
  @Override
  public List<PlanResponse> getAllActivePlans() {
    return List.of();
  }
}
