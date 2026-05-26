package workforce_management.dto;

import lombok.Data;

@Data
public class ClockInRequest {

    private Long workerId;
    private Long siteId;
}