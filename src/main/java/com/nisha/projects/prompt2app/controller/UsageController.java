package com.nisha.projects.prompt2app.controller;

import com.nisha.projects.prompt2app.dto.subscription.PlanLimitsResponse;
import com.nisha.projects.prompt2app.dto.subscription.UsageTodayResponse;
import com.nisha.projects.prompt2app.service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usage")
public class UsageController {

    private final UsageService usageService;

    @GetMapping("/today")
    public ResponseEntity<UsageTodayResponse> getTodayUsage() {
        Long userId = 1L;
//        return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId));
        return null;
    }

}