package table.Branch.PicoBranchDetails.Service;



import table.Branch.PicoBranchDetails.Model.PicoBranchDetails;
import table.Branch.PicoBranchDetails.Response.PicoBranchDetailsResponse;

import java.util.Map;
import java.util.Optional;

public interface PicoBranchDetailsService {

    Optional<PicoBranchDetails> findById(String id) throws Exception;

    PicoBranchDetails save(PicoBranchDetails picoBranchDetails) throws Exception;

    PicoBranchDetailsResponse savePicoBranchDetails(PicoBranchDetails picoBranchDetails) throws Exception;

    PicoBranchDetailsResponse moveToTrash(Map<String,String> formData) throws Exception;

    PicoBranchDetailsResponse get(Map<String,String> formData) throws Exception;

    PicoBranchDetailsResponse getAll() throws Exception;

    PicoBranchDetailsResponse getDeleted() throws Exception;

    PicoBranchDetailsResponse getPaginated(Map<String,String> formData) throws Exception;

    PicoBranchDetailsResponse searchPaginated(Map<String,String> formData) throws Exception;

    PicoBranchDetailsResponse searchPaginatedThroughRepository(Map<String,String> formData) throws Exception;



}

