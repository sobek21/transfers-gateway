package com.kodilla.transfersgateway.connect;

import com.kodilla.transfersgateway.domain.TransferAccountValueCheck;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "accounts", fallback = AccountsConnector.AccountsConnectorFallback.class)
public interface AccountsConnector {

  @GetMapping("/v1/accounts")
  TransferAccountValueCheck getAccounts(@RequestParam("customerId") Long customerId);

  @Slf4j
  @Component
  class AccountsConnectorFallback implements AccountsConnector {
    @Override
    public TransferAccountValueCheck getAccounts(Long customerId) {
      log.warn("Can not get account details for customerId: {}", customerId);
      return new TransferAccountValueCheck("error", BigDecimal.ZERO);
    }
  }
}
