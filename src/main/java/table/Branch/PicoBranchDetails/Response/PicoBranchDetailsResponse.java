package table.Branch.PicoBranchDetails.Response;


import lombok.Data;
import table.Branch.PicoBranchDetails.DTO.PicoBranchDetailsDTO;

import java.util.List;

@Data
public class PicoBranchDetailsResponse {

    private PicoBranchDetailsDTO picoBranchDetailsDTO;

    private List<PicoBranchDetailsDTO> data;

    private long totalPages;

    private long recordsTotal;

    private long currentRecords;

    private long recordsFiltered;

    private boolean success;

    private String error;
}

