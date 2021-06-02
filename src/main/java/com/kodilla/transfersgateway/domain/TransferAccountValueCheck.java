package com.kodilla.transfersgateway.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferAccountValueCheck {

  private String nrb;
  private BigDecimal availableFunds;

}

